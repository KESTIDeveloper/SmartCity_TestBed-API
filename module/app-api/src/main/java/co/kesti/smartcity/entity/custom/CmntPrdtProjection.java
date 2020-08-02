package co.kesti.smartcity.entity.custom;


import co.kesti.smartcity.util.DateTimeUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;



public interface CmntPrdtProjection {

    Integer getPrdtSeq();

    String getUserNm();

    String getPrdtType();

    String getPrdtName();

    String getObsItem();

    String getPrdtContents();

    String getPrdtImgPath();

    String getAttachedFilePath();

    String getObsItemName();

    String getPrdtTypeName();

    String getCretrId();

    LocalDateTime getCretDt();

    default String getFormattedCretDt() {
        return DateTimeUtils.getDefaultFormat(getCretDt());
    }

    default boolean getHasImage() {
        return StringUtils.isNotBlank(getPrdtImgPath());
    }

    default boolean getHasFile() {
        return StringUtils.isNotBlank(getAttachedFilePath());
    }
}
