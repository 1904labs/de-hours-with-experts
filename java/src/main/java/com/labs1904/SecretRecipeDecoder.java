package com.labs1904;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
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
        // TODO: implement me
        //return "1 cup";
        char[] chars = str.toCharArray();
        String ConcatStr = "";

        for (int i = 0; i < str.length(); i++) {

                String LocString = ENCODING.getOrDefault(Character.toString(chars[i])," ");
                //  System.out.println(LocString);
                ConcatStr = ConcatStr.concat(LocString);


        }

        return ConcatStr;

    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
       // return new Ingredient("1 cup", "butter");
        String data = line;
        String[] s = data.split("#");
        return new Ingredient( decodeString(s[0]),decodeString(s[1]));
    }

    public static void main(String[] args) {
        // TODO: implement me
        try {
            SecretRecipeDecoder sr = new SecretRecipeDecoder();
            String file = "/Users/sraje/IdeaProjects/de-hours-with-experts/java/src/main/resources/secret_recipe.txt";
            Path path = Paths.get(file);
            Stream<String> lines = Files.lines(path);
            String data = lines.collect(Collectors.joining("\n"));
            lines.close();

            try {
                String filename = "decode.txt";

                String directory = System.getProperty("user.dir");
                String absoluteFilePath = directory + File.separator + filename;
                System.out.println(absoluteFilePath);
                File file2 = new File(absoluteFilePath);
                if (!file2.exists()) {
                    file2.createNewFile();
                    System.out.println("file created");
                }
                FileWriter fw = new FileWriter(file2.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                String[] s = data.split("\n");
                for (int i = 0; i < s.length; i++) {
                    bw.write((SecretRecipeDecoder.decodeString(s[i]) + "\n"));

                }
                bw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred...");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
