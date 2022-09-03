package com.labs1904;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.io.PrintStream;
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
            put(" ", " ");
        }
    };
    /**
     * Given a string named str, use the Caesar encoding above to return the decoded string.
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        // TODO: implement me
        String letter;
        String finalWord = "";
        for (int i = 0; i < str.length(); i++) {
            letter = (String.valueOf(str.charAt(i)));
            for (Map.Entry entry : ENCODING.entrySet()) {
                if (entry.getValue().equals(letter)) {
                    finalWord += entry.getKey();
                }
            }
        } return finalWord;
    }
    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        String amountInRecipe = "";
        String measurement = "";
        String intermediateMeasurement;
        String ingredientInRecipe = "";
        String ingredient = "";
        String intermediateIngredient;
        String[] breakLine = line.split("[#]");
        for (int i = 0; i < breakLine.length; i++) {
            measurement = breakLine[0];
            ingredient = breakLine[1];
        }
        for (int j = 0; j < breakLine[0].length(); j++) {
            intermediateMeasurement = String.valueOf(measurement.charAt(j));
            for (Map.Entry recipe2 : ENCODING.entrySet()){
                if (recipe2.getKey().equals(intermediateMeasurement)) {
                    amountInRecipe += recipe2.getValue();
                }
            }
        }

        for (int k = 0; k < breakLine[1].length(); k++) {
            intermediateIngredient = String.valueOf(ingredient.charAt(k));
            for (Map.Entry recipe : ENCODING.entrySet()) {
                if (recipe.getKey().equals(intermediateIngredient)) {
                    ingredientInRecipe += recipe.getValue();
                }
            }
        } return new Ingredient(amountInRecipe, ingredientInRecipe);
    }

    public static void main(String[] args) {
        // TODO: implement me
        // SecretRecipeDecoder secretRecipeDecoder = new SecretRecipeDecoder();
        String amount;
        String description;
        String wholeThingTogether;
        try {
            File recipeList = new File("src/main/resources/secret_recipe.txt");
            File decoded  = new File("src/main/resources/decoded_recipe.txt");
            PrintStream moveItOver = new PrintStream(decoded);
            Scanner readRecipeList = new Scanner(recipeList);
            while (readRecipeList.hasNextLine()) {
                String wholeRecipe = readRecipeList.nextLine();
                amount = SecretRecipeDecoder.decodeIngredient(wholeRecipe).getAmount();
                description = SecretRecipeDecoder.decodeIngredient(wholeRecipe).getDescription();
                wholeThingTogether = amount + " " + description;
                System.setOut(moveItOver);
                System.out.println(wholeThingTogether);
            }
            readRecipeList.close();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }
}