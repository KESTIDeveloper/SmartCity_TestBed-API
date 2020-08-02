package co.kesti.smartcity.member;

import co.kesti.smartcity.entity.CmntPrdt;
import co.kesti.smartcity.entity.ComMbr;
import co.kesti.smartcity.entity.ComRegst;
import co.kesti.smartcity.entity.DevInfo;
import co.kesti.smartcity.entity.custom.DevInfoProjection;
import co.kesti.smartcity.model.Pagination;
import co.kesti.smartcity.model.request.RequestCmntPrdt;
import co.kesti.smartcity.repository.ComMbrRepository;
import co.kesti.smartcity.repository.ComRegstRepository;
import co.kesti.smartcity.repository.DevInfoRepository;
import co.kesti.smartcity.service.CdDtlService;
import co.kesti.smartcity.service.CmntPrdtService;
import co.kesti.smartcity.service.ComMbrService;
import co.kesti.smartcity.service.PageMaker;
import co.kesti.smartcity.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
@SpringBootTest
class ComMbrTest {


    @Autowired
    private ComMbrRepository comMbrRepository;

    @Autowired
    private ComMbrService comMbrService;

    @Autowired
    private ComRegstRepository comRegstRepository;

    @Test
    public void mbrList() {

        List<ComMbr> rse = comMbrRepository.findAllByMbrClasIn(Lists.newArrayList("0001", "0002"));
        log.info("{}", JsonUtils.toPrettyString(rse));

        log.info("{}", JsonUtils.toPrettyString(comMbrService.selectAdminMbrList()));

    }

    @Test
    public void comregstTest() {
        List<ComRegst> list = comRegstRepository.findAll();
        log.info("{}", JsonUtils.toPrettyString(list));
    }


}
