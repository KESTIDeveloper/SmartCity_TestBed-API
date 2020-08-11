package co.kesti.smartcity.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String secretKey;

    private static final long TOKEN_VALID_MILLISECOND = 1000L * 3600 * 24 * 365; // 1년 유효


    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }


    public String createToken(String mbrId) {
        Claims claims = Jwts.claims().setSubject(mbrId);


        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims) // 데이터
                .setIssuedAt(now) // 토큰 발행일자
                .setExpiration(new Date(now.getTime() + TOKEN_VALID_MILLISECOND)) // set Expire Time
                .signWith(SignatureAlgorithm.HS256, secretKey) // 암호화 알고리즘, secret값 세팅
                .compact();
    }

    public boolean validateToken(String jwtToken) {
        if (StringUtils.isBlank(jwtToken)) {
            return false;
        }
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            log.info(e.getLocalizedMessage());
            return false;
        }
    }

    public Claims getUser(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    public String encAuth(String data) {
        return new String(Base64.getEncoder().encode(data.getBytes()));
    }

    public String decAuth(String data) {
        return new String(Base64.getDecoder().decode(data));
    }
}
