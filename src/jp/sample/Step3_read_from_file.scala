package jp.sample
import scala.io.Source

object Step3_read_from_file {

  def main(args: Array[String]): Unit = {
    if(args.length > 0) {
      for(line <- Source.fromFile(args(0)).getLines)
        println(line.length + " " + line)
    } else {
      Console.err.println("Please enter filename")
    }

    val lines = Source.fromFile(args(0)).getLines.toList

    val maxWidth = lines.reduceLeft((a, b) => if(a.length > b.length) a else b ).length.toString.length
  }

  def widthOfLength(s: String) = s.length.toString.length

}