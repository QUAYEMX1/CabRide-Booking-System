package ratanpur.com.example.BusRide.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ratanpur.com.example.BusRide.Models.Driver;

public interface DriverRepository extends JpaRepository<Driver,Integer> {


}
