public class IntList {
    // prints integer array
    public static void printIntArray(int[] letters){
        System.out.print("{");
        for(int i = 0; i < letters.length; i++){
            System.out.print(letters[i] + " ");
        }
        System.out.print("} ");
    }

    // calculates a ^ b
    public static int pow (int a, int b) {
        if (b < 0) {
            System.out.println("This function doesn't suuport negativ exponent.");
            return 0;
        }
        int mul = 1;
        for (int i = 0; i < b; i++) {
            mul *= a;
        }

        return mul;
    }

    // counts digits of the given number
    public static int count_digits(int num) { // digits not numbers
        int count = 0;

        while (num > 0) {
            count += 1;
            num /= 10;
        }

        return count;
    }

    // splits given integer into list of its digits
    public static int[] int_to_list(int num) {
        if (count_digits(num) <= 0) {
            return new int[0]; // exception handled by num = 0
        }

        int[] list = new int[count_digits(num)];

        for (int i = count_digits(num) - 1; i >= 0; i--){
            list[i] = num % 10;
            num /= 10;
        }

        return list;
    }

    public static int list_to_int(int[] list) {
        int len = list.length;
        int num = 0;

        if (len == 0) { // edge case handled
            return 0;
        }

        for (int i = 0; i < len; i++) {
            num += list[len - i -1] * pow(10, i);
        }

        return num;
    }

    // adds 1 to an integer in the splitted form and returns the new number as list
    public static int[] add_one(int[] list) {
        int num = list_to_int(list);
        num += 1;
        int[] new_list = int_to_list(num);
        return new_list;
    }

    public static void main (String[] args) {
        // Test case 1: Normal number (1234)
        int a = 1234;
        System.out.println("Test case 1: Normal number (1234)");
        System.out.println(a + " has " + count_digits(a) + " digits.");
        int[] listA = int_to_list(a);
        System.out.print(a + " as a list of digits: ");
        printIntArray(listA); // Expected: 1 2 3 4
        int convertedA = list_to_int(listA);
        System.out.println("converted number from list: " + convertedA); // Expected: 1234
        System.out.println();

        // Test case 2: Zero (0)
        int b = 0;
        System.out.println("Test case 2: Zero (0)");
        System.out.println(b + " has " + count_digits(b) + " digits.");
        int[] listB = int_to_list(b);
        System.out.print(b + " as a list of digits: ");
        printIntArray(listB); // Expected: 0
        int convertedB = list_to_int(listB);
        System.out.println("converted number from list: " + convertedB); // Expected: 0
        System.out.println();

        // Test case 3: Large number (987654)
        int c = 987654321;
        System.out.println("Test case 3: Large number (987654321)");
        System.out.println(c + " has " + count_digits(c) + " digits.");
        int[] listC = int_to_list(c);
        System.out.print(c + " as a list of digits: ");
        printIntArray(listC); // Expected: 9 8 7 6 5 4 3 2 1
        int convertedC = list_to_int(listC);
        System.out.println("converted number from list: " + convertedC); // Expected: 987654321
        System.out.println();

        // Test case 1: Add 1 to {9, 9, 9}
        int[] list1 = {9, 9, 9};
        System.out.println("Test case add_one 1: {9, 9, 9}");
        System.out.print("Original list: ");
        printIntArray(list1); // Expected: 9 9 9
        int[] result1 = add_one(list1);
        System.out.print("List after adding 1: ");
        printIntArray(result1); // Expected: 1 0 0 0
        System.out.println("\n");

        // Test case 2: Add 1 to {1, 2, 3}
        int[] list2 = {1, 2, 3};
        System.out.println("Test case add_one 2: {1, 2, 3}");
        System.out.print("Original list: ");
        printIntArray(list2); // Expected: 1 2 3
        int[] result2 = add_one(list2);
        System.out.print("List after adding 1: ");
        printIntArray(result2); // Expected: 1 2 4
        System.out.println();
    

    }
}