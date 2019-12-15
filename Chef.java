package Classes;

/**
*
* @author laurahodge
* Class that allows a chef to clock in and out using the computer time to calculate their hours worked.
*/


public class Chef extends Employee{
	 // kitchen class to cook, cooking, and cooked (remove method)
	 // hourly wage, double time stamp in/out, hours worked (out-in)
	  
	 /** 
	 * Constructor for Chef Class
	 * @param name: Name of Chef
	 * @param employeeId: EmployeeId
	 * @param hourlyWage: Hourly wage for chef
	 * @param amountMade: Total amount the restaurant has made for the day
	 */
	public Chef(String name, String employeeId, double hourlyWage){
	    super(name, employeeId, hourlyWage);
	    
	  }
	  public double timeIn(){
	    //just here for declaration (use computer time)
	    return hourlyWage;
	    }
	  
	  public double timeOut(){
	    //just here for declaration (use computer time)
	    return hourlyWage;
	    }
	  
	  public double hoursWorked(){
	    return timeOut()-timeIn();
	    }
	  
	}
