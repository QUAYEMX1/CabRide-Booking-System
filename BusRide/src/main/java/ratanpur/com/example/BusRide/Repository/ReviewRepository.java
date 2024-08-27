package ratanpur.com.example.BusRide.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ratanpur.com.example.BusRide.Models.Driver;
import ratanpur.com.example.BusRide.Models.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Integer> {

    List<Review> findByDriver(Driver driver);

}
