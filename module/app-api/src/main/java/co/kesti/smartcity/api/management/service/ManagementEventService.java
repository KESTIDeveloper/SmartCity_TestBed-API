package co.kesti.smartcity.api.management.service;

import java.util.List;

import co.kesti.smartcity.api.management.vo.MgmtEvtDelReqVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtDtlVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtLogReqVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtLogVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtReadVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtReqVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtVo;

/**
 * 관리 > 이벤트 서비스
 * @author atom
 * @since 2020.07.31
 */
public interface ManagementEventService {

    /**
     * 이벤트 목록 조회
     * @param param
     * @return
     */
    public List<MgmtEvtVo> selectEvtList(MgmtEvtReqVo param);

    /**
     * 이벤트 읽기 정보 조회
     * @param param
     * @return
     */
    public MgmtEvtReadVo selectEvtReadInfo(MgmtEvtVo param);

    /**
     * 이벤트 상세 정보 조회
     * @param param
     * @return
     */
    public MgmtEvtDtlVo selectEvtDtlInfo(MgmtEvtVo param);

    /**
     * 이벤트 저장
     * @param param
     */
    public void saveEvt(MgmtEvtDtlVo param);

    /**
     * 이벤트 상태 여부 수정
     * @param param
     */
    public void updateEvtStatYn(MgmtEvtVo param);

    /**
     * 이벤트 삭제
     * @param param
     */
    public void deleteEvt(MgmtEvtDelReqVo param);

    /**
     * 이벤트 멀티 삭제
     * @param param
     */
    public void deleteEvtMulti(MgmtEvtDelReqVo param);

    /**
     * 이벤트 로그 목록 조회
     * @param param
     * @return
     */
    public List<MgmtEvtLogVo> selectEvtLogList(MgmtEvtLogReqVo param);

}
