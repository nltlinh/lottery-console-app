package rmit.p1.Customer;

import rmit.p1.Lottery.ReleaseLottery;
import rmit.p1.Shop.ShopList;
import rmit.p1.Shop.ShopListCheck;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerListCheck implements CustomerManager {
    private CustomerManager customerManager;

    // No second instance create
    public static CustomerListCheck CUSINSTANCE = new CustomerListCheck(CustomerList.CUSTOMER);
    private CustomerListCheck(){
    };

    public CustomerListCheck(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    @Override
    public void addCustomer(Customer customer) throws CustomerException {
        if (!Pattern.matches("[c]{1}[0-9]{5}",customer.getId()))
            throw new CustomerException("Invalid ID");
        customerManager.addCustomer(customer);
    }

    @Override
    public void addbyInput() throws CustomerException{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter information id,name,birthday,address,phone,email (separate by comma): ");
        String[] b = input.nextLine().split(",");
        String id = b[0].trim();
        String name = b[1].trim();
        String dob = b[2].trim();
        String address = b[3].trim();
        String phone = b[4].trim();
        String email = b[5].trim();
        Customer newCus = new Customer(id,name,dob,address,phone,email);
        addCustomer(newCus);
    }

    @Override
    public void deleteCustomer(String id) throws CustomerException {
        if (!Pattern.matches("[c]{1}[0-9]{5}",id))
            throw new CustomerException("Invalid ID");
        customerManager.deleteCustomer(id);

    }

    @Override
    public void updateCustomer(Customer newCustomer) throws CustomerException {
        if (!Pattern.matches("[c]{1}[0-9]{5}",newCustomer.getId()))
            throw new CustomerException("Invalid ID");
        customerManager.updateCustomer(newCustomer);
    }

    @Override
    public void updatebyInput() throws CustomerException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ID you want to update: ");
        String id = input.nextLine();
        System.out.println("Enter new information name, birthday, address, phone, email (separate by comma): ");
        String[] b = input.nextLine().split(",");
        String name = b[0].trim();
        String dob = b[1].trim();
        String address = b[2].trim();
        String phone = b[3].trim();
        String email = b[4].trim();
        Customer newCustomer = new Customer(id,name,dob,address,phone,email);
        updateCustomer(newCustomer);
    }

    @Override
    public void viewAllcustomer() {
        customerManager.viewAllcustomer();
    }

    @Override
    public List<Customer> viewCustomerID(String id) throws CustomerException {
        if (!Pattern.matches("[c]{1}[0-9]{5}",id))
            throw new CustomerException("Invalid ID");
        return customerManager.viewCustomerID(id);
    }

    @Override
    public List<Customer> searchCustomer(String keyword) {
        return customerManager.searchCustomer(keyword);
    }

    @Override
    public void subscribeLottery(ReleaseLottery releaseLottery) {
        customerManager.subscribeLottery(releaseLottery);
    }

    @Override
    public CustomerListMemento backup() {
        return customerManager.backup();
    }

    @Override
    public void restore(CustomerListMemento customerListMemento) {
        customerManager.restore(customerListMemento);
    }
}
