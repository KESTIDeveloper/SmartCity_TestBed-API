package co.kesti.smartcity.service;

import co.kesti.smartcity.entity.CdDtl;
import co.kesti.smartcity.entity.ComMbr;
import co.kesti.smartcity.entity.DevInfo;
import co.kesti.smartcity.entity.custom.DevInfoProjection;
import co.kesti.smartcity.error.ApplicationException;
import co.kesti.smartcity.error.ResponseCode;
import co.kesti.smartcity.model.DevMonitor;
import co.kesti.smartcity.model.request.RequestDevInfo;
import co.kesti.smartcity.model.request.RequestLocation;
import co.kesti.smartcity.model.request.RequestSearchManufacturer;
import co.kesti.smartcity.model.response.ResponseAddress;
import co.kesti.smartcity.repository.DevCompareRepository;
import co.kesti.smartcity.repository.DevInfoRepository;
import co.kesti.smartcity.util.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class DevInfoService {

    private final DevInfoRepository devInfoRepository;

    private final CdDtlService cdDtlService;

    private final DevCompareRepository devCompareRepository;

    private final ComMbrService comMbrService;

    private final DevMonitorService devMonitorService;

    private final MapService mapService;

    public Page<DevInfo> getDevInfos(Pageable pageable) {
        return devInfoRepository.findAllByOrderByCretDtDesc(pageable);
    }

    public Page<DevInfoProjection> getDevInfoProjections(Pageable pageable) {
        return devInfoRepository.selectAllByOrderByCretDtDesc(pageable);
    }

    public Page<DevInfoProjection> getDevInfoProjectionsByCretrId(String cretrId, Pageable pageable) {
        return devInfoRepository.getDevInfoProjectionsByCretrId(cretrId, pageable);
    }


    public DevInfo getDevInfoOrThrow(String devId) {
        DevInfo devInfo = devInfoRepository.findById(devId)
                .orElseThrow(() -> new ApplicationException(ResponseCode.RESOURCE_NOT_FOUND, "User not found: " + devId));

        Map<String, String> protocolRuleMap = cdDtlService.getProtocolRuleMap();
        String protocolRuleName = protocolRuleMap.getOrDefault(devInfo.getProtocolRule(), "");
        devInfo.setProtocolRuleName(protocolRuleName);
        return devInfo;
    }

    public DevInfo createDevInfo(RequestDevInfo requestDevInfo) {
        DevInfo devInfo = requestDevInfo.toDevInfo();
        devInfo.setLiveStatus("LIVED");
        devInfo.setConnStatus("CONNECTED");
        devInfo.setTestDevYn(true);
        devInfo.getCretrId();

        ComMbr comMbr = comMbrService.getMbrById(devInfo.getCretrId());
        devInfo.setMbrSeq(comMbr.getMbrSeq());

        log.info("create devInfo: {}", JsonUtils.toPrettyString(devInfo));
        return devInfoRepository.save(devInfo);
    }

    public DevInfo updateComMbr(String devId, RequestDevInfo requestDevInfo) {
        getDevInfoOrThrow(devId);
        DevInfo devInfo = requestDevInfo.toDevInfo();
        devInfo.setDevId(devId);
        log.info("updateComMbr: {}", JsonUtils.toPrettyString(devInfo));
        return devInfoRepository.save(devInfo);
    }

    @Transactional
    public void delete(String devId) {
        DevInfo devInfo = getDevInfoOrThrow(devId);
        devInfoRepository.delete(devInfo);
    }

    public Integer updateLiveStatusById(String devId, String liveStatus) {
        return devInfoRepository.updateLiveStatusById(devId, liveStatus);
    }

    public List<DevInfo> getCompareDeviceListByDevId(String devId) {
        return devCompareRepository.getDevCompareByDevId(devId);
    }



    /**
     * 테스트 디바이스 목록
     */
    public List<DevInfo> getTestDeviceList() {
        return devInfoRepository.findAllByTestDevYn(true);
    }

    public List<CdDtl> searchManufacturer(RequestSearchManufacturer request) {
        return cdDtlService.searchManufacturer(request);
    }
}
