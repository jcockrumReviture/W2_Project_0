/* package tests */

import java.sql.{Connection,DriverManager}

object ScalaJdbcConnectSelect extends App {
    // connect to the database named "mysql" on port 3306 of localhost
    val url = "jdbc:mysql://localhost:3306/mysql"
    val driver = "com.mysql.jdbc.Driver"
    val username = "root"
    val password = "1q2w3e4r"
    var connection:Connection = _
    try {
        Class.forName(driver)
        connection = DriverManager.getConnection(url, username, password)
        val statement = connection.createStatement
        val rs = statement.executeQuery("SELECT host, user FROM user")
        while (rs.next) {
            val host = rs.getString("host")
            val user = rs.getString("user")
            println("host = %s, user = %s".format(host,user))
        }
    } catch {
        case e: Exception => e.printStackTrace
    }
    connection.close
}