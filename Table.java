package Classes;

import java.util.ArrayList;

public class Table{
  //ArrayList <Customer> customers;
  int customers;
  ArrayList<Dish> orders;
  protected int tableNumber;
  //Sam IRvin
  protected double tipAmount;
  public Table(int tableNumber){
    this.tableNumber = tableNumber;
    //this.customers = new ArrayList<Customer>();
    this.orders = new ArrayList<Dish>();
    customers = 0;
    tipAmount = 0;
  }
  public int getTableNumber(){
    return this.tableNumber;}
  public void setTableNumber(int tableNumber){
    this.tableNumber=tableNumber;}
  public boolean isEmpty(){
	  if(orders.size() <= 0)
		  return true;
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
  
  //Sam's change for now
  public String toString() {
	 String str = "";
	 str += "Table " + tableNumber;
	 return str;
  }
  
  public double calcBill() {
	  double total = 0;
	  for(Dish d: orders) {
		  total += d.priceToSell;
	  }
	  return total;
  }
  
  public void setTip(double t) {
	  tipAmount = t;
  }
  public double getTip() {
	  return tipAmount;
  }
  
  public void clearTable() {
	  tipAmount = 0;
	  orders.clear();
	  
  }
  
}
