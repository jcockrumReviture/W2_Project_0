/*  On First Run: 
        Auto Call to set the Paramaters 
    On Open: 
        Set a global Var from Date to Auto Seprate by TS_5_Param
        Print out the 3 Timesheet Paramaters
*/






/* Prompt avadable Commands - exe loop */  
    /*1 Punch  - TS_2_Punch */ 
        //1 Enter Punch (Auto Now)
    /*2 Hours - TS_3_Hours */
        // 1 Date (Default Now)
    /*3 Correct Punch  - TS_3_Hours */ 
        // 1 Date (Default Now)
    /*3 Print Timesheet - TS_4_TSP */
        //1 print Current Timesheet (Default Now)
        //2 Select by Date (Entered Date)
        //3 list old timesheet (Date = List of)
    /*4 Timesheet Paramaters - TS_5_Param*/
        //1 Timesheet Cutoff {Day of Week -> Default Friday}
        //2 TimeSheet Range {Weekly, BiWeekly, BiMonthly, Mothly-> Default Weekly}
        //3 Default Lunch {.5,1,1.5,2}
    /*5 Exit */
        // Cleanup and Close (Close DB connection, files, etc)

       
/* -*-*-*-*-*-*-*- 
NOTES
    Future data entry ONLY through Hours
    What are the Scala Time / Date commands?
    On rounding time: 
            Chop to Min? 
            Round to Qtr Hr?
            Convert to Decimal Time?
    On Date:
        What Format?
    Use SQL DateTime instead?
    Refence table for # days in month unless there is a fucntion for that

*/