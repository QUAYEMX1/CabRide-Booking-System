package ratanpur.com.example.BusRide.transformer;

import ratanpur.com.example.BusRide.Enums.TripStatus;
import ratanpur.com.example.BusRide.Models.TripBooking;
import ratanpur.com.example.BusRide.dto.Request.TripBookingRequest;

import java.util.UUID;

public class TripBookingTransformer {

    public static TripBooking BookingTransformer(TripBookingRequest tripBookingRequest){

        return TripBooking.builder()
                .bookingId(String.valueOf(UUID.randomUUID()))
                .pickup(tripBookingRequest.getPickup())
                .destination(tripBookingRequest.getDestination())
                .tripDistanceInKm(tripBookingRequest.getTripDistanceInKm())
                .tripStatus(TripStatus.IN_TRANSIT)
                .build();
    }

}
