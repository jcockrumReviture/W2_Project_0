import java.sql.{Connection, DriverManager}
import java.awt.print.Printable
object TS_2A_InPunch extends App {

    dbConnTest()

    def dbConnTest (): Connection = {
        val dbc = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
        val userName = "john"
        val password ="1q2w3e4r5t"
        val driver = "com.mysql.cj.jdbc.Driver"
        Class.forName(driver)
        val con = DriverManager.getConnection(dbc, userName, password)
        try {
            Class.forName(driver)
            if(con != null)
            System.out.println("Database connection is successful!")
            } catch {
            case e: Exception =>
            e.printStackTrace()
        }
        return con
    }
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