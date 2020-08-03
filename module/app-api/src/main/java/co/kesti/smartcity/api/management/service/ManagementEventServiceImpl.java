package co.kesti.smartcity.api.management.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.kesti.smartcity.api.management.mapper.ManagementEventMapper;
import co.kesti.smartcity.api.management.vo.MgmtEvtDelReqVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtDtlVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtLogVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtObsVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtReadVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtReqVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtVo;
import co.kesti.smartcity.define.Define;
import co.kesti.smartcity.error.UserException;

/**
 * 관리 > 이벤트 서비스 구현
 * @author atom
 * @since 2020.07.31
 */
@Service
public class ManagementEventServiceImpl implements ManagementEventService {

    @Autowired
    private ManagementEventMapper managementEventMapper;

    /**
     * 이벤트 목록 조회
     */
    @Override
    public List<MgmtEvtVo> selectEvtList(MgmtEvtReqVo param) {
        // 회원 유효성 체크
        if (param.getMbrSeq() == null) {
            throw new UserException("회원정보는 필수 항목입니다.");
        }

        // 이벤트 건수 조회
        int evtCnt = managementEventMapper.selectEvtCount(param);
        param.setTotCnt(evtCnt);

        // 이벤트 목록 조회
        List<MgmtEvtVo> evtList = new ArrayList<>();

        if (evtCnt > 0) {
            evtList = managementEventMapper.selectEvtList(param);
        }

        return evtList;
    }

    /**
     * 이벤트 읽기 정보 조회
     */
    @Override
    public MgmtEvtReadVo selectEvtReadInfo(MgmtEvtVo param) {
        // 회원 유효성 체크
        if (param.getMbrSeq() == null) {
            throw new UserException("회원정보는 필수 항목입니다.");
        }

        // 이벤트ID
        String evntId = StringUtils.trimToEmpty(param.getEvntId());

        // 이벤트 정보 조회
        MgmtEvtVo evtInfo = managementEventMapper.selectEvtInfo(evntId, param.getMbrSeq());

        if (evtInfo == null) {
            throw new UserException("이벤트정보가 존재하지 않습니다.");
        }

        // 이벤트 측정 목록 조회
        List<MgmtEvtObsVo> obsList = managementEventMapper.selectEvtObsList(evntId);

        // 이벤트 로그 목록 조회
        List<MgmtEvtLogVo> logList = managementEventMapper.selectEvtLogList(evntId);

        // 결과값 설정
        MgmtEvtReadVo resultVo = new MgmtEvtReadVo();
        resultVo.setEvtInfo(evtInfo);
        resultVo.setObsList(obsList);
        resultVo.setLogList(logList);

        return resultVo;
    }

    /**
     * 이벤트 상세 정보 조회
     */
    @Override
    public MgmtEvtDtlVo selectEvtDtlInfo(MgmtEvtVo param) {
        // 회원 유효성 체크
        if (param.getMbrSeq() == null) {
            throw new UserException("회원정보는 필수 항목입니다.");
        }

        // 이벤트ID
        String evntId = StringUtils.trimToEmpty(param.getEvntId());

        // 이벤트 정보 조회
        MgmtEvtVo evtInfo = managementEventMapper.selectEvtInfo(evntId, param.getMbrSeq());

        if (evtInfo == null) {
            throw new UserException("이벤트정보가 존재하지 않습니다.");
        }

        // 이벤트 측정 목록 조회
        List<MgmtEvtObsVo> obsList = managementEventMapper.selectEvtObsList(evntId);

        // 결과값 설정
        MgmtEvtDtlVo resultVo = new MgmtEvtDtlVo();
        resultVo.setEvtInfo(evtInfo);
        resultVo.setObsList(obsList);

        return resultVo;
    }

    /**
     * 이벤트 저장
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveEvt(MgmtEvtDtlVo param) {
        // 회원 유효성 체크
        if (param.getMbrSeq() == null || StringUtils.isBlank(param.getMbrId())) {
            throw new UserException("회원정보는 필수 항목입니다.");
        }

        // 이벤트 정보
        MgmtEvtVo evtVo = param.getEvtInfo();

        if (evtVo == null) {
            throw new UserException("이벤트정보가 존재하지 않습니다.");
        }

        // 이벤트발생구분 - 디바이스연결상태
        if (Define.CODE_A.equals(evtVo.getEvntOccrDiv())) {
            evtVo.setAndOrCode(Define.EMPTY);
            param.setObsList(null);

        // 디바이스측정
        } else {
            evtVo.setEvntOccrCondDiv(Define.EMPTY);
            evtVo.setEvntOccrCondVal(Define.EMPTY);
        }

        // 회원정보
        evtVo.setMbrSeq(param.getMbrSeq());
        evtVo.setMbrId(param.getMbrId());

        // 이벤트ID
        String evntId = evtVo.getEvntId();

        // 등록
        if (Define.Mode.CREATE.equals(param.getMode())) {
            // 이벤트 등록
            evtVo.setStatus(Define.CODE_ON);
            managementEventMapper.insertEvt(evtVo);

            // 이벤트ID
            evntId = evtVo.getEvntId();

        // 수정
        } else {
            // 이벤트 정보 조회
            MgmtEvtVo evtInfo = managementEventMapper.selectEvtInfo(evntId, param.getMbrSeq());

            if (evtInfo == null) {
                throw new UserException("이벤트정보가 존재하지 않습니다.");
            }

            // 이벤트 수정
            managementEventMapper.updateEvt(evtVo);
        }

        // 이벤트 측정 전체 삭제
        managementEventMapper.deleteEvtObsAll(evntId);

        // 측정 목록
        List<MgmtEvtObsVo> obsList = param.getObsList();

        // 이벤트 측정 등록
        if (obsList != null && !obsList.isEmpty()) {
            for (MgmtEvtObsVo obsRow : obsList) {
                obsRow.setEvntId(evntId);
                managementEventMapper.insertEvtObs(obsRow);
            }
        }
    }

    /**
     * 이벤트 상태 여부 수정
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateEvtStatYn(MgmtEvtVo param) {
        // 회원 유효성 체크
        if (param.getMbrSeq() == null || StringUtils.isBlank(param.getMbrId())) {
            throw new UserException("회원정보는 필수 항목입니다.");
        }

        // 이벤트 상태 여부 수정
        managementEventMapper.updateEvtStatYn(param);
    }

    /**
     * 이벤트 삭제
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteEvt(MgmtEvtDelReqVo param) {
        // 회원 유효성 체크
        if (param.getMbrSeq() == null || StringUtils.isBlank(param.getMbrId())) {
            throw new UserException("회원정보는 필수 항목입니다.");
        }

        // 이벤트 삭제
        managementEventMapper.deleteEvt(param);
    }

    /**
     * 이벤트 멀티 삭제
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteEvtMulti(MgmtEvtDelReqVo param) {
        // 회원 유효성 체크
        if (param.getMbrSeq() == null || StringUtils.isBlank(param.getMbrId())) {
            throw new UserException("회원정보는 필수 항목입니다.");
        }

        // 이벤트 목록
        List<String> evtList = param.getEvtList();

        if (evtList == null || evtList.isEmpty()) {
            throw new UserException("이벤트 목록은 필수 항목입니다.");
        }

        // 이벤트 멀티 삭제
        managementEventMapper.deleteEvtMulti(param);
    }

}
