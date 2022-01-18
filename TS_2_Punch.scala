class TS_2A_InPunch {

/* Print To Screen */
// "Today is "{Date = Now}
// "The time is "{Time = Time of entry to screen}
// "You are clocked " + {State} 
// "Press 1 to Enter Punch, 2 to exit"
    //IF ioCapture <> 1 Then RetMain
    //test state - Read State from DB {Date = Now, State}
    //IF State <> in, - write to DB -> {Method = Punch, State = in,Date =now, Time = now}
    //Else - write to DB -> {Method = Punch, State = out,Date=now, Time = (round(Now)}
}