package co.kesti.smartcity.controller;

import co.kesti.smartcity.entity.CdDtl;
import co.kesti.smartcity.entity.CdDtlKey;
import co.kesti.smartcity.model.request.ReqeustCdDtl;
import co.kesti.smartcity.model.request.RequestDeleteCodeGroupInfo;
import co.kesti.smartcity.service.CdDtlService;
import co.kesti.smartcity.util.JsonUtils;
import com.google.common.collect.ImmutableMap;
import co.kesti.smartcity.model.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/TESTBED/v0.9/api")
public class CdDtlController {

    private final CdDtlService cdDtlService;

    public CdDtlController(CdDtlService cdDtlService) {
        this.cdDtlService = cdDtlService;
    }

    @GetMapping("/cdDtlList")
    public ApiResponse getCodeGroupInfos() {
        List<CdDtl> res = cdDtlService.getCodeGroupInfos();
        return ApiResponse.ok(res);
    }

    @GetMapping("/cdDtlList/{cdGroupId}")
    public ApiResponse getCodeGroupInfosByCdGroupId(@PathVariable("cdGroupId") String cdGroupId) {
        List<CdDtl> res = cdDtlService.getCodeGroupInfosByGroupId(cdGroupId);
        log.info("{}", JsonUtils.toString(res));
        return ApiResponse.ok(res);
    }


    private String langCd;

    @GetMapping("/cdDtl")
    public ApiResponse getCodeGroupInfo(@RequestParam("cdGroupId") String cdGroupId,
                                        @RequestParam("dtlCd") String dtlCd,
                                        @RequestParam("langCd") String langCd) {
        CdDtlKey cdDtlKey = CdDtlKey.builder().cdGroupId(cdGroupId).dtlCd(dtlCd).langCd(langCd).build();
        CdDtl res = cdDtlService.getCodeGroupInfoOrThrow(cdDtlKey);
        return ApiResponse.ok(res);
    }

    @PostMapping("/cdDtl")
    public ApiResponse createCodeGroupInfo(@RequestBody ReqeustCdDtl request) {
        CdDtl res = cdDtlService.createCodeGroupInfo(request);
        return ApiResponse.ok(res);
    }


    @PutMapping("/cdDtl")
    public ApiResponse updateCodeGroupInfo(@RequestBody ReqeustCdDtl request) {
        CdDtl res = cdDtlService.updateCodeGroupInfo(request);
        return ApiResponse.ok(res);
    }

    @DeleteMapping("/cdDtl")
    public ApiResponse deleteCodeGroupInfo(@RequestBody RequestDeleteCodeGroupInfo requestDeleteCodeGroupInfo) {
        cdDtlService.delete(requestDeleteCodeGroupInfo.getCdDtlKey());
        return ApiResponse.ok(ImmutableMap.of("deleted", Boolean.TRUE));
    }

}
