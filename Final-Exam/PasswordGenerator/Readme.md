### **Task: Password Generator from Text Input**

**Short name:** `PasswordGen`

**Description:**

Implement a simple application to generate a password based on a text entered by the user.

#### Requirements:

1. Create a class `Generator` in the package/folder `util`.

   * The class should have two `String` attributes: `text` and `password`.
2. The application reads a line of text from the console.
3. The password is generated as follows:

   * Take the **first letter** of each word (words are separated by spaces).
   * **Punctuation at the end of a word** (e.g. `Test.` or `yes::;`) counts as part of the word and does **not** affect splitting.
   * At the end of the password, append the **number of uppercase letters** in the input.
4. The `toString()` method in the `Generator` class should return the generated password.
5. The application must be executable (with a `main()` method), and it should repeat if the user inputs `j`, and exit if the user inputs `n`.
6. Code must be **well-structured and readable** (naming conventions, indentation, and style must be respected).

---

#### Example Output:

```
Input: Hello World, this is a Test.
Output: HWtiaT3

Again? (j/n)
> j

Input: Good Morning 44 Me AaAaA doing fine yes::;
Output: GM4MAdfy6

Again? (j/n)
> n
```