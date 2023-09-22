package utils

abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if(height == 0) 0 else contents(0).length
  def above(e: Element) = new ArrayElement(this.contents ++ e.contents)

  def beside(e: Element) = {
    new ArrayElement(for ((line1, line2) <- this.contents zip e.contents) yield line1 + line2)
  }
  override def toString: String = contents mkString "\n"
}

final class ArrayElement(val contents: Array[String]) extends Element {}
