import java.util.*;
public class Report {
	public double moneyIn(ArrayList<Dish> cooked) {
		double total = 0;
		for(Dish d: cooked)
			total += d.priceToSell();
		return total;
	}
	public double moneyOutFood(ArrayList<Dish> cooked) {
		double total = 0;
		for(Dish d: cooked)
			total += d.priceToMake();
		return total;
	}
	public double moneyOutPeople(ArrayList<Employee> employees ){
		double total = 0;
		for(Employee e: employees)
			total += e.getAmountMade();
		return total;
	}
	
}
