package ratanpur.com.example.BusRide.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratanpur.com.example.BusRide.Models.Coupon;
import ratanpur.com.example.BusRide.Repository.CouponRepository;

@Service
public class CouponService {
    @Autowired
    CouponRepository couponRepository;


    public String addCoupon(String coupon,int discount){
        Coupon coupon1=new Coupon();
        coupon1.setCouponCode(coupon);
        coupon1.setPercentageDiscount(discount);

        couponRepository.save(coupon1);

        return "data has been saved into the db:"+coupon1.getId();
    }
}
