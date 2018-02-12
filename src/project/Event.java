package project;

public class Event
{
    private final String processid;
    private int startTime;
    private int finishTime;
    private int waitingTime;
    
    public Event(String processid, int startTime, int finishTime)
    {
        this.processid = processid;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.waitingTime = 0;
    }
    
    public String getProcessid()
    {
        return processid;
    }
    
    public void setStartTime(int startTime)
    {
         this.startTime = startTime;
    }
    public void setwaitingTime(int waitingTime)
    {
         this.waitingTime = waitingTime;
    }
    public int getwaitingTime()
    {
        return waitingTime;
    }
    
    public int getStartTime()
    {
        return startTime;
    }
    
    public void getFinishTime(int finishTime)
    {
        this.finishTime=finishTime;
    }
    
    public int getFinishTime()
    {
        return finishTime;
    }
    
    public void setFinishTime(int finishTime)
    {
        this.finishTime = finishTime;
    }
}