package ratanpur.com.example.BusRide.transformer;

import ratanpur.com.example.BusRide.Enums.TripStatus;
import ratanpur.com.example.BusRide.Models.TripBooking;
import ratanpur.com.example.BusRide.dto.Request.TripBookingRequest;
import ratanpur.com.example.BusRide.dto.Response.TripBookingResponse;

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

    public static TripBookingResponse TripBookingToTripBookingResponse(TripBooking tripBooking) {
        return TripBookingResponse.builder()
                .id(tripBooking.getId())
                .bookingId(tripBooking.getBookingId())
                .pickup(tripBooking.getPickup())
                .destination(tripBooking.getDestination())
                .tripDistanceInKm(tripBooking.getTripDistanceInKm())
                .totalFare(tripBooking.getTotalFare())
                .tripStatus(tripBooking.getTripStatus().toString())
                .bookedAt(tripBooking.getBookedAt())
                .driverName(tripBooking.getDriver().getName()) // Assuming you want to include driver name
                .driverRating(tripBooking.getDriver().getRating()) // Assuming you want to include driver rating
                .build();
    }

}
