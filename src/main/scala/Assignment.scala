import com.sun.security.auth.callback.DialogCallbackHandler

/**
  * Created by Tarek Ottey on 10/14/2017.
  */
object Assignment {
  type Out = BigInt

  def factorial(n: Int): Out = {
    require(n >= 0, "n must be non negative")

    var accumulator: Out = 1
    var i = 1
    while (i <= n) {
      accumulator = i * accumulator
      i += 1
    }
    accumulator
  }

  def isPalindrome(s: String): Boolean = {
    if (s == null || s.isEmpty) return true;
    return s == s.reverse
  }

  def runLengthEncode(s: String): String = {
    (1 until s.size).foldLeft((1, s(0), new StringBuilder)) {
      case ((len, c, sb), index) if c != s(index) => sb.append(c); sb.append(len); (1, s(index), sb)
      case ((len, c, sb), _) => (len + 1, c, sb)
    } match {
      case (len, c, sb) => sb.append(c); sb.append(len); sb.toString
    }
  }

  def runLengthDecode(s: String): String = {
    val sb = new StringBuilder
    val Code = """([A-Za-z])(\d+)""".r
    for (Code(c, len) <- Code findAllIn s) sb.append(c * len.toInt)
    sb.toString
  }

  def compose[A](f: (A) => A, g: (A) => A) = (a: A) => f(g(a))

}