package com.labs1904;

import java.util.HashMap;
import java.util.Map;

public class SecretRecipeDecoder {
//    private static Map<String, String> ENCODING = new HashMap<String, String>() {
//        {
//            put("y", "a");
//            put("h", "b");
//            put("v", "c");
//            put("x", "d");
//            put("k", "e");
//            put("p", "f");
//            put("z", "g");
//            put("s", "h");
//            put("a", "i");
//            put("b", "j");
//            put("e", "k");
//            put("w", "l");
//            put("u", "m");
//            put("q", "n");
//            put("n", "o");
//            put("l", "p");
//            put("m", "q");
//            put("f", "r");
//            put("o", "s");
//            put("i", "t");
//            put("g", "u");
//            put("j", "v");
//            put("t", "w");
//            put("d", "x");
//            put("r", "y");
//            put("c", "z");
//            put("3", "0");
//            put("8", "1");
//            put("4", "2");
//            put("0", "3");
//            put("2", "4");
//            put("7", "5");
//            put("5", "6");
//            put("9", "7");
//            put("1", "8");
//            put("6", "9");
//        }
//    };
    
    private static final Map<String, String> ENCODING = createMap();
    private static final Map<String, String> createMap() {
        Map<String, String> m = new HashMap<>();
        m.put("y", "a");
        m.put("h", "b");
        m.put("v", "c");
        m.put("x", "d");
        m.put("k", "e");
        m.put("p", "f");
        m.put("z", "g");
        m.put("s", "h");
        m.put("a", "i");
        m.put("b", "j");
        m.put("e", "k");
        m.put("w", "l");
        m.put("u", "m");
        m.put("q", "n");
        m.put("n", "o");
        m.put("l", "p");
        m.put("m", "q");
        m.put("f", "r");
        m.put("o", "s");
        m.put("i", "t");
        m.put("g", "u");
        m.put("j", "v");
        m.put("t", "w");
        m.put("d", "x");
        m.put("r", "y");
        m.put("c", "z");
        m.put("3", "0");
        m.put("8", "1");
        m.put("4", "2");
        m.put("0", "3");
        m.put("2", "4");
        m.put("7", "5");
        m.put("5", "6");
        m.put("9", "7");
        m.put("1", "8");
        m.put("6", "9");
        return m;
    }
    
    
    
    
    /**
     * Given a string named str, use the Caesar encoding above to return the
     * decoded string.
     *
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        // TODO: implement me
        return "1 cup";
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new
     * Ingredient
     *
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        return new Ingredient("1 cup", "butter");
    }

    public static void main(String[] args) {
        // TODO: implement me
        System.out.println("a");
        System.out.println(ENCODING.keySet());
//Challenge #1: Decode a string - Implement a function that takes an encoded string and returns 
//the decoded value (hgiikf is decoded to butter).




//Challenge #2: Decode an Ingredient - Implement a function that takes a line from the recipe 
//and returns a new Ingredient (a class already defined for you). 
//The # sign delimits the encoded amount and the description of an ingredient. 
//For example, the line 8 vgl#hgiikf would return an Ingredient with an amount of 1 cup 
//and a description of butter.

        
//Challenge #3: Decode the entire recipe - Read all of the ingredients out of secret_recipe.txt, 
//decode each ingredient (hopefully using the functions you implemented above), 
//and save the output into a new file named decoded_recipe.txt.
        
        
        
        
    }
}
