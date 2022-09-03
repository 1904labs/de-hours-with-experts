package com.labs1904;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        String[] letters = str.split("");
        String[] decoded = new String[str.length()];

        for (int i = 0; i < str.length(); i++) {
            if (letters[i].isEmpty()) {
                decoded[i] = "";
            } else if (letters[i].equals(",")) {
                decoded[i] = ",";
            } else if (letters[i].equals("/")) {
                decoded[i] = "/";
            } else decoded[i] = ENCODING.get(letters[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            if (decoded[j] == null){
                stringBuilder.append(" ");
            } else stringBuilder.append(decoded[j]);
        }
        return stringBuilder.toString();

    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        String[] ing = line.split("#");
        return new Ingredient(decodeString(ing[0]), decodeString(ing[1]));
    }

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Users\\leuko\\Desktop\\hwe\\de-hours-with-experts\\java\\src\\main\\resources\\secret_recipe.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        List<Ingredient> decoded = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++){
            decoded.add(decodeIngredient(lines.get(i)));
        }

        FileWriter file = new FileWriter("C:\\Users\\leuko\\Desktop\\hwe\\de-hours-with-experts\\java\\src\\main\\resources\\decoded_recipe.txt");
        BufferedWriter output = new BufferedWriter(file);

        for (Ingredient ingredient : decoded) {
            System.out.println(ingredient.getAmount() + " " + ingredient.getDescription());
            output.write(ingredient.getAmount() + " " + ingredient.getDescription() + "\n");
        }

        output.close();

    }
}
