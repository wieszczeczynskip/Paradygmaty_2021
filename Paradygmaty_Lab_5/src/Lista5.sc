def skipTakeL[A](xs: LazyList[A]): LazyList[A] =
  def help(xs: LazyList[A], skipBy: Int, skipCount: Int): LazyList[A] =
    (xs, skipCount) match {
      case (LazyList(), _) => LazyList()
      case (x #:: xf, 0) => x #:: help(xf, (skipBy + 1), (skipBy + 1))
      case (x #:: xf, _) => help(xf, skipBy, (skipCount - 1))
    }
  help(xs, 0, 0)

skipTakeL(LazyList(1, 2, 3, 4, 5, 6, 7, 8, 9)).force
skipTakeL(LazyList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p')).toList
skipTakeL(LazyList.from(1)).take(15).toList
skipTakeL(LazyList()).toList