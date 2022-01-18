/* On First Run: Auto Call Paramaters */
// On Open: Set a global Var from Date to Auto Seprate by TS_5_Param

/* Prompt avadable Commands - exe loop */  
    /*1 Punch  - TS_2_Punch */ 
        //1 Enter Punch
    /*2 Hours - TS_3_Hours */
        // 1 Date (Default Now)
    /*3 Correct Punch  - TS_3_Hours */ 
        // 1 Date (Default Now)
    /*3 Print Timesheet - TS_4_TSP */
        //1 print Current Timesheet (Date = Now)
        //2 list old timesheet (Date = List of)
        //3 Select and print old timesheet (Enter Date )
    /*4 Timesheet Paramaters  - TS_5_Param*/
        //1 Timesheet Cutoff {Day of Week -> Default Friday}
        //2 TimeSheet Range {Weekly, BiWeekly, Monthly  -> Default Weekly}
    /*5 Exit */
        // Cleanup and Close (Close DB connection, files, etc)
       
/* -*-*-*-*-*-*-*- 
NOTES
    Use of Hours Locks out ANY punch entry on CurrDate
    Future Data Entry Through Hours
    What are the Scala Time / Date commands?
    On rounding time: 
            Chop to Min? 
            Round to Qtr Hr?
            Convert to Decimal Time?
    On Date:
        What Format?

    Use SQL DateTime instead?

*/