package egen.io.navigator.service;

import egen.io.navigator.entity.Trip;
import egen.io.navigator.entity.TripResponse;
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
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@Slf4j
public class TripService {

    @Autowired
    private Environment environment;

    public List<Trip> findTripsForAVehicle(String vehicleID) {
        String url = environment.getProperty("mocker-api-base-url") + WebUri.TRIPS;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("vehicleId", vehicleID);
        log.info("## "+builder.build().encode().toString());

        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        template.getMessageConverters().add(new StringHttpMessageConverter());

        HttpEntity<String> request = new HttpEntity<>(new String());

        ResponseEntity<TripResponse> response = template.exchange(builder.build().encode().toString(), HttpMethod.GET,
                request, TripResponse.class);

        return response.getBody().getResults();
    }

}
