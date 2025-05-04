## Task 2: Marketplace 3

This week, you are to extend your implementation of the Marketplace task from last week.
If you didn’t work on it last week or had issues with it, you can download the **sample solution** for Assignment 2 from the Stud.IP file section of the exercise under `Marketplace2.zip`.

---

### a) Implement the method:

```java
public User login()
```

* This method should **read a username and password up to 3 times**.
* If a user with the entered username **and** password exists in the `Marketplace`, return that user.
* If the login **fails 3 times**, the program should exit using `System.exit(0)`.

---

### b) Implement the method:

```java
public void cli()
```

This method should implement the following **command-line interface (CLI)** features.
Creating and using helper functions is explicitly allowed.

#### CLI Functionalities:

1. Add an item
2. Remove an item
3. Modify an item's name, description, and price
4. Show all items in a category
5. Exit the program

**Note**: A user may only **remove or modify items they own**.

---

### Example CLI Flow

```
Choose one of the following options:
1. Add item
2. Remove item
3. View marketplace
4. Edit item
5. Exit program

>> 3

Which category would you like to view:
1. All
2. CLOTHES
3. ELECTRONICS
...
X. Exit program

>> 2

The following items were found in the CLOTHES category:
[Item: Bag; Price: 10.99; Seller: Max Mustermann; Description: A bag, Category: CLOTHES]

1. Add item
2. Remove item
3. View marketplace
4. Edit item
5. Exit program
```