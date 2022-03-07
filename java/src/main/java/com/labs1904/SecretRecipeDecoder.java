package com.labs1904;


import java.io.PrintStream;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Iterator;
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
     *
     * @param str
     * @return
     */
    public static String decodeString(String str) {

        String result = "";


        for (int i = 0; i < str.length(); i++) {

            if(ENCODING.containsKey(Character.toString(str.charAt(i)))){
                result = result + ENCODING.get(Character.toString(str.charAt(i)));
            }

        }
        return result;
    }

    ;

//    for(Map.Entry<String, String>entry: ENCODING.entrySet()) {
////
//        String key = entry.getKey();
//        String value = entry.getValue();


//        if(str.equals(ENCODING.keySet())) {
//
//            System.out.println(ENCODING.values());
//
//        }

    // TODO: implement me
//        return ENCODING.get(str);


    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     *
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        String amount = decodeString(line.split("#")[0]);
        String description = decodeString(line.split("#")[1]);

        Ingredient newIngredient = new Ingredient(amount, description);



        // TODO: implement me
        return newIngredient;
    }

    public static void main(String[] args) {


        System.out.print(decodeString("hgiikf"));



    }
}

