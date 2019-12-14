/**
*
* @author laurahodge
* Class that allows a chef to clock in and out using the computer time to calculate their hours worked.
*/

public class Chef extends Employee{
 /** 
 * Constructor for Chef Class
 * @param name: Name of Chef
 * @param employeeId: EmployeeId
 * @param hourlyWage: Hourly wage for chef
 * @param amountMade: Total amount the restaurant has made for the day
 */
  public Chef(String name, String employeeId, double hourlyWage, double amountMade){
    super(name, employeeId, hourlyWage, amountMade);}
  public double timeIn(){
    //just here for declaration (use computer time)
    return hourlyWage;}
  public double timeOut(){
    //just here for declaration (use computer time)
    return hourlyWage;}
  public double hoursWorked(){
    return timeOut()-timeIn();}
}
  
