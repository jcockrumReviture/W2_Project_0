# W2_Project_0
A Scala CLI application over MySql db.
When working from home or on a consulting job it is often difficult to generate an accurate timesheet at the end of work. 

=-=-=-=-=-=-
This program will accept 2 diffrent input types: 
    a "live" punch,     
            If you are clocking in what times your upcomming breaks and clock times are.
            If you are clocking out, how many hours have been logged.
            each punch will be a row in the DB

    a "hours" punch
        for this punch you will enter a start time, which will give you the time of what hours you should have punched in and out based on a standard work day split
        This type of punch will be used to correct entered punches
    There are 4 punches avadable In, Lunch Out, Lunch In, Done

=-=-=-=-=-=-
This Program will output in 3 ways:
    The default action is to display the Timesheet of the current period.
    You can select a timesheet by Date.
    YOu can show a list of completed Timesheet dates.

=-=-=-=-=-=-
There is a Third section, which is the Timesheet Paramaters. This is where you enter or change the default values of the Timesheet reporting.

