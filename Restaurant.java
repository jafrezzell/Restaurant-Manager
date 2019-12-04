import java.util.ArrayList;

/**
 * Main method for restaurant manager system
 * @author jafre
 *Employee, Customer, and Tables not implemented yet
 *Might congest this into either object or separate methods
 */
public class Restaurant {
	
	//protected ArrayList<Employee> Employees;//Employees currently working at restaurant
	//protected ArrayList<Customer> Customers;//Customers currently dining at restaurant
	//protected ArrayList<Table> Tables;//Tables at the restaurant
	//protected static double Budget;//Amount of money
	//protected static ArrayList<Dish> Dishes;//The dishes our restaurant serves
	//protected static ArrayList<Ingredient> Ingredients;//The ingredients available at our restaurant
	
	public static void main (String [] args)
	{
		//ArrayList<Employee> Employees;//Employees currently working at restaurant
		//ArrayList<Customer> Customers;//Customers currently dining at restaurant
		//ArrayList<Table> Tables;//Tables at the restaurant
		double Budget;//Amount of money NO BUDGET AT THE MOMENT
		ArrayList<Dish> Dishes = new ArrayList<Dish>();//The dishes our restaurant serves
		ArrayList<Ingredient> Ingredients = new ArrayList<Ingredient>();//The ingredients available at our restaurant
		
		
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
		Dish Nachos = new Dish("Nachos",nachoIngredients);
		Dishes.add(Nachos);
		requiredIngredients.clear();
		
		requiredIngredients.add(chickenSauce);
		requiredIngredients.add(Celery);
		requiredIngredients.add(Ranch);
		Ingredient[] wingIngredients = new Ingredient[requiredIngredients.size()];
		requiredIngredients.toArray(wingIngredients);
		Dish Wings = new Dish("Wings", wingIngredients);
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
		Dish Burger = new Dish("Burger", burgerIngredients);
		Dishes.add(Burger);
		requiredIngredients.clear();
		
		requiredIngredients.add(Chicken);
		requiredIngredients.add(Bun);
		requiredIngredients.add(Lettuce);
		requiredIngredients.add(Tomato);
		requiredIngredients.add(Mayo);
		Ingredient[] chickenSandwichIngredients = new Ingredient[requiredIngredients.size()];
		requiredIngredients.toArray(chickenSandwichIngredients);
		Dish grilledChickenSandwich = new Dish("Grilled Chicken Sandwich", chickenSandwichIngredients);
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
		Dish DWater = new Dish("Water",waterIngredients);
		Dishes.add(DWater);
		requiredIngredients.clear();
		
		requiredIngredients.add(Water);
		requiredIngredients.add(Syrup);
		Ingredient[] sodaIngredients = new Ingredient[requiredIngredients.size()];
		requiredIngredients.toArray(sodaIngredients);
		Dish Soda = new Dish("Soda", sodaIngredients);
		Dishes.add(Soda);
		requiredIngredients.clear();
		
		requiredIngredients.add(Water);
		requiredIngredients.add(Tea);
		requiredIngredients.add(Syrup);
		Ingredient[] teaIngredients = new Ingredient[requiredIngredients.size()];
		requiredIngredients.toArray(teaIngredients);
		Dish icedTea = new Dish("Iced Tea", teaIngredients);
		Dishes.add(icedTea);
		requiredIngredients.clear();
		////////////END DRINK DISHES
	}
	
	//OpenDay()
	//ClockIn()
	//reStock(Ingredient, amount)//Maybe not do
	//assignServer()
	//printReceipt()
	//getMoney()
	//clockOut()
	//endDay()
	
}
