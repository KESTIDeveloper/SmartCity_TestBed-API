package co.kesti.smartcity.controller;

import com.google.common.collect.ImmutableMap;
import co.kesti.smartcity.entity.ComMbr;
import co.kesti.smartcity.model.request.RequestComMbr;
import co.kesti.smartcity.model.response.ApiResponse;
import co.kesti.smartcity.service.ComMbrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/TESTBED/v0.9")
public class ComMbrController {

    private final ComMbrService comMbrService;

    public ComMbrController(ComMbrService comMbrService) {
        this.comMbrService = comMbrService;
    }

    @GetMapping("/commbrList")
    public ApiResponse getComMbrs() {
        List<ComMbr> res = comMbrService.getComMbrs();
        return ApiResponse.ok(res);
    }

    @GetMapping("/commbr/{id}")
    public ApiResponse getComMbr(@PathVariable(value = "id") Integer mbrSeq) {
        ComMbr res = comMbrService.getComMbrOrThrow(mbrSeq);
        return ApiResponse.ok(res);
    }

    @PostMapping("/commbr")
    public ApiResponse createComMbr(@RequestBody RequestComMbr request) {
        ComMbr res = comMbrService.createComMbr(request);
        return ApiResponse.ok(res);
    }


    @PutMapping("/commbr/{id}")
    public ApiResponse updateComMbr(@PathVariable(value = "id") Integer mbrSeq, @RequestBody RequestComMbr request) {
        ComMbr res = comMbrService.updateComMbr(mbrSeq, request);
        return ApiResponse.ok(res);
    }

    @DeleteMapping("/commbr/{id}")
    public ApiResponse deleteComMbr(@PathVariable(value = "id") Integer mbrSeq) {
        comMbrService.delete(mbrSeq);
        return ApiResponse.ok(ImmutableMap.of("deleted", Boolean.TRUE));
    }

}
