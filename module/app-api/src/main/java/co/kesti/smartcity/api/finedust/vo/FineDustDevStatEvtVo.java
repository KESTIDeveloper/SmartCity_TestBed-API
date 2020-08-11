package co.kesti.smartcity.api.finedust.vo;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 메세먼지 > 디바이스 상태 이벤트 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FineDustDevStatEvtVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 연결건수 */
    private int conCnt;

    /* 측정건수 */
    private int obsCnt;

    /* 총건수 */
    private int totCnt;
}
