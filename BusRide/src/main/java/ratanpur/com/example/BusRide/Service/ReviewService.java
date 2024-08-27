package ratanpur.com.example.BusRide.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratanpur.com.example.BusRide.Models.Review;
import ratanpur.com.example.BusRide.Models.TripBooking;
import ratanpur.com.example.BusRide.Repository.ReviewRepository;
import ratanpur.com.example.BusRide.Repository.TripBookingRepository;
import ratanpur.com.example.BusRide.dto.Request.ReviewRequest;

@Service
public class ReviewService {

    @Autowired
    private TripBookingRepository tripBookingRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public void submitReview(int tripId, ReviewRequest reviewRequest) {
        TripBooking tripBooking = tripBookingRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        Review review = new Review();
        review.setRating(reviewRequest.getRating());
        review.setComment(reviewRequest.getComment());
        review.setTripBooking(tripBooking);

        if (tripBooking.getReview() != null) {
            reviewRepository.delete(tripBooking.getReview());
        }

        reviewRepository.save(review);
        tripBooking.setReview(review);
        tripBookingRepository.save(tripBooking);
    }

}
