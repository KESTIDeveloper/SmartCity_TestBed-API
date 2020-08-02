package co.kesti.smartcity.controller;

import co.kesti.smartcity.entity.CmntPrdt;
import co.kesti.smartcity.entity.CmntPrdtComment;
import co.kesti.smartcity.entity.custom.CmntPrdtCommentProjection;
import co.kesti.smartcity.entity.custom.CmntPrdtProjection;
import co.kesti.smartcity.model.request.RequestCmntPrdt;
import co.kesti.smartcity.model.request.RequestCmntPrdtComment;
import co.kesti.smartcity.model.response.ApiResponse;
import co.kesti.smartcity.service.CmntPrdtService;
import co.kesti.smartcity.util.JsonUtils;
import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/TESTBED/v0.9/api")
public class CmntPrdtController {

    private final CmntPrdtService cmntPrdtService;


    @GetMapping("/community/products")
    public ApiResponse getProductsList(@RequestParam(value = "prdtType", defaultValue = "all") String prdtType,
                                       @RequestParam(value = "prdtName", defaultValue = "") String prdtName,
                                       @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                       @RequestParam(name = "size", required = false, defaultValue = "8") int size) {
        List<CmntPrdt> res = cmntPrdtService.getCmntPrdtListByPrdtTypeAndPrdtName(prdtType, prdtName, PageRequest.of(page, size));
        log.info("{}", JsonUtils.toPrettyString(res));
        return ApiResponse.ok(res);
    }

    @GetMapping("/community/product/{prdtSeq}")
    public ApiResponse getProductById(@PathVariable(value = "prdtSeq") Integer prdtSeq) {
        CmntPrdt res = cmntPrdtService.getCmntPrdtProjectionOrThrow(prdtSeq);

        log.info("------- product ------\n{}", JsonUtils.toPrettyString(res));
        return ApiResponse.ok(res);
    }

    @PostMapping("/community/product")
    public ApiResponse createProduct(@RequestBody RequestCmntPrdt request) {
        CmntPrdt res = cmntPrdtService.createCmntPrdt(request);
        log.debug("res: {}", JsonUtils.toString(res));
        return ApiResponse.ok(res);
    }

    @PutMapping("/community/product/{id}")
    public ApiResponse updateProduct(@PathVariable(value = "id") Integer prdtSeq, @RequestBody RequestCmntPrdt request) {
        CmntPrdt res = cmntPrdtService.updateCmntPrdt(prdtSeq, request);
        return ApiResponse.ok(res);
    }

    @DeleteMapping("/community/product/{id}")
    public ApiResponse deleteProduct(@PathVariable(value = "id") Integer prdtSeq) {
        cmntPrdtService.delete(prdtSeq);
        return ApiResponse.ok(ImmutableMap.of("deleted", Boolean.TRUE));
    }


    @PostMapping("/community/product/comment")
    public ApiResponse createProductComment(@RequestBody RequestCmntPrdtComment request) {
        CmntPrdtComment res = cmntPrdtService.createCmntPrdtComment(request);
        log.debug("res: {}", JsonUtils.toString(res));
        return ApiResponse.ok(res);
    }

    @GetMapping("/community/product/comments/{prdtSeq}")
    public ApiResponse createProductComments(@PathVariable(value = "prdtSeq") Integer prdtSeq) {
        List<CmntPrdtCommentProjection> res = cmntPrdtService.getCmntPrdtComments(prdtSeq);
        log.info("comments: {}", JsonUtils.toPrettyString(res));
        return ApiResponse.ok(res);
    }

}
