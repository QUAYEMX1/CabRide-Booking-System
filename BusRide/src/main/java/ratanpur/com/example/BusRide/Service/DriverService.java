package ratanpur.com.example.BusRide.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratanpur.com.example.BusRide.Models.Cab;
import ratanpur.com.example.BusRide.Models.Driver;
import ratanpur.com.example.BusRide.Repository.CabRepository;
import ratanpur.com.example.BusRide.Repository.DriverRepository;
import ratanpur.com.example.BusRide.dto.Request.CabRequest;
import ratanpur.com.example.BusRide.dto.Request.DriverRequest;
import ratanpur.com.example.BusRide.transformer.DriverRequestTransform;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;
    @Autowired
    CabRepository cabRepository;
   public String addDriver(DriverRequest driverRequest) {

       Cab cab=DriverRequestTransform.CabRequestToCab(driverRequest.getCab());
       Driver driver = DriverRequestTransform.DriverRequestToDriver(driverRequest);
       driver.setCab(cab);

       cab.setDriver(driver);  // Ensure bidirectional relationship is set

//       cabRepository.save(cab);
       driverRepository.save(driver);

       return "Driver data has been added to the db:" + driver.getId();
   }
}
