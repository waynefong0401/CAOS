package project;

public class Event
{
    private final String processid;
    private final int startTime;
    private int finishTime;
    
    public Event(String processid, int startTime, int finishTime)
    {
        this.processid = processid;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }
    
    public String getProcessid()
    {
        return processid;
    }
    
    public int getStartTime()
    {
        return startTime;
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