package co.kesti.smartcity.api.finedust.vo;

import java.util.List;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 메세먼지 > 디바이스 측정 통계 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FineDustDevObsStscVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 측정시간 */
    private String obsTime;

    /* 측정항목명 */
    private String obsItemNm;

    /* 상세목록 */
    private List<FineDustDevObsStscRowVo> dtlList;

}
