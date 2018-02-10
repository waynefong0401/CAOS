package project;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JComponent;

public class drawMemoryBlock extends JComponent
{
		Graphics2D g2;
		Rectangle rect1;
		Graphics graphics;
		int height,width;
		
     @Override
     public void paintComponent(Graphics g) {
    	 g2 = (Graphics2D) g;
         rect1 = new Rectangle(0,0,getWidth()-1,getHeight()-1);
         g2.draw(rect1);
     }
     void drawBlock(MemoryBlock memoryBlock){
    	 graphics = getGraphics();
   		HashMap<Integer,Integer> allBlock = memoryBlock.getAllBlock1();
   		int totalSize=0;
   		double currentY = 0;
   		double tempY;
   		for(Entry<Integer, Integer> individualBlock:allBlock.entrySet())
   			totalSize += individualBlock.getValue();
   		for(Entry<Integer, Integer> individualBlock:allBlock.entrySet())
   		{
   			double y = individualBlock.getValue()*1.0/totalSize;
   			tempY=currentY;
   			currentY+=rect1.getHeight()*y;
   			graphics.drawLine((int)rect1.getX()+1, (int)currentY, (int)rect1.getWidth()-1, (int)currentY);
   			graphics.drawString(individualBlock.getValue().toString(),(int)(rect1.getWidth()/2.0)-5 , (int)(rect1.getHeight()*y/2+tempY)+3);
   		}
 	}
     
     void drawResultBlock(HashMap<Integer,List<Integer>> blockInfo, HashMap<Integer,HashMap<Integer,List<Integer>>> blockDetails)
     {
    	graphics = getGraphics();
  		double currentY = 0;
  		double tempY;
  		for(Entry<Integer, List<Integer>> individualBlock:blockInfo.entrySet())
  		{
  			if(individualBlock.getValue().get(1)==0)
  				continue;
  			currentY=individualBlock.getValue().get(4)*rect1.getHeight()/10000.0;
  			Graphics2D g3 = (Graphics2D)graphics;
   	        g3.setStroke(new BasicStroke(3));
   	        g3.drawLine((int)rect1.getX()+1, (int)currentY, (int)rect1.getWidth()-1, (int)currentY);   //thick
  			currentY=individualBlock.getValue().get(4)*rect1.getHeight()/10000.0;
				tempY = individualBlock.getValue().get(5)*rect1.getHeight()/10000.0;
				if(individualBlock.getValue().get(1)==0)
					continue;
  			graphics.drawString(individualBlock.getValue().get(1).toString(), (int)(rect1.getWidth()/2.0)-5, (int)((tempY+currentY)/2)+3);
  		}
  		for(Entry<Integer, HashMap<Integer, List<Integer>>> blockdetail : blockDetails.entrySet())
  		{
  			for(Entry<Integer, List<Integer>> process : blockdetail.getValue().entrySet())
  			{
  				int start = process.getValue().get(1);
  				int end = process.getValue().get(2);
  				currentY=end*rect1.getHeight()/10000.0;
  				tempY = start*rect1.getHeight()/10000.0;
  				graphics.setColor(Color.gray);
  				graphics.fillRect((int)rect1.getX(), (int)tempY, (int)rect1.getWidth(), (int)(currentY-tempY));;
  				graphics.setColor(Color.black);
  				Graphics2D g3= (Graphics2D)graphics;
  	   	        g3.setStroke(new BasicStroke(3));
  	   	        g3.drawLine((int)rect1.getX()+1, (int)currentY, (int)rect1.getWidth()-1, (int)currentY);   //thick
  				graphics.drawString(process.getKey().toString()+" : "+process.getValue().get(0).toString(), (int)(rect1.getWidth()/2.0)-10, (int)((tempY+currentY)/2)+3);
  			}
  		}
  	}
     
 	void clearGraphic()
 	{
 		graphics = getGraphics();
 		graphics.clearRect((int)rect1.getX()+1,(int)rect1.getY()+1,(int)rect1.getWidth()-1,(int)rect1.getHeight()-1);
 	}
}
