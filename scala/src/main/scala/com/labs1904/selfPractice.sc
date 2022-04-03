
import scala.collection.immutable.HashMap

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
"8 vgl".flatMap(c => (ENCODING(c.toString)))

