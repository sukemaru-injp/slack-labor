package utils

import java.awt.print.Book

trait ListTest {
  def append[T](xs: List[T], ys: List[T]): List[T]
}
object ListTest extends ListTest {
  override def append[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List()   => ys
    case x :: xs1 => x :: append(xs1, ys)
  }
}
