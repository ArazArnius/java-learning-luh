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
        String filtered_items = ""; // all users' items

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

    public User login(Scanner sc) {
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
                        System.out.printf("Error: Wrong password. %d tries left!\n", 2 - j);
                    }

                    System.out.println("Error: Too many attempts. Please try again later.");
                    sc.close();
                    System.exit(0);
                }
            }
            System.out.printf("Error: User doesn't exist. %d tries left!\n", 2 - i);
        }
        System.out.println("Error: Unexpected error occured!");
        return null;
    }

    public void cli(Scanner sc, User user) { // getting user as parameter to avoid asking for login on each command
        System.out.println("Choose one of the following options: \n\t1. Add item\n\t2. Remove item" +
                            "\n\t3. View marketplace\n\t4. Edit item\n\t5. Exit program");
        int key = sc.nextInt();
        sc.nextLine();
        System.out.println();

        switch (key) {
            case 1: { // add an item, name, price, seller, category, description
                addItem(sc, user);
                break;
            }
            case 2: { // remove an item
                removeItem(sc, user);
                break;
            }
            case 3: { // view marketplace
                viewMarketplace(sc);
                break;
            }
            case 4: { // edit an item
                editItem(sc, user);
                break;
            }
            default: { // exit program
                sc.close();
                System.exit(0);
            }
        }
    }

    public void editItem(Scanner sc, User user) {
        System.out.println("List of the items is as shown below: \n" + str());
        System.out.printf("Which item would you like to edit (for example 2)? ");

        int edit_index = sc.nextInt() - 1; // becuase the indexes are shown as index + 1
        sc.nextLine();
        System.out.println();
        Item edit_item = findItem(edit_index);

        if (!edit_item.getSeller().getUsername().equals(user.getUsername())) { // if it's another user trying to edit an item
            System.out.println("You do not have the permission to modify this item!");
            return;
        }

        System.out.println("What would you like to edit:\n\t1. Name" + 
                            "\n\t2. Price\n\t3. Description");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println();

        switch (choice) {
            case 1: {
                System.out.printf("Changing name of the product\nWhat is the new name? (for example: Backpack) ");
                String name = sc.nextLine();
                edit_item.setName(name);
                break;
            }
            case 2: {
                System.out.printf("Changing price of the product\nWhat is the new price? (for example: 23.00) ");
                float price = sc.nextFloat();
                sc.nextLine();
                edit_item.setPrice(price);
                break;
            }
            case 3: {
                System.out.printf("Changing description of the product\n" + 
                                    "What is the new description? (for example: Red school bag) ");
                String description = sc.nextLine();
                edit_item.setDescription(description);
                System.out.println("description is actually changed!");
                break;
            }
            default: {
                System.out.println("Error: invalid entry. Please try again!");
            }
        }
        System.out.println("Item is edited successfully!\n");
    }

    public void viewMarketplace(Scanner sc) {
        System.out.println("Which category would you like to view:\n\t1. All" + 
                            "\n\t2. Furniture\n\t3. Electronics\n\t4. Other");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println();

        switch (choice) {
            case 1: {
                System.out.println(str());
                break;
            }
            case 2: {
                System.out.println(filterMarket(Category.FURNITURE));
                break;
            }
            case 3: {
                System.out.println(filterMarket(Category.ELECTRONICS));
                break;
            }
            case 4: {
                System.out.println(filterMarket(Category.OTHER));
                break;
            }
        }
    }

    /**
     * removes an item from the user's items list
     * 
     * @param user the user to whome the item will be assigned
     */
    public void removeItem(Scanner sc, User user) {
        System.out.println("List of the items is as shown below: \n" + str());
        System.out.printf("Which item would you like to remove (for example 2)? ");

        int rmv_index = sc.nextInt() - 1; // becuase the indexes are shown as index + 1
        sc.nextLine();
        System.out.println();
        Item rmv_item = findItem(rmv_index);

        System.out.println("Are you sure you want to remove this item? (y/n)\n" + rmv_item);
        String confirm = sc.nextLine().toLowerCase();

        if (!rmv_item.getSeller().getUsername().equals(user.getUsername())) { // if it's another user trying to delete an item
            System.out.println("You do not have the permission to delete this item!\n");
            return;
        }

        if (!confirm.equals("y")) {
            System.out.println("Then kindly try again!\n");
            return;
        }

        user.removeItem(rmv_item);
        System.out.println("Item is removed successfully!\n");
    }

    /**
     * finds an item based on the index in which the program discovers items
     * know that index starts at 0 and not like natural numbers
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

        System.out.println("Error: couldn't find an item at the given index.");
        return null;
    }

    /**
     * adds an item to the user's items list
     * 
     * @param user the user to whome the item will be assigned
     */
    public void addItem(Scanner sc, User user) {
        System.out.printf("Adding Item!\nPlease enter the name of the product: ");
        String name = sc.nextLine();
        System.out.printf("Please enter the price of the product (for example: 3.50): ");
        float price = sc.nextFloat(); // apparently I have to add nextLine() here to consume the \n
        sc.nextLine();
        System.out.printf("Please enter the category of the product (for example: Furniture): ");
        String category = sc.nextLine().toLowerCase();
        System.out.printf("Please enter the description of the product: ");
        String description = sc.nextLine();

        user.addItem(new Item(name, price, user, stringToCategory(category), description));
        System.out.println("Item added successfully!\n");
    }

    /**
     * converts a string to a Category enum if it matches a known category name
     * 
     * @param category the string to convert
     * @return the matching Category enum, or null if no match
     */
    public static Category stringToCategory(String category) { 
        if (category.equals("furniture")) return Category.FURNITURE;         
        if (category.equals("electronics")) return Category.ELECTRONICS;
        if (category.equals("other")) return Category.OTHER;
        return null;
    }

    /**
     * runs example tests to show the usage of the marketplace
     * creates users and items and tests adding and removing them
     * also shows category filtering
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

        // running the CLI here
        User test_user = market_place.login(sc);
        while (true){
            market_place.cli(sc, user1);
        }
        // sc.close();
    }
}