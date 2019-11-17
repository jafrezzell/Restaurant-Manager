package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignIn extends JFrame {

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
		
		Initialize();
		Events();
		
		
	}

	
	private void Initialize() {
		//default stuff
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 501);
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
				//Find out if that is a valid employee ID
					//else
					JOptionPane.showMessageDialog(null, "Please enter a valid Employee ID");
				//check that they are not already clocked in
					//if so 
					JOptionPane.showMessageDialog(null, "You are already clocked in");
					//else
					//take time from computer clock
					//setThat employee clockIn time to the computer clock time
				
			}
		});
		
		//click the clock out button
		btnClockOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Find out if that is a valid employee ID
					//else
					JOptionPane.showMessageDialog(null, "Please enter a valid Employee ID");
				//check that they are actually clocked in
					//if not
					JOptionPane.showMessageDialog(null, "You must be clocked in to clock out");
				//take time from the computer clock and set the clock out time to computer time
				//compute the hours worked based on that
				
			}
		});
		
		
		
	}
}
