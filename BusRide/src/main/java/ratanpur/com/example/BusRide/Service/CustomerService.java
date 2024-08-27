package ratanpur.com.example.BusRide.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratanpur.com.example.BusRide.Enums.Gender;
import ratanpur.com.example.BusRide.Models.Customer;
import ratanpur.com.example.BusRide.Models.TripBooking;
import ratanpur.com.example.BusRide.Repository.CustomerRepository;
import ratanpur.com.example.BusRide.Repository.TripBookingRepository;
import ratanpur.com.example.BusRide.dto.Request.CustomerRequest;
import ratanpur.com.example.BusRide.dto.Response.CustomerResponse;
import ratanpur.com.example.BusRide.dto.Response.TripBookingResponse;
import ratanpur.com.example.BusRide.transformer.CustomerRequestTransformer;
import ratanpur.com.example.BusRide.transformer.TripBookingTransformer;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    TripBookingRepository tripBookingRepository;

  public CustomerResponse addCustomer(CustomerRequest customerRequest){

      Customer customer= CustomerRequestTransformer.CustomerRequestToCustomer(customerRequest);
      customerRepository.save(customer);

      CustomerResponse customerResponse=CustomerRequestTransformer.CustomerToCustomerResponse(customer);

      return customerResponse;
  }

  public List<CustomerResponse> getCustomerByGenderAndAgeGreaterThan(Gender gender,int age){

      List<Customer>customerList=customerRepository.findByAgeAndGender(age, gender);

      List<CustomerResponse>customerResponseList=new ArrayList<>();

      for(Customer customer:customerList){
          customerResponseList.add(CustomerRequestTransformer.CustomerToCustomerResponse(customer));
      }

      return customerResponseList;
  }

    public List<TripBookingResponse> getRideHistory(int customerId) {
        // Find the customer by ID
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Find all trip bookings for this customer
        List<TripBooking> tripBookings = tripBookingRepository.findByCustomer(customer);

        // Initialize a list to hold the response objects
        List<TripBookingResponse> tripBookingResponses = new ArrayList<>();

        // Loop through each trip booking and convert it to a response object
        for (TripBooking tripBooking : tripBookings) {
            TripBookingResponse response = TripBookingTransformer.TripBookingToTripBookingResponse(tripBooking);
            tripBookingResponses.add(response);
        }

        // Return the list of trip booking responses
        return tripBookingResponses;
    }

}
