class TS_5_Param {

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
        Capure a Value to use as the PK.

    5 *Not Implamented, but should go here * Standard workday hours
        //Current *unchangeable* defalt is 8    
 */

}
