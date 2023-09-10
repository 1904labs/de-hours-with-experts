package com.labs1904;


import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
     * @return decodedStr
     */
    public static String decodeString(String str) {
        String[] arr = str.split("");
        ArrayList<String> decodedArr = new ArrayList<>();
        for (String character : arr) {
            if (character.matches("^[a-z0-9]*$")){  // only decoding relevant characters
                decodedArr.add(ENCODING.get(character));
            }
            else {                                        // otherwise keeping character as is
                decodedArr.add(character);
            }
        }
        String decodedStr = String.join("", decodedArr);
        return decodedStr;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return decodedAmount, decodedDescrip
     */
    public static Ingredient decodeIngredient(String line) {
        int i = line.indexOf("#");
        String codedAmount = line.substring(0, i);
        String codedDescrip = line.substring(i+1);
        String decodedAmount = decodeString(codedAmount);
        String decodedDescrip = decodeString(codedDescrip);
        return new Ingredient(decodedAmount, decodedDescrip);
    }

    public static void main(String[] args) throws IOException {
        int ch;
        FileReader fr = null;
        fr = new FileReader("java/src/main/resources/secret_recipe.txt");

        FileWriter fw = new FileWriter("java/src/main/resources/decoded_recipe.txt");

        ArrayList<Character> secretRecipeCharArray = new ArrayList<>();
        ArrayList<String> secretRecipeStrArray = new ArrayList<>();

        // reading secret_recipe.txt and adding each character into a char array
        while ((ch=fr.read())!=-1) {
            secretRecipeCharArray.add((char)ch);
        }
        fr.close();

        // converting that char array into a string array
        for (Character c : secretRecipeCharArray){
            secretRecipeStrArray.add(c.toString());
        }

        // converting that string array into a string
        String secretRecipeString = String.join("", secretRecipeStrArray);

        System.out.println(secretRecipeString);

        // need to find a way to delimit the secretRecipeString into separate lines
        // to feed them into the decodeIngredient function in a loop

        // then they should be ready to be written into the decoded_recipe.txt file

        fw.close();

    }
}
