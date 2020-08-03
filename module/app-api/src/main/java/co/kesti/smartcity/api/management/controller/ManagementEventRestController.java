package co.kesti.smartcity.api.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.kesti.smartcity.api.management.service.ManagementEventService;
import co.kesti.smartcity.api.management.vo.MgmtEvtDelReqVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtDtlVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtReadVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtReqVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtVo;
import co.kesti.smartcity.model.response.ApiResponse;

/**
 * 관리 > 이벤트 컨트롤러
 * @author atom
 * @since 2020.07.31
 */
@RestController
@RequestMapping("/TESTBED/v0.9/api/management/event")
public class ManagementEventRestController {

    @Autowired
    private ManagementEventService managementEventService;

    /**
     * 이벤트 목록 조회
     * @param param
     * @return
     */
    @GetMapping("/selectEvtList")
    public ApiResponse<?> selectEvtList(MgmtEvtReqVo param) {
        List<MgmtEvtVo> resList = managementEventService.selectEvtList(param);

        return ApiResponse.ok(resList, param);
    }

    /**
     * 이벤트 읽기 정보 조회
     * @param param
     * @return
     */
    @GetMapping("/selectEvtReadInfo")
    public ApiResponse<?> selectEvtReadInfo(MgmtEvtVo param) {
        MgmtEvtReadVo resInfo = managementEventService.selectEvtReadInfo(param);

        return ApiResponse.ok(resInfo);
    }

    /**
     * 이벤트 상세 정보 조회
     * @param param
     * @return
     */
    @GetMapping("/selectEvtDtlInfo")
    public ApiResponse<?> selectEvtDtlInfo(MgmtEvtVo param) {
        MgmtEvtDtlVo resInfo = managementEventService.selectEvtDtlInfo(param);

        return ApiResponse.ok(resInfo);
    }

    /**
     * 이벤트 저장
     * @param param
     * @return
     */
    @PostMapping("/saveEvt")
    public ApiResponse<?> saveEvt(@RequestBody MgmtEvtDtlVo param) {
        managementEventService.saveEvt(param);

        return ApiResponse.ok();
    }

    /**
     * 이벤트 상태 여부 수정
     * @param param
     * @return
     */
    @PostMapping("/updateEvtStatYn")
    public ApiResponse<?> updateEvtStatYn(MgmtEvtVo param) {
        managementEventService.updateEvtStatYn(param);

        return ApiResponse.ok();
    }

    /**
     * 이벤트 삭제
     * @param param
     * @return
     */
    @PostMapping("/deleteEvt")
    public ApiResponse<?> deleteEvt(MgmtEvtDelReqVo param) {
        managementEventService.deleteEvt(param);

        return ApiResponse.ok();
    }

    /**
     * 이벤트 멀티 삭제
     * @param param
     * @return
     */
    @PostMapping("/deleteEvtMulti")
    public ApiResponse<?> deleteEvtMulti(@RequestBody MgmtEvtDelReqVo param) {
        managementEventService.deleteEvtMulti(param);

        return ApiResponse.ok();
    }

}
