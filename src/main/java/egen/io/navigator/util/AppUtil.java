package egen.io.navigator.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"egen.io.navigator"})
@PropertySource("classpath:application.properties")
public class AppUtil {

    @Value("${mocker-api-base-url}")
    private String appBaseUrl;

    public String getAppBaseUrl() {
        return appBaseUrl;
    }
}
