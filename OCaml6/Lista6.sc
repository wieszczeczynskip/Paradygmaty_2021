// Paweł Wieszczeczyński

// zadanie2

def swap(tab: Array[Int], a: Int, b: Int ): Unit = {
  val aux = tab(a)
  tab(a) = tab(b)
  tab(b) = aux
}

def choose_pivot(tab: Array[Int], m: Int, n: Int): Int = tab((m + n) / 2)

def partition(tab: Array[Int], l: Int, r: Int): (Int, Int) = {
  var i = l
  var j = r
  val pivot = choose_pivot(tab, l, r)
  while (i <= j) {
    while (tab(i) < pivot) {i += 1}
    while (pivot < tab(j)) {j -= 1}
    if (i <= j) {
      swap(tab, i, j)
      i += 1
      j -= 1
    }
  }
  (i, j)
}

def quick(tab: Array[Int], l: Int, r:Int): Unit = {
  if (l < r) then
    val (i, j) = partition(tab, l, r)
    if (j - l < r - i) then
      val _ = quick(tab, l, j)
      quick(tab, i, r)
    else
      val _ = quick(tab, i, r)
      quick(tab, l, j)
}

def quickSort(tab: Array[Int]) = quick(tab, 0, tab.length - 1)

val tab = Array(2, 4, 1, 3, 5)
quickSort(tab)
tab

val tab2 = Array(21, 4, 56, 36, 50, 67, 35, 62, 53, 15, 58, 75, 9, 37, 46)
quickSort(tab2)
tab2

val tab3 = new Array[Int](0)
quickSort(tab3)
tab3

val tab4 = new Array[Int](5)
quickSort(tab4)
tab4