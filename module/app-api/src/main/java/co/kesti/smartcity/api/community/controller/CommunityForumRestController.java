package co.kesti.smartcity.api.community.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.kesti.smartcity.api.community.service.CommunityForumService;
import co.kesti.smartcity.api.community.vo.CmntFrumCmtVo;
import co.kesti.smartcity.api.community.vo.CmntFrumGrpVo;
import co.kesti.smartcity.api.community.vo.CmntFrumIntrVo;
import co.kesti.smartcity.api.community.vo.CmntFrumReqVo;
import co.kesti.smartcity.api.community.vo.CmntFrumVo;
import co.kesti.smartcity.model.response.ApiResponse;

/**
 * 커뮤니티 > 포럼 컨트롤러
 * @author atom
 * @since 2020.07.20
 */
@RestController
@RequestMapping("/TESTBED/v0.9/api/community/forum")
public class CommunityForumRestController {

    @Autowired
    private CommunityForumService communityForumService;

    /**
     * 포럼 소개 정보 조회
     * @return
     */
    @GetMapping("/selectFrumIntrInfo")
    public ApiResponse<?> selectFrumIntrInfo() {
        CmntFrumIntrVo resInfo = communityForumService.selectFrumIntrInfo();

        return ApiResponse.ok(resInfo);
    }

    /**
     * 포럼 그룹 정보 조회
     * @param forumGroupSeq
     * @return
     */
    @GetMapping("/selectFrumGrpInfo")
    public ApiResponse<?> selectFrumGrpInfo(@RequestParam(value="forumGroupSeq", required=true) Long forumGroupSeq) {
        CmntFrumGrpVo resInfo = communityForumService.selectFrumGrpInfo(forumGroupSeq);

        return ApiResponse.ok(resInfo);
    }

    /**
     * 포럼 읽기 정보 조회
     * @param param
     * @return
     */
    @GetMapping("/selectFrumReadInfo")
    public ApiResponse<?> selectFrumReadInfo(CmntFrumVo param) {
        CmntFrumVo resInfo = communityForumService.selectFrumReadInfo(param);

        return ApiResponse.ok(resInfo);
    }

    /**
     * 포럼 수정 정보 조회
     * @param param
     * @return
     */
    @GetMapping("/selectFrumUptInfo")
    public ApiResponse<?> selectFrumUptInfo(CmntFrumVo param) {
        CmntFrumVo resInfo = communityForumService.selectFrumUptInfo(param);

        return ApiResponse.ok(resInfo);
    }

    /**
     * 포럼 목록 조회
     * @param param
     * @return
     */
    @GetMapping("/selectFrumList")
    public ApiResponse<?> selectFrumList(CmntFrumReqVo param) {
        List<CmntFrumVo> resList = communityForumService.selectFrumList(param);

        return ApiResponse.ok(resList, param);
    }

    /**
     * 포럼 저장
     * @param param
     * @return
     */
    @PostMapping("/saveFrum")
    public ApiResponse<?> saveFrum(@RequestBody CmntFrumVo param) {
        communityForumService.saveFrum(param);

        return ApiResponse.ok();
    }

    /**
     * 포럼 삭제
     * @param param
     * @return
     */
    @PostMapping("/deleteFrum")
    public ApiResponse<?> deleteFrum(CmntFrumVo param) {
        communityForumService.deleteFrum(param);

        return ApiResponse.ok();
    }

    /**
     * 포럼 추천 처리
     * @param param
     * @return
     */
    @PostMapping("/procFrumRcmd")
    public ApiResponse<?> procFrumRcmd(CmntFrumVo param) {
        communityForumService.procFrumRcmd(param);

        return ApiResponse.ok();
    }

    /**
     * 포럼 코멘트 목록 조회
     * @param forumGroupSeq
     * @param forumSeq
     * @return
     */
    @GetMapping("/selectFrumCmtList")
    public ApiResponse<?> selectFrumCmtList(@RequestParam(value="forumGroupSeq", required=true) Long forumGroupSeq,
            @RequestParam(value="forumSeq", required=true) Long forumSeq) {
        List<CmntFrumCmtVo> resList = communityForumService.selectFrumCmtList(forumGroupSeq, forumSeq);

        return ApiResponse.ok(resList);
    }

    /**
     * 포럼 코멘트 등록
     * @param param
     * @return
     */
    @PostMapping("/insertFrumCmt")
    public ApiResponse<?> insertFrumCmt(CmntFrumCmtVo param, HttpServletRequest request) {
        param.setIpAdress(request.getRemoteAddr());
        communityForumService.insertFrumCmt(param);

        return ApiResponse.ok();
    }

}
