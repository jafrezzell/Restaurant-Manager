public class Employee extends Person{
  protected String employeeId;
  protected double hourlyWage;
  protected double amountMade;
  public Employee(String name, String employeeId, double hourlyWage, double amountMade){
    super(name);
    this.employeeId=employeeId;
    this.hourlyWage=hourlyWage;
    this.amountMade=0;}
  public String getEmployeeId(){
    return this.employeeId;}
  public void setEmployeeId(String employeeId){
    this.employeeId=employeeId;}
  public double getHourlyWage(){
    return this.hourlyWage;}
  public void setHourlyWage(double hourlyWage){
    this.hourlyWage=hourlyWage;}
  public void setAmountMade(double d){
    this.amountMade = d;}
  public double getAmountMade(){
    return this.amountMade;}
}
