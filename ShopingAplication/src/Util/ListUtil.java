package Util;



import java.util.List;

import Sources.Bill;
import Sources.Cart;
import Sources.Item;
import Sources.Stock;


/**
 *  This class defines several different methods used to process the different lists
 */
public class ListUtil {
	/**
	 * search for the current code in the list of items
	 * @param code - This is item code to be searched
	 * @param items - this is list where you have to search the item
	 */
	public static boolean containsCode(int code, List<Item> items) {
		for(Item i : items) {
			if(i.getId()==code)
				return true;
		}
		return false;
	}
	
	/**
	  
	 * Adds or updates the stock of an item with the given code.
     * If the stock list is empty, a new stock entry is added with the given code and item count.
	 * If a stock entry already exists for the given code, the item count is updated.
	 * If no stock entry exists for the given code, a new stock entry is added.

	 * @param code the code of the item to add or update
	 * @param itemcount the number of items to add or update
	 * @param stocks a list of existing stock entries
	 
	 */
	
	public static void addOrUpdateStock(int code, int itemcount, List<Stock> stocks) {
     /**
      * if stock list is empty
     */
		if(stocks.isEmpty()) {
			stocks.add(new Stock(code, itemcount));
			return;
		}
		/**
		 * if stock having entry, the add/increase stock of item having same code
	    */
		boolean flg = false;
		for(Stock s : stocks) {
			if(s.getCode()==code) {
				s.updateStock(itemcount);
				flg=true;
			}
		}
		
	   /**
	    * if stock don't have entry, adding the stock of code <code> first time
	    */
		if(!flg) {
			stocks.add(new Stock(code, itemcount));
		}
			
	}
	/**
	 
	 * Returns the item from the list that matches the given code.
  
  	 * @param items the list of items to search through
 	 * @param code the code to search for
	 * @return the item that matches the given code, or null if not found
	 *   
	 
	 */
	
	public static Item getItemByCode(List<Item> items, int code) {
		// TODO Auto-generated method stub
		for (Item i : items) {
			if (i.getId() == code)
				return i;
		}
		return null;
	}
	
	/**
	 * Checks if a product is in stock based on its code and count.
	 * 
	 * @param code the product code
	 * @param count the quantity to check
	 * @param stocks a list of stock objects
	 * @return true if the product is in stock, false otherwise
	 */

	public static boolean isInStock(int code, int count, List<Stock> stocks) {

		for(Stock s : stocks) {
			if(s.getCode()==code && s.getCountinstock()>=count) {
				return true;				
			}
		}
		return false;
	}
	/**
	 * Displays a cart to the console.
	 * 
	 * @param cart the cart to display 
	 */
	public static void showCart(Cart cart) {
		System.out.println("\n -----------------------------------------------------");
		cart.showBills();
	}
	
	
	/**
	 * Updates the stock quantities based on the items in the cart.
	 * 
	 * @param cart the cart containing the items to update
	 * @param stocks a list of stock objects to update
	 */

	public static void UpdateStock(Cart cart, List<Stock> stocks) {
		// TODO Auto-generated method stub
		List<Bill> bill = cart.getBilList();
		for(Bill b : bill) {
			decreaseStock(b.getId(), b.getCount(), stocks);
		}
		
	}
	/**
	 * Decreases the stock quantity of a specific product by the given count.
	 * 
	 * @param id the id of the product to update
	 * @param count the amount to decrease the stock quantity by
	 * @param stocks a list of stock objects to update
	 */
	private static void decreaseStock(int id, int count, List<Stock> stocks) {
		// TODO Auto-generated method stub
		for (Stock s : stocks) {
			if(s.getCode() == id) {
				s.updateStock(-count);
			}
		}
	}
	/**
	 * Displays all the carts and their total bill, and returns the total of all carts.
	 * 
	 * @param carts the list of carts to display
	 * @return the total of all cart bills
	 */

	public static double showAllCarts(List<Cart> carts) {
		double shopsell = 0.0;
		for (int i = 0; i < carts.size(); i++) {
			System.out.print("\n------- Cart:" + (i + 1) + " --------\n");
			carts.get(i).showBills();
			System.out.print("\n------- Cart Total: " +carts.get(i).getTotalBill());
			shopsell+=carts.get(i).getTotalBill();
		}
		return shopsell;
	}
}

