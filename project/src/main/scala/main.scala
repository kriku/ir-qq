import java.io.File
import scala.collection.immutable.HashMap
import scala.collection.immutable.ListMap

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
               print(" | " + doc.name + " | ")
               for ((key, value) <- doc.dictionary) {
                 if (dictionary.contains(key))
                   dictionary += (key -> (dictionary(key) + value))
                 else
                   dictionary += (key -> value)
               }
               print(doc.dictionary.toList.length + " | ")
               print(doc.roughly.toList.length + " | ")
               print("<small> " + doc.words.length + " </small> | ")
               println
             })
    val stopwords = ListMap(dictionary.toSeq.sortWith(_._2 > _._2):_*).take(7)
    stopwords.map{ case(key, value) => println(key + " : " + value) }
    println(dictionary.toList.length)
  }

}

