package ratanpur.com.example.BusRide.dto.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ratanpur.com.example.BusRide.Enums.CarType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CabRequest {

    String carModel;

    String cabNo;

    CarType carType;

    int numberOfSeat;

    double farePerKm;
}
