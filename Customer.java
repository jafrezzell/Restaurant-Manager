public class Customer extends Person{
  public double budget;
  public double costOfMeal;
  public String dishOrdered;
  public Customer(String name, double budget, double costOfMeal, String dishOrdered){
    super(name);
    this.budget=budget;
    this.costOfMeal=costOfMeal;
    this.dishOrdered=dishOrdered;
    if (this.costOfMeal>this.budget){
      System.out.println("Meal is too expensive.");}
  }
  public double getBudget(){
    return this.budget;}
  public void setBudget(double budget){
    this.budget=budget;}
  public double getCostofMeal(){
    return this.costOfMeal;}
  public void setCostofMeal(double costOfMeal){
    this.costOfMeal=costOfMeal;}
  public String getDishOrdered(){
    return this.dishOrdered;}
  public void setDishOrdered(String dishOrdered){
    this.dishOrdered=dishOrdered;}
}
  
  
  