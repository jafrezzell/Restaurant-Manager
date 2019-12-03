public class Employee extends Person{
  protected String employeeId;
  protected double hourlyWage;
  public Employee(String name, String employeeId, double hourlyWage){
    super(name);
    this.employeeId=employeeId;
    this.hourlyWage=hourlyWage;}
  public String getEmployeeId(){
    return this.employeeId;}
  public void setEmployeeId(String employeeId){
    this.employeeId=employeeId;}
  public double getHourlyWage(){
    return this.hourlyWage;}
  public void setHourlyWage(double hourlyWage){
    this.hourlyWage=hourlyWage;}
}
