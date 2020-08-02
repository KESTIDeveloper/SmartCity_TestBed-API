package co.kesti.smartcity.management;

import co.kesti.smartcity.entity.CdDtl;
import co.kesti.smartcity.entity.CmntPrdt;
import co.kesti.smartcity.entity.DevInfo;
import co.kesti.smartcity.entity.custom.DevInfoProjection;
import co.kesti.smartcity.model.Pagination;
import co.kesti.smartcity.model.request.RequestCmntPrdt;
import co.kesti.smartcity.repository.DevInfoRepository;
import co.kesti.smartcity.service.CdDtlService;
import co.kesti.smartcity.service.CmntPrdtService;
import co.kesti.smartcity.service.PageMaker;
import co.kesti.smartcity.util.JsonUtils;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@SpringBootTest
class ManagementDeviceTest {


    @Autowired
    private CmntPrdtService cmntPrdtService;

    @Autowired
    private DevInfoRepository devInfoRepository;

    @Autowired
    CdDtlService cdDtlService;

    @Autowired
    PageMaker pageMaker;

    @Test
    public void paging() {

        Page<DevInfo> page = devInfoRepository.findAllByOrderByCretDtDesc(PageRequest.of(0, 6));

        Pagination pagination = pageMaker.toPagination(page, 5);

        log.info("{}", JsonUtils.toPrettyString(pagination));
        log.info("{}", JsonUtils.toPrettyString(page));

    }

    @Test
    public void pagingProjection() {

        Page<DevInfoProjection> page = devInfoRepository.selectAllByOrderByCretDtDesc(PageRequest.of(0, 6));

//        Pagination pagination = pageMaker.toPagination(page, 5);
//
//        log.info("{}", JsonUtils.toPrettyString(pagination));
        log.info("{}", JsonUtils.toPrettyString(page.getContent()));

    }


    @Test
    public void crud() {
        Page<DevInfo> devInfos = devInfoRepository.findAllByOrderByCretDtDesc(PageRequest.of(0, 1));
        DevInfo devInfo = devInfos.getContent().get(0);

        IntStream.rangeClosed(21,50).forEach(num -> {

            String devId = "ST00"+num;

            devInfo.setDevId(devId);

            devInfoRepository.save(devInfo);
        });
    }


    @Test
    public void integrationTest() {
        List<String> types = Lists.newArrayList("OBSTYPE001", "OBSTYPE002", "OBSTYPE003");
        List<String> osbItemTypes = Lists.newArrayList("OBS_ATEMPR", "OBS_HUMID", "OBS_PM10", "OBS_PM2P5", "OBS_VOC");

        IntStream.rangeClosed(20, 50).forEach(num -> {
            RequestCmntPrdt req = RequestCmntPrdt.builder()
                    .prdtName("디바이스 "+num)
                    .prdtContents("내용 "+num)
                    .prdtType(types.get(new Random().nextInt(3)))
                    .obsItem(osbItemTypes.get(new Random().nextInt(5)))
                    .build();
            cmntPrdtService.createCmntPrdt(req);
        });


        List<CmntPrdt> res = cmntPrdtService.getCommunityProductList();

//        res.stream().forEach(p -> {
//            communityProductService.delete(p.getPrdtSeq());
//        });
        log.info("{}", JsonUtils.toPrettyString(res));
    }


    @Test
    public void paginationTest() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        String type = "all";
        String prdtName = "디바이스 1";
        List<CmntPrdt> res = cmntPrdtService.getCmntPrdtListByPrdtTypeAndPrdtName(type, prdtName, pageRequest);
        log.info("{}", JsonUtils.toPrettyString(res));
//        log.info("{}", JsonUtils.toPrettyString(res));
    }
}
