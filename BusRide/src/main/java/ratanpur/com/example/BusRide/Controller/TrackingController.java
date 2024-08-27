package ratanpur.com.example.BusRide.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ratanpur.com.example.BusRide.Models.Location;
import ratanpur.com.example.BusRide.Service.DriverService;
import ratanpur.com.example.BusRide.Service.TripTrackingService;

@RestController
@RequestMapping("/tracking")
public class TrackingController {
    @Autowired
    DriverService driverService;

    @Autowired
    TripTrackingService tripTrackingService;

    @PostMapping("/drivers/{driverId}/location")
    public ResponseEntity<String> updateLocation(@PathVariable int driverId,
                                                 @RequestParam double latitude,
                                                 @RequestParam double longitude) {
        String response = driverService.updateLocation(driverId, latitude, longitude);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/trips/{tripId}/track")
    public ResponseEntity<Location> trackCab(@PathVariable int tripId) {
        Location location = tripTrackingService.trackCab(tripId);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

}
