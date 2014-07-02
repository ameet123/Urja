package com.urjanet.energy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "urja_aeo_series_data")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_AEO_SERIES_DATA")
public class AeoSeriesData {
	@Id
	@GeneratedValue(generator = "idSeqGen", strategy = GenerationType.AUTO)
	private Long id;
	
	private String period;
	private float data;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="aeo_series_id", referencedColumnName="id")
	private AeoSeries aeoSeries;
	
	public AeoSeriesData(String year, float data) {
		this.period = year;
		this.data = data;
	}
	
	public Long getId() {
		return id;
	}

	public String getYear() {
		return period;
	}

	public void setYear(String year) {
		this.period = year;
	}

	public float getData() {
		return data;
	}

	public void setData(float data) {
		this.data = data;
	}

	public AeoSeries getAeoSeries() {
		return aeoSeries;
	}

	public void setAeoSeries(AeoSeries aeoSeries) {
		this.aeoSeries = aeoSeries;
	}
}