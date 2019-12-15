package Classes;

/**
*
* @author laurahodge
* Class that allows the Employee to be a Person and have an employeeId, hourlyWage, and amount they made
*/

public class Employee extends Person{
	
	  protected String employeeId;
	  protected double hourlyWage;
	  
	  //Sam Irvin
	  protected boolean isClockedIn;
	  protected long clockInTime;
	  protected long clockOutTime;
	  //end Sam Irvin
	  
	  /**
	   * Constructor for the Employee Class
	   * @param name: Name of Employee
	   * @param employeeId: Id for employee
	   * @param hourlyWage: amount the employee makes hourly
	   * @param amountMade: amount the employee made for the day
	   */
	  
	  public Employee(String name, String employeeId, double hourlyWage){
	    super(name);
	    this.employeeId=employeeId;
	    this.hourlyWage=hourlyWage;
	    
	    //Sam Irvin
	    isClockedIn = false;
	    clockInTime = 0;
	    clockOutTime = 0;
	    //end Sam Irvin
	    }
	  
	  public String getEmployeeId(){
	    return this.employeeId;
	    }
	  
	  public void setEmployeeId(String employeeId){
	    this.employeeId=employeeId;
	    }
	  
	  public double getHourlyWage(){
	    return this.hourlyWage;
	    }
	  
	  public void setHourlyWage(double hourlyWage){
	    this.hourlyWage=hourlyWage;
	    }
	  
	  //Sam Irvin
	  public boolean isClockedIn() {
		  return isClockedIn;
	  }
	  
	  public void setClockInTime(long c) {
		  clockInTime = c;
		  isClockedIn = true;
	  }
	  
	  public void setClockOutTime(long c) {
		  clockOutTime = c;
		  isClockedIn = false;
	  }

	  public long getClockIn() {
		  return clockInTime;
	  }
	  
	  public long getClockOut() {
		  return clockOutTime;
	  }
	  
	  public double hoursWorked() {
		// double hours = (((clockOutTime - clockInTime)) / (1000.0 * 60.0 * 60.0));
		 return ((clockOutTime - clockInTime) * ((1.0 / 1000.0) * (1.0 / 60.0) * (1.0 / 60.0)));
	  }
	  
	}