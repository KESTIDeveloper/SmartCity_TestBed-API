package co.kesti.smartcity.api.community.vo;

import co.kesti.smartcity.api.common.vo.BaseParamVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 커뮤니티 > 자료실 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CmntUpldVo extends BaseParamVo {

    private static final long serialVersionUID = 1L;

    /* 자료실순번 */
    private Long uploadSeq;

    /* 자료실주제 */
    private String uploadTitle;

    /* 자료실내용 */
    private String uploadContents;

    /* 첨부파일경로 */
    private String attachedFilePath;

    /* 조회수 */
    private Integer hitCnt;

    /* 추천수 */
    private Integer recmdCnt;

    /* 삭제여부 */
    private String delYn;

    /* 신규여부 */
    private String newYn;

    /* 이전순번 */
    private Long prevSeq;

    /* 이전타이틀 */
    private String prevTit;

    /* 다음순번 */
    private Long nextSeq;

    /* 다음타이틀 */
    private String nextTit;

}
