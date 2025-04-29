package task2;
import task2.offerings.*;
import task2.auth.*;

/**
 * represents a marketplace with users and their listed items
 * users can be added and their items can be shown or filtered by category
 * 
 * @author Araz Mazaheri
 * @version April 29th, 2025
 */
public class Marketplace {
    /** stores up to 10 users in the marketplace */
    private User[] users = new User[10];

    /**
     * adds a user to the marketplace
     * if a user with the same username exists, the new user will not be added
     * 
     * @param user the user to be added
     * @return true if the user was added, false if the username already exists
     */
    public boolean addUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getUsername() == user.getUsername()) {
                System.out.println("Error at adding user " + user.getUsername() + ": user already exists! ");
                return false;
            }
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                break;
            }
        }

        return true;
    }

    /**
     * creates a string of all items listed by all users in the marketplace
     * 
     * @return a string that shows all items with their info
     */
    public String str() {
        String items_users = ""; // all users' items

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) { // check if users[i] exists
                // System.out.println(i + " null"); // debug
                continue;
            }

            // System.out.println(i + " user exists"); // debug
            Item[] user_items = users[i].getItems();
            for (int j = 0; j < user_items.length; j++) {
                if (user_items[j] == null) { // check if users[i].items[j] exists
                    continue;
                }

                // single item string format
                items_users += "[Item: " + user_items[j].getName() +
                                "; Price: " + user_items[j].getPrice() + 
                                "; Seller: " + user_items[j].getSeller().getUsername() +
                                "; Category: " + user_items[j].getCategory().str() +
                                "; Description: " + user_items[j].getDescription() + 
                                "]\n";
            }
        }

        return items_users;
    }

    /**
     * filters and returns items that match the given category
     * 
     * @param category the category to filter items by
     * @return a string of all items that belong to the given category
     */
    public String filterMarket(Category category) {
        String filtered_items = ; // all users' items

        for (int i = 0; i < users.length; i++) {
            // check if users[i] exists
            if (users[i] == null) { 
                continue;
            }

            // System.out.println(i + " user exists"); // debug
            Item[] user_items = users[i].getItems();
            for (int j = 0; j < user_items.length; j++) {
                // check if users[i].items[j] exists or category doesn't match
                // it wouldn't be problematic because of short circuit expressions
                if (user_items[j] == null || user_items[j].getCategory() != category) { 
                    continue;
                }

                // single item string format
                filtered_items += "[Item: " + user_items[j].getName() +
                                "; Price: " + user_items[j].getPrice() + 
                                "; Seller: " + user_items[j].getSeller().getUsername() +
                                "; Category: " + user_items[j].getCategory().str() +
                                "; Description: " + user_items[j].getDescription() + 
                                "]\n";
            }
        }

        return filtered_items;
    }

    /**
     * runs example tests to show the usage of the marketplace
     * creates users and items and tests adding and removing them
     * also shows category filtering
     */
    public static void main(String[] args) {
        Marketplace market_place = new Marketplace();

        User user1 = new User("Araz Mazaheri", "password");
        user1.addItem(new Item("Bicycle", (float)420.00, user1, Category.OTHER, "Mountain bike, slightly used")); // Error: possible lossy conversion from double to float
        user1.addItem(new Item("Laptop", (float)899.99, user1, Category.ELECTRONICS, "A used laptop in good condition"));
        market_place.addUser(user1);
        System.out.println("1st test: first user added.\n" + market_place.str());

        User user2 = new User("Dr. Matthias Becker", "veryhardpassword");
        user2.addItem(new Item("Headphones", (float)39.95, user2, Category.ELECTRONICS, "Noise-cancelling over-ear headphones"));
        user2.addItem(new Item("Desk Lamp", (float)15.50, user2, Category.ELECTRONICS, "LED lamp with adjustable brightness"));
        Item sofa = new Item("Sofa", (float)25.00, user2, Category.FURNITURE, "Best in the market orange sofa");
        user2.addItem(sofa);
        market_place.addUser(user2);
        System.out.println("2nd test: user added.\n" + market_place.str());

        User user3 = new User("Araz Mazaheri", "anotherpassowrd"); // user with same name 
        user3.addItem(new Item("Coffee Maker", (float)35.00, user3, Category.FURNITURE, "Brews fast, barely used")); 
        user3.addItem(new Item("Gaming Mouse", (float)29.99, user3, Category.ELECTRONICS, "RGB lights, like new"));
        market_place.addUser(user3); // user will not be added (and their corresponding products)
        System.out.println("3rd test: user with existing username can not be added.\n" + market_place.str());

        user2.removeItem(sofa);
        System.out.println("4th test: item sofa removed.\n" + market_place.str());

        System.out.println("5th test: apply category filter: Electronics.\n" + market_place.filterMarket(Category.ELECTRONICS));
    }
}