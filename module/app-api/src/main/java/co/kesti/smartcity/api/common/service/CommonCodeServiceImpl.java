package co.kesti.smartcity.api.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kesti.smartcity.api.common.mapper.CommonCodeMapper;
import co.kesti.smartcity.api.common.vo.ComCdVo;

/**
 * 공통코드 서비스 구현
 * @author atom
 * @since 2020.08.05
 */
@Service
public class CommonCodeServiceImpl implements CommonCodeService {

    @Autowired
    private CommonCodeMapper commonCodeMapper;

    /**
     * 공통 코드 목록 조회
     */
    @Override
    public List<ComCdVo> selectComCdList(String cdGroupId) {
        return commonCodeMapper.selectComCdList(cdGroupId);
    }

}
