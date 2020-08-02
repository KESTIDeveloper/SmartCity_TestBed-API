package co.kesti.smartcity.api.finedust.service;

import java.util.List;

import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscReqVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevVo;


/**
 * 미세먼지 > 측정값 통계 서비스
 * @author atom
 * @since 2020.07.26
 */
public interface FineDustStatisticsService {

    /**
     * 테스트 디바이스 목록 조회
     * @param mbrSeq
     * @return
     */
    public List<FineDustDevVo> selectTestDevList(Long mbrSeq);

    /**
     * 비교 디바이스 목록 조회
     * @param devId
     * @return
     */
    public List<FineDustDevVo> selectCmprDevList(String devId);

    /**
     * 디바이스 측정 목록 조회
     * @param devId
     * @return
     */
    public List<FineDustDevObsVo> selectDevObsList(String devId);

    /**
     * 디바이스 측정 통계 목록 조회
     * @param param
     * @return
     */
    public List<FineDustDevObsStscVo> selectDevObsStscList(FineDustDevObsStscReqVo param);

}
