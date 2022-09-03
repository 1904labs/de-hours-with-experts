package com.labs1904;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

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
        StringBuilder decodedStrBldr = new StringBuilder();
        Arrays.stream(str.split("")).forEach(letter -> {
            if(ENCODING.containsKey(letter)){
                decodedStrBldr.append(ENCODING.get(letter));
            } else {
                decodedStrBldr.append(letter.replace("#", " "));
            }
        });
        return decodedStrBldr.toString();
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        return new Ingredient(decodeString(line.substring(0,line.indexOf("#"))), decodeString(line.substring(line.indexOf("#")+1)));
    }

    public static void main(String[] args) {
        try{
            File secretRecipe = new File("src\\main\\resources\\secret_recipe.txt");
            File decodedRecipe = new File("src\\main\\resources\\decoded_recipe.txt");
            if(decodedRecipe.createNewFile()){
                Scanner myReader = new Scanner(secretRecipe);
                FileWriter myWriter = new FileWriter(decodedRecipe);
                while(myReader.hasNextLine()){
                    String data = myReader.nextLine();
                    myWriter.write(decodeIngredient(data)+"\n");
                }
                myReader.close();
                myWriter.close();
            }

        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
