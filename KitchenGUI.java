package GUI;
import Classes.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KitchenGUI extends JFrame {

	//back end code components
	private ArrayList<Dish> orders;
	private ArrayList<Dish> cooked;
	private int ordersDish1;
	private int ordersDish2;
	private int ordersDish3;
	
	
	//gui components
	private JPanel contentPane;
	private JPanel pnl1;
	private JLabel lblDishName1;
	private JLabel lblIngredients1;
	private JComboBox cbIngredients;
	private JTextArea txtaSpecialInstructions;
	private JScrollPane spSpecialInstructions;
	private JPanel panel;
	private JLabel lblDishName2;
	private JLabel lblIngredients2;
	private JComboBox cbIngredients2;
	private JLabel lblSpecialInstructions2;
	private JScrollPane spSpecialInstructions2;
	private JTextArea txtaSpecialInstructions2;
	private JLabel lblDishName3;
	private JLabel lblIngredients3;
	private JComboBox cbIngredients3;
	private JLabel lblSpecialInstructions3;
	private JScrollPane spSpecialInstructions3;
	private JTextArea txtaSpecialInstructions3;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnDone1;
	private JButton btnDone2;
	private JButton btnDone3;
	private JLabel lblTableNum1;
	private JLabel lblTableNum2;
	private JLabel lblTableNum3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KitchenGUI frame = new KitchenGUI();
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
	public KitchenGUI() {
		setTitle("Kitchen");
		
		InitializeGUI();
		InitializeCode();
		Events();

	}
	
	private void InitializeGUI() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 968, 749);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		pnl1 = new JPanel();
		pnl1.setBounds(20, 38, 300, 521);
		
		panel = new JPanel();
		panel.setBounds(326, 38, 300, 521);
		
		lblDishName2 = new JLabel("Dish Name");
		lblDishName2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDishName2.setBounds(55, 28, 192, 33);
		
		lblIngredients2 = new JLabel("Ingredients");
		lblIngredients2.setBounds(17, 116, 101, 25);
		lblIngredients2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		cbIngredients2 = new JComboBox();
		cbIngredients2.setBounds(17, 154, 257, 25);
		
		lblSpecialInstructions2 = new JLabel("Special Instructions:");
		lblSpecialInstructions2.setBounds(17, 192, 180, 25);
		lblSpecialInstructions2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		spSpecialInstructions2 = new JScrollPane();
		spSpecialInstructions2.setBounds(17, 221, 257, 300);
		
		txtaSpecialInstructions2 = new JTextArea();
		txtaSpecialInstructions2.setEditable(false);
		spSpecialInstructions2.setViewportView(txtaSpecialInstructions2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(636, 38, 300, 521);
		
		lblDishName3 = new JLabel("Dish Name");
		lblDishName3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDishName3.setBounds(55, 28, 192, 33);
		
		lblIngredients3 = new JLabel("Ingredients");
		lblIngredients3.setBounds(15, 116, 101, 25);
		lblIngredients3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		cbIngredients3 = new JComboBox();
		cbIngredients3.setBounds(17, 154, 257, 25);
		
		lblSpecialInstructions3 = new JLabel("Special Instructions:");
		lblSpecialInstructions3.setBounds(17, 192, 180, 25);
		lblSpecialInstructions3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		spSpecialInstructions3 = new JScrollPane();
		spSpecialInstructions3.setBounds(17, 221, 257, 300);
		
		txtaSpecialInstructions3 = new JTextArea();
		txtaSpecialInstructions3.setEditable(false);
		spSpecialInstructions3.setViewportView(txtaSpecialInstructions3);
		contentPane.setLayout(null);
		
		lblDishName1 = new JLabel("Dish Name");
		lblDishName1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDishName1.setBounds(55, 28, 192, 33);
		
		lblIngredients1 = new JLabel("Ingredients");
		lblIngredients1.setBounds(17, 116, 101, 25);
		lblIngredients1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		cbIngredients = new JComboBox();
		cbIngredients.setBounds(17, 154, 257, 25);
		
		JLabel lblSpecialInstructions = new JLabel("Special Instructions:");
		lblSpecialInstructions.setBounds(17, 192, 180, 25);
		lblSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		spSpecialInstructions = new JScrollPane();
		spSpecialInstructions.setBounds(17, 221, 257, 300);
		
		txtaSpecialInstructions = new JTextArea();
		txtaSpecialInstructions.setEditable(false);
		spSpecialInstructions.setViewportView(txtaSpecialInstructions);
		contentPane.add(pnl1);
		pnl1.setLayout(null);
		pnl1.add(lblDishName1);
		pnl1.add(lblIngredients1);
		pnl1.add(cbIngredients);
		pnl1.add(lblSpecialInstructions);
		pnl1.add(spSpecialInstructions);
		
		lblTableNum1 = new JLabel("Table: ");
		lblTableNum1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTableNum1.setBounds(17, 76, 115, 33);
		pnl1.add(lblTableNum1);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(lblDishName2);
		panel.add(lblIngredients2);
		panel.add(cbIngredients2);
		panel.add(lblSpecialInstructions2);
		panel.add(spSpecialInstructions2);
		
		lblTableNum2 = new JLabel("Table: ");
		lblTableNum2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTableNum2.setBounds(17, 76, 115, 33);
		panel.add(lblTableNum2);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(lblDishName3);
		panel_1.add(lblIngredients3);
		panel_1.add(cbIngredients3);
		panel_1.add(lblSpecialInstructions3);
		panel_1.add(spSpecialInstructions3);
		
		lblTableNum3 = new JLabel("Table: ");
		lblTableNum3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTableNum3.setBounds(17, 76, 115, 33);
		panel_1.add(lblTableNum3);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(0, 620, 171, 41);
		contentPane.add(btnPrevious);
		
		btnNext = new JButton("Next");
		btnNext.setBounds(765, 620, 171, 41);
		contentPane.add(btnNext);
		
		btnDone1 = new JButton("Done");
		btnDone1.setBounds(72, 567, 171, 25);

		btnDone1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(btnDone1);
		
		btnDone2 = new JButton("Done");
		btnDone2.setBounds(389, 567, 171, 25);

		btnDone2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(btnDone2);
		
		btnDone3 = new JButton("Done");
		btnDone3.setBounds(712, 567, 171, 25);

		btnDone3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(btnDone3);
	}
	
	private void InitializeCode() {
		orders = new ArrayList<Dish>();
		cooked = new ArrayList<Dish>();
		ordersDish1 = 0;
		ordersDish2 = 1;
		ordersDish3 = 2;
		
	}
	
	private void Events() {
		
		//NextButton
		//Scroll 3 dishes to the right
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ordersDish1 + 3 <= orders.size()) {
					ordersDish1 += 3;
					ordersDish2 += 3;
					ordersDish3 += 3;
				}
				display();
				/*
				Ingredient Jalapeno = new Ingredient("Jalapeno",7.50,5.00);
				Ingredient Cheese = new Ingredient("Cheese",5.00,3.00);
				Ingredient Tomato = new Ingredient("Tomato",3.50,2.50);
				Ingredient groundBeef = new Ingredient("Ground Beef",15.50,10.00);
				
				
				ArrayList<Ingredient>requiredIngredients = new ArrayList<Ingredient>();//Temporary variable for helping create dishes
				requiredIngredients.add(Cheese);
				requiredIngredients.add(Tomato);
				requiredIngredients.add(Jalapeno);
				requiredIngredients.add(groundBeef);
				
				//////////////////APPETIZER DISHES
				Dish Nachos = new Dish("Nachos",requiredIngredients);
				Nachos.setNotes("No cheese\nextra sauce");
				orders.add(Nachos);
				display();
				*/
			}
		});
		
		//Previous Button
		//Scroll 3 dishes to the left
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ordersDish1 - 3 >= 0) {
					ordersDish1 -= 3;
					ordersDish2 -= 3;
					ordersDish3 -= 3;
				}
				display();
				
			}
		});
		
		//Done Buttons
		//Take that dish to the cooked list from the to cook list and shift everyone down on the gui
		
		//done1
		btnDone1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cookDish(ordersDish1);
			}
		});
		
		//done2
		btnDone2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cookDish(ordersDish2);
			}
		});
		
		//done3
		btnDone3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cookDish(ordersDish3);
			}
		});
		
	}
	
	//methods
	
	//add dish to the kitchen orders list
	public void addDish(Dish d) {
		orders.add(d);
	}
	
	//when done cooking a dish move it to the cooked list
	private void cookDish(int index) {
		if(index < orders.size()) {
		cooked.add(orders.get(index));
		orders.remove(index);
		display();
		}
	}
	
	
	//set the gui dish display to the first three items in the arrayList
	//reset the display for chosen num 1,2,or 3
	//reset the display for all elements
	@SuppressWarnings("unchecked")
	public void display() {
		//dish1

		
		if(ordersDish1 >= orders.size()) {
			lblDishName1.setText("No Orders");
			cbIngredients.removeAllItems();
			txtaSpecialInstructions.setText("Remember to stay hydrated!!! :)");
			lblTableNum1.setText("Table: ");
			
		}
		else {
		Dish dish1 = orders.get(ordersDish1);
		//String name = dish1.getDishName();
		lblDishName1.setText(dish1.getDishName());
		cbIngredients.removeAllItems();
		/*
		//test
		ArrayList<Ingredient> ingr = new ArrayList<Ingredient>();
		Ingredient chickenSauce = new Ingredient("Chicken Sauce",1.00,2.00);
		Ingredient chickenSauce2 = new Ingredient("1",1.00,2.00);
		Ingredient chickenSauce3 = new Ingredient("2",1.00,2.00);
		ingr.add(chickenSauce);
		ingr.add(chickenSauce2);
		ingr.add(chickenSauce3);
		for(Ingredient ing: ingr) {
			cbIngredients.addItem(ing);
		}
		//end test
		 */
		 
		for(Ingredient ing: dish1.getIngredients()) {
			cbIngredients.addItem(ing);
		}
		
		txtaSpecialInstructions.setText(dish1.getNotes());
		lblTableNum1.setText("Table: " + dish1.getTableNum());
		}
		
		//dish2
		if(ordersDish2 >= orders.size()) {
			lblDishName2.setText("No Orders");
			cbIngredients2.removeAllItems();
			txtaSpecialInstructions2.setText("Remember to stay hydrated!!! :)");
			lblTableNum2.setText("Table: ");
		}
		else {
		Dish dish2 = orders.get(ordersDish2);
		lblDishName2.setText(dish2.getDishName());
		cbIngredients2.removeAllItems();
		for(Ingredient ing: dish2.getIngredients()) {
			cbIngredients2.addItem(ing);
		}
		txtaSpecialInstructions2.setText(dish2.getNotes());
		lblTableNum2.setText("Table: " + dish2.getTableNum());
		}
		
		//dish3
		if(ordersDish3 >= orders.size()) {
			lblDishName3.setText("No Orders");
			cbIngredients3.removeAllItems();
			txtaSpecialInstructions3.setText("Remember to stay hydrated!!! :)");
			lblTableNum3.setText("Table: ");
		}
		else {
		Dish dish3 = orders.get(ordersDish3);
		lblDishName3.setText(dish3.getDishName());
		cbIngredients3.removeAllItems();
		for(Ingredient ing: dish3.getIngredients()) {
			cbIngredients3.addItem(ing);
		}
		txtaSpecialInstructions3.setText(dish3.getNotes());
		lblTableNum3.setText("Table: " + dish3.getTableNum());
		
		}
	}
	
	public double calcFoodIncome() {
		//Alex and lara made this
		double total = 0;
		for(Dish d: cooked)
			total += d.priceToSell();
		return total;
	}
	
	public double calcFoodSpent() {
		//alex and lara made this
		double total = 0;
		for(Dish d: cooked)
			total += d.getPriceToMake();
		return total;
	}
	
	
	
	
}
