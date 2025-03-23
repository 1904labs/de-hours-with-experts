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
        String decodedStr ="";
        for(char c : str.toCharArray() ){
            String key = Character.toString(c);
            if(ENCODING.containsKey(key)){
                decodedStr = decodedStr + ENCODING.get(key);
            } else {
                decodedStr += c;
            }
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
        String[] parts = line.split("#", 2);
        String amount = parts[0];
        String ingredient = parts[1];

        String decodedAmount = decodeString(amount);
        String decodedIngredient = decodeString(ingredient);
        return new Ingredient(decodedAmount, decodedIngredient);
    }

    public static void main(String[] args) throws IOException {
        // TODO: implement me

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\tmanb\\Desktop\\hour-with-experts-challenges\\de-hours-with-experts\\java\\src\\main\\resources\\secret_recipe.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\tmanb\\Desktop\\hour-with-experts-challenges\\de-hours-with-experts\\java\\src\\main\\resources\\decoded_recipe.txt"));
        String line;
        while((line = reader.readLine()) != null) {
            Ingredient ingredient = decodeIngredient(line);
            String formattedIngredient = ingredient.getAmount() + " " + ingredient.getDescription();
            writer.write(formattedIngredient);
            writer.newLine();

            System.out.println(line);
            System.out.println(formattedIngredient);
        }
            reader.close();
            writer.close();
    }
}
