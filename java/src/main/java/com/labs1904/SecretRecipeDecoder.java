package com.labs1904;


import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Properties;
import java.io.*;

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
        String decodedString = "";

        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).matches(" ")){
                decodedString += " ";
            }
            for (Map.Entry<String,String> entry : ENCODING.entrySet()){
                if (String.valueOf(str.charAt(i)).matches(entry.getKey())){
                    decodedString += entry.getValue();
                }
            }
        }
        return decodedString;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        String[] arrOfStrings = line.split("#");
        String[] arrOfDecodedStrings = new String[arrOfStrings.length];

        for (int i = 0; i < arrOfStrings.length; i++) {
            String decodedStr = decodeString(arrOfStrings[i]);
            arrOfDecodedStrings[i] = decodedStr;
        }

        Ingredient ingredient = new Ingredient(arrOfDecodedStrings[0], arrOfDecodedStrings[1]);

        return ingredient;
    }

    public static void main(String[] args) {
        try (InputStream inputStream =
                new FileInputStream("/Users/michaelallen/Documents/Coding/HoursWithExperts/de-hours-with-experts/java/src/main/resources/secret_recipe.txt")){
            InputStreamReader isReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isReader);
            String str = reader.readLine();
            while (str != null){
                Ingredient ingredient = decodeIngredient(str);
                File decodedRecipe = new File("/Users/michaelallen/Documents/Coding/HoursWithExperts/de-hours-with-experts/java/src/main/resources/decoded_recipe.txt");
                FileWriter writer = new FileWriter(decodedRecipe);
                writer.write(ingredient.getAmount() + " " + ingredient.getDescription());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Could not load file 'secret_recipe.txt'");
        }
    }
}
