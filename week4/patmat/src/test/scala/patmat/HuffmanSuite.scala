package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
	trait TestTrees {
		val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
		val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
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
  }


  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("weight of sample tree") {
    new TestTrees {
      assert(weight(abcdefgh) === 17)
    }
  }


  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }


  test("chars of sample tree") {
    new TestTrees {
      assert(chars(abcdefgh) === List('a','b','c','d','e','f','g','h'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }


  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }


  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }


  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("decode sample tree"){
    new TestTrees {
      assert(decode(abcdefgh,List(0,1,0,0,0,1,0,1,0)) === List('a', 'b', 'a', 'c'))
    }
  }
  test("decode secret"){
    new TestTrees {
      assert(decodedSecret === List('h', 'u', 'f', 'f', 'm', 'a', 'n', 'e', 's', 't', 'c', 'o', 'o', 'l'))
    }
  }
  test("encode sample"){
    new TestTrees {
      assert(encode(abcdefgh)("bac".toList) === List(1,0,0,0,1,0,1,0))
    }
  }
  test("quickencode sample"){
    new TestTrees {
      assert(quickEncode(abcdefgh)("abac".toList) === List(0,1,0,0,0,1,0,1,0))
    }
  }

}
