package Util;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Sources.Cart;
import Sources.Item;
import Sources.Stock;


/**
 * The class FileUtil defined the different static methods used to perform the different operations on file.
 */
public class FileUtil  {

	/**
     * The name of the file to store items.
     */
	private static final String FILE_NAME = "items.txt";
	/**
     * The name of the file to store carts.
     */
	private static final String CARTS_NAME = "carts.txt";
	/**
     * The name of the file to store stock.
     */
	private static final String stock_NAME = "stock.txt";
	/**
	 *  This method used to write the entire list of items to file
	 * @param items - this is ArrayList contains all newly created items
	 * @throws IOException - exception class
	 */
	public static void saveItems(List<Item> items) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			oos.writeObject(items);
		}
	}
	/**
	 * Loads a list of items from a file.
	 * 
	 * @return A list of items. If the file does not exist, an empty list is returned.
	 * @throws IOException If there is an issue reading the file.
	 * @throws ClassNotFoundException If the serialized object cannot be deserialized.
	 */
	public static List<Item> loadItems() throws IOException, ClassNotFoundException {
		/**
		 *  Creating a file object for the item file 
		 */
		 
		File file = new File(FILE_NAME);
		
		 /**
		  *  If the file does not exist, return an empty list.
		  */
		 
		if (!file.exists()) {
			return new ArrayList<>();
		}
		
		 /**
		  * Try to read the list of items from the file using ObjectInputStream.
		  */
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			return (List<Item>) ois.readObject();
		}
	}
	/**
	 * Saves a list of carts to a file.
	 * 
	 * @param carts The list of carts to be saved.
	 * @throws IOException If there is an issue writing to the file.
	 */
	public static void saveCarts(List<Cart> carts) throws IOException {
		// TODO Auto-generated method stub

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARTS_NAME))) {
			oos.writeObject(carts);
		}
	}
	/**
	 * Loads a list of carts from a file.
	 * 
	 * @return A list of carts. If the file does not exist, an empty list is returned.
	 * @throws IOException If there is an issue reading the file.
	 * @throws ClassNotFoundException If the serialized object cannot be deserialized.
	 */
	@SuppressWarnings("unchecked")
	public static List<Cart> loadCarts() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File file = new File(CARTS_NAME);
		if (!file.exists()) {
			return new ArrayList<>();
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CARTS_NAME))) {
			return (List<Cart>) ois.readObject();
		}
	}
	/**
	 * Saves a list of stock to a file.
	 * 
	 * @param stock The list of stock to be saved.
	 * @throws IOException If there is an issue writing to the file.
	 */
	
	public static void saveStock(List<Stock> stock) throws IOException {
		// TODO Auto-generated method stub

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(stock_NAME))) {
			oos.writeObject(stock);
		}
	}
	/**
	 * Loads a list of Stock from a file.
	 * 
	 * @return A list of Stock. If the file does not exist, an empty list is returned.
	 * @throws IOException If there is an issue reading the file.
	 * @throws ClassNotFoundException If the serialized object cannot be deserialized.
	 */

	@SuppressWarnings("unchecked")
	public static List<Stock> loadStock() throws IOException, ClassNotFoundException {
		File file = new File(stock_NAME);
		if (!file.exists()) {
			return new ArrayList<>();
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(stock_NAME))) {
			return (List<Stock>) ois.readObject();
		}
	}	
}
