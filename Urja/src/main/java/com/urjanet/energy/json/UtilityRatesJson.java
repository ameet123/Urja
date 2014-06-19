package com.urjanet.energy.json;


import java.util.Date;
/**
 * class to convert JSON to object
 * for Utility rates data
 * It is in the form of inner nested class of Item[]
 * an Item consists of all the attributes
 * @author ac2211
 *
 */
public class UtilityRatesJson {
	
	public UtilityRatesJson() {}
	
	private Items[] items;

	/**
	 * @return the items
	 */
	public Items[] getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Items[] items) {
		this.items = items;
	}

	public static class Items {
		
	
	private String label;
	private String name;
	private Date startDate;
	private Date endDate;
	private String utility;
	private String sector;
	private String description;
	private String source;
	private String sourceParent;
	private float version;
	private String useNetMetering;
	private float peakKwCapacityMin;
	private float peakKwCapacityMax;
	private float peakKwCapacityHistory;
	private float peakKwhusageMin;
	private float peakKwhusageMax;
	private float peakKwhusagehistory;
	private String voltageCategory;
	private String phaseWiring;
	private float voltageMinimum;
	private float voltageMaximum;
	private float flatRatebuy;
	private float flatRatesell;
	private float flatRatefueladj;
	private float fixedMonthlyCharge;
	private String basicInformationComments;
	private String flatDemandUnit;
	private String demandRateUnit;
	private float flatDemandMonth1;
	private float flatDemandMonth2;
	private float flatDemandMonth3;
	private float flatDemandMonth4;
	private float flatDemandMonth5;
	private float flatDemandMonth6;
	private float flatDemandMonth7;
	private float flatDemandMonth8;
	private float flatDemandMonth9;
	private float flatDemandMonth10;
	private float flatDemandMonth11;
	private float flatDemandMonth12;
	private String demandWeekdaySchedule;
	private String demandWeekendSchedule;
	private float demandReactivePowercharge;
	private float demandRatchetPercentage;
	private float demandWindow;
	private String demandComments;
	private String energyRateUnit;
	private String energyWeekdaySchedule;
	private String energyWeekendSchedule;
	private String energyComments;
	private String supersedes;
	private float demandRateStructure_period1_period;
	private float demandRateStructure_period2_period;
	private float demandRateStructure_period2_tier1Rate;
	private float demandRateStructure_period1_tier1Rate;
	private float demandRateStructure_period3_period;
	private float demandRateStructure_period3_tier1Rate;
	private float demandRateStructure_period1_tier1Adjustment;
	private float demandRateStructure_period2_tier1Adjustment;
	private float flatDemandStructure_period1_period;
	private float flatDemandStructure_period1_tier1Rate;
	private float flatDemandStructure_period2_period;
	private float flatDemandStructure_period2_tier1Max;
	private float flatDemandStructure_period2_tier1Rate;
	private float flatDemandStructure_period2_tier2Rate;
	private float flatDemandStructure_period3_period;
	private float flatDemandStructure_period3_tier1Rate;
	private float flatDemandStructure_period1_tier1Max;
	private float flatDemandStructure_period1_tier2Max;
	private float flatDemandStructure_period1_tier2Rate;
	private float flatDemandStructure_period1_tier3Rate;
	private float flatDemandStructure_period2_tier2Max;
	private float flatDemandStructure_period2_tier3Rate;
	private float flatDemandStructure_period1_tier1Adjustment;
	private float flatDemandStructure_period3_tier1Max;
	private float flatDemandStructure_period3_tier2Rate;
	private float energyRateStructure_period1_period;
	private float energyRateStructure_period1_tier1Max;
	private float energyRateStructure_period1_tier1Rate;
	private float energyRateStructure_period1_tier2Rate;
	private float energyRateStructure_period2_period;
	private float energyRateStructure_period2_tier1Max;
	private float energyRateStructure_period2_tier1Rate;
	private float energyRateStructure_period2_tier2Rate;
	private float energyRateStructure_period1_tier1Adjustment;
	private float energyRateStructure_period1_tier1sell;
	private float energyRateStructure_period2_tier1Adjustment;
	private float energyRateStructure_period2_tier1sell;
	private float energyRateStructure_period1_tier2Max;
	private float energyRateStructure_period1_tier2Adjustment;
	private float energyRateStructure_period1_tier3Adjustment;
	private float energyRateStructure_period1_tier3Rate;
	private float energyRateStructure_period2_tier2Max;
	private float energyRateStructure_period2_tier3Max;
	private float energyRateStructure_period2_tier2Adjustment;
	private float energyRateStructure_period2_tier3Adjustment;
	private float energyRateStructure_period2_tier4Adjustment;
	private float energyRateStructure_period2_tier3Rate;
	private float energyRateStructure_period2_tier4Rate;
	private float energyRateStructure_period1_tier3Max;
	private float energyRateStructure_period1_tier4Adjustment;
	private float energyRateStructure_period1_tier4Rate;
	private float energyRateStructure_period5_period;
	private float energyRateStructure_period5_tier1Adjustment;
	private float energyRateStructure_period5_tier1Rate;
	private float energyRateStructure_period3_period;
	private float energyRateStructure_period3_tier1Adjustment;
	private float energyRateStructure_period3_tier1Rate;
	private float energyRateStructure_period4_period;
	private float energyRateStructure_period4_tier1Adjustment;
	private float energyRateStructure_period4_tier1Rate;
	private float energyRateStructure_period1_tier2sell;
	private float energyRateStructure_period2_tier2sell;
	private float energyRateStructure_period3_tier1Max;
	private float energyRateStructure_period3_tier2Rate;
	private float energyRateStructure_period4_tier1Max;
	private float energyRateStructure_period5_tier2Rate;
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the utility
	 */
	public String getUtility() {
		return utility;
	}
	/**
	 * @param utility the utility to set
	 */
	public void setUtility(String utility) {
		this.utility = utility;
	}
	/**
	 * @return the sector
	 */
	public String getSector() {
		return sector;
	}
	/**
	 * @param sector the sector to set
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the sourceParent
	 */
	public String getSourceParent() {
		return sourceParent;
	}
	/**
	 * @param sourceParent the sourceParent to set
	 */
	public void setSourceParent(String sourceParent) {
		this.sourceParent = sourceParent;
	}
	/**
	 * @return the version
	 */
	public float getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(float version) {
		this.version = version;
	}
	/**
	 * @return the useNetMetering
	 */
	public String getUseNetMetering() {
		return useNetMetering;
	}
	/**
	 * @param useNetMetering the useNetMetering to set
	 */
	public void setUseNetMetering(String useNetMetering) {
		this.useNetMetering = useNetMetering;
	}
	/**
	 * @return the peakKwCapacityMin
	 */
	public float getPeakKwCapacityMin() {
		return peakKwCapacityMin;
	}
	/**
	 * @param peakKwCapacityMin the peakKwCapacityMin to set
	 */
	public void setPeakKwCapacityMin(float peakKwCapacityMin) {
		this.peakKwCapacityMin = peakKwCapacityMin;
	}
	/**
	 * @return the peakKwCapacityMax
	 */
	public float getPeakKwCapacityMax() {
		return peakKwCapacityMax;
	}
	/**
	 * @param peakKwCapacityMax the peakKwCapacityMax to set
	 */
	public void setPeakKwCapacityMax(float peakKwCapacityMax) {
		this.peakKwCapacityMax = peakKwCapacityMax;
	}
	/**
	 * @return the peakKwCapacityHistory
	 */
	public float getPeakKwCapacityHistory() {
		return peakKwCapacityHistory;
	}
	/**
	 * @param peakKwCapacityHistory the peakKwCapacityHistory to set
	 */
	public void setPeakKwCapacityHistory(float peakKwCapacityHistory) {
		this.peakKwCapacityHistory = peakKwCapacityHistory;
	}
	/**
	 * @return the peakKwhusageMin
	 */
	public float getPeakKwhusageMin() {
		return peakKwhusageMin;
	}
	/**
	 * @param peakKwhusageMin the peakKwhusageMin to set
	 */
	public void setPeakKwhusageMin(float peakKwhusageMin) {
		this.peakKwhusageMin = peakKwhusageMin;
	}
	/**
	 * @return the peakKwhusageMax
	 */
	public float getPeakKwhusageMax() {
		return peakKwhusageMax;
	}
	/**
	 * @param peakKwhusageMax the peakKwhusageMax to set
	 */
	public void setPeakKwhusageMax(float peakKwhusageMax) {
		this.peakKwhusageMax = peakKwhusageMax;
	}
	/**
	 * @return the peakKwhusagehistory
	 */
	public float getPeakKwhusagehistory() {
		return peakKwhusagehistory;
	}
	/**
	 * @param peakKwhusagehistory the peakKwhusagehistory to set
	 */
	public void setPeakKwhusagehistory(float peakKwhusagehistory) {
		this.peakKwhusagehistory = peakKwhusagehistory;
	}
	/**
	 * @return the voltageCategory
	 */
	public String getVoltageCategory() {
		return voltageCategory;
	}
	/**
	 * @param voltageCategory the voltageCategory to set
	 */
	public void setVoltageCategory(String voltageCategory) {
		this.voltageCategory = voltageCategory;
	}
	/**
	 * @return the phaseWiring
	 */
	public String getPhaseWiring() {
		return phaseWiring;
	}
	/**
	 * @param phaseWiring the phaseWiring to set
	 */
	public void setPhaseWiring(String phaseWiring) {
		this.phaseWiring = phaseWiring;
	}
	/**
	 * @return the voltageMinimum
	 */
	public float getVoltageMinimum() {
		return voltageMinimum;
	}
	/**
	 * @param voltageMinimum the voltageMinimum to set
	 */
	public void setVoltageMinimum(float voltageMinimum) {
		this.voltageMinimum = voltageMinimum;
	}
	/**
	 * @return the voltageMaximum
	 */
	public float getVoltageMaximum() {
		return voltageMaximum;
	}
	/**
	 * @param voltageMaximum the voltageMaximum to set
	 */
	public void setVoltageMaximum(float voltageMaximum) {
		this.voltageMaximum = voltageMaximum;
	}
	/**
	 * @return the flatRatebuy
	 */
	public float getFlatRatebuy() {
		return flatRatebuy;
	}
	/**
	 * @param flatRatebuy the flatRatebuy to set
	 */
	public void setFlatRatebuy(float flatRatebuy) {
		this.flatRatebuy = flatRatebuy;
	}
	/**
	 * @return the flatRatesell
	 */
	public float getFlatRatesell() {
		return flatRatesell;
	}
	/**
	 * @param flatRatesell the flatRatesell to set
	 */
	public void setFlatRatesell(float flatRatesell) {
		this.flatRatesell = flatRatesell;
	}
	/**
	 * @return the flatRatefueladj
	 */
	public float getFlatRatefueladj() {
		return flatRatefueladj;
	}
	/**
	 * @param flatRatefueladj the flatRatefueladj to set
	 */
	public void setFlatRatefueladj(float flatRatefueladj) {
		this.flatRatefueladj = flatRatefueladj;
	}
	/**
	 * @return the fixedMonthlyCharge
	 */
	public float getFixedMonthlyCharge() {
		return fixedMonthlyCharge;
	}
	/**
	 * @param fixedMonthlyCharge the fixedMonthlyCharge to set
	 */
	public void setFixedMonthlyCharge(float fixedMonthlyCharge) {
		this.fixedMonthlyCharge = fixedMonthlyCharge;
	}
	/**
	 * @return the basicInformationComments
	 */
	public String getBasicInformationComments() {
		return basicInformationComments;
	}
	/**
	 * @param basicInformationComments the basicInformationComments to set
	 */
	public void setBasicInformationComments(String basicInformationComments) {
		this.basicInformationComments = basicInformationComments;
	}
	/**
	 * @return the flatDemandUnit
	 */
	public String getFlatDemandUnit() {
		return flatDemandUnit;
	}
	/**
	 * @param flatDemandUnit the flatDemandUnit to set
	 */
	public void setFlatDemandUnit(String flatDemandUnit) {
		this.flatDemandUnit = flatDemandUnit;
	}
	/**
	 * @return the demandRateUnit
	 */
	public String getDemandRateUnit() {
		return demandRateUnit;
	}
	/**
	 * @param demandRateUnit the demandRateUnit to set
	 */
	public void setDemandRateUnit(String demandRateUnit) {
		this.demandRateUnit = demandRateUnit;
	}
	/**
	 * @return the flatDemandMonth1
	 */
	public float getFlatDemandMonth1() {
		return flatDemandMonth1;
	}
	/**
	 * @param flatDemandMonth1 the flatDemandMonth1 to set
	 */
	public void setFlatDemandMonth1(float flatDemandMonth1) {
		this.flatDemandMonth1 = flatDemandMonth1;
	}
	/**
	 * @return the flatDemandMonth2
	 */
	public float getFlatDemandMonth2() {
		return flatDemandMonth2;
	}
	/**
	 * @param flatDemandMonth2 the flatDemandMonth2 to set
	 */
	public void setFlatDemandMonth2(float flatDemandMonth2) {
		this.flatDemandMonth2 = flatDemandMonth2;
	}
	/**
	 * @return the flatDemandMonth3
	 */
	public float getFlatDemandMonth3() {
		return flatDemandMonth3;
	}
	/**
	 * @param flatDemandMonth3 the flatDemandMonth3 to set
	 */
	public void setFlatDemandMonth3(float flatDemandMonth3) {
		this.flatDemandMonth3 = flatDemandMonth3;
	}
	/**
	 * @return the flatDemandMonth4
	 */
	public float getFlatDemandMonth4() {
		return flatDemandMonth4;
	}
	/**
	 * @param flatDemandMonth4 the flatDemandMonth4 to set
	 */
	public void setFlatDemandMonth4(float flatDemandMonth4) {
		this.flatDemandMonth4 = flatDemandMonth4;
	}
	/**
	 * @return the flatDemandMonth5
	 */
	public float getFlatDemandMonth5() {
		return flatDemandMonth5;
	}
	/**
	 * @param flatDemandMonth5 the flatDemandMonth5 to set
	 */
	public void setFlatDemandMonth5(float flatDemandMonth5) {
		this.flatDemandMonth5 = flatDemandMonth5;
	}
	/**
	 * @return the flatDemandMonth6
	 */
	public float getFlatDemandMonth6() {
		return flatDemandMonth6;
	}
	/**
	 * @param flatDemandMonth6 the flatDemandMonth6 to set
	 */
	public void setFlatDemandMonth6(float flatDemandMonth6) {
		this.flatDemandMonth6 = flatDemandMonth6;
	}
	/**
	 * @return the flatDemandMonth7
	 */
	public float getFlatDemandMonth7() {
		return flatDemandMonth7;
	}
	/**
	 * @param flatDemandMonth7 the flatDemandMonth7 to set
	 */
	public void setFlatDemandMonth7(float flatDemandMonth7) {
		this.flatDemandMonth7 = flatDemandMonth7;
	}
	/**
	 * @return the flatDemandMonth8
	 */
	public float getFlatDemandMonth8() {
		return flatDemandMonth8;
	}
	/**
	 * @param flatDemandMonth8 the flatDemandMonth8 to set
	 */
	public void setFlatDemandMonth8(float flatDemandMonth8) {
		this.flatDemandMonth8 = flatDemandMonth8;
	}
	/**
	 * @return the flatDemandMonth9
	 */
	public float getFlatDemandMonth9() {
		return flatDemandMonth9;
	}
	/**
	 * @param flatDemandMonth9 the flatDemandMonth9 to set
	 */
	public void setFlatDemandMonth9(float flatDemandMonth9) {
		this.flatDemandMonth9 = flatDemandMonth9;
	}
	/**
	 * @return the flatDemandMonth10
	 */
	public float getFlatDemandMonth10() {
		return flatDemandMonth10;
	}
	/**
	 * @param flatDemandMonth10 the flatDemandMonth10 to set
	 */
	public void setFlatDemandMonth10(float flatDemandMonth10) {
		this.flatDemandMonth10 = flatDemandMonth10;
	}
	/**
	 * @return the flatDemandMonth11
	 */
	public float getFlatDemandMonth11() {
		return flatDemandMonth11;
	}
	/**
	 * @param flatDemandMonth11 the flatDemandMonth11 to set
	 */
	public void setFlatDemandMonth11(float flatDemandMonth11) {
		this.flatDemandMonth11 = flatDemandMonth11;
	}
	/**
	 * @return the flatDemandMonth12
	 */
	public float getFlatDemandMonth12() {
		return flatDemandMonth12;
	}
	/**
	 * @param flatDemandMonth12 the flatDemandMonth12 to set
	 */
	public void setFlatDemandMonth12(float flatDemandMonth12) {
		this.flatDemandMonth12 = flatDemandMonth12;
	}
	/**
	 * @return the demandWeekdaySchedule
	 */
	public String getDemandWeekdaySchedule() {
		return demandWeekdaySchedule;
	}
	/**
	 * @param demandWeekdaySchedule the demandWeekdaySchedule to set
	 */
	public void setDemandWeekdaySchedule(String demandWeekdaySchedule) {
		this.demandWeekdaySchedule = demandWeekdaySchedule;
	}
	/**
	 * @return the demandWeekendSchedule
	 */
	public String getDemandWeekendSchedule() {
		return demandWeekendSchedule;
	}
	/**
	 * @param demandWeekendSchedule the demandWeekendSchedule to set
	 */
	public void setDemandWeekendSchedule(String demandWeekendSchedule) {
		this.demandWeekendSchedule = demandWeekendSchedule;
	}
	/**
	 * @return the demandReactivePowercharge
	 */
	public float getDemandReactivePowercharge() {
		return demandReactivePowercharge;
	}
	/**
	 * @param demandReactivePowercharge the demandReactivePowercharge to set
	 */
	public void setDemandReactivePowercharge(float demandReactivePowercharge) {
		this.demandReactivePowercharge = demandReactivePowercharge;
	}
	/**
	 * @return the demandRatchetPercentage
	 */
	public float getDemandRatchetPercentage() {
		return demandRatchetPercentage;
	}
	/**
	 * @param demandRatchetPercentage the demandRatchetPercentage to set
	 */
	public void setDemandRatchetPercentage(float demandRatchetPercentage) {
		this.demandRatchetPercentage = demandRatchetPercentage;
	}
	/**
	 * @return the demandWindow
	 */
	public float getDemandWindow() {
		return demandWindow;
	}
	/**
	 * @param demandWindow the demandWindow to set
	 */
	public void setDemandWindow(float demandWindow) {
		this.demandWindow = demandWindow;
	}
	/**
	 * @return the demandComments
	 */
	public String getDemandComments() {
		return demandComments;
	}
	/**
	 * @param demandComments the demandComments to set
	 */
	public void setDemandComments(String demandComments) {
		this.demandComments = demandComments;
	}
	/**
	 * @return the energyRateUnit
	 */
	public String getEnergyRateUnit() {
		return energyRateUnit;
	}
	/**
	 * @param energyRateUnit the energyRateUnit to set
	 */
	public void setEnergyRateUnit(String energyRateUnit) {
		this.energyRateUnit = energyRateUnit;
	}
	/**
	 * @return the energyWeekdaySchedule
	 */
	public String getEnergyWeekdaySchedule() {
		return energyWeekdaySchedule;
	}
	/**
	 * @param energyWeekdaySchedule the energyWeekdaySchedule to set
	 */
	public void setEnergyWeekdaySchedule(String energyWeekdaySchedule) {
		this.energyWeekdaySchedule = energyWeekdaySchedule;
	}
	/**
	 * @return the energyWeekendSchedule
	 */
	public String getEnergyWeekendSchedule() {
		return energyWeekendSchedule;
	}
	/**
	 * @param energyWeekendSchedule the energyWeekendSchedule to set
	 */
	public void setEnergyWeekendSchedule(String energyWeekendSchedule) {
		this.energyWeekendSchedule = energyWeekendSchedule;
	}
	/**
	 * @return the energyComments
	 */
	public String getEnergyComments() {
		return energyComments;
	}
	/**
	 * @param energyComments the energyComments to set
	 */
	public void setEnergyComments(String energyComments) {
		this.energyComments = energyComments;
	}
	/**
	 * @return the supersedes
	 */
	public String getSupersedes() {
		return supersedes;
	}
	/**
	 * @param supersedes the supersedes to set
	 */
	public void setSupersedes(String supersedes) {
		this.supersedes = supersedes;
	}
	/**
	 * @return the demandRateStructure_period1_period
	 */
	public float getDemandRateStructure_period1_period() {
		return demandRateStructure_period1_period;
	}
	/**
	 * @param demandRateStructure_period1_period the demandRateStructure_period1_period to set
	 */
	public void setDemandRateStructure_period1_period(
			float demandRateStructure_period1_period) {
		this.demandRateStructure_period1_period = demandRateStructure_period1_period;
	}
	/**
	 * @return the demandRateStructure_period2_period
	 */
	public float getDemandRateStructure_period2_period() {
		return demandRateStructure_period2_period;
	}
	/**
	 * @param demandRateStructure_period2_period the demandRateStructure_period2_period to set
	 */
	public void setDemandRateStructure_period2_period(
			float demandRateStructure_period2_period) {
		this.demandRateStructure_period2_period = demandRateStructure_period2_period;
	}
	/**
	 * @return the demandRateStructure_period2_tier1Rate
	 */
	public float getDemandRateStructure_period2_tier1Rate() {
		return demandRateStructure_period2_tier1Rate;
	}
	/**
	 * @param demandRateStructure_period2_tier1Rate the demandRateStructure_period2_tier1Rate to set
	 */
	public void setDemandRateStructure_period2_tier1Rate(
			float demandRateStructure_period2_tier1Rate) {
		this.demandRateStructure_period2_tier1Rate = demandRateStructure_period2_tier1Rate;
	}
	/**
	 * @return the demandRateStructure_period1_tier1Rate
	 */
	public float getDemandRateStructure_period1_tier1Rate() {
		return demandRateStructure_period1_tier1Rate;
	}
	/**
	 * @param demandRateStructure_period1_tier1Rate the demandRateStructure_period1_tier1Rate to set
	 */
	public void setDemandRateStructure_period1_tier1Rate(
			float demandRateStructure_period1_tier1Rate) {
		this.demandRateStructure_period1_tier1Rate = demandRateStructure_period1_tier1Rate;
	}
	/**
	 * @return the demandRateStructure_period3_period
	 */
	public float getDemandRateStructure_period3_period() {
		return demandRateStructure_period3_period;
	}
	/**
	 * @param demandRateStructure_period3_period the demandRateStructure_period3_period to set
	 */
	public void setDemandRateStructure_period3_period(
			float demandRateStructure_period3_period) {
		this.demandRateStructure_period3_period = demandRateStructure_period3_period;
	}
	/**
	 * @return the demandRateStructure_period3_tier1Rate
	 */
	public float getDemandRateStructure_period3_tier1Rate() {
		return demandRateStructure_period3_tier1Rate;
	}
	/**
	 * @param demandRateStructure_period3_tier1Rate the demandRateStructure_period3_tier1Rate to set
	 */
	public void setDemandRateStructure_period3_tier1Rate(
			float demandRateStructure_period3_tier1Rate) {
		this.demandRateStructure_period3_tier1Rate = demandRateStructure_period3_tier1Rate;
	}
	/**
	 * @return the demandRateStructure_period1_tier1Adjustment
	 */
	public float getDemandRateStructure_period1_tier1Adjustment() {
		return demandRateStructure_period1_tier1Adjustment;
	}
	/**
	 * @param demandRateStructure_period1_tier1Adjustment the demandRateStructure_period1_tier1Adjustment to set
	 */
	public void setDemandRateStructure_period1_tier1Adjustment(
			float demandRateStructure_period1_tier1Adjustment) {
		this.demandRateStructure_period1_tier1Adjustment = demandRateStructure_period1_tier1Adjustment;
	}
	/**
	 * @return the demandRateStructure_period2_tier1Adjustment
	 */
	public float getDemandRateStructure_period2_tier1Adjustment() {
		return demandRateStructure_period2_tier1Adjustment;
	}
	/**
	 * @param demandRateStructure_period2_tier1Adjustment the demandRateStructure_period2_tier1Adjustment to set
	 */
	public void setDemandRateStructure_period2_tier1Adjustment(
			float demandRateStructure_period2_tier1Adjustment) {
		this.demandRateStructure_period2_tier1Adjustment = demandRateStructure_period2_tier1Adjustment;
	}
	/**
	 * @return the flatDemandStructure_period1_period
	 */
	public float getFlatDemandStructure_period1_period() {
		return flatDemandStructure_period1_period;
	}
	/**
	 * @param flatDemandStructure_period1_period the flatDemandStructure_period1_period to set
	 */
	public void setFlatDemandStructure_period1_period(
			float flatDemandStructure_period1_period) {
		this.flatDemandStructure_period1_period = flatDemandStructure_period1_period;
	}
	/**
	 * @return the flatDemandStructure_period1_tier1Rate
	 */
	public float getFlatDemandStructure_period1_tier1Rate() {
		return flatDemandStructure_period1_tier1Rate;
	}
	/**
	 * @param flatDemandStructure_period1_tier1Rate the flatDemandStructure_period1_tier1Rate to set
	 */
	public void setFlatDemandStructure_period1_tier1Rate(
			float flatDemandStructure_period1_tier1Rate) {
		this.flatDemandStructure_period1_tier1Rate = flatDemandStructure_period1_tier1Rate;
	}
	/**
	 * @return the flatDemandStructure_period2_period
	 */
	public float getFlatDemandStructure_period2_period() {
		return flatDemandStructure_period2_period;
	}
	/**
	 * @param flatDemandStructure_period2_period the flatDemandStructure_period2_period to set
	 */
	public void setFlatDemandStructure_period2_period(
			float flatDemandStructure_period2_period) {
		this.flatDemandStructure_period2_period = flatDemandStructure_period2_period;
	}
	/**
	 * @return the flatDemandStructure_period2_tier1Max
	 */
	public float getFlatDemandStructure_period2_tier1Max() {
		return flatDemandStructure_period2_tier1Max;
	}
	/**
	 * @param flatDemandStructure_period2_tier1Max the flatDemandStructure_period2_tier1Max to set
	 */
	public void setFlatDemandStructure_period2_tier1Max(
			float flatDemandStructure_period2_tier1Max) {
		this.flatDemandStructure_period2_tier1Max = flatDemandStructure_period2_tier1Max;
	}
	/**
	 * @return the flatDemandStructure_period2_tier1Rate
	 */
	public float getFlatDemandStructure_period2_tier1Rate() {
		return flatDemandStructure_period2_tier1Rate;
	}
	/**
	 * @param flatDemandStructure_period2_tier1Rate the flatDemandStructure_period2_tier1Rate to set
	 */
	public void setFlatDemandStructure_period2_tier1Rate(
			float flatDemandStructure_period2_tier1Rate) {
		this.flatDemandStructure_period2_tier1Rate = flatDemandStructure_period2_tier1Rate;
	}
	/**
	 * @return the flatDemandStructure_period2_tier2Rate
	 */
	public float getFlatDemandStructure_period2_tier2Rate() {
		return flatDemandStructure_period2_tier2Rate;
	}
	/**
	 * @param flatDemandStructure_period2_tier2Rate the flatDemandStructure_period2_tier2Rate to set
	 */
	public void setFlatDemandStructure_period2_tier2Rate(
			float flatDemandStructure_period2_tier2Rate) {
		this.flatDemandStructure_period2_tier2Rate = flatDemandStructure_period2_tier2Rate;
	}
	/**
	 * @return the flatDemandStructure_period3_period
	 */
	public float getFlatDemandStructure_period3_period() {
		return flatDemandStructure_period3_period;
	}
	/**
	 * @param flatDemandStructure_period3_period the flatDemandStructure_period3_period to set
	 */
	public void setFlatDemandStructure_period3_period(
			float flatDemandStructure_period3_period) {
		this.flatDemandStructure_period3_period = flatDemandStructure_period3_period;
	}
	/**
	 * @return the flatDemandStructure_period3_tier1Rate
	 */
	public float getFlatDemandStructure_period3_tier1Rate() {
		return flatDemandStructure_period3_tier1Rate;
	}
	/**
	 * @param flatDemandStructure_period3_tier1Rate the flatDemandStructure_period3_tier1Rate to set
	 */
	public void setFlatDemandStructure_period3_tier1Rate(
			float flatDemandStructure_period3_tier1Rate) {
		this.flatDemandStructure_period3_tier1Rate = flatDemandStructure_period3_tier1Rate;
	}
	/**
	 * @return the flatDemandStructure_period1_tier1Max
	 */
	public float getFlatDemandStructure_period1_tier1Max() {
		return flatDemandStructure_period1_tier1Max;
	}
	/**
	 * @param flatDemandStructure_period1_tier1Max the flatDemandStructure_period1_tier1Max to set
	 */
	public void setFlatDemandStructure_period1_tier1Max(
			float flatDemandStructure_period1_tier1Max) {
		this.flatDemandStructure_period1_tier1Max = flatDemandStructure_period1_tier1Max;
	}
	/**
	 * @return the flatDemandStructure_period1_tier2Max
	 */
	public float getFlatDemandStructure_period1_tier2Max() {
		return flatDemandStructure_period1_tier2Max;
	}
	/**
	 * @param flatDemandStructure_period1_tier2Max the flatDemandStructure_period1_tier2Max to set
	 */
	public void setFlatDemandStructure_period1_tier2Max(
			float flatDemandStructure_period1_tier2Max) {
		this.flatDemandStructure_period1_tier2Max = flatDemandStructure_period1_tier2Max;
	}
	/**
	 * @return the flatDemandStructure_period1_tier2Rate
	 */
	public float getFlatDemandStructure_period1_tier2Rate() {
		return flatDemandStructure_period1_tier2Rate;
	}
	/**
	 * @param flatDemandStructure_period1_tier2Rate the flatDemandStructure_period1_tier2Rate to set
	 */
	public void setFlatDemandStructure_period1_tier2Rate(
			float flatDemandStructure_period1_tier2Rate) {
		this.flatDemandStructure_period1_tier2Rate = flatDemandStructure_period1_tier2Rate;
	}
	/**
	 * @return the flatDemandStructure_period1_tier3Rate
	 */
	public float getFlatDemandStructure_period1_tier3Rate() {
		return flatDemandStructure_period1_tier3Rate;
	}
	/**
	 * @param flatDemandStructure_period1_tier3Rate the flatDemandStructure_period1_tier3Rate to set
	 */
	public void setFlatDemandStructure_period1_tier3Rate(
			float flatDemandStructure_period1_tier3Rate) {
		this.flatDemandStructure_period1_tier3Rate = flatDemandStructure_period1_tier3Rate;
	}
	/**
	 * @return the flatDemandStructure_period2_tier2Max
	 */
	public float getFlatDemandStructure_period2_tier2Max() {
		return flatDemandStructure_period2_tier2Max;
	}
	/**
	 * @param flatDemandStructure_period2_tier2Max the flatDemandStructure_period2_tier2Max to set
	 */
	public void setFlatDemandStructure_period2_tier2Max(
			float flatDemandStructure_period2_tier2Max) {
		this.flatDemandStructure_period2_tier2Max = flatDemandStructure_period2_tier2Max;
	}
	/**
	 * @return the flatDemandStructure_period2_tier3Rate
	 */
	public float getFlatDemandStructure_period2_tier3Rate() {
		return flatDemandStructure_period2_tier3Rate;
	}
	/**
	 * @param flatDemandStructure_period2_tier3Rate the flatDemandStructure_period2_tier3Rate to set
	 */
	public void setFlatDemandStructure_period2_tier3Rate(
			float flatDemandStructure_period2_tier3Rate) {
		this.flatDemandStructure_period2_tier3Rate = flatDemandStructure_period2_tier3Rate;
	}
	/**
	 * @return the flatDemandStructure_period1_tier1Adjustment
	 */
	public float getFlatDemandStructure_period1_tier1Adjustment() {
		return flatDemandStructure_period1_tier1Adjustment;
	}
	/**
	 * @param flatDemandStructure_period1_tier1Adjustment the flatDemandStructure_period1_tier1Adjustment to set
	 */
	public void setFlatDemandStructure_period1_tier1Adjustment(
			float flatDemandStructure_period1_tier1Adjustment) {
		this.flatDemandStructure_period1_tier1Adjustment = flatDemandStructure_period1_tier1Adjustment;
	}
	/**
	 * @return the flatDemandStructure_period3_tier1Max
	 */
	public float getFlatDemandStructure_period3_tier1Max() {
		return flatDemandStructure_period3_tier1Max;
	}
	/**
	 * @param flatDemandStructure_period3_tier1Max the flatDemandStructure_period3_tier1Max to set
	 */
	public void setFlatDemandStructure_period3_tier1Max(
			float flatDemandStructure_period3_tier1Max) {
		this.flatDemandStructure_period3_tier1Max = flatDemandStructure_period3_tier1Max;
	}
	/**
	 * @return the flatDemandStructure_period3_tier2Rate
	 */
	public float getFlatDemandStructure_period3_tier2Rate() {
		return flatDemandStructure_period3_tier2Rate;
	}
	/**
	 * @param flatDemandStructure_period3_tier2Rate the flatDemandStructure_period3_tier2Rate to set
	 */
	public void setFlatDemandStructure_period3_tier2Rate(
			float flatDemandStructure_period3_tier2Rate) {
		this.flatDemandStructure_period3_tier2Rate = flatDemandStructure_period3_tier2Rate;
	}
	/**
	 * @return the energyRateStructure_period1_period
	 */
	public float getEnergyRateStructure_period1_period() {
		return energyRateStructure_period1_period;
	}
	/**
	 * @param energyRateStructure_period1_period the energyRateStructure_period1_period to set
	 */
	public void setEnergyRateStructure_period1_period(
			float energyRateStructure_period1_period) {
		this.energyRateStructure_period1_period = energyRateStructure_period1_period;
	}
	/**
	 * @return the energyRateStructure_period1_tier1Max
	 */
	public float getEnergyRateStructure_period1_tier1Max() {
		return energyRateStructure_period1_tier1Max;
	}
	/**
	 * @param energyRateStructure_period1_tier1Max the energyRateStructure_period1_tier1Max to set
	 */
	public void setEnergyRateStructure_period1_tier1Max(
			float energyRateStructure_period1_tier1Max) {
		this.energyRateStructure_period1_tier1Max = energyRateStructure_period1_tier1Max;
	}
	/**
	 * @return the energyRateStructure_period1_tier1Rate
	 */
	public float getEnergyRateStructure_period1_tier1Rate() {
		return energyRateStructure_period1_tier1Rate;
	}
	/**
	 * @param energyRateStructure_period1_tier1Rate the energyRateStructure_period1_tier1Rate to set
	 */
	public void setEnergyRateStructure_period1_tier1Rate(
			float energyRateStructure_period1_tier1Rate) {
		this.energyRateStructure_period1_tier1Rate = energyRateStructure_period1_tier1Rate;
	}
	/**
	 * @return the energyRateStructure_period1_tier2Rate
	 */
	public float getEnergyRateStructure_period1_tier2Rate() {
		return energyRateStructure_period1_tier2Rate;
	}
	/**
	 * @param energyRateStructure_period1_tier2Rate the energyRateStructure_period1_tier2Rate to set
	 */
	public void setEnergyRateStructure_period1_tier2Rate(
			float energyRateStructure_period1_tier2Rate) {
		this.energyRateStructure_period1_tier2Rate = energyRateStructure_period1_tier2Rate;
	}
	/**
	 * @return the energyRateStructure_period2_period
	 */
	public float getEnergyRateStructure_period2_period() {
		return energyRateStructure_period2_period;
	}
	/**
	 * @param energyRateStructure_period2_period the energyRateStructure_period2_period to set
	 */
	public void setEnergyRateStructure_period2_period(
			float energyRateStructure_period2_period) {
		this.energyRateStructure_period2_period = energyRateStructure_period2_period;
	}
	/**
	 * @return the energyRateStructure_period2_tier1Max
	 */
	public float getEnergyRateStructure_period2_tier1Max() {
		return energyRateStructure_period2_tier1Max;
	}
	/**
	 * @param energyRateStructure_period2_tier1Max the energyRateStructure_period2_tier1Max to set
	 */
	public void setEnergyRateStructure_period2_tier1Max(
			float energyRateStructure_period2_tier1Max) {
		this.energyRateStructure_period2_tier1Max = energyRateStructure_period2_tier1Max;
	}
	/**
	 * @return the energyRateStructure_period2_tier1Rate
	 */
	public float getEnergyRateStructure_period2_tier1Rate() {
		return energyRateStructure_period2_tier1Rate;
	}
	/**
	 * @param energyRateStructure_period2_tier1Rate the energyRateStructure_period2_tier1Rate to set
	 */
	public void setEnergyRateStructure_period2_tier1Rate(
			float energyRateStructure_period2_tier1Rate) {
		this.energyRateStructure_period2_tier1Rate = energyRateStructure_period2_tier1Rate;
	}
	/**
	 * @return the energyRateStructure_period2_tier2Rate
	 */
	public float getEnergyRateStructure_period2_tier2Rate() {
		return energyRateStructure_period2_tier2Rate;
	}
	/**
	 * @param energyRateStructure_period2_tier2Rate the energyRateStructure_period2_tier2Rate to set
	 */
	public void setEnergyRateStructure_period2_tier2Rate(
			float energyRateStructure_period2_tier2Rate) {
		this.energyRateStructure_period2_tier2Rate = energyRateStructure_period2_tier2Rate;
	}
	/**
	 * @return the energyRateStructure_period1_tier1Adjustment
	 */
	public float getEnergyRateStructure_period1_tier1Adjustment() {
		return energyRateStructure_period1_tier1Adjustment;
	}
	/**
	 * @param energyRateStructure_period1_tier1Adjustment the energyRateStructure_period1_tier1Adjustment to set
	 */
	public void setEnergyRateStructure_period1_tier1Adjustment(
			float energyRateStructure_period1_tier1Adjustment) {
		this.energyRateStructure_period1_tier1Adjustment = energyRateStructure_period1_tier1Adjustment;
	}
	/**
	 * @return the energyRateStructure_period1_tier1sell
	 */
	public float getEnergyRateStructure_period1_tier1sell() {
		return energyRateStructure_period1_tier1sell;
	}
	/**
	 * @param energyRateStructure_period1_tier1sell the energyRateStructure_period1_tier1sell to set
	 */
	public void setEnergyRateStructure_period1_tier1sell(
			float energyRateStructure_period1_tier1sell) {
		this.energyRateStructure_period1_tier1sell = energyRateStructure_period1_tier1sell;
	}
	/**
	 * @return the energyRateStructure_period2_tier1Adjustment
	 */
	public float getEnergyRateStructure_period2_tier1Adjustment() {
		return energyRateStructure_period2_tier1Adjustment;
	}
	/**
	 * @param energyRateStructure_period2_tier1Adjustment the energyRateStructure_period2_tier1Adjustment to set
	 */
	public void setEnergyRateStructure_period2_tier1Adjustment(
			float energyRateStructure_period2_tier1Adjustment) {
		this.energyRateStructure_period2_tier1Adjustment = energyRateStructure_period2_tier1Adjustment;
	}
	/**
	 * @return the energyRateStructure_period2_tier1sell
	 */
	public float getEnergyRateStructure_period2_tier1sell() {
		return energyRateStructure_period2_tier1sell;
	}
	/**
	 * @param energyRateStructure_period2_tier1sell the energyRateStructure_period2_tier1sell to set
	 */
	public void setEnergyRateStructure_period2_tier1sell(
			float energyRateStructure_period2_tier1sell) {
		this.energyRateStructure_period2_tier1sell = energyRateStructure_period2_tier1sell;
	}
	/**
	 * @return the energyRateStructure_period1_tier2Max
	 */
	public float getEnergyRateStructure_period1_tier2Max() {
		return energyRateStructure_period1_tier2Max;
	}
	/**
	 * @param energyRateStructure_period1_tier2Max the energyRateStructure_period1_tier2Max to set
	 */
	public void setEnergyRateStructure_period1_tier2Max(
			float energyRateStructure_period1_tier2Max) {
		this.energyRateStructure_period1_tier2Max = energyRateStructure_period1_tier2Max;
	}
	/**
	 * @return the energyRateStructure_period1_tier2Adjustment
	 */
	public float getEnergyRateStructure_period1_tier2Adjustment() {
		return energyRateStructure_period1_tier2Adjustment;
	}
	/**
	 * @param energyRateStructure_period1_tier2Adjustment the energyRateStructure_period1_tier2Adjustment to set
	 */
	public void setEnergyRateStructure_period1_tier2Adjustment(
			float energyRateStructure_period1_tier2Adjustment) {
		this.energyRateStructure_period1_tier2Adjustment = energyRateStructure_period1_tier2Adjustment;
	}
	/**
	 * @return the energyRateStructure_period1_tier3Adjustment
	 */
	public float getEnergyRateStructure_period1_tier3Adjustment() {
		return energyRateStructure_period1_tier3Adjustment;
	}
	/**
	 * @param energyRateStructure_period1_tier3Adjustment the energyRateStructure_period1_tier3Adjustment to set
	 */
	public void setEnergyRateStructure_period1_tier3Adjustment(
			float energyRateStructure_period1_tier3Adjustment) {
		this.energyRateStructure_period1_tier3Adjustment = energyRateStructure_period1_tier3Adjustment;
	}
	/**
	 * @return the energyRateStructure_period1_tier3Rate
	 */
	public float getEnergyRateStructure_period1_tier3Rate() {
		return energyRateStructure_period1_tier3Rate;
	}
	/**
	 * @param energyRateStructure_period1_tier3Rate the energyRateStructure_period1_tier3Rate to set
	 */
	public void setEnergyRateStructure_period1_tier3Rate(
			float energyRateStructure_period1_tier3Rate) {
		this.energyRateStructure_period1_tier3Rate = energyRateStructure_period1_tier3Rate;
	}
	/**
	 * @return the energyRateStructure_period2_tier2Max
	 */
	public float getEnergyRateStructure_period2_tier2Max() {
		return energyRateStructure_period2_tier2Max;
	}
	/**
	 * @param energyRateStructure_period2_tier2Max the energyRateStructure_period2_tier2Max to set
	 */
	public void setEnergyRateStructure_period2_tier2Max(
			float energyRateStructure_period2_tier2Max) {
		this.energyRateStructure_period2_tier2Max = energyRateStructure_period2_tier2Max;
	}
	/**
	 * @return the energyRateStructure_period2_tier3Max
	 */
	public float getEnergyRateStructure_period2_tier3Max() {
		return energyRateStructure_period2_tier3Max;
	}
	/**
	 * @param energyRateStructure_period2_tier3Max the energyRateStructure_period2_tier3Max to set
	 */
	public void setEnergyRateStructure_period2_tier3Max(
			float energyRateStructure_period2_tier3Max) {
		this.energyRateStructure_period2_tier3Max = energyRateStructure_period2_tier3Max;
	}
	/**
	 * @return the energyRateStructure_period2_tier2Adjustment
	 */
	public float getEnergyRateStructure_period2_tier2Adjustment() {
		return energyRateStructure_period2_tier2Adjustment;
	}
	/**
	 * @param energyRateStructure_period2_tier2Adjustment the energyRateStructure_period2_tier2Adjustment to set
	 */
	public void setEnergyRateStructure_period2_tier2Adjustment(
			float energyRateStructure_period2_tier2Adjustment) {
		this.energyRateStructure_period2_tier2Adjustment = energyRateStructure_period2_tier2Adjustment;
	}
	/**
	 * @return the energyRateStructure_period2_tier3Adjustment
	 */
	public float getEnergyRateStructure_period2_tier3Adjustment() {
		return energyRateStructure_period2_tier3Adjustment;
	}
	/**
	 * @param energyRateStructure_period2_tier3Adjustment the energyRateStructure_period2_tier3Adjustment to set
	 */
	public void setEnergyRateStructure_period2_tier3Adjustment(
			float energyRateStructure_period2_tier3Adjustment) {
		this.energyRateStructure_period2_tier3Adjustment = energyRateStructure_period2_tier3Adjustment;
	}
	/**
	 * @return the energyRateStructure_period2_tier4Adjustment
	 */
	public float getEnergyRateStructure_period2_tier4Adjustment() {
		return energyRateStructure_period2_tier4Adjustment;
	}
	/**
	 * @param energyRateStructure_period2_tier4Adjustment the energyRateStructure_period2_tier4Adjustment to set
	 */
	public void setEnergyRateStructure_period2_tier4Adjustment(
			float energyRateStructure_period2_tier4Adjustment) {
		this.energyRateStructure_period2_tier4Adjustment = energyRateStructure_period2_tier4Adjustment;
	}
	/**
	 * @return the energyRateStructure_period2_tier3Rate
	 */
	public float getEnergyRateStructure_period2_tier3Rate() {
		return energyRateStructure_period2_tier3Rate;
	}
	/**
	 * @param energyRateStructure_period2_tier3Rate the energyRateStructure_period2_tier3Rate to set
	 */
	public void setEnergyRateStructure_period2_tier3Rate(
			float energyRateStructure_period2_tier3Rate) {
		this.energyRateStructure_period2_tier3Rate = energyRateStructure_period2_tier3Rate;
	}
	/**
	 * @return the energyRateStructure_period2_tier4Rate
	 */
	public float getEnergyRateStructure_period2_tier4Rate() {
		return energyRateStructure_period2_tier4Rate;
	}
	/**
	 * @param energyRateStructure_period2_tier4Rate the energyRateStructure_period2_tier4Rate to set
	 */
	public void setEnergyRateStructure_period2_tier4Rate(
			float energyRateStructure_period2_tier4Rate) {
		this.energyRateStructure_period2_tier4Rate = energyRateStructure_period2_tier4Rate;
	}
	/**
	 * @return the energyRateStructure_period1_tier3Max
	 */
	public float getEnergyRateStructure_period1_tier3Max() {
		return energyRateStructure_period1_tier3Max;
	}
	/**
	 * @param energyRateStructure_period1_tier3Max the energyRateStructure_period1_tier3Max to set
	 */
	public void setEnergyRateStructure_period1_tier3Max(
			float energyRateStructure_period1_tier3Max) {
		this.energyRateStructure_period1_tier3Max = energyRateStructure_period1_tier3Max;
	}
	/**
	 * @return the energyRateStructure_period1_tier4Adjustment
	 */
	public float getEnergyRateStructure_period1_tier4Adjustment() {
		return energyRateStructure_period1_tier4Adjustment;
	}
	/**
	 * @param energyRateStructure_period1_tier4Adjustment the energyRateStructure_period1_tier4Adjustment to set
	 */
	public void setEnergyRateStructure_period1_tier4Adjustment(
			float energyRateStructure_period1_tier4Adjustment) {
		this.energyRateStructure_period1_tier4Adjustment = energyRateStructure_period1_tier4Adjustment;
	}
	/**
	 * @return the energyRateStructure_period1_tier4Rate
	 */
	public float getEnergyRateStructure_period1_tier4Rate() {
		return energyRateStructure_period1_tier4Rate;
	}
	/**
	 * @param energyRateStructure_period1_tier4Rate the energyRateStructure_period1_tier4Rate to set
	 */
	public void setEnergyRateStructure_period1_tier4Rate(
			float energyRateStructure_period1_tier4Rate) {
		this.energyRateStructure_period1_tier4Rate = energyRateStructure_period1_tier4Rate;
	}
	/**
	 * @return the energyRateStructure_period5_period
	 */
	public float getEnergyRateStructure_period5_period() {
		return energyRateStructure_period5_period;
	}
	/**
	 * @param energyRateStructure_period5_period the energyRateStructure_period5_period to set
	 */
	public void setEnergyRateStructure_period5_period(
			float energyRateStructure_period5_period) {
		this.energyRateStructure_period5_period = energyRateStructure_period5_period;
	}
	/**
	 * @return the energyRateStructure_period5_tier1Adjustment
	 */
	public float getEnergyRateStructure_period5_tier1Adjustment() {
		return energyRateStructure_period5_tier1Adjustment;
	}
	/**
	 * @param energyRateStructure_period5_tier1Adjustment the energyRateStructure_period5_tier1Adjustment to set
	 */
	public void setEnergyRateStructure_period5_tier1Adjustment(
			float energyRateStructure_period5_tier1Adjustment) {
		this.energyRateStructure_period5_tier1Adjustment = energyRateStructure_period5_tier1Adjustment;
	}
	/**
	 * @return the energyRateStructure_period5_tier1Rate
	 */
	public float getEnergyRateStructure_period5_tier1Rate() {
		return energyRateStructure_period5_tier1Rate;
	}
	/**
	 * @param energyRateStructure_period5_tier1Rate the energyRateStructure_period5_tier1Rate to set
	 */
	public void setEnergyRateStructure_period5_tier1Rate(
			float energyRateStructure_period5_tier1Rate) {
		this.energyRateStructure_period5_tier1Rate = energyRateStructure_period5_tier1Rate;
	}
	/**
	 * @return the energyRateStructure_period3_period
	 */
	public float getEnergyRateStructure_period3_period() {
		return energyRateStructure_period3_period;
	}
	/**
	 * @param energyRateStructure_period3_period the energyRateStructure_period3_period to set
	 */
	public void setEnergyRateStructure_period3_period(
			float energyRateStructure_period3_period) {
		this.energyRateStructure_period3_period = energyRateStructure_period3_period;
	}
	/**
	 * @return the energyRateStructure_period3_tier1Adjustment
	 */
	public float getEnergyRateStructure_period3_tier1Adjustment() {
		return energyRateStructure_period3_tier1Adjustment;
	}
	/**
	 * @param energyRateStructure_period3_tier1Adjustment the energyRateStructure_period3_tier1Adjustment to set
	 */
	public void setEnergyRateStructure_period3_tier1Adjustment(
			float energyRateStructure_period3_tier1Adjustment) {
		this.energyRateStructure_period3_tier1Adjustment = energyRateStructure_period3_tier1Adjustment;
	}
	/**
	 * @return the energyRateStructure_period3_tier1Rate
	 */
	public float getEnergyRateStructure_period3_tier1Rate() {
		return energyRateStructure_period3_tier1Rate;
	}
	/**
	 * @param energyRateStructure_period3_tier1Rate the energyRateStructure_period3_tier1Rate to set
	 */
	public void setEnergyRateStructure_period3_tier1Rate(
			float energyRateStructure_period3_tier1Rate) {
		this.energyRateStructure_period3_tier1Rate = energyRateStructure_period3_tier1Rate;
	}
	/**
	 * @return the energyRateStructure_period4_period
	 */
	public float getEnergyRateStructure_period4_period() {
		return energyRateStructure_period4_period;
	}
	/**
	 * @param energyRateStructure_period4_period the energyRateStructure_period4_period to set
	 */
	public void setEnergyRateStructure_period4_period(
			float energyRateStructure_period4_period) {
		this.energyRateStructure_period4_period = energyRateStructure_period4_period;
	}
	/**
	 * @return the energyRateStructure_period4_tier1Adjustment
	 */
	public float getEnergyRateStructure_period4_tier1Adjustment() {
		return energyRateStructure_period4_tier1Adjustment;
	}
	/**
	 * @param energyRateStructure_period4_tier1Adjustment the energyRateStructure_period4_tier1Adjustment to set
	 */
	public void setEnergyRateStructure_period4_tier1Adjustment(
			float energyRateStructure_period4_tier1Adjustment) {
		this.energyRateStructure_period4_tier1Adjustment = energyRateStructure_period4_tier1Adjustment;
	}
	/**
	 * @return the energyRateStructure_period4_tier1Rate
	 */
	public float getEnergyRateStructure_period4_tier1Rate() {
		return energyRateStructure_period4_tier1Rate;
	}
	/**
	 * @param energyRateStructure_period4_tier1Rate the energyRateStructure_period4_tier1Rate to set
	 */
	public void setEnergyRateStructure_period4_tier1Rate(
			float energyRateStructure_period4_tier1Rate) {
		this.energyRateStructure_period4_tier1Rate = energyRateStructure_period4_tier1Rate;
	}
	/**
	 * @return the energyRateStructure_period1_tier2sell
	 */
	public float getEnergyRateStructure_period1_tier2sell() {
		return energyRateStructure_period1_tier2sell;
	}
	/**
	 * @param energyRateStructure_period1_tier2sell the energyRateStructure_period1_tier2sell to set
	 */
	public void setEnergyRateStructure_period1_tier2sell(
			float energyRateStructure_period1_tier2sell) {
		this.energyRateStructure_period1_tier2sell = energyRateStructure_period1_tier2sell;
	}
	/**
	 * @return the energyRateStructure_period2_tier2sell
	 */
	public float getEnergyRateStructure_period2_tier2sell() {
		return energyRateStructure_period2_tier2sell;
	}
	/**
	 * @param energyRateStructure_period2_tier2sell the energyRateStructure_period2_tier2sell to set
	 */
	public void setEnergyRateStructure_period2_tier2sell(
			float energyRateStructure_period2_tier2sell) {
		this.energyRateStructure_period2_tier2sell = energyRateStructure_period2_tier2sell;
	}
	/**
	 * @return the energyRateStructure_period3_tier1Max
	 */
	public float getEnergyRateStructure_period3_tier1Max() {
		return energyRateStructure_period3_tier1Max;
	}
	/**
	 * @param energyRateStructure_period3_tier1Max the energyRateStructure_period3_tier1Max to set
	 */
	public void setEnergyRateStructure_period3_tier1Max(
			float energyRateStructure_period3_tier1Max) {
		this.energyRateStructure_period3_tier1Max = energyRateStructure_period3_tier1Max;
	}
	/**
	 * @return the energyRateStructure_period3_tier2Rate
	 */
	public float getEnergyRateStructure_period3_tier2Rate() {
		return energyRateStructure_period3_tier2Rate;
	}
	/**
	 * @param energyRateStructure_period3_tier2Rate the energyRateStructure_period3_tier2Rate to set
	 */
	public void setEnergyRateStructure_period3_tier2Rate(
			float energyRateStructure_period3_tier2Rate) {
		this.energyRateStructure_period3_tier2Rate = energyRateStructure_period3_tier2Rate;
	}
	/**
	 * @return the energyRateStructure_period4_tier1Max
	 */
	public float getEnergyRateStructure_period4_tier1Max() {
		return energyRateStructure_period4_tier1Max;
	}
	/**
	 * @param energyRateStructure_period4_tier1Max the energyRateStructure_period4_tier1Max to set
	 */
	public void setEnergyRateStructure_period4_tier1Max(
			float energyRateStructure_period4_tier1Max) {
		this.energyRateStructure_period4_tier1Max = energyRateStructure_period4_tier1Max;
	}
	/**
	 * @return the energyRateStructure_period5_tier2Rate
	 */
	public float getEnergyRateStructure_period5_tier2Rate() {
		return energyRateStructure_period5_tier2Rate;
	}
	/**
	 * @param energyRateStructure_period5_tier2Rate the energyRateStructure_period5_tier2Rate to set
	 */
	public void setEnergyRateStructure_period5_tier2Rate(
			float energyRateStructure_period5_tier2Rate) {
		this.energyRateStructure_period5_tier2Rate = energyRateStructure_period5_tier2Rate;
	}
	}
}