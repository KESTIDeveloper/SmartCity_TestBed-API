package co.kesti.smartcity.api.finedust.vo;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 메세먼지 > 디바이스 측정 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FineDustDevObsVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 디바이스ID */
    private String devId;

    /* 측정항목ID */
    private String obsItemId;

    /* 측정항목명 */
    private String obsItemNm;

    /* 단위타입 */
    private String unitType;

    /* 활성화여부 */
    private Boolean actYn;

}
