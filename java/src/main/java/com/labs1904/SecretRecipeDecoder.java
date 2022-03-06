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
    public static String decodeString(String str, HashMap<String, String> Encoder) {
        // TODO: implement me
//        static String decodeString(String value,HashMap<String, String> Encoder) {
        String[] arrDecodedString = new String [str.length()];
        for(int i = 0; i < str.length(); i++) {
            char charAtIndex = str.charAt(i);
            String stringChar = Character.toString(charAtIndex);
            for (Map.Entry<String, string> code : ENCODING.entrySet()) {
                if (code.getKey().equals(stringChar)) {
                    arrDecodedString[i] = code.getValue();
                }
                if (arrDecodedString[i] == null) {
                    arrDecodedString[i] = stringChar;
                }
            }
        }
        String decodedString = String.join("", arrDecodedString);
        return decodedString;
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me Implement a function named decodeIngredient that takes a line from the recipe and returns a new Ingredient (a class already defined for you). The # sign delimits the encoded amount and the description of an ingredient. For example, the line 8 vgl#hgiikf would return an Ingredient with an amount of 1 cup and a description of butter
        String decodedIngredient = decodedIngredientString(line);

        String[] ingredientSplit = decodedIngredient.split("#");
        Ingredient newIngredient = new Ingredient(ingredientSplit[0], ingredientSplit[1]);
        return newIngredient;

        return null;
    }

    public static void main(String[] args) {
        // TODO: implement me
        try {
            FileWriter writer = new writer("src/main/resources/decoded_recipe.txt");
            try {
                File myObj = new File("src/main/resources/secret_recipe.txt");
                Scanner reader = new Scanner(myObj);
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    Ingredient ingredient = decodeIngredient(data);
                    writer.write(ingredient.toString() + "\n");
                }
                reader.close();
                writer.close();
            } catch (FileNotFoundException e) {
                System.out.println("An exception error has  occurred.");
            }
        } catch (IOException e) {
            System.out.println("An IO Exception occurred.");
        }
    }
}
