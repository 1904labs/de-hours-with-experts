package com.labs1904;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        //CREATE LIST
        List<String> ingredient = new ArrayList<>();
        //LOOP STRING
        for (int i = 0; i < str.length(); i++) {
            //IF LETTER
            if(Character.isLetter(str.charAt(i))){
                ingredient.add(ENCODING.get(String.valueOf(str.charAt(i))));
            }//IF NUMBER
            else if(Character.isDigit(str.charAt(i))){
                ingredient.add(ENCODING.get(String.valueOf(str.charAt(i))));
            }//IF NEITHER
            else{
                ingredient.add(String.valueOf(str.charAt(i)));
            }
        }
        //STRING LIST TO STRING
        String joined = String.join("", ingredient);

        //RETURN STRING
        return String.valueOf(joined);
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        //SPLIT INTO ARRAY
        String[] stringArray = line.split("#");
        //TO STRING()
        Ingredient newIngredient = new Ingredient(decodeString(stringArray[0]), decodeString(stringArray[1]));

        //RETURN Ingredient
        return newIngredient;
    }

    public static void main(String[] args) {
        // TODO: implement me
        //DELETE FILE IF EXISTS
        Path fileToDeletePath = Paths.get("src/main/resources/decoded_recipe.txt");
        try {
            Files.delete(fileToDeletePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //READ AND WRITE FILE
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/secret_recipe.txt"));
            FileWriter writer = new FileWriter("src/main/resources/decoded_recipe.txt", true);
            String line = reader.readLine();
            while (line != null) {
//                System.out.println(decodeIngredient(line)); //DEBUG: CHECK IF newIngredient IS SHOWING
                writer.write(String.valueOf(decodeIngredient(line)));
                writer.write("\r\n");   // write new line
                line = reader.readLine();
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}