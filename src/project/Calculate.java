package project;
import java.util.List;
import java.util.Map.Entry;

public class Calculate {
	
	MemoryBlock memory = new MemoryBlock();
	Process process = new Process();
	
 	public void handleMemoryBestFit(MemoryBlock objMemory,Process objProcess)
	{
		int tempSize = Integer.MAX_VALUE,tempIndex = Integer.MAX_VALUE;
		objMemory.generateBlock();
		objProcess.generateProcess();
		for(Entry<Integer, List<Integer>> individualProcess:objProcess.processMap.entrySet())
		{
			List<Integer> processInfo = individualProcess.getValue();
			for(int loopControl = 0; loopControl < objMemory.block.size();loopControl++)
			{
				int blockSize = objMemory.block.get(loopControl).get(1);
				if(processInfo.get(0) <= blockSize)
				{
					if(tempSize>blockSize)
					{
						tempSize = blockSize;
						tempIndex = loopControl;
					}
				}
			}
			if(tempIndex==Integer.MAX_VALUE)
			{
				objProcess.processFailed(individualProcess.getKey());
				continue;
			}
			objMemory.updateMemoryBlock(tempIndex,processInfo.get(0));
			objProcess.updateProcessMap(individualProcess.getKey(),tempIndex);
			tempSize = Integer.MAX_VALUE;
			tempIndex = Integer.MAX_VALUE;
		}
		this.process=objProcess;
		this.memory = objMemory;
	}
 	
 	public void handleMemoryFirstFit(MemoryBlock objMemory,Process objProcess)
	{
 		
		int tempIndex = Integer.MAX_VALUE;
		objMemory.generateBlock();
		objProcess.generateProcess();
		for(Entry<Integer, List<Integer>> individualProcess:objProcess.processMap.entrySet())
		{
			List<Integer> processInfo = individualProcess.getValue();
			for(int loopControl = 0; loopControl < objMemory.block.size();loopControl++)
			{
				int blockSize = objMemory.block.get(loopControl).get(1);
				//System.out.println("free block size : "+blockSize);
				if(processInfo.get(0) <= blockSize)
				{
						tempIndex = loopControl;
						break;
				}
			}
			if(tempIndex==Integer.MAX_VALUE)
			{
				objProcess.processFailed(individualProcess.getKey());
				continue;
			}
			objMemory.updateMemoryBlock(tempIndex,processInfo.get(0));
			objProcess.updateProcessMap(individualProcess.getKey(),tempIndex);
			tempIndex = Integer.MAX_VALUE;
		}
		this.process=objProcess;
		this.memory = objMemory;
	}
 	
 	public void handleMemoryWorstFit(MemoryBlock objMemory,Process objProcess)
	{
		int tempSize = Integer.MIN_VALUE,tempIndex = Integer.MIN_VALUE;
		objMemory.generateBlock();
		objProcess.generateProcess();
		for(Entry<Integer, List<Integer>> individualProcess:objProcess.processMap.entrySet())
		{
			List<Integer> processInfo = individualProcess.getValue();
			for(int loopControl = 0; loopControl < objMemory.block.size();loopControl++)
			{
				int blockSize = objMemory.block.get(loopControl).get(1);
				//System.out.println("free block size : "+blockSize);
				if(processInfo.get(0) <= blockSize)
				{
					if(tempSize<blockSize)
					{
						tempSize = blockSize;
						tempIndex = loopControl;
					}
				}
			}
			if(tempIndex==Integer.MIN_VALUE)
			{
				objProcess.processFailed(individualProcess.getKey());
				continue;
			}
			objMemory.updateMemoryBlock(tempIndex,processInfo.get(0));
			objProcess.updateProcessMap(individualProcess.getKey(),tempIndex);
			tempSize = Integer.MIN_VALUE;
			tempIndex = Integer.MIN_VALUE;
		}
		this.process=objProcess;
		this.memory = objMemory;
	}
 	
 	
 	MemoryBlock getMemoryResult()
 	{
 		return this.memory;
 	}

 	Process getProcessResult()
 	{
 		return this.process;
 	}
}
