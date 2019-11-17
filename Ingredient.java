/**
 * 
 * @author jafre
 *Class that represents the ingredients in a specified dish
 */
public class Ingredient {//FIXME
	
	protected String name;//Name of the ingredient
	protected int amountRemaining;//Amount of ingredient remaining in the restaurant
	//**amountRemaining still needs to be implemented
	protected double customerPrice;//Price for customer to add this ingredient
	protected double restaurantPrice;//Price for the restaurant to use ingredient
	
	
	/**
	 * Constructor for Ingredient class
	 * @param name: Name of Ingredient
	 * @param customerPrice: Price for customer to add ingredient to order
	 * @param restaurantPrice: Price for restaurant to use/buy this ingredient
	 */
	public Ingredient(String name, double customerPrice, double restaurantPrice)
	{
		this.name = name;
		this.customerPrice = customerPrice;
		this.restaurantPrice = restaurantPrice;
	}//end Ingredient()
	
	
////////////////////////////////////GETTERS	
	/**
	 * Returns name of ingredient
	 * @return name of ingredient
	 */
	public String getName()
	{
		return this.name;
	}//end getName()
	
	/**
	 * Returns the charged price of this ingredient
	 * @return customerPrice
	 */
	public double getCustomerPrice()
	{
		return this.customerPrice;
	}//end customerPrice()
	
	/**
	 * Returns price to acquire/use ingredient
	 * @return restaurantPrice
	 */
	public double getRestaurantPrice()
	{
		return this.restaurantPrice;
	}//end getRestaurantPrice()

	
}
