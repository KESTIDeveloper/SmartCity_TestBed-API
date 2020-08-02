package co.kesti.smartcity.controller;

import co.kesti.smartcity.entity.DevInfo;
import co.kesti.smartcity.entity.custom.DevInfoProjection;
import co.kesti.smartcity.model.Pagination;
import co.kesti.smartcity.model.request.RequestDevInfo;
import co.kesti.smartcity.model.response.ApiResponse;
import co.kesti.smartcity.service.DevInfoService;
import co.kesti.smartcity.service.PageMaker;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/TESTBED/v0.9/api")
public class DevInfoController {

    private final DevInfoService devInfoService;
    private final PageMaker pageMaker;

    public DevInfoController(DevInfoService devInfoService, PageMaker pageMaker) {
        this.devInfoService = devInfoService;
        this.pageMaker = pageMaker;
    }

    @GetMapping("/management/devices")
    public ApiResponse getManagementDeviceList(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                               @RequestParam(name = "size", required = false, defaultValue = "8") int size) {
        Page<DevInfoProjection> pages = devInfoService.getDevInfoProjections(PageRequest.of(page, size));
        Pagination pagination = pageMaker.toPagination(pages, 10);
        return ApiResponse.ok(pagination);
    }

    @PostMapping("/management/devices")
    public ApiResponse getMyManagementDeviceList(@RequestBody RequestDevInfo request) {
        Page<DevInfoProjection> pages = devInfoService.getDevInfoProjectionsByCretrId(request.getCretrId(), PageRequest.of(request.getPage(), request.getSize()));
        Pagination pagination = pageMaker.toPagination(pages, 10);
        return ApiResponse.ok(pagination);
    }

    @GetMapping("/management/device/{id}")
    public ApiResponse getDevInfo(@PathVariable(value = "id") String devId) {
        DevInfo res = devInfoService.getDevInfoOrThrow(devId);
        return ApiResponse.ok(res);
    }

    @GetMapping("/management/compare-devices/{devId}")
    public ApiResponse getCompareDevInfoListByDevId(@PathVariable(value = "devId") String devId) {
        List<DevInfo> res = devInfoService.getCompareDeviceListByDevId(devId);
        return ApiResponse.ok(res);
    }

    @GetMapping("/management/compare-devices")
    public ApiResponse getCompareDevInfoList() {
        List<DevInfo> res = devInfoService.getCompareDeviceList();
        return ApiResponse.ok(res);
    }

    @GetMapping("/management/device/monitor/{id}")
    public ApiResponse getDevInfoMonitor(@PathVariable(value = "id") String devId) {
        DevInfo res = devInfoService.getDevInfoOrThrow(devId);
        return ApiResponse.ok(res);
    }

    @PostMapping("/management/device")
    public ApiResponse createDevInfo(@Valid @RequestBody RequestDevInfo request) {
        DevInfo res = devInfoService.createDevInfo(request);
        return ApiResponse.ok(res);
    }

    @PostMapping("/management/device/{id}/liveStatus/{liveStatus}")
    public ApiResponse updateDevInfoLiveStatus(@PathVariable("id") String devId, @PathVariable("liveStatus") String liveStatus) {
        Integer res = devInfoService.updateLiveStatusById(devId, liveStatus);
        return ApiResponse.ok(res);
    }


    @PutMapping("/management/device/{id}")
    public ApiResponse updateDevInfo(@PathVariable(value = "id") String devId, @Valid @RequestBody RequestDevInfo request) {
        DevInfo res = devInfoService.updateComMbr(devId, request);
        return ApiResponse.ok(res);
    }

    @DeleteMapping("/management/device/{id}")
    public ApiResponse deleteDevInfo(@PathVariable(value = "id") String devId) {
        devInfoService.delete(devId);
        return ApiResponse.ok(ImmutableMap.of("deleted", Boolean.TRUE));
    }

}
