package co.kesti.smartcity.service;

import co.kesti.smartcity.entity.DevRealtimeObs;
import co.kesti.smartcity.model.RealtimeObsData;
import co.kesti.smartcity.model.code.ObsType;
import co.kesti.smartcity.model.request.RequestDevRealtimeObs;
import co.kesti.smartcity.repository.DevObsInfoRepository;
import co.kesti.smartcity.repository.DevRealtimeObsRepository;
import co.kesti.smartcity.util.JsonUtils;
import co.kesti.smartcity.util.StreamUtil;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    public Map<String, RealtimeObsData> getDefaultRealtimeObsDataMap() {
        return Arrays.stream(ObsType.values()).map(obsType -> {

            return RealtimeObsData.builder()
                    .obsItemId(obsType.getItemId())
                    .obsItemName(obsType.getItemName())
                    .unitType(obsType.getUnitType())
                    .obsItemValue(0F)
                    .build();
        }).collect(Collectors.toMap(RealtimeObsData::getObsItemId, Function.identity()));

    }

    public List<RealtimeObsData> getDevRealtimeObsMapByDevId(String devId) {
        Map<String, String> obsItemMap = cdDtlService.getObsItemMap();

        Map<String, RealtimeObsData> defaultMap = getDefaultRealtimeObsDataMap();

        Map<String, RealtimeObsData> obsDataMap = devObsInfoRepository.findAllByDevObsInfoKeyDevId(devId).stream()
                .filter(devObsInfo -> StringUtils.isNotBlank(devObsInfo.getObsItemId()))
                .map(devObsInfo -> {
                    String obsItemName = obsItemMap.getOrDefault(devObsInfo.getObsItemId(), "");
                    String unitType = devObsInfo.getUnitType();
                    Float obsItemValue = getLatestValue(devId, devObsInfo.getObsItemId());

                    return RealtimeObsData.builder()
                            .obsItemId(devObsInfo.getObsItemId())
                            .obsItemName(obsItemName)
                            .unitType(unitType)
                            .obsItemValue(obsItemValue)
                            .build();

                }).collect(Collectors.toMap(RealtimeObsData::getObsItemId, Function.identity()));

        return Arrays.stream(ObsType.values()).map(obsType -> {

            log.debug(" - {}, {}"+obsType.getItemId(), obsDataMap.getOrDefault(obsType.getItemId(), defaultMap.get(obsType.getItemId())));
            return obsDataMap.getOrDefault(obsType.getItemId(), defaultMap.get(obsType.getItemId()));
                }).collect(Collectors.toList());
    }

    public Map<String, Float> getDevRealtimeObsDataMapByDevId(String devId) {
        Map<String, Float> obsDataMap = Maps.newConcurrentMap();
        devObsInfoRepository.findAllByDevObsInfoKeyDevId(devId).stream()
                .filter(devObsInfo -> StringUtils.isNotBlank(devObsInfo.getObsItemId()))
                .forEach(devObsInfo -> {
                    Float obsItemValue = getLatestValue(devId, devObsInfo.getObsItemId());
                    obsDataMap.put(devObsInfo.getObsItemId(), obsItemValue);

                });

        log.info("obsDataMap: {}", JsonUtils.toString(obsDataMap));
        return obsDataMap;

    }


    public Float getLatestValue(String devId, String obsItemId) {
        List<Float> realtimeObs = devRealtimeObsRepository.getLatestObsItemValue(devId, obsItemId, PageRequest.of(0, 1)).stream().map(DevRealtimeObs::getObsItemValue).collect(Collectors.toList());
        return StreamUtil.head(realtimeObs).orElse(0F);
    }

    public Optional<DevRealtimeObs>  getLastUpdatedTimeByDevId(String devId) {
        return devRealtimeObsRepository.findTopByDevRealtimeObsKey_DevId(devId);
    }
}
