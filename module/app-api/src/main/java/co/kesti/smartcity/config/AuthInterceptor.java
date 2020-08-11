package co.kesti.smartcity.config;

import co.kesti.smartcity.entity.ComMbr;
import co.kesti.smartcity.error.ApplicationException;
import co.kesti.smartcity.error.ResponseCode;
import co.kesti.smartcity.service.ComMbrService;
import co.kesti.smartcity.service.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;


@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private ComMbrService comMbrService;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
        String token = req.getHeader(AppConfig.Authorization);

        if (!jwtTokenProvider.validateToken(token)) {
            throw ApplicationException.builder().code(ResponseCode.UNAUTHORIZED).build();
        } else {

            String mbrId = jwtTokenProvider.getUser(token).getSubject();
            ComMbr comMbr = comMbrService.getMbrById(mbrId);
            req.getSession().setAttribute(AppConfig.MbrId, comMbr.getCretrId());
            log.debug("open-api: {}", comMbr.getCretrId());
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }


}
