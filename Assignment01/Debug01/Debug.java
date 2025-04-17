class Debug {
/*
Zeile 1: class Keyword falsch geschrieben (ckass):
8 Fehlermeldung:
9 **************
10 Debug.java:1: error: class , interface , or enum expected
11 public ckass Debug {
12 ^
13 **************
14 Der Compiler erwartet eines der drei oben angegebenen Keywords , hat aber nur das falsch
,→ geschriebene ckass bekommen.
*/ 

    // Methode that checks whether a given number is prime
    public static boolean isPrime(int n) {
        // Return false if number is one, zero or negative
        if (n < 2) { // logic error: returned false if n is 2
            return false;
        }
        // Check for all factors smaller and equal to n/2 whether it is a prime factor.
        // If it is a prime factor, return false.
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false; // logic error: returned true when it's devidable by i
            }
        }
        // If no prime factor was found, return true.
        return true;
    }


    // Method that prints all numbers in an array that are prime
    public static void printPrime(int[] arr) {
        /*
        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
	    at Debug.printPrime(Debug.java:35)
	    at Debug.main(Debug.java:44)

        i equal 10 must not go through loop and shall break.
        */
        for (int i = 0; i < arr.length; i++) { // out of bound
            if (isPrime(arr[i])) {
                System.out.println(arr[i]);
            }
        }

    }


    // main added
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printPrime(arr);

        // output should be as follows:
        // 2
        // 3
        // 5
        // 7
    }
}