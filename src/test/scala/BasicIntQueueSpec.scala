import org.scalatest.funsuite.AsyncFunSuite
import utils.BasicIntQueue

class BasicIntQueueSpec extends AsyncFunSuite {
  test("pushした先頭が取得できること") {
    val test = new BasicIntQueue()
    test.put(1)
    test.put(2)
    test.put(3)
    
    assert(test.get() === 1)
  }
}
