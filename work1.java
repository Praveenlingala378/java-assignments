import java.io.*;
import java.util.Calendar; 
class work1
{
    private static int BEGINWORKHOUR = 8;
    private static int ENDWORKHOUR = 16;

    public int getWorkedMinutes(){
    Calendar start = (Calendar) this.startTime.clone();
    Calendar end = (Calendar) this.endTime.clone();

    if(start.get(Calendar.HOUR_OF_DAY) < BEGINWORKHOUR){
        start.set(Calendar.HOUR_OF_DAY, BEGINWORKHOUR);
        start.set(Calendar.MINUTE, 0);
    }

    if(end.get(Calendar.HOUR_OF_DAY) >= ENDWORKHOUR){
        end.set(Calendar.HOUR_OF_DAY, ENDWORKHOUR);
        end.set(Calendar.MINUTE, 0);
    }

    int workedMins = 0;
    while(!sameDay(start, end)){
        workedMins += workedMinsDay(start);
        start.add(Calendar.DAY_OF_MONTH, 1);
        start.set(Calendar.HOUR_OF_DAY, BEGINWORKHOUR);
        start.set(Calendar.MINUTE, 0);
    }
    workedMins += (end.get(Calendar.MINUTE) - start.get(Calendar.MINUTE)) + ((end.get(Calendar.HOUR_OF_DAY) - start.get(Calendar.HOUR_OF_DAY))*60);
    return workedMins;
}

private int workedMinsDay(Calendar start){
    if((start.get(Calendar.DAY_OF_WEEK) == 1) || (start.get(Calendar.DAY_OF_WEEK) == 6))    return 0;
    else return (60 - start.get(Calendar.MINUTE)) + ((ENDWORKHOUR - start.get(Calendar.HOUR_OF_DAY) - 1)*60);
}

private boolean sameDay(Calendar start, Calendar end){
    if(start.get(Calendar.YEAR) == end.get(Calendar.YEAR) && start.get(Calendar.MONTH) == end.get(Calendar.MONTH) &&
            start.get(Calendar.DAY_OF_MONTH) == end.get(Calendar.DAY_OF_MONTH)) return true;
    else return false;
}
}