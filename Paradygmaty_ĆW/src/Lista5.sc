// zadanie1

def lrepeat[A](k: Int)(lxs: LazyList[A]): LazyList[A] =
  if k <= 0 then LazyList() else
    def lrepeatIte(k: Int, lxs: LazyList[A], help: Int): LazyList[A] =
      (help, lxs) match {
        case (_, LazyList()) => LazyList()
        case (0, LazyList.cons(x, xf)) => lrepeatIte(k, xf, k)
        case (_, LazyList.cons(x, xf)) => (x #:: lrepeatIte(k, lxs, (help - 1)))
    }
    lrepeatIte(k, lxs, k)

lrepeat(3)(LazyList('a','b','c','d')).toList == List('a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'd', 'd', 'd')
lrepeat(3)(LazyList.from(1)).take(15).toList == List(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5)
lrepeat(3)(LazyList()).take(15).toList == List()

// zadanie2

def fib: LazyList[Int] =
  def fibIte(a: Int, b: Int): LazyList[Int] =
    a #:: fibIte(b, (a+b))
  fibIte(1,1)

fib.take(15).toList

// zadanie3

sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem: A, left: () => lBT[A], right: () => lBT[A]) extends lBT[A]

def lBreadth[A](ltree: lBT[A]): LazyList[A] =
  def breadthLBTIte(queue: List[lBT[A]]): LazyList[A] =
    if queue == List() then LazyList()
    else queue.head match {
      case LEmpty => LazyList()
      case LNode(v, l, r) => v#::breadthLBTIte(queue.tail:::List(l(), r()))
    }
  breadthLBTIte(List(ltree))

val lbtree = LNode(1, () => LNode(3, () => LEmpty, () => LEmpty), () => LNode(2, () => LEmpty, () => LEmpty))

lBreadth(lbtree).take(20).toList

def lTree(n: Int): lBT[Int] =
  LNode(n, () => lTree(2*n), () => lTree(2*n+1))

lBreadth(lTree(1)).take(20).toList == List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
lBreadth(LEmpty).take(20).toList == List()