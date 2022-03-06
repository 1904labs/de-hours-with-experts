package com.labs1904;


import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        
    	String decodedString = "";
        
        // Split each letter into its own string
        String [] arrayOfLetters = str.split("");
    	
        // Decode each letter
    	for(int i = 0; i < arrayOfLetters.length; i++) {
            		
    		String decodedLetter = ENCODING.get(arrayOfLetters[i]);	    		
    	
                // If the decoded letter returns null, indicating it's not in ENCODING, return the original character
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
    	
        // Split amount and description into their own strings
        String [] splitLine = line.split("#");
    	String encodedAmount = splitLine[0];
    	String encodedDescription = splitLine[1];
        
        // Decode amount and description
        String decodedAmount = decodeString(encodedAmount);
        String decodedDescription = decodeString(encodedDescription);
    	
        return new Ingredient(decodedAmount, decodedDescription);
    }

    public static void main(String[] args) {     
        
        try
        {
            // Create .txt file
            PrintWriter decodedRecipeFile = new PrintWriter("decoded_recipe.txt", "UTF-8");
                      
            // Read secret recipe
            File secretRecipe = new File("src/main/resources/secret_recipe.txt");
            Scanner myReader = new Scanner(secretRecipe);
            
            // Decode each line and write it to new .txt file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Ingredient decodedIngredient = decodeIngredient(data);
                decodedRecipeFile.println(String.format("%s %s", decodedIngredient.getAmount(), decodedIngredient.getDescription()));
            }
            myReader.close();
            decodedRecipeFile.close();          
        }
        catch (Exception ex){
            System.out.println("There was an error when trying to decode the recipe. Try again. " + ex.getMessage());
        }       
    }
}
