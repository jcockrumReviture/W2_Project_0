
import java.sql._
import java.time._
import scala.util.Try
import scala.io.StdIn._

class TS_3_InHours(val theUID: Int, val theDate: String) {
    var changeLoop   : Boolean = true
    var ts3_sel      : Int = 1
    var mod_pid      : Int = 0
    var mod_ptm      : String = ""


//Loopit
    println()
    println()
    println("Welcome to Hours Entry")
    println()
    while(changeLoop){
// Show all the punches for the date
        getAllPunches
        println()
        println("1 Edit A punch")
        println("2 Exit ")
        ts3_sel = readLine("Please Choose: ").toInt
    //select a punch and change it
        ts3_sel match {
            case 1  => {
                mod_pid = readLine("Please Enter Punch ID: ").toInt
                mod_ptm = readLine("Please Enter Punch time: ").toString
                if (mod_pid != 0){
                    cngAPunch
                    println(s"You have changed punch $mod_pid ")
                }else{
                    println{"Change Canceled"}
                }

            }
            case 2  => changeLoop = false
            case _  => println("I'm sorry, I don't understand what you want to do")
        }
    }

    def getAllPunches = {
        val db_addy = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
        // database credentials
        val db_usr  = "root"
        val db_pass = "1q2w3e4r"
        //SQL and Connection
        // SELECT PunchID, TSEntryDate, TSEntryTime FROM TSPunches WHERE TSEntryDate = '1/30/2022' AND fk_EmpID = 1111;
        val sql =  s"SELECT PunchID, TSEntryDate, TSEntryTime FROM TSPunches WHERE TSEntryDate = '$theDate' AND fk_EmpID = $theUID ;"
        //for testing:  println (s"get Count: $sql")
        Class.forName("com.mysql.cj.jdbc.Driver")
        val connection =  DriverManager.getConnection(db_addy, db_usr, db_pass)
        val statement = connection.createStatement
        val rs = statement.executeQuery(sql)
         println("Punch ID    Date         Time")
            while (rs.next) {
                val pid = rs.getString("PunchID")
                val pda = rs.getString("TSEntryDate")
                val ptm = rs.getString("TSEntryTime")
                println(s"$pid         $pda    $ptm")
            }
        // Cleanup
        connection.close()
    }

    def cngAPunch = {
        val db_addy = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
        // database credentials
        val db_usr  = "root"
        val db_pass = "1q2w3e4r"
        //SQL and Connection
        //// UPDATE TSPunches SET TSEntryTime = '08:00' WHERE PunchID = 363; 
        val sql = s"UPDATE TSPunches SET TSEntryTime = '$mod_ptm' WHERE PunchID = $mod_pid ;"
        Class.forName("com.mysql.cj.jdbc.Driver")
        val conn =  DriverManager.getConnection(db_addy, db_usr, db_pass)
        val stmt = conn.createStatement()
        stmt.executeUpdate(sql)
        System.out.println("Database updated successfully ")
        conn.close()
    }
} //Fin
/*  Behavior
    
    accept Date Value from Main Or Restart if a new date is entered
        Look in DB for val by that Date
            IF Start == NULL Then Prompt Start
                Else display Val and Next
            IF Out_Lunch == NULL Then show as Start + 4 Hours
                Else display Val and Next
            IF In_Lunch == NULL Then show as Out Lunch + Default Lunch Hours
                Else display Val and Next
            IF Out == NULL Then show as Out - Lunch + 4 Hours
                Else display Val

*/