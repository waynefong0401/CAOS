package project;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CPUscheduling extends JFrame {

	private JPanel contentPane;//fcfs
	private JTextField processid;
	private JTextField arrivaltime;
	private JTextField bursttime;
	private JLabel avett;
	private JLabel avewt;
	private CustomPanel chartPanel;
	
	public DefaultTableModel model ,model1;
	private JScrollPane tablePane;
	
	private JTable table; //priority
	private JTextField pid;
	private JTextField pat;
	private JTextField pbt;
	private JTable table_1;
	private JComboBox combobox;
	private JScrollPane scrollPane_2;
	private CustomPanel chartPanel2;
	private JLabel pavett, pavewt;
	private JTextField priority;
	CPUresult temp ;
	
	
	JPanel cards;
	private CardLayout cardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPUscheduling frame = new CPUscheduling();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CPUscheduling(JPanel cards) {
		this.cards = cards;
		cardLayout = (CardLayout) cards.getLayout();
		initialize();
			
		}
	public CPUscheduling() {
		initialize();
			
		}
	private void initialize() {
		setTitle("CPU Scheduling");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1154, 773);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 1112, 700);
		contentPane.add(tabbedPane);
		
		
		
		
		model = new DefaultTableModel (new String[] {"Process Id" , "Arrival Time", "Burst Time", "Priority Level","Waiting Time" , "Turn Around Time" } ,0);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("FCFS Scheduling", null, panel, null);
		panel.setLayout(null);
		
			JScrollPane tablePane_1 = new JScrollPane();
			tablePane_1.setBounds(452, 62, 631, 294);
			panel.add(tablePane_1);
			
			table = new JTable(model);
			table.setFillsViewportHeight(true);
			tablePane_1.setViewportView(table);
			
			
			
			JLabel lblNewLabel = new JLabel("Process Information :");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(102, 45, 230, 60);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Process ID : ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(72, 112, 119, 30);
			panel.add(lblNewLabel_1);
			
			JLabel lblArrivalTime = new JLabel("Arrival Time :");
			lblArrivalTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblArrivalTime.setBounds(72, 179, 119, 30);
			panel.add(lblArrivalTime);
			
			JLabel lblBurstTime = new JLabel("Burst Time :");
			lblBurstTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblBurstTime.setBounds(72, 244, 100, 30);
			panel.add(lblBurstTime);
			
			processid = new JTextField();
			processid.setBounds(198, 118, 186, 22);
			panel.add(processid);
			processid.setColumns(10);
			
			arrivaltime = new JTextField();
			arrivaltime.setColumns(10);
			arrivaltime.setBounds(198, 184, 186, 25);
			panel.add(arrivaltime);
			
			bursttime = new JTextField();
			bursttime.setColumns(10);
			bursttime.setBounds(198, 250, 186, 22);
			panel.add(bursttime);
			JLabel label_4 = new JLabel("Ave Turnaround Time :");
			label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label_4.setBounds(808, 473, 186, 30);
			panel.add(label_4);
			
			JLabel avett = new JLabel();
			avett.setFont(new Font("Tahoma", Font.PLAIN, 18));
			avett.setBounds(995, 473, 100, 30);
			panel.add(avett);
			
			JLabel label_6 = new JLabel("Ave Waiting Time :");
			label_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label_6.setBounds(808, 541, 161, 30);
			panel.add(label_6);
			
			JLabel avewt = new JLabel();
			avewt.setFont(new Font("Tahoma", Font.PLAIN, 18));
			avewt.setBounds(995, 541, 100, 30);
			panel.add(avewt);
			
			JButton btnNewButton = new JButton("Back to Main Menu");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					mainpage main = new mainpage();
//					main.setVisible(true);
					//cards.show(cards, "main");
					cardLayout.show(cards, "main");
					
				}
			});
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			btnNewButton.setBounds(52, 633, 194, 37);
			panel.add(btnNewButton);
			
			JButton btnStart = new JButton("Start");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					
					 CPUScheduler scheduler;
					 scheduler = new FCFS();
					 for (int i = 0; i < model.getRowCount(); i++)
	                {
	                    String process = (String) model.getValueAt(i, 0);
	                    int at = Integer.parseInt((String) model.getValueAt(i, 1));
	                    int bt = Integer.parseInt((String) model.getValueAt(i, 2));
	                    int pl;
	        
	                        pl = 1; //priority level =1, all the same
	                    
	                                        
	                    scheduler.add(new Row(process, at, bt, pl));
	                }
	                
	                scheduler.process();
	                
	                for (int i = 0; i < model.getRowCount(); i++)
	                {
	                    String process = (String) model.getValueAt(i, 0);
	                    temp = new CPUresult(scheduler.getTimeline());
	                    Row row = scheduler.getRow(process);
	                    model.setValueAt(temp.event.get(i).getwaitingTime(), i, 4);
	                    model.setValueAt(temp.event.get(i).getwaitingTime()+row.getBurstTime(), i, 5);
	                }
	                avett.setText(Double.toString(temp.getAveTurnAroundTime()));
	                //System.out.println(avett);
	                //System.out.println(avewt);
				
				avewt.setText(Double.toString(temp.getAveWaitingTime()));
					
					chartPanel.setTimeline(scheduler.getTimeline());
					
				}
			});
			
			btnStart.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			btnStart.setBounds(727, 379, 194, 37);
			panel.add(btnStart);
			
			JButton btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JTextField id = processid;
					JTextField arrivalT = arrivaltime;
					JTextField burstt = bursttime;
					
					model.addRow(new String[] {id.getText() , arrivalT.getText() ,burstt.getText() , "0" , "" ,""}); //0, priority, other 2 is wt and turnaround
					
					processid.setText("");
					arrivaltime.setText("");
					bursttime.setText("");
				}
			});
			btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			btnAdd.setBounds(123, 297, 173, 37);
			panel.add(btnAdd);
			
			JButton btnRemove = new JButton("Remove");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int row = table.getSelectedRow();
					if(row>-1)
					{
						model.removeRow(row);
					}
					
				}
			});
			btnRemove.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnRemove.setBounds(956, 13, 139, 42);
			panel.add(btnRemove);
			
			chartPanel = new CustomPanel();
			chartPanel.setBackground(Color.WHITE);
			JScrollPane chartPane = new JScrollPane(chartPanel);
			chartPane.setBounds(52, 447, 744, 173);
			panel.add(chartPane);
			
			
		
				
			
			JPanel panel_1 = new JPanel();
			tabbedPane.addTab("Non-Preemptive Priority Scheduling", null, panel_1, null);
			panel_1.setLayout(null);
			
			
			
	
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(420, 62, 663, 294);
			panel_1.add(scrollPane_1);
			model1 = new DefaultTableModel(new String[] {"Process ID", "Arrival Time","Burst Time", "Priority", "Waiting Time" ,"Turnaround Time"},0);
			table_1 = new JTable(model1);
			table_1.setFillsViewportHeight(true);
			scrollPane_1.setViewportView(table_1);
			
			JLabel label_8 = new JLabel("Ave Turnaround Time :");
			label_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label_8.setBounds(808, 473, 186, 30);
			panel_1.add(label_8);
			
			JLabel pavett = new JLabel();
			pavett.setFont(new Font("Tahoma", Font.PLAIN, 18));
			pavett.setBounds(995, 473, 100, 30);
			panel_1.add(pavett);
			
			JLabel label_10 = new JLabel("Ave Waiting Time :");
			label_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label_10.setBounds(808, 541, 161, 30);
			panel_1.add(label_10);
			
			JLabel pavewt = new JLabel();
			pavewt.setFont(new Font("Tahoma", Font.PLAIN, 18));
			pavewt.setBounds(995, 541, 100, 30);
			panel_1.add(pavewt);
			
			JLabel label = new JLabel("Process Information :");
			label.setFont(new Font("Tahoma", Font.PLAIN, 20));
			label.setBounds(101, 45, 230, 60);
			panel_1.add(label);
			
			JLabel label_1 = new JLabel("Process ID : ");
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label_1.setBounds(71, 112, 119, 30);
			panel_1.add(label_1);
			
			JLabel label_2 = new JLabel("Arrival Time :");
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label_2.setBounds(71, 179, 119, 30);
			panel_1.add(label_2);
			
			JLabel label_3 = new JLabel("Burst Time :");
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label_3.setBounds(71, 244, 100, 30);
			panel_1.add(label_3);
			
			pid = new JTextField();
			pid.setColumns(10);
			pid.setBounds(197, 118, 186, 22);
			panel_1.add(pid);
			
			pat = new JTextField();
			pat.setColumns(10);
			pat.setBounds(197, 184, 186, 25);
			panel_1.add(pat);
			
			pbt = new JTextField();
			pbt.setColumns(10);
			pbt.setBounds(197, 250, 186, 22);
			panel_1.add(pbt);
			
			JButton btnmain = new JButton("Back to Main Menu");
			btnmain.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			btnmain.setBounds(51, 633, 194, 37);
			btnmain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cardLayout.show(cards, "main");
					
				}
			});
			panel_1.add(btnmain);
			
			JButton pbtnstart = new JButton("Start");
			pbtnstart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CPUScheduler scheduler;
					 scheduler = new PriorityNonPreemptive();

					
					for (int i = 0; i < model1.getRowCount(); i++)
	                {
	                    String process = (String) model1.getValueAt(i, 0);
	                    int at = Integer.parseInt((String) model1.getValueAt(i, 1));
	                    int bt = Integer.parseInt((String) model1.getValueAt(i, 2));
	                    int pl;
	                    
	                   
	                    {
	                        if (!model1.getValueAt(i, 3).equals(""))
	                        {
	                            pl = Integer.parseInt((String) model1.getValueAt(i, 3));
	                        }
	                        else
	                        {
	                            pl = 1;
	                        }
	                    }
	                    
	                                        
	                    scheduler.add(new Row(process, at, bt, pl));
	                }
					 scheduler.process();
		                
		                for (int i = 0; i < model1.getRowCount(); i++)
		                {
		                    String process = (String) model1.getValueAt(i, 0);
		                    Row row = scheduler.getRow(process);
		                    model1.setValueAt(row.getWaitingTime(), i, 4);
		                    model1.setValueAt(row.getTurnaroundTime(), i, 5);
		                }
		                pavett.setText(Double.toString(scheduler.getAverageTurnAroundTime()) + " ms");
		                //System.out.println(avett);
		                //System.out.println(avewt);
					
					pavewt.setText(Double.toString(scheduler.getAverageWaitingTime()) +" ms");
						
						chartPanel2.setTimeline(scheduler.getTimeline());
				   
				}

			});
			pbtnstart.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			pbtnstart.setBounds(726, 379, 194, 37);
			panel_1.add(pbtnstart);
			
			JButton pbtnadd = new JButton("Add");
			pbtnadd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//model.addRow(new String[] {pid.getText(), pat.getText(), pbt.getText(), Integer.toString(combobox.getSelectedIndex()),"",""});
					model1.addRow(new String[] {pid.getText(), pat.getText(), pbt.getText(), priority.getText(),"",""});
					pid.setText("");
					pat.setText("");
					pbt.setText("");
					priority.setText("");
				}
			});
			pbtnadd.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			pbtnadd.setBounds(125, 379, 173, 37);
			panel_1.add(pbtnadd);
			
			JButton pbtnremove = new JButton("Remove");
			pbtnremove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table_1.getSelectedRow();
					if(row>-1)
					{
						model1.removeRow(row);
					}
				}
			});
			pbtnremove.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			pbtnremove.setBounds(934, 13, 139, 42);
			panel_1.add(pbtnremove);
			
			chartPanel2 = new CustomPanel();
			chartPanel2.setBackground(Color.WHITE);
			JScrollPane scrollPane_2 = new JScrollPane(chartPanel2);
			scrollPane_2.setBounds(51, 447, 744, 173);
			scrollPane_2.setBackground(Color.WHITE);
			panel_1.add(scrollPane_2);
			
			
		
			
			JLabel lblPriority = new JLabel("Priority :");
			lblPriority.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblPriority.setBounds(71, 296, 100, 30);
			panel_1.add(lblPriority);
			
			priority = new JTextField();
			priority.setColumns(10);
			priority.setBounds(197, 304, 186, 22);
			panel_1.add(priority);
		
	}
	class CustomPanel extends JPanel
    {   
        private List<Event> timeline;
        
        
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            
            if (timeline != null)
            {
            	CPUresult temp = new CPUresult(timeline);
                List<Event> timelineTemp=temp.eventResult;
                int anchor=30;
                for (int i = 0; i < timelineTemp.size(); i++)
                {
                	Event previousEvent;
                	if(i==0)
                		previousEvent = new Event("default",0,0);
                	else
                		previousEvent = timelineTemp.get(i-1);
                	
                    Event event = timelineTemp.get(i);
                    System.out.print("previousEvent : "+previousEvent.getFinishTime()+previousEvent.getStartTime());
                    System.out.print("event : "+event.getFinishTime()+event.getStartTime());
                    int y = 20;
                    if(previousEvent.getFinishTime()!=event.getStartTime())
                    {
                    	System.out.print("got idle : "+previousEvent.getFinishTime());
                    	g.drawRect(anchor, y, 30, 30);
                        g.setFont(new Font("Segoe UI", Font.BOLD, 13));
                        g.drawString("idle", anchor + 2, y + 20);
                        g.setFont(new Font("Segoe UI", Font.PLAIN, 11));
                        g.drawString(Integer.toString(previousEvent.getFinishTime()), anchor - 5, y + 45);
                        
                        anchor+=30;
                        
                        g.drawRect(anchor, y, 30, 30);
                        g.setFont(new Font("Segoe UI", Font.BOLD, 13));
                        g.drawString(event.getProcessid(), anchor + 10, y + 20);
                        g.setFont(new Font("Segoe UI", Font.PLAIN, 11));
                        g.drawString(Integer.toString(event.getStartTime()), anchor - 5, y + 45);
                        if (i == timelineTemp.size() - 1)
                        {
                            g.drawString(Integer.toString(event.getFinishTime()), anchor + 27, y + 45);
                        }
                        anchor+=30;
                    }
                    else
                    {
                    	g.drawRect(anchor, y, 30, 30);
                    	g.setFont(new Font("Segoe UI", Font.BOLD, 13));
                    	g.drawString(event.getProcessid(), anchor + 10, y + 20);
                    	g.setFont(new Font("Segoe UI", Font.PLAIN, 11));
                    	g.drawString(Integer.toString(event.getStartTime()), anchor - 5, y + 45);
                    
                    	if (i == timelineTemp.size() - 1)
                    	{
                    		g.drawString(Integer.toString(event.getFinishTime()), anchor + 27, y + 45);
                    	}
                    	anchor+=30;
                    }
//                    width += 30;
                }
                
//                this.setPreferredSize(new Dimension(width, 75));
            }
        }
        
        public void setTimeline(List<Event> timeline)
        {
            this.timeline = timeline;
            repaint();
        }
        
        
    }
	public JPanel getJPanel()
    {
    	return contentPane;
    }
}


