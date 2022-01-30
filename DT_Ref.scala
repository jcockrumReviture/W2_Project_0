
import java.time._
object DT_Temp extends App {
    //Get current Date
    val cDate = LocalDate.now
    // Get Current Time
    val cTime = LocalTime.now
    // Get Current Date and Time
    val cDateTime = LocalDateTime.now
    // Get Current UTC Date and time
    val cUTCTime = Instant.now
    // Get Date Time with Time Zone information
    val cDateTimeWithZone = ZonedDateTime.now  

    var a = 0
    for( a <- 1 to 7){ 
        var tmpvar = DayOfWeek.of(a)
        println( "Value of "+ a + " & " + tmpvar )
    }

// Split the Date into Year, Month and Day
    val cMonth = cDate.getMonthValue()
    val cYear = cDate.getYear()
    val cDay = cDate.getDayOfMonth()

    // Split the Time into Hour, Min, Sec
    val cHour = cTime.getHour()
    val cMin = cTime.getMinute()
    val cSec = cTime.getSecond()

    println("Convert String to Date")
    val strDate = "2021-05-13"
    println(s"from $strDate")
     println("Data Type" + strDate.getClass)
     println
    val dt = LocalDate.parse(strDate)
    println(s"to $dt")
     println("Data Type" + dt.getClass)


    
// compare with Period.between :: Y to Y or D to D
    val dt1 = LocalDate.parse("2021-05-13")
    val dt2 = LocalDate.parse("2020-04-01")
    val diff = Period.between(dt1, dt2)
    diff.getYears
    diff.getMonths
    diff.getDays
    // 2020 - 2021 = -1
    // 04 - 05 = -1
    // 01 - 13 = -12
    println("=-=-=-=-=-=-=-=-=-=-")
    val TSRange = List("Weekly", "BiWeekly", "BiMonthly","Monthly")
    for ((elem, count) <- TSRange.zipWithIndex) {print(s"${count+1} -> $elem  ")}

/*
// Convert Date to BASIC_ISO_DATE
    val f = DateTimeFormatter.BASIC_ISO_DATE
    f.format(LocalDate.now) // 20210513
    val g = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    g.format(LocalDate.now)
    val h = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    h.format(LocalDate.now)
*/
}
