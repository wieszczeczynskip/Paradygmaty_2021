// Paweł Wieszczeczyński

// zadanie2
def fib(n: Int): Int =
  if n < 0 then throw new Exception(s"ujemny argument: $n")
  else if n == 0 then 0
  else if n == 1 then 1
  else (fib(n-1) + fib(n-2))

fib(0) == 0
fib(6) == 8
fib(7) == 13
fib(-3)
//fib(42) == 267914296

def fibTail(n: Int) = {
  if n < 0 then throw new Exception(s"ujemny argument: $n")
  def fibIter(n: Int, accum: Int, last: Int): Int =
    if n == 0 then last
    else if n == 1 then accum
    else fibIter(n-1, accum+last, accum)
  fibIter(n,1,0)
}

fibTail(0) == 0
fibTail(6) == 8
fibTail(7) == 13
fibTail(-3)
fibTail(42) == 267914296

//Obliczanie n-tej liczby ciągu Fibonacciego za pomocą funkcji
//fibTail wykorzystującej rekursję ogonową jest dużo szybsze.
//Dla n = 42, fibTail obliczyła 42 liczbę ciągu praktycznie
//natychmiast, natomiast w przypadku użycia zwykłej rekurencji
//(funkcja fib), program wykonywał się zauważalnie dłużej
//(kilka sekund). Definitywnie funkcja fibTail
//jest znacząco szybsza niż funkcja fib.

// zadanie3

def root3met(a: Double): Double = {
  def root3Iter(a: Double, x: Double): Double =
    if Math.abs((x*x*x)-a) > (Math.pow(10, -15)*Math.abs(a)) then root3Iter(a, (x+(((a/(x*x))-x)/3)))
    else x
  if a > 1 then root3Iter(a, (a/3))
  else root3Iter(a, a)
}

val root3fun = (a: Double) => root3met(a)

root3met(8) == 2.0
root3met(-8) == -2.0
root3met(0) == 0.0
val root3met_16 = root3met(16)
(root3met_16 > 2.51 && root3met_16 < 2.52) == true

root3fun(8) == 2.0
root3fun(-8) == -2.0
root3fun(0) == 0.0
val root3fun_16 = root3fun(16)
(root3fun_16 > 2.51 && root3fun_16 < 2.52) == true



// zadanie4

def pm1[A](y: List[A]): A =
  val List(_, _, x, _, _) = y
  x

def pm2[A](y: List[(A, A)]): A =
  val List((_, _), (x, _)) = y
  x

pm1(List(1, 2, 3, 4, 5)) == 3
pm2(List((1, 2), (3, 4))) == 3

// zadanie5

def initSegment[A](xs: (List[A], List[A])): Boolean =
  xs match {
    case(Nil, _) => true
    case(_, Nil) => false
    case(x, y) => if (x.head == y.head) then initSegment(x.tail, y.tail) else false
  }

initSegment(List(1, 2, 3), List(1, 2, 3, 4, 5)) == true
initSegment(List(), List(1, 2, 3, 4, 5)) == true
initSegment(List(1, 2), List(2, 3, 4, 5)) == false
initSegment(List(1, 2, 3), List(1, 2, 3)) == true
initSegment(List(1, 2), List()) == false

// zadanie6

def replaceNth[A](xs: List[A], n: Int, x: A): List[A] =
  (xs, n) match {
    case(Nil, _) => Nil
    case(_, 0) => x::xs.tail
    case(xs, n) => if n < 0 then xs else xs.head::replaceNth(xs.tail, n-1, x)
  }

replaceNth(List(1, 2, 3, 4, 5), 2, 999) == List(1, 2, 999, 4, 5)
replaceNth(List(), 2, 999) == List()
replaceNth(List(1, 2, 3, 4, 5), 5, 999) == List(1, 2, 3, 4, 5)
replaceNth(List(1, 2, 3, 4, 5), -2, 999) == List(1, 2, 3, 4, 5)
replaceNth(List(1, 2, 3, 4, 5), 4, 999) == List(1, 2, 3, 4, 999)