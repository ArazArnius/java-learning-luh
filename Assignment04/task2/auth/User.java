package task2.auth;
import task2.offerings.*;

/**
 * this class is for making a user
 * a user has a name and password and also can have items
 * usernames can't change later
 * items can be added or removed
 * 
 * @author Araz Mazaheri
 * @version April 29th, 2025
 */
public class User {
    /** this is the name of the user */
    private String username;

    /** this is the password, we don’t show it for safety */
    private String password;

    /** this is the list of items the user has */
    private Item[] items;

    /**
     * constructor to make a new user
     * starts with no items
     * 
     * @param username the name of the user
     * @param password the password for the user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        items = new Item[0];
    }

    /**
     * getter method for {@link task2.auth.User#username}
     * 
     * @return the username
     */
    public String getUsername() { // no need for setter since usernames don't change
        return username;
    }

    /**
     * setter method for {@link task2.auth.User#password}
     * sets a new password if it's not empty
     * 
     * @param password the new password
     */
    public void setPassword(String password) { // no need for getter because of privacy
        if (password.equals("")) { // false use of `==` as string comparison 
            System.out.println("Error at setting the new password: Password can not be empty. ");
        }
        this.password = password;
    }

    /**
     * checks if the given password is correct for this user
     *
     * @param password the password to check
     * @return true if the password is correct, false otherwise
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password); 
    }


    /**
     * getter method for {@link task2.auth.User#items}
     * 
     * @return all items that belong to this user
     */
    public Item[] getItems() {
        return items;
    }

    /**
     * method to remove an item from the user
     * checks if item is exactly the same before removing
     * 
     * @param item the item to remove
     * @return true if removed, false if not found
     * 
     * @author Araz Mazaheri
     */
    public boolean removeItem(Item item) {
        boolean rmv = false;
        int i = 0; // so that we can save the index of the item in items[]

        // check if it can be removed at all
        for (; i < items.length; i++) {
            if (!items[i].getName().equals(item.getName())) continue; // it's not the same item so continue to the next item in items
            if (items[i].getPrice() != item.getPrice()) continue;
            if (!items[i].getSeller().getUsername().equals(item.getSeller().getUsername())) continue; // the username of the seller
            if (!items[i].getDescription().equals(item.getDescription())) continue;

            rmv = true; // if everything matched with one of the items, then it can be removed
            break;
        }

        if (!rmv) { // if the item can not be removed, do not proceed
            return rmv;
        }

        Item[] new_items = new Item[items.length - 1];

        // actaully remove the item
        for (int j = 0, k = 0; j < new_items.length; k++) { //j is index variable for new_items[], k is i.v. for itemp[]
            if (k == i) { // items[i] shall be removed
                continue;
            } else {
                new_items[j++] = items[k];
            }
        }

        items = new_items;
        return rmv;
    }

    /**
     * method to add a new item to the user
     * only adds if it’s not already in the list
     * 
     * @param item the item to add
     * @return true if added, false if already exists
     * 
     * @author Araz Mazaheri
     */
    public boolean addItem(Item item) {
        // check if the item can be added
        for (int i = 0; i < items.length; i++) {
            if (!items[i].getName().equals(item.getName())) continue; // it's not the same item so continue to the next item in items
            if (items[i].getPrice() != item.getPrice()) continue;
            if (!items[i].getSeller().getUsername().equals(item.getSeller().getUsername())) continue; // the username of the seller
            if (!items[i].getDescription().equals(item.getDescription())) continue;

            return false; // if everything matched. it can't be added
        }
        
        // add the item
        Item[] new_items = new Item[items.length + 1];
        new_items[0] = item;

        // copy items[] into new_items[]
        for (int i = 1; i < new_items.length; i++) {
            new_items[i] = items[i - 1];
        }
        items = new_items;

        return true;
    }
}