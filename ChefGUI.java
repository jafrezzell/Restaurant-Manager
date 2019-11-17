package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class ChefGUI extends JFrame {

	private JPanel contentPane;
	private JComboBox cbDishes;
	private JLabel lblDishes;
	private JButton btnCooked;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChefGUI frame = new ChefGUI();
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
	public ChefGUI() {
		
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
		
		//Labels
		//Dishes
		lblDishes = new JLabel("Dishes:");
		
		//ComboBox
		//shows the dishes/tickets for the kitchen to do stuff with
		cbDishes = new JComboBox();
		
		//buttons
		//allows kitchen 
		btnCooked = new JButton("Cooked");
		
		//group Layout for the JFrame
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(561, Short.MAX_VALUE)
					.addComponent(btnCooked)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(cbDishes, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDishes))
					.addContainerGap(396, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDishes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbDishes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
					.addComponent(btnCooked)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
	}
	
	private void Events() {
		
	}

}
