package co.kesti.smartcity.api.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.kesti.smartcity.api.community.service.CommunityNoticeService;
import co.kesti.smartcity.api.community.vo.CmntNotiReqVo;
import co.kesti.smartcity.api.community.vo.CmntNotiVo;
import co.kesti.smartcity.model.response.ApiResponse;

/**
 * 커뮤니티 > 공지사항 컨트롤러
 * @author atom
 * @since 2020.07.23
 */
@RestController
@RequestMapping("/TESTBED/v0.9/api/community/notice")
public class CommunityNoticeRestController {

    @Autowired
    private CommunityNoticeService communityNoticeService;

    /**
     * 공지사항 목록 조회
     * @param param
     * @return
     */
    @GetMapping("/selectNotiList")
    public ApiResponse<?> selectNotiList(CmntNotiReqVo param) {
        List<CmntNotiVo> resList = communityNoticeService.selectNotiList(param);

        return ApiResponse.ok(resList, param);
    }

    /**
     * 공지사항 읽기 정보 조회
     * @param param
     * @return
     */
    @GetMapping("/selectNotiReadInfo")
    public ApiResponse<?> selectNotiReadInfo(CmntNotiVo param) {
        CmntNotiVo resInfo = communityNoticeService.selectNotiReadInfo(param);

        return ApiResponse.ok(resInfo);
    }

    /**
     * 공지사항 추천 처리
     * @param param
     * @return
     */
    @PostMapping("/procNotiRcmd")
    public ApiResponse<?> procNotiRcmd(CmntNotiVo param) {
        communityNoticeService.procNotiRcmd(param);

        return ApiResponse.ok();
    }

}
