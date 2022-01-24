/*  On First Run: 
        Auto Call to set the Paramaters 
    On Open: 
        Set a global Var from Date to Auto Seprate by TS_5_Param
        Print out the 3 Timesheet Paramaters
*/

import scala.io.StdIn.readLine
import java.time._
import java.sql.{Connection, DriverManager}
import java.awt.print.Printable

Object TS(

  def main(args: Array[String]): Unit = {

    AuthTheUsr()


  def AuthTheUsr() :  
    val uName = readLine("Please enter your username: ")
    val EmpID = readLine("Please enter your password ")


)
    DEF theMenuSys(){
        var passDate  = LocalDate.now
        //Print the Menu
            println("1  Punch or out")
            println("2 Punch By Date")
            println("3 Print Timsheet")
            println("4 Edit Paramaters")
            println("5 Exit ")
            val i = readLine("Please Choose")
        i match {
            case 1  => TS_2_Punch( passDate )
            case 2  => TS_3_Hours( passDate )
            case 3  => {
                println("1 Correct Current Timesheet")
                println("2 Enter a Date")
                val j = readLine("Please Choose")
                j match {
                    case 1  => TS_3_Hours( passDate )
                    case 2  => {
                    val newDate = readLine("Enter Another Date if needed: yyyy/mm/dd")
                    val passDate =LocalDate.parse(newDate)
                    TS_3_Hours( passDate )
                    }
                }
            }   
            case 4  => {
                println("1 Print Current Timesheet")
                println("2 Enter a Date")
                println("3 See all Timesheets")
                val j = readLine("Please Choose")
                j match {
                    case 1  => TS_4_TSP( passDate )
                    case 2  => {
                    val newDate = readLine("Enter Another Date if needed: yyyy/mm/dd")
                    val passDate =LocalDate.parse(newDate)
                    TS_4_TSP( passDate )
                    }
                    Case 3  => TS_4_TSP()
                }
            }  
            case 5  => {
                println("1 Timesheet Cutoff")
                println("2 TimeSheet Range")
                println("3 Peroid of Lunch time")
                val j = readLine("Please Choose")
                j match {
                    case 1  => {
                        println("Please choose a day of the Week")
                        int k = readLine("Please Choose")
                        if 1 to 7 contains k
                        then TS_5_Param(1, int k = dateTime.getDayOfWeek())
                        Else println("Choose wisely next time")    
                    }
                         

                        
                    }
                    case 2  =>{



                        TS_5_Param(2, passParam)
                    }
                    Case 3  => {
                        

                        TS_5_Param(3, passParam)
                    }
                }
            }  
            case _  => println("Select a diffrent option please")
        } 
    }


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