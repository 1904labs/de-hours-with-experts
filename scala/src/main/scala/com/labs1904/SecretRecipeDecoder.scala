package com.labs1904

import scala.collection.immutable.HashMap
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter


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
   * @return The decoded string.
   */
  def decodeString(str: String): String = {
    str.map(c => ENCODING.getOrElse(c.toLower.toString, c.toString)).mkString("")
  }

  /**
   * Given an ingredient, decode the amount and description, and return a new Ingredient
   * @param line An encoded ingredient.
   * @return
   */
  def decodeIngredient(line: String): Ingredient = {
    val (amount, description) = line.split("#") match {
      case Array(amount, desc) => (decodeString(amount), decodeString(desc))
      case _ => ("", "")
    }
    Ingredient(amount, description)
  }

  /**
   * Helper function to read files
   * @param inputFileName
   * @return
   */
  def readEncodedRecipe(inputFileName: String): List[String] = {
    scala.io.Source.fromFile(inputFileName).getLines().toList
  }

  /**
   * helper function to write decoded files
   * @param outputFileName
   * @param decodedRecipe
   */
  def writeDecodedRecipe(outputFileName: String, decodedRecipe: String): Unit = {
    val file = new File(outputFileName)
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(decodedRecipe)
    bw.close()
  }

  /**
   * A program that decodes a secret recipe
   * @param args
   */
  def main(args: Array[String]): Unit = {
//    I could've done the read and write here but figured seperation of concerns wouldn't hurt.

//    I'm not a scala person so ended up having to use absolute path instead of relative, tried to fix but wasn't able to.
    val inputFileName = "/Users/enrique/Documents/GitHub/de-hours-with-experts/scala/src/main/resources/secret_recipe.txt"
    val outputFileName = "/Users/enrique/Documents/GitHub/de-hours-with-experts/scala/src/main/resources/decoded_recipe.txt"

//    read recipe
    val encodedLines = readEncodedRecipe(inputFileName)
//    decode the recipe
    val decodedIngredients = encodedLines.map(decodeIngredient)
//    seperate out the amount and description, ideally wouldve been done in decodeRecipe function but following the prompt
    val decodedRecipe = decodedIngredients.map(i => s"${i.amount} ${i.description}").mkString("\n")
//    write the recipe
    writeDecodedRecipe(outputFileName, decodedRecipe)

    println("The cookie recipe! :) " + outputFileName)
  }
}
