package co.kesti.smartcity.api.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 공통코드 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ComCdVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 키 */
    private String key;

    /* 텍스트 */
    private String txt;

    /* 활성화여부 */
    private Boolean actYn;

}
