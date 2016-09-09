import java.io.File

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
    docs.map(doc => {
               println(doc.name)
               println(doc.words.length)
               println(doc.dictionary.toList.length)
             })
  }

}

