package co.kesti.smartcity.model.code;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum ObsType {

    OBS_PM10("OBS_PM10", "PM10","㎍/㎥"),
    OBS_PM2P5("OBS_PM2P5", "PM2.5", "㎍/㎥"),
    OBS_VOC("OBS_VOC", "VOC","ppm"),
    OBS_ATEMPR("OBS_ATEMPR", "온도", "°C"),
    OBS_HUMID("OBS_HUMID", "습도", "%");


    private String itemId;
    private String itemName;
    private String unitType;

}
