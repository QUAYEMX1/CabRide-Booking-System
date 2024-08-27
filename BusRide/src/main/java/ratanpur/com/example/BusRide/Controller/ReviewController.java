package ratanpur.com.example.BusRide.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ratanpur.com.example.BusRide.Service.ReviewService;
import ratanpur.com.example.BusRide.dto.Request.ReviewRequest;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/{tripId}/review")
    public ResponseEntity<String> submitReview(@PathVariable int tripId, @RequestBody ReviewRequest reviewRequest) {
        reviewService.submitReview(tripId, reviewRequest);
        return new ResponseEntity<>("Review submitted successfully", HttpStatus.CREATED);
    }


}
