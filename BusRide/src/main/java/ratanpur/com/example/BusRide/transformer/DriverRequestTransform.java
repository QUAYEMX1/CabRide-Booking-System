package ratanpur.com.example.BusRide.transformer;

import ratanpur.com.example.BusRide.Enums.CarType;
import ratanpur.com.example.BusRide.Models.Cab;
import ratanpur.com.example.BusRide.Models.Driver;
import ratanpur.com.example.BusRide.dto.Request.CabRequest;
import ratanpur.com.example.BusRide.dto.Request.DriverRequest;

public class DriverRequestTransform {
    public static Driver DriverRequestToDriver(DriverRequest driverRequest){

        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .panNumber(driverRequest.getPanNumber())
                .mobNo(driverRequest.getMobNo())
                .build();

    }


    public static Cab CabRequestToCab(CabRequest cabRequest){

        return Cab.builder()
                .carModel(cabRequest.getCarModel())
                .available(true)
                .cabNo(cabRequest.getCabNo())
                .carType(cabRequest.getCarType())
                .farePerKm(cabRequest.getFarePerKm())
                .noOfSeats(cabRequest.getNumberOfSeat())
                .build();
    }
}
