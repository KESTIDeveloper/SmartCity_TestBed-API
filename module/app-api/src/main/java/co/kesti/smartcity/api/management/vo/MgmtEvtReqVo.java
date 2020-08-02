package co.kesti.smartcity.api.management.vo;

import co.kesti.smartcity.api.common.vo.BasePageVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 관리 > 이벤트 요청 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class MgmtEvtReqVo extends BasePageVo {

    private static final long serialVersionUID = 1L;

    /* 회원순번 */
    private Long mbrSeq;

}
