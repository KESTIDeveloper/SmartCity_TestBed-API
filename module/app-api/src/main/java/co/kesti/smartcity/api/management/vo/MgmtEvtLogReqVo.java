package co.kesti.smartcity.api.management.vo;

import co.kesti.smartcity.api.common.vo.BasePageVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 관리 > 이벤트 로그 요청 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class MgmtEvtLogReqVo extends BasePageVo {

    private static final long serialVersionUID = 1L;

    /* 이벤트ID */
    private String evntId;

}
