package co.kesti.smartcity.api.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.kesti.smartcity.api.management.service.ManagementDeviceService;
import co.kesti.smartcity.api.management.vo.MgmtDevCdVo;
import co.kesti.smartcity.api.management.vo.MgmtDevObsCdVo;
import co.kesti.smartcity.model.response.ApiResponse;

/**
 * 관리 > 디바이스 컨트롤러
 * @author atom
 * @since 2020.08.02
 */
@RestController
@RequestMapping("/TESTBED/v0.9/api/management/device")
public class ManagementDeviceRestController {

    @Autowired
    private ManagementDeviceService managementDeviceService;

    /**
     * 디바이스 코드 목록 조회
     * @param mbrSeq
     * @return
     */
    @PostMapping("/selectDevCdList")
    public ApiResponse<?> selectDevCdList(@RequestParam(value="mbrSeq", required=false) Long mbrSeq) {
        List<MgmtDevCdVo> resList = managementDeviceService.selectDevCdList(mbrSeq);

        return ApiResponse.ok(resList);
    }

    /**
     * 비교 디바이스 코드 목록 조회
     * @param devId
     * @return
     */
    @GetMapping("/selectCmprDevCdList")
    public ApiResponse<?> selectCmprDevCdList(@RequestParam(value="devId", required=true) String devId) {
        List<MgmtDevCdVo> resList = managementDeviceService.selectCmprDevCdList(devId);

        return ApiResponse.ok(resList);
    }

    /**
     * 디바이스 측정 코드 목록 조회
     * @param devId
     * @return
     */
    @GetMapping("/selectDevObsCdList")
    public ApiResponse<?> selectDevObsCdList(@RequestParam(value="devId", required=true) String devId) {
        List<MgmtDevObsCdVo> resList = managementDeviceService.selectDevObsCdList(devId);

        return ApiResponse.ok(resList);
    }

}
