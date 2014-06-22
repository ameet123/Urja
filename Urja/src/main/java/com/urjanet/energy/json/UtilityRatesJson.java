package com.urjanet.energy.json;


import com.urjanet.energy.entity.UtilityRates;
/**
 * class to convert JSON to object
 * for Utility rates data
 * It is in the form of inner nested class of UtilityRates[]
 * This is the same Class which is a hibernate entity
 * @author ac2211
 *
 */
public class UtilityRatesJson {
	
	public UtilityRatesJson() {}
	
	private UtilityRates[] items;

	/**
	 * @return the items
	 */
	public UtilityRates[] getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(UtilityRates[] items) {
		this.items = items;
	}
}