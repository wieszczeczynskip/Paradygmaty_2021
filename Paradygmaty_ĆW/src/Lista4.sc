// Paweł Wieszczeczyński

// zadanie3

sealed trait BT[A]
case class Empty[A]() extends BT[A]
case class Node[A](elem: A, left: BT[A], right: BT[A]) extends BT[A]

val t = Node(1, Node(2, Empty(), Node(3, Empty(), Empty())), Empty())
val tt = Node(1, Node(2, Node(4, Empty(), Empty()), Empty()),Node(3, Node(5, Empty(), Node(6, Empty(), Empty())), Empty()))
val ttt = Node(1, Node(3, Empty(), Empty()), Node(2, Empty(), Empty()))
val empty = Empty()


def breadthBT[A](tree: BT[A]): List[A] =
  def breadthBTIte(queue: List[BT[A]], result: List[A]): List[A] =
    queue match {
      case List() => result
      case Empty()::_ => breadthBTIte(queue.tail, result)
      case Node(v, l, r)::_ => breadthBTIte((queue.tail:::List(l, r)), (v::result))
    }
  breadthBTIte(List(tree), List()).reverse

breadthBT(t) == List(1,2,3)
breadthBT(tt) == List(1,2,3,4,5,6)
breadthBT(ttt) == List(1,3,2)
breadthBT(empty) == List()


// zadanie4

def internalPath[A](tree: BT[A]): Int =
  def internalIte(tree: BT[A], result: Int, lvl: Int): Int =
    tree match {
      case Empty() => result
      case Node(v, l, r) => internalIte(l, internalIte(r, (result + lvl), (lvl + 1)), (lvl + 1))
    }
  internalIte(tree, 0, 0)

internalPath(t) == 3
internalPath(tt) == 9
internalPath(ttt) == 2
internalPath(empty) == 0

def externalPath[A](tree: BT[A]): Int =
  def externalIte(tree: BT[A], result: Int, lvl: Int): Int =
    tree match {
      case Empty() => (result + lvl)
      case Node(v, l, r) => externalIte(l, externalIte(r, result, (lvl + 1)), (lvl + 1))
    }
  externalIte(tree, 0, 0)

externalPath(t) == 9
externalPath(tt) == 21
externalPath(ttt) == 8
externalPath(empty) == 0

// zadanie5

def depthSearch[A](tree: BT[A]): List[A] =
  tree match {
    case Node(v, l, r) => v::depthSearch(l):::depthSearch(r)
    case Empty() => List()
  }

depthSearch(t) == List(1,2,3)
depthSearch(tt) == List(1,2,4,3,5,6)
depthSearch(ttt) == List(1,3,2)
depthSearch(empty) == List()