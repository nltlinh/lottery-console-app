package rmit.p1.Shop;

public class Shop {
    // properties
    private String code;
    private String address;
    private String owner;
    private String phone;
    private String email;
    private String accBalance;


    // Constructor
    public Shop(String code, String address, String owner, String phone, String email, String accBalance) {
        this.code = code;
        this.address = address;
        this.owner = owner;
        this.phone = phone;
        this.email = email;
        this.accBalance = accBalance;
    }

    public Shop(String code, String address, String owner, String phone, String email) {
        this.code = code;
        this.address = address;
        this.owner = owner;
        this.phone = phone;
        this.email = email;
    }

    public Shop() {
    }

    // toString

    @Override
    public String toString() {
        return "Shop{" +
                "code='" + code + '\'' +
                ", address='" + address + '\'' +
                ", owner='" + owner + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", accBalance=" + accBalance +
                '}';
    }

    // getter and setter
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public String getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(String accBalance) {
        this.accBalance = accBalance;
    }


}
