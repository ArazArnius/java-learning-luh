package task2;
import task2.offerings.*;
import task2.auth.*;
import java.util.Scanner;

/**
 * represents a marketplace with users and their listed items
 * users can be added and their items can be shown or filtered by category
 * 
 * @author Araz Mazaheri
 * @version May 4th, 2025
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
        int count = 1; // attention: indexes in programming start from 0

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
                items_users += count++ + ". [Item: " + user_items[j].getName() +
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

    public User login() {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++) { // user can enter a valid username up to three times
            System.out.printf("Enter username: ");
            String username = sc.nextLine();

            for (User u : users) {
                if (u != null && u.getUsername().equals(username)) { // user found
                    for(int j = 0; j < 3; j++) {
                        System.out.printf("Enter password: ");
                        String password = sc.nextLine();
                        if (u.checkPassword(password)) {
                            System.out.println("Login successful.");
                            return u;
                        }
                        System.out.printf("Error: Wrong password. %d tries left!\n", j);
                    }

                    System.out.println("Error: Too many attempts. Please try again later.");
                    System.exit(0);
                }
            }
            System.out.printf("Error: User doesn't exist. %d tries left!\n", i);
        }
        System.out.println("Error: Unexpected error occured!");
    }

    public void cli(User user) { // getting user as parameter to avoid asking for login on each command
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();

        switch (key) {
            case 1: { // add an item, name, price, seller, category, description
                addItem(user);
                break;
            }
            case 2: { // remove an item

            }
                break;
            case 3: // view marketplace
                break;
            case 4: // edit an item
                break;
            default: // exit program
                System.exit(0);
        }
    }

    /**
     * removes an item from the user's items list
     * 
     * @param user the user to whome the item will be assigned
     */
    public void removeItem(User user) {
        Scanner sc = new Scanner(System.in);

        System.out.println("List of the items is as shown below: \n" + str());
        System.out.printf("Which item would you like to remove (for example 3)? ");

        int to_remove = sc.nextInt() - 1; // becuase the indexes are shown as index + 1


    }

    /**
     * finds an item based on the index in which the program discovers items
     * 
     * @param index the index in which the item is at
     * @return item is the item in that index
     */
    public Item findItem(int index) {
        int count = 0;

        for (User u : users) {
            if (u == null) continue; // check if u exists
                
            Item[] user_items = u.getItems();
            for (Item item : user_items) {
                if (item == null) { // check if users[i].items[j] exists
                    continue;
                }
                if (count == index) return item;

                count++;
                continue;
            }
        }

        System.out.println("Error: couldn't find an item at the given index.")
        return null;
    }

    /**
     * adds an item to the user's items list
     * 
     * @param user the user to whome the item will be assigned
     */
    public void addItem(User user) {
        System.out.printf("Adding Item:\nPlease enter the name of the product: ");
        String name = sc.nextLine();
        System.out.printf("Please enter the price of the product (for example: 3.50): ");
        float price = sc.nextFloat();
        System.out.printf("Please enter the category of the product (for example: Furniture): ");
        String category = sc.nextLine();
        System.out.printf("Please enter the description of the product: ");
        String description = sc.nextLine();

        user.addItem(new Item(name, price, stringToCategory(category), user, description));
        System.out.println("Item added successfully.");
    }

    /**
     * converts a string to a Category enum if it matches a known category name
     * 
     * @param category the string to convert
     * @return the matching Category enum, or null if no match
     */
    public static Category stringToCategory(String category) { 
        if (category.equals(Category.FURNITURE.str())) return Category.FURNITURE;         
        if (category.equals(Category.ELECTRONICS.str())) return Category.ELECTRONICS;
        if (category.equals(Category.OTHER.str())) return Category.OTHER;
        return null;
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