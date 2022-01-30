class TS_5_Param {



}
object TS_Start{

    /*
    def main(args:Array[String]):Unit={  
        println
        println
        println("welcome to Timesheet in Scala")
        //TODO: test and scub input
        val un1 = readLine("Enter your UserID: ")
        val usrTst = auth_usr(un1)
        if ( usrTst == true ){
                tsMainLoop(un1)
            }else{
                println("Please Contact a Admistrator to be added to the system") 
            }
        //TODO: On First run: Call to set the Paramaters 
        println
        println  
        //Exit

        def auth_usr (un1: String):Boolean = {
            val dbc = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
            val dbun = "john"
            val dbpw ="1q2w3e4r5t"
            //TODO Git rid of the Hardcode
            val conn = DriverManager.getConnection(dbc, dbun, dbpw)
            val statement = connection.createStatement
            val rs = statement.executeQuery("SELECT EmpID FROM TSUser")
            while (rs.next() ) {
                val checkUnkn1 = rs.getString("EmpID")
                If( checkUnkn1 !=NULL)  {return true} 
            }
            connection.close
        }
    }   
*/    

}

/* 
    Output warning: Changing these values will change All reporting of past records

    1 Timesheet Cutoff {Day of Week -> Default Friday}
        Capture Value and write to DB
        prompt " Enter your cutoff day: 1 Sat 2 Sun ... 7 Fri"
            Reject if in put is not Int [1 - 7]

    2 TimeSheet Range {Weekly, BiWeekly, Monthly  -> Default Weekly
        Capture Value and write to DB
        "1 Weekly" 
        "2 BiWeekly"
        "3 BiMonthly" 
        "4 Monthly"
        Prompt "How often are you paid?""
            if 2 "Enter the last cutoff day"
            if 3 "Enter your pay days, ex 1, 15 or 7, 22"

    3 Default Lunch period {.5,1,1.5,2}
        Capture Value and write to DB

    4 Employee ID
        Moved to Main for Data persistance and control

    5 *Not Implamented, but should go here * Standard workday hours
        //Current *unchangeable* defalt is 8    
 */