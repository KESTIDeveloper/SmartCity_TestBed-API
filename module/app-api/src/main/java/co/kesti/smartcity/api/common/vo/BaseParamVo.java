package co.kesti.smartcity.api.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 기본 파라미터 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BaseParamVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 생성일시 */
    private String cretDt;

    /* 생성시간 */
    private String cretTm;

    /* 생성자ID */
    private String cretrId;

    /* 생성자명 */
    private String cretrNm;

    /* 생성자마스킹ID */
    private String cretrMaskId;

    /* 수정일시 */
    private String amdDt;

    /* 수정자ID */
    private String amdrId;

    /* 회원순번 */
    private Long mbrSeq;

    /* 회원ID */
    private String mbrId;

}
