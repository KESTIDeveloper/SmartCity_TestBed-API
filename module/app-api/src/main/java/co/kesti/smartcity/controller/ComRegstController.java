package co.kesti.smartcity.controller;

import co.kesti.smartcity.entity.ComRegst;
import co.kesti.smartcity.entity.custom.ComRegstProjection;
import co.kesti.smartcity.model.Pagination;
import co.kesti.smartcity.model.request.RequestComRegst;
import co.kesti.smartcity.model.response.ApiResponse;
import co.kesti.smartcity.service.ComRegstService;
import co.kesti.smartcity.service.PageMaker;
import co.kesti.smartcity.util.JsonUtils;
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
public class ComRegstController {

    private final ComRegstService comRegstService;
    private final PageMaker pageMaker;

    public ComRegstController(ComRegstService comRegstService, PageMaker pageMaker) {
        this.comRegstService = comRegstService;
        this.pageMaker = pageMaker;
    }

    @PostMapping("/comregstList")
    public ApiResponse getComRegsts(@RequestBody RequestComRegst request) {
        Page<ComRegst> pages = comRegstService.getComRegstsByCretrId(request.getCretrId(), PageRequest.of(request.getPage(), request.getSize()));

        Pagination pagination = pageMaker.toPagination(pages, 10);
        return ApiResponse.ok(pagination);
    }

    /**
     * 나의 신청현황 목록
     */
    @PostMapping("/mypage/comregstList")
    public ApiResponse getMyPageComRegsts(@RequestBody RequestComRegst request) {
        Page<ComRegst> pages = comRegstService.getComRegstsByCretrId(request.getCretrId(), PageRequest.of(request.getPage(), request.getSize()));

        Pagination pagination = pageMaker.toPagination(pages, 10);
        return ApiResponse.ok(pagination);
    }


    @GetMapping("/comregst/{id}")
    public ApiResponse getComRegst(@PathVariable(value = "id") Integer regstSeq) {
        ComRegst res = comRegstService.getComRegst(regstSeq);
        return ApiResponse.ok(res);
    }

    @PostMapping("/comregst")
    public ApiResponse createComRegst(@RequestBody RequestComRegst request) {
        log.info("{}", JsonUtils.toPrettyString(request));
        ComRegst res = comRegstService.createComRegst(request);
        return ApiResponse.ok(res);
    }


    @PutMapping("/comregst/{id}")
    public ApiResponse updateComRegst(@PathVariable(value = "id") Integer regstSeq, @RequestBody RequestComRegst request) {
        ComRegst res = comRegstService.updateComRegst(regstSeq, request);
        return ApiResponse.ok(res);
    }

    @DeleteMapping("/comregst/{id}")
    public ApiResponse deleteComRegst(@PathVariable(value = "id") Integer regstSeq) {
        comRegstService.delete(regstSeq);
        return ApiResponse.ok(ImmutableMap.of("deleted", Boolean.TRUE));
    }

}
