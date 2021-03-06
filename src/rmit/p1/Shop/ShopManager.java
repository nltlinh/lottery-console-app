package rmit.p1.Shop;

import rmit.p1.Lottery.ReleaseLottery;

import java.util.List;

public interface ShopManager {
    public void addShop(Shop s) throws ShopException;
    public void addbyInput() throws ShopException;
    public void deleteShop(String code) throws ShopException;
    public void updateShop (Shop newShop) throws ShopException;
    public void updatebyInput() throws ShopException;
    public void viewAllShop();
    public List<Shop> viewShopCode(String code) throws ShopException;
    public List<Shop> searchShop(String keyword);
    public ShopListMemento backup();
    public void restore(ShopListMemento shopListMemento);
}
