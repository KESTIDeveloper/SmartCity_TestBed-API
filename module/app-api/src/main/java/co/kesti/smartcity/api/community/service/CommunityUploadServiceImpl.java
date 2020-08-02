package co.kesti.smartcity.api.community.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kesti.smartcity.api.community.mapper.CommunityUploadMapper;
import co.kesti.smartcity.api.community.vo.CmntUpldReqVo;
import co.kesti.smartcity.api.community.vo.CmntUpldVo;
import co.kesti.smartcity.error.UserException;

/**
 * 커뮤니티 > 자료실 서비스 구현
 * @author atom
 * @since 2020.07.23
 */
@Service
public class CommunityUploadServiceImpl implements CommunityUploadService {

    @Autowired
    private CommunityUploadMapper communityUploadMapper;

    /**
     * 자료실 목록 조회
     */
    @Override
    public List<CmntUpldVo> selectUpldList(CmntUpldReqVo param) {
        // 자료실 건수 조회
        int upldCnt = communityUploadMapper.selectUpldCount(param);
        param.setTotCnt(upldCnt);

        // 자료실 목록 조회
        List<CmntUpldVo> upldList = new ArrayList<>();

        if (upldCnt > 0) {
            upldList = communityUploadMapper.selectUpldList(param);
        }

        return upldList;
    }

    /**
     * 자료실 읽기 정보 조회
     */
    @Override
    public CmntUpldVo selectUpldReadInfo(CmntUpldVo param) {
        // 자료실순번
        Long uploadSeq = param.getUploadSeq();

        // 자료실 정보 조회
        CmntUpldVo upldInfo = communityUploadMapper.selectUpldInfo(uploadSeq);

        if (upldInfo == null) {
            throw new UserException("자료실정보가 존재하지 않습니다.");
        }

        // 자료실 이전 정보 조회
        CmntUpldVo prevInfo = communityUploadMapper.selectUpldPrevInfo(uploadSeq);

        if (prevInfo != null) {
            upldInfo.setPrevSeq(prevInfo.getUploadSeq());
            upldInfo.setPrevTit(prevInfo.getUploadTitle());
        }

        // 자료실 다음 정보 조회
        CmntUpldVo nextInfo = communityUploadMapper.selectUpldNextInfo(uploadSeq);

        if (nextInfo != null) {
            upldInfo.setNextSeq(nextInfo.getUploadSeq());
            upldInfo.setNextTit(nextInfo.getUploadTitle());
        }

        // 회원아이디
        String mbrId = StringUtils.trimToEmpty(param.getMbrId());

        // 조회수 더하기
        if (StringUtils.isNotEmpty(mbrId) && !mbrId.equals(upldInfo.getCretrId())) {
            communityUploadMapper.updateUpldHitCntPlus(param);
        }

        return upldInfo;
    }

}
