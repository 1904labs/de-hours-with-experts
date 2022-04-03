package com.labs1904

import java.io.PrintWriter
import scala.collection.immutable.HashMap
import scala.io.Source

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
  def decodeString(str: String): String  = {
    val decodedStr = str.flatMap(c => if (c.isDigit || c.isLetter) ENCODING(c.toString) else c.toString)
    return decodedStr
  }

  /**
   * Given an ingredient, decode the amount and description, and return a new Ingredient
   * @param line An encoded ingredient.
   * @return
   */
  def decodeIngredient(line: String): Ingredient = {
    val decodedLine = decodeString(line)
    val ingredients = decodedLine.split("#")
    return Ingredient(ingredients(0), ingredients(1))
  }

  /**
   * A program that decodes a secret recipe
   * @param args
   */
  def main(args: Array[String]): Unit = {
    val finalFile = new PrintWriter("decoded_recipe.txt")
    // read the secret_recipe.txt file and read its content line by line
    val fileStream = getClass.getResourceAsStream("/secret_recipe.txt")
    val lines = Source.fromInputStream(fileStream).getLines()

    // iterate through each line in the secret_recipe.txt, decode and write to the file
    lines.foreach(line =>{
      val decodedIngredient = decodeIngredient(line)
      val decodedLine = decodedIngredient.amount + " " + decodedIngredient.description + "\n"
      finalFile.write(decodedLine)
    })
    //close
    finalFile.close()
  }
}
