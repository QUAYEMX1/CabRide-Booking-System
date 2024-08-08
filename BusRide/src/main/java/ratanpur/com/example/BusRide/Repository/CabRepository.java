package ratanpur.com.example.BusRide.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ratanpur.com.example.BusRide.Models.Cab;

public interface CabRepository extends JpaRepository<Cab,Integer> {

    @Query(value = "select * from cab where available = true order by rand() limit 1",nativeQuery = true)

    Cab getRandomAvailableCab();
}
