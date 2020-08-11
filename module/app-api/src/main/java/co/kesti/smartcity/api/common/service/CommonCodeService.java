package co.kesti.smartcity.api.common.service;

import java.util.List;

import co.kesti.smartcity.api.common.vo.ComCdVo;

/**
 * 공통코드 서비스
 * @author atom
 * @since 2020.08.05
 */
public interface CommonCodeService {

    /**
     * 공통 코드 목록 조회
     * @param cdGroupId
     * @return
     */
    public List<ComCdVo> selectComCdList(String cdGroupId);

}
