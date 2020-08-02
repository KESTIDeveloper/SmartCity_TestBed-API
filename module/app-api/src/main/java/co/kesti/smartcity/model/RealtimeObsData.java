package co.kesti.smartcity.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class RealtimeObsData {
    private String obsItemId;
    private String obsItemName;
    private String unitType;
    private Float obsItemValue;
}
