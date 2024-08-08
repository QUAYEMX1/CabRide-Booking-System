package ratanpur.com.example.BusRide.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ratanpur.com.example.BusRide.Service.TripBookingService;
import ratanpur.com.example.BusRide.dto.Request.TripBookingRequest;

@RestController
@RequestMapping("TripBooking")
public class TripBookingController {
    @Autowired
    TripBookingService tripBookingService;

    @PostMapping("api/bookCab")
    public ResponseEntity<String> bookCab(@RequestBody TripBookingRequest tripBookingRequest){

     return new ResponseEntity<>(tripBookingService.bookCab(tripBookingRequest), HttpStatus.OK);
    }
}
