package Sources;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * The class represents a shopping cart.
 * 
 * This class is used to manage a list of bills in a shopping cart.
 */
public class Cart implements Serializable 
{
	/**
     * The serial version ID.
     */
	private static final long serialVersionUID = 1L;
	/**
     * The list of bills in the cart.
     */
	List <Bill> bill = new ArrayList<Bill>(); 
	 /**
     * Adds a bill to the cart.
     *
     * @param bill The bill to be added to the cart.
     */
	public void addItem(Bill bill) 
	{
		 
		this.bill.add(bill);
	}

    /**
     * Displays all the bills in the cart.
     */	
	public void showBills() 
	{
		 
		for(int i=0;i<bill.size();i++)
		{
			bill.get(i).showBilledItem();
		}
	}
	/**
     * Returns the total amount of all bills in the cart.
     *
     * @return The total amount of all bills in the cart.
     */	
	public double getTotalBill() {
		double tot = 0.0;
		for(Bill b : bill) {
			tot = tot + b.getIndividuaTotal();
		}
		return tot;
	}
	/**
     * Removes an item from the cart by its code and count.
     
     * @param code The code of the item to be removed.
     * @param count The count of the item to be removed.
     */	
	public void remove(int code, int count) 
	{
		for(int i=0 ; i<bill.size();i++)
		{
			if(bill.get(i).getId()==code) {
				bill.get(i).setCount(count);
			}
		}
	}
	 /**
     * Gets the list of bills in the cart.
     *
     * @return The list of bills in the cart.
     */	
	public List<Bill> getBilList() 
	{
		 
		return bill;
	}
}
