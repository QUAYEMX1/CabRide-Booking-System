package ratanpur.com.example.BusRide.dto.Response;

import lombok.Getter;
import lombok.Setter;
import ratanpur.com.example.BusRide.Models.Review;

import java.util.List;

@Getter
@Setter
public class DriverReviewResponse {
    private List<Review> reviews;
    private double averageRating;
}
