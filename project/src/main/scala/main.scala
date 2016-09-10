import java.io.File
import scala.collection.immutable.HashMap
import scala.collection.immutable.ListMap
import scala.collection.mutable.ListBuffer
import scala.language.postfixOps
import scala.math.{max,min}

object Main {
  def editDist[A](a: Iterable[A], b: Iterable[A]) =
    ((0 to b.size).toList /: a)((prev, x) =>
      (prev zip prev.tail zip b).scanLeft(prev.head + 1) {
        case (h, ((d, v), y)) => min(min(h + 1, v + 1), d + (if (x == y) 0 else 1))
          }) last

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
    val query = "define"
    println(postings(query).toList)
    var relevant = HashMap.empty[String, Set[String]]
    postings.keys.map(key => (
                        if (editDist(key, "define") <= 1) {
                          if (!relevant.contains(query)) relevant += (query -> postings(key).toSet)
                          else for (docId <- postings(key)) {
                            relevant(query) + docId
                          }
                          println(key)
                          println(postings(key).toList)
                        }
                      ))
    println(relevant.toList)
  }

}

