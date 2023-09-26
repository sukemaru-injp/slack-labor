package utils

import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int): Unit
  def print(): Unit
}
class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]

  def get(): Int = buf.remove(0)
  def put(x: Int): Unit = { buf += x }

  def print(): Unit = println(this.buf)
}
