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

        StringBuilder s = new StringBuilder();
        for (char c : str.toCharArray()) {
            if(String.valueOf(c).matches("[a-zA-Z0-9]")){
                s.append(ENCODING.get(String.valueOf(c)));
            } else {
                s.append(c);
            }
        }
        return s.toString();
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {

        String[] parts = line.split("#");
        String amount = decodeString(parts[0]);
        String desc = decodeString(parts[1]);
        return new Ingredient(amount, desc);
    }

    public static void main(String[] args) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("secret_recipe.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);

        try(BufferedReader reader = new BufferedReader(streamReader);
            FileWriter fileWriter = new FileWriter("decoded_recipe.txt")) {
            for(String line; (line = reader.readLine()) != null;){
                Ingredient ingredient = decodeIngredient(line);
                String lineToWrite = ingredient.getAmount() + " " + ingredient.getDescription();
                fileWriter.write(lineToWrite);
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
