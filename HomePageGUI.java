package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import Classes.*;
import java.awt.Color;

public class HomePageGUI extends JFrame {
	
	//variables
	private Dish toOrder;
	private int tableNumber;
	
	//GUis
	SignIn signIn;
	KitchenGUI kitchen;
	ServerGUI server;
	ReportGUI report;
	
	//components
	private JPanel contentPane;
	private JButton btnClock;
	private JButton btnDayReport;
	private JButton btnManagement;
	private JButton btnServer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageGUI frame = new HomePageGUI();
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
	public HomePageGUI() {
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.BLACK);
		setTitle("Home");
		System.out.println("1");
		Initialize();
		System.out.println("2");
		InitializeCode();
		System.out.println("3");
		Events();
		System.out.println("4");
	}

	
	
	private void Initialize() {
		
		//storage
		RestarauntInfo.populate();
		
		//Gui pages
		signIn = new SignIn();
		kitchen = new KitchenGUI();
		server = new ServerGUI();
		report = new ReportGUI();
		
		//default stuff
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//new buttons
		btnClock = new JButton("Clock In/Out");
		
		btnClock.setBounds(0, 0, 355, 205);
		contentPane.add(btnClock);
		
		btnDayReport = new JButton("Report");

		btnDayReport.setBounds(355, 0, 363, 205);
		contentPane.add(btnDayReport);
		
		btnManagement = new JButton("Manage");
		
		btnManagement.setBounds(0, 205, 355, 207);
		contentPane.add(btnManagement);
		
		btnServer = new JButton("Server");
		
		btnServer.setBounds(355, 205, 363, 207);
		contentPane.add(btnServer);
		
		
		
	}
	
	private void InitializeCode() {
		tableNumber = -1;
	}
	
	private void Events() {
		
		//clock in out button
		btnClock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signIn.setVisible(true);
			}
		});
		
		//Management button

		
		//ServerGUI button
		btnServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				server.setVisible(true);
			}
		});
		
		//Report button
		btnDayReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				report.setWagesSpent(signIn.getWagesSpent());
				report.setFoodEarned(server.getFoodIncome());
				report.setFoodSpent(server.getFoodSpent());
				report.setVisible(true);
			}
		});
		
		
	}
	
	
	//methods
	public void giveOrder(Dish d) {
		toOrder = d;
		toOrder.setTableNum(tableNumber);
		sendOrder();
	}
	
	public void giveTable(int tableNum) {
		tableNumber = tableNum;
	}
	
	private void sendOrder() {
		kitchen.addDish(toOrder);
	}
	
	
	
}
