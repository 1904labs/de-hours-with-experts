package com.labs1904;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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
     *
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        // TODO: implement me
        String decodedString;
        List<String> decodedChars = new ArrayList<>();
        HashMap<Integer, Character> secretStrMap = new HashMap<>();
        //Map<Integer, String> secretStrMap = new HashMap<Integer, String>() {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            secretStrMap.put(i, c);
        }
        for (Character secretStr : secretStrMap.values()) {
            if (ENCODING.containsKey(Character.toString(secretStr))) {
                decodedChars.add(ENCODING.get(Character.toString(secretStr)));
            } else {
                decodedChars.add(Character.toString(secretStr));
            }
        }
        decodedString = String.join("", decodedChars);
        return decodedString;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     *
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        String[] stringArray = line.split("#");
        String amount = decodeString(stringArray[0]);
        String description = decodeString(stringArray[1]);
        Ingredient newIngredient = new Ingredient(amount, description);
        return newIngredient;
    }

    public static void main(String[] args) {
        // TODO: implement me
        //System.out.println(decodeIngredient("8 vgl#hgiikf").toString());
        try {
            Path current = Paths.get("java/src/main/resources");
            String t = current.toAbsolutePath().toString();
            File input = new File("java/src/main/resources/secret_recipe.txt");
            File output = new File("/Users/avener/Desktop/de-hours-with-experts/java/src/main/resources/decoded_recipe.txt");
            Scanner sc = new Scanner(input);
            PrintWriter printer = new PrintWriter(output);
            while (sc.hasNextLine()) {
                String s = decodeIngredient(sc.nextLine()).toString();
                printer.write(s);
            }
            sc.close();
            printer.close();
        } catch (
                FileNotFoundException e) {
            System.err.println("File not found. Please scan in new file.");
        }
    }
}
