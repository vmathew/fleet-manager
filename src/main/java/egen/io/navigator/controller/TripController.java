package egen.io.navigator.controller;

import egen.io.navigator.entity.Trip;
import egen.io.navigator.service.TripService;
import egen.io.navigator.util.WebUri;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(WebUri.TRIPS)
@Api(WebUri.TRIPS)
public class TripController {

    @Autowired
    private TripService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Finds the trips for a vehicle", notes = "Given a Vehicle ID fetch all its trips")
    public List<Trip> findTrips(@ApiParam(value = "Vehicle Id") @RequestParam(value = "vehicleId") String vehicleId) {
        return service.findTripsForAVehicle(vehicleId);
    }
}
