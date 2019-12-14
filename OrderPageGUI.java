package GUI;

import Classes.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class OrderPageGUI extends JFrame {

	public void setWingLabel(String s) {
		lblWNotes.setText(s);
	}
	
	//variables 
	private int tableNum;
	static KitchenGUI kitchen;
	private Table table;
	//Josh
	private ArrayList<Dish> Dishes;
	private ArrayList<Ingredient> Ingredients;
	private Dish Nachos;
	private Dish Wings;
	private Dish Burger;
	private Dish grilledChickenSandwich;
	private Dish DWater;
	private Dish Soda;
	private Dish icedTea;
	//end Josh
	
	private JPanel contentPane;
	private JTabbedPane tabpOrders;
	private JLabel lblNachos;
	private JLabel lblWings;
	private JPanel pnlAppetizers;
	private JLabel lblCheeseBurger;
	private JLabel lnlCSandwhich;
	private JButton btnCBOrder;
	private JTextArea txtaCBNotes;
	private JLabel lblCBNotes;
	
	//temp dish objects to send to the kitchen
	Dish CheeseBurger;
	private JScrollPane spGC;
	private JLabel lblWNotes;
	private JLabel lblNachosNotes;
	private JScrollPane spW;
	private JScrollPane spNachos;
	private JTextArea txtAWNotes;
	private JTextArea txtANachosNotes;
	private JButton btnWOrder;
	private JButton btnNachosOrder;
	private JButton btnOrder;
	private JTextArea txtaGCNotes;
	private JPanel pnlEntrees;
	private JButton btnSodaOrder;
	private JButton btnTeaOrder;
	private JLabel lblWater;
	private JButton button;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderPageGUI frame = new OrderPageGUI(kitchen);
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
	public OrderPageGUI(KitchenGUI k) {
		setTitle("Orders");
		kitchen = k;
		Initialize();
		Events();
		

	}

	private void Initialize() {
		
		tableNum = -1;
		Dishes = new ArrayList<Dish>();//The dishes our restaurant serves
		Ingredients = new ArrayList<Ingredient>();//The ingredients available at our restaurant
		CreateFood();

		
		
	//	ArrayList cbIngredients = new ArrayList<>();
	//	Ingredient cheese = new Ingredient("cheese", 10, 10);
	//	cbIngredients.add(cheese);
	//	CheeseBurger = new Dish("Cheese Burger", cbIngredients);
		
		//default stuff                  right here default says EXIT_ON_CLOSE //changing to Dispose closes just this specific window
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabpOrders = new JTabbedPane(JTabbedPane.TOP);
		tabpOrders.setBounds(31, 33, 712, 474);
		
		pnlAppetizers = new JPanel();
		tabpOrders.addTab("Appetizers", null, pnlAppetizers, null);
		
		lblWings = new JLabel("Wings");
		lblWings.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblWings.setBounds(196, 28, 162, 47);
		
		lblNachos = new JLabel("Nachos");
		lblNachos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNachos.setBounds(196, 225, 231, 33);
		
		lblWNotes = new JLabel("Notes");
		lblWNotes.setBounds(26, 62, 51, 25);
		lblWNotes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNachosNotes = new JLabel("Notes");
		lblNachosNotes.setBounds(26, 257, 51, 25);
		lblNachosNotes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		spW = new JScrollPane();
		spW.setBounds(26, 95, 487, 106);
		
		spNachos = new JScrollPane();
		spNachos.setBounds(26, 286, 487, 112);
		
		btnWOrder = new JButton("Order");
		btnWOrder.setBounds(528, 95, 153, 41);

		
		btnNachosOrder = new JButton("Order");
		btnNachosOrder.setBounds(531, 286, 150, 41);
		
		txtANachosNotes = new JTextArea();
		spNachos.setViewportView(txtANachosNotes);
		
		txtAWNotes = new JTextArea();
		spW.setViewportView(txtAWNotes);
		pnlAppetizers.setLayout(null);
		pnlAppetizers.add(lblNachosNotes);
		pnlAppetizers.add(lblNachos);
		pnlAppetizers.add(spNachos);
		pnlAppetizers.add(spW);
		pnlAppetizers.add(lblWings);
		pnlAppetizers.add(lblWNotes);
		pnlAppetizers.add(btnWOrder);
		pnlAppetizers.add(btnNachosOrder);
		
		pnlEntrees = new JPanel();
		tabpOrders.addTab("Entrees", null, pnlEntrees, null);
		
		lblCheeseBurger = new JLabel("Cheese Burger");
		lblCheeseBurger.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCheeseBurger.setBounds(167, 28, 236, 33);
		
		lnlCSandwhich = new JLabel("Grilled Chicken Sandwhich");
		lnlCSandwhich.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lnlCSandwhich.setBounds(96, 210, 403, 70);
		
		JScrollPane spCB = new JScrollPane();
		spCB.setBounds(26, 95, 487, 106);
		
		btnCBOrder = new JButton("Order");
		btnCBOrder.setBounds(528, 95, 153, 41);

		
		lblCBNotes = new JLabel("Notes:");
		lblCBNotes.setBounds(26, 62, 90, 25);
		lblCBNotes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setBounds(26, 255, 58, 25);
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		spGC = new JScrollPane();
		spGC.setBounds(26, 286, 487, 112);
		
		btnOrder = new JButton("Order");
		btnOrder.setBounds(531, 286, 150, 41);
		
		txtaGCNotes = new JTextArea();
		spGC.setViewportView(txtaGCNotes);
		
		txtaCBNotes = new JTextArea();
		spCB.setViewportView(txtaCBNotes);
		pnlEntrees.setLayout(null);
		pnlEntrees.add(lblCBNotes);
		pnlEntrees.add(lblCheeseBurger);
		pnlEntrees.add(spCB);
		pnlEntrees.add(lblNotes);
		pnlEntrees.add(lnlCSandwhich);
		pnlEntrees.add(spGC);
		pnlEntrees.add(btnOrder);
		pnlEntrees.add(btnCBOrder);
		
		JPanel pnlDrinks = new JPanel();
		pnlDrinks.setToolTipText("");
		tabpOrders.addTab("Drinks", null, pnlDrinks, null);
		
		JLabel lblSoda = new JLabel("Soda");
		lblSoda.setBounds(26, 28, 91, 33);
		
		JLabel lblTea = new JLabel("Tea");
		lblTea.setBounds(26, 104, 75, 33);
		pnlDrinks.setLayout(null);
		
		btnSodaOrder = new JButton("Order");

		btnSodaOrder.setBounds(143, 28, 112, 33);
		pnlDrinks.add(btnSodaOrder);
		pnlDrinks.add(lblSoda);
		pnlDrinks.add(lblTea);
		
		btnTeaOrder = new JButton("Order");

		btnTeaOrder.setBounds(143, 104, 112, 33);
		pnlDrinks.add(btnTeaOrder);
		
		lblWater = new JLabel("Water");
		lblWater.setBounds(26, 165, 75, 33);
		pnlDrinks.add(lblWater);
		
		button = new JButton("Order");

		button.setBounds(143, 165, 112, 33);
		pnlDrinks.add(button);
		contentPane.add(tabpOrders);
	}
	
	private void CreateFood() {

		
		
		//INGREDIENTS
		Ingredient chickenSauce = new Ingredient("Chicken Sauce",1.00,2.00);
		Ingredients.add(chickenSauce);
		Ingredient Celery = new Ingredient("Celery",1.50,0.99);
		Ingredients.add(Celery);
		Ingredient Ranch = new Ingredient("Ranch",4.50,3.50);
		Ingredients.add(Ranch);
		Ingredient Chips = new Ingredient("Chips",2.50,0.99);
		Ingredients.add(Chips);
		Ingredient Cheese = new Ingredient("Cheese",5.00,3.00);
		Ingredients.add(Cheese);
		Ingredient Tomato = new Ingredient("Tomato",3.50,2.50);
		Ingredients.add(Tomato);
		Ingredient Jalapeno = new Ingredient("Jalapeno",7.50,5.00);
		Ingredients.add(Jalapeno);
		Ingredient groundBeef = new Ingredient("Ground Beef",15.50,10.00);
		Ingredients.add(groundBeef);
		Ingredient Bun = new Ingredient("Bun",2.50,.99);
		Ingredients.add(Bun);
		Ingredient Lettuce = new Ingredient("Lettuce",1.50,0.99);
		Ingredients.add(Lettuce);
		Ingredient Mustard = new Ingredient("Mustard",3.00,2.50);
		Ingredients.add(Mustard);
		Ingredient Ketchup = new Ingredient("Ketchup",3.00,2.50);
		Ingredients.add(Ketchup);
		Ingredient Chicken = new Ingredient("Chicken",16.00,10.00);
		Ingredients.add(Chicken);
		Ingredient Mayo = new Ingredient("Mayo",3.00,2.50);
		Ingredients.add(Mayo);
		Ingredient Crust = new Ingredient("Crust",10.00,8.50);
		Ingredients.add(Crust);
		Ingredient Pepperoni = new Ingredient("Pepperoni",1.50,.99);
		Ingredients.add(Pepperoni);
		Ingredient marinaraSauce = new Ingredient("Marinara Sauce",5.00,3.50);
		Ingredients.add(marinaraSauce);
		Ingredient Water = new Ingredient("Water",0.00,0.00);
		Ingredients.add(Water);
		Ingredient Syrup = new Ingredient("Syrup",1.50,0.50);
		Ingredients.add(Syrup);
		Ingredient Tea = new Ingredient("Tea",1.50,0.50);
		Ingredients.add(Tea);
		///////////////////////////END INGREDIENTS BEING ADDED
		
		
		ArrayList<Ingredient>requiredIngredients = new ArrayList<Ingredient>();//Temporary variable for helping create dishes
		requiredIngredients.add(Cheese);
		requiredIngredients.add(Tomato);
		requiredIngredients.add(Jalapeno);
		requiredIngredients.add(groundBeef);
		
		//////////////////APPETIZER DISHES
		Ingredient[] nachoIngredients = new Ingredient[requiredIngredients.size()];
		requiredIngredients.toArray(nachoIngredients);
		Nachos = new Dish("Nachos",nachoIngredients);
		Dishes.add(Nachos);
		requiredIngredients.clear();
		
		requiredIngredients.add(chickenSauce);
		requiredIngredients.add(Celery);
		requiredIngredients.add(Ranch);
		Ingredient[] wingIngredients = new Ingredient[requiredIngredients.size()];
		requiredIngredients.toArray(wingIngredients);
		Wings = new Dish("Wings", wingIngredients);
		Dishes.add(Wings);
		requiredIngredients.clear();
		//////////////////END APPETIZER DISHES
		
		
		////////////////////ENTREE DISHES
		requiredIngredients.add(groundBeef);
		requiredIngredients.add(Bun);
		requiredIngredients.add(Cheese);
		requiredIngredients.add(Tomato);
		requiredIngredients.add(Lettuce);
		requiredIngredients.add(Mustard);
		requiredIngredients.add(Ketchup);
		Ingredient[] burgerIngredients = new Ingredient[requiredIngredients.size()];
		requiredIngredients.toArray(burgerIngredients);
		Burger = new Dish("Burger", burgerIngredients);
		Dishes.add(Burger);
		requiredIngredients.clear();
		
		requiredIngredients.add(Chicken);
		requiredIngredients.add(Bun);
		requiredIngredients.add(Lettuce);
		requiredIngredients.add(Tomato);
		requiredIngredients.add(Mayo);
		Ingredient[] chickenSandwichIngredients = new Ingredient[requiredIngredients.size()];
		requiredIngredients.toArray(chickenSandwichIngredients);
		grilledChickenSandwich = new Dish("Grilled Chicken Sandwich", chickenSandwichIngredients);
		Dishes.add(grilledChickenSandwich);
		requiredIngredients.clear();
		
		requiredIngredients.add(Cheese);
		requiredIngredients.add(Crust);
		requiredIngredients.add(Pepperoni);
		requiredIngredients.add(marinaraSauce);
		Ingredient[] pizzaIngredients = new Ingredient[requiredIngredients.size()];
		requiredIngredients.toArray(pizzaIngredients);
		Dish Pizza = new Dish("Pizza", pizzaIngredients);
		Dishes.add(Pizza);
		requiredIngredients.clear();
		/////////////END ENTREE DISHES
		
		
		//////////////DRINK DISHES
		requiredIngredients.add(Water);
		Ingredient[] waterIngredients = new Ingredient[requiredIngredients.size()];
		requiredIngredients.toArray(waterIngredients);
		DWater = new Dish("Water",waterIngredients);
		Dishes.add(DWater);
		requiredIngredients.clear();
		
		requiredIngredients.add(Water);
		requiredIngredients.add(Syrup);
		Ingredient[] sodaIngredients = new Ingredient[requiredIngredients.size()];
		requiredIngredients.toArray(sodaIngredients);
		Soda = new Dish("Soda", sodaIngredients);
		Dishes.add(Soda);
		requiredIngredients.clear();
		
		requiredIngredients.add(Water);
		requiredIngredients.add(Tea);
		requiredIngredients.add(Syrup);
		Ingredient[] teaIngredients = new Ingredient[requiredIngredients.size()];
		requiredIngredients.toArray(teaIngredients);
		icedTea = new Dish("Iced Tea", teaIngredients);
		Dishes.add(icedTea);
		requiredIngredients.clear();
		////////////END DRINK DISHES
	}

	
	
	private void Events() {
		//close the frame
	//	btnClosePage.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
			//	dispose();
		//	}
		//});
		
		//Appetizers
		
		//wings
		btnWOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Wings.setNotes(txtAWNotes.getText());
				Wings.setTableNum(tableNum);
				kitchen.addDish(Wings.makeCopy());
				table.addDishes(Wings.makeCopy());
				kitchen.display();
				
				txtAWNotes.setText(" ");
			}
		});
		
		//Nachos
		btnNachosOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Nachos.setNotes(txtANachosNotes.getText());
				Nachos.setTableNum(tableNum);
				kitchen.addDish(Nachos.makeCopy());
				table.addDishes(Nachos.makeCopy());
				kitchen.display();
				
				txtANachosNotes.setText(" ");
			}
		});
		
		//Entrees
		
		//Grilled chicken sandwhich
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				grilledChickenSandwich.setNotes(txtaGCNotes.getText());
				grilledChickenSandwich.setTableNum(tableNum);
				kitchen.addDish(grilledChickenSandwich.makeCopy());
				table.addDishes(grilledChickenSandwich.makeCopy());
				kitchen.display();
				
				txtaGCNotes.setText(" ");
			}
		});
		
		//CheeseBurger
		btnCBOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//send the kitchen a cheeseburger along with the notes the kitchen needs to cook it properly
				
				Burger.setNotes(txtaCBNotes.getText());
				Burger.setTableNum(tableNum);
				kitchen.addDish(Burger.makeCopy());
				table.addDishes(Burger.makeCopy());
				kitchen.display();
				
				Burger.setNotes(" ");
				Burger.setTableNum(-1);
				txtaCBNotes.setText(" ");
			}
		});
		
		//Drinks
		//soda
		btnSodaOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.addDishes(Soda.makeCopy());
			}
		});
		
		//Iced Tea
		btnTeaOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.addDishes(icedTea.makeCopy());
			}
		});
		//Water
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.addDishes(DWater.makeCopy());
			}
		});
		
	}
	
	//methods
	public void setTableNum(int num) {
		tableNum = num;
	}
	
	public void giveTable(Table t) {
		table = t;
	}
	
}
