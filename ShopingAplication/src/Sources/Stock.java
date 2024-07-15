package Sources;
 

import java.io.Serializable;
import java.util.List;

import Util.ListUtil;

 

/**
 * This class used to create an object which stores the stock.
 */
public class Stock implements Serializable {
	/**
     * The serial version ID.
     */
	private static final long serialVersionUID = 1L;
	 /**
     * The code of the stock item.
     */
	private int code;
	/**
     * The count of items in stock.
     */
	private int countinstock;
	/**
     * Creates a new stock item with the given code and initial count.
     *
     * @param code the code of the stock item
     * @param itemcount the initial count of items in stock
     */
	public Stock(int code, int itemcount) {
		this.code = code;
		countinstock = itemcount;
	}
	/**
     * Gets the code of the stock item.
     *
     * @return the code
     */
	public int getCode() {
		return code;
	}
	/**
     * Gets the count of items in stock.
     *
     * @return the countinstock
     */
	public int getCountinstock() {
		return countinstock;
	}
	 /**
     * Sets a new count for the stock item.
     *
     * @param countinstock the new count
     */
	public void setCountinstock(int countinstock) {
		this.countinstock = countinstock;
	}
	 /**
     * Updates the stock count by adding the given amount.
     *
     * @param itemcount the amount to add to the stock count
     */
	public void updateStock(int itemcount) {
		countinstock = countinstock + itemcount;
	}

    /**
     * Prints information about the stock item, including its name, price, and stock count.
     *
     * @param items a list of all items, used to look up the name and price of the stock item
     */
	public void printStock(List<Item> items) {
		
		Item item = ListUtil.getItemByCode(items, code);
		String str = "Stock{" + "id=" + code + ", name='" + item.getName() + '\'' + ", Price='" + item.getPrice() + '\'' + '}'+" Stock: "+countinstock;
		System.out.println(str);
	}
}

