package co.kesti.smartcity.api.community.service;

import java.util.List;

import co.kesti.smartcity.api.community.vo.CmntUpldReqVo;
import co.kesti.smartcity.api.community.vo.CmntUpldVo;

/**
 * 커뮤니티 > 자료실 서비스
 * @author atom
 * @since 2020.07.25
 */
public interface CommunityUploadService {

    /**
     * 자료실 목록 조회
     * @param param
     * @return
     */
    public List<CmntUpldVo> selectUpldList(CmntUpldReqVo param);

    /**
     * 자료실 읽기 정보 조회
     * @param param
     * @return
     */
    public CmntUpldVo selectUpldReadInfo(CmntUpldVo param);

}
