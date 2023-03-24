package com.labs1904;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
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
        String returnstr = "";
        for (char c : str.toCharArray()) {            
            //System.out.print(ENCODING.get(String. valueOf(c)));
            if(c == ' ')
            {
                returnstr = returnstr + ' '; 
            }            
            else
            {
                if(c == '/')
                {
                returnstr = returnstr + '/'; 
                } 
                else{
                    returnstr = returnstr + ENCODING.get(String. valueOf(c));
                }
                
            }            
        }
        //String. valueOf(char)
        return returnstr;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        String[] inputStringSplit = line.split("#");
        //for(String singlestr : inputStringSplit) {            System.out.print(decodeString(singlestr));                   }
        //System.out.println(decodeString(inputStringSplit[0])); 
        //System.out.println(decodeString(inputStringSplit[1])); 
        return new Ingredient(decodeString(inputStringSplit[0]), decodeString(inputStringSplit[1]));
    }

    public static void main(String[] args) {
        // TODO: implement me
        System.out.println("Coding Challenge #1");
        //System.out.println(ENCODING.get("h"));
        System.out.println(decodeString("hgiikf"));
        System.out.println("Coding Challenge #2");
        Ingredient lineofingredient = null;
        lineofingredient = decodeIngredient("8 vgl#hgiikf");
        System.out.println(lineofingredient.getAmount() + " " + lineofingredient.getDescription());
        //System.out.println(System.getProperty("user.dir"));
        System.out.println("Coding Challenge #3");
        try
        {
            File myObj = new File("java/src/main/resources/filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileWriter myWriter = new FileWriter("java/src/main/resources/filename.txt");

            List<String> allLines = Files.readAllLines(Paths.get("java/src/main/resources/secret_recipe.txt"));
			for (String line : allLines) {				
                //System.out.println(line);	
                lineofingredient = decodeIngredient(line);
                System.out.println(lineofingredient.getAmount() + " " + lineofingredient.getDescription());	
                myWriter.write(lineofingredient.getAmount() + " " + lineofingredient.getDescription() + " \n");
            }
            
            //myWriter.write("Write testing! \n");            
            myWriter.close();
        }
        catch (IOException e) {
			e.printStackTrace();
		}
        
    }
}
