##### Information Retrieval <span class="right">innopolis university <br> krikun gosha </span>
-------------------------

## HW3 <small>Little Research Report</small>

### Recall and Precision

We would compare mainly this two characteristic.

#### But at the first lets consider test doc set:

| docId | terms | <small> tokens </small> |
| ----- | ------: | :-------- |
| docs/arrays | 558 | <small> 1948 </small> |
| docs/mutable-and-immutable-collections | 396 | <small> 1048 </small> |
| docs/collection-sets | 506 | <small> 1854 </small> |
| docs/collections-trait-traversable | 487 | <small> 1633 </small> |
| docs/collections-trait-iterable | 307 | <small> 713 </small> |
| docs/maps | 494 | <small> 1810 </small> |
| docs/scala-for-java-programmers | 1055 | <small> 4983 </small> |
| docs/classes | 240 | <small> 430 </small> |
| docs/sets | 506 | <small> 1854 </small> |

This is scala code for do that:

```scala
import java.io.File

class Document(file: File) {

  val name = file.toString()
  val value = io.Source.fromFile(file).mkString
  // tokenization
  val words = value.split("[\\p{Punct}\\s]+")
  // simple terms retrieval, without even case
  val dictionary = words.toSet


}
```


Aliquam erat volutpat.  Nunc eleifend leo vitae magna.  In id erat non orci commodo lobortis.  Proin neque massa, cursus ut, gravida ut, lobortis eget, lacus.  Sed diam.  Praesent fermentum tempor tellus.  Nullam tempus.  Mauris ac felis vel velit tristique imperdiet.  Donec at pede.  Etiam vel neque nec dui dignissim bibendum.  Vivamus id enim.  Phasellus neque orci, porta a, aliquet quis, semper a, massa.  Phasellus purus.  Pellentesque tristique imperdiet tortor.  Nam euismod tellus id erat.

Nullam eu ante vel est convallis dignissim.  Fusce suscipit, wisi nec facilisis facilisis, est dui fermentum leo, quis tempor ligula erat quis odio.  Nunc porta vulputate tellus.  Nunc rutrum turpis sed pede.  Sed bibendum.  Aliquam posuere.  Nunc aliquet, augue nec adipiscing interdum, lacus tellus malesuada massa, quis varius mi purus non odio.  Pellentesque condimentum, magna ut suscipit hendrerit, ipsum augue ornare nulla, non luctus diam neque sit amet urna.  Curabitur vulputate vestibulum lorem.  Fusce sagittis, libero non molestie mollis, magna orci ultrices dolor, at vulputate neque nulla lacinia eros.  Sed id ligula quis est convallis tempor.  Curabitur lacinia pulvinar nibh.  Nam a sapien.

Pellentesque dapibus suscipit ligula.  Donec posuere augue in quam.  Etiam vel tortor sodales tellus ultricies commodo.  Suspendisse potenti.  Aenean in sem ac leo mollis blandit.  Donec neque quam, dignissim in, mollis nec, sagittis eu, wisi.  Phasellus lacus.  Etiam laoreet quam sed arcu.  Phasellus at dui in ligula mollis ultricies.  Integer placerat tristique nisl.  Praesent augue.  Fusce commodo.  Vestibulum convallis, lorem a tempus semper, dui dui euismod elit, vitae placerat urna tortor vitae lacus.  Nullam libero mauris, consequat quis, varius et, dictum id, arcu.  Mauris mollis tincidunt felis.  Aliquam feugiat tellus ut neque.  Nulla facilisis, risus a rhoncus fermentum, tellus tellus lacinia purus, et dictum nunc justo sit amet elit.


 





