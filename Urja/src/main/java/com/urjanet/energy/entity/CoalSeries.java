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
@Table(name = "urja_coal_series")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_COAL_SERIES")
public class CoalSeries extends GenericSeries {
	@Transient
	private static final Logger LOGGER = LoggerFactory.getLogger(CoalSeries.class);
	
	@OneToMany(orphanRemoval=true, mappedBy="coalSeries", targetEntity=CoalSeriesData.class, 
			cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@OrderBy("period")
	private Set<CoalSeriesData> childData = new LinkedHashSet<>();

	/**
	 * based on the series data in nested List form, fill the List<POJO>
	 * @return
	 */
	@Override
	public void fillChildData() {
		CoalSeriesData childData;
		for(List<String> data: getData()){
			LOGGER.debug("0:"+data.get(0)+" 1:"+data.get(1));
			try{
				childData = new CoalSeriesData(data.get(0), Float.parseFloat(data.get(1)));
			} catch (NumberFormatException |NullPointerException nfpe){
				// some times the record may have "- -"
				childData = new CoalSeriesData(data.get(0),0.0f);
			}
			childData.setCoalSeries(this);
			getChildData().add(childData);
		}
	}

	public Set<CoalSeriesData> getChildData() {
		return childData;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void setChildData(Set<? extends GenericSeriesData> childData) {
		this.childData = (Set<CoalSeriesData>) childData;
	}
}