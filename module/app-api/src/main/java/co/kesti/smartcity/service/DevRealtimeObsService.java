package co.kesti.smartcity.service;

import co.kesti.smartcity.entity.DevRealtimeObs;
import co.kesti.smartcity.model.RealtimeObsData;
import co.kesti.smartcity.model.request.RequestDevRealtimeObs;
import co.kesti.smartcity.repository.DevObsInfoRepository;
import co.kesti.smartcity.repository.DevRealtimeObsRepository;
import co.kesti.smartcity.util.JsonUtils;
import co.kesti.smartcity.util.StreamUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class DevRealtimeObsService {

    private final DevRealtimeObsRepository devRealtimeObsRepository;

    private final DevObsInfoRepository devObsInfoRepository;

    private final CdDtlService cdDtlService;


    public List<DevRealtimeObs> getDevRealtimeObsList() {
        return devRealtimeObsRepository.findAll();
    }

    public DevRealtimeObs save(RequestDevRealtimeObs request) {
        DevRealtimeObs devRealtimeObs = request.toDevRealtimeObs();
        return devRealtimeObsRepository.save(devRealtimeObs);
    }


    public Map<String, RealtimeObsData> getDevRealtimeObsMapByDevId(String devId) {
        Map<String, String> obsItemMap = cdDtlService.getObsItemMap();


        Map<String, RealtimeObsData> obsDataMap = devObsInfoRepository.findAllByDevObsInfoKeyDevId(devId).stream()
                .map(devObsInfo -> {
                    String obsItemName = obsItemMap.getOrDefault(devObsInfo.getObsItemId(), "");
                    String unitType = devObsInfo.getUnitType();
                    Float obsItemValue = getLatestValue(devId, devObsInfo.getObsItemId()).orElse(0F);

                    return RealtimeObsData.builder()
                            .obsItemId(devObsInfo.getObsItemId())
                            .obsItemName(obsItemName)
                            .unitType(unitType)
                            .obsItemValue(obsItemValue)
                            .build();

                }).collect(Collectors.toMap(RealtimeObsData::getObsItemId, Function.identity()));

        log.info("obsDataMap: {}", JsonUtils.toPrettyString(obsDataMap));
         return obsDataMap;

    }


    public Optional<Float> getLatestValue(String devId, String obsItemId) {
        List<Float> realtimeObs = devRealtimeObsRepository.getLatestObsItemValue(devId, obsItemId, PageRequest.of(0, 1)).stream().map(DevRealtimeObs::getObsItemValue).collect(Collectors.toList());
        return StreamUtil.head(realtimeObs);
    }
}
