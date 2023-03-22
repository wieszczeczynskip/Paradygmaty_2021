// zadanie1

def mirror4[A, B, C, D](k4: (A, B, C, D)): (B, A, D, C) =
  (k4._2, k4._1, k4._4, k4._3)

mirror4((1,2,3,4))
mirror4((1.2,3,"Ala",true))
mirror4((1,1,1,1))

// zadanie2

def substitute[A](xs: List[A], a: A, b: A): List[A] =
  if xs == Nil then List()
  else if xs.head == a then (b::substitute(xs.tail, a, b))
  else (xs.head::substitute(xs.tail, a, b))

substitute(List(1,2,3,4,5,6,7,8,4,4,9), 4, 20000)
substitute(List(1,2,3,4,5,6,7,8,4,4,9), 10, 20000)
substitute(List("Ala", "Ela", "Ula", "Ala", "Ula"), "Ala", "XXX")
substitute(List(), 1, 5050)

// zadanie3

def remove[A](xs: List[A], x: Int): List[A] =
  if xs == List() then List()
  else if x == 0 then xs.tail
  else (xs.head::remove(xs.tail, x-1))

remove(List(1,2,3,4,5,6,7), 3)
remove(List(1,2,3), 2)
remove(List(1,2,3), 0)
remove(List(1,2,3), 7)
remove(List(), 0)
remove(List(1,2,3), -5)