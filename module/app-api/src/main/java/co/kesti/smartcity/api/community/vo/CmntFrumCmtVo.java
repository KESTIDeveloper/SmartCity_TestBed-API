package co.kesti.smartcity.api.community.vo;

import co.kesti.smartcity.api.common.vo.BaseParamVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 커뮤니티 > 포럼 코멘트 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CmntFrumCmtVo extends BaseParamVo {

    private static final long serialVersionUID = 1L;

    /* 포럼댓글순번 */
    private Long  forumCommentSeq;

    /* 포럼그룹순번 */
    private Long forumGroupSeq;

    /* 포럼순번 */
    private Long forumSeq;

    /* 부모댓글 */
    private Long forumCommentParent;

    /* 댓글내용 */
    private String forumCommentContent;

    /* 좋아요수 */
    private Integer likeCnt;

    /* 싫어요수 */
    private Integer dislikeCnt;

    /* 아이피주소 */
    private String ipAdress;

    /* 삭제여부 */
    private String delYn;

}
