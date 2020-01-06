import scala.collection.immutable.Stack

object FoldLeft {
  def main(args: Array[String]) {

    assert(checkBalancedParens("))((") == false)
    assert(checkBalancedParens("(()(ab)c)"))
    assert(checkBalancedParens("((()())") == false)
    assert(checkBalancedParens("(()))(") == false)
    assert(checkBalancedParens("(aa(b)()c)d"))
    print("Successful assertion ")
  }

  def checkBalancedParens(password: String): Boolean = {
    val parenthesis = Map('}' -> '{', ')' -> '(', ']' -> '[', '>' -> '<')

    val isParenthesis: (Char) => Boolean = c => parenthesis exists {
      case (closed, opened) => closed == c || opened == c
    }
    val isClosing: (Char) => Boolean = parenthesis.contains
    val openingFor: (Char) => Option[Char] = parenthesis.get

    password.toCharArray
      .filter(isParenthesis)
      .foldLeft(Stack[Char]())((stack, p) => {
        if (isClosing(p) && openingFor(p) == stack.headOption) stack.pop
        else stack.push(p)
      }).isEmpty
  }

}
