package edu.nyu.cs9053.homework7;
import java.util.Iterator;

import edu.nyu.cs9053.homework7.inventory.*;
/**
 * User: blangel
 * Date: 10/13/14
 * Time: 1:58 PM
 */
public class WarehouseInventoryAuditor {

    // TODO - create a method to print the individual prices of a Bin of any Item type
	public <T extends Item>void printItemPrice(Bin<T> items){
		Iterator<T> iter = items.iterator();
		while(iter.hasNext()){
			T item = iter.next();
			System.out.println(item.getPrice());
		}		
	}

    // TODO - create a method to print the individual prices of a Bin of any Electronic types
	public <T extends Electronic> void printElectronicPrice(Bin<T> electronics){
		Iterator<T> iter = electronics.iterator();
		while(iter.hasNext()){
			T electronic = iter.next();
			System.out.println(electronic.getPrice());
		}		
	}

    // TODO - create a method to print the individual prices of a Bin of any Book types
	public <T extends Book> void printBookPrice(Bin<T> books){
		Iterator<T> iter = books.iterator();
		while(iter.hasNext()){
			T book = iter.next();
			System.out.println(book.getPrice());
		}		
	}

}
