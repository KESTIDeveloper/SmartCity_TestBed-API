package co.kesti.smartcity.entity.custom;


import co.kesti.smartcity.util.DateTimeUtils;

import java.time.LocalDateTime;


public interface CmntPrdtCommentProjection {

    Integer getPrdtCommentSeq();

    Integer getPrdtSeq();

    Integer getPrdtCommentParent();

    String getPrdtCommentContent();

    Integer getLikeCnt();

    Integer getDislikeCnt();

    String getIpAdress();

    String getCretrId();

    String getAmdrId();

    String getDelYn();

    String getUserNm();

    LocalDateTime getCretDt();

    default String getFormattedCretDt() {
        return DateTimeUtils.getDefaultFormat(getCretDt());
    }
}
