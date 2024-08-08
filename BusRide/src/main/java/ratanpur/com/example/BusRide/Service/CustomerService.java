package ratanpur.com.example.BusRide.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratanpur.com.example.BusRide.Enums.Gender;
import ratanpur.com.example.BusRide.Models.Customer;
import ratanpur.com.example.BusRide.Repository.CustomerRepository;
import ratanpur.com.example.BusRide.dto.Request.CustomerRequest;
import ratanpur.com.example.BusRide.dto.Response.CustomerResponse;
import ratanpur.com.example.BusRide.transformer.CustomerRequestTransformer;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

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
}
