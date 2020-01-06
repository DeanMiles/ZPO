object Rozgrzewka {

  def main(args: Array[String]) {
    var score = 0;
    var sign = 1;
    val string = "-3 + 4 - 1 + 1 + 12 - 5 + 6"
    for (v <- string.split(' ')) {
      if (matchTest(v) == 1 || matchTest(v) == -1) {
        sign = matchTest(v);
      } else {
          score += (v.toInt * sign);
      }
    }
    print(score)
  }

  def matchTest(x: String): Int = x match {
    case "+" => 1
    case "-" => -1
    case _ => 0
  }
}
