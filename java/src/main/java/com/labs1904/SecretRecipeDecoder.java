package com.labs1904;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;

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
		String decodeString = "";
		for (int i = 0; i < str.length(); i++){
			//used next line of code to debug why my if statement wasn't registering as true for checking for whitespace
			// String thisSubStr = str.substring(i, i+1);
			if(str.substring(i, i+1) == " "){
				decodeString += " ";
			}
			decodeString += ENCODING.get(str.substring(i, i+1));
		}
		return decodeString;
	}

	/**
	 * Given an ingredient, decode the amount and description, and return a new Ingredient
	 * @param line
	 * @return
	 */
	public static Ingredient decodeIngredient(String line) {
		String[] recipeLine = line.split("#");
		String amount = decodeString(recipeLine[0]);
		String description = decodeString(recipeLine[1]);
		return new Ingredient(amount, description);
	}

	public static void main(String[] args) {
		// TODO: implement me
		String newRecipe = decodeString("8 vgl");
		try {
			File file = new File("C:\\Users\\TEMP\\source\\repos\\HoursWithExperts\\de-hours-with-experts\\java\\src\\main\\resources\\secret_recipe.txt");
			BufferedReader secretRecipeText = new BufferedReader(new FileReader(file));
			StringBuffer sb = new StringBuffer();
			String line;
			while((line=secretRecipeText.readLine())!=null) {
				Ingredient decodedIngred = decodeIngredient(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(newRecipe);
	}
}
