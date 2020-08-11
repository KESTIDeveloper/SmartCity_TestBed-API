package co.kesti.smartcity.member;

import co.kesti.smartcity.service.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class JwtTest {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;




    @Test
    public void integration() {

        String mbrId = "haru";

        String token = jwtTokenProvider.createToken(mbrId);
        log.info("token: {}", token);

        boolean valid = jwtTokenProvider.validateToken(token);
        log.info("valid: {}", valid);

        String res = jwtTokenProvider.getUser(token).getSubject();

        log.info("userId: {}", res);
    }


}
