package ratanpur.com.example.BusRide.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ratanpur.com.example.BusRide.Models.Customer;
import ratanpur.com.example.BusRide.Models.Location;
import ratanpur.com.example.BusRide.Models.TripBooking;

import java.util.List;

public interface TripBookingRepository extends JpaRepository<TripBooking,Integer> {

    List<TripBooking> findByCustomer(Customer customer);

}
