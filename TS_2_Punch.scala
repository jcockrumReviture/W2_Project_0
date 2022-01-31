import java.sql._
import java.time._
import scala.util.Try

class TS_2A_InPunch(val theUID: Int, val theDate: String) {
    val theTime: Stirng = ""
    var thePunchCnt: Int = 0
    var formOfSQL: String = ""
    val theTimeforMath=LocalTime.now

    theTime = (LocalTime.now).toString
//get Punch Count
    getPunchCount
//Select and insert Punch
    thePunchCnt match {
        case "0"  => {
            addPunchbyCount
            println("You have Clocked in ")
        }
        case "1"  => {

            println("You have Clocked out for Lunch ")
        }
        case "2"  => {
            addPunchbyCount
            println("You have Clocked in from Lunch")
        //TODO: Da Maths You have xx:XX remaining time today
        }
        case "3"  => {
            addPunchbyCount
            println("You have Clocked out for the Day ")
        //TODO: Da Maths: You worked X Hours
        }
        case _  => println("You are done; You don't have to go home but you can't stay here")
    } 

    def getPunchCount = {
        val db_addy = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
        // database credentials
        val db_usr  = "root"
        val db_pass = "1q2w3e4r"
        //SQL and Connection
        val sql =  s"SELECT COUNT(TSEntryDate) FROM TSPunches WHERE TSEntryDate = $theDate AND fk_EmpID = $theUID"
        Class.forName("com.mysql.cj.jdbc.Driver")
        val connection:Try[Connection]= Try(DriverManager.getConnection(db_addy, db_usr, db_pass))
        val statement: Try[Statement] = connection.map(_.createStatement())
        val resultSet: Try[ResultSet] = statement.map(_.executeQuery(sql))
        resultSet.map(rs => while (rs.next()) thePunchCnt=(rs.getInt(1)))  
                .recover{case e => e.printStackTrace()}
        // Cleanup
        resultSet.foreach(_.close())
        statement.foreach(_.close())
        connection.foreach(_.close())
    }

    def addPunchbyCount {
        val db_addy = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
        // database credentials
        val db_usr  = "root"
        val db_pass = "1q2w3e4r"
        //SQL and Connection
        val formOfSQL = s"INSERT INTO TSPunches (TSEntryDate,TSEntryTime,fk_EmpID) VALUES ($theDate,$theTime,$theUID);"
        Class.forName("com.mysql.cj.jdbc.Driver")
        val connection:Try[Connection]= Try(DriverManager.getConnection(db_addy, db_usr, db_pass))
        val statement: Try[Statement] = connection.map(_.createStatement())
        val resultSet: Try[ResultSet] = statement.map(_.executeQuery(formOfSQL))
        resultSet.map(rs => while (rs.next()) thePunchCnt=(rs.getInt(1)))  
                .recover{case e => e.printStackTrace()}
        // Cleanup
        resultSet.foreach(_.close())
        statement.foreach(_.close())
        connection.foreach(_.close())

    }

//Fin
} 

// Future Data entry is blocked because there is no access by the use to enter a time

/* Print To Screen */
// "Today is "{Date = Now}
// "The time is "{Time = Time of entry to screen}
// "You are clocked " + {State} 
// "IF {state <> OUT} your next Clock time is {calculation}"
// Else "you worked {Calculation} hours."

// "Press 1 to Enter Punch, 2 to exit"
    //IF ioCapture <> 1 Then RetMain
    //test state - Read State from DB {Date = Now, State}
    //IF State <> in, - write to DB -> {Method = Punch, State = in,Date =now, Time = now}
    //Else - write to DB -> {Method = Punch, State = out,Date=now, Time = (round(Now)}