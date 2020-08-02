package co.kesti.smartcity.api.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.kesti.smartcity.api.member.service.MemberService;
import co.kesti.smartcity.api.member.vo.ComMbrVo;
import co.kesti.smartcity.model.response.ApiResponse;

/**
 * 회원 컨트롤러
 * @author atom
 * @since 2020.07.16
 */
@RestController
@RequestMapping("/TESTBED/v0.9/api/member")
public class MemberRestController {

    @Autowired
    private MemberService memberService;

    /**
     * 회원 정보 조회
     * @param mbrId
     * @return
     */
    @PostMapping("/selectMbrInfo")
    public ApiResponse<?> selectMbrInfo(@RequestParam(value="mbrId", required=true) String mbrId, @RequestParam(value="pwdYn", required=false) String pwdYn) {
        ComMbrVo resInfo = memberService.selectMbrInfo(mbrId, pwdYn);

        return ApiResponse.ok(resInfo);
    }

    /**
     * 회원 중복 건수 조회
     * @param mbrId
     * @return
     */
    @GetMapping("/selectMbrDupCount")
    public ApiResponse<?> selectMbrDupCount(@RequestParam(value="mbrId", required=true) String mbrId) {
        int dupCnt = memberService.selectMbrDupCount(mbrId);

        return ApiResponse.ok(dupCnt);
    }

    /**
     * 회원 등록
     * @param param
     * @param request
     * @return
     */
    @PostMapping("/insertMbr")
    public ApiResponse<?> insertMbr(ComMbrVo param, HttpServletRequest request) {
        param.setIpAddress(request.getRemoteAddr());
        memberService.insertMbr(param);

        return ApiResponse.ok();
    }

    /**
     * 회원 수정
     * @param param
     * @return
     */
    @PostMapping("/updateMbr")
    public ApiResponse<?> updateMbr(ComMbrVo param) {
        memberService.updateMbr(param);

        return ApiResponse.ok();
    }

    /**
     * 로그인 실패 건수 더하기 수정
     * @param mbrId
     * @return
     */
    @PostMapping("/updateLognFailCntPlus")
    public ApiResponse<?> updateLognFailCntPlus(@RequestParam(value="mbrId", required=true) String mbrId) {
        memberService.updateLognFailCntPlus(mbrId);

        return ApiResponse.ok();
    }

    /**
     * 로그인 실패 건수 초기화 수정
     * @param mbrId
     * @return
     */
    @PostMapping("/updateLognFailCntReset")
    public ApiResponse<?> updateLognFailCntReset(@RequestParam(value="mbrId", required=true) String mbrId) {
        memberService.updateLognFailCntReset(mbrId);

        return ApiResponse.ok();
    }

    /**
     * 회원 삭제
     * @param mbrId
     * @return
     */
    @PostMapping("/deleteMbr")
    public ApiResponse<?> deleteMbr(@RequestParam(value="mbrId", required=true) String mbrId) {
        memberService.deleteMbr(mbrId);

        return ApiResponse.ok();
    }

}
