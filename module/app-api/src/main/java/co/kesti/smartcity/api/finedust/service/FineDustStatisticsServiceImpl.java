package co.kesti.smartcity.api.finedust.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kesti.smartcity.api.finedust.mapper.FineDustStatisticsMapper;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscReqVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevVo;

/**
 * 미세먼지 > 측정값 통계 서비스 구현
 * @author atom
 * @since 2020.07.26
 */
@Service
public class FineDustStatisticsServiceImpl implements FineDustStatisticsService {

    @Autowired
    private FineDustStatisticsMapper fineDustStatisticsMapper;

    /**
     * 테스트 디바이스 목록 조회
     */
    @Override
    public List<FineDustDevVo> selectTestDevList(Long mbrSeq) {
        return fineDustStatisticsMapper.selectTestDevList(mbrSeq);
    }

    /**
     * 비교 디바이스 목록 조회
     */
    @Override
    public List<FineDustDevVo> selectCmprDevList(String devId) {
        return fineDustStatisticsMapper.selectCmprDevList(devId);
    }

    /**
     * 디바이스 측정 목록 조회
     */
    @Override
    public List<FineDustDevObsVo> selectDevObsList(String devId) {
        return fineDustStatisticsMapper.selectDevObsList(devId);
    }

    /**
     * 디바이스 측정 통계 목록 조회
     */
    @Override
    public List<FineDustDevObsStscVo> selectDevObsStscList(FineDustDevObsStscReqVo param) {
        return fineDustStatisticsMapper.selectDevObsStscList(param);
    }

}
