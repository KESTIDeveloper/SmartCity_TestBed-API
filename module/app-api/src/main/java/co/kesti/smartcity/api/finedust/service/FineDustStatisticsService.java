package co.kesti.smartcity.api.finedust.service;

import java.util.List;

import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscReqVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatReqVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatVo;


/**
 * 미세먼지 > 통계 서비스
 * @author atom
 * @since 2020.07.26
 */
public interface FineDustStatisticsService {

    /**
     * 디바이스 측정 통계 목록 조회
     * @param param
     * @return
     */
    public List<FineDustDevObsStscVo> selectDevObsStscList(FineDustDevObsStscReqVo param);

    /**
     * 디바이스 상태 정보 조회
     * @param param
     * @return
     */
    public FineDustDevStatVo selectDevStatInfo(FineDustDevStatReqVo param);

}
