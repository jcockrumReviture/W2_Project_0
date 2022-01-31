import java.sql._
import scala.util.Try
import scala.io.StdIn._

object Main extends App {
  //Login Vars
  var un1: Int = 0
  var usrTst: Int = 0
  var passedAuth : Boolean = false

  //=-=-=-=-=-=-=-=-
  println()
  println()
  println()
  println()
  println("welcome to Timesheet in Scala")
  println()      

  user_login
  if(passedAuth == true){ new tsMainLoop(usrTst) }
  
  println()
  println("Program terminated")
  println()
  println()
  //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

    def user_login = {
        un1 = readLine("Enter your UserID: ").toInt
        auth_usr
        //for testing:  println(s"value of un1 is $un1 and usrTst is $usrTst")
        if (un1 == usrTst){
                passedAuth = true
            }else{
                println("Please Contact a Admistrator to be added to the system") 
                passedAuth = false
            }
        //Exit
    }

    def auth_usr = {
        val db_addy = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
        // database credentials
        val db_usr  = "root"
        val db_pass = "1q2w3e4r"
        //SQL and Connection
        val sql =  s"SELECT EmpID FROM TSUser WHERE EmpID = $un1 ;"
        //for testing println(s"Query $sql")
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