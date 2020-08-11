package co.kesti.smartcity.api.finedust.vo;

import co.kesti.smartcity.api.common.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 메세먼지 > 디바이스 상태 이벤트 로그 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FineDustDevStatEvtLogVo extends BaseVo {

    private static final long serialVersionUID = 1L;

    /* 로그일자 */
    private Long seq;

    /* 로그일자 */
    private String logDt;

    /* 이벤트이름 */
    private String evntNm;

    /* 관리내용 */
    private String mngContent;

    /* 이벤트측정명 */
    private String evtObsNm;

    /* 테스트값 */
    private String testVal;

}
