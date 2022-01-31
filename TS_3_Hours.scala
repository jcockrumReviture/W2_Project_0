
import java.sql._
import java.time._
import scala.util.Try
import scala.io.StdIn._

class TS_3_InHours(val theUID: Int, val theDate: String) {

     var thePunchCnt =0

// Show all the punches for the date
    getAllPunches


//select a punch and change it
    thePunchCnt match {
        case 0  => {
            cngAPunch
            println("You have changed your first Punch ")
        }
        case 1  => {
            cngAPunch
            println("You have changed your first Punch ")
        }
        case 2  => {
            cngAPunch
            println("You have changed your first Punch")
    
        }
        case 3  => {
            cngAPunch
            println("You have changed your first Punch")

        }
        case _  => println("I'm sorry, I don't understand what you want to do")
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
        val connection:Try[Connection]= Try(DriverManager.getConnection(db_addy, db_usr, db_pass))
        val statement: Try[Statement] = connection.map(_.createStatement())
        val resultSet: Try[ResultSet] = statement.map(_.executeQuery(sql))
        //resultSet.map(rs => while (rs.next)   println(rs.getInt(1)) ) 
        println("Punch ID    Date     Time")
        while ( resultSet ) {
        val pid = resultSet.getString(1)
        val pda = resultSet.getString(2)
        val ptm = resultSet.getString(3)
        println(s"$pid    $pda    $ptm")
      }
        // Cleanup
        resultSet.foreach(_.close())
        statement.foreach(_.close())
        connection.foreach(_.close())
    }

    def cngAPunch = {
        /*
        val db_addy = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
        // database credentials
        val db_usr  = "root"
        val db_pass = "1q2w3e4r"
        //SQL and Connection
        //// UPDATE TSPunches SET TSEntryTime = '08:00' WHERE PunchID = 363; 
        String sql = s"UPDATE TSPunches SET TSEntryTime = '08:00' WHERE PunchID = $theUID ;"
        Class.forName("com.mysql.cj.jdbc.Driver")

        Connection conn = DriverManager.getConnection(db_addy, db_usr, db_pass)
        Statement stmt = conn.createStatement()
        stmt.executeUpdate(sql)
        System.out.println("Database updated successfully ")
        */
    }
  
}    
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