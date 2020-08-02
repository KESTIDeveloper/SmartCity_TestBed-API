package co.kesti.smartcity.service;

import co.kesti.smartcity.entity.DevInfo;
import co.kesti.smartcity.model.DevMonitor;
import co.kesti.smartcity.model.RealtimeObsData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class DevMonitorService {

    private final DevInfoService devInfoService;

    private final DevRealtimeObsService devRealtimeObsService;



    public DevMonitor getDeviceMonitor(String devId) {
        DevInfo devInfo = devInfoService.getDevInfoOrThrow(devId);

        Map<String, RealtimeObsData> map = devRealtimeObsService.getDevRealtimeObsMapByDevId(devId);

        String address = "";
        return DevMonitor.builder()
                .devId(devId)
                .devName(devInfo.getDevName())
                .latitVal(devInfo.getLatitVal())
                .lngitVal(devInfo.getLngitVal())
                .obsDataMap(map)
                .address(address)
                .build();
    }

}
