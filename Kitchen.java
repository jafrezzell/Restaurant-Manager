import java.util.ArrayList;
public class Kitchen{
  protected ArrayList<Dish> orders;
  public Kitchen(){
    orders = new ArrayList<Dish>();
  }
  public void toCook(Dish d){
    orders.add(d);
  }
  public Dish cooked(Dish d){
    return orders.remove(d);
  }
  
}