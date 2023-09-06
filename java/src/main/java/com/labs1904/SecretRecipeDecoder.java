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
        }
    };

    /**
     * Given a string named str, use the Caesar encoding above to return the decoded string.
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        // TODO: implement me
        String[] input = str.split("");
        StringBuilder returnString = new StringBuilder("");
        for (String c : input) {
            if(ENCODING.containsKey(c)){
                returnString.append(ENCODING.get(c));
            }else{
                returnString.append(c);
        }}

        return returnString.toString();
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

    public static void main(String[] args) throws IOException {
        File decodedRecipe = new File("decoded_recipe.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(decodedRecipe));

        InputStreamReader stream =new InputStreamReader(SecretRecipeDecoder.class.getResourceAsStream("/secret_recipe.txt"));
        BufferedReader reader = new BufferedReader(stream);


        do{
            String currentLine = reader.readLine();
            Ingredient ingredient = decodeIngredient(currentLine);
            writer.append(ingredient.getAmount()+" "+ingredient.getDescription()+"\n");
        }while (reader.readLine()!=null);

        writer.close();
        reader.close();
    }
}
