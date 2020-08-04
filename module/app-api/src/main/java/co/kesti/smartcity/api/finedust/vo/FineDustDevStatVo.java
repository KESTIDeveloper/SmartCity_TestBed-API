package co.kesti.smartcity.api.finedust.vo;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 메세먼지 > 디바이스 상태 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FineDustDevStatVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 건수정보 */
    private FineDustDevStatTotVo totInfo;

}
