package rmit.p1.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerListMemento {
    private CustomerListMemento customerListMemento;
    private List<Customer> customers = new ArrayList<>();

    public CustomerListMemento(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
