(*Pawe³ Wieszczeczyñski*)

(*zadanie2*)
let curry3_1 f(x)(y)(z) = f(x,y,z);;

let curry3_2 = function f -> function x -> function y -> function z -> f(x,y,z);;

let plusToCurry (x,y,z) = x+y+z;;

let plusCurried_1 = curry3_1(plusToCurry);;

let plusCurried_2 = curry3_2(plusToCurry);;

plusToCurry(1,2,3) == 6;;
plusCurried_1(1)(2)(3) == 6;;
plusCurried_2(1)(2)(3) == 6;;

let uncurry3_1 f(x,y,z) = f(x)(y)(z);;

let uncurry3_2 = function f -> function (x,y,z) -> f(x)(y)(z);;

let plusToUncurry(x)(y)(z) = x+y+z;;

let plusUncurried_1 = uncurry3_1(plusToUncurry);;

let plusUncurried_2 = uncurry3_2(plusToUncurry);;

plusToUncurry(1)(2)(3) == 6;;
plusUncurried_1(1,2,3) == 6;;
plusUncurried_2(1,2,3) == 6;;

(*zadanie3*)

let addmul (s, p) x = ((s+x), (p*x));;

let sumProd xs =
  match xs with
    (h::t) -> List.fold_left(addmul) (0,1) xs
  | [] -> (0,1);;

sumProd([1;2;3;4]) = (10,24);;
sumProd([]) = (0,1);;
