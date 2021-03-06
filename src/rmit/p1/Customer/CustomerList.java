package rmit.p1.Customer;

import rmit.p1.Lottery.ReleaseLottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerList implements CustomerManager {
    private List<Customer> customers = new ArrayList<>();

    // No second instance create
    public static CustomerList CUSTOMER = new CustomerList();
    private CustomerList(){
    };

    // Getter and Setter
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    // add a customer
    public void addCustomer (Customer customer){
        this.customers.add(customer);
    }

    public void addbyInput(){
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

    // delete a customer by ID
    public void deleteCustomer (String id){
        for (int i = 0; i < this.customers.size(); i++) {
            Customer customer = this.customers.get(i);
            if (customer.getId().equalsIgnoreCase(id)){
                this.customers.remove(i);
                break;
            }
        }
    }

    // update all info by ID
    public void updateCustomer (Customer newCustomer){
        for (Customer c: this.customers) {
            if (c.getId().equalsIgnoreCase(newCustomer.getId())){
                c.setName(newCustomer.getName());
                c.setDob(newCustomer.getDob());
                c.setAddress(newCustomer.getAddress());
                c.setPhone(newCustomer.getPhone());
                c.setEmail(newCustomer.getEmail());
            }
        }
    }

    public void updatebyInput (){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ID you want to update: ");
        String id = input.nextLine();
        System.out.println("Enter new information name,birthday,address,phone,email (separate by comma): ");
        String[] b = input.nextLine().split(",");
        String name = b[0].trim();
        String dob = b[1].trim();
        String address = b[2].trim();
        String phone = b[3].trim();
        String email = b[4].trim();
        Customer newCustomer = new Customer(id,name,dob,address,phone,email);
        updateCustomer(newCustomer);
    }

    // view all customer
    public void viewAllcustomer(){
        for (Customer c: this.customers){
            System.out.println(c);
        }
    }

    // view customer by ID
    public List<Customer> viewCustomerID (String id){
        List<Customer> result = new ArrayList<>();
        for (Customer c: this.customers) {
            if (c.getId().equalsIgnoreCase(id)){
                result.add(c);
            }
        }
        return result;
    }

    // search by keyword (name, address, email, phone)
    public List<Customer> searchCustomer(String keyword) {
        List<Customer> result = new ArrayList<>();
        for (Customer c : this.customers) {
            if(c.getName().toLowerCase().indexOf(keyword)>-1
                    || c.getAddress().toLowerCase().indexOf(keyword)>-1
                    || c.getEmail().toLowerCase().indexOf(keyword)>-1
                    || c.getPhone().indexOf(keyword)>-1){
                result.add(c);
            }
        }
        return result;
    }

    // subscribe to Lottery result
    public void subscribeLottery(ReleaseLottery releaseLottery) {
        for (Customer c: this.customers) {
            c.subscribeLottery(releaseLottery);
        }
    }

    // Undone Change
    public CustomerListMemento backup(){
        List<Customer> backup = new ArrayList<>();
        for (Customer c: this.customers) {
            backup.add(c);
        }
        return new CustomerListMemento(backup);
    }

    public void restore(CustomerListMemento customerListMemento){
        this.customers = customerListMemento.getCustomers();
    }

}

