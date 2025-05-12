public class Triangle {
    public static void main (String[] args) {
        int len = Integer.parseInt(args[0]);
        String result = "";
        System.out.println("The given length of the pyramid is " + len + "\n");

        /*
            *
           **
          ***
         ****
        *****
        */

        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < len; j++) { // spaces on the beginning
                if (j < len - i) {
                    result += " ";
                } else { // then asterisks
                    result += "*";
                }
            }
            result += "\n";
        }

        System.out.println(result);
    }
}