package co.kesti.smartcity.entity.custom;


import co.kesti.smartcity.entity.DevObsInfoKey;
import co.kesti.smartcity.util.DateTimeUtils;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


public interface DevObsInfoProjection {

	String getDevId();

	String getObsItemId();

	String getObsItemName();

	String getUnitType();

	LocalDateTime getRegisteDt();

	default String getFormattedRegisteDt() {
		return DateTimeUtils.getDefaultFormat(getRegisteDt());
	}
}
	