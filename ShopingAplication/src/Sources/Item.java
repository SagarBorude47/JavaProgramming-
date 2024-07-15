package Sources;

import java.io.Serializable;

/**
 * The class used to represent the main entity Item from the application
 * This class represents an item that can be stored, priced, and named.
 */
public class Item implements Serializable 
{
	/**
     * The serial version ID.
     */
	private static final long serialVersionUID = 1L;
	/**
     * The unique identifier for this item.
     */
	private int id;
	/**
     * The name of this item.
     */
	private String name;
	/**
     * The price of this item.
     */
	private double price;
	 /**
     * Creates a new Item with the given id, name, and price.
     
     * @param id The unique identifier for this item.
     * @param name The name of this item.
     * @param price The price of this item.
     */
	public Item(int id, String name, double price)
	{
		this.id = id;
		this.name = name;
		this.price = price;
	}

    /**
     * Gets the unique identifier for this item.
     *
     * @return The unique identifier for this item.
     */
	public int getId()
	{
		return id;
	}
	 /**
     * Gets the price of this item.
     *
     * @return The price of this item.
     */

	public double getPrice() 
	{
		return price;
	}
	 /**
     * Gets the name of this item.
     *
     * @return The name of this item.
     */
	public String getName()
	{
		return name;
	}
	/**
     * Sets the price of this item.
     *
     * @param price The new price for this item.
     */
	public void setPrice(double price) 
	{
		this.price = price;
	}
	 /**
     * Sets the name of this item.
     *
     * @param name The new name for this item.
     */
	public void setName(String name) 
	{
		this.name = name;
	}
	/**
     * Returns a string representation of this item, including its id, name, and price.
     *
     * @return A string representation of this item.
     */
	@Override
	public String toString() 
	{
		return "Item{" + "id=" + id + ", name='" + name + '\'' + ", Price='" + price + '\'' + '}';
	}
}