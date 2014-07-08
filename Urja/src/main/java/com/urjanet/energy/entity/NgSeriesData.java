package com.urjanet.energy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "urja_ng_series_data")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_NG_SERIES_DATA")
public class NgSeriesData extends GenericSeriesData {

	public NgSeriesData(String period, float data) {
		super(period, data);
	}
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="ng_series_id", referencedColumnName="id")
	private NgSeries ngSeries;

	public NgSeries getNgSeries() {
		return ngSeries;
	}

	public void setNgSeries(NgSeries ngSeries) {
		this.ngSeries = ngSeries;
	}
}