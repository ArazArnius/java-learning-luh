package task2.offerings;

/**
 * this enum shows what type an item is
 * it can be furniture, electronics, or other
 * each type also has a string name
 * 
 * @author Araz Mazaheri
 * @version April 29th, 2025
 */
public enum Category {
    /** item is a furniture */
    FURNITURE("Furniture"),

    /** item is electronics */
    ELECTRONICS("Electronics"),

    /** item is not in the other two groups */
    OTHER("Other");

    /** this is the text name of the category */
    private String category_name;
    
    /**
     * makes a new category with a string name
     * 
     * @param category_name the name of the category as a string
     */
    Category(String category_name) {
        this.category_name = category_name;
    }

    /**
     * getter method for {@link task2.offerings.Category#category_name}
     * 
     * @return the name of this category as a string
     */
    public String str() {
        return category_name;
    }
}