package project;

import java.util.ArrayList;
import java.util.List;

public class CPUresult {

	List<Event> event;
	List<Event> eventResult = new ArrayList();
	CPUresult(List<Event> event)
	{
		this.event = event;
		for(int i =0;i<event.size();i++)
		{
			Event previousEvent;
			Event currentEvent = event.get(i);
			if(i==0)
			{
				 previousEvent = new Event("default",0,0);
			}
			else
			{
				previousEvent = event.get(i-1);
			}
			if(previousEvent.getFinishTime()>currentEvent.getStartTime())
			{
				currentEvent.setwaitingTime(previousEvent.getFinishTime()-currentEvent.getStartTime());
				int burstTime = currentEvent.getFinishTime()-currentEvent.getStartTime();
				currentEvent.setStartTime(previousEvent.getFinishTime());
				currentEvent.setFinishTime(currentEvent.getStartTime()+burstTime);
				
			}
			eventResult.add(currentEvent);
			
		}
	}
	double getAveWaitingTime()
	{
		int total=0;
		for(Event entry : eventResult)
		{
			total +=entry.getwaitingTime();
		}
		return total*1.0/eventResult.size();
	}
	double getAveTurnAroundTime()
	{
		int total=0;
		for(Event entry : eventResult)
		{
			total +=entry.getwaitingTime()+entry.getFinishTime()-entry.getStartTime();
		}
		return total*1.0/eventResult.size();
	}
}
