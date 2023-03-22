
// Paweł Wieszczeczyński

// zadanie1

def find[A](xs: List[A])(x: A): Boolean =
  xs match {
    case(Nil) => false
    case(h::t) => (h==x || find(t)(x))
  }

find(List(1,2,3))(3)

val find123 = find(List(1, 2, 3))

find123(5)

// zadanie2

def split3Tail[A](xs: List[A]): (List[A], List[A], List[A]) =
  def help[A](xs: List[A], xss: (List[A], List[A], List[A])): (List[A], List[A], List[A]) =
    xs match {
      case(Nil) => xss
      case(h::t) => help(t, (xss._2, xss._3, h::xss._1))
    }
  help(xs, (List(), List(), List()))

split3Tail(List(1, 2, 3, 4, 5, 6))

def split3Rec[A](xs: List[A]): (List[A], List[A], List[A]) =
  def help[A](xs: List[A], xss: (List[A], List[A], List[A])): (List[A], List[A], List[A]) =
    if xs.head == Nil then xss
    else xs.head::xss.head
    if xs.tail.head == Nil then xss
    else xs.tail.head::xss.tail.head
    if xs.tail.tail.head == Nil then xss
    else xs.tail.tail.head::xss.tail.tail.head
    if xs.tail.tail.tail == Nil then xss
    else help(xs.tail.tail.tail, xss)
  help(xs, (List(), List(), List()))

split3Rec(List(1, 2, 3, 4, 5, 6))
