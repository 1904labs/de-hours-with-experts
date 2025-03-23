package com.labs1904;


import java.io.*;
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
     * @return
     */
    public static String decodeString(String str) {
        // TODO: implement me

        StringBuilder decoded = new StringBuilder();
        // Holds decoded answer


        for (char c : str.toCharArray()) {
            String decodedChar = ENCODING.getOrDefault(String.valueOf(c), String.valueOf(c));
            System.out.println("Decoding: " + c + " -> " + decodedChar);
            decoded.append(decodedChar);
        }
        return decoded.toString();
    }
        // For loop, loops through each character in string.
        // Defaults to itself if it doesn't find corresponding character.
        // Returns decoded string.

//    public static void main(String[] args) {
//        System.out.println(decodeString("8 vgl"));  // Should print: 1 cup
//    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        String[] parts = line.split("#");
        // Separates amounts and description.

        if (parts.length < 2) {
            System.out.println("Error: Invalid ingredient format.");
            return null;
        }
        // Makes sure there are two parts and prints error if something is wrong and returns null.

        String amount = decodeString(parts[0].trim());
        String description = decodeString(parts[1].trim());

        return new Ingredient(amount, description);

        // Returns Ingredient object.
    }

    public static void main(String[] args) {
        // TODO: implement me
        InputStream inputStream = SecretRecipeDecoder.class.getClassLoader().getResourceAsStream("secret_recipe.txt");
         if (inputStream == null) {
             System.out.println("Error, file not found.");
             return;
         }

         // Looks for our secret file in resource folder. Prints error if not found.

         File outputFile = new File("decoded_recipe.txt");

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))

        // Buffered Reader to read input file stream (given txt file).
        // Buffered Writer to write our output file (decoded txt file).
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                Ingredient ingredient = decodeIngredient(line);

                if (ingredient != null) {
                    writer.write(ingredient.getAmount() + " " + ingredient.getDescription());
                    writer.newLine();
        // Making sure it is not null before writing. Then moves to next line.
                }
            }
            System.out.println("Decode complete. Saved to decoded_recipe.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    // Exception handling
    }
}
