// Example 10 from https://www.programcreek.com/scala/java.sql.Connection

object DBConnTst {
/*
import java.sql.{Connection, DriverManager}
import java.util

    class MySqlPool(url: String, user: String, pwd: String) extends Serializable {
        private val max = 3
        private val connectionNum = 1
        private var conNum = 0
        private val pool = new util.LinkedList[Connection]()
        def getJdbcConn(): Connection = {
            AnyRef.synchronized({
            if (pool.isEmpty) {
                preGetConn()
                for (i <- 1 to connectionNum) {
                    val conn = DriverManager.getConnection(url, user, pwd)
                    pool.push(conn)
                    conNum += 1
                }
            }
            pool.poll()
            })
        }
        def releaseConn(conn: Connection): Unit = {
            pool.push(conn)
        }
    }

    object JdbcSqlite {
        def main(args: Array[String]) {
            var c: Connection = null
            try {
                Class.forName("org.sqlite.JDBC")
                c = DriverManager.getConnection("jdbc:sqlite:planets.sqlite")
            } catch {
                case e: Throwable => e.printStackTrace
            }
            c.close()
        }
    } 







    */
    
}