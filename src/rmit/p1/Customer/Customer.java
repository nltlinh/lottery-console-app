package rmit.p1.Customer;

import rmit.p1.Lottery.ReleaseLottery;

public class Customer {
    // properties
    private String id;
    private String name;
    private String dob;
    private String address;
    private String phone;
    private String email;


    // toString
    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // Constructor

    public Customer(String id, String name, String dob, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Customer() {
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // customer subscribe the lottery release
    public void subscribeLottery(ReleaseLottery releaseLottery){
        releaseLottery.getCustomers().add(this);
    }

}
