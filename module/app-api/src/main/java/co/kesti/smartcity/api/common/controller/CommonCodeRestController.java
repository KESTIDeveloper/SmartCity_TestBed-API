package co.kesti.smartcity.api.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.kesti.smartcity.api.common.service.CommonCodeService;
import co.kesti.smartcity.api.common.vo.ComCdVo;
import co.kesti.smartcity.model.response.ApiResponse;

/**
 * 공통코드 컨트롤러
 * @author atom
 * @since 2020.08.05
 */
@RestController
@RequestMapping("/TESTBED/v0.9/api/common/code")
public class CommonCodeRestController {

    @Autowired
    private CommonCodeService commonCodeService;

    /**
     * 공통 코드 목록 조회
     * @param cdGroupId
     * @return
     */
    @GetMapping("/selectComCdList")
    public ApiResponse<?> selectComCdList(@RequestParam(value="cdGroupId", required=true) String cdGroupId) {
        List<ComCdVo> resList = commonCodeService.selectComCdList(cdGroupId);

        return ApiResponse.ok(resList);
    }

}
