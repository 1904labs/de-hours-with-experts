package com.labs1904;


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
     *
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        // TODO: implement me
        List<String> decodeStrList = new ArrayList<>();

        for (char cha : str.toCharArray()) {
            String chaStr = Character.toString(cha);
            if (ENCODING.containsKey(chaStr)) {
                decodeStrList.add(ENCODING.get(chaStr));
            } else {
                decodeStrList.add(chaStr);
            }
        }
        String decodeStr = String.join("", decodeStrList);

        return decodeStr;

    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     *
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        List<String> decodeStrListAmount = new ArrayList<>();
        List<String> decodeStrListDescription = new ArrayList<>();

        for (char cha : line.toCharArray()) {
            String chaStr = Character.toString(cha);

            if (chaStr != "#") {
                if (ENCODING.containsKey(chaStr)) {
                    decodeStrListAmount.add(ENCODING.get(chaStr));
                } else {
                    decodeStrListAmount.add(chaStr);
                }
            } else {
                if (ENCODING.containsKey(chaStr)) {
                    decodeStrListDescription.add(ENCODING.get(chaStr));
                } else {
                    decodeStrListDescription.add(chaStr);
                }
            }
        }
        String amount = String.join("", decodeStrListAmount);
        String description = String.join("", decodeStrListDescription);

        return new Ingredient(amount, description);
    }

    public static void main(String[] args) {
        // TODO: implement me
        System.out.println("Challenge #1");
        String str1 = "hgiikf";
        System.out.println(decodeString(str1));

        System.out.println("Challenge #2");
        String str2 = "8 vgl#hgiikf";
        System.out.println(decodeString(str2));

        System.out.println("Challenge #3");
        // File path is passed as parameter
        File file = new File(
                "C:\\dtg\\jobHunting\\20220302for1904labs\\de-hours-with-experts\\java\\src\\main\\resources\\secret_recipe.txt}");

        /*File file = new File(
                "C:\\Users\\16366\\Desktop\\secret_recipe.txt");

        */

        // Creating an object of BufferedReader class
        BufferedReader br
                = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;
        List<String> decodeStr111 = new ArrayList<>();
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null) {
            System.out.println(decodeIngredient(st).getAmount());
            System.out.println(decodeIngredient(st).getDescription());
        }


    }
}
