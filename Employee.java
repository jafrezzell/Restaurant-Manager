/**
*
* @author laurahodge
* Class that allows the Employee to be a Person and have an employeeId, hourlyWage, and amount they made
*/
public class Employee extends Person{
  protected String employeeId;
  protected double hourlyWage;
  protected double amountMade;
  /**
  * Constructor for the Employee Class
  * @param name: Name of Employee
  * @param employeeId: Id for employee
  * @param hourlyWage: amount the employee makes hourly
  * @param amountMade: amount the employee made for the day
  */
  public Employee(String name, String employeeId, double hourlyWage, double amountMade){
    super(name);
    this.employeeId=employeeId;
    this.hourlyWage=hourlyWage;
    this.amountMade=0;}
  public String getEmployeeId(){ //getter for employeeId
    return this.employeeId;}
  public void setEmployeeId(String employeeId){ //setter for employeeId
    this.employeeId=employeeId;}
  public double getHourlyWage(){ //getter for hourlyWage
    return this.hourlyWage;}
  public void setHourlyWage(double hourlyWage){ //setter for hourlyWage
    this.hourlyWage=hourlyWage;}
  public void setAmountMade(double d){ //setter for amount made
    this.amountMade = d;}
  public double getAmountMade(){ //getter for amount made
    return this.amountMade;}
}
