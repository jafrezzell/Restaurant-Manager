import java.util.ArrayList;

/**
 * 
 * @author jafre
 *Class that represents the specified dish ordered by the customer and prepared by the chef
 */
public class Dish {
	
	protected String dishName;//Name of dish
	protected ArrayList<Ingredient> requiredIngredients;//Ingredients required to make dish
	protected double priceToMake;//Price to make dish
	protected double priceToSell;//Price of dish to sell to customer
	protected String notes;
	//protected static int timesOrdered;//amount of times dish was ordered
	//protected double cookTime;//how long it takes to cook dish
	
	/**
	 * Constructor for Dish Class
	 * @param dishName: Name of dish
	 * @param requiredIngredients: Required Ingredients
	 */
	public Dish(String dishName, ArrayList<Ingredient>requiredIngredients)
	{
		this.dishName = dishName;
		this.requiredIngredients = requiredIngredients;
		for(Ingredient ingredient: this.requiredIngredients)
		{
			this.priceToMake+=ingredient.restaurantPrice;
			this.priceToSell+=ingredient.customerPrice;
		}
		this.notes = "";
	}//end Dish()

	
//////////////////////////////////GETTERS	
	/**
	 * Returns name of dish
	 * @return dish name
	 */
	public String getDishName()
	{
		return this.dishName;
	}//end getDishName()
	
	/**
	 * Returns making price of the dish
	 * @return priceToMake
	 */
	public double getPriceToMake()
	{
		return this.priceToMake;
	}//end getPriceToMake()
	
	/**
	 * Returns selling price the dish
	 * @return priceToSell
	 */
	public double priceToSell()
	{
		return this.priceToSell;
	}//end priceToSell()
	
//////////////////////SETTERS
	/**
	 * Sets notes to newNotes
	 * @param newNotes New notes to be set
	 */
	public void setNotes(String newNotes)
	{
		this.notes = newNotes;
	}
}
