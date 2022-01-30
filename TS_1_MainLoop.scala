
// TODO Resolve "java.sql.SQLException: No suitable driver found for jdbc:mysql"
import java.sql.{Connection, DriverManager}
import scala.io.StdIn._
import java.time._
object  tsMainLoop extends App{
    var exLoop  : Boolean = true;
    val passDate  = LocalDate.now
    println
    println(s"Today is $passDate")
    do {
        println
        println
        //Print the Menu
            println("1 Punch or Out")
            println("2 Punch By Date")
            println("3 Print Timsheet")
            println("4 Edit Paramaters")
            println("5 Exit ")
            val  i = readLine("Please Choose: ")
        //proc the i

        i match {
            case "1"  => println(s"TS2+ $passDate")//TS_2_Punch( passDate )
            case "2"  => {
                println("    1 Correct Current Timesheet")
                println("    2 Enter a Date")
                val j = readLine("  Please Choose: ")
                j match {
                    case "1"  => println(s"TS3 + $passDate")//TS_3_Hours( passDate )
                    case "2"  => {
                    val newDate = readLine("Enter Date Please yyyy/mm/dd: ")
                    //TODO val passDate = LocalDate.parse(newDate)
                    println(s"TS3 + $newDate")//TS_3_Hours( passDate )
                    }
                }
            }   
            case "3"  => {
                println("    1 Print Current Timesheet")
                println("    2 Enter a Date")
                println("    3 See all Timesheets")
                val j = readLine("  Please Choose: ")
                j match {
                    case "1"  => println("TS4")//TS_4_TSP( passDate )
                    case "2"  => {
                    val newDate = readLine("Enter Date Please yyyy/mm/dd: ")
                    // TODO val passDate =LocalDate.parse(newDate)
                    println(s"TS4 + $newDate")//TS_4_TSP( passDate )
                    }
                    case "3"  => println("TS4")//TS_4_TSP()
                }
            }  
            case "4"  => {
                println("    1 Timesheet Cutoff")
                println("    2 TimeSheet Range")
                println("    3 Peroid of Lunch time")
                val j = readLine("Please Choose: ")
                j match {
                    case "1"  => {
                        println
                        var a = 0
                        for( a <- 1 to 7){ 
                            var tmpvar = DayOfWeek.of(a)
                            print(s"$a -> $tmpvar  " )
                        }
                        println    
                        var kofweek = readLine("  Please choose a day of the Week ")
                        var k  = kofweek.toInt
                        //TODO: Catch line for Non int
                        //Inline test: println("you entered "+kofweek+" which is a Data Type " + k.getClass)
                        if (0 to 8 contains k) {
                            var tmpvar = DayOfWeek.of(k)
                            println(s"   setting Day as $tmpvar in TS5")//TS_5_Param(1, int k = dateTime.getDayOfWeek())
                        }else{
                            println("Choose wisely next time")
                        } 
                    }
                    case "2"  =>{
                        val TSRange = List("Weekly", "BiWeekly", "BiMonthly","Monthly")
                        for ((elem, count) <- TSRange.zipWithIndex) {print(s"${count+1} -> $elem  ")}
                        println
                        var TSRngSel = readLine("  Please choose a pay period range ")
                        //TODO: Catch line for Non int
                        var trs = TSRngSel.toInt
                        if (0 to 5 contains trs) {
                            println(s"  Setting TS5 range with ${TSRange(trs-1)}") //TS_5_Param(2, passParam)
                        }else{
                            println("  There may come a day where *that* works, but it is not today")
                        } 
                    }
                    case "3"  => {
                        val TSLRange = List(".5", "1", "1.5","2")
                        for ((elem, count) <- TSLRange.zipWithIndex) {print(s"${count+1} -> $elem  ")}
                        println
                        var TSLRngSel = readLine("  Please choose a Lunch Period ")
                        //TODO: Catch line for Non int
                        var tlrs = TSLRngSel.toInt
                        if (0 to 5 contains tlrs) {
                            println(s"  Setting TS5 Lunch with ${TSLRange(tlrs-1)}") //TS_5_Param(2, passParam)
                        }else{
                            println("  Thats what you want...Really?")
                        }
                    }
                }
            }  
            case "5" => { 
                println("Exit condition satisfied")
                exLoop = false
            }
            case _  => println("\nSelect a diffrent option please\n")
        }
    } 
    while(exLoop);   
    println()
    println("Program terminated")
    println()
    println()




} //fin



















/* Prompt avadable Commands - exe loop */  
    /*1 Punch  - TS_2_Punch */ 
        //1 Enter Punch (Auto Now)
    /*2 Hours - TS_3_Hours */
        // 1 Date (Default Now)
    /*3 Correct Punch  - TS_3_Hours */ 
        // 1 Date (Default Now)
    /*3 Print Timesheet - TS_4_TSP */
        //1 print Current Timesheet (Default Now)
        //2 Select by Date (Entered Date)
        //3 list old timesheet (Date = List of)
    /*4 Timesheet Paramaters - TS_5_Param*/
        //1 Timesheet Cutoff {Day of Week -> Default Friday}
        //2 TimeSheet Range {Weekly, BiWeekly, BiMonthly, Mothly-> Default Weekly}
        //3 Peroid of Lunch time {.5,1,1.5,2}
    /*5 Exit */
        // Cleanup and Close (Close DB connection, files, etc)

       
/* -*-*-*-*-*-*-*- 
NOTES
    Future data entry ONLY through Hours
    What are the Scala Time / Date commands?
    On rounding time: 
            Chop to Min? 
            Round to Qtr Hr?
            Convert to Decimal Time?
    On Date:
        What Format?
    Use SQL DateTime instead?
    Refence table for # days in month unless there is a fucntion for that

*/