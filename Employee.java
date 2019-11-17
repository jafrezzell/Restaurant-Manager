public class Employee extends Person{
  protected String employeeId;
  public Employee(String name, String employeeId){
    super(name);
    this.employeeId=employeeId;}
  public String getEmployeeId(){
    return this.employeeId;}
  public void setEmployeeId(String employeeId){
    this.employeeId=employeeId;}
}