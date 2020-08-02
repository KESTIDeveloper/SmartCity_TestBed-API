package co.kesti.smartcity.api.community.vo;

import java.util.List;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 커뮤니티 > 포럼 소개 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CmntFrumIntrVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 포럼그룹목록 */
    private List<CmntFrumGrpVo> frumGrpList;

    /* 포럼추천목록 */
    private List<CmntFrumVo> frumRcmdList;

    /* 포럼인기목록 */
    private List<CmntFrumVo> frumHitList;

}
