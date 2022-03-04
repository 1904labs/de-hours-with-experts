package com.labs1904;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
        String[] decodedArr = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            for (Map.Entry<String, String> code : ENCODING.entrySet()) {
                if (code.getKey().equals(Character.toString(str.charAt(i)))) {
                    decodedArr[i] = code.getValue();
                }
                if (decodedArr[i] == null) {
                    decodedArr[i] = Character.toString(str.charAt(i));
                }
            }
        }
        String decoded = String.join("", decodedArr);
        return decoded;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        String decoded = decodeString(line);

        String[] ingredientSplit = decoded.split("#");
        Ingredient newIngredient = new Ingredient(ingredientSplit[0], ingredientSplit[1]);
        return newIngredient;
    }

    public static void main(String[] args) {
        // TODO: implement me
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/decoded_recipe.txt");
            try {
                File myObj = new File("src/main/resources/secret_recipe.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    Ingredient ingredient = decodeIngredient(data);
                    myWriter.write(ingredient.getAmount() + " " + ingredient.getDescription() + "\n");
                }
                myReader.close();
                myWriter.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
            }
        } catch (IOException e) {
            System.out.println("An IO error occurred.");
        }
    }
}
