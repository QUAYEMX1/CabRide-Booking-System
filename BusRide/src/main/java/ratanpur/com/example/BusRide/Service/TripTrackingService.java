package ratanpur.com.example.BusRide.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratanpur.com.example.BusRide.Models.Location;
import ratanpur.com.example.BusRide.Repository.LocationRepository;

@Service
public class TripTrackingService {

    @Autowired
    LocationRepository locationRepository;

    public Location trackCab(int tripId) {
        return locationRepository.findByCab_Id(tripId);
    }


}
