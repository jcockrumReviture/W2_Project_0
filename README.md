# W2_Project_0
## A Scala CLI application over MySql db.
When working from home or on a consulting job it is often difficult to generate an accurate timesheet at the end of work. 

## Data Origization
- There are 4 punches avadable In, Lunch Out, Lunch In, Out
- a group of 4 punches will be a row in the DB
###### Timesheet Paramaters 
- This is where you enter or change the default values of the Timesheet reporting.
- Warning: at this time, changes to these paramaters will alter ALL reporting.
- Also in this section will be the employee ID, which will serve as half of the PK

## This program will accept 2 diffrent input types:
###### a "live" punch 
- If you are clocking in what times your upcomming breaks and clock times are.
- If you are clocking out, how many hours have been logged.

###### a "hours" punch
- for this style you will enter a start time, which will then give you the next time of what hours you should have punched in and out based on a standard work day split
- This type of punch will be used to correct entered punches

## This Program will output in 3 ways:
- The default action is to display the Timesheet of the current period.
- You can select a timesheet by Date.
- You can show a list of completed Timesheet dates.


