// Paweł Wieszczeczyński

// zadanie 1
def flatten1[A](xss: List[List[A]]): List[A] =
  if xss == Nil then return Nil
  else return xss.head ::: flatten1(xss.tail)

flatten1(List(List(5,6), List(1,2,3))) == List(5,6,1,2,3)
flatten1(List(List("Ala","ma","kota"))) == List("Ala","ma","kota")
flatten1(Nil) == List()
flatten1(List(List(1,2,3))) == List(1,2,3)

// zadanie2
def count[A](x: A, xs: List[A]): Int =
  if xs == Nil then return 0
  else if xs.head == x then return(1+count(x, xs.tail))
  else return count(x, xs.tail)

count(5, List(1,2,3,5,6,4,5,7,5)) == 3
count(5, List()) == 0
count("Ala", List("A","Al","Ala","Alaa","Ala","Alaaa","Ala")) == 3
count("Ala", List(1,2,3,4,5,6)) == 0

// zadanie3
def replicate[A](x: A, n: Int): List[A] =
  if n == 0 then return Nil
  else return List(x) ++ replicate(x, n-1)

replicate(5, 5) == List(5,5,5,5,5)
replicate(1, 1) == List(1)
replicate("Ala", 3) == List("Ala","Ala","Ala")
replicate(0, 0) == List()

// zadanie4
def sqrList(xs: List[Int]): List[Int] =
  if xs == Nil then return Nil
  else return List(xs.head * xs.head) ++ sqrList(xs.tail)

val sqrListFun = sqrList _

sqrListFun(List(1,2,3,4)) == List(1,4,9,16)
sqrList(List(1,2,3,4)) == List(1,4,9,16)
sqrList(List(0,5,-3)) == List(0,25,9)
sqrList(List()) == List()
sqrList(Nil) == List()

// zadanie5
def palindrome[A](xs: List[A]): Boolean =
  if xs == Nil then return true
  else if xs.tail == Nil then return true
  else if xs.head != xs.tail.reverse.head then return false
  else return palindrome(xs.tail.reverse.tail)

palindrome(List("k","a","j","a","k")) == true
palindrome(List("k","a","j","a","g")) == false
palindrome(List("k","a","j","e","k")) == false
palindrome(List("k","a","j","q","a","k")) == false

// zadanie6
def listLength[A](xs: List[A]): Int =
  if xs == Nil then return 0
  else if xs.tail == Nil then return 1
  else return(1+listLength(xs.tail))

listLength(List(1,2,3,4,5)) == 5
listLength(List()) == 0
listLength(List(1)) == 1
listLength(List("Ala","ma","kota")) == 3