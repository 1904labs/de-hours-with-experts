package com.labs1904;


import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.io.PrintWriter;
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
        //loop through the string
        for (int i = 0; i < str.length(); i++) {
            //for each char, find that key in ENCODING map and replace it with it's value pair
            String decodedChar = ENCODING.get(str.charAt(i));
            String decodedString += decodedChar;
        }
        return "decodedString";
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        String[] stringarray = line.split("#");
        String amount = decodeString(stringarray[0]);
        String description = decodeString(stringarray[1]);
        Ingredient newIngredient = new Ingredient(amount, description);
        return null;
    }

    public static void main(String[] args) {
        // TODO: implement me
        //define the write file
        PrintWriter out = new PrintWriter("java/src/main/resources/decoded_recipe.txt");
        //get the .txt file
        File file = new File("java/src/main/resources/secret_recipe.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            out.println(decodeIngredient(scan.nextLine()));
            out.close();
        }
        scan.close();
    }
    }
