class EmptyName extends Exception
class EmptySurname extends Exception
class TooYoung extends Exception

trait Painter
trait Electrician
trait Tiler

class Handyman (nameS: String, surnameS: String, ageI: Int) {
  if nameS == "" then throw EmptyName()
  if surnameS == "" then throw EmptySurname()
  if ageI < 18 then throw TooYoung()

  val name = nameS
  val surname = surnameS
  val age = ageI

  def getName(): String = name
  def getSurname(): String = surname
  def getAge(): Int = age

  override def toString: String = name + surname + age
}

class Office () {
  var list: List[Handyman] = List()

  def register(h: Handyman): Unit = {
    list = h :: list
  }

  def listPainter(): List[Handyman] = {
    def listPainterHelp(handymanList: List[Handyman], result: List[Handyman]): List[Handyman] = {
      if handymanList == List() then result
      else if handymanList.head.isInstanceOf[Painter] then listPainterHelp(handymanList.tail, handymanList.head :: result)
      else listPainterHelp(handymanList.tail, result)
    }
    listPainterHelp(list, List())
  }

  def listElectrician(): List[Handyman] = {
    def listElectricianHelp(handymanList: List[Handyman], result: List[Handyman]): List[Handyman] = {
      if handymanList == List() then result
      else if handymanList.head.isInstanceOf[Electrician] then listElectricianHelp(handymanList.tail, handymanList.head :: result)
      else listElectricianHelp(handymanList.tail, result)
    }
    listElectricianHelp(list, List())
  }

  def listTiler(): List[Handyman] = {
    def listTilerHelp(handymanList: List[Handyman], result: List[Handyman]): List[Handyman] = {
      if handymanList == List() then result
      else if handymanList.head.isInstanceOf[Tiler] then listTilerHelp(handymanList.tail, handymanList.head :: result)
      else listTilerHelp(handymanList.tail, result)
    }
    listTilerHelp(list, List())
  }
}


val h1 = new Handyman("Kamil", "Nowak", 20) with Painter
val o1 = new Office
val h2 = new Handyman("Jan", "Kowalski", 21) with Electrician
val h3 = new Handyman("Patryk", "Nowak", 22) with Electrician with Painter
o1.register(h1)
o1.register(h2)
o1.register(h3)
o1.listPainter()
o1.listElectrician()
o1.listTiler()
