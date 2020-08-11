package co.kesti.smartcity.api.community.service;

import java.util.List;

import co.kesti.smartcity.api.community.vo.CmntNotiReqVo;
import co.kesti.smartcity.api.community.vo.CmntNotiVo;

/**
 * 커뮤니티 > 공지사항 서비스
 * @author atom
 * @since 2020.07.23
 */
public interface CommunityNoticeService {

    /**
     * 공지사항 목록 조회
     * @param param
     * @return
     */
    public List<CmntNotiVo> selectNotiList(CmntNotiReqVo param);

    /**
     * 메인 공지사항 목록 조회
     * @return
     */
    public List<CmntNotiVo> selectMainNotiList();

    /**
     * 공지사항 읽기 정보 조회
     * @param param
     * @return
     */
    public CmntNotiVo selectNotiReadInfo(CmntNotiVo param);

    /**
     * 공지사항 추천 처리
     * @param param
     */
    public void procNotiRcmd(CmntNotiVo param);

}
