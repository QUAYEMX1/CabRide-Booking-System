package ratanpur.com.example.BusRide.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratanpur.com.example.BusRide.Models.Cab;
import ratanpur.com.example.BusRide.Models.Driver;
import ratanpur.com.example.BusRide.Models.Location;
import ratanpur.com.example.BusRide.Models.Review;
import ratanpur.com.example.BusRide.Repository.CabRepository;
import ratanpur.com.example.BusRide.Repository.DriverRepository;
import ratanpur.com.example.BusRide.Repository.LocationRepository;
import ratanpur.com.example.BusRide.Repository.ReviewRepository;
import ratanpur.com.example.BusRide.dto.Request.CabRequest;
import ratanpur.com.example.BusRide.dto.Request.DriverRequest;
import ratanpur.com.example.BusRide.dto.Response.DriverReviewResponse;
import ratanpur.com.example.BusRide.transformer.DriverRequestTransform;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;
    @Autowired
    CabRepository cabRepository;
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    LocationRepository locationRepository;
   public String addDriver(DriverRequest driverRequest) {

       Cab cab=DriverRequestTransform.CabRequestToCab(driverRequest.getCab());
       Driver driver = DriverRequestTransform.DriverRequestToDriver(driverRequest);
       driver.setCab(cab);

       cab.setDriver(driver);  // Ensure bidirectional relationship is set

//       cabRepository.save(cab);
       driverRepository.save(driver);

       return "Driver data has been added to the db:" + driver.getId();
   }

    public String updateLocation(int driverId, double latitude, double longitude) {
        Cab cab = cabRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        Location location = cab.getLocation();
        if (location == null) {
            location = new Location();
            location.setCab(cab);
        }
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        locationRepository.save(location);

        cab.setLocation(location);
        cabRepository.save(cab);

        return "Location updated successfully";
    }

    public DriverReviewResponse getDriverReviews(int driverId) {

        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        List<Review> reviews = reviewRepository.findByDriver(driver);

        OptionalDouble averageRating = reviews.stream()
                .mapToInt(Review::getRating)
                .average();

        DriverReviewResponse response = new DriverReviewResponse();
        response.setReviews(reviews);
        response.setAverageRating(averageRating.orElse(0.0));

        return response;

    }
}
