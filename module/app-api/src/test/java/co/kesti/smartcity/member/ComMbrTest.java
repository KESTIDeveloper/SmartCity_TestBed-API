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
import co.kesti.smartcity.service.*;
import co.kesti.smartcity.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
@SpringBootTest
class ComMbrTest {

    @Autowired
    private HttpClientTemplate httpClientTemplate;

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

    @Test
    public void countryTest() throws IOException {
        String aa = getCountry("203.236.8.208");

        log.info("{}", aa);
    }


    public String getCountry(String ip) {
        String response =  httpClientTemplate.get("http://ip2c.org/"+ip, String.class);
        String[] data = StringUtils.split(response, ";");
        if (data.length >=3) {
            return String.format("%s;%s", data[1], data[2]);
        } else {
            return "";
        }
    }
}
