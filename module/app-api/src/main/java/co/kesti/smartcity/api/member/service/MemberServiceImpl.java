package co.kesti.smartcity.api.member.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.kesti.smartcity.api.member.mapper.MemberMapper;
import co.kesti.smartcity.api.member.vo.ComMbrVo;
import co.kesti.smartcity.define.Define;
import co.kesti.smartcity.error.UserException;
import co.kesti.smartcity.error.UserOkException;
import co.kesti.smartcity.service.HttpClientTemplate;

/**
 * 회원 서비스 구현
 * @author atom
 * @since 2020.07.16
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpClientTemplate httpClientTemplate;

    /**
     * 회원 정보 조회
     */
    @Override
    public ComMbrVo selectMbrInfo(String mbrId, String pwdYn) {
        // 회원 정보 조회
        ComMbrVo mbrInfo = memberMapper.selectMbrInfo(mbrId);

        if (mbrInfo == null) {
            throw new UserException("회원정보가 존재하지 않습니다.");
        }

        // 비밀번호 초기화
        if (!Define.YES.equals(pwdYn)) {
            mbrInfo.setMbrPwd(Define.EMPTY);
        }

        return mbrInfo;
    }

    /**
     * 회원 체크 여부 조회
     */
    @Override
    public boolean selectMbrChkYn(ComMbrVo param) {
        // 회원 체크 정보 조회
        ComMbrVo mbrInfo = memberMapper.selectMbrChkInfo(param);

        if (mbrInfo == null) {
            throw new UserOkException("회원정보가 존재하지 않습니다.");
        }

        return true;
    }

    /**
     * 회원 중복 건수 조회
     */
    @Override
    public int selectMbrDupCount(String mbrId) {
        return memberMapper.selectMbrDupCount(mbrId);
    }

    /**
     * 회원 등록
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertMbr(ComMbrVo param) {
        // 회원 중복  건수 조회
        int dupCnt = memberMapper.selectMbrDupCount(param.getMbrId());

        if (dupCnt > 0) {
            throw new UserException("사용중인 아이디입니다.");
        }

        // 비밀번호 암호화
        param.setMbrPwd(passwordEncoder.encode(param.getMbrPwd()));

        // 회원등급
        param.setMbrClas(Define.CODE_0003);
        param.setUserTokn(Define.EMPTY);

        // 국가이름
        if (StringUtils.isNotBlank(param.getIpAddress())) {
            String countryName = this.getCountry(param.getIpAddress());
            param.setCountryName(countryName);
        }

        // 회원 등록
        memberMapper.insertMbr(param);
    }

    /**
     * 회원 수정
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateMbr(ComMbrVo param) {
        // 회원 정보 조회
        ComMbrVo mbrInfo = memberMapper.selectMbrInfo(param.getMbrId());

        if (mbrInfo == null) {
            throw new UserException("회원정보가 존재하지 않습니다.");
        }

        // 비밀번호 암호화
        if (StringUtils.isNotBlank(param.getMbrPwd())) {
            param.setMbrPwd(passwordEncoder.encode(param.getMbrPwd()));
        }

        // 회원 수정
        memberMapper.updateMbr(param);
    }

    /**
     * 로그인 실패 건수 더하기 수정
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateLognFailCntPlus(String mbrId) {
        memberMapper.updateLognFailCntPlus(mbrId);
    }

    /**
     * 로그인 실패 건수 초기화 수정
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateLognFailCntReset(String mbrId) {
        memberMapper.updateLognFailCntReset(mbrId);
    }

    /**
     * 회원 아이디 찾기
     */
    @Override
    public ComMbrVo findMbrId(ComMbrVo param) {
        // 회원 체크 정보 조회
        ComMbrVo mbrInfo = memberMapper.selectMbrChkInfo(param);

        if (mbrInfo == null) {
            throw new UserOkException("회원정보가 존재하지 않습니다.");
        }

        return mbrInfo;
    }

    /**
     * 회원 비밀번호 찾기
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ComMbrVo findMbrPwd(ComMbrVo param) {
        // 회원 체크 정보 조회
        ComMbrVo mbrInfo = memberMapper.selectMbrChkInfo(param);

        if (mbrInfo == null) {
            throw new UserOkException("회원정보가 존재하지 않습니다.");
        }

        // 회원 인증키 수정
        memberMapper.updateMbrAuthKey(mbrInfo.getMbrId(), param.getAuthKey());

        return mbrInfo;
    }

    /**
     * 회원 비밀번호 수정
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateMbrPwd(String mbrId, String mbrPWd, String authKey) {
        // 회원ID 체크
        if (StringUtils.isBlank(mbrId)) {
            throw new UserOkException("회원 아이디는 필수 항목입니다.");
        }

        // 비밀번호 체크
        if (StringUtils.isBlank(mbrPWd)) {
            throw new UserOkException("비밀번호는 필수 항목입니다.");
        }

        // 인증키 체크
        if (StringUtils.isBlank(authKey)) {
            throw new UserOkException("인증키는 필수 항목입니다.");
        }

        memberMapper.updateMbrPwd(mbrId, passwordEncoder.encode(mbrPWd), authKey);
    }

    /**
     * 회원 삭제
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteMbr(String mbrId) {
        memberMapper.deleteMbr(mbrId);
    }

    /**
     * ip로 국가정보 알아오기
     */
    private String getCountry(String ip) {
        String response = httpClientTemplate.get("http://ip2c.org/"+ip, String.class);
        String[] data = StringUtils.split(response, ";");

        if (data.length >=3) {
            return String.format("%s;%s", data[1], data[2]);
        } else {
            return "";
        }
    }

}
