package com.labs1904;


import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.labs1904.Ingredient;

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
        String output = "";
        String[] letters = str.split("");

        for (String x : letters) {
            if (ENCODING.containsKey(x)) {
                output = output + ENCODING.get(x);
            }
            else {
                output = output + x;
            }
        }

        return output;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        String[] words = line.split("\\s+");
        String decodedWord = "";

        for (String word : words) {
            decodedWord = decodedWord + " " + decodeString(word);
        }

        String[] decodedWords = decodedWord.split("#");

        return new Ingredient(decodedWords[0], decodedWords[1]);
    }

    public static void main(String[] args) {
        // TODO: implement me
        String inputFile = "../../../resources/secret_recipe.txt";
        String outputFile = "../../../resources/decoded_recipe.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Process the line here
                Ingredient processedLine = decodeIngredient(line);
                // Write the processed line to the output file
                writer.write(processedLine.getAmount() + " " + processedLine.getDescription());
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
        }
    }
}
