package com.labs1904;

import java.io.*;
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
            put(" ", " ");
            put(",", ",");
            put("-", "-");
            put("/", "/");
        }
    };

    /**
     * Given a string named str, use the Caesar encoding above to return the decoded string.
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        // TODO: implement me
        String decodedStr = "";
        for (int i = 0; i < str.length(); i++){
            decodedStr += ENCODING.get(Character.toString(str.charAt(i)));
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
        String[] encodedInfo = line.split("#");
        String decodedDescr = decodeString(encodedInfo[0]);
        String decodedIngredient = decodeString(encodedInfo[1]);
        return new Ingredient(decodedDescr, decodedIngredient);
    }



    public static void main(String[] args) throws IOException {
        // TODO: implement me
        File file = new File("java/src/main/resources/secret_recipe.txt");
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        String result = sb.toString();
        String[] encodedList = result.split("\n");

        String recipe = "";
        for (int i = 0; i < encodedList.length; i++){
            recipe += decodeIngredient(encodedList[i]) + "\n";
        }
        try {
            FileWriter myWriter = new FileWriter("decoded_recipe.txt");
            myWriter.write(recipe);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}