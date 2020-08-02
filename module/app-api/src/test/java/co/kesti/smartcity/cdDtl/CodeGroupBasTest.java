package co.kesti.smartcity.cdDtl;

import co.kesti.smartcity.repository.CdGroupBasRepository;
import co.kesti.smartcity.service.CdGroupBasService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Slf4j
@SpringBootTest
class CodeGroupBasTest {


    @Autowired
    private CdGroupBasRepository cdGroupBasRepository;

    @Autowired
    private CdGroupBasService cdGroupBasService;


    @Test
    public void updateCdGroupId() {

//        Integer res = cdGroupBasRepository.updateCdGroupId("AAA", "BBB");

//        log.info("updated: {}", res);

        Integer res = cdGroupBasService.updateCdGroupId("PROTR", "PROTR2");
        // 오류: "cd_group_bas" 테이블의 자료 갱신, 삭제 작업이 "cd_group_id_fk" 참조키(foreign key) 제약 조건 - "cd_dtl" 테이블 - 을 위반했습니다
        //  Detail: (cd_group_id)=(PROTR) 키가 "cd_dtl" 테이블에서 여전히 참조됩니다.
        log.info("updated: {}", res);
    }


    @Test
    public void uuid() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        long most64SigBits = get64MostSignificantBitsForVersion1();
        long least64SigBits = get64LeastSignificantBitsForVersion1();

        log.info("{}, {}", most64SigBits, least64SigBits);
    }

    private static long get64LeastSignificantBitsForVersion1() {
        Random random = new Random();
        long random63BitLong = random.nextLong() & 0x3FFFFFFFFFFFFFFFL;
        long variant3BitFlag = 0x8000000000000000L;
        return random63BitLong + variant3BitFlag;
    }

    private static long get64MostSignificantBitsForVersion1() {
        LocalDateTime start = LocalDateTime.of(1582, 10, 15, 0, 0, 0);
        Duration duration = Duration.between(start, LocalDateTime.now());
        long seconds = duration.getSeconds();
        long nanos = duration.getNano();
        long timeForUuidIn100Nanos = seconds * 10000000 + nanos * 100;
        long least12SignificatBitOfTime = (timeForUuidIn100Nanos & 0x000000000000FFFFL) >> 4;
        long version = 1 << 12;
        return (timeForUuidIn100Nanos & 0xFFFFFFFFFFFF0000L) + version + least12SignificatBitOfTime;
    }
}
