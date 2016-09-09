import java.io.File

class Document(file: File) {
  // class Word(value: String, frequency: Int)

  val name = file.toString()
  val value = io.Source.fromFile(file).mkString
  // tokenization
  val words = value.split("[\\p{Punct}\\s]+")
  val dictionary = words.toSet


}
