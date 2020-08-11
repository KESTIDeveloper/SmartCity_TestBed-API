package co.kesti.smartcity.entity.custom;

import co.kesti.smartcity.model.code.CountryType;

public interface DevInfoCountryStatsProjection {

    String getCountryName();
    Integer getCount();


    default CountryType getCountryCode() {

        return CountryType.fromCode(getCountryName());
    }
}
