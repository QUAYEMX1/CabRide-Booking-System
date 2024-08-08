package ratanpur.com.example.BusRide.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TripBookingRequest {

    String pickup;

    String destination;

    double tripDistanceInKm;

    String customerEmailId;
}
