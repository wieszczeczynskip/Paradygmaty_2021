(*Pawe³ Wieszczeczyñski*)

(*zadanie2*)

let rec f x = f x;;

(*zadanie3*)

type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let t = Node(1, Node(2, Empty, Node(3, Empty, Empty)), Empty);;
let tt = Node(1,Node(2,Node(4,Empty,Empty),Empty),Node(3,Node(5,Empty,Node(6,Empty,Empty)),Empty));;
let ttt = Node(1, Node(3, Empty, Empty), Node(2, Empty, Empty));;
let empty = Empty;;

let breadthBT tree =
  let rec breadthBTIte queue result =
            if queue = [] then result else
              match List.hd(queue) with
                Empty -> breadthBTIte (List.tl(queue)) result
              | Node(v, l, r) -> breadthBTIte (List.tl(queue) @ [l; r]) (v::result)
in List.rev (breadthBTIte [tree] []);;

breadthBT t = [1;2;3];;
breadthBT tt = [1;2;3;4;5;6];;
breadthBT ttt = [1;3;2];;
breadthBT empty = [];;

(*zadanie4*)

let internalPath tree =
  let rec internalIte (tree, result, lvl) =
    match tree with
      Empty -> result
    | Node(v, l, r) -> internalIte(l, internalIte(r, (result + lvl), (lvl + 1)), (lvl + 1))
  in internalIte(tree, 0, 0);;

internalPath t = 3;;
internalPath tt = 9;;
internalPath ttt = 2;;
internalPath empty = 0;;

let externalPath tree =
  let rec externalIte (tree, result, lvl) =
    match tree with
      Empty -> (result + lvl)
    | Node(v, l, r) -> externalIte(l, externalIte(r, result, (lvl + 1)), (lvl + 1))
  in externalIte(tree, 0, 0);;

externalPath t = 9;;
externalPath tt = 21;;
externalPath ttt = 8;;
externalPath empty = 0;;

(*zadanie5*)

let rec depthSearch tree =
  match tree with
    Empty -> []
  | Node(v, l, r) -> v::(depthSearch l)@(depthSearch r);;

depthSearch t = [1;2;3];;
depthSearch tt = [1;2;4;3;5;6];;
depthSearch ttt = [1;3;2];;
depthSearch empty = [];;
