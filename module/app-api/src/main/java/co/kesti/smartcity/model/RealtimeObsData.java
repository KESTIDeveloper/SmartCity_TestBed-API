package co.kesti.smartcity.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.math.NumberUtils;

@Data
@Builder
public class RealtimeObsData {
    private String obsItemId;
    private String obsItemName;
    private String unitType;
    private Float obsItemValue;

    public Integer getObsValue() {

        if (obsItemValue == null) {
            return 0;
        } else {
            return Math.round(obsItemValue);
        }
    }
}
