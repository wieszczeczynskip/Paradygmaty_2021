(*Pawe³ Wieszczeczyñski*)

(*zadanie*)

let rec fib n =
  if n < 0 then raise (Failure "ujemny argument") else
    if n = 0 then 0 else
      if n = 1 then 1 else
        (fib(n-1) + fib(n-2));;

fib(0) = 0;;
fib(6) = 8;;
fib(7) = 13;;
fib(-3);;
(*fib(42);;*)

let fibTail n =
  let rec fibIter (n, accum, last) =
    if n < 0 then raise (Failure "ujemny argument") else
      if n = 0 then last else
        if n = 1 then accum else
          fibIter((n-1), (accum+last), accum)
in fibIter(n, 1, 0);;

fibTail(0) = 0;;
fibTail(6) = 8;;
fibTail(7) = 13;;
fibTail(-3);;
fibTail(42) = 267914296;;

(*Sytuacja wygl±da tak samo jak w Scali. Zwyk³a rekurencja wykonuje siê du¿o d³u¿ej ni¿ rekursja ogonowa.*)

(*zadanie3*)

let root3 a =
  let rec root3Iter (a, x) =
    if abs_float((x*.x*.x)-.a) > ((10. ** -15.)*.(abs_float(a))) then root3Iter(a, (x+.(((a/.(x*.x))-.x)/.3.))) else
      x
  in if a > 1 then root3Iter(float_of_int(a), (float_of_int(a)/.3.)) else root3Iter(float_of_int(a), float_of_int(a));;

root3(8) = 2.0;;
root3(-8) = -2.0;;
root3(0) = 0.0;;
let root3_16 = root3(16);;
root3_16 > 2.51 && root3_16 < 2.52;;

(*zadanie4*)

let pm1 y =
  let [_; _; x; _; _] = y in x;;

let pm2 y =
  let [(_, _); (x, _)] = y in x;;

pm1([1; 2; 3; 4; 5]) = 3;;
pm2([(1, 2); (3, 4)]) = 3;;

(*zadanie5*)

let rec initSegment (xs, ys) =
  match (xs, ys) with
    ([], _) -> true
  | (_, []) -> false
  | _ -> if (List.hd(xs) = List.hd(ys)) then initSegment(List.tl(xs), List.tl(ys)) else false;;

initSegment([1; 2; 3], [1; 2; 3; 4; 5]) = true;;
initSegment([], [1; 2; 3; 4; 5]) = true;;
initSegment([1; 2], [2; 3; 4; 5]) = false;;
initSegment([1; 2; 3], [1; 2; 3]) = true;;
initSegment([1; 2], []) = false;;

(*zadanie6*)

let rec replaceNth (xs, n, x) =
  match (xs, n) with
    ([], _) -> []
  | (hd::tl, 0) -> x::tl
  | (hd::tl, n) -> if n < 0 then xs else hd::replaceNth(tl, (n-1), x);;

replaceNth([1; 2; 3; 4; 5], 2, 999) = [1; 2; 999; 4; 5];;
replaceNth([], 2, 999) = [];;
replaceNth([1; 2; 3; 4; 5], 5, 999) = [1; 2; 3; 4; 5];;
replaceNth([1; 2; 3; 4; 5], -2, 999) = [1; 2; 3; 4; 5];;
replaceNth([1; 2; 3; 4; 5], 4, 999) = [1; 2; 3; 4; 999];;
