package co.kesti.smartcity.api.management.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.kesti.smartcity.api.management.vo.MgmtEvtDelReqVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtLogReqVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtLogVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtObsVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtReqVo;
import co.kesti.smartcity.api.management.vo.MgmtEvtVo;

/**
 * 관리 > 이벤트 맵퍼
 * @author atom
 * @since 2020.07.31
 */
@Mapper
public interface ManagementEventMapper {

    /**
     * 이벤트 정보 조회
     */
    public MgmtEvtVo selectEvtInfo(@Param("evntId") String evntId, @Param("mbrSeq") Long mbrSeq);

    /**
     * 이벤트 건수 조회
     */
    public int selectEvtCount(MgmtEvtReqVo param);

    /**
     * 이벤트 목록 조회
     */
    public List<MgmtEvtVo> selectEvtList(MgmtEvtReqVo param);

    /**
     * 이벤트 등록
     */
    public int insertEvt(MgmtEvtVo param);

    /**
     * 이벤트 수정
     */
    public int updateEvt(MgmtEvtVo param);

    /**
     * 이벤트 상태 여부 수정
     */
    public int updateEvtStatYn(MgmtEvtVo param);

    /**
     * 이벤트 삭제
     */
    public int deleteEvt(MgmtEvtDelReqVo param);

    /**
     * 이벤트 멀티 삭제
     */
    public int deleteEvtMulti(MgmtEvtDelReqVo param);

    /**
     * 이벤트 측정 목록 조회
     */
    public List<MgmtEvtObsVo> selectEvtObsList(@Param("evntId") String evntId);

    /**
     * 이벤트 측정 등록
     */
    public int insertEvtObs(MgmtEvtObsVo param);

    /**
     * 이벤트 측정 전체 삭제
     */
    public int deleteEvtObsAll(@Param("evntId") String evntId);

    /**
     * 이벤트 로그 건수 조회
     */
    public int selectEvtLogCount(MgmtEvtLogReqVo param);

    /**
     * 이벤트 로그 목록 조회
     */
    public List<MgmtEvtLogVo> selectEvtLogList(MgmtEvtLogReqVo param);

}
