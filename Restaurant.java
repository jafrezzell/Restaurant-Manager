import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main method for restaurant manager system
 * @author jafre
 *Employee, Customer, and Tables not implemented yet
 *NOTE:  DO NOT ADD Manager to Employees ArrayList, it might break program plus you'll only have one manager at a restaurant
 *NOTE:  MIGHT HAVE TO MAKE MANAGER FILE
 *NOTE:  updateBudget() not implemented
 *NOTE:  ADD MANAGER PASSWORD PARAMETER TO MANAGER FUNCTIONALITIES (like addEmployee etc.)
 *NOTE:  MIGHT HAVE TO ADD PASSWORD FUNCTIONALITY FOR EMPLOYEES
 */
public class Restaurant {
	
	public static void main (String [] args)
	{
		ArrayList<Employee> Employees = new ArrayList<Employee>();//Employees currently working at restaurant
		ArrayList<Table> Tables = new ArrayList<Table>();//Tables at the restaurant
		double Budget;//Amount of money NO BUDGET AT THE MOMENT
		ArrayList<Dish> Dishes = new ArrayList<Dish>();//The dishes our restaurant serves
		ArrayList<Ingredient> Ingredients = new ArrayList<Ingredient>();//The ingredients available at our restaurant
		
		File ingredientFile = fileCreater("ingredientFile.txt", Ingredients, "Ingredient");//File containing ingredients
		File dishFile = fileCreater("dishFile.txt", Dishes, "Dish");//File containing dishes
		File employeeFile = fileCreater("employeeFile.txt", Employees, "Employee");//File containing employees
		File tableFile = fileCreater("tableFile.txt", Tables, "Table");//File containing Tables
		
		//Manager Bob = new Manager("Bob_Dylan", "12", 24, "69");
		
		/*FOLLOWING COMMENTED CODE IS TEST CODE FOR FILES TO ENSURE THAT ADDING AND REMOVING FUNCTIONALITIES
		 **save to files, if you uncomment them, they don't do anything because they just add then remove immediately*/
		/*addEmployee(new Employee("Tim_Dude", "12345", 69), Employees, employeeFile);
		removeEmployee(Employees.get(3), Employees, employeeFile);
		
		addTable(new Table(5), Tables, tableFile);
		removeTable(Tables.get(4), Tables, tableFile);
		
		ArrayList<Ingredient> nachoIngredients = new ArrayList<Ingredient>();
		Ingredient chickenSauce = new Ingredient("Chicken_Sauce",1.00,2.00);
		Ingredient Celery = new Ingredient("Celery",1.50,0.99);
		Ingredient Ranch = new Ingredient("Ranch",4.50,3.50);
		nachoIngredients.add(Celery);
		nachoIngredients.add(chickenSauce);
		nachoIngredients.add(Ranch);
		addDish(new Dish("Nachos", nachoIngredients), Dishes, dishFile);
		removeDish(Dishes.get(3), Dishes, dishFile);
		
		addIngredient(new Ingredient("Sprite_Cranberry",20,40), Ingredients, ingredientFile);
		removeIngredient(Ingredients.get(3), Ingredients, ingredientFile);*/
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * Creates an empty file for a specified list of items (such as Ingredients, Dishes, Employees, Tables).
	 * If file already exists, reads in information from specified files and saves them to lists in the running program.
	 * @param <T>: Generic for type of ArrayList (is only going to be Ingredient, Dish, Employee, Table)
	 * @param fileName: Name of the file
	 * @param listofItems: List to have information inputted
	 * @param type: Helper variable for type of items in the ArrayList
	 */
	public static <T> File fileCreater(String fileName, ArrayList<T> listofItems, String type)
	{
		File newFile = new File(System.getProperty("user.dir")+File.separator+fileName);//new file to be created (file located in project folder so it automatically changes)
		if(!newFile.exists())
		{
			try {
				File directory = new File(newFile.getParent());//directory to be created
				if(!directory.exists())
					directory.mkdirs();
				
				newFile.createNewFile();
			}
			catch(IOException e){
				System.out.println("Error has occurred:  "+ e.toString());
			}
		}
		else
		{
			Scanner fileScnr;//Scanner for the file
			try {
				fileScnr = new Scanner(newFile);
				switch(type)
				{
				case "Ingredient"://START INGREDIENTCASE
					while(fileScnr.hasNextLine())
						listofItems.add((T)new Ingredient(fileScnr.next(),Double.parseDouble(fileScnr.next()),Double.parseDouble(fileScnr.next())));
					break;//END INGREDIENTCASE
					
				case "Dish"://START DISHCASE
					String tempName = "";
					while(fileScnr.hasNextLine())
					{
						ArrayList<Ingredient>requiredIngredients = new ArrayList<Ingredient>();
						tempName = fileScnr.next();
						
						Scanner lineScnr = new Scanner(fileScnr.nextLine());
						
						while(lineScnr.hasNext())
							requiredIngredients.add(new Ingredient(lineScnr.next(), Double.parseDouble(lineScnr.next()), Double.parseDouble(lineScnr.next())) );
						
						listofItems.add((T) new Dish(tempName, requiredIngredients));
						lineScnr.close();
					}
					break;///END DISHCASE
				
				case "Employee"://START EMPLOYEECASE
					while(fileScnr.hasNextLine())
						listofItems.add((T) new Employee(fileScnr.next(), fileScnr.next(), Double.parseDouble(fileScnr.next())));
					break;//END EMPLOYEECASE
					
				case "Table"://START TABLECASE
					while(fileScnr.hasNextLine())
						listofItems.add((T) new Table(Integer.parseInt(fileScnr.next())));
					break;//END TABLECASE

				}//END SWITCH STATEMENT
				fileScnr.close();
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return newFile;
	}//END fileCreater()
	
	@SuppressWarnings("unchecked")
	/**
	 * Writes specified information to file.  Used to save information to files, should only be accessed by Manger (not implemented currently for Manager)
	 * NOTE:  Only use this method when adding or removing different aspects of the restaurant (such as ingredients, dishes, employees, etc.)
	 * @param <T>:  Generic for type of ArrayList
	 * @param listofItems:  List of items to be added to file
	 * @param fileToWrite:  File to be written to
	 */
	public static <T> void writeToFile(ArrayList<T> listofItems, File fileToWrite)
	{
		FileWriter fWriter;
		BufferedWriter bWriter;
		try {
			fWriter = new FileWriter(fileToWrite.getAbsoluteFile(), true);
			bWriter = new BufferedWriter(fWriter);
			if(listofItems.get(0) instanceof Employee)
			{
				for(int i = 0; i < listofItems.size(); i++)
				{
					bWriter.write(  ((ArrayList<Employee>)listofItems).get(i).name +" "+ ((ArrayList<Employee>)listofItems).get(i).employeeId+" "+ ((ArrayList<Employee>)listofItems).get(i).hourlyWage);
					if(i+1 < listofItems.size())
						bWriter.newLine();
				}
				bWriter.close();
			}
			else if(listofItems.get(0) instanceof Table)
			{
				for(int i = 0; i < listofItems.size(); i++)
				{
					bWriter.write( ((ArrayList<Table>)listofItems).get(i).tableNumber+"" );
					if(i+1 < listofItems.size())
						bWriter.newLine();
				}
				bWriter.close();
			}
			else if(listofItems.get(0) instanceof Dish)
			{
				for(int i = 0; i < listofItems.size(); i++)
				{
					bWriter.write( ((ArrayList<Dish>)listofItems).get(i).dishName+" " );
					for(int j = 0; j < ((ArrayList<Dish>)listofItems).get(i).requiredIngredients.size();j++)
					{
						bWriter.write(((ArrayList<Dish>)listofItems).get(i).requiredIngredients.get(j).name+" "+((ArrayList<Dish>)listofItems).get(i).requiredIngredients.get(j).customerPrice +" "+((ArrayList<Dish>)listofItems).get(i).requiredIngredients.get(j).restaurantPrice);
						if(j+1 < ((ArrayList<Dish>)listofItems).get(i).requiredIngredients.size())
							bWriter.write(" ");
					}
					if(i+1 < listofItems.size())
						bWriter.newLine();
				}
				bWriter.close();
			}
			
			else if(listofItems.get(0) instanceof Ingredient)
			{
				for(int i = 0; i < listofItems.size();i++)
				{
					bWriter.write(  ((ArrayList<Ingredient>)listofItems).get(i).name +" "+ ((ArrayList<Ingredient>)listofItems).get(i).customerPrice +" "+ ((ArrayList<Ingredient>)listofItems).get(i).restaurantPrice);
					if(i+1 < listofItems.size())
						bWriter.newLine();
				}
				bWriter.close();
			}
			fWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Clears a file
	 * @param fileToClear:  File to clear
	 */
	public static void clearFile(File fileToClear)
	{
			FileWriter fWriter;
			try {
				fWriter = new FileWriter(fileToClear.getAbsoluteFile(),false);
				fWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}
	
	//Following methods have same functionality and operation, they add/remove the specified item by first adding the specified
	//item to the program then deleting the contents of the file and then writing the newly updated contents to the new File
	public static void addEmployee(Employee newEmployee, ArrayList<Employee> Employees, File employeeFile)
	{
		Employees.add(newEmployee);
		clearFile(employeeFile);
		employeeFile = fileCreater("employeeFile.txt", Employees, "Employee");
		writeToFile(Employees, employeeFile);
	}
	public static void removeEmployee(Employee oldEmployee, ArrayList<Employee> Employees, File employeeFile)
	{
		Employees.remove(oldEmployee);
		clearFile(employeeFile);
		employeeFile = fileCreater("employeeFile.txt",Employees, "Employees");
		writeToFile(Employees, employeeFile);
	}
	
	public static void addTable(Table newTable, ArrayList<Table> Tables, File tableFile)
	{
		Tables.add(newTable);
		clearFile(tableFile);
		tableFile = fileCreater("tableFile.txt", Tables, "Table");
		writeToFile(Tables, tableFile);
	}
	public static void removeTable(Table oldTable, ArrayList<Table> Tables, File tableFile)
	{
		Tables.remove(oldTable);
		clearFile(tableFile);
		tableFile = fileCreater("tableFile.txt", Tables, "Table");
		writeToFile(Tables, tableFile);
	}
	
	public static void addDish(Dish newDish, ArrayList<Dish> Dishes, File dishFile)
	{
		Dishes.add(newDish);
		clearFile(dishFile);
		dishFile = fileCreater("dishFile.txt", Dishes, "Dish");
		writeToFile(Dishes, dishFile);
	}
	public static void removeDish(Dish oldDish, ArrayList<Dish> Dishes, File dishFile)
	{
		Dishes.remove(oldDish);
		clearFile(dishFile);
		dishFile = fileCreater("dishFile.txt", Dishes, "Dish");
		writeToFile(Dishes, dishFile);
	}
	
	public static void addIngredient(Ingredient newIngredient, ArrayList<Ingredient>Ingredients, File ingredientFile)
	{
		Ingredients.add(newIngredient);
		clearFile(ingredientFile);
		ingredientFile = fileCreater("ingredientFile.txt", Ingredients, "Ingredient");
		writeToFile(Ingredients, ingredientFile);
	}
	public static void removeIngredient(Ingredient oldIngredient, ArrayList<Ingredient> Ingredients, File ingredientFile)
	{
		Ingredients.remove(oldIngredient);
		clearFile(ingredientFile);
		ingredientFile = fileCreater("ingredientFile.txt", Ingredients, "Ingredient");
		writeToFile(Ingredients, ingredientFile);
	}
	
	//OpenDay()
	//ClockIn()
	//reStock(Ingredient, amount)//Maybe not do
	//assignServer()
	//printReceipt()
	//getMoney()
	//clockOut()
	//endDay()
	
	//***FOLLOWING COMMENTED CODE IS ORIGINAL MAIN METHOD CONTENTS BEFORE FILE UPDATE
	//INGREDIENTS
			//Ingredient chickenSauce = new Ingredient("Chicken_Sauce",1.00,2.00);
			//Ingredients.add(chickenSauce);
			//Ingredient Celery = new Ingredient("Celery",1.50,0.99);
			//Ingredients.add(Celery);
			//Ingredient Ranch = new Ingredient("Ranch",4.50,3.50);
			//Ingredients.add(Ranch);
			/*Ingredient Chips = new Ingredient("Chips",2.50,0.99);
			Ingredients.add(Chips);
			Ingredient Cheese = new Ingredient("Cheese",5.00,3.00);
			Ingredients.add(Cheese);
			Ingredient Tomato = new Ingredient("Tomato",3.50,2.50);
			Ingredients.add(Tomato);
			Ingredient Jalapeno = new Ingredient("Jalapeno",7.50,5.00);
			Ingredients.add(Jalapeno);
			Ingredient groundBeef = new Ingredient("Ground_Beef",15.50,10.00);
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
			Ingredient marinaraSauce = new Ingredient("Marinara_Sauce",5.00,3.50);
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
			Dish grilledChickenSandwich = new Dish("Grilled_Chicken_Sandwich", chickenSandwichIngredients);
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
			*/
/////////////////END OLD MAIN METHOD CONTENTS			

	
}
