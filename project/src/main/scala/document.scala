import java.io.File

class Document(file: File) {

  val name = file.toString()
  val value = io.Source.fromFile(file).mkString
  // tokenization
  val words = value.split("[\\p{Punct}\\s]+")
  // simple terms retrieval, without even case
  val dictionary = words.toSet


}
