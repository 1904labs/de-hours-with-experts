package com.labs1904;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
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
            put(" "," ");
            put("/","/");
            put("-","-");
            put(",",",");
        }
    };

    /**
     * Given a string named str, use the Caesar encoding above to return the decoded string.
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        // TODO: implement me
    	ArrayList<String> decodedString=new ArrayList<>();
    	String s="";
    	String key="";
    	for(int i=0;i<str.length();i++) {
    		key=String.valueOf(str.charAt(i));
    		s+=ENCODING.get(key);
    	}
        //return "1 cup";
        return s;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
    	int index;
    	String s="";
    	index=line.indexOf("#");
    	String amount="";
    	String description="";
    	amount=decodeString(line.substring(0, index));
    	description=decodeString(line.substring(index+1));
    	Ingredient ing = new Ingredient(amount,description);
        //return new Ingredient("1 cup", "butter");
    	return ing;
    }

    public static void main(String[] args) {
        // TODO: implement me
    	String s=decodeString("hgiikf");
    	System.out.print(s);
    	Ingredient ing=decodeIngredient("8 vgl#hgiikf");
    	System.out.print(ing.getAmount()+" "+ing.getDescription());
    	BufferedReader reader;
    	FileWriter writer;
    	try {
			reader=new BufferedReader(new FileReader("src/main/resources/secret_recipe.txt"));
			writer=new FileWriter("src/main/resources/decoded_recipe.txt");
			String line=reader.readLine();
			while(line!=null) {
				Ingredient in=decodeIngredient(line.trim());
				writer.write(in.getAmount()+" "+in.getDescription()+"\n");
				line=reader.readLine();
			}
			reader.close();
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
}
