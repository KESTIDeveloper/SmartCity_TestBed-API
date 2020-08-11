package co.kesti.smartcity.api.finedust.vo;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 메세먼지 > 디바이스 상태 이벤트 측정 행 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FineDustDevStatEvtObsRowVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 이벤트측정코드 */
    private String evtObsCd;

    /* 로그건수 */
    private int logCnt;

}
