package com.labs1904;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SecretRecipeDecoder {
    private static Map<String, String> ENCODING = new HashMap<String, String>() {
        {
            put("y", "a");
            put("h", "b");
            put("v", "c");
            put("x", "d");
            put("k", "e");
            put("p", "f");
            put("z", "g");
            put("s", "h");
            put("a", "i");
            put("b", "j");
            put("e", "k");
            put("w", "l");
            put("u", "m");
            put("q", "n");
            put("n", "o");
            put("l", "p");
            put("m", "q");
            put("f", "r");
            put("o", "s");
            put("i", "t");
            put("g", "u");
            put("j", "v");
            put("t", "w");
            put("d", "x");
            put("r", "y");
            put("c", "z");
            put("3", "0");
            put("8", "1");
            put("4", "2");
            put("0", "3");
            put("2", "4");
            put("7", "5");
            put("5", "6");
            put("9", "7");
            put("1", "8");
            put("6", "9");
        }
    };

    /**
     * Given a string named str, use the Caesar encoding above to return the decoded string.
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        // TODO: implement me
        //declare and initiate decodedStr
        String decodedStr ="";

        //loop through str chars
        for(int i= 0 ; i < str.length(); i++) {
            // change str.charAt(i) to be String type
            String decodedSingleStr = String.valueOf(str.charAt(i));

            //find decodedSingleStr use ENCODING.get(String str.charAt(i))
            if (ENCODING.containsKey(decodedSingleStr)) {

                //increment str chars under 2 senarios, with or without containskeys from ENCODING
                decodedStr += ENCODING.get(decodedSingleStr);
            } else {
                decodedStr += String.valueOf(str.charAt(i));
            }
            }
        return decodedStr;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        // split line to 2 elements str[] array
       String[] amountWithIngredient = line.split("#");

        // reach each elements with arr[0], and arr[1], with decodeString method defined above to decode each array elements
        String amount = decodeString(amountWithIngredient[0]);
        String description = decodeString(amountWithIngredient[1]);

        return new Ingredient(amount, description);
    }

    public static void main(String[] args) throws IOException {
        // TODO: implement me
        File secret_recipe = new File("java/src/main/resources/secret_recipe.txt");
        // read secret_recipe.txt with Scanner
        Scanner scanner = new Scanner(secret_recipe);
        // loop through each line until no line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            //decodeIngredient each line
            Ingredient decodedLine = decodeIngredient(line);

            //create a new file named `decoded_recipe.txt` with FileWriter, set append true
            FileWriter myWriter = new FileWriter("java/src/main/resources/decoded_recipe.txt", true);

            //write each decodedLine to `decoded_recipe.txt`
            myWriter.write(String.valueOf(decodedLine));

            //write newline after each decodedLine, close writer
            myWriter.write("\r\n");
            myWriter.close();

            System.out.println(decodedLine);
        }

    }
}
