package co.kesti.smartcity.service;

import co.kesti.smartcity.entity.DevInfo;
import co.kesti.smartcity.entity.custom.DevInfoProjection;
import co.kesti.smartcity.error.ApplicationException;
import co.kesti.smartcity.error.ResponseCode;
import co.kesti.smartcity.model.request.RequestDevInfo;
import co.kesti.smartcity.repository.DevCompareRepository;
import co.kesti.smartcity.repository.DevInfoRepository;
import co.kesti.smartcity.util.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class DevInfoService {

    private final DevInfoRepository devInfoRepository;

    private final CdDtlService cdDtlService;

    private final DevCompareRepository devCompareRepository;


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
     * 비교 디바이스 목록
     */
    public List<DevInfo> getCompareDeviceList() {
        return devInfoRepository.findAllByTestDevYn("N");
    }

    /**
     * 테스트 디바이스 목록
     */
    public List<DevInfo> getTestDeviceList() {
        return devInfoRepository.findAllByTestDevYn("Y");
    }
}
