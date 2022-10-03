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
    "6" -> "9",
    " "->" ",
    "#"->"#"
  )

  /**
   * Given a string named str, use the Caeser encoding above to return the decoded string.
   * @param str A caesar-encoded string.
   * @return
   * (hgiikf is decoded to butter)
   */
  def decodeString(str: String): String = {
    // todo: implement me
    //ArrayList<String> decodedString=new ArrayList<>();
    import java.util
    val decodedString = new util.ArrayList[String]
    val c="a"
    println("str= "+str)
    println(SecretRecipeDecoder.ENCODING(c))
    //val newString=str.map(c=>{
    //  str.replace(c,SecretRecipeDecoder.ENCODING(c))
    //}
    val characters=str.toList
    val newList=characters.map(c=>replaceChar(c.toString))
    println(characters)
    println(newList)
    val newString=newList.mkString
    println(newString)
    //
    // val decodedList=characters.map(c=>c.)
    //str.replace(str)
    //"1 cup"
    newString
  }

  def replaceChar(c:String):String={
    'i'
    SecretRecipeDecoder.ENCODING(c)
  }

  /**
   * Given an ingredient, decode the amount and description, and return a new Ingredient
   * @param line An encoded ingredient.
   * @return
   */
  def decodeIngredient(line: String): Ingredient = {
    // todo: implement me
    //val line="8 vgl#hgiikf"

    println("line= "+line)
    val decodedString=decodeString(line)
    println("decodedString= "+decodedString)
    var newList:Array[String]=Array()
    newList=decodedString.split("#")
    if(newList.length>1) {
      Ingredient(newList(0), newList(1))
      var s=Ingredient(newList(0),newList(1))
      println(s.amount+" "+s.description)
      Ingredient(newList(0),newList(1))
    }else{
      Ingredient(newList(0), null)
      var s=Ingredient(newList(0),null)
      println(s.amount+" "+s.description)
      Ingredient(newList(0),null)
    }
    //Ingredient("1 cup", "butter")
    //var s=Ingredient(newList(0),newList(1))
    //println(s.amount+" "+s.description)
    //Ingredient(newList(0),newList(1))
  }

  /**
   * A program that decodes a secret recipe
   * @param args
   */
  def main(args: Array[String]): Unit = {
    // TODO: implement me
    val str="str"
    decodeString(str)
    //var s=decodeIngredient("8 vgl#hgiikf")
    var s=decodeIngredient("hgiikf")
    println(s.amount+" "+s.description)
  }
}
