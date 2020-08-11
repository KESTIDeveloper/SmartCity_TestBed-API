package co.kesti.smartcity.api.management.vo;

import java.util.List;

import co.kesti.smartcity.api.common.vo.BaseParamVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 관리 > 이벤트 상세 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class MgmtEvtReadVo extends BaseParamVo {

    private static final long serialVersionUID = 1L;

    /* 이벤트정보 */
    private MgmtEvtVo evtInfo;

    /* 측정목록 */
    private List<MgmtEvtObsVo> obsList;

}
