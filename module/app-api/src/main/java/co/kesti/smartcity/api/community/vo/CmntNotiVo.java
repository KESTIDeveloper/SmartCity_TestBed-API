package co.kesti.smartcity.api.community.vo;

import co.kesti.smartcity.api.common.vo.BaseParamVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 커뮤니티 > 공지사항 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CmntNotiVo extends BaseParamVo {

    private static final long serialVersionUID = 1L;

    /* 공지사항순번 */
    private Long noticeSeq;

    /* 공지사항태그 */
    private Boolean noticeTag;

    /* 공지사항주제 */
    private String noticeTitle;

    /* 공지사항내용 */
    private String noticeContents;

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
