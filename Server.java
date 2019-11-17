import java.util.ArrayList;
public class Server extends Employee{
  protected double tips;
  ArrayList <Table> tables=new ArrayList<Table>();
  public Server(String name, String employeeId, double tips){
    super(name, employeeId);
    this.tips=tips;}
  public double getTips(){
    return this.tips;}
  public void setTips(double tips){
    this.tips=tips;}
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
    
  
