package com.labs1904;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.sound.sampled.AudioFormat.Encoding;

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

    private static Map<String, String> DECODING = new HashMap<String, String>() {
        {
            put("a", "y");
            put("h", "b");
            put("c", "v");
            put("d", "x");
            put("e", "k");
            put("f", "p");
            put("g", "z");
            put("h", "s");
            put("i", "a");
            put("j", "b");
            put("k", "e");
            put("l", "w");
            put("m", "u");
            put("n", "q");
            put("o", "n");
            put("p", "l");
            put("q", "m");
            put("r", "f");
            put("s", "o");
            put("t", "i");
            put("u", "g");
            put("v", "j");
            put("w", "t");
            put("x", "d");
            put("y", "r");
            put("z", "c");
            put("0", "3");
            put("1", "8");
            put("2", "4");
            put("3", "0");
            put("4", "2");
            put("5", "7");
            put("6", "5");
            put("7", "9");
            put("8", "1");
            put("9", "6");
        }
    };

    public static String decodeString(String str) {

        char[] encodedCharArray = str.toCharArray();

        char[] decodedCharArray;
        

        for (int i = 0; i < str.length(); i++) {

            decodedCharArray[i] = ENCODING.get(Character.toString(encodedCharArray[i]));


        }

        // TODO: implement me
        return decodedString;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        return null;
    }

    public static void main(String[] args) {
        // TODO: implement me

        System.out.println(decodeString("hgiikf"));


    }
}
