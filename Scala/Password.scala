object Password {
  def main(args: Array[String]) {
    print("Write your password \n")
    val a = scala.io.StdIn.readLine()
    validate(a)
    print("Password is correct")
  }

  def validate(password: String): Unit = {
    val maxFun = max(password)_
    val minFun = min(password)_
    val MAX_VALUE = 10;
    val MIN_VALUE = 5;

    if (!maxFun(MAX_VALUE))
      throw new IllegalArgumentException("The password contains " + password.length() + " letters where maximum is " + MAX_VALUE)
    else if (!minFun(MIN_VALUE))
      throw new IllegalArgumentException("The password contains " + password.length() + " letters where minimum is " + MIN_VALUE)
    else if (!containsTwoDigits(containsOneDigit, password))
      throw new IllegalArgumentException("The password doesn't contain at least two digits")
    else if (!containsOneDigit(password))
      throw new IllegalArgumentException("The password doesn't contain at least one digit")
    else if (!containsOneLowerCaseLetter(password))
      throw new IllegalArgumentException("The password doesn't contain at least one lower case letter")
    else if (!containsOneUpperCaseLetter(password))
      throw new IllegalArgumentException("The password doesn't contain at least one upper case letter")
  }

  def min(a: String)(b: Int): Boolean = a.length > b

  def max(a: String)(b: Int): Boolean = a.length < b


//  def containsMaximumLength(password: String): Boolean = {
//    if (password.length() < 10) {
//      true
//    } else {
//      false
//    }
//  }
//
//  def containsMinimumLength(password: String): Boolean = {
//    if (password.length() > 1) {
//      true
//    } else {
//      false
//    }
//  }

  def containsTwoDigits(function: (String) => Boolean, password: String): Boolean = {
    var i = 0
    var counter = 0
    for (c <- password) {
      if (containsOneDigit(password.substring(i))) {
        counter += 1
        if (counter == 2)
          return true
      }
      i += 1
    }
    false
  }

  def containsOneDigit(password: String): Boolean = {
    for (c <- password) {
      if (c.isDigit) {
        return true
      }
    }
    false
  }

  def containsOneLowerCaseLetter(password: String): Boolean = {
    for (c <- password) {
      if (c.isLower) {
        return true
      }
    }
    false
  }

  def containsOneUpperCaseLetter(password: String): Boolean = {
    for (c <- password) {
      if (c.isUpper) {
        return true
      }
    }
    false
  }
}
