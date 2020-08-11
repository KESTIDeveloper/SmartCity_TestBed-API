package co.kesti.smartcity.api.community.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.kesti.smartcity.api.community.mapper.CommunityForumMapper;
import co.kesti.smartcity.api.community.vo.CmntFrumCmtVo;
import co.kesti.smartcity.api.community.vo.CmntFrumGrpVo;
import co.kesti.smartcity.api.community.vo.CmntFrumIntrVo;
import co.kesti.smartcity.api.community.vo.CmntFrumReqVo;
import co.kesti.smartcity.api.community.vo.CmntFrumVo;
import co.kesti.smartcity.error.UserException;

/**
 * 커뮤니티 > 포럼 서비스 구현
 * @author atom
 * @since 2020.07.20
 */
@Service
public class CommunityForumServiceImpl implements CommunityForumService {

    @Autowired
    private CommunityForumMapper communityForumMapper;

    /**
     * 포럼 소개 정보 조회
     */
    @Override
    public CmntFrumIntrVo selectFrumIntrInfo() {
        // 포럼 그룹 목록 조회
        List<CmntFrumGrpVo> frumGrpList = communityForumMapper.selectFrumGrpList();

        // 포럼 추천 목록 조회
        List<CmntFrumVo> frumRcmdList = communityForumMapper.selectFrumNotiList("recmd_cnt");

        // 포럼 인기 목록 조회
        List<CmntFrumVo> frumHitList = communityForumMapper.selectFrumNotiList("hit_cnt");

        // 결과값 설정
        CmntFrumIntrVo resultVo = new CmntFrumIntrVo();
        resultVo.setFrumGrpList(frumGrpList);
        resultVo.setFrumRcmdList(frumRcmdList);
        resultVo.setFrumHitList(frumHitList);

        return resultVo;
    }

    /**
     * 포럼 그룹 정보 조회
     */
    @Override
    public CmntFrumGrpVo selectFrumGrpInfo(Long forumGroupSeq) {
        CmntFrumGrpVo frumGrpInfo = communityForumMapper.selectFrumGrpInfo(forumGroupSeq);

        if (frumGrpInfo == null) {
            throw new UserException("포럼정보가 존재하지 않습니다.");
        }

        return frumGrpInfo;
    }

    /**
     * 포럼 그룹 정보 조회
     */
    @Override
    public List<CmntFrumGrpVo> selectFrumGrpList() {
        return communityForumMapper.selectFrumGrpList();
    }

    /**
     * 포럼 목록 조회
     */
    @Override
    public List<CmntFrumVo> selectFrumList(CmntFrumReqVo param) {
        // 포럼 건수 조회
        int frumCnt = communityForumMapper.selectFrumCount(param);
        param.setTotCnt(frumCnt);

        // 포럼 목록 조회
        List<CmntFrumVo> frumList = new ArrayList<>();

        if (frumCnt > 0) {
            frumList = communityForumMapper.selectFrumList(param);
        }

        return frumList;
    }

    /**
     * 포럼 읽기 정보 조회
     */
    @Override
    public CmntFrumVo selectFrumReadInfo(CmntFrumVo param) {
        // 포럼 정보 조회
        CmntFrumVo frumInfo = communityForumMapper.selectFrumInfo(param.getForumGroupSeq(), param.getForumSeq(), param.getMbrId());

        if (frumInfo == null) {
            throw new UserException("포럼정보가 존재하지 않습니다.");
        }

        // 조회수 더하기
        if (!frumInfo.getSelfYn()) {
            communityForumMapper.updateFrumHitCntPlus(param);
        }

        return frumInfo;
    }

    /**
     * 포럼 수정 정보 조회
     */
    @Override
    public CmntFrumVo selectFrumUptInfo(CmntFrumVo param) {
        // 포럼 정보 조회
        CmntFrumVo frumInfo = communityForumMapper.selectFrumInfo(param.getForumGroupSeq(), param.getForumSeq(), param.getMbrId());

        if (frumInfo == null) {
            throw new UserException("포럼정보가 존재하지 않습니다.");
        }

        if (!frumInfo.getSelfYn() && !param.getAdmYn()) {
            throw new UserException("본인글만 수정할 수 있습니다.");
        }

        return frumInfo;
    }

    /**
     * 포럼 저장
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveFrum(CmntFrumVo param) {
        // 회원 유효성 체크
        this.isValidMbr(param.getMbrId());

        // 포럼 정보 조회
        CmntFrumVo frumInfo = communityForumMapper.selectFrumInfo(param.getForumGroupSeq(), param.getForumSeq(), param.getMbrId());

        // 등록
        if (frumInfo == null) {
            // 포럼 등록
            communityForumMapper.insertFrum(param);

        // 수정
        } else {
            // 회원 체크
            if (!frumInfo.getSelfYn() && !param.getAdmYn()) {
                throw new UserException("본인글만 수정할 수 있습니다.");
            }

            // 포럼 수정
            communityForumMapper.updateFrum(param);
        }
    }

    /**
     * 포럼 삭제
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteFrum(CmntFrumVo param) {
        // 회원 유효성 체크
        this.isValidMbr(param.getMbrId());

        // 포럼 정보 조회
        CmntFrumVo frumInfo = communityForumMapper.selectFrumInfo(param.getForumGroupSeq(), param.getForumSeq(), param.getMbrId());

        if (frumInfo == null) {
            throw new UserException("포럼정보가 존재하지 않습니다.");
        }

        // 회원 체크
        if (!frumInfo.getSelfYn() && !param.getAdmYn()) {
            throw new UserException("본인글만 삭제할 수 있습니다.");
        }

        // 포럼 삭제
        communityForumMapper.deleteFrum(param);
    }

    /**
     * 포럼 추천 처리
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void procFrumRcmd(CmntFrumVo param) {
        // 회원 유효성 체크
        this.isValidMbr(param.getMbrId());

        // 포럼 정보 조회
        CmntFrumVo frumInfo = communityForumMapper.selectFrumInfo(param.getForumGroupSeq(), param.getForumSeq(), param.getMbrId());

        if (frumInfo == null) {
            throw new UserException("포럼정보가 존재하지 않습니다.");
        }

        // 회원 체크
        if (frumInfo.getSelfYn()) {
            throw new UserException("본인글은 추천할 수 없습니다.");
        }

        // 포럼 중복 건수 조회
        int frumRcmdDupCnt = communityForumMapper.selectFrumRcmdDupCount(param);

        if (frumRcmdDupCnt > 0) {
            throw new UserException("이미 추천한 게시글입니다.");
        }

        // 포럼 추천 등록
        communityForumMapper.insertFrumRcmd(param);

        // 포럼 추천수 더하기 수정
        communityForumMapper.updateFrumRcmdCntPlus(param);
    }

    /**
     * 포럼 코멘트 목록 조회
     */
    @Override
    public List<CmntFrumCmtVo> selectFrumCmtList(Long forumGroupSeq, Long forumSeq, String mbrId) {
        return communityForumMapper.selectFrumCmtList(forumGroupSeq, forumSeq, mbrId);
    }

    /**
     * 포럼 코멘트 등록
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertFrumCmt(CmntFrumCmtVo param) {
        // 회원 유효성 체크
        this.isValidMbr(param.getMbrId());

        // 포럼 정보 조회
        CmntFrumVo frumInfo = communityForumMapper.selectFrumInfo(param.getForumGroupSeq(), param.getForumSeq(), param.getMbrId());

        if (frumInfo == null) {
            throw new UserException("포럼정보가 존재하지 않습니다.");
        }

        // 포럼 코멘트 등록
        communityForumMapper.insertFrumCmt(param);
    }

    /**
     * 포럼 코멘트 수정
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateFrumCmt(CmntFrumCmtVo param) {
        communityForumMapper.updateFrumCmt(param);
    }

    /**
     * 포럼 코멘트 삭제
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteFrumCmt(CmntFrumCmtVo param) {
        communityForumMapper.deleteFrumCmt(param);
    }

    /**
     * 회원 유효성 체크
     */
    private void isValidMbr(String mbrId) {
        if (StringUtils.isBlank(mbrId)) {
            throw new UserException("회원 아이디는 필수 항목입니다.");
        }
    }

}
