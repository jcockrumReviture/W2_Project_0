import java.sql._
import java.time._
import scala.util.Try
import scala.io.StdIn._

class TS_5_Param {
    // Class variables
        var un1: Int = 0
        var usrTst: Int = 0

    def user_login = {
        println()
        println()
        println("welcome to Timesheet in Scala")
        //TODO: test and scub input
        
        un1 = readLine("Enter your UserID: ").toInt
        auth_usr
        
        println(s"value of un1 is $un1 and usrTst is $usrTst")

        if (un1 == usrTst){
                println("tsMainLoop(un1)")
            }else{
                println("Please Contact a Admistrator to be added to the system") 
            }
        //TODO: On First run: Call to set the Paramaters 
        println()
        println()
        //Exit
    }

    def auth_usr = {
        val db_addy = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
        // database credentials
        val db_usr  = "root"
        val db_pass = "1q2w3e4r"
        //SQL and Connection
        val sql =  s"SELECT $un1 FROM tsuser"
        
        Class.forName("com.mysql.cj.jdbc.Driver")
        val connection:Try[Connection]= Try(DriverManager.getConnection(db_addy, db_usr, db_pass))
        val statement: Try[Statement] = connection.map(_.createStatement())
        val resultSet: Try[ResultSet] = statement.map(_.executeQuery(sql))

        resultSet.map(rs => while (rs.next()) usrTst=(rs.getInt(1)))  
                .recover{case e => e.printStackTrace()}
        // Cleanup
        resultSet.foreach(_.close())
        statement.foreach(_.close())
        connection.foreach(_.close())
    }
}

/* 
    Output warning: Changing these values will change All reporting of past records

    1 Timesheet Cutoff {Day of Week -> Default Friday}
        Capture Value and write to DB
        prompt " Enter your cutoff day: 1 Sat 2 Sun ... 7 Fri"
            Reject if in put is not Int [1 - 7]

    2 TimeSheet Range {Weekly, BiWeekly, Monthly  -> Default Weekly
        Capture Value and write to DB
        "1 Weekly" 
        "2 BiWeekly"
        "3 BiMonthly" 
        "4 Monthly"
        Prompt "How often are you paid?""
            if 2 "Enter the last cutoff day"
            if 3 "Enter your pay days, ex 1, 15 or 7, 22"

    3 Default Lunch period {.5,1,1.5,2}
        Capture Value and write to DB

    4 Employee ID
        

    5 *Not Implamented, but should go here * Standard workday hours
        //Current *unchangeable* defalt is 8    
 */