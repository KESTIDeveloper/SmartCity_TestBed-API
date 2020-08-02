package co.kesti.smartcity.config;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.allowed-domains}")
    private String[] corsAllowedDomains;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/TESTBED/v0.9/**")
                .allowedOrigins(corsAllowedDomains)
                .allowedMethods(HttpMethod.GET.name(),
                                HttpMethod.POST.name(),
                                HttpMethod.PUT.name(),
                                HttpMethod.DELETE.name());

    }

    @Bean
    public FilterRegistrationBean requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeHeaders(false);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(1000);
        loggingFilter.setIncludeClientInfo(false);
        loggingFilter.setBeforeMessagePrefix("");
        loggingFilter.setAfterMessagePrefix("");

        FilterRegistrationBean registrationBean = new FilterRegistrationBean(loggingFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(-2);
        return registrationBean;
    }

}
