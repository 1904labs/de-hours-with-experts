package com.labs1904

import scala.collection.immutable.HashMap

/**
 * An ingredient has an amount and a description.
 * @param amount For example, "1 cup"
 * @param description For example, "butter"
 */
case class Ingredient(amount: String, description: String)

object SecretRecipeDecoder {
  val ENCODING: Map[String, String] = HashMap[String, String](
    "y" -> "a",
    "h" -> "b",
    "v" -> "c",
    "x" -> "d",
    "k" -> "e",
    "p" -> "f",
    "z" -> "g",
    "s" -> "h",
    "a" -> "i",
    "b" -> "j",
    "e" -> "k",
    "w" -> "l",
    "u" -> "m",
    "q" -> "n",
    "n" -> "o",
    "l" -> "p",
    "m" -> "q",
    "f" -> "r",
    "o" -> "s",
    "i" -> "t",
    "g" -> "u",
    "j" -> "v",
    "t" -> "w",
    "d" -> "x",
    "r" -> "y",
    "c" -> "z",
    "3" -> "0",
    "8" -> "1",
    "4" -> "2",
    "0" -> "3",
    "2" -> "4",
    "7" -> "5",
    "5" -> "6",
    "9" -> "7",
    "1" -> "8",
    "6" -> "9"
  )

  /**
   * Given a string named str, use the Caeser encoding above to return the decoded string.
   * @param str A caesar-encoded string.
   * @return
   */
  def decodeString(str: String): String = {
    // Declare the variable for the decoding response
val response = new StringBuilder
for (letter <- encoded_string) {
// The purpose is to leave the characters which are not in encoding as the same format
if (!ENCODING.contains(letter)) {
response.append(letter)
} else {
response.append(ENCODING(letter))
}
}
response.toString
}
   
  }

  /**
   * Given an ingredient, decode the amount and description, and return a new Ingredient
   * @param line An encoded ingredient.
   * @return
   */
  def decodeIngredient(line: String): Ingredient = {
   // Using # to separate the quantity and ingredient
val encoded_quantity = line.split("#")(0)
val encoded_ingredient = line.split("#")(1)
// Return the quantity and ingredient
new Ingredient(decode_string(encoded_quantity), decode_string(encoded_ingredient))
  }

  /**
   * A program that decodes a secret recipe
   * @param args
   */

   def main(recipe_path: String): Map[String, Any] = {
// Where you can open and read the file
val lines = Source.fromFile(recipe_path).getLines.toList
val recipe = lines.map(decode_ingredient)
// Return the objects and string of the recipe
Map(
"recipe_objects" -> recipe,
"recipe_text" -> recipe.map(ingredient => s"amount: ${ingredient.amount}, item: ${ingredient.description}").mkString
)
}

// Entry point
if (args.length > 0) {
val recipePath = args(0)
val result = main(recipePath)
println(result)
} else {
println("Please provide the path to the recipe file.")
}





  
