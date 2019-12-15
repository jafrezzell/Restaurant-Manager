package Classes;

import java.io.File;
import java.util.ArrayList;

public class RestarauntInfo {
	

	
	//Josh f
	private static Manager Bob = new Manager("Bob_Dylan", "M12", 24);//Default Manager
	//end josh f
	
	private static Chef chef1 =new Chef("Erik_V._Mathews III", "001255", 10.25);
	private static Chef chef2 =new Chef("Thomas_Kambell", "014245",13.75);
	private static Chef chef3 =new Chef("Aimee_Lee", "201922",11.00);

	private static Server server1= new Server("Ashley_Brown", "903751", 3.26);
	private static Server server2= new Server("John_Alimoe", "001836", 2.57);
	private static Server server3= new Server("Jenny_Yap", "234567", 4.55);
	
	private static ArrayList<Chef> chefs = new ArrayList<Chef>();
	private static ArrayList<Server> servers = new ArrayList<Server>();
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	
	//josh f
	private static ArrayList<Table> Tables = new ArrayList<Table>();//Tables at the restaurant
	private static ArrayList<Dish> Dishes = new ArrayList<Dish>();//The dishes our restaurant serves
	private static ArrayList<Ingredient> Ingredients = new ArrayList<Ingredient>();//The ingredients available at our restaurant
	//end josh f
	
	//file variables //created by Josh F.
	private static File ingredientFile = Manager.fileCreater("ingredientFile.txt", Ingredients, "Ingredient");//File containing ingredients
	private static File dishFile = Manager.fileCreater("dishFile.txt", Dishes, "Dish");//File containing dishes
	private static File employeeFile = Manager.fileCreater("employeeFile.txt", employees, "Employee");//File containing employees
	private static File tableFile = Manager.fileCreater("tableFile.txt", Tables, "Table");//File containing Tables
	//end Josh F
	
	
	//getters and setters for the files
	public static File getIngredientFile() {
		return ingredientFile;
	}
	
	public static File getDishFile() {
		return dishFile;
	}
	
	public static File getEmployeeFile() {
		return employeeFile;
	}
	
	public static File getTableFile() {
		return tableFile;
	}
	
	public static void setIngredientFile(File f) {
		ingredientFile = f;
	}
	
	public static void setDishFile(File f) {
		dishFile = f;
	}
	
	public static void setEmployeeFile(File f) {
		employeeFile = f;
	}
	
	public static void setTableFile(File f) {
		tableFile = f;
	}
	
	//methods
	public static void populate() {
		chefs.add(chef1);
		chefs.add(chef2);
		chefs.add(chef3);
		
		servers.add(server1);
		servers.add(server2);
		servers.add(server3);
		
		employees.addAll(chefs);
		employees.addAll(servers);
		employees.add(Bob);
		
	}

	
	
	
	public static boolean isEmployeeID(String ID) {
		for(Employee emp: employees) {
			if (emp.getEmployeeId().equals(ID))
				return true;
		}
		return false;
	}
	
	public static Employee getEmployee(String ID) {
		for(Employee emp: employees) {
			if(emp.getEmployeeId().equals(ID))
				return emp;
		}
		return null;
	}
	/*
	public static double calcAllWages() {
		double total = 0;
		for(Employee emp: employees) {
			
		}
	}
	
	*/


	//set and get for the arrayLists so managers can use them 
	//these setters pass references for arrayLists so items are not copied every edit will edit argument list and set list

	public static ArrayList<Employee> getEmployees() {
		return employees;
	}




	public static void setEmployees(ArrayList<Employee> employees) {
		RestarauntInfo.employees = employees;
	}




	public static ArrayList<Table> getTables() {
		return Tables;
	}




	public static void setTables(ArrayList<Table> tables) {
		Tables = tables;
	}




	public static ArrayList<Dish> getDishes() {
		return Dishes;
	}




	public static void setDishes(ArrayList<Dish> dishes) {
		Dishes = dishes;
	}




	public static ArrayList<Ingredient> getIngredients() {
		return Ingredients;
	}




	public static void setIngredients(ArrayList<Ingredient> ingredients) {
		Ingredients = ingredients;
	}
	

	//add dish so we can have one record of each dish
	public static void addDish(Dish d) {
		Dishes.add(d);
	}
	
	//add ingredient so we have one record of each ingredient
	public static void addIngredient(Ingredient ing) {
		Ingredients.add(ing);
	}
}
