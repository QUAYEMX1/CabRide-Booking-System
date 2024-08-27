package ratanpur.com.example.BusRide.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ratanpur.com.example.BusRide.Models.TripBooking;
import ratanpur.com.example.BusRide.Service.ReviewService;
import ratanpur.com.example.BusRide.Service.TripBookingService;
import ratanpur.com.example.BusRide.dto.Request.ReviewRequest;
import ratanpur.com.example.BusRide.dto.Request.TripBookingRequest;

import java.util.List;

@RestController
@RequestMapping("TripBooking")
public class TripBookingController {
    @Autowired
    TripBookingService tripBookingService;
    @Autowired
    ReviewService reviewService;

    @PostMapping("api/bookCab")
    public ResponseEntity<String> bookCab(@RequestBody TripBookingRequest tripBookingRequest){

     return new ResponseEntity<>(tripBookingService.bookCab(tripBookingRequest), HttpStatus.OK);
    }

    @PostMapping("/{tripId}/review")
    public ResponseEntity<String> submitReview(@PathVariable("tripId") int tripId, @RequestBody ReviewRequest reviewRequest) {
        reviewService.submitReview(tripId, reviewRequest);
        return new ResponseEntity<>("Review submitted successfully", HttpStatus.OK);
    }
}
