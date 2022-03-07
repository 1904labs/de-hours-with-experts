package com.labs1904;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

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

        // Build reverse Map
        Map<String, String> Decoding = new HashMap<>();
        for (Map.Entry<String, String> entry : ENCODING.entrySet()) {
            Decoding.put(entry.getValue(), entry.getKey());
        }

        String decoded = "";
        String[] splitStr = str.split("");
         for (int i=0; i<splitStr.length; i++) {
            if (splitStr[i].equals(" ")) {
                decoded += " ";
            }
            else
                decoded += Decoding.get(splitStr[i]);
         }

        return decoded;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */


     public static Ingredient decodeIngredient(String line) {
        // separate amount using # delimiter
        String[] amountDescription = line.split("#");
        
        return new Ingredient(decodeString(amountDescription[0]), decodeString(amountDescription[1]));
    }

    public static void main(String[] args) {
        try (
            InputStream is = SecretRecipeDecoder.class.getResourceAsStream("/secret_repipe.txt");
            InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            PrintWriter writer = 
            new PrintWriter(
                  new File(SecretRecipeDecoder.class.getResource("/decoded_recipe.txt").getPath()));
            )
        {
            String ingredient;
            while ((ingredient = reader.readLine()) != null) {
                writer.print(decodeIngredient(ingredient));;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
