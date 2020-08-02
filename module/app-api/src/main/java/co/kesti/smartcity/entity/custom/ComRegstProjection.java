package co.kesti.smartcity.entity.custom;


import co.kesti.smartcity.util.DateTimeUtils;

import java.time.LocalDateTime;


public interface ComRegstProjection {


	Integer getRegstSeq();

	String getUsePurpose();

	String getRegstName();

	String getCretrId();

	LocalDateTime getRegstDt();

	LocalDateTime getCretDt();

	String getUserNm();

	String getAdminUserNm();

	default String getFormattedCretDt() {
		return DateTimeUtils.getDefaultFormat(getCretDt());
	}

	default String getFormattedRegstDt() {
		return DateTimeUtils.getDefaultFormat(getRegstDt());
	}

}
	