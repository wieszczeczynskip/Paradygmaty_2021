class Square (val a: Int) {
  require(a>0)

  def area(): Int = a*a

  def getA(): Int = a
}

val s1 = new Square(5)
s1.area()
val s2 = new Square(0)
s2.area()
val s3 = new Square(-5)
s3.area()

class Rectangle (x: Int, y: Int) extends Square(x) {
  require(x>0 && y>0)
  val b = y

  override def area(): Int = super.getA()*b
}

val r1 = new Rectangle(4,5)
r1.area()
val r2 = new Rectangle(0,5)
r2.area()
val r3 = new Rectangle(4,0)
r3.area()
val r4 = new Rectangle(0,0)
r4.area()
