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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "urja_aeo_series")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_AEO_SERIES")
public class AeoSeries {
	private static final Logger LOGGER = LoggerFactory.getLogger(AeoSeries.class);
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
	private String start;
	private String end;
	private String lastHistoricalPeriod;
	@SerializedName("last_updated")
	private Date lastUpdated;
	
	@OneToMany(orphanRemoval=true, mappedBy="aeoSeries", targetEntity=AeoSeriesData.class, 
			cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@OrderBy("period")
	private Set<AeoSeriesData> childData = new LinkedHashSet<>();
	
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
	public Set<AeoSeriesData> getChildData() {
		return childData;
	}
	public void setChildData(Set<AeoSeriesData> aeoData) {
		this.childData = aeoData;
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
	public void fillChildData() {
		AeoSeriesData childData;
		for(List<String> data: getData()){
			LOGGER.debug("0:"+data.get(0)+" 1:"+data.get(1));
			try{
				childData = new AeoSeriesData(data.get(0), Float.parseFloat(data.get(1)));
			} catch (NumberFormatException nfe){
				// some times the record may have "- -"
				childData = new AeoSeriesData(data.get(0),0.0f);
			}
			childData.setAeoSeries(this);
			getChildData().add(childData);
		}
	}
	public String getLastHistoricalPeriod() {
		return lastHistoricalPeriod;
	}
	public void setLastHistoricalPeriod(String lastHistoricalPeriod) {
		this.lastHistoricalPeriod = lastHistoricalPeriod;
	}
}