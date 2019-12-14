import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author jafre
 *Class created for the purpose of managers to manage overall restaurant functionalities (such as add/removing employees, updating the menu, etc.)
 */
public class Manager extends Employee{
	
	/**
	 * Constructor for Manager Class
	 * @param name:  First and last name of manager
	 * @param employeeId:  ID of manager
	 * @param hourlyWage:  HourlyWage of manager
	 * @param password:  Password of manager
	 */
	public Manager(String name, String employeeId, double hourlyWage)
	{
		super(name, employeeId, hourlyWage);
	}//END Manager()

	
///////////////////CUSTOM METHODS
	/**
	 * Creates an empty file for a specified list of items (such as Ingredients, Dishes, Employees, Tables).
	 * If file already exists, reads in information from specified files and saves them to lists in the running program.
	 * @param <T>: Generic for type of ArrayList (is only going to be Ingredient, Dish, Employee, Table)
	 * @param fileName: Name of the file
	 * @param listofItems: List to have information inputted
	 * @param type: Helper variable for type of items in the ArrayList
	 */
	@SuppressWarnings("unchecked")
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
	
	
	/**
	 * Adds an employee by first adding the new employee to arraylist in program, clearing the associated employee file, then writing to the employee file the new information
	 * @param newEmployee:  New employee to be added
	 * @param Employees:  Arraylist of employees
	 * @param employeeFile:  File of employees
	 */
	public static void addEmployee(Employee newEmployee, ArrayList<Employee> Employees, File employeeFile)
	{
		Employees.add(newEmployee);
		clearFile(employeeFile);
		employeeFile = fileCreater("employeeFile.txt", Employees, "Employee");
		writeToFile(Employees, employeeFile);
	}
	/**
	 * Removes an employee by first removing the old employee from arraylist in program, clearing the associated employee file, then writing to the employee file the new information
	 * @param oldEmployee:  Employee to be removed
	 * @param Employees:  Arraylist of Employees
	 * @param employeeFile:  File containing employees
	 */
	public static void removeEmployee(Employee oldEmployee, ArrayList<Employee> Employees, File employeeFile)
	{
		Employees.remove(oldEmployee);
		clearFile(employeeFile);
		employeeFile = fileCreater("employeeFile.txt",Employees, "Employees");
		writeToFile(Employees, employeeFile);
		
	}//end removeEmployee()
	
	
	/**
	 * Adds a table by first adding the new table to arraylist in program, clearing the associated table file, then writing to the table file the new information
	 * @param newTable:  Table to be added
	 * @param Tables:  Arraylist of tables in restaurant
	 * @param tableFile:  File containing tables
	 */
	public static void addTable(Table newTable, ArrayList<Table> Tables, File tableFile)
	{
		Tables.add(newTable);
		clearFile(tableFile);
		tableFile = fileCreater("tableFile.txt", Tables, "Table");
		writeToFile(Tables, tableFile);
	}//END addTable()
	/**
	 * Removes a table by first removing the old table from arraylist in program, clearing the associated table file, then writing to the table file the new information
	 * @param oldTable:  Table to be removed
	 * @param Tables:  Arraylist of tables
	 * @param tableFile:  File containing tables
	 */
	public static void removeTable(Table oldTable, ArrayList<Table> Tables, File tableFile)
	{
		Tables.remove(oldTable);
		clearFile(tableFile);
		tableFile = fileCreater("tableFile.txt", Tables, "Table");
		writeToFile(Tables, tableFile);
	}//END removeTable()
	
	
	/**
	 * Adds a dish by first adding the new dish to arraylist in program, clearing the associated dish file, then writing to the dish file the new information
	 * @param newDish:  New dish to be added
	 * @param Dishes:  Arraylist of Dishes
	 * @param dishFile:  File containing dishes of restaurant
	 */
	public static void addDish(Dish newDish, ArrayList<Dish> Dishes, File dishFile)
	{
		Dishes.add(newDish);
		clearFile(dishFile);
		dishFile = fileCreater("dishFile.txt", Dishes, "Dish");
		writeToFile(Dishes, dishFile);
	}
	/**
	 * Removes a dish by first removing the old dish from arraylist in program, clearing the associated dish file, then writing to the dish file the new information
	 * @param oldDish:  Old dish to be removed
	 * @param Dishes:  Arraylist of dishes
	 * @param dishFile:  File containing dishes
	 */
	public static void removeDish(Dish oldDish, ArrayList<Dish> Dishes, File dishFile)
	{
		Dishes.remove(oldDish);
		clearFile(dishFile);
		dishFile = fileCreater("dishFile.txt", Dishes, "Dish");
		writeToFile(Dishes, dishFile);
	}//END rmeoveDish()
	
	
	/**
	 * Adds an ingredient by first adding the new ingredient to arraylist in program, clearing the associated ingredient file, then writing to the ingredient file the new information
	 * @param newIngredient
	 * @param Ingredients
	 * @param ingredientFile
	 */
	public static void addIngredient(Ingredient newIngredient, ArrayList<Ingredient>Ingredients, File ingredientFile)
	{
		Ingredients.add(newIngredient);
		clearFile(ingredientFile);
		ingredientFile = fileCreater("ingredientFile.txt", Ingredients, "Ingredient");
		writeToFile(Ingredients, ingredientFile);
	}
	/**
	 * Removes an ingredient by first removing the old ingredient from arraylist in program, clearing the associated ingredient file, then writing to the ingredient file the new information
	 * @param oldIngredient:  Ingredient to be removed
	 * @param Ingredients:  Arraylist of ingredients
	 * @param ingredientFile:  File containing ingredients
	 */
	public static void removeIngredient(Ingredient oldIngredient, ArrayList<Ingredient> Ingredients, File ingredientFile)
	{
		Ingredients.remove(oldIngredient);
		clearFile(ingredientFile);
		ingredientFile = fileCreater("ingredientFile.txt", Ingredients, "Ingredient");
		writeToFile(Ingredients, ingredientFile);
	}
	
/////END CUSTOM METHODS	
}
