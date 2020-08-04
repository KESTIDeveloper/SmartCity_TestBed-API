package co.kesti.smartcity.api.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kesti.smartcity.api.management.mapper.ManagementDeviceMapper;
import co.kesti.smartcity.api.management.vo.MgmtDevCdVo;
import co.kesti.smartcity.api.management.vo.MgmtDevObsCdVo;

/**
 * 관리 > 디바이스 서비스 구현
 * @author atom
 * @since 2020.08.02
 */
@Service
public class ManagementDeviceServiceImpl implements ManagementDeviceService {

    @Autowired
    private ManagementDeviceMapper managementDeviceMapper;

    /**
     * 디바이스 코드 목록 조회
     */
    @Override
    public List<MgmtDevCdVo> selectDevCdList(Long mbrSeq) {
        return managementDeviceMapper.selectDevCdList(mbrSeq);
    }

    /**
     * 비교 디바이스 코드 목록 조회
     */
    @Override
    public List<MgmtDevCdVo> selectCmprDevCdList(String devId) {
        return managementDeviceMapper.selectCmprDevCdList(devId);
    }

    /**
     * 디바이스 측정 코드 목록 조회
     */
    @Override
    public List<MgmtDevObsCdVo> selectDevObsCdList(String devId) {
        return managementDeviceMapper.selectDevObsCdList(devId);
    }

}
