package co.kesti.smartcity.api.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.kesti.smartcity.api.community.vo.CmntUpldReqVo;
import co.kesti.smartcity.api.community.vo.CmntUpldVo;

/**
 * 커뮤니티 > 자료실 맵퍼
 * @author atom
 * @since 2020.07.25
 */
@Mapper
public interface CommunityUploadMapper {

    /**
     * 자료실 정보 조회
     */
    public CmntUpldVo selectUpldInfo(@Param("uploadSeq") Long uploadSeq);

    /**
     * 자료실 이전 정보 조회
     */
    public CmntUpldVo selectUpldPrevInfo(@Param("uploadSeq") Long uploadSeq);

    /**
     * 자료실 다음 정보 조회
     */
    public CmntUpldVo selectUpldNextInfo(@Param("uploadSeq") Long uploadSeq);

    /**
     * 자료실 건수 조회
     */
    public int selectUpldCount(CmntUpldReqVo param);

    /**
     * 자료실 목록 조회
     */
    public List<CmntUpldVo> selectUpldList(CmntUpldReqVo param);

    /**
     * 자료실 조회수 더하기 수정
     */
    public int updateUpldHitCntPlus(CmntUpldVo param);

    /**
     * 자료실 추천수 더하기 수정
     */
    public int updateUpldRcmdCntPlus(CmntUpldVo param);

    /**
     * 자료실 추천 중복 건수 조회
     */
    public int selectUpldRcmdDupCount(CmntUpldVo param);

    /**
     * 자료실 추천 등록
     */
    public int insertUpldRcmd(CmntUpldVo param);

}
