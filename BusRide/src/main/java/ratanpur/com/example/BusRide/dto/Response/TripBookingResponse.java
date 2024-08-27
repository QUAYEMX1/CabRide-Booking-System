package ratanpur.com.example.BusRide.dto.Response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class TripBookingResponse {
    private int id;
    private String bookingId;
    private String pickup;
    private String destination;
    private double tripDistanceInKm;
    private double totalFare;
    private String tripStatus;
    private Date bookedAt;
    private String driverName; // Include driver name if needed
    private double driverRating; // Include driver rating if needed
}
