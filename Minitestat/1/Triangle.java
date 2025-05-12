public class Triangle {
    public static void main (String[] args) {
        int len = Integer.parseInt(args[0]);
        StringBuilder result = new StringBuilder(); // ChatGpt doesn't like the string concatenation in the loops
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
                    result.append(" ");
                } else { // then asterisks
                    result.append("*");
                }
            }
            result.append("\n");
        }

        System.out.println(result);
    }
}