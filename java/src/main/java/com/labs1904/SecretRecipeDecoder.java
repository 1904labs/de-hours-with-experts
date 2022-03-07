package com.labs1904;


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
        // TODO: implement me
        String decodedStr="";
        for (int i = 0; i < str.length(); i++) {

            decodedStr+=ENCODING.get(String.valueOf(str.charAt(i)));
        }
        //System.out.println(decodeStr);
        return decodedStr;
        return "";
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        String [] lines=line.split(("[#]"));
        String quantity="";
        String ingredient="";
        String quantity1;
        String decodedQuantity="";
        String ingredient1;
        String decodedIngredient="";
        //for(String s:lines)
        // System.out.println(s);
        for (int i = 0; i < lines.length; i++) {
            quantity = lines[0];
            ingredient = lines[1];
        }
        for (int j = 0; j < lines[0].length(); j++) {

            for (Map.Entry entry : ENCODING.entrySet()){
                if (entry.getKey().equals(String.valueOf(quantity.charAt(j)))) {
                    decodedQuantity += entry.getValue();
                }
            }
            //System.out.println(decodedQuantity);
        }
        for (int k = 0; k < lines[1].length(); k++) {

            for (Map.Entry entry : ENCODING.entrySet()) {
                if (entry.getKey().equals(String.valueOf(ingredient.charAt(k)))) {
                    decodedIngredient += entry.getValue();
                }
            }
        }
        //System.out.println(decodedIngredient);
        return Ingredient(decodedQuantity,decodedIngredient);
        return null;
    }

    public static void main(String[] args) {
        // TODO: implement me
    }
}
