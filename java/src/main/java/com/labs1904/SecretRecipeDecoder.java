package com.labs1904;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
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
     * @return
     */
    public static String decodeString(String str) {
        StringBuilder result = new StringBuilder(str.length());
        String[] splitString = str.split("");

        //iterate char array
        for (int i = 0; i < splitString.length; i++) {
            //System.out.print(splitString[i] + " ");
            String decodedString = ENCODING.get(splitString[i]);
            if(decodedString == null)
                result.append(splitString[i]);
            else result.append(ENCODING.get(splitString[i]));
        }

        //System.out.print(result.toString());

        // TODO: implement me
        return result.toString();
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        String[] splitString = line.split("#| ");
        Ingredient theIngred = new Ingredient("","");

        for (int i = 0; i < splitString.length; i++) {
            if(i == 0)
                theIngred.setAmount(decodeString(splitString[i]));
            else if(i == 1) {
                //System.out.println(splitString[i]);
                theIngred.setDescription(decodeString(splitString[i]));
            }
            else if(i == 2){
                theIngred.setDescription(theIngred.getDescription() + " " + decodeString(splitString[i]));
            }
        }

        return theIngred;
    }

    public static void DecodeRecipe(String filepath) throws FileNotFoundException, URISyntaxException {
        Scanner scanner = new Scanner(new File(filepath));

        URL res = SecretRecipeDecoder.class.getClassLoader().getResource("decoded_recipe.txt");
        File file = Paths.get(res.toURI()).toFile();
        String destinationPath = file.getAbsolutePath();
        System.out.println(destinationPath);
        PrintWriter writer = new PrintWriter(file);

        Ingredient t = null;
        while (scanner.hasNextLine()) {
            //System.out.println();
            String txtLine = scanner.nextLine();
            //System.out.println(txtLine);
            t = decodeIngredient(txtLine);
            writer.println(t.getAmount() + " " + t.getDescription());
            System.out.println(t.getAmount() + " " + t.getDescription());
        }

        scanner.close();
        writer.close();
    }

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        // TODO: implement me
        SecretRecipeDecoder.decodeString("hgiikf");
        Ingredient result = SecretRecipeDecoder.decodeIngredient("8 vgl#hgiikf");
        URL res = SecretRecipeDecoder.class.getClassLoader().getResource("secret_recipe.txt");
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();
        DecodeRecipe(absolutePath);
    }
}
