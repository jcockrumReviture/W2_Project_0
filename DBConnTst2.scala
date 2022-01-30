//import java.sql.{Connection, DriverManager}
//import java.sql.Statement
import java.sql._
import scala.util.Try

object DBConnTst2{

    val db_addy = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
    // database credentials
    val db_usr  = "root"
    val db_pass = "1q2w3e4r"
    //SQL and Connection
    val sql =  "SELECT * FROM tsuser"
    
    Class.forName("com.mysql.cj.jdbc.Driver")
    val connection:Try[Connection]= Try(DriverManager.getConnection(db_addy, db_usr, db_pass))
    val statement: Try[Statement] = connection.map(_.createStatement())
    val resultSet: Try[ResultSet] = statement.map(_.executeQuery(sql))

    resultSet.map(rs => while (rs.next()) println(rs.getString(1)))  
            .recover{case e => e.printStackTrace()}
    // Cleanup
    resultSet.foreach(_.close())
    statement.foreach(_.close())
    connection.foreach(_.close())
}
