package com.urjanet.energy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "urja_aeo_series_data")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_AEO_SERIES_DATA")
public class AEOSeriesData extends GenericSeriesData {

	public AEOSeriesData(String period, float data) {
		super(period, data);
	}
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="aeo_series_id", referencedColumnName="id")
	private AEOSeries aeoSeries;

	public AEOSeries getAEOSeries() {
		return aeoSeries;
	}

	public void setAEOSeries(AEOSeries aeoSeries) {
		this.aeoSeries = aeoSeries;
	}
}