package co.kesti.smartcity.api.finedust.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import co.kesti.smartcity.api.finedust.service.FineDustStatisticsService;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscReqVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatEvtLogVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatReqVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevStatVo;
import co.kesti.smartcity.define.Define;
import co.kesti.smartcity.model.response.ApiResponse;

/**
 * 미세먼지 > 통계 컨트롤러
 * @author atom
 * @since 2020.07.26
 */
@RestController
@RequestMapping("/TESTBED/v0.9/api/finedust/statistics")
public class FineDustStatisticsRestController {

    @Autowired
    private FineDustStatisticsService fineDustStatisticsService;

    /**
     * 디바이스 측정 통계 목록 조회
     * @param param
     * @return
     */
    @PostMapping("/selectDevObsStscList")
    public ApiResponse<?> selectDevObsStscList(@RequestBody FineDustDevObsStscReqVo param) {
        List<FineDustDevObsStscVo> resList = fineDustStatisticsService.selectDevObsStscList(param);

        return ApiResponse.ok(resList);
    }

    /**
     * 디바이스 측정 통계 목록 엑셀 다운로드
     * @param param
     * @return
     */
    @PostMapping("/exclDwldlDevObsStscList")
    public ModelAndView exclDwldlDevObsStscList(@RequestBody Map<String, Object> param) {
        // 결과값 설정
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put(Define.EXCEL_HAED_LIST, param.get(Define.EXCEL_HAED_LIST));
        resultMap.put(Define.EXCEL_BODY_LIST, param.get(Define.EXCEL_BODY_LIST));

        return new ModelAndView(Define.EXCEL_VIEW, resultMap);
    }

    /**
     * 디바이스 상태 정보 조회
     * @param param
     * @return
     */
    @GetMapping("/selectDevStatInfo")
    public ApiResponse<?> selectDevStatInfo(FineDustDevStatReqVo param) {
        FineDustDevStatVo resInfo = fineDustStatisticsService.selectDevStatInfo(param);

        return ApiResponse.ok(resInfo);
    }

    /**
     * 디바이스 상태 이벤트 로그 목록 조회
     * @param param
     * @return
     */
    @GetMapping("/selectDevStatEvtLogList")
    public ApiResponse<?> selectDevStatEvtLogList(FineDustDevStatReqVo param) {
        List<FineDustDevStatEvtLogVo> resList = fineDustStatisticsService.selectDevStatEvtLogList(param);

        return ApiResponse.ok(resList, param);
    }

    /**
     * 디바이스 측정 통계 목록 엑셀 다운로드
     * @param param
     * @return
     */
    @GetMapping("/exclDwldlDevStatEvtLogList")
    public ModelAndView exclDwldlDevStatEvtLogList(FineDustDevStatReqVo param) {
        // 디바이스 상태 이벤트 로그 목록 조회
        param.setPagingSet(false);
        List<FineDustDevStatEvtLogVo> logList = fineDustStatisticsService.selectDevStatEvtLogList(param);

        // head 목록
        List<String> headList = Arrays.asList("시간", "이벤트명", "이벤트 내용", "측정항목", "측정값");

        // body 목록
        List<List<String>> bodyList = new ArrayList<List<String>>();
        List<String> data = null;

        for (FineDustDevStatEvtLogVo logRow : logList) {
            data = new ArrayList<String>();
            data.add(logRow.getLogDt());      // 시간
            data.add(logRow.getEvntNm());     // 이벤트명
            data.add(logRow.getMngContent()); // 이벤트내용
            data.add(logRow.getEvtObsNm());   // 측정항목
            data.add(logRow.getTestVal());    // 측정값

            // body 목록 추가
            bodyList.add(data);
        }

        // 결과값 설정
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put(Define.EXCEL_HAED_LIST, headList);
        resultMap.put(Define.EXCEL_BODY_LIST, bodyList);

        return new ModelAndView(Define.EXCEL_VIEW, resultMap);
    }

}
