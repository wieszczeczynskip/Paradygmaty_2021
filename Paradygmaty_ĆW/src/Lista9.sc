class Time(private var h: Int):
  if h<0 then h = 0
  if h>=24 then h = h%24
  def hour: Int = h
  def hour_=(newHour: Int): Unit =
    if newHour<0 then h = 0
    if newHour>=24 then h = newHour%24
    h = newHour
end Time

val t1 = new Time(24)
t1.hour
t1.hour = 25
t1.hour
t1.hour = 5
t1.hour
val t2 = new Time(-5)
t2.hour
t2.hour = -4
t2.hour