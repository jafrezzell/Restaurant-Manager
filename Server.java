import java.util.ArrayList;
public class Server extends Employee{
  protected double tips;
  ArrayList <Table> tables=new ArrayList<Table>();
  public Server(String name, String employeeId, double hourlyWage, double amountMade){
    super(name, employeeId, hourlyWage, amountMade);
    tips=0;}
  public void addTips(double amount){
    tips+=amount;}
  /*public void fillTables(ArrayList <Customer> tables){
    int tableNum=this.getCustomer().getTableNumber();
    if (tables.get(tableNum)==null){
      tables.set(tableNum)=this.Person().getName();}
    else{
      System.out.println("Table is in use, please choose a different table.");}
  }  */
}
    
  
