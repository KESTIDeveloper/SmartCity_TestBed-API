package co.kesti.smartcity.api.community.vo;

import co.kesti.smartcity.api.common.vo.BaseParamVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 커뮤니티 > 포럼 그룹 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CmntFrumGrpVo extends BaseParamVo {

    private static final long serialVersionUID = 1L;

    /* 포럼그룹일련번호 */
    private Long forumGroupSeq;

    /* 포럼그룹주제 */
    private String forumGroupTitle;

    /* 포럼그룹내용 */
    private String forumGroupContents;

    /* 포럼그룹이미지경로 */
    private String forumGroupImgPath;

    /* 삭제여부 */
    private String delYn;

}
