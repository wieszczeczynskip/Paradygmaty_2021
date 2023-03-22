(*Pawe³ Wieszczeczyñski*)

(*zadanie1*)

let rec flatten1 xss =
  if xss == [] then [] else List.hd(xss)@(flatten1(List.tl(xss)));;

flatten1([[5; 6]; [1; 2; 3]]) = [5; 6; 1; 2; 3];;
flatten1([["Ala"; "ma"; "kota"]]) = ["Ala"; "ma"; "kota"];;
flatten1([]) = [];;
flatten1([[1; 2; 3]]) = [1; 2; 3];;


(*zadanie2*)

let rec count (x, xs) =
  if xs = [] then 0 else
    if List.hd(xs) = x then (1+count(x, List.tl(xs))) else
      count(x, List.tl(xs));;

count(5, [1;2;3;4;5;6;5]) = 2;;
count(5, []) = 0;;
count("Ala", ["A";"Al";"Ala";"Alaa";"Ala";"Alaaa";"Ala"]) = 3;;

(*zadanie3*)

let rec replicate (x, n) =
  if n = 0 then [] else
    [x]@replicate(x, (n-1));;

replicate(5, 5) = [5;5;5;5;5];;
replicate(1, 1) = [1];;
replicate("Ala", 3) = ["Ala";"Ala";"Ala"];;
replicate(0, 0) = [];;

(*zadanie4*)

let rec sqrList xs =
  if xs = [] then [] else
    [List.hd(xs)*List.hd(xs)]@sqrList(List.tl(xs));;

sqrList([1;2;3;4]) = [1;4;9;16];;
sqrList([0;5;-3]) = [0;25;9];;
sqrList([]) = [];;

(*zadanie5*)

let rec palindrome xs =
  if xs = [] then true else
    if List.tl(xs) = [] then true else
      if List.hd(xs) <> List.hd(List.rev(List.tl(xs))) then false else
        palindrome(List.tl(List.rev(List.tl(xs))));;

palindrome(["k";"a";"j";"a";"k"]) = true;;
palindrome(["k";"a";"j";"a";"g"]) = false;;
palindrome(["k";"a";"j";"e";"k"]) = false;;
palindrome(["k";"a";"j";"q";"a";"k"]) = false;;

(*zadanie6*)

let rec listLength xs =
  if xs = [] then 0 else
    if List.tl(xs) = [] then 1 else
      (1+listLength(List.tl(xs)));;

listLength([1;2;3;4;5]) = 5;;
listLength([]) = 0;;
listLength([1]) = 1;;
listLength(["Ala";"ma";"kota"]) = 3;;
