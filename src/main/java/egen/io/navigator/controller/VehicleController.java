package egen.io.navigator.controller;

import egen.io.navigator.entity.Vehicle;
import egen.io.navigator.service.VehicleService;
import egen.io.navigator.util.WebUri;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(WebUri.VEHICLES)
@Api(WebUri.VEHICLES)
public class VehicleController {

    @Autowired
    private VehicleService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Find All Vehicles", notes = "Fetches All the Vehicles")
    public List<Vehicle> findAll() {
        return service.fetchAllVehicles();
    }
}
