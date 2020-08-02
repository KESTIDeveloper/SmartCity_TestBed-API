package co.kesti.smartcity.api.community.vo;

import co.kesti.smartcity.api.common.vo.BaseParamVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 커뮤니티 > 포럼 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CmntFrumVo extends BaseParamVo {

    private static final long serialVersionUID = 1L;

    /* 포럼그룹일련번호 */
    private Long forumGroupSeq;

    /* 포럼일련번호 */
    private Long forumSeq;

    /* 포럼주제 */
    private String forumTitle;

    /* 포럼내용 */
    private String forumContents;

    /* 첨부파일경로 */
    private String attachedFilePath;

    /* 조회수 */
    private Integer hitCnt;

    /* 추천수 */
    private Integer recmdCnt;

    /* 삭제여부 */
    private String delYn;

    /* 코멘트수 */
    private Integer cmtCnt;

}
