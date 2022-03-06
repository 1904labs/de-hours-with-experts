package com.labs1904;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        // TODO: implement
        //variable to hold decoded string
        String decoded = "";
        //loop over each letting in string and decode in not " " or "#"
        for (int i=0; i<str.length();i++){
            if(String.valueOf(str.charAt(i)).equals(" ")){
                decoded += " ";
            } else if (String.valueOf(str.charAt(i)).equals("#")) {
                decoded += "#";
            } else if (String.valueOf(str.charAt(i)).equals("/")) {
                decoded += "/";
            } else if (String.valueOf(str.charAt(i)).equals("-")) {
                decoded += "-";
            } else if (String.valueOf(str.charAt(i)).equals(",")) {
                decoded += ",";
            } else {
                decoded += decodeLetter(str.charAt(i));
            }

        }

        return decoded;
    }

    private static String decodeLetter(char encodeLetter) {
        return ENCODING.get(String.valueOf(encodeLetter));
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        String description = "";
        String amount = "";

        //returns decoded string
        String decodedLine = decodeString(line);
        //regex setup (group 1)#((group 2) // "1 cup#flour"
        String pattern = "([^#]*)#([^#]*)";
        Pattern regex = Pattern.compile(pattern);

        //get the amount and description from the decoded line
        //regex Matcher
        Matcher m = regex.matcher(decodedLine);
        if(m.find()) {
            amount = m.group(1);
            description = m.group(2);
        }

        Ingredient ingredient = new Ingredient(amount, description);

        return ingredient;
    }

    public static void decodeFile(String filePathEncodedFile) throws IOException {
        //takes string
        //gets file
        //loops lines in file (decodes)
        //writes decoded string to new file


        //method setup
        Path filePathDecodedFile = Path.of("./decoded_ingredient_list.txt");
        String decodedText = "";

        //get file and loop
        Scanner scanner = new Scanner(new File(filePathEncodedFile));
        while (scanner.hasNextLine()) {
            //collect and  decoded lines
            String decodedLine = decodeString(scanner.nextLine());
            decodedText += decodedLine + "\n";
        }
        scanner.close();

        Files.writeString(filePathDecodedFile, decodedText);
        return;
    }



    public static void main(String[] args) throws IOException, URISyntaxException {
        // TODO: implement me
        //returns decoded string
        Ingredient newIngredient = decodeIngredient("8 vgl#hgiikf");
        decodeFile("src/main/resources/secret_recipe.txt");
    }


}
