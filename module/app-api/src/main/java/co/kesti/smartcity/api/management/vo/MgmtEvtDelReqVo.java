package co.kesti.smartcity.api.management.vo;

import java.util.List;

import co.kesti.smartcity.api.common.vo.BaseParamVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 관리 > 이벤트 삭제 요청 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class MgmtEvtDelReqVo extends BaseParamVo {

    private static final long serialVersionUID = 1L;

    /* 이벤트ID */
    private String evntId;

    /* 이벤트목록 */
    private List<String> evtList;
}
