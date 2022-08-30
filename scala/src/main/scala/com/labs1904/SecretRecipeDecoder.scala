package com.labs1904

import scala.collection.immutable.HashMap

/**
 * An ingredient has an amount and a description.
 * @param amount For example, "1 cup"
 * @param description For example, "butter"
 */
case class Ingredient(amount: String, description: String) {
  override def toString(): String = s"$amount, $description"
}

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
  def decodeString(str: String): String = 
    str.map((char: Char) => this.ENCODING.get(s"$char").getOrElse(s"$char").charAt(0))

  /**
   * Given an ingredient, decode the amount and description, and return a new Ingredient
   * @param line An encoded ingredient.
   * @return
   */
  def decodeIngredient(line: String): Ingredient = {
    val ingredientInputsEncoded: Array[String] = line.split("#")
    val decodedUnit: String = decodeString(ingredientInputsEncoded(0))
    val decodedIngredient: String = decodeString(ingredientInputsEncoded(1))
    Ingredient(decodedUnit, decodedIngredient)
  }

  /**
   * A program that decodes a secret recipe
   * @param args
   */
  def main(args: Array[String]): Unit = {
    val destination = new java.io.File("src/main/resources/decoded_recipe.txt")
    val printWriter = new java.io.PrintWriter(destination)
    for (line <- scala.io.Source.fromFile("src/main/resources/secret_recipe.txt").getLines()) {
      printWriter.write(s"${decodeIngredient(line)}\n")
    }
    printWriter.close()
  }
}
