package co.kesti.smartcity.api.finedust.vo;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 메세먼지 > 디바이스 상태 합계 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FineDustDevStatTotVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 총건수 */
    private int totCnt;

    /* 성공건수 */
    private int succCnt;

    /* 실패건수 */
    private int failCnt;

    /* 총시간 */
    private int totHour;

    /* 가동시간 */
    private int oprtHour;

    /* 비가동시간 */
    private int noprHour;

}
