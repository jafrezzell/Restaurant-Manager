package Classes;

import java.util.ArrayList;
/**
*
* @author laurahodge
* Class that creates the Server which is a child of Employee.
*/
public class Server extends Employee{
  protected double tips;
  ArrayList <Table> tables=new ArrayList<Table>();
  /**
  * Constructor for Server Class
  * @param name: Name of server
  * @param employeeId: Employee Id for server
  * @param hourlyWage: Amount server makes per hour
  * @param amountMade: Amount server made that day
  */
  public Server(String name, String employeeId, double hourlyWage){
    super(name, employeeId, hourlyWage);
    tips=0;}
  
  public void addTips(double amount){ //adds tips to amount
    tips+=amount;}
  
  public double getTips(){ //getter for tips
    return this.tips;}
  
  public void setTips(double tips){ //setter for tips
    this.tips=tips;}
}
    
  