package com.labs1904;


import java.io.*;
import java.util.Arrays;
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
            put("#", " ");
        }
    };

    /**
     * Given a string named str, use the Caesar encoding above to return the decoded string.
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        // TODO: implement me
        //Challenge #1: Decode a string
        StringBuilder decodedString = new StringBuilder();
        for (char c : str.toCharArray())
        {
            String decodedChar = ENCODING.getOrDefault(String.valueOf(c), String.valueOf(c));
            decodedString.append(decodedChar);
        }
        return decodedString.toString();
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        //Challenge #2: Decode an Ingredient
        String[] parts = line.split("#");
        String amountDecoded = decodeString(parts[0]);
        String descriptionDecoded = decodeString(parts[1]);
        return new Ingredient(amountDecoded, descriptionDecoded);
    }

    // Challenge #3: Decode entire recipe
    public static void decodeRecipe(String inputFileName, String outputFileName) {
        try {
            // Get input file from resources
            InputStream inputStream = SecretRecipeDecoder.class.getResourceAsStream("/" + inputFileName);
            System.out.println(SecretRecipeDecoder.class.getResourceAsStream("/" + inputFileName));
            if (inputStream == null) {
                System.out.println("Input file not found!");
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Get path for writing output in the same resource folder
            File outputFile = new File(
                    SecretRecipeDecoder.class.getResource("/").getPath() + outputFileName
            );
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                Ingredient ingredient = decodeIngredient(line);
                writer.write(ingredient.toString());
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("Decoded recipe saved to " + outputFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

       public static void main(String[] args) {
        // TODO: implement me
        System.out.println(decodeString("hgiikf"));
        System.out.println(decodeString("8 vgl#hgiikf"));
           decodeRecipe("secret_recipe.txt", "decoded_recipe.txt");

    }
}
