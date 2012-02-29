package jp.sample

object Rational extends Application {

  implicit def intToRational(x: Int) = new Rational(x)
  
  val r = new Rational(1, 2)
  println(r)

  val oneHalf = new Rational(1, 2)
  val twoThirds = new Rational(2, 3)

  println(oneHalf + twoThirds)

  println(oneHalf + 3)
  println(3 + oneHalf)

  new Rational(3)

  new Rational(20, 15)

  new Rational(5, 0)
}

class Rational(n: Int, d: Int) {
  require(d != 0)
  println("Created " + numer + "/" + denom)

  private def g: Int = gcd(n.abs, d.abs)
  def numer: Int = n / g
  def denom: Int = d / g
  def this(n: Int) = this(n, 1)
  def +(that: Rational) =
    new Rational(numer * that.denom + denom * that.numer,
      denom * that.denom)
  def +(i: Int) =
    new Rational(numer + i * denom, denom)

  override def toString = n + "/" + d

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}