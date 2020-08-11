package co.kesti.smartcity.api.member.service;

import co.kesti.smartcity.api.member.vo.ComMbrVo;

/**
 * 회원 서비스
 * @author atom
 * @since 2020.07.16
 */
public interface MemberService {

    /**
     * 회원 정보 조회
     * @param mbrId
     * @param pwdYn
     * @return
     */
    public ComMbrVo selectMbrInfo(String mbrId, String pwdYn);

    /**
     * 회원 체크 여부 조회
     * @param param
     * @return
     */
    public boolean selectMbrChkYn(ComMbrVo param);

    /**
     * 회원 중복 건수 조회
     * @param mbrId
     * @return
     */
    public int selectMbrDupCount(String mbrId);

    /**
     * 회원 등록
     * @param param
     */
    public void insertMbr(ComMbrVo param);

    /**
     * 회원 수정
     * @param param
     */
    public void updateMbr(ComMbrVo param);

    /**
     * 로그인 실패 건수 더하기 수정
     * @param mbrId
     */
    public void updateLognFailCntPlus(String mbrId);

    /**
     * 로그인 실패 건수 초기화 수정
     * @param mbrId
     */
    public void updateLognFailCntReset(String mbrId);

    /**
     * 회원 아이디 찾기
     * @param param
     * @return
     */
    public ComMbrVo findMbrId(ComMbrVo param);

    /**
     * 회원 비밀번호 찾기
     * @param param
     * @return
     */
    public ComMbrVo findMbrPwd(ComMbrVo param);

    /**
     * 회원 비밀번호 수정
     * @param mbrId
     * @param mbrPWd
     * @param authKey
     */
    public void updateMbrPwd(String mbrId, String mbrPWd, String authKey);

    /**
     * 회원 삭제
     * @param mbrId
     */
    public void deleteMbr(String mbrId);

}
