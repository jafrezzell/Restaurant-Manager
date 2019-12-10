import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author jafre
 *Class created for the purpose of managers to manage overall restaurant functionalities (such as add/removing employees, updating the menu, etc.)
 *NOTE:  Any commented code that has [REMOVE] indicates to remove that comment to ensure code functionality
 */
public class Manager extends Employee{
	
	protected ArrayList<Employee> Employees;//Employees currently working at restaurant
	protected ArrayList<Table> Tables;//Tables at the restaurant
	protected ArrayList<Dish> Dishes;//The dishes our restaurant serves
	protected ArrayList<Ingredient> Ingredients;//The ingredients available at our restaurant*/
	//protected double Budget;//Amount of money
	protected String password;//Password for Manager
	
	/**
	 * Constructor for Manager Class
	 * @param name
	 * @param employeeId
	 * @param hourlyWage
	 * @param password
	 */
	public Manager(String name, String employeeId, double hourlyWage, String password)
	{
		super(name, employeeId, hourlyWage);
		this.password = password;
	}//END Manager()
	
	/////////////////////GETTERS
	public String getPassword()
	{
		return this.password;
	}
	
	////////////////////SETTERS
	public void setPassword(String password)
	{
		this.password = password;
	}
}
