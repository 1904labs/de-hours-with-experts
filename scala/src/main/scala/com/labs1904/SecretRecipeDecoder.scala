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
    // todo: implement me
    // "1 cup"

    // NOTES - if no result brought back must return original str
    // Personal notes - tested using a phrase set as "8 vgl#zfyqgwyikx ogzyf"
    // the below line works but will error out if key not found
    // for(letter <- phrase) (print(ENCODING(s"$letter")))
    // removed # from phrase and used this:
    // for(letter <- phrase if letter.toString != " ") (print(ENCODING(s"$letter")))
    // this solved the problem of spaces but resulted in "1cupgranulatedsugar"
    // researched available key value pair methods in scala and found .contains
    // if (ENCODING.contains(s"$str")) return (ENCODING(s"$str")) else return (s"$str") results in "1 cup#granulated sugar"
    // future thoughts - is the # supposed to represent a break? Read ahead to challenge 2!


    if (ENCODING.contains(s"$str")) return (ENCODING(s"$str")) else return (s"$str")

  }

  /**
   * Given an ingredient, decode the amount and description, and return a new Ingredient
   * @param line An encoded ingredient.
   * @return
   */
  def decodeIngredient(line: String): Ingredient = {
    // todo: implement me
    Ingredient("1 cup", "butter")

  }

  /**
   * A program that decodes a secret recipe
   * @param args
   */
  def main(args: Array[String]): Unit = {
    // TODO: implement me
  }
}


scala> if (states.contains("FOO")) println("Found foo") else println("No foo")
