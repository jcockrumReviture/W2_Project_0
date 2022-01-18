class TS_4_TSP {
  
/* 
Behavior

    Opitons 1 && 2

    The Year values will be ignored (if possable)
    def "End of Period" as EOP

    Pass in Date from main
    Test if Date from Main is already an EOP
        IF Date <> EOP
        Lookup param {TimeSheet Range} as numOfDays
        calc/find the EOP for Date from Main with numOfDays
    print a table from EOP back numOfDays rows
    *** Exception to watch for: When date ranges cross months

    Option 3 
    Pull 10 rows of EOP at a time and display
    Calculate Next EOP and list Backwards
    Nav menu at the bottom (1 Back, 2 Forward, 9 Exit)
        Modfiy menu: No Foward when at the Calculated EOP, No Back when the
        oldest EOP is pulled
*/

}
