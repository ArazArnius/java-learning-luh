public class Encryption {
    // generate the next number
    public static int nextInt(int a, int b, int m, int x){
        return (a * x + b) % m;
    }

    public static int[] key_generator(int a, int len){
        int[] key = new int[len];
        key[0] = a;
        for (int i = 1; i < len; i++){
            key[i] = nextInt(7, 28, 256, key[i-1]);
        }
        return key;
    }

    // print char array in a line.
    public static void printCharArray(char[] letters){
        for(int i = 0; i < letters.length; i++){
            System.out.print(letters[i]);
        }
    }

    public static void printIntArray(int[] letters){
        for(int i = 0; i < letters.length; i++){
            System.out.print(letters[i] + " ");
        }
    }

    public static char int_to_char(int a) {
        return (char) a;
    }

    public static int char_to_int(char c) {
        return (int) c;
    }

    public static int[] encrypt(char[] letters, int[] keys){
        if (letters.length > 0){
            int[] enc = new int[letters.length];
            enc[0] = char_to_int(letters[0]) ^ keys[0];

            for (int i = 1; i < letters.length; i++){
                enc[i] = char_to_int(letters[i]) ^ keys[i] ^ enc[i-1];
            }
            return enc;
        }
        else{
            return null;
        }
    }

    public static char[] decrypt(int[] enc, int[] keys){
        if (enc.length > 0){
            char[] dec = new char[enc.length];
            dec[0] = int_to_char(enc[0] ^ keys[0]); // (l ^ k) ^ k = l

            for (int i = 1; i < enc.length; i++){
                dec[i] = int_to_char(enc[i] ^ keys[i] ^ enc[i-1]); // (l ^ k ^ e) ^ k ^ e
            }
            return dec;
        }
        else{
            return null;
        }
    }

    public static void main(String[] args){
        int a = nextInt(7, 28, 256, 3); // first element of keys
        char[] letters = {'Y', 'i', 'p', 'e', 'e'};
        int[] key = key_generator(a, letters.length);

        System.out.print("Original Text: ");
        printCharArray(letters);
        System.out.print("\nEncrypted Text: ");
        printIntArray(encrypt(letters, key));
        System.out.print("\nDecrypted Text: ");
        printCharArray(decrypt(encrypt(letters, key), key));
        System.out.println();

    }
}
