package com.urjanet.energy.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.urjanet.energy.entity.SedsSeriesData;
public class SedsJson {

	@SerializedName("series_id") // this is for JSON, this is what appears in the file
	private String seriesId; 	 // this is what WE(java/this Class) would like to call it by
	
	private String name;
	private String units;
	private String f;

	private String description;
	private String copyright;
	private String source;
	@SerializedName("iso3166")
	private String iso;
	private String geography;
	private String start;
	private String end;
	@SerializedName("last_updated")
	private Date lastUpdated;
	private List<List<String>> data = new ArrayList<List<String>>();
	
	
	public String getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getIso() {
		return iso;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	public String getGeography() {
		return geography;
	}
	public void setGeography(String geography) {
		this.geography = geography;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public List<List<String>> getData() {
		return data;
	}
	public void setData(List<List<String>> data) {
		this.data = data;
	}
}