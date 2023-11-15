package utils

object CollectionTest {
  def lastTest[T](seq: Seq[T]): Option[T] = seq.lastOption
  def reverseTest[T](arr: Array[T]): Array[T] = arr.reverse
}
