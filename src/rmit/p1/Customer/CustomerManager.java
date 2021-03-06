package rmit.p1.Customer;

import rmit.p1.Lottery.ReleaseLottery;

import java.util.List;

public interface CustomerManager {
    public void addCustomer (Customer customer) throws CustomerException;
    public void addbyInput() throws CustomerException;
    public void deleteCustomer (String id) throws CustomerException;
    public void updateCustomer (Customer newCustomer) throws CustomerException;
    public void updatebyInput () throws CustomerException;
    public void viewAllcustomer();
    public List<Customer> viewCustomerID (String id) throws CustomerException;
    public List<Customer> searchCustomer(String keyword);
    public void subscribeLottery(ReleaseLottery releaseLottery);
    public CustomerListMemento backup();
    public void restore(CustomerListMemento customerListMemento);
}
