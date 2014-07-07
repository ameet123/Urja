package com.urjanet.energy.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "urja_coal_series")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_COAL_SERIES")
public class CoalSeries extends GenericSeries {
//	private static final Logger LOGGER = LoggerFactory.getLogger(CoalSeries.class);
//	
//	@OneToMany(orphanRemoval=true, mappedBy="coalSeries", targetEntity=CoalSeriesData.class, 
//			cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//	@OrderBy("period")
//	private Set<CoalSeriesData> childData = new LinkedHashSet<>();

	/**
	 * based on the series data in nested List form, fill the List<POJO>
	 * @return
	 */
//	public void fillChildData() {
//		CoalSeriesData childData;
//		for(List<String> data: getData()){
//			LOGGER.debug("0:"+data.get(0)+" 1:"+data.get(1));
//			try{
//				childData = new CoalSeriesData(data.get(0), Float.parseFloat(data.get(1)));
//			} catch (NumberFormatException nfe){
//				// some times the record may have "- -"
//				childData = new CoalSeriesData(data.get(0),0.0f);
//			}
//			childData.setCoalSeries(this);
//			getChildData().add(childData);
//		}
//	}

//	public Set<CoalSeriesData> getChildData() {
//		return childData;
//	}

//	public void setChildData(Set<CoalSeriesData> childData) {
//		this.childData = childData;
//	}
}
