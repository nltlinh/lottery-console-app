package rmit.p1.Lottery;

import rmit.p1.Customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class ReleaseLottery implements Lottery {
    private Lottery lottery;
    private static List<Customer> customers = new ArrayList<>();

    // getter and setter
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public ReleaseLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    // method inform the result to the customer
    public void informCustomer(){
        for (Customer c:customers){
            System.out.println("Inform the result to: "+c);
        }
    }

    @Override
    public int[] lottery() {
        informCustomer();
        return lottery.lottery();
    }
}
