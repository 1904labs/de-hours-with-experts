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
    "a" -> "y",
    "b"-> "h",
    "c"-> "v",
    "d"-> "x",
    "e"-> "k",
    "f"-> "p",
    "g"-> "z",
    "h"-> "s",
    "i"-> "a",
    "j"-> "b",
    "k"-> "e",
    "l"-> "w",
    "m"-> "u",
    "n"-> "q",
    "o"-> "n",
    "p"-> "l",
    "q"-> "m",
    "r"-> "f",
    "s"-> "o",
    "t"-> "i",
    "u"-> "g",
    "v"-> "j",
    "w"-> "t",
    "x"-> "d",
    "y"-> "r",
    "z"-> "c",
    "0"-> "3",
    "1"-> "8",
    "2"-> "4",
    "3"-> "0",
    "4"-> "2",
    "5"-> "7",
    "6"-> "5",
    "7"-> "9",
    "8"-> "1",
    "9"-> "6"
  )

  /**
   * Given a string named str, use the Caeser encoding above to return the decoded string.
   * @param str A caesar-encoded string.
   * @return
   */
  def decodeString(str: String): String  = ???

  /**
   * Given an ingredient, decode the amount and description, and return a new Ingredient
   * @param line An encoded ingredient.
   * @return
   */
  def decodeIngredient(line: String): Ingredient = ???

  /**
   * A program that decodes a secret recipe
   * @param args
   */
  def main(args: Array[String]): Unit = {
    // TODO: implement me
  }
}
