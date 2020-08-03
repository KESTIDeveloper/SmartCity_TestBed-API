package co.kesti.smartcity.api.finedust.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kesti.smartcity.api.finedust.mapper.FineDustStatisticsMapper;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscReqVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatReqVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatTotVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatVo;

/**
 * 미세먼지 > 통계 서비스 구현
 * @author atom
 * @since 2020.07.26
 */
@Service
public class FineDustStatisticsServiceImpl implements FineDustStatisticsService {

    @Autowired
    private FineDustStatisticsMapper fineDustStatisticsMapper;

    /**
     * 디바이스 측정 통계 목록 조회
     */
    @Override
    public List<FineDustDevObsStscVo> selectDevObsStscList(FineDustDevObsStscReqVo param) {
        return fineDustStatisticsMapper.selectDevObsStscList(param);
    }

    /**
     * 디바이스 상태 정보 조회
     */
    @Override
    public FineDustDevStatVo selectDevStatInfo(FineDustDevStatReqVo param) {
        // 디바이스 상태 합계 정보 조회
        FineDustDevStatTotVo totInfo = fineDustStatisticsMapper.selectDevStatTotInfo(param);

        // 결과값 설정
        FineDustDevStatVo resultVo = new FineDustDevStatVo();
        resultVo.setTotInfo(totInfo);

        return resultVo;
    }

}
