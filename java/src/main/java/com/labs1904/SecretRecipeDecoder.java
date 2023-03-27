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
            put("/", "/"); //added to account for "/" in recipe
        }
    };

    /**
     * Given a string named str, use the Caesar encoding above to return the decoded string.
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        String decodedStr = "";
        for (int i = 0; i < str.length(); i++) {
            char characterAtIndex = str.charAt(i); //gives the characters of the hashmap KEYS
            String charactersToStrings = new String(String.valueOf(characterAtIndex)); //turns the characters of the hashmap KEYS into strings
            String decodedValues = ENCODING.get(charactersToStrings); //accessing hashmap VALUES as strings

            if(decodedValues == null) { //will otherwise print as "null"
                decodedStr += " ";
            } else {
                decodedStr += decodedValues; //adding each value to final decoded string
                }
            }
        return decodedStr;
    }


    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        String[] splitRecipeLine = line.split("#");
        String ingredientAmount = decodeString(splitRecipeLine[0]);
        String ingredientDescription = decodeString(splitRecipeLine[1]);

        return new Ingredient(ingredientAmount, ingredientDescription);
    }

    public static void main(String[] args) {
        String[] secretRecipe = {"8 vgl#hgiikf", "8 vgl#xyfe hfntq ogzyf, lyvekx", "8 vgl#zfyqgwyikx ogzyf", "4#kzzo", "8 ikyolnnq#jyqawwy", "4 8/4 vglo#nyiukyw", "4 vglo#pwngf", "8/4 ikyolnnq#oywi", "8 ikyolnnq#hyeaqz onxy", "ikyolnnq#hyeaqz lntxkf", "84 ngqvko#vsnvnwyik vsalo", "8#2-ngqvk uawe vsnvnwyik hyf", "8 8/4 vglo#vsnllkx qgio"};
        for(int i=0; i<secretRecipe.length; i++){
            System.out.println(decodeIngredient(secretRecipe[i]));
        }
    }
}
