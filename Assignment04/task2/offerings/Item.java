package task2.offerings;
import task2.auth.*;
// import task2.offerings.Category; // so that there's no need to compile Category (apparently it's not needed)

/**
 * this class represents an item with details like name, price, seller, category, and description
 * each item is linked to a seller and has a specific category
 * 
 * @author Araz Mazaheri
 * @version April 29th, 2025
 */
public class Item {
    /** the name of the item */
    private String name;

    /** the price of the item */
    private float price;

    /** the user selling the item */
    private User seller;

    /** the category of the item */
    private Category category;

    /** the description of the item */
    private String description;

    /**
     * constructor to create a new item
     * 
     * @param name the name of the item
     * @param price the price of the item
     * @param seller the seller of the item
     * @param category the category the item belongs to
     * @param description a description of the item
     */
    public Item(String name, float price, User seller, Category category, String description) {
        this.name = name;
        this.price = price;
        this.seller = seller;
        this.category = category;
        this.description = description;
    }

    /**
     * getter method for {@link task2.offerings.Item#name}
     * 
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * setter method for {@link task2.offerings.Item#name}
     * 
     * @param name the new name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method for {@link task2.offerings.Item#price}
     * 
     * @return the price of the item
     */
    public float getPrice() {
        return price;
    }

    /**
     * getter method for {@link task2.offerings.Item#category}
     * 
     * @return the category of the item
     */
    public Category getCategory() {
        return category;
    }

    /**
     * setter method for {@link task2.offerings.Item#price}
     * sets a new price for the item if it's not negative
     * 
     * @param price the new price for the item
     */
    public void setPrice(float price) {
        if (price < 0) {
            System.out.println("Error at setting the price: negative price is not valid! ");
            return;
        }
        this.price = price;
    }

    /**
     * getter method for {@link task2.offerings.Item#seller}
     * 
     * @return the user who is selling the item
     */
    public User getSeller() {
        return seller;
    }

    /**
     * setter method for {@link task2.offerings.Item#seller}
     * 
     * @param seller the new seller for the item
     */
    public void setSeller(User seller) {
        this.seller = seller;
    }

    /**
     * getter method for {@link task2.offerings.Item#description}
     * 
     * @return the description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter method for {@link task2.offerings.Item#description}
     * 
     * @param description the new description of the item
     */
    public void setDescription(String description) { // description was written as Description:)))
        this.description = description;
    }

    @Override
    public String toString() {
        String result = "[Item: " + name +
                            "; Price: " + price + 
                            "; Seller: " + seller.getUsername() +
                            "; Category: " +category.str() +
                            "; Description: " + description + "]";
        return result;
    }
}