# **Prog 2 – Mini-Testat 1: Task Description**

Please complete the following two programming tasks. Make sure your code is well-structured, properly commented, and uses meaningful variable names.

---

## **Task 1: Mirrored Triangle**

Write a program that takes an integer as input (e.g., via `args[0]`) and prints a right-aligned triangle of asterisks (`*`), similar to the triangle from the 2024 test, but **mirrored horizontally** (right-aligned).
That means: leading spaces should be printed on the left so that the triangle is aligned to the right.

**Example (input: `5`):**

```
        *
       **
      ***
     ****
    *****
```

---

## **Task 2: Shifted String Output**

Write a program that:

1. Reads a string from the user using `Scanner`,
2. Reads an integer from the user,
3. Outputs the string where each character is shifted to the right in the alphabet by the given amount.

The shift should:

* Apply only to **lowercase letters** (`a`–`z`),
* Wrap around at the end of the alphabet.

**Example:**

```
Input string: hallo  
Shift: 2  
Output: jcnnq
```
