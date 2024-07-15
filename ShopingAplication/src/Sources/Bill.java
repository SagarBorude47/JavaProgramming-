package Sources;


import java.io.Serializable;
 /**
 * Represents a bill for a set of items.
 */
public class Bill implements Serializable {
	 /**
     * The serial version ID.
     */
	private static final long serialVersionUID = 1L;
	/**
	 * The unique ID of a bill.
	 */
	private int id;
	/**
	 * Count of item in abill.
	 */
	private int count;
	/**
	 * The total price of item in a bill.
	 */
	private double totalpricefornitems;
	/**
	 * The item being billed
	 */
	private Item item;

    /**
     * Creates a new bill for the given item and count.
     
     * @param item the item being billed
     * @param count the number of items being billed
     */
	public Bill(Item item, int count) { 
		this.item = item;
		this.id = item.getId();
		this.count = count;
		this.totalpricefornitems=item.getPrice()*this.count;
	}
	 /**
     * Gets the unique ID of the bill.
     *
     * @return the id
     */

	public int getId() {
		return id;
	}
	 /**
     * Gets the count of items in the bill.
     *
     * @return the count
     */
	public int getCount() {
		return count;
	}
	/**
     * Gets the total price for each individual item in the bill.
     *
     * @return the totalpricefornitems
     */
	public double getIndividuaTotal() {
		// TODO Auto-generated method stub
		return totalpricefornitems;
	}
	 /**
     * Displays information about the billed item.
     */
	public void showBilledItem()
	{
		this.totalpricefornitems=item.getPrice()*this.count;
		System.out.println("ID: "+id+"\t Name: "+item.getName()+"\t Price: "+item.getPrice()+"\t count: "+count+"\t Total Items Price: "+totalpricefornitems);
	}
	 /**
     * Sets a new count for the bill, subtracting from the current count and updating the total price.
     *
     * @param count the new count
     */
	public void setCount(int count) {
		this.count -= count;
		this.totalpricefornitems=item.getPrice()*this.count;
	}

}


