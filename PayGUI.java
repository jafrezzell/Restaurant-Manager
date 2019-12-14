package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PayGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblEmployeeID;
	private JTextField txtID;
	private JTextField txtAmountDue;
	private JTextField txtTip;
	private JLabel lblAmounntDue;
	private JLabel lblTipAmount;
	private JLabel lblTotal;
	private JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PayGUI dialog = new PayGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PayGUI() {
		
		Initialize();
		Events();

	}
	
	private void Initialize() {
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblEmployeeID = new JLabel("Employee ID:");
			lblEmployeeID.setBounds(26, 28, 161, 33);
			contentPanel.add(lblEmployeeID);
		}
		{
			lblAmounntDue = new JLabel("Amount Due:");
			lblAmounntDue.setBounds(26, 78, 175, 33);
			contentPanel.add(lblAmounntDue);
		}
		{
			lblTipAmount = new JLabel("Tip Amount:");
			lblTipAmount.setBounds(26, 128, 175, 33);
			contentPanel.add(lblTipAmount);
		}
		
		txtID = new JTextField();
		txtID.setBounds(213, 28, 236, 33);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		txtAmountDue = new JTextField();
		txtAmountDue.setEditable(false);
		txtAmountDue.setColumns(10);
		txtAmountDue.setBounds(213, 78, 236, 33);
		contentPanel.add(txtAmountDue);
		
		txtTip = new JTextField();
		txtTip.setColumns(10);
		txtTip.setBounds(213, 128, 236, 33);
		contentPanel.add(txtTip);
		
		lblTotal = new JLabel("New label");
		lblTotal.setBounds(26, 178, 115, 33);
		contentPanel.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(213, 178, 236, 33);
		contentPanel.add(txtTotal);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void Events() {
		
	}
}
