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
@Table(name = "urja_seds_series_data")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_SEDS_SERIES_DATA")
public class SedsSeriesData {
	@Id
	@GeneratedValue(generator = "idSeqGen", strategy = GenerationType.AUTO)
	private Long id;
	
	private String year;
	private String data;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="series_id", referencedColumnName="series_id")
	private SedsSeries sedsSeries;
	
	public Long getId() {
		return id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public SedsSeries getSedsSeries() {
		return sedsSeries;
	}

	public void setSedsSeries(SedsSeries sedsSeries) {
		this.sedsSeries = sedsSeries;
	}
}