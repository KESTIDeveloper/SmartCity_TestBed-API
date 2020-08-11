package co.kesti.smartcity.controller;

import co.kesti.smartcity.config.AppConfig;
import co.kesti.smartcity.entity.ComMbr;
import co.kesti.smartcity.entity.DevInfo;
import co.kesti.smartcity.entity.DevObsInfo;
import co.kesti.smartcity.entity.DevObsInfoKey;
import co.kesti.smartcity.entity.custom.DevInfoProjection;
import co.kesti.smartcity.entity.custom.DevObsInfoProjection;
import co.kesti.smartcity.model.Pagination;
import co.kesti.smartcity.model.request.RequestDevInfo;
import co.kesti.smartcity.model.request.RequestOpenApiApply;
import co.kesti.smartcity.model.response.ApiResponse;
import co.kesti.smartcity.service.*;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/TESTBED/v0.9/api/open-api")
public class OpenApiController {

    private final DevInfoService devInfoService;
    private final PageMaker pageMaker;
    private final JwtTokenProvider jwtTokenProvider;
    private final ComMbrService comMbrService;
    private final DeviceObsInfoService deviceObsInfoService;


    @ApiOperation(value = "오픈 api 신청")
    @PostMapping("/apply")
    public ApiResponse applyOpenApi(@RequestBody RequestOpenApiApply request) {

        String token = jwtTokenProvider.createToken(request.getCretrId());
        ComMbr comMbr = comMbrService.getMbrById(request.getCretrId());
        comMbr.setUserTokn(token);
        comMbrService.save(comMbr);
        log.debug("generate token: {}, {}", request.getCretrId(), token);
        return ApiResponse.ok(token);
    }



    @ApiOperation(value = "전체 디바이스 목록 조회")
    @GetMapping("/management/devices")
    public ApiResponse getManagementDeviceList(@RequestHeader("AUTH-TOKEN") String authToken,
                                               @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                               @RequestParam(name = "size", required = false, defaultValue = "8") int size) {
        Page<DevInfoProjection> pages = devInfoService.getDevInfoProjections(PageRequest.of(page, size));
        Pagination pagination = pageMaker.toPagination(pages, 10);
        return ApiResponse.ok(pagination);
    }

    @ApiOperation(value = "내 디바이스 목록 조회")
    @PostMapping("/management/devices")
    public ApiResponse getMyManagementDeviceList(HttpServletRequest req,
                                                 @RequestHeader("AUTH-TOKEN") String authToken,
                                                 @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                                 @RequestParam(name = "size", required = false, defaultValue = "8") int size) {

        String mbrId = (String) req.getSession().getAttribute(AppConfig.MbrId);

        Page<DevInfoProjection> pages = devInfoService.getDevInfoProjectionsByCretrId(mbrId, PageRequest.of(page, size));
        Pagination pagination = pageMaker.toPagination(pages, 10);
        return ApiResponse.ok(pagination);
    }

    @ApiOperation(value = "내 디바이스 정보")
    @GetMapping("/management/device/{id}")
    public ApiResponse getDevInfo(HttpServletRequest req,
                                  @RequestHeader("AUTH-TOKEN") String authToken,
                                  @PathVariable(value = "id") String devId) {
        String mbrId = (String) req.getSession().getAttribute(AppConfig.MbrId);
        DevInfo res = devInfoService.getDevInfoOrThrow(devId);
        return ApiResponse.ok(res);
    }


    @GetMapping("/deviceObsInfos")
    public ApiResponse getDeviceInfos(HttpServletRequest req,
                                      @RequestHeader("AUTH-TOKEN") String authToken,
                                      @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                      @RequestParam(name = "size", required = false, defaultValue = "5") int size) {
        Page<DevObsInfo> res = deviceObsInfoService.getDevObsInfos(PageRequest.of(page, size, Sort.by("cretDt").descending()));
        return ApiResponse.ok(res.getContent());
    }

    @GetMapping("/deviceObsInfos/{devId}")
    public ApiResponse getDeviceInfosByDevId(HttpServletRequest req,
                                             @RequestHeader("AUTH-TOKEN") String authToken,
                                             @PathVariable("devId") String devId,
                                             @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                             @RequestParam(name = "size", required = false, defaultValue = "5") int size) {
        Page<DevObsInfoProjection> res = deviceObsInfoService.getDevObsInfosByDevId(devId, PageRequest.of(page, size));
        return ApiResponse.ok(res.getContent());
    }

    @GetMapping("/deviceObsInfo")
    public ApiResponse getDeviceInfo(HttpServletRequest req,
                                     @RequestHeader("AUTH-TOKEN") String authToken,
                                     @RequestParam("deviceId") String deviceId,
                                     @RequestParam("obsItemId") String obsItemId) {
        DevObsInfoKey deviceObsInfoKey = DevObsInfoKey.builder()
                .devId(deviceId)
                .obsItemId(obsItemId)
                .build();

        DevObsInfo res = deviceObsInfoService.getDevObsInfoOrThrow(deviceObsInfoKey);
        return ApiResponse.ok(res);
    }


}
