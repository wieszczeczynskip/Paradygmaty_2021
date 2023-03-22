//Paweł Wieszczeczyński

// zadanie2
def curry3[A,B,C,D](f: (A,B,C) => D) =
  (x:A) => (y:B) => (z:C) => f(x,y,z)

def plusToCurry(x: Int, y: Int, z: Int): Int = x+y+z

def plusCurried = curry3(plusToCurry(_,_,_))

plusToCurry(1,2,3) == 6
plusCurried(1)(2)(3) == 6

def uncurry3[A,B,C,D](f: A => B => C => D) =
  (x:A, y:B, z:C) => f(x)(y)(z)

def plusToUncurry(x: Int)(y: Int)(z: Int): Int = x+y+z

def plusUncurried = uncurry3(plusToUncurry(_))

plusToUncurry(1)(2)(3) == 6
plusUncurried(1,2,3) == 6

// zadanie3

def sumProd(xs: List[Int]): (Int, Int) =
  xs match
    case h::t => (xs foldLeft(0,1))((acc, x) => (acc._1 + x, acc._2 * x))
    case Nil => (0,1)

sumProd(List(1,2,3,4)) == (10,24)
sumProd(Nil) == (0,1)
