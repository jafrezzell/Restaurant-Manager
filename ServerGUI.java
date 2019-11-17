package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerGUI extends JFrame {

	private JPanel contentPane;
	private JComboBox cbTables;
	private JButton btnOrder;
	private JButton btnPay;

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
		
		Initialize();
		Events();
		
		
	}

	private void Initialize() {
		
		//default
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//ComboBox
		//tables
		cbTables = new JComboBox();
		
		
		//Labels
		//Tables
		JLabel lblTables = new JLabel("Tables:");
		
		//buttons
		//take order
		btnOrder = new JButton("Order");
		//cash out the table/ pay
		btnPay = new JButton("Pay");
		
		
		//group layout for the JFrame
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cbTables, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 379, Short.MAX_VALUE)
							.addComponent(btnOrder))
						.addComponent(lblTables)
						.addComponent(btnPay, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(lblTables)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbTables, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(69)
							.addComponent(btnOrder)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPay)
					.addContainerGap(235, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
		
	}
	
	private void Events() {
		
		//comboBox
		//selecting the table wanted
		cbTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*find table wanted based on table number
				 call that table.isEmpty()
				 if empty new window pop up asking num customers then add that to table
				 then hit "ok" which closees pop up and continue as is
				*/
			}
		});
		
		
		
	}
}
