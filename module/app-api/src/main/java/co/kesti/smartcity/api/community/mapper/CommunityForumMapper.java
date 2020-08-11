package co.kesti.smartcity.api.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.kesti.smartcity.api.community.vo.CmntFrumCmtVo;
import co.kesti.smartcity.api.community.vo.CmntFrumGrpVo;
import co.kesti.smartcity.api.community.vo.CmntFrumReqVo;
import co.kesti.smartcity.api.community.vo.CmntFrumVo;

/**
 * 커뮤니티 > 포럼 맵퍼
 * @author atom
 * @since 2020.07.20
 */
@Mapper
public interface CommunityForumMapper {

    /**
     * 포럼 그룹 정보 조회
     */
    public CmntFrumGrpVo selectFrumGrpInfo(@Param("forumGroupSeq") Long forumGroupSeq);

    /**
     * 포럼 그룹 목록 조회
     */
    public List<CmntFrumGrpVo> selectFrumGrpList();

    /**
     * 포럼 공지 목록 조회
     */
    public List<CmntFrumVo> selectFrumNotiList(@Param("sortCol") String sortCol);

    /**
     * 포럼 정보 조회
     */
    public CmntFrumVo selectFrumInfo(@Param("forumGroupSeq") Long forumGroupSeq, @Param("forumSeq") Long forumSeq, @Param("mbrId") String mbrId);

    /**
     * 포럼 건수 조회
     */
    public int selectFrumCount(CmntFrumReqVo param);

    /**
     * 포럼 목록 조회
     */
    public List<CmntFrumVo> selectFrumList(CmntFrumReqVo param);

    /**
     * 포럼 등록
     */
    public int insertFrum(CmntFrumVo param);

    /**
     * 포럼 수정
     */
    public int updateFrum(CmntFrumVo param);

    /**
     * 포럼 삭제
     */
    public int deleteFrum(CmntFrumVo param);

    /**
     * 포럼 조회수 더하기 수정
     */
    public int updateFrumHitCntPlus(CmntFrumVo param);

    /**
     * 포럼 추천수 더하기 수정
     */
    public int updateFrumRcmdCntPlus(CmntFrumVo param);

    /**
     * 포럼 추천 중복 건수 조회
     */
    public int selectFrumRcmdDupCount(CmntFrumVo param);

    /**
     * 포럼 추천 등록
     */
    public int insertFrumRcmd(CmntFrumVo param);

    /**
     * 포럼 코멘트 목록 조회
     */
    public List<CmntFrumCmtVo> selectFrumCmtList(@Param("forumGroupSeq") Long forumGroupSeq, @Param("forumSeq") Long forumSeq, @Param("mbrId") String mbrId);

    /**
     * 포럼 코멘트 등록
     */
    public int insertFrumCmt(CmntFrumCmtVo param);

    /**
     * 포럼 코멘트 수정
     */
    public int updateFrumCmt(CmntFrumCmtVo param);

    /**
     * 포럼 코멘트 삭제
     */
    public int deleteFrumCmt(CmntFrumCmtVo param);

}
