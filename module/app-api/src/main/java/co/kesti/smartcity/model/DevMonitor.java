package co.kesti.smartcity.model;

import co.kesti.smartcity.entity.DevInfo;
import lombok.*;

import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DevMonitor {

    private DevInfo devInfo;
    private String address;
    private Float pm25;

    public String getDevId() {
        return devInfo.getDevId();
    }

    public String getDevName() {
        return devInfo.getDevName();
    }


    public String getMarkerIcon() {
        String testYn = devInfo.getTestDevYn() ? "t" : "nt";
        return String.format("%s_%s_%s.png", testYn, getPrdtType(), getPm25Level());
    }

    public String getPrdtType() {
        if (devInfo.getPrdtType().equals("OBSTYPE001")) {
            return "static";
        } else if (devInfo.getPrdtType().equals("OBSTYPE002")) {
            return "move";
        } else {
            return "port";
        }
    }

    public String getPm25Level() {
        if (Objects.nonNull(pm25)) {
            if (pm25 > 75) {
                return "red";
            } else if (pm25 > 35) {
                return "yellow";
            } else if (pm25 > 15) {
                return "green";
            } else {
                return "blue";
            }
        } else {
            return "";
        }
    }
    private Map<String, RealtimeObsData> obsDataMap;
}
