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
     * @return decodedString
     */
    public static String decodeString(String str) {      
    	String [] arrayOfLetters = str.split("");   	
    	String decodedString = "";
    	
    	for(int i = 0; i < arrayOfLetters.length; i++) {
    		String decodedLetter; 		
    		decodedLetter = ENCODING.get(arrayOfLetters[i]);	    		
    	
                // If the decoded letter returns null bc it's not in the ENCODING, return the original letter or character
                // else return the decoded letter
    		if(decodedLetter == null) 
    		{
                    decodedString += arrayOfLetters[i];
    		} 
    		else 
    		{
                    decodedString += decodedLetter;
    		}
        }
        return decodedString;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return decoded Ingredient
     */
    public static Ingredient decodeIngredient(String line) {
    	String [] splitLine = line.split("#");
    	String encodedAmount = splitLine[0];
    	String encodedDescription = splitLine[1];
        
        String decodedAmount = decodeString(encodedAmount);
        String decodedDescription = decodeString(encodedDescription);
    	
        return new Ingredient(decodedAmount, decodedDescription);
    }

    public static void main(String[] args) {
        // TODO: implement me
    }
}
