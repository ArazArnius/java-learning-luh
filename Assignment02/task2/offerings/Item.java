package offerings;
import auth.*;

public class Item {
    private String name;
    private float price;
    private User seller;
    private String description;

    public Item(String name, float price, User seller, String description) {
        this.name = name;
        this.price = price;
        this.seller = seller;
        this.description = description;
    }

    // name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // price
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price < 0) {
            System.out.println("Error at setting the price: negative price is not valid! ");
            return;
        }
        this.price = price;
    }

    // seller
    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    // description
    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = description;
    }

}