package ratanpur.com.example.BusRide.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ratanpur.com.example.BusRide.Enums.CarType;
import ratanpur.com.example.BusRide.Models.Driver;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    @Column(unique = true)
    String cabNo;

    String carModel;

    boolean available=true;

    int noOfSeats;

    @Enumerated(value = EnumType.STRING)
    CarType carType;

    double farePerKm;

    @JoinColumn
    @OneToOne
    Driver driver;


}
