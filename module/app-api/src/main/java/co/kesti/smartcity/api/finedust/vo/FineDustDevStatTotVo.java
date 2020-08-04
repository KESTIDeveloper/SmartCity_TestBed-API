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

    /* 성공건수 */
    private Integer succCnt;

    /* 실패건수 */
    private Integer failCnt;

    /* 전체건수 */
    private Integer totCnt;

}
