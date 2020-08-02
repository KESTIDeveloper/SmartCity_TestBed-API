package co.kesti.smartcity.community;

import co.kesti.smartcity.entity.CdDtl;
import co.kesti.smartcity.entity.CmntPrdt;
import co.kesti.smartcity.entity.custom.CmntPrdtProjection;
import co.kesti.smartcity.model.request.RequestCmntPrdt;
import co.kesti.smartcity.repository.CmntPrdtRepository;
import co.kesti.smartcity.service.CdDtlService;
import co.kesti.smartcity.service.CmntPrdtService;
import co.kesti.smartcity.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
@SpringBootTest
class CommunityProductTest {


    @Autowired
    private CmntPrdtService cmntPrdtService;

    @Autowired
    private CmntPrdtRepository cmntPrdtRepository;

    @Autowired
    CdDtlService cdDtlService;

    @Test
    public void getProcuct() {
        Integer prdtSeq = 404;
    }


    @Test
    public void getCodeGroupInfosByCdGroupId() {
        String cdGroupId = "OBS";
        List<CdDtl> res = cdDtlService.getCodeGroupInfosByGroupId(cdGroupId);
        log.info("{}", JsonUtils.toPrettyString(res));
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
