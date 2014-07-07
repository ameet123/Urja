package com.urjanet.energy.entity;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
/**
 * 
 * @author ac2211
 * The parameter type is actually for the parent/master class type of genericSeries 
 * @param <T>
 */
@MappedSuperclass
public class GenericSeriesData {
	
	@Id
	@GeneratedValue(generator = "idSeqGen", strategy = GenerationType.AUTO)
	private Long id;
	
	private String period;
	private float data;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="pk_series_id", referencedColumnName="id")
	private GenericSeries genericSeries;
	
	public GenericSeriesData(String period, float data) {
		this.period = period;
		this.data = data;
	}
	
	public Long getId() {
		return id;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public float getData() {
		return data;
	}

	public void setData(float data) {
		this.data = data;
	}

	public GenericSeries getGenericSeries() {
		return genericSeries;
	}

	public void setGenericSeries(GenericSeries genericSeries) {
		this.genericSeries = genericSeries;
	}
}