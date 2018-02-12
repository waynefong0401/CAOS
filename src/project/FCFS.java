package project;
import java.util.Collections;
import java.util.List;


public class FCFS extends CPUScheduler
{
	List<Event> timeline;
    @Override
    public void process()
    {        
        Collections.sort(this.getRows(), (Object o1, Object o2) -> {
            if (((Row) o1).getArrivalTime() == ((Row) o2).getArrivalTime())
            {
                return 0;
            }
            else if (((Row) o1).getArrivalTime() < ((Row) o2).getArrivalTime())
            {
                return -1;
            }
            else
            {
                return 1;
            }
        });
        
        timeline = this.getTimeline();
        
        for (Row row : this.getRows())
        {
            if (timeline.isEmpty())
            {
                timeline.add(new Event(row.getProcessid(), row.getArrivalTime(), row.getArrivalTime() + row.getBurstTime()));
            }
            else
            {
               // Event event = timeline.get(timeline.size() - 1);
                timeline.add(new Event(row.getProcessid(), row.getArrivalTime(), row.getArrivalTime() + row.getBurstTime()));
            }
        }
        
        for (Row row : this.getRows())
        {
            row.setWaitingTime(this.getEvent(row).getStartTime() - row.getArrivalTime());
            row.setTurnaroundTime(row.getWaitingTime() + row.getBurstTime());
        }
    }
}

