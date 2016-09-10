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
               print(doc.words.length + " |")
               println
             })

    println(dictionary.toList.length)

    val stopwords = ListMap(dictionary.toSeq.sortWith(_._2 > _._2):_*).take(9)

    println(stopwords.toList)

    val query = "compuet"

    if (postings.contains(query)) {
      println(postings(query).toList)
    } else {
      println("Quoted phrase doesn't appear")
    }

    var relevant = HashMap[String, Set[String]]()
    relevant += (query -> "".toSet)

    postings.keys.map(key => (
                        if (editDist(key, query) <= 2) {
                          relevant.updated(query, (query -> postings(key)))
                          println(key)
                          println(postings(key).toList)
                          // println(relevant(query).toList)
                        }
                      ))
    println(relevant.toList)
  }

}

