/**
*
* @author lahod
* Class that allows a chef to clock in and out using the computer time to calculate their hours worked.
*/

public class Chef extends Employee{
 // kitchen class to cook, cooking, and cooked (remove method)
 // hourly wage, double time stamp in/out, hours worked (out-in)
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
  
