package ratanpur.com.example.BusRide.Exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String msg){
        super(msg);
    }

}
