import org.scalatest.funsuite.AsyncFunSuite
import utils.ListTest

class ListTestSpec extends AsyncFunSuite {
  test("連結できること") {
    val li1 = List(1,2,3,4)
    val li2 = List(5,6)
    assert(ListTest.append(li1, li2) === List(1,2,3,4,5,6))
  }
}
