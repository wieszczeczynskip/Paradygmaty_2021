// Paweł Wieszczeczyński

// zadanie1

def nComp[A](f: A => A, n: Int)(x: A): List[A] =
  if (n == 0) then List()
  else {
    def nCompIte(f: A => A, last: A, n: Int)(x: A): List[A] =
      if (n == 2) List(f(last))
      else f(last)::nCompIte(f, f(last), (n - 1))(x)
    x::nCompIte(f, x, n)(x)
  }

val cosinus = (x: Double) => Math.cos(x)
val f1 = nComp(cosinus, 10)

val timesTwo = (x: Int) => 2 * x
val f2 = nComp(timesTwo, 10)

val f3 = nComp(timesTwo, 0)

f1(3)
f2(2)
f3(5)

// zadanie2

def area(a: Double, b: Double, f: Double => Double, n: Double): Double =
  val split = (b - a) / n
  def areaSplits(a: Double, f: Double => Double, x: Double, split: Double): List[Double] =
    if (x == n) then List(f(a + (x * split)))
    else f(a + (x * split))::areaSplits(a, f, (x + 1), split)
  (areaSplits(a, f, 1, split) foldLeft 0.0)((sum, y) => sum + y) * split

val twice = (x: Double) => 2.0 * x

val pi = Math.PI

area (1.0, 5.0, twice, 40000.0)
area (1.0, 5.0, twice, 4000.0)
area (1.0, 5.0, twice, 4.0)
"Poprawny wynik: 24"
area (0.0, 5.0, twice, 5.0)
area (0.0, 5.0, twice, 5000.0)
area (0.0, 5.0, twice, 1.0)
"Poprawny wynik: 25"
area (0.0, 2*pi, cosinus, 2.0)
area (0.0, 2*pi, cosinus, 1.0)
area (0.0, 2*pi, cosinus, 2000.0)
"Poprawny wynik: 0"