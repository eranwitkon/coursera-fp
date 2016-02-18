

val keys = List(('a',1),('c',1))
val x = List(('a',1),('b',1),('c',1))
val m = x.toMap
keys.foldLeft(m){ case (m , (k,v)) => m - k}


for (k <- keys) yield m - k._1








