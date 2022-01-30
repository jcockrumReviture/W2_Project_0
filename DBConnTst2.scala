//import java.sql.{Connection, DriverManager}
//import java.sql.Statement
import java.sql._
import scala.util.Try

object DBConnTst2 extends App {

    val db_addy = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
    // database credentials
    val db_usr  = "root"
    val db_pass = "1q2w3e4r"
    //SQL and Connection
    val sql =  "SELECT * FROM tsuser"
    
    Class.forName("com.mysql.jdbc.Driver")
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

/* 
  //example from https://alvinalexander.com/source-code/scala-jdbc-sql-select-insert-statement-resultset-preparedstatement-example/
 // jdbc driver name and database URL
    val DB_URL      = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
    // database credentials
    val USER = "root"
    val PASS = "1q2w3e4r"
    //SQL and Connection
    val sql =  "SELECT * FROM tsuser"
    try {
        val conn = DriverManager.getConnection(DB_URL, USER, PASS)
        val stmt = conn.createStatement
        val rs: ResultSet = stmt.executeQuery(sql)
        while (rs.next) {
            val id = rs.getInt("id")
            val first = rs.getString("first")
            val last = rs.getString("last")
            println(s"$id, $first, $last")
        }
        // cleanup
        stmt.close
        conn.close
    } catch {
        case se: SQLException => se.printStackTrace
        case e:  Exception => e.printStackTrace
    } finally {
        try {
            if (stmt!=null) stmt.close
        } catch {
            case se2: SQLException => // nothing we can do
        }
        try {
            if (conn!=null) conn.close
        } catch {
            case se: SQLException => se.printStackTrace
        } //end finally-try
    } //end try
    println("the end")
*/