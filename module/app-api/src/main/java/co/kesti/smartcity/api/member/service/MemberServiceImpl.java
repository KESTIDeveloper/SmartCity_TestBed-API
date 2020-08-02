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

        // 회원 등록
        param.setMbrClas(Define.CODE_0003);
        param.setUserTokn(Define.EMPTY);
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
     * 회원 삭제
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteMbr(String mbrId) {
        memberMapper.deleteMbr(mbrId);
    }

}
