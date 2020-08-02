package co.kesti.smartcity.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DevMonitor {

    private String devId;

    private String devName;

    private Float latitVal; // 위도

    private Float lngitVal; // 경도

    private String address;

    private Map<String, RealtimeObsData> obsDataMap;
}
