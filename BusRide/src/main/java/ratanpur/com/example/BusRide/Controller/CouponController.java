package ratanpur.com.example.BusRide.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ratanpur.com.example.BusRide.Service.CouponService;

@RestController
@RequestMapping("Coupon")
public class CouponController {
    @Autowired
    CouponService couponService;

   @PostMapping("/addCoupon")
    public ResponseEntity<String> addCoupon(@RequestParam("couponCode")String coupon,
                                            @RequestParam("discount")int discount){
      String res=couponService.addCoupon(coupon,discount);

      return new ResponseEntity<>(res, HttpStatus.CREATED);
   }
}
