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
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        // TODO: implement me
        String newStr = "";
        for (int i=0; i < str.length(); i++) {

            if (ENCODING.containsKey(Character.toString(str.charAt(i)))) {
                newStr += ENCODING.get(Character.toString(str.charAt(i)));

            }
            if (str.charAt(i)==(' ')||str.charAt(i)==('#')) {
                newStr+=" ";
            }
            if (str.charAt(i)==('/')) {
                newStr+="/";
            }
        }

        return newStr;

    }


    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
        Ingredient cake = new Ingredient(decodeString(line.substring(0,line.indexOf('#'))),decodeString(line.substring(line.indexOf('#')+1, line.indexOf(line.charAt(line.length()-1))+1)));

        return cake;

    }

    public static void main(String[] args) {
        // TODO: implement me
        System.out.println(decodeString("8 vgl#hgiikf"));
        System.out.println(decodeString("8 vgl#xyfe hfntq ogzyf, lyvekx"));
        System.out.println(decodeString("8 vgl#zfyqgwyikx ogzyf"));
        System.out.println(decodeString("4#kzzo"));
        System.out.println(decodeString("8 ikyolnnq#jyqawwy"));
        System.out.println(decodeString("4 8/4 vglo#nyiukyw"));
        System.out.println(decodeString("4 vglo#pwngf"));
        System.out.println(decodeString("8/4 ikyolnnq#oywi"));
        System.out.println(decodeString("8 ikyolnnq#hyeaqz onxy"));
        System.out.println(decodeString("8 ikyolnnq#hyeaqz lntxkf"));
        System.out.println(decodeString("84 ngqvko#vsnvnwyik vsalo"));
        System.out.println(decodeString("8#2-ngqvk uawe vsnvnwyik hyf"));
        System.out.println(decodeString("8 8/4 vglo#vsnllkx qgio"));
        System.out.println(decodeIngredient("8 vgl#hgiikf"));
        System.out.println(decodeIngredient("8#2-ngqvk uawe vsnvnwyik hyf"));

    }
}

