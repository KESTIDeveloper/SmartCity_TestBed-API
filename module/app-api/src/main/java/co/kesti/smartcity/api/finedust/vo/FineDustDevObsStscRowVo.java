package co.kesti.smartcity.api.finedust.vo;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 메세먼지 > 디바이스 측정 통계 행 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FineDustDevObsStscRowVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 디바이스ID */
    private String devId;

    /* 측정항목ID */
    private String obsItemId;

    /* 측정항목값 */
    private double obsItemValue;

}
