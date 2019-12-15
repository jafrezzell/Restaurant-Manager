package Classes;

import java.util.ArrayList;

/**
 * 
 * @author Joshua Frezzell
 *Class that represents the specified dish ordered by the customer and prepared by the chef
 */
public class Dish {
	
	protected String dishName;//Name of dish
	//protected Ingredient[] requiredIngredients;//Ingredients required to make dish
	protected ArrayList<Ingredient> requiredIngredients;
	protected double priceToMake;//Price to make dish
	protected double priceToSell;//Price of dish to sell to customer
	protected String notes;
	//Sam Irvin
	protected int tableNum;
	//end Sam Irvin
	//protected static int timesOrdered;//amount of times dish was ordered
	//protected double cookTime;//how long it takes to cook dish
	
	/**
	 * Constructor for Dish Class
	 * @param dishName: Name of dish
	 * @param requiredIngredients: Required Ingredients
	 */
	/*
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
		//Sam Irvin
		tableNum = -1;
		//end Sam Irvin
	}//end Dish()
*/
	public Dish(String dishName, ArrayList<Ingredient> requiredIngredients)
	{
		this.dishName = dishName;
		this.requiredIngredients = requiredIngredients;
		for(Ingredient ingredient: this.requiredIngredients)
		{
			this.priceToMake+=ingredient.restaurantPrice;
			this.priceToSell+=ingredient.customerPrice;
		}
		this.notes = "";
		//Sam Irvin
		tableNum = -1;
		//end Sam Irvin
	}//end Dish()
	
	//Sam Irvin
	//For the Make copy Dishes
	public Dish(String dishName, ArrayList<Ingredient> requiredIngredients, String note, int tab)
	{
		this.dishName = dishName;
		this.requiredIngredients = requiredIngredients;
		for(Ingredient ingredient: this.requiredIngredients)
		{
			this.priceToMake+=ingredient.restaurantPrice;
			this.priceToSell+=ingredient.customerPrice;
		}
		this.notes = note;
		tableNum = tab;
	}
	//End Sam Irvin
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
	
	//Sam Irvin
	public String getNotes() {
		return this.notes;
	}
	
	public ArrayList<Ingredient> getIngredients(){
		return this.requiredIngredients;
	}
	
	public int getTableNum() {
		return tableNum;
	}
	//end Sam Irvin
	
//////////////////////SETTERS
	/**
	 * Sets notes to newNotes
	 * @param newNotes New notes to be set
	 */
	public void setNotes(String newNotes)
	{
		this.notes = newNotes;
	}
	
	//Sam Irvin
	public void setTableNum(int num) {
		tableNum = num;
	}
	//end Sam Irvin
	
	
	public Dish makeCopy() {
		return new Dish(dishName, requiredIngredients, notes, tableNum);
	}
	
	
	
}
