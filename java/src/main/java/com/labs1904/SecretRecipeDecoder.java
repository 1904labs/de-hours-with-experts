package com.labs1904;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char eachChar:charArray) {
            sb.append(ENCODING.getOrDefault(String.valueOf(eachChar), " "));
        }
//        Stream.of(charArray)
//            .forEach(eachChar -> sb.append(ENCODING.get(String.valueOf(eachChar))));
//            .map(eachChar -> ENCODING.get(String.valueOf(eachChar)))
//            .collect(Collectors.joining())
        ;
        return sb.toString();
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        String[] decodeLine = line.split("#", -1);
        List<String> ingredient = Stream.of(decodeLine)
                .map(SecretRecipeDecoder :: decodeString)
                .collect(Collectors.toList());
        return new Ingredient(ingredient.get(0),ingredient.get(1));
    }

    public static void main(String[] args) {
        try {
            SecretRecipeDecoder sr = new SecretRecipeDecoder();
            try (InputStream resource = sr.getClass().getClassLoader()
                    .getResourceAsStream("secret_recipe.txt")) {
                List<String> lines = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8))
                        .lines()
                        .collect(Collectors.toList());
                String content = lines.stream().map(l -> decodeIngredient(l).toString()).collect(Collectors.joining(System.lineSeparator()));
                String outputFilePath = sr.getClass().getResource("/").getPath() + "decoded_recipe.txt";
                Path newFile = Paths.get(outputFilePath.substring(1));
                Files.write(newFile, content.getBytes());
            }
        }
        catch (IOException ex){}

    }
}
