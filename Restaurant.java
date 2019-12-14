/**
 * Main method for restaurant manager system
 * @author jafre
 */
public class Restaurant {
	
	public static void main (String [] args)
	{
		Manager Bob = new Manager("Bob_Dylan", "M12", 24);//Default Manager
		
		ArrayList<Employee> Employees = new ArrayList<Employee>();//Employees currently working at restaurant
		ArrayList<Table> Tables = new ArrayList<Table>();//Tables at the restaurant
		double Budget;//Amount of money NO BUDGET AT THE MOMENT
		ArrayList<Dish> Dishes = new ArrayList<Dish>();//The dishes our restaurant serves
		ArrayList<Ingredient> Ingredients = new ArrayList<Ingredient>();//The ingredients available at our restaurant
		
		
		File ingredientFile = Manager.fileCreater("ingredientFile.txt", Ingredients, "Ingredient");//File containing ingredients
		File dishFile = Manager.fileCreater("dishFile.txt", Dishes, "Dish");//File containing dishes
		File employeeFile = Manager.fileCreater("employeeFile.txt", Employees, "Employee");//File containing employees
		File tableFile = Manager.fileCreater("tableFile.txt", Tables, "Table");//File containing Tables
		
		
		/*FOLLOWING COMMENTED CODE IS TEST CODE FOR FILES TO ENSURE THAT ADDING AND REMOVING FUNCTIONALITIES
		 **save to files, if you uncomment them, they don't do anything because they just add then remove immediately*/
		/*Manager.addEmployee(new Employee("Tim_Dude", "12345", 695), Employees, employeeFile);
		Manager.removeEmployee(Employees.get(4), Employees, employeeFile);
		
		Manager.addTable(new Table(5), Tables, tableFile);
		Manager.removeTable(Tables.get(4), Tables, tableFile);
		
		ArrayList<Ingredient> nachoIngredients = new ArrayList<Ingredient>();
		Ingredient chickenSauce = new Ingredient("Chicken_Sauce",1.00,2.00);
		Ingredient Celery = new Ingredient("Celery",1.50,0.99);
		Ingredient Ranch = new Ingredient("Ranch",4.50,3.50);
		nachoIngredients.add(Celery);
		nachoIngredients.add(chickenSauce);
		nachoIngredients.add(Ranch);
		Manager.addDish(new Dish("Nachos", nachoIngredients), Dishes, dishFile);
		Manager.removeDish(Dishes.get(3), Dishes, dishFile);
		
		Manager.addIngredient(new Ingredient("Sprite_Cranberry",20,40), Ingredients, ingredientFile);
		Manager.removeIngredient(Ingredients.get(3), Ingredients, ingredientFile);*/
	}
	
}
