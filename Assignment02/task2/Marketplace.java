import offerings.*;
import auth.*;

public class Marketplace {
    private User[] users = new User[10];

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
            }
        }

        return true;
    }

    public String str() {
        String items_users = ""; // all users' items

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) { // check if users[i] exists
                continue;
            }

            System.out.println(users[i].getUsername() + ": ");

            Item[] user_items = users[i].getItems();
            for (int j = 0; j < user_items.length; j++) {
                if (user_items[j] == null) { // check if users[i].items[j] exists
                    continue;
                }

                // single item string format
                String s_item = "[Item: " + user_items[j].getName() +
                                "; Price: " + user_items[j].getPrice() + 
                                "; Seller: " + user_items[j].getSeller().getUsername() +
                                "; Description: " + user_items[j].getDescription() + 
                                "]\n";

                items_users += s_item;
            }
        }

        return items_users;
    }


    public static void main(String[] args) {
        Marketplace market_place = new Marketplace();

        User user1 = new User("Araz Mazaheri", "password");
        user1.addItem(new Item("Bicycle", (float)420.00, user1, "Mountain bike, slightly used")); // Error: possible lossy conversion from double to float
        user1.addItem(new Item("Laptop", (float)899.99, user1, "A used laptop in good condition"));
        market_place.addUser(user1);
        System.out.println(market_place.str());

        User user2 = new User("Dr. Matthias Becker", "veryhardpassword");
        user2.addItem(new Item("Headphones", (float)39.95, user2, "Noise-cancelling over-ear headphones"));
        user2.addItem(new Item("Desk Lamp", (float)15.50, user2, "LED lamp with adjustable brightness"));
        user2.addItem(new Item("Backpack", (float)25.00, user2, "Waterproof and durable, great for school"));
        market_place.addUser(user2);
        System.out.println(market_place.str());
    }
}