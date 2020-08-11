package co.kesti.smartcity.api.finedust.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kesti.smartcity.api.finedust.mapper.FineDustStatisticsMapper;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscReqVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatEvtLogVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatEvtObsVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatEvtVo;
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
        // 디바이스구분값
        param.setDevDivVal(StringUtils.join(param.getDevList(), "|"));

        return fineDustStatisticsMapper.selectDevObsStscList(param);
    }

    /**
     * 디바이스 상태 정보 조회
     */
    @Override
    public FineDustDevStatVo selectDevStatInfo(FineDustDevStatReqVo param) {
        // 디바이스 상태 합계 정보 조회
        FineDustDevStatTotVo totInfo = fineDustStatisticsMapper.selectDevStatTotInfo(param);

        // 디바이스 상태 이벤트 정보 조회
        FineDustDevStatEvtVo evtInfo = fineDustStatisticsMapper.selectDevStatEvtInfo(param);

        // 디바이스 상태 이벤트 측정 목록 조회
        List<FineDustDevStatEvtObsVo> evtObsList = fineDustStatisticsMapper.selectDevStatEvtObsList(param);

        // 결과값 설정
        FineDustDevStatVo resultVo = new FineDustDevStatVo();
        resultVo.setTotInfo(totInfo);
        resultVo.setEvtInfo(evtInfo);
        resultVo.setEvtObsList(evtObsList);

        return resultVo;
    }

    /**
     * 디바이스 상태 이벤트 로그 목록 조회
     */
    @Override
    public List<FineDustDevStatEvtLogVo> selectDevStatEvtLogList(FineDustDevStatReqVo param) {
        // 이벤트 로그 건수 조회
        int evtLogCnt = fineDustStatisticsMapper.selectDevStatEvtLogCount(param);
        param.setTotCnt(evtLogCnt);

        // 이벤트 로그 목록 조회
        List<FineDustDevStatEvtLogVo> evtLogList = new ArrayList<>();

        if (evtLogCnt > 0) {
            evtLogList = fineDustStatisticsMapper.selectDevStatEvtLogList(param);
        }

        return evtLogList;
    }

}
