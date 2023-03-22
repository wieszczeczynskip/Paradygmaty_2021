(*Pawe³ Wieszczeczyñski*)

(*zadanie1*)

type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;
(*type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;*)

let lhd = function
    LNil -> failwith "lhd"
  | LCons (x, _) -> x;;

let ltl = function
    LNil -> failwith "ltl"
  | LCons (_, lazy t) -> t;;

let rec lfrom k = LCons (k, lazy(lfrom (k+1)));;

let rec ltake (n, lxs) =
  match (n, lxs) with
    (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x, lazy xs)) -> x::ltake(n-1, xs);;

ltake(20, lfrom 5);;

let lrepeat k lxs =
  if k <= 0 then LNil else
    let rec lrepeatIte(k, lxs, help) =
      match (help, lxs) with
        (_, LNil) -> LNil
      | (0, LCons(x, lazy xs)) -> lrepeatIte(k, xs, k)
      | (_, LCons(x, lazy xs)) -> LCons(x, lazy(lrepeatIte(k, lxs, (help-1))))
         in lrepeatIte(k, lxs, k);;

let lazylist = LCons('a', lazy(LCons('b', lazy(LCons('c', lazy(LCons('d',lazy LNil)))))));;

ltake(12, lrepeat(3)(lazylist)) = ['a'; 'a'; 'a'; 'b'; 'b'; 'b'; 'c'; 'c'; 'c'; 'd'; 'd'; 'd'];;
ltake(15, lrepeat(3)(lfrom 1)) = [1; 1; 1; 2; 2; 2; 3; 3; 3; 4; 4; 4; 5; 5; 5];;
ltake(15, lrepeat(3)(LNil)) = [];;

(*zadanie2*)

let fib =
  let rec fibIte a b =
    LCons(a, lazy(fibIte b (a+b)))
  in fibIte 1 1;;

ltake(15, fib);;

(*zadanie3*)

type 'a lBT = LEmpty | LNode of 'a * (unit ->'a lBT) * (unit -> 'a lBT);;

let lBreadth lbt =
  let rec breadthLBTIte queue =
    if queue = [] then LNil else
      match List.hd(queue) with
        LEmpty -> LNil
      | LNode(v, l, r) -> LCons(v, lazy (breadthLBTIte (List.tl(queue) @ [l(); r()])))
  in breadthLBTIte [lbt];;

let lbtree = LNode(1, (function () -> LNode(3, (function () -> LEmpty), (function () -> LEmpty))), (function () -> LNode(2, (function () -> LEmpty), (function () -> LEmpty))));;

ltake(20, (lBreadth lbtree));;
ltake(20, (lBreadth LEmpty)) = [];;

let rec lTree n =
  LNode(n, (function () -> lTree(2 * n)), (function () -> lTree(2 * n + 1)));;

ltake(10, (lBreadth(lTree 5))) = [5; 10; 11; 20; 21; 22; 23; 40; 41; 42];;
lTree 5;;
lBreadth(lTree 5);;
ltake(20, (lBreadth(lTree 1))) = [1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12; 13; 14; 15; 16; 17; 18; 19; 20];;
