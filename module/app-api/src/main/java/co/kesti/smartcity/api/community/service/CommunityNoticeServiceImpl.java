package co.kesti.smartcity.api.community.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.kesti.smartcity.api.community.mapper.CommunityNoticeMapper;
import co.kesti.smartcity.api.community.vo.CmntNotiReqVo;
import co.kesti.smartcity.api.community.vo.CmntNotiVo;
import co.kesti.smartcity.error.UserException;

/**
 * 커뮤니티 > 공지사항 서비스 구현
 * @author atom
 * @since 2020.07.23
 */
@Service
public class CommunityNoticeServiceImpl implements CommunityNoticeService {

    @Autowired
    private CommunityNoticeMapper communityNoticeMapper;

    /**
     * 공지사항 목록 조회
     */
    @Override
    public List<CmntNotiVo> selectNotiList(CmntNotiReqVo param) {
        // 공지사항 건수 조회
        int notiCnt = communityNoticeMapper.selectNotiCount(param);
        param.setTotCnt(notiCnt);

        // 공지사항 목록 조회
        List<CmntNotiVo> notiList = new ArrayList<>();

        if (notiCnt > 0) {
            notiList = communityNoticeMapper.selectNotiList(param);
        }

        return notiList;
    }

    /**
     * 공지사항 읽기 정보 조회
     */
    @Override
    public CmntNotiVo selectNotiReadInfo(CmntNotiVo param) {
        // 공지사항순번
        Long noticeSeq = param.getNoticeSeq();

        // 공지사항 정보 조회
        CmntNotiVo notiInfo = communityNoticeMapper.selectNotiInfo(noticeSeq);

        if (notiInfo == null) {
            throw new UserException("공지사항정보가 존재하지 않습니다.");
        }

        // 공지사항 이전 정보 조회
        CmntNotiVo prevInfo = communityNoticeMapper.selectNotiPrevInfo(noticeSeq, notiInfo.getNoticeTag());

        if (prevInfo != null) {
            notiInfo.setPrevSeq(prevInfo.getNoticeSeq());
            notiInfo.setPrevTit(prevInfo.getNoticeTitle());
        }

        // 공지사항 다음 정보 조회
        CmntNotiVo nextInfo = communityNoticeMapper.selectNotiNextInfo(noticeSeq, notiInfo.getNoticeTag());

        if (nextInfo != null) {
            notiInfo.setNextSeq(nextInfo.getNoticeSeq());
            notiInfo.setNextTit(nextInfo.getNoticeTitle());
        }

        // 회원아이디
        String mbrId = StringUtils.trimToEmpty(param.getMbrId());

        // 조회수 더하기
        if (StringUtils.isNotEmpty(mbrId) && !mbrId.equals(notiInfo.getCretrId())) {
            communityNoticeMapper.updateNotiHitCntPlus(param);
        }

        return notiInfo;
    }

    /**
     * 공지사항 추천 처리
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void procNotiRcmd(CmntNotiVo param) {
        // 회원 체크
        if (StringUtils.isBlank(param.getMbrId())) {
            throw new UserException("회원 아이디는 필수 항목입니다.");
        }

        // 공지사항 정보 조회
        CmntNotiVo notiInfo = communityNoticeMapper.selectNotiInfo(param.getNoticeSeq());

        if (notiInfo == null) {
            throw new UserException("공지사항정보가 존재하지 않습니다.");
        }

        // 회원 체크
        if (param.getMbrId().equals(notiInfo.getCretrId())) {
            throw new UserException("본인글은 추천할 수 없습니다.");
        }

        // 공지사항 중복 건수 조회
        int notiRcmdDupCnt = communityNoticeMapper.selectNotiRcmdDupCount(param);

        if (notiRcmdDupCnt > 0) {
            throw new UserException("이미 추천한 게시글입니다.");
        }

        // 공지사항 추천 등록
        communityNoticeMapper.insertNotiRcmd(param);

        // 공지사항 추천수 더하기 수정
        communityNoticeMapper.updateNotiRcmdCntPlus(param);
    }

}
