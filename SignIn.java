package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Employee;
import Classes.RestarauntInfo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import Classes.*;

public class SignIn extends JFrame {

	//needed oher GUI pages
	ServerGUI server;
	
	
	//
	double wagesSpent;
	private JPanel contentPane;
	private JLabel lblEmpID;
	private JTextField txtEmpID;
	private JButton btnClockIn;
	private JButton btnClockOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {
		setTitle("The CLOCK");
		
		Initialize();
		Events();
		
		
	}

	
	private void Initialize() {
		
		//
		wagesSpent = 0.0;
		
		//default stuff
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//labels
		//employee ID
		lblEmpID = new JLabel("Employee ID:");
		
		//TextField
		//Text field for the employee to enter their ID
		txtEmpID = new JTextField();
		txtEmpID.setColumns(10);
		
		
		//buttons
		//Clock in button for employee after they enter their ID
		btnClockIn = new JButton("Clock In");
		
		
		//clock out button for emplouee after they enter their ID
		btnClockOut = new JButton("Clock Out");
		
		
		
		
		
		
		//group layout
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblEmpID)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEmpID, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(555, Short.MAX_VALUE)
							.addComponent(btnClockIn))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(511, Short.MAX_VALUE)
							.addComponent(btnClockOut)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmpID)
						.addComponent(txtEmpID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnClockIn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnClockOut)
					.addContainerGap(222, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
		
	}
	
	private void Events() {
	
		//click the clock in button
		btnClockIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String employeeID = txtEmpID.getText();
				
				if(RestarauntInfo.isEmployeeID(employeeID)) { //validate employee ID
					if(RestarauntInfo.getEmployee(employeeID).isClockedIn()) { //check if clocked in
						JOptionPane.showMessageDialog(null, "you are already clocked in");
					}
					else {
						RestarauntInfo.getEmployee(employeeID).setClockInTime(System.currentTimeMillis());
						JOptionPane.showMessageDialog(null, RestarauntInfo.getEmployee(employeeID).getName() + " is now clocked in!");
						txtEmpID.setText("");
						dispose();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Enter a valid Employee ID");
				}
				
				//JOptionPane.showMessageDialog(null, System.currentTimeMillis());
				//clock in if valid and not already clocked in 
				//take time from computer and put it into the employees clock in time slot
				//
				/*
				 * if(ArrayList.contains(employeeID))
				 * 		if(ArrayList.indexOf(employeeID).isClockedIn())
				 * 			JOptionPane.showMessageDialog(null, "you are already clocked in");
				 * 		else
				 * 			ArrayList.indexOf(employeeID).setClockin(system.currentTimeMillis());
				 * else
				 * 		JOptionPane.showMessageDialog("enter valid ID");
				 */
				
				
				
				//JOptionPane.showMessageDialog(null, employeeID);

				//Find out if that is a valid employee ID
				//	if(ArrayList.contains(employeeID)){
						//if(employeeID % 2 == 0)
							//server.setVisible(true);
						//else
							//
					//else
				//	JOptionPane.showMessageDialog(null, "Please enter a valid Employee ID");
				//check that they are not already clocked in
					//if so 
			//		JOptionPane.showMessageDialog(null, "You are already clocked in");
					//else
					//take time from computer clock
					//setThat employee clockIn time to the computer clock time
				//	txtEmpID.setText("");
			}
		});
		
		//click the clock out button
		btnClockOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String employeeID = txtEmpID.getText();
				
				if(RestarauntInfo.isEmployeeID(employeeID)) { //validate employee ID
					if(RestarauntInfo.getEmployee(employeeID).isClockedIn()) { //check if clocked in
						RestarauntInfo.getEmployee(employeeID).setClockOutTime(System.currentTimeMillis());
						JOptionPane.showMessageDialog(null, clockOutMessage(RestarauntInfo.getEmployee(employeeID)));
						txtEmpID.setText("");
						wagesSpent += calcIncome(RestarauntInfo.getEmployee(employeeID));
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "You must be clocked in to clock out");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Enter a valid Employee ID");
				}
				
				
				
				
				//Find out if that is a valid employee ID
					//else
			//		JOptionPane.showMessageDialog(null, "Please enter a valid Employee ID");
				//check that they are actually clocked in
					//if not
			//		JOptionPane.showMessageDialog(null, "You must be clocked in to clock out");
				//take time from the computer clock and set the clock out time to computer time
				//compute the hours worked based on that
		//		txtEmpID.setText("");
			}
		});
		
		
		
	}
	
	//methods
	
	private String clockOutMessage(Employee emp) {
		String str = "";
		DecimalFormat format = new DecimalFormat("####.##");
		double wage = (emp.getHourlyWage() * 1.0) / ((60 * 60 * 1000) * 1.0);
		double tips = 0;
		str += "Name: " + emp.getName() + "\n";
		str += "Employee ID: " + emp.getEmployeeId() + "\n";
		str += "Hourly Wage: " + emp.getHourlyWage() + "\nHours Worked: " + emp.hoursWorked() + "\n";
		if(emp instanceof Server) {
			tips = ((Server)(emp)).getTips();
			str += "Daily Tips: " + tips + "\n";
		}
		String income = format.format((((RestarauntInfo.getEmployee(emp.getEmployeeId()).getClockOut() - RestarauntInfo.getEmployee(emp.getEmployeeId()).getClockIn()) * ((1.0 / 1000.0) * (1.0 / 60.0) * (1.0 / 60.0))) * RestarauntInfo.getEmployee(emp.getEmployeeId()).getHourlyWage()) + tips);
		str += "Today's income*: " + income;
		return str;
	}
	
	private double calcIncome(Employee emp) {
		return (((RestarauntInfo.getEmployee(emp.getEmployeeId()).getClockOut() - RestarauntInfo.getEmployee(emp.getEmployeeId()).getClockIn()) * ((1.0 / 1000.0) * (1.0 / 60.0) * (1.0 / 60.0))) * RestarauntInfo.getEmployee(emp.getEmployeeId()).getHourlyWage());
	}
	
	public double getWagesSpent() {
		return wagesSpent;
	}
	
	
	
	
}
