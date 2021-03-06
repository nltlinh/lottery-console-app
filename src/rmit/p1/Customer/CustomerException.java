package rmit.p1.Customer;

public class CustomerException extends Exception {
    public CustomerException(String message) {
        super(message);
        System.out.println("CUSTOMER EXCEPTION: "+message);
    }

}
