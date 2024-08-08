package ratanpur.com.example.BusRide.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ratanpur.com.example.BusRide.Service.DriverService;
import ratanpur.com.example.BusRide.dto.Request.DriverRequest;

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


}
