package co.kesti.smartcity.api.finedust.vo;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 메세먼지 > 디바이스 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FineDustDevVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 디바이스ID */
    private String devId;

    /* 디바이스이름 */
    private String devName;

    /* 활성화여부 */
    private Boolean actYn;

}
