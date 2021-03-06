package rmit.p1.Shop;

public class ShopException extends Exception {
    public ShopException(String message) {
        super(message);
        System.out.println("SHOP EXCEPTION: "+message);
    }
}
