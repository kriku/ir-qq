import java.io.File
import scala.collection.immutable.HashMap

class Document(file: File) {

  val name = file.toString()
  val raw = io.Source.fromFile(file).mkString
  // tokenization
  val tokens = raw.split("[\\p{Punct}\\s]+")
  val words = tokens.map(word => word.toLowerCase())
  val roughly = words.toSet

  var dictionary = HashMap.empty[String, Int]

  for (word <- words) {
    if (dictionary.contains(word)) {
      dictionary += (word -> (dictionary(word) + 1))
    } else {
      dictionary += (word -> 1)
    }
  }

}
