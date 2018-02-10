/*package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JScrollPane;

public class schedulingGraphs extends JFrame {

	private JPanel contentPane;
	private static CustomPanel chartPanel;
	private static JLabel avett;
	private static JLabel avewt;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					schedulingGraphs frame = new schedulingGraphs();
					frame.setVisible(true);
					
					 CPUScheduler scheduler;
					 scheduler = new FCFS();
					 scheduler.process();
					
		                
					 avewt.setText(Double.toString(scheduler.getAverageWaitingTime()));
		                avett.setText(Double.toString(scheduler.getAverageTurnAroundTime()));
		                
		                chartPanel.setTimeline(scheduler.getTimeline());
					
		                /* String selected = (String) option.getSelectedItem();
                CPUScheduler scheduler;
                
                switch (selected) {
                    case "FCFS":
                        scheduler = new FirstComeFirstServe();
                        break;

                       
                    default:
                        return;
                }
                
                for (int i = 0; i < model.getRowCount(); i++)
                {
                    String process = (String) model.getValueAt(i, 0);
                    int at = Integer.parseInt((String) model.getValueAt(i, 1));
                    int bt = Integer.parseInt((String) model.getValueAt(i, 2));
                    int pl;
        
                        pl = 1;
                    
                                        
                    scheduler.add(new Row(process, at, bt, pl));
                }
                
                scheduler.process();
                
                for (int i = 0; i < model.getRowCount(); i++)
                {
                    String process = (String) model.getValueAt(i, 0);
                    Row row = scheduler.getRow(process);
                    model.setValueAt(row.getWaitingTime(), i, 4);
                    model.setValueAt(row.getTurnaroundTime(), i, 5);
                }
                
               finalone yo= new finalone();
               //yo.scrollPanel= new JScrollPane(chartPanel);
                
                
                //wtResultLabel.setText(Double.toString(scheduler.getAverageWaitingTime()));
                //tatResultLabel.setText(Double.toString(scheduler.getAverageTurnAroundTime()));
              //  chartPanel= yo.scrollPanel;
                chartPanel.setTimeline(scheduler.getTimeline());
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public schedulingGraphs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(67, 215, 491, 240);
		textPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(textPane);
		
		JButton button = new JButton("Back to Main Menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainpage main = new mainpage();
				main.setVisible(true);
			}
			
		});
		button.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		button.setBounds(586, 468, 194, 37);
		contentPane.add(button);
		
		JLabel lblAveTurnaroundTime = new JLabel("Ave Turnaround Time :");
		lblAveTurnaroundTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAveTurnaroundTime.setBounds(560, 252, 139, 30);
		contentPane.add(lblAveTurnaroundTime);
		
		JLabel lblAveWaitingTime = new JLabel("Ave Waiting Time :");
		lblAveWaitingTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAveWaitingTime.setBounds(560, 320, 139, 30);
		contentPane.add(lblAveWaitingTime);
		
		JLabel avett = new JLabel("");
		avett.setFont(new Font("Tahoma", Font.PLAIN, 15));
		avett.setBounds(701, 252, 100, 30);
		contentPane.add(avett);
		
		JLabel avewt = new JLabel("");
		avewt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		avewt.setBounds(701, 320, 100, 30);
		contentPane.add(avewt);
		
		JScrollPane chartPane = new JScrollPane();
		chartPane.setBounds(67, 29, 744, 173);
		contentPane.add(chartPane);
		chartPanel = new CustomPanel();
		
	
	}
	
	
	    }
}
*/
