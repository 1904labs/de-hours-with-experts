package com.labs1904;

import java.util.HashMap;
import java.util.Map;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import java.io.PrintWriter;


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
        String decoded = "";
        for (int i = 0; i < str.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (ENCODING.containsKey(c)) {
                decoded += ENCODING.get(c);
            } else {
                decoded += "?";
            }
        }
        return decoded;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static String decodeIngredient(String line) {
        // TODO: implement me
        String newIngredient = "";
        for (int i = 0; i < line.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (ENCODING.containsKey(c)) {
                newIngredient += ENCODING.get(c);
            } elseif((c=" ") || (c="#") {
                newIngredient += " ";
            } else {
                newIngredient += "?";
            }
        }
        return newIngredient;
    }


    public static void main(String[] args) {
        // TODO: implement me
        try {
            File myObj = new File("secret_recipe.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        newData = decodeIngredient(data);
        try (PrintWriter out = new PrintWriter("decoded_recipe.txt", "UTF-8")) {
            out.write(newData);
        }

    }

}

