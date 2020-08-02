package co.kesti.smartcity.api.management.vo;

import co.kesti.smartcity.api.common.vo.BaseParamVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 관리 > 이벤트 로그 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class MgmtEvtLogVo extends BaseParamVo {

    private static final long serialVersionUID = 1L;

    /* 이벤트ID */
    private String evntId;

    /* 순번 */
    private Long seq;

    /* 관리내용 */
    private String mngContent;

}
