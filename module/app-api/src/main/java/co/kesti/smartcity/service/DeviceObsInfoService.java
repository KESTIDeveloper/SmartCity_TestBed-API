package co.kesti.smartcity.service;

import co.kesti.smartcity.entity.DevObsInfo;
import co.kesti.smartcity.entity.DevObsInfoKey;
import co.kesti.smartcity.entity.custom.DevObsInfoProjection;
import co.kesti.smartcity.error.ApplicationException;
import co.kesti.smartcity.error.ResponseCode;
import co.kesti.smartcity.model.request.RequestDevObsInfo;
import co.kesti.smartcity.repository.DevObsInfoRepository;
import co.kesti.smartcity.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class DeviceObsInfoService {

    private final DevObsInfoRepository devObsInfoRepository;

    public DeviceObsInfoService(DevObsInfoRepository devObsInfoRepository) {
        this.devObsInfoRepository = devObsInfoRepository;
    }

    @Transactional(readOnly = true)
    public Page<DevObsInfo> getDevObsInfos(Pageable pageable) {
        return devObsInfoRepository.findAllByOrderByRegisteDtDesc(pageable);
    }

    @Transactional(readOnly = true)
    public Page<DevObsInfoProjection> getDevObsInfosByDevId(String devId, Pageable pageable) {
        return devObsInfoRepository.getDevObsInfosByDevId(devId, pageable);
    }

    @Transactional(readOnly = true)
    public DevObsInfo getDevObsInfoOrThrow(DevObsInfoKey devObsInfoKey) {
        return devObsInfoRepository.findByDevObsInfoKey(devObsInfoKey)
                .orElseThrow(() -> new ApplicationException(ResponseCode.RESOURCE_NOT_FOUND, "devObsInfo not found: "+JsonUtils.toString(devObsInfoKey)));
    }

    public DevObsInfo createDevObsInfo(RequestDevObsInfo requestDevObsInfo) {
        DevObsInfo devInfo = requestDevObsInfo.toDevObsInfo();
        return devObsInfoRepository.save(devInfo);
    }

    public DevObsInfo updateDevObsInfo(RequestDevObsInfo requestDevObsInfo) {
        getDevObsInfoOrThrow(requestDevObsInfo.getDevObsInfoKey());
        DevObsInfo devObsInfo = requestDevObsInfo.toDevObsInfo();
        devObsInfo.setDevObsInfoKey(requestDevObsInfo.getDevObsInfoKey());
        log.info("updateDevObsInfo: {}", JsonUtils.toPrettyString(devObsInfo));
        return devObsInfoRepository.save(devObsInfo);
    }

    @Transactional
    public void delete(DevObsInfoKey devObsInfoKey) {
        DevObsInfo devObsInfo = getDevObsInfoOrThrow(devObsInfoKey);
        devObsInfoRepository.delete(devObsInfo);
    }


}
