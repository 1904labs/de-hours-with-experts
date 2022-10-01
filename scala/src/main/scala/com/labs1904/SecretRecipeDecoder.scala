package com.labs1904

import java.io.{BufferedWriter, FileWriter}
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
    str.map(_.toString).map(s => ENCODING.getOrElse(s, " ")).mkString
  }

  /**
   * Given an ingredient, decode the amount and description, and return a new Ingredient
   * @param line An encoded ingredient.
   * @return
   */
  def decodeIngredient(line: String): Ingredient = {
    // todo: implement me
    val splitLine = line.split("#")
    Ingredient(decodeString(splitLine(0)), decodeString(splitLine(1)))
  }

  /**
   * A program that decodes a secret recipe
   * @param args
   */
  def main(args: Array[String]): Unit = {
    // TODO: implement me
    val source = scala.io.Source.fromFile("scala/src/main/resources/secret_recipe.txt")
    val bw = new BufferedWriter(new FileWriter("scala/src/main/resources/decoded_recipe.txt"))
    try {
      source.getLines().map(decodeIngredient)
        .map(ingredient => "%s %s%n".format(ingredient.amount, ingredient.description)).foreach(line => bw.write(line))
    }
    finally {
      source.close()
      bw.close()
    }
  }
}
