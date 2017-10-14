import org.scalatest.FunSuite

/**
  * Created by Tarek Ottey on 10/14/2017.
  */


class AssignmentTest extends FunSuite {
  test("Assignment.factorial") {
    assert(Assignment.factorial(5) === 120)
    assert(Assignment.factorial(0) === 1)
    assert(Assignment.factorial(1) === 1)
    assertThrows[IllegalArgumentException](Assignment.factorial(-1))
  }

  test("Assignment.isPalindrome") {
    val testStrings: List[String] = List("madam", "mom", "radar", "refer", "wow")
    for (testString <- testStrings) {
      assert(Assignment.isPalindrome(testString))
    }
    assert(Assignment.isPalindrome(null))
    assert(Assignment.isPalindrome(""))
    assert(Assignment.isPalindrome("isPalindrome") === false)
  }



  test("Assignment.runLengthEncode") {
    val text: String = "aaaaaaaaaabbbaxxxxyyyzyx"
    val code: String = "a10b3a1x4y3z1y1x1"
    assert(Assignment.runLengthEncode(text).equals(code))
  }

  test("Assignment.runLengthDecode"){
    val text: String = "aaaaaaaaaabbbaxxxxyyyzyx"
    val code: String = "a10b3a1x4y3z1y1x1"
    assert(Assignment.runLengthDecode(code).equals(text))
  }

  test("Assignment.compose"){
    def inc(a: Int): Int = {
      var b = a
      b += 1
      return b }

    def sq(a: Int): Int = {
      var b = a
      b *= b
      return b }

    var h = Assignment.compose( sq, inc)
    assert(h(6).equals(49))
  }


}