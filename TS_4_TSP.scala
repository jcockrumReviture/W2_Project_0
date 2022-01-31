import java.sql._

class TS_4_TSP {











/*

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
  */  
}

/* 
Behavior

    Opitons 1 && 2

    The Year values will be ignored (if possable)
    def "End of Period" as EOP

    Pass in Date from main
    Test if Date from Main is already an EOP
        IF Date <> EOP
        Lookup param {TimeSheet Range} as numOfDays
        calc/find the EOP for Date from Main with numOfDays
    print a table from EOP back numOfDays rows
    *** Exception to watch for: When date ranges cross months

    Option 3 
    Pull 10 rows of EOP at a time and display
    Calculate Next EOP and list Backwards
    Nav menu at the bottom (1 Back, 2 Forward, 9 Exit)
        Modfiy menu: No Foward when at the Calculated EOP, No Back when the
        oldest EOP is pulled
*/
