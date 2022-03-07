package com.labs1904;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

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
            put("/", "/");
            put(",", ",");
            put("-", "-");
        }
    };

    /**
     * Given a string named str, use the Caesar encoding above to return the decoded string.
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        String newString = "";

        for (int i = 0; i < str.length(); i++) {
            newString += ENCODING.get(str.substring(i, i+1));
        }

        return newString;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        String[] gredArr = line.split("#");

        return new Ingredient(decodeString(gredArr[0]), decodeString(gredArr[1]));
    }

    public static void main(String[] args) {


        BufferedReader reader;
        PrintWriter writer;
        try {
            reader = new BufferedReader(new FileReader("D:\\Code\\LaunchCode\\de-hours-with-experts\\java\\src\\main\\resources/secret_recipe.txt"));
            writer = new PrintWriter(new File("D:\\Code\\LaunchCode\\de-hours-with-experts\\java\\src\\main\\resources/decoded_recipe.txt"));
            String line = reader.readLine();
            while (line != null) {
                Ingredient thisGred = decodeIngredient(line);
                writer.write(thisGred.getAmount() + " " + thisGred.getDescription() + System.getProperty("line.separator"));
                line = reader.readLine();
            }
            reader.close();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
