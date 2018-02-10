package project;

import java.util.*;
import java.util.Map.Entry;
import java.lang.Integer;

public class MemoryBlock
{
	HashMap<Integer,List<Integer>> block = new HashMap<Integer,List<Integer>>();
	HashMap<Integer,Integer> block1 = new HashMap<Integer,Integer>();
	//Key is the ID of Block
	//Value is the size of block
	//use block1 to generate the result block
	MemoryBlock()
	{

	}
	public void addMemoryBlock(Integer size)
	{
		if(block1.isEmpty())
			block1.put(0,size);//If block is empty, put newblock in the first key position
		else
			block1.put(block1.size(),size);//Else, append newblock in the end
	}
	
	HashMap<Integer,List<Integer>> getAllBlock()
	{
		return block;
	}
	
	HashMap<Integer,Integer> getAllBlock1()
	{
		return block1;
	}
	
	public boolean clearBlock()
	{
		block.clear();
		return true;
	}
	
	public boolean clearBlock1()
	{
		block1.clear();
		return  true;
	}
	
	public void generateBlock()
	{
		block.clear();
		for(Entry<Integer, Integer> entry : block1.entrySet())
		{
			List<Integer> newBlock = new ArrayList<Integer>();
			//This List contain 3 value
			newBlock.add(entry.getValue());//0. size of block
			newBlock.add(entry.getValue());//1. free space in block
			newBlock.add(0);//	 2. used space in block
			block.put(entry.getKey(), newBlock);
				
		}
		
	}
	public void updateMemoryBlock(Integer index,Integer processSize)
	{
		List<Integer> updatedBlock = block.get(index);
		updatedBlock.set(1,updatedBlock.get(1)-processSize);//update free space in block(free space - process size)
		updatedBlock.set(2,processSize+updatedBlock.get(2)); //update used space in block(used space + process size)
		block.put(index,updatedBlock);
	}
}