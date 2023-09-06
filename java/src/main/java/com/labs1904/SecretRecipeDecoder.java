package com.labs1904;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

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
        //        return "1 cup";
char[] chars=str.toCharArray();
String concatStr="";
        for(int i=0;i<str.length();i++){
        String decodedString =ENCODING.getOrDefault(Character.toString((chars[i]))," ");
        concatStr=concatStr.concat(decodedString);
        }
    return concatStr;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
       // return new Ingredient("1 cup", "butter");
        String data=line;
        String[] s=data.split("#");
        return  new Ingredient(decodeString(s[0]),decodeString(s[1]));
    }

    public static void main(String[] args) throws IOException {
        // TODO: implement me

        /* Read a data from secret_recipe.txt  */
try {
    String file = "C:\\Users\\User\\IdeaProjects\\1904\\java\\src\\main\\resources\\secret_recipe.txt";
    Stream<String> stream = Files.lines((Paths.get(file)));
    String data = stream.collect(Collectors.joining("\n"));
    stream.close();


        /* write a  decoded data to decode_recipe.txt
           create a decode_recipe.txt and write data into file  */
    try {
        String newFile = "decode_recipe.txt";
        String directory = System.getProperty("user.dir");
        String absolutePathForWrite = directory + File.separator + newFile;

        // File fileWrite=new File(absolutePathForWrite);

        File fileWrite = new File("C:\\Users\\User\\IdeaProjects\\1904\\java\\src\\main\\resources\\decode_recipe.txt");
        System.out.println(fileWrite);
        if (!fileWrite.exists()) {
            fileWrite.createNewFile();
            System.out.println("file created");
        } else {
            System.out.println("file exist");
        }

        FileOutputStream fos = new FileOutputStream(fileWrite);
        String[] s = data.split("\n");
        String lineSeparator = System.getProperty("line.separator");

        for (int k = 0; k < s.length; k++) {

            String written = SecretRecipeDecoder.decodeString((s[k]) + "\n");
            fos.write(written.getBytes());
            fos.write(lineSeparator.getBytes());

        }

        fos.close();
        fos.flush();


    } catch (FileNotFoundException e) {
        System.out.println("An error occured");
    }

} catch (IOException e) {
    throw new RuntimeException(e);
}
    }
}

