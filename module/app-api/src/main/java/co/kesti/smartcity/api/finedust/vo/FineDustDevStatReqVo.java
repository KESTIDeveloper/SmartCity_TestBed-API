package co.kesti.smartcity.api.finedust.vo;

import co.kesti.smartcity.api.common.vo.BasePageVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 메세먼지 > 디바이스 상태 요청 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FineDustDevStatReqVo extends BasePageVo {

    private static final long serialVersionUID = 1L;

    /* 디바이스ID */
    private String devId;

    /* 시작일자 */
    private String strDt;

    /* 종료일자 */
    private String endDt;

}
