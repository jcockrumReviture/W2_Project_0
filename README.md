# W2_Project_0
## A Scala CLI application over MySQL.
When working from home or on a consulting job it is often difficult to generate an accurate timesheet at the end of work.

## Data origization
- There are 4 punches available: _In_, _Lunch Out_, _Lunch In_, _Out_
###### Timesheet Parameters
- **Warning: changes to these parameters will alter _ALL_ reporting Per User**.
- This is where you enter or change the **default** values of the Timesheet reporting.
- Also in this section will be the _employeeID_, which will serve as PK

## This program will accept 2 different input types:
###### a "live" punch
- If you are clocking in what times your upcoming breaks and clock times are.
- If you are clocking out, how many hours have been logged.
###### a "hours" punch
- To create a Hours record: 
  - enter a start time, which will then give you the next time of what hours you should have punched in and out 
  - Hours defaults to a _standard_ work day split
- This type of punch is used to correct entered punches

## This program will output in 3 ways:
- The default action is to display the Timesheet of the current period.
- You can select a timesheet by Date.
- You can show a list of completed Timesheet dates.
