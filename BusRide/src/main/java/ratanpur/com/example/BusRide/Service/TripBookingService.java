package ratanpur.com.example.BusRide.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratanpur.com.example.BusRide.Exceptions.CabNotFoundException;
import ratanpur.com.example.BusRide.Exceptions.CustomerNotFoundException;
import ratanpur.com.example.BusRide.Models.Cab;
import ratanpur.com.example.BusRide.Models.Customer;
import ratanpur.com.example.BusRide.Models.TripBooking;
import ratanpur.com.example.BusRide.Repository.CabRepository;
import ratanpur.com.example.BusRide.Repository.CustomerRepository;
import ratanpur.com.example.BusRide.Repository.DriverRepository;
import ratanpur.com.example.BusRide.Repository.TripBookingRepository;
import ratanpur.com.example.BusRide.dto.Request.TripBookingRequest;
import ratanpur.com.example.BusRide.transformer.TripBookingTransformer;

import java.util.List;

@Service
public class TripBookingService {
    @Autowired
    TripBookingRepository tripBookingRepository;
    @Autowired
    CabRepository cabRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    DriverRepository driverRepository;


   public String bookCab(TripBookingRequest tripBookingRequest){

       Customer customer=customerRepository.findByEmailId(tripBookingRequest.getCustomerEmailId());

       if(customer==null){
           throw new CustomerNotFoundException("EmailId is not found");
       }

       TripBooking tripBooking= TripBookingTransformer.BookingTransformer(tripBookingRequest);

       Cab cab=cabRepository.getRandomAvailableCab();

       if(cab==null){
           throw new CabNotFoundException("sorry all drivers are busy in this route");
       }
//       tripBookingRepository.save(tripBooking);
       tripBooking.setTotalFare(tripBookingRequest.getTripDistanceInKm()*cab.getFarePerKm());

        cab.getDriver().getDriverTripBookingList().add(tripBooking);
        cab.setAvailable(false);

        customer.getCustomerTripBookingList().add(tripBooking);

       tripBooking.setDriver(cab.getDriver());
       tripBooking.setCustomer(customer);

       driverRepository.save(cab.getDriver());
       customerRepository.save(customer);

       return "cab has been booked";

   }
}
