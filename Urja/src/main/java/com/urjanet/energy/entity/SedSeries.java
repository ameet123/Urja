package com.urjanet.energy.entity;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "urja_sed_series")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_SED_SERIES")
public class SedSeries extends GenericSeries {
	@Transient
	private static final Logger LOGGER = LoggerFactory.getLogger(SedSeries.class);
	
	private String copyright;
	private String source;
	@Column(name="iso3166")
	@SerializedName("iso3166")
	private String iso;
	private String geography;
	
	@OneToMany(orphanRemoval=true, mappedBy="sedSeries", targetEntity=SedSeriesData.class, 
			cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@OrderBy("period")
	private Set<SedSeriesData> childData = new LinkedHashSet<>();

	/**
	 * based on the series data in nested List form, fill the List<POJO>
	 * @return
	 */
	@Override
	public void fillChildData() {
		SedSeriesData childData;
		for(List<String> data: getData()){
			LOGGER.debug("0:"+data.get(0)+" 1:"+data.get(1));
			try{
				childData = new SedSeriesData(data.get(0), Float.parseFloat(data.get(1)));
			} catch (NumberFormatException |NullPointerException nfpe){
				// some times the record may have "- -"
				childData = new SedSeriesData(data.get(0),0.0f);
			}
			childData.setSedSeries(this);
			getChildData().add(childData);
		}
	}

	public Set<SedSeriesData> getChildData() {
		return childData;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void setChildData(Set<? extends GenericSeriesData> childData) {
		this.childData = (Set<SedSeriesData>) childData;
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
}