package com.labs1904;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
      String decoded = "";

       for(Character c : str.toCharArray()){
           //for char at index, decode and add to string
           decoded.concat(ENCODING.get(c));
           }
       return decoded;
       }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        String[] encodedStringArray = line.split("#");
        Ingredient decodedNewIngredient = new Ingredient(decodeString(encodedStringArray[0]), decodeString(encodedStringArray[1]));
        return decodedNewIngredient;
    }

    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("secret_recipe.txt"));
            FileWriter fileWriter = new FileWriter("decoded_recipe.txt", true);
            //reads an encoded line
            String newLine = reader.readLine();
            while (newLine != null) {
                //writes a decoded line
                fileWriter.write(String.valueOf(decodeIngredient(newLine)));
                //write new line to separate
                fileWriter.write(System.lineSeparator());
                newLine = reader.readLine();
            }
            reader.close();
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
