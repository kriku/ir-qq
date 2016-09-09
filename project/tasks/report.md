#### Information Retrieval <span class="right">Innopolis University <br> Krikun Gosha</span>

-------------------------------------------------------------------------------

## HW3 <small>Little Research Report</small>

[repository](https://gitlab.com/krikun/ir-qq)

### 0 Structure

```bash
project/                 # little research project
project/docs/            # test document set
project/src/main/scala   # research scala src
                      
project/tasks/           # this reports from .md
```

build with sbt

```bash
# git clone ssh or https ..
cd project
sbt
...

> run
```

### 1 Doc set

placed in `project/docs/` directory

| docId | terms | roughly | <small> tokens </small> |
| ----- | ------: | --------: | :-------- |
 | docs/arrays | 502 | 558 | <small> 1948 </small> | 
 | docs/mutable-and-immutable-collections | 362 | 396 | <small> 1048 </small> | 
 | docs/collection-sets | 453 | 506 | <small> 1854 </small> | 
 | docs/collections-trait-traversable | 434 | 487 | <small> 1633 </small> | 
 | docs/collections-trait-iterable | 278 | 307 | <small> 713 </small> | 
 | docs/maps | 447 | 494 | <small> 1810 </small> | 
 | docs/scala-for-java-programmers | 962 | 1055 | <small> 4983 </small> | 
 | docs/classes | 227 | 240 | <small> 430 </small> | 
 | docs/sets | 453 | 506 | <small> 1854 </small> | 

<small class="center">Tabel 1. Roughly counted</small>

### 2.1 Terms

Total terms:

```markdown
terms : 1709
```

### 2.2 Stop words

First 7 by frequency:

```markdown
the : 916
of  : 430
a   : 425
is  : 317
to  : 313
in  : 294
and : 277
```
