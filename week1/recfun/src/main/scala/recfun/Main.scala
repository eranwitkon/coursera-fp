package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if ((c==0) || (c==r))  1
    else pascal(c-1,r-1)+pascal(c,r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    balanceStack(chars,0)
  }

  def balanceStack(chars: List[Char], i: Int): Boolean = {
     chars match {
        case x :: xs => {
          if (x == '(') balanceStack(xs, i + 1)
          else if (x == ')')
            if (i>0) balanceStack(xs, i - 1)
              else false
          else balanceStack(xs, i)
        }
        case nil => (i == 0)
      }
  }
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    if (money==0) 1
    else
      if (money<0 || coins.isEmpty) 0
      else
        countChange(money,coins.tail) + countChange(money-coins.head,coins)
  }
}
