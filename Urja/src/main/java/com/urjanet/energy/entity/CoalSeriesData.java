package com.urjanet.energy.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "urja_coal_series_data")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_COAL_SERIES_DATA")
public class CoalSeriesData extends GenericSeriesData {

	public CoalSeriesData(String period, float data) {
		super(period, data);
	}
	
//	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
//	@JoinColumn(name="coal_series_id", referencedColumnName="id")
//	private CoalSeries coalSeries;
//
//	public CoalSeries getCoalSeries() {
//		return coalSeries;
//	}
//
//	public void setCoalSeries(CoalSeries coalSeries) {
//		this.coalSeries = coalSeries;
//	}
}