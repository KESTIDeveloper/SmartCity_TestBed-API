package co.kesti.smartcity.api.finedust.vo;

import java.util.List;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 메세먼지 > 디바이스 상태 이벤트 측정 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FineDustDevStatEvtObsVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 이벤트일자 */
    private String evtDt;

    /* 상세목록 */
    private List<FineDustDevStatEvtObsRowVo> dtlList;

}
