package co.kesti.smartcity.device;

import co.kesti.smartcity.entity.CdDtl;
import co.kesti.smartcity.entity.CmntPrdt;
import co.kesti.smartcity.entity.DevInfo;
import co.kesti.smartcity.entity.DevRealtimeObs;
import co.kesti.smartcity.model.request.RequestCmntPrdt;
import co.kesti.smartcity.repository.CmntPrdtRepository;
import co.kesti.smartcity.repository.DevInfoRepository;
import co.kesti.smartcity.repository.DevObsInfoRepository;
import co.kesti.smartcity.repository.DevRealtimeObsRepository;
import co.kesti.smartcity.service.CdDtlService;
import co.kesti.smartcity.service.CmntPrdtService;
import co.kesti.smartcity.service.DevRealtimeObsService;
import co.kesti.smartcity.util.JsonUtils;
import co.kesti.smartcity.util.StreamUtil;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@SpringBootTest
class DeviceTest {

    @Autowired
    private DevInfoRepository devInfoRepository;

    @Autowired
    private DevObsInfoRepository devObsInfoRepository;

    @Autowired
    private DevRealtimeObsRepository devRealtimeObsRepository;

    @Autowired
    private DevRealtimeObsService devRealtimeObsService;


    @Test
    public void select() {
        String devId = "ST0001";
        String obsItemId = "OBS_PM2P5";
//        List<DevInfo> list = devInfoRepository.findAllByTestDevYn(true);
        List<DevRealtimeObs> list = devRealtimeObsRepository.getLatestObsItemValue(devId, obsItemId, PageRequest.of(0, 1));
        log.info("{}", JsonUtils.toPrettyString(list));

//        List<DevRealtimeObs> list = devRealtimeObsRepository.findAll();
//        log.info("{}", JsonUtils.toPrettyString(list));
    }

    @Test
    public void get() {
        String devId = "ST0001";

        devRealtimeObsService.getDevRealtimeObsMapByDevId(devId);


//            devInfoRepository.findById("ST0006").ifPresent(devInfo -> {
//            log.info("{}", JsonUtils.toPrettyString(devInfo));
//        });
    }
}
