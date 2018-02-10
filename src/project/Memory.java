package project;

import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.Font;

public class Memory {
	
	private JFrame frmMemoryManagement;
	
	JPanel cards;
	JPanel mainPanel;
	private JPanel blockPanel;
	private JPanel taskPanel;
	private JPanel ResultPanel;
	
	private CardLayout cardLayout;
	
	private MemoryBlock memoryBlock = new MemoryBlock();
	private Process process = new Process();
	private Calculate cal = new Calculate();
	
	private JNumberTextField txtTaskSequence;
	private JNumberTextField txtTaskSize;
	private JNumberTextField txtBlockSize;
	
	Graphics graphics,resultGraphics;
	drawMemoryBlock db = new drawMemoryBlock();
	drawMemoryBlock drawMemoryBlock_ = new drawMemoryBlock();
	
	private JTable table_1;
	private JTable table;
	JLabel lblExternal,lblInternal;
	
	private DefaultTableModel modelTable = new DefaultTableModel(new Object[][] {},new String[] {"Sequence", "Size"})//Model for table
	{
	    @Override
	    public boolean isCellEditable(int row, int column) {//Make the table not editable
	       return false;
	    }};
	    
	private DefaultTableModel modelTableResult = new DefaultTableModel(new Object[][] {},new String[] {"Sequence", "Size","Location"})//Model for result table
	{
	    @Override
	    public boolean isCellEditable(int row, int column) {//Make the table not editable
	    	return false;
	    }};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Memory window = new Memory();
					window.frmMemoryManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Memory(JPanel cards) {
		this.cards = cards;
		cardLayout = (CardLayout) cards.getLayout();
		initialize();
	}
	
	public Memory() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmMemoryManagement = new JFrame();
		frmMemoryManagement.setTitle("Memory Management");
		frmMemoryManagement.setBounds(100, 100, 1154, 773);
		frmMemoryManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMemoryManagement.getContentPane().setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1138, 734);
		mainPanel.setLayout(null);
		frmMemoryManagement.getContentPane().add(mainPanel);
		
		/*************blockPanel*************/
		blockPanel = new JPanel();
		blockPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Memory Block", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		blockPanel.setLayout(null);
		blockPanel.setToolTipText("");
		blockPanel.setBounds(10, 11, 347, 488);
		mainPanel.add(blockPanel);
		
		db.setBounds(10, 113, 327, 364);//drawBlock
		blockPanel.add(db);
		
		ActionListener addBlockSize = new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(txtBlockSize.getText().isEmpty())//No text
		    		return;
		    	if(Integer.parseInt(txtBlockSize.getText())==0)//Enter 0s
		    	{
		    		txtBlockSize.setText("");
				  	txtBlockSize.requestFocusInWindow();
				  	return;
		    	}
		    	memoryBlock.addMemoryBlock(Integer.parseInt(txtBlockSize.getText()));
				  txtBlockSize.setText("");
				  txtBlockSize.requestFocusInWindow();
				  db.clearGraphic();
				  db.drawBlock(memoryBlock);
		    }
		};
		
		JButton btnAddBlock = new JButton("Add");
		btnAddBlock.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddBlock.setBounds(36, 67, 126, 35);
		blockPanel.add(btnAddBlock);
		btnAddBlock.addActionListener(addBlockSize);
		
		JButton btnClearBlock = new JButton("Clear");
		btnClearBlock.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnClearBlock.setBounds(187, 67, 126, 35);
		blockPanel.add(btnClearBlock);
		btnClearBlock.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  txtBlockSize.setText("");
			  }
		});
		
		txtBlockSize = new JNumberTextField();
		txtBlockSize.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtBlockSize.setColumns(10);
		txtBlockSize.setBounds(186, 36, 133, 24);
		txtBlockSize.addActionListener(addBlockSize);
		blockPanel.add(txtBlockSize);
		
		JLabel label_2 = new JLabel("Size : ");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(36, 33, 78, 23);
		blockPanel.add(label_2);
		/**********End of blockPanel*********/
		
		/*************taskPanel*************/
		taskPanel = new JPanel();
		taskPanel.setLayout(null);
		taskPanel.setToolTipText("");
		taskPanel.setBorder(new TitledBorder(null, "Task", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.controlDkShadow));
		taskPanel.setBounds(367, 11, 340, 488);
		mainPanel.add(taskPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 134, 320, 289);
		taskPanel.add(scrollPane);

		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setModel(modelTable);
		table_1.setBounds(10, 112, 205, 268);
		
		scrollPane.setViewportView(table_1);
		
		ActionListener addTaskSequence = new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(txtTaskSequence.getText().isEmpty())//No text
		    		return;
				txtTaskSize.requestFocusInWindow();
		    }
		};
		
		ActionListener addTaskSize = new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(txtTaskSequence.getText().isEmpty()||txtTaskSize.getText().isEmpty())//No text
		    		return;
		    	if(Integer.parseInt(txtTaskSize.getText())==0)//Enter 0s
		    	{
		    		txtTaskSize.setText("");
		    		txtTaskSize.requestFocusInWindow();
				  	return;
		    	}
				  process.addProcess(Integer.parseInt(txtTaskSequence.getText()), Integer.parseInt(txtTaskSize.getText()));
				  modelTable.setRowCount(0);
				  for (Entry<Integer, Integer> entry : process.getAllProcess1().entrySet()) {
					    //System.out.println(entry.getKey() + ", " + entry.getValue()+"\n");
					    modelTable.addRow(new Object[]{entry.getKey(),entry.getValue()});
					}
				  txtTaskSequence.setText("");
				  txtTaskSize.setText("");
				  txtTaskSequence.requestFocusInWindow();
		    }
		};
		
		ActionListener deleteTask = new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	process.deleteProcess((int)table_1.getValueAt(table_1.getSelectedRow(), 0));
		    	modelTable.setRowCount(0);
				  for (Entry<Integer, Integer> entry : process.getAllProcess1().entrySet()) {
					    //System.out.println(entry.getKey() + ", " + entry.getValue()+"\n");
					  modelTable.addRow(new Object[]{entry.getKey(),entry.getValue()});
					}
		    }
		};
		
		JButton btnAddTask = new JButton("Add");
		btnAddTask.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddTask.setBounds(30, 88, 126, 35);
		taskPanel.add(btnAddTask);
		btnAddTask.addActionListener(addTaskSize);
		
		JButton btnDeleteTask = new JButton("Delete");
		btnDeleteTask.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDeleteTask.setBounds(73, 434, 205, 43);
		taskPanel.add(btnDeleteTask);
		btnDeleteTask.addActionListener(deleteTask);
		
		JButton btnClearTask = new JButton("Clear");
		btnClearTask.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnClearTask.setBounds(186, 88, 126, 35);
		taskPanel.add(btnClearTask);
		btnClearTask.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  txtTaskSize.setText("");
				  txtTaskSequence.setText("");
			  }
		});
		
		txtTaskSequence = new JNumberTextField();
		txtTaskSequence.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtTaskSequence.setColumns(10);
		txtTaskSequence.setBounds(186, 26, 133, 24);
		txtTaskSequence.addActionListener(addTaskSequence);
		taskPanel.add(txtTaskSequence);
		
		txtTaskSize = new JNumberTextField();
		txtTaskSize.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtTaskSize.setColumns(10);
		txtTaskSize.addActionListener(addTaskSize);
		txtTaskSize.setBounds(186, 57, 133, 24);
		taskPanel.add(txtTaskSize);
		
		JLabel label = new JLabel("Sequence : ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(30, 29, 113, 17);
		taskPanel.add(label);
		JLabel label_1 = new JLabel("Size : ");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(30, 53, 88, 24);
		taskPanel.add(label_1);
		
		/**********End of taskPanel*********/
		
		/*************ResultPanel*************/
		ResultPanel = new JPanel();
		ResultPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Result", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		ResultPanel.setBounds(717, 11, 411, 712);
		mainPanel.add(ResultPanel);
		ResultPanel.setLayout(null);
		
		drawMemoryBlock_.setBounds(10, 348, 391, 353);
		ResultPanel.add(drawMemoryBlock_);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 23, 391, 264);
		ResultPanel.add(scrollPane_1);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(modelTableResult);
		table.setBounds(0, 0, 203, 1);
		
		scrollPane_1.setViewportView(table);
		
		lblInternal = new JLabel("Internal Fragmentation : ");
		lblInternal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInternal.setBounds(10, 298, 304, 14);
		ResultPanel.add(lblInternal);
		
		lblExternal = new JLabel("External Fragmentation : ");
		lblExternal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblExternal.setBounds(10, 323, 304, 14);
		ResultPanel.add(lblExternal);
		/**********End of ResultPanel*********/
		
		/*************selectionPanel*************/
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBounds(10, 510, 697, 213);
		selectionPanel.setBorder(new TitledBorder(null, "Select", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.controlDkShadow));
		mainPanel.add(selectionPanel);
		selectionPanel.setLayout(null);
		
		ActionListener resetAll = new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	drawMemoryBlock_.clearGraphic();
		    	db.clearGraphic();
		    	//drawMemoryBlock_.clearGraphic();
		    	memoryBlock.clearBlock();
		    	memoryBlock.clearBlock1();
		    	process.clearProcess();
		    	modelTable.setRowCount(0);
		    	modelTableResult.setRowCount(0);
		    	lblInternal.setText("Internal Fragmentation : ");
		    	lblExternal.setText("External Fragmentation : ");
		    }
		};
		
		JRadioButton rbtnBest = new JRadioButton("Best Fit");
		rbtnBest.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rbtnBest.setSelected(true);
		rbtnBest.setBounds(148, 42, 109, 23);
		selectionPanel.add(rbtnBest);
		
		JRadioButton rbtnFirst = new JRadioButton("First Fit");
		rbtnFirst.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rbtnFirst.setBounds(148, 94, 109, 23);
		selectionPanel.add(rbtnFirst);
		
		JRadioButton rbtnWorst = new JRadioButton("Worst Fit");
		rbtnWorst.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rbtnWorst.setBounds(148, 146, 109, 23);
		selectionPanel.add(rbtnWorst);
		
		ButtonGroup bgroup = new ButtonGroup();
	     bgroup.add(rbtnBest);
	     bgroup.add(rbtnFirst);
	     bgroup.add(rbtnWorst);
	     
	    JButton btnGo = new JButton("Go");
		btnGo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGo.setBounds(375, 86, 154, 39);
		selectionPanel.add(btnGo);
		btnGo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(rbtnBest.isSelected())
					cal.handleMemoryBestFit(memoryBlock, process);
				else if(rbtnFirst.isSelected())
					cal.handleMemoryFirstFit(memoryBlock, process);
				else
					cal.handleMemoryWorstFit(memoryBlock, process);
				printResult();
				  }
		});
			  
		JButton button = new JButton("Clear All");
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBounds(375, 34, 154, 39);
		selectionPanel.add(button);
		        
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, "main");
		    }});
		btnBack.setBounds(375, 143, 154, 39);
		selectionPanel.add(btnBack);
		button.addActionListener(resetAll);
		/**********End of selectionPanel*********/
	}
	void printResult()
	{
		  MemoryBlock tempBlock = cal.getMemoryResult();
		  Process tempProcess = cal.getProcessResult();
		  MemoryResult mr = new MemoryResult(tempBlock,tempProcess);
		  drawMemoryBlock_.clearGraphic();
		  drawMemoryBlock_.drawResultBlock(mr.memoryResultBlockInfo,mr.memoryResultBlock);
		  modelTableResult.setRowCount(0);
		  for (Entry<Integer, List<Integer>> entryProcess : mr.pc.getAllProcess().entrySet()) {
			if(entryProcess.getValue().get(2)==-1)
			{
				modelTableResult.addRow(new Object[]{entryProcess.getKey(),entryProcess.getValue().get(0),"Not located"});
				continue;
			}
			modelTableResult.addRow(new Object[]{entryProcess.getKey(),entryProcess.getValue().get(0),entryProcess.getValue().get(2)});
		  }
		  int internalFragmentation=0,externalFragmentation=0;
		  if(mr.oversizeProcess.isEmpty())
		  {
			  for(Entry<Integer,List<Integer>> entry : mr.memoryResultBlockInfo.entrySet())
			  {
				  if(entry.getValue().get(0)==entry.getValue().get(1))
					  continue;
				  else
					  internalFragmentation+=entry.getValue().get(1);
			  }
			  lblExternal.setText("External Fragmentation : 0");
		  }
		  else
		  {
			  for(Entry<Integer,List<Integer>> entry : mr.memoryResultBlockInfo.entrySet())
			  {
				  if(entry.getValue().get(0)==entry.getValue().get(1))
					  externalFragmentation+=entry.getValue().get(1);
				  else
					  internalFragmentation+=entry.getValue().get(1);
			  }
			  lblExternal.setText("External Fragmentation : "+externalFragmentation);
		  }
		  lblInternal.setText("Internal Fragmentation : "+internalFragmentation);
	}
}
