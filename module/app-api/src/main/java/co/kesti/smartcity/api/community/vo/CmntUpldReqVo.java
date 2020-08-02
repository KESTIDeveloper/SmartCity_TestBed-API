package co.kesti.smartcity.api.community.vo;

import co.kesti.smartcity.api.common.vo.BasePageVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 커뮤니티 > 자료실 요청 VO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class CmntUpldReqVo extends BasePageVo {

    private static final long serialVersionUID = 1L;

    /* 검색유형코드 */
    private String schTpCd;

    /* 검색키워드 */
    private String schKwd;

}
