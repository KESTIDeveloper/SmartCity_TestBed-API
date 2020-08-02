package co.kesti.smartcity.api.finedust.vo;

import java.util.List;

import co.kesti.smartcity.api.common.vo.BasePageVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 메세먼지 > 디바이스 측정 통계 요청 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class FineDustDevObsStscReqVo extends BasePageVo {

    private static final long serialVersionUID = 1L;

    /* 디바이스목록 */
    private List<String> devList;

    /* 디바이스구분값 */
    private String devDivVal;

    /* 시작일자 */
    private String strDt;

    /* 종료일자 */
    private String endDt;

    /* 측정항목ID */
    private String obsItemId;

    /* 측정항목명 */
    private String obsItemNm;

    /* 통계항목코드 */
    private String stscItemCd;

    /* 통계일시코드 */
    private String stscDtmCd;

}
