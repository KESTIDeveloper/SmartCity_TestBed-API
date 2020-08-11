package co.kesti.smartcity.api.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.kesti.smartcity.api.common.vo.ComCdVo;

/**
 * 공통코드 맵퍼
 * @author atom
 * @since 2020.08.05
 */
@Mapper
public interface CommonCodeMapper {

    /**
     * 공통 코드 목록 조회
     */
    public List<ComCdVo> selectComCdList(@Param("cdGroupId") String cdGroupId);

}
