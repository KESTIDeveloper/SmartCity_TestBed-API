package co.kesti.smartcity.api.management.vo;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 관리 > 디바이스 코드 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class MgmtDevCdVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 디바이스ID */
    private String devId;

    /* 디바이스이름 */
    private String devNm;

    /* 활성화여부 */
    private Boolean actYn;

}
