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
	public String mostPopularDish(ArrayList<Dish> cooked, ArrayList<Dish> dishes) {
		ArrayList<Integer> numOrdered = new ArrayList<Integer>(dishes.size());
		for(int i = 0; i < numOrdered.size(); i++) {
			numordered[i] = 0;
		}	
		for(Dish d: cooked) {
			public int x = dishes.indexOf(d);
			numOrdered[x]++;
		}
		Integer maxValue = numOrdered[0];
		for(int j = 1; j < numOrdered.size(); j++) {
			if(numOrdered[i] > maxValue;)
				maxValue = numOrdered[j];
		}
		indexOfMostOrdered = numOrdered.indexOf(maxValue);
		return dishes[indexOfMostOrdered].getDishName();
	}
}
