package co.kesti.smartcity.mypage;

import co.kesti.smartcity.entity.ComMbr;
import co.kesti.smartcity.entity.ComRegst;
import co.kesti.smartcity.repository.ComMbrRepository;
import co.kesti.smartcity.repository.ComRegstDtlRepository;
import co.kesti.smartcity.repository.ComRegstRepository;
import co.kesti.smartcity.service.ComMbrService;
import co.kesti.smartcity.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class ComRegstDtlTest {


    @Autowired
    private ComRegstDtlRepository comRegstDtlRepository;


    @Test
    public void list() {
        log.info("{}", JsonUtils.toPrettyString(comRegstDtlRepository.findAll()));

    }


}
