package com.urjanet.energy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "urja_pet_series_data")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_PET_SERIES_DATA")
public class PetSeriesData extends GenericSeriesData {

	public PetSeriesData(String period, float data) {
		super(period, data);
	}
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="pet_series_id", referencedColumnName="id")
	private PetSeries petSeries;

	public PetSeries getPetSeries() {
		return petSeries;
	}

	public void setPetSeries(PetSeries petSeries) {
		this.petSeries = petSeries;
	}
}