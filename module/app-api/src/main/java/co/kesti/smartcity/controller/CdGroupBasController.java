package co.kesti.smartcity.controller;

import co.kesti.smartcity.entity.CdGroupBas;
import co.kesti.smartcity.service.CdGroupBasService;
import com.google.common.collect.ImmutableMap;
import co.kesti.smartcity.model.request.RequestCdGroupBas;
import co.kesti.smartcity.model.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/TESTBED/v0.9")
public class CdGroupBasController {

    private final CdGroupBasService cdGroupBasService;

    public CdGroupBasController(CdGroupBasService cdGroupBasService) {
        this.cdGroupBasService = cdGroupBasService;
    }

    @GetMapping("/cdGroupBasList")
    public ApiResponse getCodeGroups() {
        List<CdGroupBas> res = cdGroupBasService.getCodeGroups();
        return ApiResponse.ok(res);
    }

    @GetMapping("/cdGroupBas/{id}")
    public ApiResponse getCodeGroup(@PathVariable(value = "id") String cdGroupId) {
        CdGroupBas res = cdGroupBasService.getCodeGroupOrThrow(cdGroupId);
        return ApiResponse.ok(res);
    }

    @PostMapping("/cdGroupBas")
    public ApiResponse createCodeGroup(@RequestBody RequestCdGroupBas requestCdGroupBas) {
        CdGroupBas cdGroupBas = cdGroupBasService.createCodeGroup(requestCdGroupBas);
        return ApiResponse.ok(cdGroupBas);
    }


    @PutMapping("/cdGroupBas/{id}")
    public ApiResponse updateCodeGroup(@PathVariable(value = "id") String cdGroupId, @RequestBody RequestCdGroupBas requestCdGroupBas) {
        CdGroupBas res = cdGroupBasService.updateCodeGroup(cdGroupId, requestCdGroupBas);
        return ApiResponse.ok(res);
    }

    @DeleteMapping("/cdGroupBas/{id}")
    public ApiResponse deleteCodeGroup(@PathVariable(value = "id") String cdGroupId) {
        cdGroupBasService.delete(cdGroupId);
        return ApiResponse.ok(ImmutableMap.of("deleted", Boolean.TRUE));
    }

}
