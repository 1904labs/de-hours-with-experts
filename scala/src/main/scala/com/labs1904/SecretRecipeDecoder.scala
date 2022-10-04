package com.labs1904

import java.io.PrintWriter
import scala.collection.immutable.HashMap
import scala.collection.mutable

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
    "6" -> "9",
    "/" -> "/"
  )

  /**
   * Given a string named str, use the Caeser encoding above to return the decoded string.
   * @param str A caesar-encoded string.
   * @return
   */
  def decodeString(str: String): String = {
    // todo: implement me
    val res = new StringBuilder()
    str.foreach(x => res.append(ENCODING.getOrElse(x.toString, " ")))
    res.toString()
  }

  /**
   * Given an ingredient, decode the amount and description, and return a new Ingredient
   * @param line An encoded ingredient.
   * @return
   */
  def decodeIngredient(line: String): Ingredient = {
    // todo: implement me
    val code:Array[String] = line.split("#")
    val amount:String = decodeString(code(0))
    val ingredient = decodeString(code(1))
    Ingredient(amount, ingredient)
  }

  /**
   * A program that decodes a secret recipe
   * @param args
   */
  def main(args: Array[String]): Unit = {
    // TODO: implement me
    val lines = scala.io.Source.fromFile("src/main/resources/secret_recipe.txt", "utf-8").getLines()

    val decoded = lines.map(decodeIngredient(_))
    val pw = new PrintWriter("src/main/resources/decoded.txt")
    decoded.foreach( line => pw.println(line.amount + " " + line.description))
    pw.close()
  }
}
