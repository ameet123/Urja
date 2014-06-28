package com.urjanet.energy.json;

import java.util.HashMap;
import java.util.Map;

import com.urjanet.energy.entity.Series;

public class BulkManifest {

	
	private Map<String, Series> dataset = new HashMap<>();

	public Map<String, Series> getDataset() {
		return dataset;
	}

	public void setDataset(Map<String, Series> dataset) {
		this.dataset = dataset;
	}
}