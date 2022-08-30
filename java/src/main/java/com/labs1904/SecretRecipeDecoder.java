package com.labs1904;


import java.io.*;
import java.util.*;

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
        String decodedWord = "";
        String[] characters = str.split("");
        for(int i=0; i<str.length(); i++){
            if(characters[i].equals(" ") || characters[i].equals("/") || characters[i].equals("-")){
                decodedWord += characters[i];
            } else {
                decodedWord += ENCODING.get(characters[i]);
            }
        }
        return decodedWord;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        String[] ingredient = line.split("#");
        return new Ingredient(decodeString(ingredient[0]), decodeString(ingredient[1]));
    }

    public static void main(String[] args) {
        // TODO: implement me
        ArrayList<Ingredient> ingredientList = new ArrayList<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Owner\\Desktop\\Coding Folder\\CodingWithExpertsChallenge\\java\\src\\main\\resources\\secret_recipe.txt"));
            String line = reader.readLine();
            while(line != null) {
                ingredientList.add(decodeIngredient(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter file = new FileWriter("C:\\Users\\Owner\\Desktop\\Coding Folder\\CodingWithExpertsChallenge\\java\\src\\main\\resources\\decoded_recipe.txt");
            BufferedWriter output = new BufferedWriter(file);
            for(Ingredient ingredient:ingredientList){
                String writingIngredient = ingredient.getAmount() + " " + ingredient.getDescription() + "\n";
                output.write(writingIngredient);
            }
            output.close();
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }
}
