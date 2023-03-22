sealed trait tree3[+A]
case object Empty extends tree3[Nothing]
case class Node[+A](v: A, t31: tree3[A], t32: tree3[A], t33: tree3[A]) extends tree3[A]

def map[A, B](f: A => B)(tree3: tree3[A]): tree3[B] =
  tree3 match
    case Empty => Empty
    case Node(v, t31, t32, t33) => Node(f(v), map(f)(t31), map(f)(t32), map(f)(t33))

val t3 = Node(1, Node(2, Empty, Empty, Empty), Node(3, Empty, Empty, Empty), Node(4, Empty, Empty, Empty))
val empty = Empty

def f(x: Int): Int = x*x

val mapt3 = map(f)(t3)
val mapempty = map(f)(empty)



case class Plik(nazwa: String)
case class Katalog(nazwa: String, katalogi: List[Katalog], pliki: List[Plik])
case class Dysk(nazwa: String, katalogi: List[Katalog])

val plik1 = Plik("zdjecie")
val plik2 = Plik("angielski")
val plik3 = Plik("matma")
val plik4 = Plik("fizyka")
val plik5 = Plik("podanie")

val katalog1 = Katalog("szkola", List(), List(plik2, plik3, plik4))
val katalog2 = Katalog("moje", List(katalog1), List(plik1))
val katalog3 = Katalog("dokumenty", List(), List(plik5))

val dysk = Dysk("C", List(katalog2, katalog3))