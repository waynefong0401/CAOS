package project;

public class Row
{
    private String processid;
    private int arrivalTime;
    private int burstTime;
    private int priorityLevel;
    private int waitingTime;
    private int turnaroundTime;
    
    private Row(String processid, int arrivalTime, int burstTime, int priorityLevel ,int waitingTime, int turnaroundTime)
    {
        this.processid = processid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priorityLevel = priorityLevel;
        this.waitingTime = waitingTime;
        this.turnaroundTime = turnaroundTime;
    }
    
    public Row(String processid, int arrivalTime, int burstTime, int priorityLevel)
    {
        this(processid, arrivalTime, burstTime, priorityLevel , 0, 0);
    }
    
    public Row(String processid, int arrivalTime, int burstTime)
    {
        this(processid, arrivalTime, burstTime, 0, 0, 0);
    }
    
    public void setBurstTime(int burstTime)
    {
        this.burstTime = burstTime;
    }
    
    public void setWaitingTime(int waitingTime)
    {
        this.waitingTime = waitingTime;
    }
    
    public void setTurnaroundTime(int turnaroundTime)
    {
        this.turnaroundTime = turnaroundTime;
    }
    
    public String getProcessid()
    {
        return this.processid;
    }
    
    public int getArrivalTime()
    {
        return this.arrivalTime;
    }
    
    public int getBurstTime()
    {
        return this.burstTime;
    }
    
    public int getPriorityLevel()
    {
        return this.priorityLevel;
    }
    
    public int getWaitingTime()
    {
        return this.waitingTime;
    }
    
    public int getTurnaroundTime()
    {
        return this.turnaroundTime;
    }
}