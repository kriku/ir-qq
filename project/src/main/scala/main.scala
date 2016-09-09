import java.io.File
import scala.collection.immutable.HashMap
import scala.collection.immutable.ListMap
import scala.collection.mutable.ListBuffer

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
    var postings = HashMap.empty[String, ListBuffer[String]]
    var count = 0

    docs.map(doc => {
               print(" | " + doc.name + " | ")
               for ((key, value) <- doc.dictionary) {
                 if (dictionary.contains(key)) {
                   dictionary += (key -> (dictionary(key) + value))
                   // only if didn't add
                   if (postings.contains(key)) {
                     if (!postings(key).contains(doc.name)) {
                       postings(key) += doc.name
                     }
                   }
                 } else {
                   dictionary += (key -> value)
                   postings += (key -> new ListBuffer())
                   postings(key) += doc.name
                 }
               }
               print(doc.dictionary.toList.length + " | ")
               print(doc.roughly.toList.length + " | ")
               count += doc.words.length
               print("<small> " + doc.words.length + " </small> | ")
               println
             })
    val stopwords = ListMap(dictionary.toSeq.sortWith(_._2 > _._2):_*).take(9)
    // var total = 0
    // stopwords.map{ case(key, value) => {
    //                  total += value
    //                  println(key + " : " + value)
    //                }
    // }
    // println(stopwords.zipWithIndex.toList)
    // println(total)
    println(dictionary.toList.length)
    println(count)
    println(postings("define").toList)
  }

}

