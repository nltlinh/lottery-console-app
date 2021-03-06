package rmit.p1.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopListMemento {
    private ShopListMemento shopListMemento;
    private List<Shop> shops = new ArrayList<>();

    public ShopListMemento(List<Shop> shops) {
        this.shops = shops;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
