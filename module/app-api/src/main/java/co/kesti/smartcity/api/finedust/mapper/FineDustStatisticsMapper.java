package co.kesti.smartcity.api.finedust.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscReqVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatEvtLogVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatEvtObsVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatEvtVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatReqVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatTotVo;

/**
 * 미세먼저 > 통계 맵퍼
 * @author atom
 * @since 2020.07.26
 */
@Mapper
public interface FineDustStatisticsMapper {

    /**
     * 디바이스 측정 통계 목록 조회
     */
    public List<FineDustDevObsStscVo> selectDevObsStscList(FineDustDevObsStscReqVo param);

    /**
     * 디바이스 상태 합계 정보 조회
     */
    public FineDustDevStatTotVo selectDevStatTotInfo(FineDustDevStatReqVo param);

    /**
     * 디바이스 상태 이벤트 정보 조회
     */
    public FineDustDevStatEvtVo selectDevStatEvtInfo(FineDustDevStatReqVo param);

    /**
     * 디바이스 상태 이벤트 측정 목록 조회
     */
    public List<FineDustDevStatEvtObsVo> selectDevStatEvtObsList(FineDustDevStatReqVo param);

    /**
     * 디바이스 상태 이벤트 로그 건수 조회
     */
    public int selectDevStatEvtLogCount(FineDustDevStatReqVo param);

    /**
     * 디바이스 상태 이벤트 로그 목록 조회
     */
    public List<FineDustDevStatEvtLogVo> selectDevStatEvtLogList(FineDustDevStatReqVo param);

}
