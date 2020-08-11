package co.kesti.smartcity.api.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.kesti.smartcity.api.community.vo.CmntNotiReqVo;
import co.kesti.smartcity.api.community.vo.CmntNotiVo;

/**
 * 커뮤니티 > 공지사항 맵퍼
 * @author atom
 * @since 2020.07.23
 */
@Mapper
public interface CommunityNoticeMapper {

    /**
     * 공지사항 정보 조회
     */
    public CmntNotiVo selectNotiInfo(@Param("noticeSeq") Long noticeSeq);

    /**
     * 공지사항 이전 정보 조회
     */
    public CmntNotiVo selectNotiPrevInfo(@Param("noticeSeq") Long noticeSeq, @Param("noticeTag") boolean noticeTag);

    /**
     * 공지사항 다음 정보 조회
     */
    public CmntNotiVo selectNotiNextInfo(@Param("noticeSeq") Long noticeSeq, @Param("noticeTag") boolean noticeTag);

    /**
     * 공지사항 건수 조회
     */
    public int selectNotiCount(CmntNotiReqVo param);

    /**
     * 공지사항 목록 조회
     */
    public List<CmntNotiVo> selectNotiList(CmntNotiReqVo param);

    /**
     * 메인 공지사항 목록 조회
     */
    public List<CmntNotiVo> selectMainNotiList();

    /**
     * 공지사항 조회수 더하기 수정
     */
    public int updateNotiHitCntPlus(CmntNotiVo param);

    /**
     * 공지사항 추천수 더하기 수정
     */
    public int updateNotiRcmdCntPlus(CmntNotiVo param);

    /**
     * 공지사항 추천 중복 건수 조회
     */
    public int selectNotiRcmdDupCount(CmntNotiVo param);

    /**
     * 공지사항 추천 등록
     */
    public int insertNotiRcmd(CmntNotiVo param);

}
