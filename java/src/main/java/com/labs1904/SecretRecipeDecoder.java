package com.labs1904;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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
        String[] strArray = str.split("");
        String decoded = "";

        for (int i = 0; i < strArray.length; i++) {
            if(strArray[i].isBlank() || strArray[i].matches("^.*[^a-zA-Z0-9 ].*$")) {
                decoded = decoded + strArray[i];
            } else {
                decoded = decoded + ENCODING.get(strArray[i]);  
            }
        }
        return decoded;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        String amount = decodeString(line.split("#")[0]);
        String description = decodeString(line.split("#")[1]);

        Ingredient newIngredient = new Ingredient(amount, description);

        return newIngredient;
    }

    

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        // TODO: implement me
        try {
            File myObj = new File("java\\src\\main\\resources\\secret_recipe.txt");
            Scanner myReader = new Scanner(myObj);
            PrintWriter myWriter = new PrintWriter("decoded_recipe.txt", "UTF-8");

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Ingredient currentIngredient = decodeIngredient(data);

                myWriter.println(currentIngredient.getAmount() + " " + currentIngredient.getDescription());
            }
            myReader.close();
            myWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
}
