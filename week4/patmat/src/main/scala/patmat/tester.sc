import patmat.Huffman
import patmat.Huffman.Leaf
import patmat.Huffman._
import common._

val a = Leaf('a',8)
val b = Leaf('b',3)
val c = Leaf('c',1)
val d = Leaf('d',1)
val e = Leaf('e',1)
val f = Leaf('f',1)
val g = Leaf('g',1)
val h = Leaf('h',1)

val gh = Fork(g,h,List('g','h'),2)
val ef = Fork(e,f,List('e','f'),2)
val efgh = makeCodeTree(ef,gh)
val cd = Fork(c,d,List('c','d'),2)
val bcd = makeCodeTree(b,cd)
val bcdefgh = makeCodeTree(bcd,efgh)
val abcdefgh = makeCodeTree(a,bcdefgh)
decode(abcdefgh,List(0,1,0,0,0,1,0,1,0))
decodedSecret






