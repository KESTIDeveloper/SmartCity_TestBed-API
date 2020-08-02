package co.kesti.smartcity.api.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.kesti.smartcity.api.community.service.CommunityUploadService;
import co.kesti.smartcity.api.community.vo.CmntUpldReqVo;
import co.kesti.smartcity.api.community.vo.CmntUpldVo;
import co.kesti.smartcity.model.response.ApiResponse;

/**
 * 커뮤니티 > 자료실 컨트롤러
 * @author atom
 * @since 2020.07.25
 */
@RestController
@RequestMapping("/TESTBED/v0.9/api/community/upload")
public class CommunityUploadRestController {

    @Autowired
    private CommunityUploadService communityUploadService;

    /**
     * 자료실 목록 조회
     * @param param
     * @return
     */
    @GetMapping("/selectUpldList")
    public ApiResponse<?> selectUpldList(CmntUpldReqVo param) {
        List<CmntUpldVo> resList = communityUploadService.selectUpldList(param);

        return ApiResponse.ok(resList, param);
    }

    /**
     * 자료실 읽기 정보 조회
     * @param param
     * @return
     */
    @GetMapping("/selectUpldReadInfo")
    public ApiResponse<?> selectUpldReadInfo(CmntUpldVo param) {
        CmntUpldVo resInfo = communityUploadService.selectUpldReadInfo(param);

        return ApiResponse.ok(resInfo);
    }

}
