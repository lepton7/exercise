package jp.sample

object Step3 {

  def main(args: Array[String]): Unit = {
    val greetStrings = new Array[String](3)
    greetStrings(0) = "Hello"
    greetStrings(1) = ", "
    greetStrings(2) = "world!\n"
    for (i <- 0 to 2)
      print(greetStrings(i))

    for (s <- greetStrings)
      print(s)

    greetStrings.foreach(s => print(s))

    greetStrings.foreach(print(_))

    greetStrings.foreach(print)

    val numNames = Array("zero", "one", "two", "three")

    numNames.map(s => print(s + " "))

    println

    val thrill = "Will" :: "fill" :: "until" :: Nil

    println(thrill.count(_.length == 4))

    thrill.drop(2).foreach(print)
    println

    thrill.dropRight(2).foreach(print)
    println

    println(thrill.exists(_.length == 4))

    thrill.filter(_.length == 4).foreach(print)
    println

    println(thrill.forall(_.endsWith("l")))

    println(thrill.head)

    thrill.init.foreach(print)
    println

    thrill.map(_ + "y").foreach(print)
    println
    
    thrill.map(addSpace).foreach(myPrint)
    
    val romanNumeral = Map(1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV")
    
    romanNumeral.filter(_._1 > 2).foreach(t => println(t._2))
  }

  def addSpace(s:String) = {
    println("addSpace is called")
    s + " "
  }

  def myPrint(s:String) {
    println("myPrint is called!")
  }

}