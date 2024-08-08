package ratanpur.com.example.BusRide.transformer;

import ratanpur.com.example.BusRide.Models.Customer;
import ratanpur.com.example.BusRide.dto.Request.CustomerRequest;
import ratanpur.com.example.BusRide.dto.Response.CustomerResponse;

public class CustomerRequestTransformer {

    public static Customer CustomerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .emailId(customerRequest.getEmailId())
                .address(customerRequest.getAddress())
                .gender(customerRequest.getGender())
                .build();

    }

    public static CustomerResponse CustomerToCustomerResponse(Customer customer){

        return CustomerResponse.builder()
                .name(customer.getName())
                .emailId(customer.getEmailId())
                .build();
    }

}
