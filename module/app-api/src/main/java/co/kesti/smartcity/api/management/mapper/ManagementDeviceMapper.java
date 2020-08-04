package co.kesti.smartcity.api.management.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.kesti.smartcity.api.management.vo.MgmtDevCdVo;
import co.kesti.smartcity.api.management.vo.MgmtDevObsCdVo;

/**
 * 관리 > 디바이스 맵퍼
 * @author atom
 * @since 2020.08.02
 */
@Mapper
public interface ManagementDeviceMapper {

    /**
     * 디바이스 코드 목록 조회
     */
    public List<MgmtDevCdVo> selectDevCdList(@Param("mbrSeq") Long mbrSeq);

    /**
     * 비교 디바이스 코드 목록 조회
     */
    public List<MgmtDevCdVo> selectCmprDevCdList(@Param("devId") String devId);

    /**
     * 디바이스 측정 코드 목록 조회
     */
    public List<MgmtDevObsCdVo> selectDevObsCdList(@Param("devId") String devId);

}
