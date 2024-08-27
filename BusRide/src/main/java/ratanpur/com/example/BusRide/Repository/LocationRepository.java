package ratanpur.com.example.BusRide.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ratanpur.com.example.BusRide.Models.Location;

public interface LocationRepository extends JpaRepository<Location,Integer> {

    Location findByCab_Id(int cabId);
}
