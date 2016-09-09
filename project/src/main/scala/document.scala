import java.io.File
import scala.collection.immutable.HashMap

class Document(file: File) {

  val name = file.toString()
  val value = io.Source.fromFile(file).mkString
  // tokenization
  val tokens = value.split("[\\p{Punct}\\s]+")
  val words = tokens.map(word => word.toLowerCase())
  val roughly = tokens.toSet

  var dictionary = HashMap.empty[String, Int]

  for (word <- words) {
    if (dictionary.contains(word)) {
      dictionary += (word -> (dictionary(word) + 1))
    } else {
      dictionary += (word -> 1)
    }
  }

  // simple terms retrieval, without even case

}
