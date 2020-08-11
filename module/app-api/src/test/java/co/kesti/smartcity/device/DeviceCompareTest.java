package co.kesti.smartcity.device;

import co.kesti.smartcity.entity.DevInfo;
import co.kesti.smartcity.entity.custom.DevInfoCountryStatsProjection;
import co.kesti.smartcity.repository.DevCompareRepository;
import co.kesti.smartcity.repository.DevInfoRepository;
import co.kesti.smartcity.repository.DevRealtimeObsRepository;
import co.kesti.smartcity.service.DevInfoService;
import co.kesti.smartcity.service.DevRealtimeObsService;
import co.kesti.smartcity.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class DeviceCompareTest {

    @Autowired
    private DevInfoRepository devInfoRepository;

    @Autowired
    private DevCompareRepository devCompareRepository;

    @Autowired
    private DevRealtimeObsRepository devRealtimeObsRepository;

    @Autowired
    private DevRealtimeObsService devRealtimeObsService;

    @Autowired
    private DevInfoService devInfoService;


    @Test
    public void select() {
        String devId = "ST0001";

        List<DevInfo> list = devCompareRepository.getDevCompareByDevId(devId);
//        List<DevCompare> list = devCompareRepository.findAllByDevCompareKeyDevId(devId);
        log.info("{}", JsonUtils.toPrettyString(list));
    }

    @Test
    public void compare() {
        List<String> res = devInfoRepository.getDevInfoCountryStats(true);
        log.info("{}", JsonUtils.toPrettyString(res));

    }
}
