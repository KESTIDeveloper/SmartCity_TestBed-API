package co.kesti.smartcity.service;

import co.kesti.smartcity.entity.DevInfo;
import co.kesti.smartcity.entity.custom.DevInfoCountryStatsProjection;
import co.kesti.smartcity.entity.custom.DevInfoStatsProjection;
import co.kesti.smartcity.model.DevMonitor;
import co.kesti.smartcity.model.DevStats;
import co.kesti.smartcity.model.RealtimeObsData;
import co.kesti.smartcity.model.code.CountryType;
import co.kesti.smartcity.model.request.RequestLocation;
import co.kesti.smartcity.model.request.RequestMy;
import co.kesti.smartcity.model.response.ResponseAddress;
import co.kesti.smartcity.repository.DevInfoRepository;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class DevMonitorService {


    private final DevRealtimeObsService devRealtimeObsService;
    private final DevInfoRepository devInfoRepository;
    private final MapService mapService;
    private final CdDtlService cdDtlService;


//
//    public DevMonitor getDeviceMonitorByDevId(DevInfo devInfo) {
//
//        Map<String, RealtimeObsData> map = devRealtimeObsService.getDevRealtimeObsMapByDevId(devInfo.getDevId());
//
//        String address = "";
//        return DevMonitor.builder()
//                .devId(devInfo.getDevId())
//                .devName(devInfo.getDevName())
//                .latitude(devInfo.getLatitVal())
//                .longitude(devInfo.getLngitVal())
//                .obsDataMap(map)
//                .address(address)
//                .build();
//    }

    /**
     * 비교 디바이스 목록
     */
    public List<DevMonitor> getMonitoringCompareDeviceList() {
        List<DevInfo> devInfos = devInfoRepository.findAllByTestDevYn(false);

        List<DevMonitor> monitors = devInfos.stream().map(devInfo -> {
//            ResponseAddress address = mapService.getAddress(RequestLocation.builder()
//                    .latitude(devInfo.getLatitVal())
//                    .longitude(devInfo.getLngitVal())
//                    .build());

            String address = "";

            Float pm25 = devRealtimeObsService.getLatestValue(devInfo.getDevId(), "OBS_PM2P5");
            log.info(" - {}, {}, {}, {}", devInfo.getDevName(), devInfo.getLatitVal(), devInfo.getLngitVal(), pm25);

            return DevMonitor.builder()
                    .devInfo(devInfo)
                    .address(address)
                    .pm25(pm25)
                    .build();

        }).collect(Collectors.toList());

        return monitors;
    }

    public List<DevMonitor> getMonitoringCompareDeviceListByDevId(String devId) {
        List<DevInfo> devInfos = devInfoRepository.getMyCompareDevice(devId);

        List<DevMonitor> monitors = devInfos.stream().map(devInfo -> {

            String address = "";

            Float pm25 = devRealtimeObsService.getLatestValue(devInfo.getDevId(), "OBS_PM2P5");
            log.info(" - {}, {}, {}, {}", devInfo.getDevName(), devInfo.getLatitVal(), devInfo.getLngitVal(), pm25);

            return DevMonitor.builder()
                    .devInfo(devInfo)
                    .address(address)
                    .pm25(pm25)
                    .build();

        }).collect(Collectors.toList());

        return monitors;
    }



    public List<DevMonitor> getMonitoringMyTestDeviceList(RequestMy requestMy) {

        List<DevInfo> devInfos = Lists.newArrayList();
        if (requestMy.getAdminYn()) {
            devInfos = devInfoRepository.findAllByTestDevYn(true);
        } else {
            devInfos = devInfoRepository.findAllByTestDevYnAndCretrId(true, requestMy.getCretrId());
        }


        List<DevMonitor> monitors = devInfos.stream().map(devInfo -> {

            String address = "";
            Float pm25 = devRealtimeObsService.getLatestValue(devInfo.getDevId(), "OBS_PM2P5");
            log.info(" - {}, {}, {}, {}", devInfo.getDevName(), devInfo.getLatitVal(), devInfo.getLngitVal(), pm25);

            return DevMonitor.builder()
                    .devInfo(devInfo)
                    .address(address)
                    .pm25(pm25)
                    .build();
        }).collect(Collectors.toList());

        return monitors;
    }

    public List<DevMonitor> getMonitoringTestDeviceList() {
        List<DevInfo> devInfos = devInfoRepository.findAllByTestDevYn(true);

        List<DevMonitor> monitors = devInfos.stream().map(devInfo -> {

//            ResponseAddress address = mapService.getAddress(RequestLocation.builder()
//                    .latitude(devInfo.getLatitVal())
//                    .longitude(devInfo.getLngitVal())
//                    .build());
            String address = "";
            Float pm25 = devRealtimeObsService.getLatestValue(devInfo.getDevId(), "OBS_PM2P5");
            log.info(" - {}, {}, {}, {}", devInfo.getDevName(), devInfo.getLatitVal(), devInfo.getLngitVal(), pm25);

            return DevMonitor.builder()
                    .devInfo(devInfo)
                    .address(address)
                    .pm25(pm25)
                    .build();
        }).collect(Collectors.toList());

        return monitors;
    }





    public DevMonitor getDeviceMonitorByDevId(String devId) {
        DevInfo devInfo = devInfoRepository.findById(devId).get();

        List<RealtimeObsData> obsDataList = devRealtimeObsService.getDevRealtimeObsMapByDevId(devInfo.getDevId());

        LocalDateTime updateTime = devRealtimeObsService.getLastUpdatedTimeByDevId(devId).map(it -> it.getRegisteDt()).orElse(LocalDateTime.now());
        return DevMonitor.builder()
                .devInfo(devInfo)
                .obsDataList(obsDataList)
                .updateTime(updateTime)
                .build();
    }

    public DevStats getDevStats() {

        List<DevInfoStatsProjection> testDevices = devInfoRepository.getDevInfoStats().stream().filter(d -> d.getTestDevYn()).collect(Collectors.toList());
        List<DevInfoStatsProjection> devices = devInfoRepository.getDevInfoStats().stream().filter(d -> !d.getTestDevYn()).collect(Collectors.toList());

        Map<String, Long> countryMap = devInfoRepository.getDevInfoCountryStats(true).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<String> prdtTypeCode = Lists.newArrayList("static", "move", "port");
        List<String> countryCodes = Lists.newArrayList("KR;KOR", "US;USA", "VN;VNM", "ID;IDN", "TW;TWN");



        Map<String, Long> count = countryCodes.stream().collect(Collectors.toMap(c -> CountryType.fromCode(c).getDesc(), c -> countryMap.getOrDefault(c, 0L)));

        Map<String, Integer> testDeviceStats = testDevices.stream()
                .collect(Collectors.toMap(d -> d.getPrdtCode(), d -> d.getCount()));

        Map<String, Integer> deviceStats = devices.stream()
                .collect(Collectors.toMap(d -> d.getPrdtCode(), d -> d.getCount()));

        Map<String, Integer> testDeviceMap = prdtTypeCode.stream().collect(Collectors.toMap(c -> c, c -> testDeviceStats.getOrDefault(c, 0)));
        Map<String, Integer> deviceMap = prdtTypeCode.stream().collect(Collectors.toMap(c -> c, c -> deviceStats.getOrDefault(c, 0)));


        return DevStats.builder().device(deviceMap).testDevice(testDeviceMap).country(count).build();
    }
}
