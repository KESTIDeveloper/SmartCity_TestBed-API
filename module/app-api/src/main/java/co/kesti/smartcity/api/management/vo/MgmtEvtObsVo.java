package co.kesti.smartcity.api.management.vo;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 관리 > 이벤트 측정 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class MgmtEvtObsVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 이벤트ID */
    private String evntId;

    /* 이벤트측정순번 */
    private Long evntObsSeq;

    /* 측정항목ID */
    private String obsItemId;

    /* 비교코드 */
    private String compareCode;

    /* 비교값 */
    private String compareValue;

}
