package com.labs1904;


import java.io.*;
import java.net.URL;
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
        StringBuilder translation= new StringBuilder();
        String[] messageArray= str.split("");
        for (String key : messageArray) {
            translation.append(ENCODING.getOrDefault(key, key));
        }
        return translation.toString();
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        String[] lineArray = line.split("#");
        String amount = decodeString(lineArray[0]);
        String description = decodeString(lineArray[1]);
        return new Ingredient(amount, description);
    }

    public static void main(String[] args) throws Exception {
        PrintWriter recipe = new PrintWriter("decoded_recipe.txt");
        URL url = SecretRecipeDecoder.class.getResource("/secret_recipe.txt");
        assert url != null;
        File file = new File(url.getPath());
        Scanner getIngredient = new Scanner(file);

        while (getIngredient.hasNextLine()){
            Ingredient decodedIngredient = decodeIngredient(getIngredient.nextLine());
            String theIngredient = String.format("%1$s %2$s", decodedIngredient.getAmount(), decodedIngredient.getDescription());
            recipe.println(theIngredient);
        }
        getIngredient.close();
        recipe.close();
    }
}
