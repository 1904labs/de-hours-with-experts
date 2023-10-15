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
        String retString = "";

        for(int i = 0; i < str.length(); i++){
            String key = String.valueOf(str.charAt(i));
            if(key.matches("[a-z0-9]")){
                retString = retString.concat(ENCODING.get(key));
            } else {
                retString = retString.concat(key);
            }
        }

        return retString;
        //return "1 cup";
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        String[] stringArr = line.split("#");
        return new Ingredient(decodeString(stringArr[0]), decodeString(stringArr[1]));
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Bobby\\Desktop\\projects\\hours-with-experts\\de-hours-with-experts\\java\\src\\main\\resources\\secret_recipe.txt";
        BufferedReader reader;
        try{

        reader = new BufferedReader(new FileReader(filePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Bobby\\Desktop\\decoded_recipe.txt"));

        String line = reader.readLine();

        while (line != null) {
            Ingredient ingredient = decodeIngredient(line);
            writer.write(ingredient.getAmount() + ingredient.getDescription());
            writer.write("\n");
            line = reader.readLine();
        }

        writer.close();
        reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
