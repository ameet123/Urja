package com.urjanet.energy.entity;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "urja_pet_series")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_PET_SERIES")
public class PetSeries extends GenericSeries {
	@Transient
	private static final Logger LOGGER = LoggerFactory.getLogger(PetSeries.class);
	
	@OneToMany(orphanRemoval=true, mappedBy="petSeries", targetEntity=PetSeriesData.class, 
			cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@OrderBy("period")
	private Set<PetSeriesData> childData = new LinkedHashSet<>();

	/**
	 * based on the series data in nested List form, fill the List<POJO>
	 * @return
	 */
	@Override
	public void fillChildData() {
		PetSeriesData childData;
		for(List<String> data: getData()){
			LOGGER.debug("0:"+data.get(0)+" 1:"+data.get(1));
			try{
				childData = new PetSeriesData(data.get(0), Float.parseFloat(data.get(1)));
			} catch (NumberFormatException |NullPointerException nfpe){
				// some times the record may have "- -"
				childData = new PetSeriesData(data.get(0),0.0f);
			}
			childData.setPetSeries(this);
			getChildData().add(childData);
		}
	}

	public Set<PetSeriesData> getChildData() {
		return childData;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void setChildData(Set<? extends GenericSeriesData> childData) {
		this.childData = (Set<PetSeriesData>) childData;
	}
}