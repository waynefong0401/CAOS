package project;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainpage extends JFrame {
	
	
	private JPanel cards;
	private CardLayout cardLayout;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainpage frame = new mainpage();
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
	public mainpage() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1154, 773);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 73));
		lblWelcome.setBounds(420, 150, 374, 98);
		contentPane.add(lblWelcome);
		
		JLabel lblPleaseOneOf = new JLabel("Please one of the following options :");
		lblPleaseOneOf.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblPleaseOneOf.setBounds(285, 240, 599, 77);
		contentPane.add(lblPleaseOneOf);
		
		JButton btnMainMemoryAlgorithms = new JButton("Main Memory Algorithms");
		btnMainMemoryAlgorithms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnMainMemoryAlgorithms.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnMainMemoryAlgorithms.setBounds(343, 459, 451, 63);
		btnMainMemoryAlgorithms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, "memory");
				
			}
		});
		contentPane.add(btnMainMemoryAlgorithms);
		
		
		JButton btnCpuSchedulingAlgorithms = new JButton("CPU Scheduling Algorithms");
		btnCpuSchedulingAlgorithms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CPUscheduling cpu = new CPUscheduling();
				//cpu.setVisible(true);
				cardLayout.show(cards, "cpu");
			}
		});
		btnCpuSchedulingAlgorithms.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnCpuSchedulingAlgorithms.setBounds(340, 334, 451, 63);
		contentPane.add(btnCpuSchedulingAlgorithms);
		
		
		cards = new JPanel(new CardLayout());
		cards.add(contentPane,"main");
		JPanel cpu =  new CPUscheduling(cards).getJPanel();
		cards.add(cpu,"cpu");
		JPanel memory =  new Memory(cards).mainPanel;
		cards.add(memory,"memory");
		getContentPane().add(cards); 
		cardLayout = (CardLayout) cards.getLayout();
		cardLayout.show(cards, "main");
		setVisible(true);
	}
}
