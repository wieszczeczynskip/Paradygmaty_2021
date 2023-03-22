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

def split3Rec[A](xs: List[A]): (List[A], List[A], List[A]) =
  def help[A](xs: List[A], f: Int, x1: List[A], x2: List[A], x3: List[A]): (List[A], List[A], List[A]) =
    (xs, f) match {
      case(Nil, _) => (x1, x2, x3)
      case(h::t, 1) => help(t, 2, (x1::h), x2, x3)
      case(h::t, 2) => help(t, 3, x1, x2::h, x3)
      case(h::t, 3) => help(t, 1, x1, x2, x3::h)
    }