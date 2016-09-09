import java.io.File
import scala.collection.immutable.HashMap

object Main {

  def getListOfFiles(dir: String):List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

  def main(args: Array[String]):Unit = {
    val files = getListOfFiles("docs")
    val docs = files.map(file => new Document(file))
    var dictionary = HashMap.empty[String, Int]
    docs.map(doc => {
               println(doc.name)
               println(doc.words.length)
               println(doc.roughly.toList.length)
               for ((key, value) <- doc.dictionary) {
                 if (dictionary.contains(key))
                   dictionary += (key -> (dictionary(key) + value))
                 else
                   dictionary += (key -> value)
               }
               println(doc.dictionary.toList.length)
             })
  }

}

