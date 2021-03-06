package rmit.p1.Shop;

import rmit.p1.Customer.CustomerException;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ShopListCheck implements ShopManager {
    private ShopManager shopManager;

    // No second instance create
    public static ShopListCheck SHOPINSTANCE = new ShopListCheck(ShopList.SHOP);
    private ShopListCheck(){
    };

    public ShopListCheck(ShopManager shopManager) {
        this.shopManager = shopManager;
    }

    @Override
    public void addShop(Shop s) throws ShopException {
        if (!Pattern.matches("[s]{1}[0-9]{5}",s.getCode()))
            throw new ShopException("Invalid CODE");
        shopManager.addShop(s);
    }

    @Override
    public void addbyInput() throws ShopException {
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

    @Override
    public void deleteShop(String code) throws ShopException{
        if (!Pattern.matches("[s]{1}[0-9]{5}",code))
            throw new ShopException("Invalid CODE");
        shopManager.deleteShop(code);
    }

    @Override
    public void updateShop(Shop newShop) throws ShopException {
        if (!Pattern.matches("[s]{1}[0-9]{5}",newShop.getCode()))
            throw new ShopException("Invalid CODE");
        shopManager.updateShop(newShop);
    }

    @Override
    public void updatebyInput() throws ShopException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Code you want to update: ");
        String code = input.nextLine();
        System.out.println("Enter new information address,owner,phone,email,account balance (separate by comma): ");
        String[] b = input.nextLine().split(",");
        String add = b[0].trim();
        String owner = b[1].trim();
        String phone = b[2].trim();
        String email = b[3].trim();
        String accBalance = b[4].trim();
        Shop newShop = new Shop(code,add,owner,phone,email,accBalance);
        updateShop(newShop);
    }

    @Override
    public void viewAllShop() {
        shopManager.viewAllShop();
    }

    @Override
    public List<Shop> viewShopCode(String code) throws ShopException {
        if (!Pattern.matches("[s]{1}[0-9]{5}",code))
            throw new ShopException("Invalid CODE");
        return shopManager.viewShopCode(code);
    }

    @Override
    public List<Shop> searchShop(String keyword) {
        return shopManager.searchShop(keyword);
    }

    @Override
    public ShopListMemento backup() {
        return shopManager.backup();
    }

    @Override
    public void restore(ShopListMemento shopListMemento) {
        shopManager.restore(shopListMemento);
    }
}
