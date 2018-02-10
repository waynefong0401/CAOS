package project;

import java.util.*;
import java.util.Map.Entry;
import java.lang.Integer;


public class Process
{
	List<Integer> keyList = new ArrayList<Integer>();
	Map<Integer,List<Integer>> processMap = new HashMap<Integer,List<Integer>>();
	
	Map<Integer,Integer> processMap1 = new HashMap<Integer,Integer>();
	//key is the sequence
	//value is the size of task
	
	Process(){
	}
	
	HashMap<Integer,List<Integer>> getAllProcess()
	{
		return (HashMap<Integer, List<Integer>>) processMap;
	}
	
	Map<Integer, Integer> getAllProcess1()
	{
		return processMap1;
	}
	
	Integer addProcess(Integer sequence,Integer size)
	{
		return processMap1.put(sequence, size);
	}
	
	void clearProcess()
	{
		processMap.clear();
		processMap1.clear();
	}
	void generateProcess()
	{
		processMap.clear();
		for(Entry<Integer, Integer> entry : processMap1.entrySet())
		{
			//the integer list contain 3 value
			//[0] size
			//[1] 1 represent the task is too big
			//[2] process location in memory block
			processMap.put(entry.getKey(), new ArrayList<Integer>(Arrays.asList(entry.getValue(),0,-1)));
		}
	}
	
	public void sortProcessMap()
	{
		Set<Integer> keyset = processMap.keySet();
		keyList = new ArrayList<Integer>(keyset);
		Collections.sort(keyList);
	}
	
	public List<Integer> getSortedKeyList()
	{
		Set<Integer> keyset = processMap.keySet();
		keyList = new ArrayList<Integer>(keyset);
		Collections.sort(keyList);
		return keyList;
	}

	public void processFailed(Integer index)
	{
		processMap.get(index).set(1,1);
	}

	public void updateProcessMap(Integer index,Integer blockIndex)
	{
		processMap.get(index).set(2,blockIndex);
	}
	
	public void deleteProcess(Integer index)
	{
		processMap1.remove(index);
	}
}















