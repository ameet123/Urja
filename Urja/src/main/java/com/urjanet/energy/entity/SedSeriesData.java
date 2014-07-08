package com.urjanet.energy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "urja_sed_series_data")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_SED_SERIES_DATA")
public class SedSeriesData extends GenericSeriesData {

	public SedSeriesData(String period, float data) {
		super(period, data);
	}
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="sed_series_id", referencedColumnName="id")
	private SedSeries sedSeries;

	public SedSeries getSedSeries() {
		return sedSeries;
	}

	public void setSedSeries(SedSeries sedSeries) {
		this.sedSeries = sedSeries;
	}
}