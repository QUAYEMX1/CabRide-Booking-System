package ratanpur.com.example.BusRide.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ratanpur.com.example.BusRide.Enums.Gender;
import ratanpur.com.example.BusRide.Models.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select c from Customer c where c.age>= :a and c.gender = :g")
    List<Customer> findByAgeAndGender(int a, Gender g);

    Customer findByEmailId(String emailId);
}
