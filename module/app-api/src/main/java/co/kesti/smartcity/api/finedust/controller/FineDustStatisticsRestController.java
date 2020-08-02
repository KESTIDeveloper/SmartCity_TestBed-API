package co.kesti.smartcity.api.finedust.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import co.kesti.smartcity.api.finedust.service.FineDustStatisticsService;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscReqVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsStscVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevObsVo;
import co.kesti.smartcity.api.finedust.vo.FineDustDevVo;
import co.kesti.smartcity.define.Define;
import co.kesti.smartcity.model.response.ApiResponse;

/**
 * 미세먼지 > 측정값 통계 컨트롤러
 * @author atom
 * @since 2020.07.26
 */
@RestController
@RequestMapping("/TESTBED/v0.9/api/finedust/statistics")
public class FineDustStatisticsRestController {

    @Autowired
    private FineDustStatisticsService fineDustStatisticsService;

    /**
     * 테스트 디바이스 목록 조회
     * @param mbrSeq
     * @return
     */
    @PostMapping("/selectTestDevList")
    public ApiResponse<?> selectTestDevList(@RequestParam(value="mbrSeq", required=true) Long mbrSeq) {
        List<FineDustDevVo> resList = fineDustStatisticsService.selectTestDevList(mbrSeq);

        return ApiResponse.ok(resList);
    }

    /**
     * 비교 디바이스 목록 조회
     * @param devId
     * @return
     */
    @GetMapping("/selectCmprDevList")
    public ApiResponse<?> selectCmprDevList(@RequestParam(value="devId", required=true) String devId) {
        List<FineDustDevVo> resList = fineDustStatisticsService.selectCmprDevList(devId);

        return ApiResponse.ok(resList);
    }

    /**
     * 디바이스 측정 목록 조회
     * @param devId
     * @return
     */
    @GetMapping("/selectDevObsList")
    public ApiResponse<?> selectDevObsList(@RequestParam(value="devId", required=true) String devId) {
        List<FineDustDevObsVo> resList = fineDustStatisticsService.selectDevObsList(devId);

        return ApiResponse.ok(resList);
    }

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

}
