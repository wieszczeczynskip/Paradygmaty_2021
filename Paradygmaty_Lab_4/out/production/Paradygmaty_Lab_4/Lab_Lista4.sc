{
  sealed trait tree3[+A]
  case object Empty extends tree3[Nothing]
  case class Node[+A](v: A, t1: tree3[A], t2: tree3[A], t3: tree3[A]) extends tree3[A]
}

