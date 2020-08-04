package co.kesti.smartcity.api.management.service;

import java.util.List;

import co.kesti.smartcity.api.management.vo.MgmtDevCdVo;
import co.kesti.smartcity.api.management.vo.MgmtDevObsCdVo;

/**
 * 관리 > 디바이스 서비스
 * @author atom
 * @since 2020.08.02
 */
public interface ManagementDeviceService {

    /**
     * 디바이스 코드 목록 조회
     * @param mbrSeq
     * @return
     */
    public List<MgmtDevCdVo> selectDevCdList(Long mbrSeq);

    /**
     * 비교 디바이스 코드 목록 조회
     * @param devId
     * @return
     */
    public List<MgmtDevCdVo> selectCmprDevCdList(String devId);

    /**
     * 디바이스 측정 코드 목록 조회
     * @param devId
     * @return
     */
    public List<MgmtDevObsCdVo> selectDevObsCdList(String devId);

}
