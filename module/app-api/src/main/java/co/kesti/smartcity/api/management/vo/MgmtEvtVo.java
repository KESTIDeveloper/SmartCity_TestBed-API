package co.kesti.smartcity.api.management.vo;

import co.kesti.smartcity.api.common.vo.BaseParamVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 관리 > 이벤트 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class MgmtEvtVo extends BaseParamVo {

    private static final long serialVersionUID = 1L;

    /* 이벤트ID */
    private String evntId;

    /* 이벤트이름 */
    private String evntNm;

    /* 디바이스ID */
    private String devId;

    /* 이벤트발생구분 */
    private String evntOccrDiv;

    /* 이벤트발생조건구분 */
    private String evntOccrCondDiv;

    /* 이벤트발생조건값 */
    private String evntOccrCondVal;

    /* and/or조건 */
    private String andOrCode;

    /* 수신전화번호 */
    private String recptnPhonNo;

    /* SMS메세지 */
    private String smsMsg;

    /* 회원순번 */
    private Long mbrSeq;

    /* 상태 */
    private String status;

    /* 삭제여부 */
    private String delYn;


    /**
     * 추가 정보
     */
    /* 디바이스명 */
    private String devName;

    /* 체크여부 */
    private Boolean chkYn;

}
