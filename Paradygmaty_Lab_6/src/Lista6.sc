def rowBuilder(prev: List[Int], len: Int, xs: List[Int], count: Int): List[Int] =
  if (count == len-2) then xs:::List(1,1)
  else rowBuilder(prev.tail, len, xs:::List(prev.head+prev.tail.head+prev.tail.tail.head), count+1)

def pascalTrapezoidF(row: Int): List[Int] =
  def help (row: Int, len: Int, prev: List[Int]): List[Int] =
    if (len+2 == row*2+1) then rowBuilder(prev, len, List(1,1), 0)
    else help(row, len+2, rowBuilder(prev, len, List(1,1), 0))
  if (row == 1) then List(1,1,1) else help(row, 3, List(1,1,1))

def pascalTrapezoidI(row: Int): Array[Int] =
  var rowCount = 2
  var prev = Array(1,1,1)
  var current = Array(1,1,3,1,1)
  if (row == 1) then current = prev
  else while (rowCount < row) do
    prev = current
    var i = 2
    current = new Array[Int]((rowCount+1)*2+1)
    current(0) = 1
    current(1) = 1
    while (i < (prev.length)) do
      current(i) = prev(i-2) + prev(i-1) + prev(i)
      i += 1
    rowCount += 1
    current(current.length-1) = 1
    current(current.length-2) = 1
  current

println("Funkcyjny")
pascalTrapezoidF(1)
pascalTrapezoidF(2)
pascalTrapezoidF(3)
pascalTrapezoidF(4)
pascalTrapezoidF(5)
pascalTrapezoidF(6)
println("Imperialny")
pascalTrapezoidI(1)
pascalTrapezoidI(2)
pascalTrapezoidI(3)
pascalTrapezoidI(4)
pascalTrapezoidI(5)
pascalTrapezoidI(6)

