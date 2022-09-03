package com.labs1904;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

        StringBuilder decodedStringBuilder = new StringBuilder();

        for (String character : str.split("")) {

            String decodedCharacter = ENCODING.get(character);

            if (decodedCharacter != null) {
                decodedStringBuilder.append(decodedCharacter);
            } else {
                decodedStringBuilder.append(character);
            }

        }
        return decodedStringBuilder.toString();
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        String[] splitLine = line.split("#");
        return new Ingredient(decodeString(splitLine[0]), decodeString(splitLine[1]));
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {
        System.out.println(System.getProperty("user.dir"));
        String inputFilename = "de-hours-with-experts/java/src/main/resources/secret_recipe.txt";
        String outputFilename = "de-hours-with-experts/java/src/main/resources/decoded_recipe.txt";
        try(
            BufferedReader br = new BufferedReader(new FileReader(inputFilename));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilename))) {
                String line;
                while((line = br.readLine()) != null) {
                    Ingredient ingredient = decodeIngredient(line);
                    bw.write(String.format("%s %s%n", ingredient.getAmount(), ingredient.getDescription()));
                }
        }
    }
}
