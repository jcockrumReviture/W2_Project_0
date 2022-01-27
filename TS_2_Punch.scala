    import java.sql.{Connection, DriverManager}
object TS_2A_InPunch extends App {

    dbConnTest()

    def dbConnTest (): Connection = {
        val dbc = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
        val dbun = "john"
        val dbpw ="1q2w3e4r5t"
        //todo Git rid of the Hardcode
        val conn = DriverManager.getConnection(dbc, dbun, dbpw)
        if(conn != null){ println("Database connection is successful!")}
    }

    def MakePunch (datetimeNow: String,empid: Int) = {
        val dbc = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
        val dbun = "john"
        val dbpw ="1q2w3e4r5t"
        //TODO gotta git rid of the Hardcode
        val conn = DriverManager.getConnection(dbc, dbun, dbpw)
        val statement = connection.createStatement
        val rs = statement.executeQuery("SELECT TSEntryDate,COUNT(TSEntryDate),fk_EmpID FROM tspunches WHERE = TSEntryDate = today AND fk_EmpID = "+ empid + ");")
        while (rs.next() ) { val checkUnkn1 = rs.getInt("COUNT(TSEntryDate)")} // TODO: This line is wrong
         checkUnkn1 match {
            case "0"  => {
                val formofSQL = "INSERT INTO TSPunches (TSEntryDate,TSEntryTime,fk_EmpID) VALUES (" + LocalDate.now + "," + LocalTime.now + "," + empid + ");"
                val statement = connection.createStatement
                val rs = statement.executeQuery(formofSQL)
                println("You have Clocked in ")
                //TODO: Da Maths Lunch is at xx:xx time
            }
            case "1"  => {
                val formofSQL = "INSERT INTO TSPunches (TSEntryDate,TSEntryTime,fk_EmpID) VALUES (" + LocalDate.now + "," + LocalTime.now + "," + empid + ");"
                val statement = connection.createStatement
                val rs = statement.executeQuery(formofSQL)
                println("You have Clocked out for Lunch ")
                //TODO: Da Maths Lunch is over at xx:xx time
            }
            case "2"  => {
                val formofSQL = "INSERT INTO TSPunches (TSEntryDate,TSEntryTime,fk_EmpID) VALUES (" + LocalDate.now + "," + LocalTime.now + "," + empid + ");"
                val statement = connection.createStatement
                val rs = statement.executeQuery(formofSQL)
                println("You have Clocked in from Lunch")
                //TODO: Da Maths You have xx:XX remaining time today
            }
            case "3"  => {
                val formofSQL = "INSERT INTO TSPunches (TSEntryDate,TSEntryTime,fk_EmpID) VALUES (" + LocalDate.now + "," + LocalTime.now + "," + empid + ");"
                val statement = connection.createStatement
                val rs = statement.executeQuery(formofSQL)
                println("You have Clocked out for the Day ")
                //TODO: Da Maths: You worked X Hours
            }
            case _  => println("You are done; You don't have to go home but you can't stay here")
         }
        }
        connection.close
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