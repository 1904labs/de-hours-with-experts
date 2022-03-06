// package com.labs1904

import java.io.PrintWriter
import scala.io.Source

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
  def decodeString(str: String): String  = {
    
    var decoded: String = ""
    
    for (i <- str) {
      // i is a char we must convert to string
      val j = i.toString
      decoded += ENCODING(j)
      // println(ENCODING(j))
    }
    println("Decoded string : " + decoded)
    // Last line returns
    decoded
  }

  /**
   * Given an ingredient, decode the amount and description, and return a new Ingredient
   * @param line An encoded ingredient.
   * @return
   */
  def decodeIngredient(line: String): Ingredient = {
    // Ingredient is a quantity # description

    var quantity: String = ""
    var description: String = ""
    // While we have not reached the '#' push to quantity
    var k = 0
    var indexOfHash: Int = line.indexOf('#')
    // println("Index of hash: " + indexOfHash)
    while (k < line.length) {
      // println("K: " + k)
      var char = line(k).toString
      if (k < indexOfHash) {
        // println("char " + char)
        if (ENCODING.contains(char)) {
          quantity += ENCODING(char)
        } else {
          quantity += char
        }
      } else if (k > indexOfHash) {
        // var char = line(k).toString
        // println("char " + char)
        if (ENCODING.contains(char)) {
          description += ENCODING(char)
        } else {
          description += char
        }
      }
      k += 1
    }
    // println("Decoded quantity: " + quantity)
    // println("Decoded description: " + description)
    // println("Decoded ingredient: " + decodedIngredient)
    // decodedIngredient
    new Ingredient(quantity, description)
  }

  /**
   * A program that decodes a secret recipe
   * @param args
   */
  def main(args: Array[String]): Unit = {
    // TODO: implement me
    val recipe = Source.fromFile("/Users/eyeballkid/Documents/Dev/hours-with-experts/de-hours-with-experts/scala/src/main/resources/secret_recipe.txt", "UTF-8")
    val lines = recipe.getLines
    val writer = new PrintWriter("decoded_recipe.txt")
    for (line <- lines) {
      var decodedIngredient = decodeIngredient(line)
      var decodedLine = decodedIngredient.amount + " " + decodedIngredient.description
      println(decodedLine)
      writer.println(decodedLine)
    }
    writer.close()
    // println(new java.io.File("./").getCanonicalPath)
  }
}
