package project;

import java.applet.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;

import java.lang.*;

/*
<applet code="rectangle" height=500 width=700>
</applet>
*/

public class sampledisplay extends JFrame
{


int apw1[];
int p[];
int i=0,n,n1;
Graphics graphics= getGraphics();

public void init()
{
try
{



BufferedReader obj=new BufferedReader(new InputStreamReader (System.in));

System.out.println("ENTER no. of processes:");
 n=Integer.parseInt(obj.readLine());

int choice;
int bt[]=new int[n];


do{

  System.out.println("MENU FOR CPU SCHEDULING");
	System.out.println("1.FCFS method");
	System.out.println("2.SHORTEST JOB FIRST method(non-preemptive)");
	System.out.println("3.SHORTEST JOB FIRST method(preemptive)");
	System.out.println("4.ROUND ROBIN method");
	System.out.println("5.PRIORITY method (non-preemptive)");
	System.out.println("6.PRIORITY method (preemptive)");
	System.out.println("7.EXIT");
	System.out.println("ENTER YOUR CHOICE");

        choice=Integer.parseInt(obj.readLine());

	switch(choice)
	{
		case 1:

			{

			for( i=0;i<n;i++)
			{System.out.println("ENTER burst time for each process: p"+(i+1));
 			bt[i]=Integer.parseInt(obj.readLine());
			}
			n1=n;
			int turn[]=new int[n];
			apw1=new int[n+1];
			apw1[0]=0;
			float t=0;
			float tu=0;
			p=new int[n];
			for( i=1;i<=n;i++)
			apw1[i]=bt[i-1]+apw1[i-1];
			for( i=0;i<n;i++)
			{
			System.out.println("indivisual waiting time for process p"+(i+1)+"is"+apw1[i]+" ");
			}

			for(i=0;i<n;i++)
			{
			p[i]=i+1;
			System.out.print(p[i]);
                	}

			for( i=0;i<n;i++)
			t+=apw1[i];

			float avg=t/n;
			System.out.println("average waiting time is:"+avg);

			/*for( i=0;i<n;i++)
			System.out.println("response for process p"+(i+1)+"is"+apw1[i]+" ");*/

			for( i=0;i<n;i++)
			{
			turn[i]=bt[i]+apw1[i];
			System.out.println("turnaround time for process p"+(i+1)+"is"+turn[i]+" ");
			}

			for( i=0;i<n;i++)
			tu+=turn[i];

			float avg1=tu/n;
			System.out.println("average turn-around time is:"+avg1);


			paint(graphics);
			}



			break;

		case 2:
			{
			for( i=0;i<n;i++)
			{System.out.println("ENTER burst time for each process: p"+(i+1));
 			bt[i]=Integer.parseInt(obj.readLine());
			}
			n1=n;
			int temp;
			float t=0;
			int turn[]=new int[n];
			apw1=new int[n+1];
			apw1[0]=0;
			p=new int[n];
			int sj[]=new int[n];
			float tu=0;

			for( i=0;i<n;i++)
			sj[i]=bt[i];

			for( i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
			if(sj[i]>sj[j])
			{
			temp=sj[i];
			sj[i]=sj[j];
			sj[j]=temp;
			}



			for( i=0;i<n;i++)
			for(int j=0;j<n;j++)
			if(sj[i]==bt[j])
			p[i]=j+1;

			for(i=0;i<n;i++)
			apw1[i+1]=sj[i]+apw1[i];

			for( i=0;i<n;i++)
			{
			System.out.println("indivisual waiting time for process p"+p[i]+"is"+apw1[i]+" ");
			}

			for( i=0;i<n;i++)
			 t+=apw1[i];
			float avg=t/n;
			System.out.println("average waiting time is:"+avg);

			/*for( i=0;i<n;i++)
			System.out.println("response for process p"+p[i]+"is"+apw1[i]+" ");*/

			for( i=0;i<n;i++)
			{
			int k=p[i];
			turn[i]=bt[k-1]+apw1[i];
			System.out.println("turnaround time for process p"+p[i]+"is"+turn[i]+" ");
			}

			for( i=0;i<n;i++)
			tu+=turn[i];

			float avg1=tu/n;
			System.out.println("average turn-around time is:"+avg1);


			paint(graphics);

			}


			break;

	case 3:
				{

				int total=0,k=0,co=0,small=999,sp=0,sp1=0,x=0,count=0;
				int pro[][]=new int[n][3];
				int wt[]=new int[n];
				int wt1[]=new int[n];
				int bt1[]=new int[n];
				int tt[]=new int[n];
			 	apw1=new int [20];
			 	p=new int[20];

				for(int i=0;i<n;i++)
				{
				pro[i][0]=i;
				System.out.print("Burst Time for P"+i+" :");
				pro[i][1]=Integer.parseInt(obj.readLine());
				total+=pro[i][1];
				System.out.print("Arrival Time for P"+i+" :");
				pro[i][2]=Integer.parseInt(obj.readLine());
				}
				for(int i=0;i<n;i++)
				wt1[i]=pro[i][2];

				for(int i=0;i<n;i++)
				bt1[i]=pro[i][1];

				for(int i=0;i<n;i++)
				for(int j=i+1;j<n;j++)
					if(pro[i][2]>pro[j][2])
					{
						int temp[]=pro[i];
						pro[i]=pro[j];
						pro[j]=temp;
					}

				for(int i=1;i<=total;i++)
				{
				small=999;
				for(int j=co;j<n;j++)
					if(k>=pro[j][2])
					co++;
				for(int j=0;j<co;j++)
				{
					if(small>pro[j][1]&&pro[j][1]!=0)
					{
						small=pro[j][1];
						sp=pro[j][0];
						sp1=j;
					}
				}
				if(p[x]==sp)
				{
				apw1[x+1]++;

				}
				else
				{
				x++;
				p[x]=sp;
				apw1[x+1]=apw1[x];
				apw1[x+1]++;
				count++;
				}



				pro[sp1][1]-=1;
				if(pro[sp1][1]==0)
				tt[sp1]=i;
				for(int j=0;j<n;j++)
				{
					if(pro[j][1]!=0&&j!=sp)
						wt[j]+=1;
				}
				k++;
				}
				for(int i=0;i<n;i++)
				for(int j=i+1;j<n;j++)
					if(pro[i][0]>pro[j][0])
					{
						int temp[]=pro[i];
						pro[i]=pro[j];
						pro[j]=temp;
						int tem=wt[i],tem1=tt[i];
						wt[i]=wt[j];
						wt[j]=tem;
						tt[i]=tt[j];
						tt[j]=tem1;

					}

				System.out.println();

				for(int m=0;m<=count;m++)
				p[m]+=1;


				double awt=0.0,att=0.0;

				System.out.println();
				for (int i = 0; i<n; i++)
				{
				System.out.println("waiting time for process p "+i+"  "+(wt[i]-wt1[i]));
				awt+=(wt[i]-wt1[i]);
				att+=(wt[i]-wt1[i]+bt1[i]);
				}
				for (int i = 0; i<n; i++)
				{
				System.out.println("turnaround time for process p"+i+"  "+(wt[i]-wt1[i]+bt1[i]));
				}
				System.out.println("Average waiting time : "+(awt/n));
				System.out.println("Average turnaround time : "+(att/n));
				n1=count+1;
				paint(graphics);

				}
			break;

		case 4:
					{
					for( i=0;i<n;i++)
					{System.out.println("ENTER burst time for each process: p"+(i+1));
		 			bt[i]=Integer.parseInt(obj.readLine());
					}
					int ro[]=new int[n];
					apw1=new int[20];
		                	apw1[0]=0;

					int sq[]=new int[20];

					int temp;
					float t=0;
					float tu=0;
					int apw[]=new int[n];
					int bttime=0;
					int turn[]=new int[n];
					int f=0;

					for(i=0;i<n;i++)
					{
					ro[i]=bt[i];

					}


					p=new int[30];
					System.out.println("enter time quantum");
					int ts=Integer.parseInt(obj.readLine());
					int k=0;
					sq[k]=0;
					i=0;
					temp=ts;

					int count=0;

					do
					{

					if(ro[i]==0)
		       			{
			 		i++;
					sq[k]=sq[k-1]+temp;
					}

					else
		       			if(ro[i]>=ts)
					{
					ro[i]=ro[i]-ts;
					p[k]=i+1;
					k++;
					i++;
					temp=ts;
					sq[k]=sq[k-1]+temp;
					turn[i-1]=sq[k];

		     			f=0;
					for(int m=0;m<n;m++)
					f+=ro[m];

					count++;
					}

		       			else
					if(ro[i]>0 && ro[i]<ts)
					{
			  		temp=ro[i];
			  		ro[i]=0;
					p[k]=i+1;
					i++;
					k++;
					sq[k]=sq[k-1]+temp;
					turn[i-1]=sq[k];

					f=0;
					for(int m=0;m<n;m++)
					f+=ro[m];

					count++;

					}

					if(i==n)
					i=0;


					}while(f!=0);


					System.out.println();

					for(i=0;i<=count;i++)
					{
					apw1[i]=sq[i];
					}

					System.out.println();


					for(i=0;i<n;i++)
		   			{
		    			apw[i]=turn[i]-bt[i];
		    			t+=apw[i];
		    			tu+=turn[i];
		   			}

					for(i=0;i<n;i++)
					System.out.println(" waiting time for p"+(i+1)+"is:"+apw[i]);

					float avg=t/n;
					System.out.println("average waiting time is:"+avg);


					for(i=0;i<n;i++)
					System.out.println("turn around time is:"+turn[i]);



					float avg1=tu/n;
					System.out.println("average turn-around time is:"+avg1);


		   			n1=count;



					paint(graphics);



					}
			break;


		case 5:
			{
			for( i=0;i<n;i++)
			{System.out.println("ENTER burst time for each process: p"+(i+1));
 			bt[i]=Integer.parseInt(obj.readLine());
			}
			n1=n;
			int pr[]=new int[n];
			int pr1[]=new int[n];
			float t=0;
			int temp;
			int turn[]=new int[n];
			p=new int[n];
			apw1=new int[n+1];
			apw1[0]=0;
			float tu=0;


			for(i=0;i<n;i++)
			{
			System.out.println("Enter the priority for p"+(i+1));
			pr[i]=Integer.parseInt(obj.readLine());
			}

			for(i=0;i<n;i++)
			{
			pr1[i]=pr[i];
			}

			for( i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
			if(pr1[i]>pr1[j])
			{
			temp=pr1[i];
			pr1[i]=pr1[j];
			pr1[j]=temp;
			}

			for( i=0;i<n;i++)
			for(int j=0;j<n;j++)
			if(pr1[i]==pr[j])
			p[i]=j+1;

			for(i=0;i<n;i++)
			{
			int k=p[i];
			apw1[i+1]=bt[k-1]+apw1[i];
			}

			for( i=0;i<n;i++)
			{
			System.out.println("indivisual waiting time for process p"+p[i]+"is"+apw1[i]+" ");
			}

			for( i=0;i<n;i++)
			t+=apw1[i];
			float avg=t/n;
			System.out.println("average waiting time is:"+avg);

			/*for( i=0;i<n;i++)
			System.out.println("response for process p"+p[i]+"is"+apw1[i]+" ");*/


			for( i=0;i<n;i++)
			{
			int k=p[i];
			turn[i]=bt[k-1]+apw1[i];
			System.out.println("turnaround time for process p"+p[i]+"is"+turn[i]+" ");
			}

			for( i=0;i<n;i++)
			tu+=turn[i];

			float avg1=tu/n;
			System.out.println("average turn-around time is:"+avg1);


			paint(graphics);

			}

			break;


		case 6:

			{
			int total=0,k=0,co=0,small=999,sp=0,sp1=0,x=0,count=0;
			int pro[][]=new int[n][4];
			int wt[]=new int[n];
			int wt1[]=new int[n];
			int bt1[]=new int[n];
			int tt[]=new int[n];
		 	apw1=new int [20];
		 	p=new int[20];

			for(int i=0;i<n;i++)
			{
			pro[i][0]=i;
			System.out.print("Burst Time for P"+i+" :");
			pro[i][3]=Integer.parseInt(obj.readLine());
			total+=pro[i][3];
			System.out.print("Arrival Time for P"+i+" :");
			pro[i][2]=Integer.parseInt(obj.readLine());
			System.out.print("Priority for P"+i+" :");
			pro[i][1]=Integer.parseInt(obj.readLine());

			}
			for(int i=0;i<n;i++)
			wt1[i]=pro[i][2];

			for(int i=0;i<n;i++)
			bt1[i]=pro[i][3];

			for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				if(pro[i][2]>pro[j][2])
				{
					int temp[]=pro[i];
					pro[i]=pro[j];
					pro[j]=temp;
				}

			for(int i=1;i<=total;i++)
			{
			small=999;
			for(int j=co;j<n;j++)
				if(k>=pro[j][2])
				co++;
			for(int j=0;j<co;j++)
			{
				if(small>pro[j][1]&&pro[j][3]!=0)
				{
					small=pro[j][1];
					sp=pro[j][0];
					sp1=j;
				}
			}
			if(p[x]==sp)
			{
			apw1[x+1]++;

			}
			else
			{
			x++;
			p[x]=sp;
			apw1[x+1]=apw1[x];
			apw1[x+1]++;
			count++;
			}



			pro[sp1][3]-=1;
			if(pro[sp1][3]==0)
			tt[sp1]=i;
			for(int j=0;j<n;j++)
			{
				if(pro[j][3]!=0&&j!=sp)
					wt[j]+=1;
			}
			k++;
			}
			for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				if(pro[i][0]>pro[j][0])
				{
					int temp[]=pro[i];
					pro[i]=pro[j];
					pro[j]=temp;
					int tem=wt[i],tem1=tt[i];
					wt[i]=wt[j];
					wt[j]=tem;
					tt[i]=tt[j];
					tt[j]=tem1;

				}

			System.out.println();

			for(int m=0;m<=count;m++)
			p[m]+=1;


			double awt=0.0,att=0.0;

			System.out.println();
			for (int i = 0; i<n; i++)
			{
			System.out.println("waiting time for process p "+i+"  "+(wt[i]-wt1[i]));
			awt+=(wt[i]-wt1[i]);
			att+=(wt[i]-wt1[i]+bt1[i]);
			}
			for (int i = 0; i<n; i++)
			{
			System.out.println("turnaround time for process p"+i+"  "+(wt[i]-wt1[i]+bt1[i]));
			}
			System.out.println("Average waiting time : "+(awt/n));
			System.out.println("Average turnaround time : "+(att/n));
			n1=count+1;
			paint(graphics);

			}



 	}

   } while(choice!=7);




}

catch (Exception e)
{}

}

public void paint(Graphics g)
{




for(int j=1;j<=n1;j++)
{

g.drawRect(50,50,(apw1[j]*20),30);
g.drawString("p"+p[j-1],(55+(apw1[j-1]*20)),70);
g.drawString(""+apw1[j-1],50+(apw1[j-1]*20),100);
}
g.drawString(""+apw1[n1],50+(apw1[n1]*20),100);




}

}
