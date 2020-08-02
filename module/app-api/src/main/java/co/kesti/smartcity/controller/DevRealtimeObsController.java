package co.kesti.smartcity.controller;

import co.kesti.smartcity.entity.DevRealtimeObs;
import co.kesti.smartcity.model.request.RequestDevRealtimeObs;
import co.kesti.smartcity.model.response.ApiResponse;
import co.kesti.smartcity.service.DevRealtimeObsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/TESTBED/v0.9")
public class DevRealtimeObsController {

    private final DevRealtimeObsService devRealtimeObsService;

    public DevRealtimeObsController(DevRealtimeObsService devRealtimeObsService) {
        this.devRealtimeObsService = devRealtimeObsService;
    }

    @GetMapping("/devRealtimeObsList")
    public ApiResponse getDevRealtimeObsList() {
        List<DevRealtimeObs> res = devRealtimeObsService.getDevRealtimeObsList();
        return ApiResponse.ok(res);
    }


    @PostMapping("/devRealtimeObs")
    public ApiResponse createDevInfo(@RequestBody RequestDevRealtimeObs request) {
        DevRealtimeObs res = devRealtimeObsService.save(request);
        return ApiResponse.ok(res);
    }


}
