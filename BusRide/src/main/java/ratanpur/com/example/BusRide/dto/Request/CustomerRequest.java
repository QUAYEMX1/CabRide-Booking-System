package ratanpur.com.example.BusRide.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ratanpur.com.example.BusRide.Enums.Gender;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    String name;
    int age;
    String emailId;
    String address;
    Gender gender;
}
