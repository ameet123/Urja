package com.urjanet.energy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "urja_seds_series")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_SEDS_SERIES")
public class SedsSeries {
	@Id
	@GeneratedValue(generator = "idSeqGen", strategy = GenerationType.AUTO)	
	private Long id;	
	
	@Column(name="series_id")
	@SerializedName("series_id") // this is for JSON, this is what appears in the file
	private String seriesId; 	 // this is what WE(java/this Class) would like to call it by
	
	private String name;
	private String units;
	private String f;
	@Column(length=1024)
	private String description;
	private String copyright;
	private String source;
	@Column(name="iso3166")
	@SerializedName("iso3166")
	private String iso;
	private String geography;
	private String start;
	private String end;
	@SerializedName("last_updated")
	private Date lastUpdated;
	
	@OneToMany(orphanRemoval=true, mappedBy="sedsSeries", targetEntity=SedsSeriesData.class, 
			cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@OrderBy("year")
	private Set<SedsSeriesData> sedData = new LinkedHashSet<>();
	
	@Transient
	private List<List<String>> data = new ArrayList<List<String>>();
	
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
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
	public void setId(Long id) {
		this.id = id;
	}
	public Set<SedsSeriesData> getSedData() {
		return sedData;
	}
	public void setSedData(Set<SedsSeriesData> sedData) {
		this.sedData = sedData;
	}

	public String getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}
	public List<List<String>> getData() {
		return data;
	}
	public void setData(List<List<String>> data) {
		this.data = data;
	}
	/**
	 * based on the series data in nested List form, fill the List<POJO>
	 * @return
	 */
	public void fillSedsData() {
		SedsSeriesData ssData;
		for(List<String> data: getData()){
			ssData = new SedsSeriesData(data.get(0), data.get(1));
			ssData.setSedsSeries(this);
			getSedData().add(ssData);
		}
	}
}