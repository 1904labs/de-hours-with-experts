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

            char[] chars=str.toCharArray();
            for(int i=0;i<chars.length;i++){
                if(ENCODING.containsKey(Charcter.toString(chars[i])))
                    String LocString=ENCODING.get(Charcter.toString(chars[i]));
                    ConcatStr=ConcatStr.concat(LocString)
                System.out.println(ConcatStr);
            }
            if (ConcatStr==="1 cup"){
                return "1 cup";
            }
        // TODO: implement me
        //return "1 cup";
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me
decodeString(line);
return null;
       // return new Ingredient("1 cup", "butter");
    }

    public static void main(String[] args) {
        File myObj=new File(pathname:"/Spring/Eswari-1904lab/java/src/main/resources/secret_recipe.txt")
        Scanner myReader=new Scanner(myObj);
        String line=myReader.nextLine();
        SecretRecipeDecoder.decodeIngredient(line);
        myReader.close();
        // TODO: implement me
    }
}
