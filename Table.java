import java.util.ArrayList;
public class Table{
  //ArrayList <Customer> customers;
  int customers;
  ArrayList<Dish> orders;
  protected int tableNumber;
  public Table(int tableNumber){
    this.tableNumber = tableNumber;
    //this.customers = new ArrayList<Customer>();
    this.orders = new ArrayList<Dish>();
    customers = 0;
  }
  public int getTableNumber(){
    return this.tableNumber;}
  public void setTableNumber(int tableNumber){
    this.tableNumber=tableNumber;}
  public boolean isEmpty(){
    if (customers == 0)
      return true;
    else
      return false;
  }
  public void addDishes(Dish d){
    orders.add(d);
  }
  /*public void addCustomers(Customer c){
    customers.add(c);
  }*/
  public void setCustomers(int num){
    this.customers = num;
  }   
  @Override
  public String toString(){
    return ("Table" + tableNumber);
  }
}