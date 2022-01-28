class TS_3_InHours {

    /*
     def MakeHours (datetimeNow: String,empid: Int) = {
        val dbc = "jdbc:mysql://127.0.0.1:3306/w2_project_0"
        val dbun = "john"
        val dbpw ="1q2w3e4r5t"
        //TODO gotta git rid of the Hardcode
        val conn = DriverManager.getConnection(dbc, dbun, dbpw)
        val formofSQL ="SELECT TSEntryDate,COUNT(TSEntryDate),fk_EmpID FROM tspunches WHERE = TSEntryDate = NOW AND fk_EmpID = "+ empid + ");"
        val statement = connection.createStatement
        val rs = statement.executeQuery(formofSQL)
        println("You have Clocked in from Lunch")
     }
  */   
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