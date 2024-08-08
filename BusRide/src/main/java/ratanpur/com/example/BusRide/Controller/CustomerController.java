package ratanpur.com.example.BusRide.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ratanpur.com.example.BusRide.Enums.Gender;
import ratanpur.com.example.BusRide.Service.CustomerService;
import ratanpur.com.example.BusRide.dto.Request.CustomerRequest;
import ratanpur.com.example.BusRide.dto.Response.CustomerResponse;

import java.util.List;

@RestController
@RequestMapping("Customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

   @PostMapping("/api/addCustomer")
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest customerRequest){

        CustomerResponse response=customerService.addCustomer(customerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
   }

   @GetMapping("/gender/{gender}/age/{age}")
    public ResponseEntity<List<CustomerResponse>> getCustomerByGenderAndAgeGreaterThan(@PathVariable("gender")Gender gender,
                                                                                       @PathVariable("age")int age){

           List<CustomerResponse> responses=customerService.getCustomerByGenderAndAgeGreaterThan(gender, age);

           return new ResponseEntity<>(responses,HttpStatus.FOUND);
   }

}
