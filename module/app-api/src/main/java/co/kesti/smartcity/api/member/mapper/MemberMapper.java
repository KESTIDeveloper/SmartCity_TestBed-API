package co.kesti.smartcity.api.member.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.kesti.smartcity.api.member.vo.ComMbrVo;

/**
 * 회원 맵퍼
 * @author atom
 * @since 2020.07.16
 */
@Mapper
public interface MemberMapper {

    /**
     * 회원 정보 조회
     */
    public ComMbrVo selectMbrInfo(@Param("mbrId") String mbrId);

    /**
     * 회원 중복 건수 조회
     */
    public int selectMbrDupCount(@Param("mbrId") String mbrId);

    /**
     * 회원 등록
     */
    public int insertMbr(ComMbrVo param);

    /**
     * 회원 수정
     */
    public int updateMbr(ComMbrVo param);

    /**
     * 로그인 실패 건수 더하기 수정
     */
    public int updateLognFailCntPlus(@Param("mbrId") String mbrId);

    /**
     * 로그인 실패 건수 초기화 수정
     */
    public int updateLognFailCntReset(@Param("mbrId") String mbrId);

    /**
     * 회원 삭제
     */
    public int deleteMbr(@Param("mbrId") String mbrId);

}
