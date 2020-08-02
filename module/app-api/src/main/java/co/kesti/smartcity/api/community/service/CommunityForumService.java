package co.kesti.smartcity.api.community.service;

import java.util.List;

import co.kesti.smartcity.api.community.vo.CmntFrumCmtVo;
import co.kesti.smartcity.api.community.vo.CmntFrumGrpVo;
import co.kesti.smartcity.api.community.vo.CmntFrumIntrVo;
import co.kesti.smartcity.api.community.vo.CmntFrumReqVo;
import co.kesti.smartcity.api.community.vo.CmntFrumVo;

/**
 * 커뮤니티 > 포럼 서비스
 * @author atom
 * @since 2020.07.20
 */
public interface CommunityForumService {

    /**
     * 포럼 소개 정보 조회
     * @return
     */
    public CmntFrumIntrVo selectFrumIntrInfo();

    /**
     * 포럼 그룹 정보 조회
     * @param forumGroupSeq
     * @return
     */
    public CmntFrumGrpVo selectFrumGrpInfo(Long forumGroupSeq);

    /**
     * 포럼 목록 조회
     * @param param
     * @return
     */
    public List<CmntFrumVo> selectFrumList(CmntFrumReqVo param);

    /**
     * 포럼 읽기 정보 조회
     * @param param
     * @return
     */
    public CmntFrumVo selectFrumReadInfo(CmntFrumVo param);

    /**
     * 포럼 수정 정보 조회
     * @param param
     * @return
     */
    public CmntFrumVo selectFrumUptInfo(CmntFrumVo param);

    /**
     * 포럼 저장
     * @param param
     */
    public void saveFrum(CmntFrumVo param);

    /**
     * 포럼 삭제
     * @param param
     */
    public void deleteFrum(CmntFrumVo param);

    /**
     * 포럼 추천 처리
     * @param param
     */
    public void procFrumRcmd(CmntFrumVo param);

    /**
     * 포럼 코멘트 목록 조회
     * @param forumGroupSeq
     * @param forumSeq
     * @return
     */
    public List<CmntFrumCmtVo> selectFrumCmtList(Long forumGroupSeq, Long forumSeq);

    /**
     * 포럼 코멘트 등록
     * @param param
     */
    public void insertFrumCmt(CmntFrumCmtVo param);

}
