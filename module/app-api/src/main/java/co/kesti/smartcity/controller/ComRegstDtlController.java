package co.kesti.smartcity.controller;

import co.kesti.smartcity.entity.ComRegst;
import co.kesti.smartcity.entity.ComRegstDtl;
import co.kesti.smartcity.model.Pagination;
import co.kesti.smartcity.model.request.RequestComRegst;
import co.kesti.smartcity.model.request.RequestComRegstDtl;
import co.kesti.smartcity.model.response.ApiResponse;
import co.kesti.smartcity.service.ComRegstDtlService;
import co.kesti.smartcity.service.ComRegstService;
import co.kesti.smartcity.service.PageMaker;
import co.kesti.smartcity.util.JsonUtils;
import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/TESTBED/v0.9/api")
public class ComRegstDtlController {

    private final ComRegstDtlService comRegstDtlService;
    private final PageMaker pageMaker;


    @PostMapping("/comregstDtlList")
    public ApiResponse getComRegstDtlList(@RequestBody RequestComRegstDtl request) {

        Page<ComRegstDtl> pages = comRegstDtlService.getComRegstDtlList(request.getRegstSeq(), PageRequest.of(request.getPage(), request.getSize()));

        Pagination pagination = pageMaker.toPagination(pages, 10);
        return ApiResponse.ok(pagination);
    }

    @PostMapping("/comregstDtl")
    public ApiResponse createComRegstDtl(@RequestBody RequestComRegstDtl request) {
        log.info("{}", JsonUtils.toPrettyString(request));
        ComRegstDtl res = comRegstDtlService.createComRegstDtl(request);
        return ApiResponse.ok(res);
    }


    @DeleteMapping("/comregstDtl/{regstSeq}/{seq}")
    public ApiResponse deleteComRegstDtl(@PathVariable(value = "regstSeq") Integer regstSeq,
                                         @PathVariable(value = "seq") Integer seq) {
        comRegstDtlService.delete(regstSeq, seq);
        return ApiResponse.ok(ImmutableMap.of("deleted", Boolean.TRUE));
    }

}
