package rmit.p1.Shop;

import rmit.p1.Customer.Customer;
import rmit.p1.Lottery.ReleaseLottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopList implements ShopManager {
    private List<Shop> shops = new ArrayList<>();

    public static ShopList SHOP = new ShopList();
    private ShopList(){
    };

    // getter and setter
    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    // add a shop
    public void addShop(Shop s){
        this.shops.add(s);
    }

    public void addbyInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter information Code,address,owner,phone,email,account balance (separate by comma): ");
        String[] b = input.nextLine().split(",");
        String code = b[0].trim();
        String add = b[1].trim();
        String owner = b[2].trim();
        String phone = b[3].trim();
        String email = b[4].trim();
        String accBalance = b[5].trim();
        Shop newShop = new Shop(code,add,owner,phone,email,accBalance );
        addShop(newShop);
    }

    // delete a shop by code
    public void deleteShop(String code){
        for (int i = 0; i < this.shops.size(); i++) {
            Shop shop = this.shops.get(i);
            if (shop.getCode().equalsIgnoreCase(code)) {
                this.shops.remove(i);
                break;
            }
        }
    }

    // update all info by create a new shop with same CODE
    public void updateShop (Shop newShop){
        for (Shop s: this.shops) {
            if (s.getCode().equalsIgnoreCase(newShop.getCode())){
                s.setAddress(newShop.getAddress());
                s.setPhone(newShop.getPhone());
                s.setEmail(newShop.getEmail());
                s.setOwner(newShop.getOwner());
                s.setAccBalance(newShop.getAccBalance());
            }
        }
    }
    public void updatebyInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Code you want to update: ");
        String code = input.nextLine();
        System.out.println("Enter new information address, owner, phone, email, account balance (separate by comma): ");
        String[] b = input.nextLine().split(",");
        String add = b[0].trim();
        String owner = b[1].trim();
        String phone = b[2].trim();
        String email = b[3].trim();
        String accBalance = b[4].trim();
        Shop newShop = new Shop(code,add,owner,phone,email,accBalance);
        updateShop(newShop);
    }


    // view all shop
    public void viewAllShop(){
        for (Shop s: this.shops) {
            System.out.println(s);
        }
    }

    // view shop by code
    public List<Shop> viewShopCode(String code){
        List<Shop> result = new ArrayList<>();
        for (Shop s: this.shops) {
            if (s.getCode().equalsIgnoreCase(code)){
                result.add(s);
            }
        }
        return result;
    }
    // search by keyword
    public List<Shop> searchShop(String keyword) {
        List<Shop> result = new ArrayList<>();
        for (Shop s : this.shops) {
            if(s.getOwner().toLowerCase().indexOf(keyword)>-1
                    || s.getAddress().toLowerCase().indexOf(keyword)>-1
                    || s.getEmail().toLowerCase().indexOf(keyword)>-1
                    || s.getPhone().indexOf(keyword)>-1){
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public ShopListMemento backup() {
        List<Shop> backup = new ArrayList<>();
        for (Shop s: this.shops) {
            backup.add(s);
        }
        return new ShopListMemento(backup);
    }

    @Override
    public void restore(ShopListMemento shopListMemento) {
        this.shops = shopListMemento.getShops();
    }
}
