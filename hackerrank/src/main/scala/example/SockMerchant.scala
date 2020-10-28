package example

import scala.annotation.tailrec

object SockMerchant extends App {

  /*

  Alex works at a clothing store.
  There is a large pile of socks that must be paired by color for
  sale. Given an array of integers representing the color of each sock,
  determine how many pairs of socks with matching colors there are.

  For example, there are  socks with colors . There is one pair of color
  and one of color . There are three odd socks left, one of each color. The number of pairs is .

Function Description

Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.

sockMerchant has the following parameter(s):

n: the number of socks in the pile
ar: the colors of each sock
Input Format

The first line contains an integer , the number of socks represented in .
The second line contains  space-separated integers describing the colors  of the socks in the pile.

Constraints

 where
Output Format

Return the total number of matching pairs of socks that Alex can sell.

Sample Input

9
10 20 20 10 10 30 50 10 20
Sample Output

3
   */

  val numSocks = 9

  val input = List(10, 20, 20, 10, 10, 30, 50, 10, 20)

  def findPairs(input: List[Int]): Int = {
    @tailrec
    def findPairsRecursive(input: List[Int], pairs: List[(Int, Int)]): Int = input match {
      case Nil => pairs.length
      case f :: s :: tail => if (f == s) {
            findPairsRecursive(tail, pairs :+ (f, s))
          } else {
            findPairsRecursive(s :: tail, pairs)
          }
      case h => pairs.length
    }
    findPairsRecursive(input, Nil)
  }

  val numberOfPairs = findPairs(input.sorted)
  println(numberOfPairs)
  // got value 3 - correct
}
