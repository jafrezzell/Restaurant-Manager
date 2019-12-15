package GUI;

import Classes.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ServerGUI extends JFrame {

	//variables
	private int tableNum;
	
	//other GUI
	OrderPageGUI ordersPage;
	static KitchenGUI kitchen;
	
	//componenents
	private JPanel contentPane;
	private JButton btnOrder;
	private JButton btnPay;
	private JList lstTables;

	//Models for components
	DefaultListModel<Table> TableList = new DefaultListModel<Table>();
	
	//tables for the servers to use
	Table table1;
	Table table2;
	Table table3;
	Table table4;
	Table table5;
	Table table6;
	private JScrollPane spTables;
	private JLabel lblEmployeeId;
	private JLabel lblTableTotal;
	private JLabel lblTipAmount;
	private JLabel lblTotal;
	private JTextField txtEmpID;
	private JTextField txtTableTotal;
	private JTextField txtTipAmount;
	private JTextField txtTotal;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGUI frame = new ServerGUI();
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
	public ServerGUI() {
		setTitle("Servers");
		
		Initialize();
		InitializeCode();
		kitchen.setVisible(true);
		Events();
		
		
	}

	@SuppressWarnings("unchecked")
	private void Initialize() {
		
		//GUI pages
		kitchen = new KitchenGUI();
		ordersPage = new OrderPageGUI(kitchen);
		
		//default
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		//Labels
		//Tables
		JLabel lblTables = new JLabel("Tables:");
		
		//buttons
		//take order
		btnOrder = new JButton("Order");
		
		//cash out the table/ pay
		btnPay = new JButton("Pay");

		initTableList();
		
		spTables = new JScrollPane();
		
		lblEmployeeId = new JLabel("Employee ID:");
		
		lblTableTotal = new JLabel("Current Table Total:");
		
		lblTipAmount = new JLabel("Tip Amount:");
		
		lblTotal = new JLabel("Total:");
		
		txtEmpID = new JTextField();
		txtEmpID.setColumns(10);
		
		txtTableTotal = new JTextField("0.00");
		txtTableTotal.setEditable(false);
		txtTableTotal.setColumns(10);
		
		txtTipAmount = new JTextField("0.00");


		txtTipAmount.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);


		
		//group layout for the JFrame
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTables)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(spTables, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTotal)
									.addPreferredGap(ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
									.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTipAmount)
									.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
									.addComponent(txtTipAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTableTotal)
									.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
									.addComponent(txtTableTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnOrder)
									.addPreferredGap(ComponentPlacement.RELATED, 353, Short.MAX_VALUE)
									.addComponent(btnPay))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEmployeeId)
									.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
									.addComponent(txtEmpID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblTables)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(spTables, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtEmpID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmployeeId))
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTableTotal)
								.addComponent(txtTableTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTipAmount)
								.addComponent(txtTipAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTotal)
								.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnPay)
								.addComponent(btnOrder))))
					.addContainerGap())
		);
		
		lstTables = new JList<Table>(TableList);

		spTables.setViewportView(lstTables);
		contentPane.setLayout(gl_contentPane);
		
		lstTables.setSelectedIndex(0);
	
		
		
	}
	
	private void InitializeCode() {
		tableNum = -1;
	}
	
	private void initTableList() {
		//initialize the tables
		table1 = new Table(1);
		table2 = new Table(2);
		table3 = new Table(3);
		table4 = new Table(4);
		table5 = new Table(5);
		table6 = new Table(6);
		
		//initialize the TablesList to have the tables we want
		TableList.addElement(table1);
		TableList.addElement(table2);
		TableList.addElement(table3);
		TableList.addElement(table4);
		TableList.addElement(table5);
		TableList.addElement(table6);
		

	}
	
	private void Events() {
		
		//action for entering tip amount
		txtTipAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tip = Double.parseDouble(txtTipAmount.getText());
				((Table) (lstTables.getSelectedValue())).setTip(tip);
				
				double total = (((Table) (lstTables.getSelectedValue())).calcBill());
				String str = "" + total;
				txtTableTotal.setText(str);

				txtTipAmount.setText("" + (((Table) (lstTables.getSelectedValue())).getTip()));
				String str2 = "" + (total + (((Table) (lstTables.getSelectedValue())).getTip()));
				txtTotal.setText(str2);
				
			}
		});
		
		
		//List Selection
		lstTables.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				
				
				
				//if(!((((Table) (lstTables.getSelectedValue())).isEmpty()))) {
				double total = (((Table) (lstTables.getSelectedValue())).calcBill());
				String str = "" + total;
				txtTableTotal.setText(str);
				
				//double tip = Double.parseDouble(txtTipAmount.getText());
				
				txtTipAmount.setText("" + (((Table) (lstTables.getSelectedValue())).getTip()));
				String str2 = "" + (total + (((Table) (lstTables.getSelectedValue())).getTip()));
				txtTotal.setText(str2);
			//	}
			//	else {
				//	txtTableTotal.setText("0.00");
				//	txtTipAmount.setText("0.00");
				//	txtTotal.setText("0.00");
			//	}
			}
		});
		
		
		//Order Button
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(RestarauntInfo.isEmployeeID(txtEmpID.getText())) {
					if (RestarauntInfo.getEmployee(txtEmpID.getText()) instanceof Chef) {
						JOptionPane.showMessageDialog(null, "Sorry only Servers can access this! You are a chef get in the kitchen!");
					}
					else {
					tableNum = ((Table)(lstTables.getSelectedValue())).getTableNumber();
					ordersPage.setTableNum(tableNum);
					ordersPage.giveTable(((Table)(lstTables.getSelectedValue())));
					ordersPage.setVisible(true);
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Not a valid employee ID");
			}
		});
		
		//Pay Button
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(RestarauntInfo.isEmployeeID(txtEmpID.getText())) {
					if (RestarauntInfo.getEmployee(txtEmpID.getText()) instanceof Chef) {
						JOptionPane.showMessageDialog(null, "Sorry only Servers can access this! You are a chef get in the kitchen!");
					}
					else {
					((Server)(RestarauntInfo.getEmployee(txtEmpID.getText()))).addTips(((Table)(lstTables.getSelectedValue())).getTip());
					((Table)(lstTables.getSelectedValue())).clearTable();
					}
					
				}
				else
					JOptionPane.showMessageDialog(null, "Not a valid employee ID");
				
				double total = (((Table) (lstTables.getSelectedValue())).calcBill());
				String str = "" + total;
				txtTableTotal.setText(str);

				txtTipAmount.setText("" + (((Table) (lstTables.getSelectedValue())).getTip()));
				String str2 = "" + (total + (((Table) (lstTables.getSelectedValue())).getTip()));
				txtTotal.setText(str2);
			}
		});
		
	//	btnNewButton.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
			//	if(ordersPage.isVisible()) {
				//	ordersPage.setVisible(false);
					//ordersPage = new OrderPageGUI();
				//	ordersPage.setVisible(true);
			//	}
		//	}
	//	});
		
	}
	
	//methods
	public int getTableNum() {
		return tableNum;
	}
	
	public double getFoodIncome() {
		return kitchen.calcFoodIncome();
	}
	
	public double getFoodSpent() {
		return kitchen.calcFoodSpent();
	}
	
	public ArrayList<Dish> getCooked(){
		return kitchen.getCooked();
	}
}
