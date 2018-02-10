package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MemoryResult {
	private static final double BLOCKSIZE = 10000.0;//Assume the blocksize is 10000, calculate the percentage position of block
	MemoryBlock mb;
	Process pc;
	List<Integer> sortedKeyList;
	double unitSize;
	HashMap<Integer,List<Integer>> memoryResultBlockInfo = new HashMap<Integer,List<Integer>>();
	//0.Size
	//1.Free size
	//2.Used Size
	//3.Start position
	//4.End Position
	//5.Anchor
	HashMap<Integer,HashMap<Integer,List<Integer>>> memoryResultBlock = new HashMap<Integer,HashMap<Integer,List<Integer>>>();
	//Key is ID of memoryBlock 0-?
	//Second key is process sequence
	//0.size
	//1.start
	//2.end
	
	HashMap<Integer,Integer> oversizeProcess = new HashMap<Integer,Integer>();
	MemoryResult(MemoryBlock tempMB,Process tempPC)
	{
		this.mb = tempMB;
		this.pc = tempPC; 
		double anchor = 0;
		int totalBlockSize = 0;
		for(HashMap.Entry<Integer,List<Integer>> entryBlock : tempMB.getAllBlock().entrySet())
		{
			totalBlockSize += ((List<Integer>)entryBlock.getValue()).get(0);
			memoryResultBlock.put((Integer) entryBlock.getKey(), new HashMap<Integer,List<Integer>>());
		}
		unitSize = BLOCKSIZE/totalBlockSize;
		for(HashMap.Entry<Integer,List<Integer>> entryBlock : tempMB.getAllBlock().entrySet())
		{
			int tempBlockSize = ((List<Integer>)entryBlock.getValue()).get(0);
			double position = tempBlockSize*BLOCKSIZE / totalBlockSize ;
			tempMB.block.get(entryBlock.getKey()).add(3, (int)anchor);
			anchor = anchor+position;
			tempMB.block.get(entryBlock.getKey()).add(4,(int)anchor);
			tempMB.block.get(entryBlock.getKey()).add(5, tempMB.block.get(entryBlock.getKey()).get(3));
		}
		memoryResultBlockInfo = tempMB.block;
		
		sortedKeyList = tempPC.getSortedKeyList();
		for(int i:sortedKeyList)
		{
			if(tempPC.processMap.get(i).get(1)==1)
			{
				oversizeProcess.put(i, tempPC.processMap.get(i).get(0));
				continue;
			}
			int memoryLocation = tempPC.processMap.get(i).get(2);
			int anchorLocation = memoryResultBlockInfo.get(memoryLocation).get(5);
			int startLocation  = anchorLocation;
			int endLocation = anchorLocation + (int)(unitSize*tempPC.processMap.get(i).get(0));
			memoryResultBlockInfo.get(memoryLocation).remove(5);
			memoryResultBlockInfo.get(memoryLocation).add(5,endLocation );;
			
			memoryResultBlock.get(memoryLocation).put(i, new ArrayList<Integer>(
					Arrays.asList(tempPC.processMap.get(i).get(0),startLocation,endLocation)));
		}
	}
}
