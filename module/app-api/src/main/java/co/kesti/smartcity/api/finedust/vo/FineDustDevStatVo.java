package co.kesti.smartcity.api.finedust.vo;

import java.util.List;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 메세먼지 > 디바이스 상태 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FineDustDevStatVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 합계정보 */
    private FineDustDevStatTotVo totInfo;

    /* 이벤트정보 */
    private FineDustDevStatEvtVo evtInfo;

    /* 이벤트측정목록 */
    private List<FineDustDevStatEvtObsVo> evtObsList;

}
