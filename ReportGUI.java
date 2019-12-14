package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Dish;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JTextField;

public class ReportGUI extends JFrame {

	//componenets
	double wagesSpent;
	double foodSpent;
	double foodEarned;
	Dish popDish;
	
	DecimalFormat format;
	
	
	//GUI components
	private JPanel contentPane;
	private JLabel lblIncome;
	private JLabel lblReport;
	private JLabel lblWagesOut;
	private JLabel lblFoodIn;
	private JTextField txtFoodIn;
	private JTextField txtFoodOut;
	private JTextField txtWagesOut;
	private JTextField txtPopDish;
	private JLabel lblPopDish;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportGUI frame = new ReportGUI();
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
	public ReportGUI() {
		
		Initialize();
		
	}
	
	
	private void Initialize() {
		
		
		//components
		wagesSpent = 0;
		foodSpent = 0;
		foodEarned = 0;
		
		//Gui
		setTitle("Daily Report");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblReport = new JLabel("Report:");
		lblReport.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblReport.setBounds(270, 28, 115, 33);
		contentPane.add(lblReport);
		
		lblIncome = new JLabel("Income:");
		lblIncome.setBounds(26, 77, 115, 33);
		contentPane.add(lblIncome);
		
		JLabel lblExpenses = new JLabel("Expenses:");
		lblExpenses.setBounds(26, 163, 147, 33);
		contentPane.add(lblExpenses);
		
		JLabel lblFoodOut = new JLabel("Food:");
		lblFoodOut.setBounds(83, 195, 115, 33);
		contentPane.add(lblFoodOut);
		
		lblWagesOut = new JLabel("Wages:");
		lblWagesOut.setBounds(83, 240, 115, 33);
		contentPane.add(lblWagesOut);
		
		lblFoodIn = new JLabel("Food:");
		lblFoodIn.setBounds(83, 114, 115, 33);
		contentPane.add(lblFoodIn);
		
		txtFoodIn = new JTextField();
		txtFoodIn.setEditable(false);
		txtFoodIn.setBounds(406, 111, 236, 39);
		contentPane.add(txtFoodIn);
		txtFoodIn.setColumns(10);
		
		txtFoodOut = new JTextField();
		txtFoodOut.setEditable(false);
		txtFoodOut.setBounds(406, 192, 236, 39);
		contentPane.add(txtFoodOut);
		txtFoodOut.setColumns(10);
		
		txtWagesOut = new JTextField();
		txtWagesOut.setEditable(false);
		txtWagesOut.setBounds(406, 237, 236, 39);
		contentPane.add(txtWagesOut);
		txtWagesOut.setColumns(10);
		
		lblPopDish = new JLabel("Most Popular Dish:");
		lblPopDish.setBounds(26, 301, 247, 33);
		contentPane.add(lblPopDish);
		
		txtPopDish = new JTextField();
		txtPopDish.setEditable(false);
		txtPopDish.setBounds(83, 347, 559, 39);
		contentPane.add(txtPopDish);
		txtPopDish.setColumns(10);
		
		format = new DecimalFormat("###.##");
		
		setLabels();
		
		
		
		

		
		
	}
	
	public void setWagesSpent(double num) {
		wagesSpent = num;
		setLabels();
	}
	
	public void setFoodSpent(double num) {
		foodSpent = num;
		setLabels();
	}
	
	public void setFoodEarned(double num) {
		foodEarned = num;
		setLabels();
	}
	
	public void setPopDish(Dish d) {
		popDish = d;
		setLabels();
	}
	
	private String getFoodEarned() {
		//return format.format(foodEarned);
		return "$" + format.format(foodEarned);
	}
	
	private String getFoodSpent() {
		return "$" + format.format(foodSpent);
	}
	
	private String getWagesSpent() {
		return "$" + format.format(wagesSpent);
	}
	
	private String getPopDish() {
		return popDish.getDishName();
	}
	
	private void setLabels() {
		txtFoodIn.setText(getFoodEarned());
		txtFoodOut.setText(getFoodSpent());
		txtWagesOut.setText(getWagesSpent());
	}
	
}
