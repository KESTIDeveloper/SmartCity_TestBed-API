package co.kesti.smartcity.api.finedust.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscReqVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevVo;

/**
 * 미세먼저 > 측정값 통계 맵퍼
 * @author atom
 * @since 2020.07.26
 */
@Mapper
public interface FineDustStatisticsMapper {

    /**
     * 테스트 디바이스 목록 조회
     */
    public List<FineDustDevVo> selectTestDevList(@Param("mbrSeq") Long mbrSeq);

    /**
     * 비교 디바이스 목록 조회
     */
    public List<FineDustDevVo> selectCmprDevList(@Param("devId") String devId);

    /**
     * 디바이스 측정 목록 조회
     */
    public List<FineDustDevObsVo> selectDevObsList(@Param("devId") String devId);

    /**
     * 디바이스 측정 통계 목록 조회
     */
    public List<FineDustDevObsStscVo> selectDevObsStscList(FineDustDevObsStscReqVo param);

}
