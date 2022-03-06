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
            put(" ", " ");
        }
    };

    /**
     * Given a string named str, use the Caesar encoding above to return the decoded string.
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        // TODO: implement me
        String letter;
        String finalWord = "";
        for (int i = 0; i < str.length(); i++) {
            letter = (String.valueOf(str.charAt(i)));

        for (Map.Entry entry : ENCODING.entrySet()) {
            if (entry.getValue().equals(letter)) {
                finalWord += entry.getKey();
            }
        }
    }

        return finalWord;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        String amountInRecipe = "";
        String measurement = "";
        String intermediateMeasurement = "";
        String ingredientInRecipe = "";
        String ingredient = "";
        String intermediateIngredient = "";
        String[] breakLine = line.split("[#]");

        for (int i = 0; i < breakLine.length; i++) {
            measurement = breakLine[0];
            ingredient = breakLine[1];
        }

            for (int k = 0; k < breakLine[0].length(); k++) {
                intermediateMeasurement = String.valueOf(measurement.charAt(k));
                 System.out.println(intermediateMeasurement);

                for (Map.Entry recipe2 : ENCODING.entrySet()){
                    if (recipe2.getKey().equals(intermediateMeasurement)) {
                        amountInRecipe += recipe2.getValue();
                        // System.out.println(amountInRecipe);
                    }
                }

            }

            for (int j = 0; j < breakLine[1].length(); j++) {
                intermediateIngredient = String.valueOf(ingredient.charAt(j));

            for (Map.Entry recipe : ENCODING.entrySet()) {
                if (recipe.getKey().equals(intermediateIngredient)) {
                    ingredientInRecipe += recipe.getValue();
                  //  System.out.println(ingredientInRecipe);
                }
            }
        }


            return new Ingredient(amountInRecipe, ingredientInRecipe);
    }








    public static void main(String[] args) {
        // TODO: implement me

    }
}




 /*   char[] charInString = line.toCharArray();

        for (char ch : charInString){
           // System.out.println(ch);
            for (Map.Entry recipe3 : ENCODING.entrySet()){
                if (recipe3.getKey().equals(String.valueOf(ch))){
                    intermediate += recipe3.getValue();
                    System.out.println(intermediate);

                }
            }
        }*/

/* for (int i = 0; i < line.length(); i++) {
           // System.out.println(breakLine[i].charAt(i));
           // System.out.println(line.charAt(i));
            string = (String.valueOf(line.charAt(i)));
            for (Map.Entry recipe : ENCODING.entrySet()) {
                if (recipe.getKey().equals(string)) {
                   intermediate += recipe.getValue();
                    System.out.println(intermediate);
                }

            }
        }*/