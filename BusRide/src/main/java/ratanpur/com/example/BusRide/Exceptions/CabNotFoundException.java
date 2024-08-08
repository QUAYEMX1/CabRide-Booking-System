package ratanpur.com.example.BusRide.Exceptions;

public class CabNotFoundException extends RuntimeException{
    public CabNotFoundException(String msg){
        super(msg);
    }
}
