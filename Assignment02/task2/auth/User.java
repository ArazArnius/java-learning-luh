package auth;

public class User {
    private String username;
    private String password;
    private Item[] items;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static String getUsername() { // no need for setter since usernames don't change
        return username;
    }

    public void setPassword(String password) { // no need for getter because of privacy
        if (password == "") {
            System.out.println("Error at setting the new password: Password can not be empty. ");
        }
        this.password = password;
    }

    public Item[] getItems() {
        return items;
    }

    // determines whether an item can be removed or not (return true if the item is already in items[])
    public boolean removeItem(Item item) {
        boolean rmv = false;
        int i = 0; // so that we can save the index of the item in items[]

        // check if it can be removed at all
        for (; i < items.length; i++) {
            if (items[i].getName() != item.getName()) {
                continue; // it's not the same item so continue to the next item in items
            } else if (items[i].getPrice() != item.getPrice()) {
                continue;
            } else if (items[i].getSeller().getUsername() != item.getSeller().getUsername()) { // the username of the seller
                continue;
            } else if (items[i].getDescription() != item.getDescription()) {
                continue;
            }

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

    // determines whether an item can be added or not (returns true if item is not already in items[])
    public boolean addItem(Item item) {
        // check if the item can be added
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName() != item.getName()) {
                continue; // it's not the same item so continue to the next item in items
            } else if (items[i].getPrice() != item.getPrice()) {
                continue;
            } else if (items[i].getSeller().getUsername() != item.getSeller().getUsername()) { // the username of the seller
                continue;
            } else if (items[i].getDescription() != item.getDescription()) {
                continue;
            }

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