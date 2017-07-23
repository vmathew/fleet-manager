package egen.io.navigator.service;

import egen.io.navigator.entity.Vehicle;
import egen.io.navigator.entity.VehicleResponse;
import egen.io.navigator.util.WebUri;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class VehicleService {

    @Autowired
    private Environment environment;

    public List<Vehicle> fetchAllVehicles(){
        String url = environment.getProperty("mocker-api-base-url") + WebUri.VEHICLES;
        log.info("## "+url);

        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        template.getMessageConverters().add(new StringHttpMessageConverter());

        HttpEntity<String> request = new HttpEntity<>(new String());
        ResponseEntity<VehicleResponse> response = template.exchange(url, HttpMethod.GET, request, VehicleResponse.class);
        return response.getBody().getResults();
    }
}
