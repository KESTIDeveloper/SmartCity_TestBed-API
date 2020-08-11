package co.kesti.smartcity.api.member.vo;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 회원 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ComMbrVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 회원순번 */
    private Long mbrSeq;

    /* 회원ID */
    private String mbrId;

    /* 사용자명 */
    private String userNm;

    /* 비밀번호 */
    private String mbrPwd;

    /* 이메일 */
    private String email;

    /* 전화번호 */
    private String mphonNo;

    /* 이메일수신여부 */
    private String emailRecptnYn;

    /* SMS수신여부 */
    private String smsRecptnYn;

    /* 회원등급 */
    private String mbrClas;

    /* 사용자토큰 */
    private String userTokn;

    /* 삭제여부 */
    private String delYn;

    /* IP주소 */
    private String ipAddress;

    /* 회원비밀번호신규 */
    private String mbrPwdNew;

    /* 비밀번호변경일 */
    private String chgPwdDt;

    /* 임시비밀번호발급여부 */
    private String tmpPwdIssYn;

    /* 비고 */
    private String rmark;

    /* 로그인실패횟수 */
    private Integer loginFailTmscnt;

    /* 국가이름 */
    private String countryName;


    /**
     * 추가 정보
     */
    /* 인증키 */
    private String authKey;

}
