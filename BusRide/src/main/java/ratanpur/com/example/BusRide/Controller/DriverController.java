package ratanpur.com.example.BusRide.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ratanpur.com.example.BusRide.Service.DriverService;
import ratanpur.com.example.BusRide.dto.Request.DriverRequest;
import ratanpur.com.example.BusRide.dto.Response.DriverReviewResponse;

@RestController
@RequestMapping("/driver")
public class DriverController {

 @Autowired
 DriverService driverService;

 @PostMapping("api/addDriver")
    public ResponseEntity<String> addDriver(@RequestBody DriverRequest driverRequest){
      String  response=driverService.addDriver(driverRequest);
     return new ResponseEntity<>(response, HttpStatus.CREATED);
 }

    @GetMapping("/{driverId}/reviews")
    public ResponseEntity<DriverReviewResponse> getDriverReviews(@PathVariable("driverId") int driverId) {
        DriverReviewResponse response = driverService.getDriverReviews(driverId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
