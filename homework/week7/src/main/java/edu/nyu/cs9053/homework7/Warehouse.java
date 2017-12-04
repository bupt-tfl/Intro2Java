package edu.nyu.cs9053.homework7;

import java.util.Iterator;

import edu.nyu.cs9053.homework7.inventory.Item;

/**
 * User: blangel
 * Date: 10/13/14
 * Time: 1:57 PM
 */
public class Warehouse {

    private static void copy(Bin from, Bin into) {
	// TODO - copy values in 'from' to 'into'
    	Iterator iter = from.iterator();
    	while(iter.hasNext()){
    		into.add(iter.next());
    	}
    }

    // TODO - implement such that the warehouse can hold any Bin of Item type

    private final Bin items;

    public Warehouse(Bin<? extends Item> items) {
        this.items = items;
    }

    public Bin getItems() {	
        return items;
    }

    public Warehouse copy() {
        // TODO - make a new Bin copying the values from `items` into a new Bin using the 'copy' method below
        // TODO - change to return a copied bin
    	Bin newBin = new Bin();
    	copy(items,newBin);
        return new Warehouse(newBin);
    }

}
