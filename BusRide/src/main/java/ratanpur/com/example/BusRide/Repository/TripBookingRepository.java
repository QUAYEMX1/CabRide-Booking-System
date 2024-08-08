package ratanpur.com.example.BusRide.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ratanpur.com.example.BusRide.Models.TripBooking;

public interface TripBookingRepository extends JpaRepository<TripBooking,Integer> {

}
