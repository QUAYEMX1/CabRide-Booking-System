package ratanpur.com.example.BusRide.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ratanpur.com.example.BusRide.Models.Coupon;

public interface CouponRepository extends JpaRepository<Coupon,Integer> {

}
