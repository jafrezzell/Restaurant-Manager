public class Chef extends Employee{
 // kitchen class to cook, cooking, and cooked (remove method)
 // hourly wage, double time stamp in/out, hours worked (out-in)
  protected double hourlyWage;
  public Chef(String name, String employeeId, double hourlyWage){
    super(name, employeeId);
    this.hourlyWage=hourlyWage;}
  public double getHourlyWage(){
    return this.hourlyWage;}
  public void setHourlyWage(double hourlyWage){
    this.hourlyWage=hourlyWage;}
  public double timeIn(){
    //just here for declaration (use computer time)
    return hourlyWage;}
  public double timeOut(){
    //just here for declaration (use computer time)
    return hourlyWage;}
  public double hoursWorked(){
    return timeOut()-timeIn();}
}
  