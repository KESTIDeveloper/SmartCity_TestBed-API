package co.kesti.smartcity.controller;

import co.kesti.smartcity.entity.DevObsInfo;
import co.kesti.smartcity.entity.DevObsInfoKey;
import co.kesti.smartcity.entity.custom.DevObsInfoProjection;
import co.kesti.smartcity.model.request.RequestDeleteDevObsInfo;
import co.kesti.smartcity.model.request.RequestDevObsInfo;
import co.kesti.smartcity.model.response.ApiResponse;
import co.kesti.smartcity.service.DeviceObsInfoService;
import co.kesti.smartcity.util.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/TESTBED/v0.9/api")
public class DeviceObsInfoController {

    private final DeviceObsInfoService deviceObsInfoService;

    public DeviceObsInfoController(DeviceObsInfoService deviceObsInfoService) {
        this.deviceObsInfoService = deviceObsInfoService;
    }


    @GetMapping("/deviceObsInfos")
    public ApiResponse getDeviceInfos(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                      @RequestParam(name = "size", required = false, defaultValue = "5") int size) {
        Page<DevObsInfo> res = deviceObsInfoService.getDevObsInfos(PageRequest.of(page, size, Sort.by("cretDt").descending()));
        return ApiResponse.ok(res.getContent());
    }

    @GetMapping("/deviceObsInfos/{devId}")
    public ApiResponse getDeviceInfosByDevId(@PathVariable("devId") String devId,
                                        @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                      @RequestParam(name = "size", required = false, defaultValue = "5") int size) {
        Page<DevObsInfoProjection> res = deviceObsInfoService.getDevObsInfosByDevId(devId, PageRequest.of(page, size));
        return ApiResponse.ok(res.getContent());
    }

    @GetMapping("/deviceObsInfo")
    public ApiResponse getDeviceInfo(@RequestParam("deviceId") String deviceId,
                                     @RequestParam("obsItemId") String obsItemId) {
        DevObsInfoKey deviceObsInfoKey = DevObsInfoKey.builder()
                .devId(deviceId)
                .obsItemId(obsItemId)
                .build();

        DevObsInfo res = deviceObsInfoService.getDevObsInfoOrThrow(deviceObsInfoKey);
        return ApiResponse.ok(res);
    }

    @PostMapping("/deviceObsInfo")
    public ApiResponse createDeviceInfo(@RequestBody RequestDevObsInfo request) {
        log.info("POST deviceObsInfo: {}", JsonUtils.toPrettyString(request));

        DevObsInfo res = deviceObsInfoService.createDevObsInfo(request);
        return ApiResponse.ok(res);
    }

    @PutMapping("/deviceObsInfo")
    public ApiResponse updateDeviceInfo(@RequestBody RequestDevObsInfo request) {
        DevObsInfo res = deviceObsInfoService.updateDevObsInfo(request);
        return ApiResponse.ok(res);
    }

    @DeleteMapping("/deviceObsInfo/{devId}/{obsItemId}")
    public ApiResponse deleteDeviceInfo(@PathVariable("devId") String devId, @PathVariable("obsItemId") String obsItemId) {

        log.debug("delete obsInfo {}, {]", devId, obsItemId);
        deviceObsInfoService.delete(DevObsInfoKey.builder().obsItemId(obsItemId).devId(devId).build());
        return ApiResponse.ok(ImmutableMap.of("deleted", Boolean.TRUE));
    }

}
