package com.urjanet.energy.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * This is the main high level source akin to a database.
 * 
 * @author ac2211
 *
 */
@Entity
@Table(name = "urja_utility_rates")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_UTIL_RATES")
public class UtilityRates {

	@Id
	@GeneratedValue(generator = "idSeqGen", strategy = GenerationType.AUTO)
	private Long id;
	
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
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUtility() {
		return utility;
	}

	public void setUtility(String utility) {
		this.utility = utility;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceParent() {
		return sourceParent;
	}

	public void setSourceParent(String sourceParent) {
		this.sourceParent = sourceParent;
	}

	public float getVersion() {
		return version;
	}

	public void setVersion(float version) {
		this.version = version;
	}

	public String getUseNetMetering() {
		return useNetMetering;
	}

	public void setUseNetMetering(String useNetMetering) {
		this.useNetMetering = useNetMetering;
	}

	public float getPeakKwCapacityMin() {
		return peakKwCapacityMin;
	}

	public void setPeakKwCapacityMin(float peakKwCapacityMin) {
		this.peakKwCapacityMin = peakKwCapacityMin;
	}

	public float getPeakKwCapacityMax() {
		return peakKwCapacityMax;
	}

	public void setPeakKwCapacityMax(float peakKwCapacityMax) {
		this.peakKwCapacityMax = peakKwCapacityMax;
	}

	public float getPeakKwCapacityHistory() {
		return peakKwCapacityHistory;
	}

	public void setPeakKwCapacityHistory(float peakKwCapacityHistory) {
		this.peakKwCapacityHistory = peakKwCapacityHistory;
	}

	public float getPeakKwhusageMin() {
		return peakKwhusageMin;
	}

	public void setPeakKwhusageMin(float peakKwhusageMin) {
		this.peakKwhusageMin = peakKwhusageMin;
	}

	public float getPeakKwhusageMax() {
		return peakKwhusageMax;
	}

	public void setPeakKwhusageMax(float peakKwhusageMax) {
		this.peakKwhusageMax = peakKwhusageMax;
	}

	public float getPeakKwhusagehistory() {
		return peakKwhusagehistory;
	}

	public void setPeakKwhusagehistory(float peakKwhusagehistory) {
		this.peakKwhusagehistory = peakKwhusagehistory;
	}

	public String getVoltageCategory() {
		return voltageCategory;
	}

	public void setVoltageCategory(String voltageCategory) {
		this.voltageCategory = voltageCategory;
	}

	public String getPhaseWiring() {
		return phaseWiring;
	}

	public void setPhaseWiring(String phaseWiring) {
		this.phaseWiring = phaseWiring;
	}

	public float getVoltageMinimum() {
		return voltageMinimum;
	}

	public void setVoltageMinimum(float voltageMinimum) {
		this.voltageMinimum = voltageMinimum;
	}

	public float getVoltageMaximum() {
		return voltageMaximum;
	}

	public void setVoltageMaximum(float voltageMaximum) {
		this.voltageMaximum = voltageMaximum;
	}

	public float getFlatRatebuy() {
		return flatRatebuy;
	}

	public void setFlatRatebuy(float flatRatebuy) {
		this.flatRatebuy = flatRatebuy;
	}

	public float getFlatRatesell() {
		return flatRatesell;
	}

	public void setFlatRatesell(float flatRatesell) {
		this.flatRatesell = flatRatesell;
	}

	public float getFlatRatefueladj() {
		return flatRatefueladj;
	}

	public void setFlatRatefueladj(float flatRatefueladj) {
		this.flatRatefueladj = flatRatefueladj;
	}

	public float getFixedMonthlyCharge() {
		return fixedMonthlyCharge;
	}

	public void setFixedMonthlyCharge(float fixedMonthlyCharge) {
		this.fixedMonthlyCharge = fixedMonthlyCharge;
	}

	public String getBasicInformationComments() {
		return basicInformationComments;
	}

	public void setBasicInformationComments(String basicInformationComments) {
		this.basicInformationComments = basicInformationComments;
	}

	public String getFlatDemandUnit() {
		return flatDemandUnit;
	}

	public void setFlatDemandUnit(String flatDemandUnit) {
		this.flatDemandUnit = flatDemandUnit;
	}

	public String getDemandRateUnit() {
		return demandRateUnit;
	}

	public void setDemandRateUnit(String demandRateUnit) {
		this.demandRateUnit = demandRateUnit;
	}

	public float getFlatDemandMonth1() {
		return flatDemandMonth1;
	}

	public void setFlatDemandMonth1(float flatDemandMonth1) {
		this.flatDemandMonth1 = flatDemandMonth1;
	}

	public float getFlatDemandMonth2() {
		return flatDemandMonth2;
	}

	public void setFlatDemandMonth2(float flatDemandMonth2) {
		this.flatDemandMonth2 = flatDemandMonth2;
	}

	public float getFlatDemandMonth3() {
		return flatDemandMonth3;
	}

	public void setFlatDemandMonth3(float flatDemandMonth3) {
		this.flatDemandMonth3 = flatDemandMonth3;
	}

	public float getFlatDemandMonth4() {
		return flatDemandMonth4;
	}

	public void setFlatDemandMonth4(float flatDemandMonth4) {
		this.flatDemandMonth4 = flatDemandMonth4;
	}

	public float getFlatDemandMonth5() {
		return flatDemandMonth5;
	}

	public void setFlatDemandMonth5(float flatDemandMonth5) {
		this.flatDemandMonth5 = flatDemandMonth5;
	}

	public float getFlatDemandMonth6() {
		return flatDemandMonth6;
	}

	public void setFlatDemandMonth6(float flatDemandMonth6) {
		this.flatDemandMonth6 = flatDemandMonth6;
	}

	public float getFlatDemandMonth7() {
		return flatDemandMonth7;
	}

	public void setFlatDemandMonth7(float flatDemandMonth7) {
		this.flatDemandMonth7 = flatDemandMonth7;
	}

	public float getFlatDemandMonth8() {
		return flatDemandMonth8;
	}

	public void setFlatDemandMonth8(float flatDemandMonth8) {
		this.flatDemandMonth8 = flatDemandMonth8;
	}

	public float getFlatDemandMonth9() {
		return flatDemandMonth9;
	}

	public void setFlatDemandMonth9(float flatDemandMonth9) {
		this.flatDemandMonth9 = flatDemandMonth9;
	}

	public float getFlatDemandMonth10() {
		return flatDemandMonth10;
	}

	public void setFlatDemandMonth10(float flatDemandMonth10) {
		this.flatDemandMonth10 = flatDemandMonth10;
	}

	public float getFlatDemandMonth11() {
		return flatDemandMonth11;
	}

	public void setFlatDemandMonth11(float flatDemandMonth11) {
		this.flatDemandMonth11 = flatDemandMonth11;
	}

	public float getFlatDemandMonth12() {
		return flatDemandMonth12;
	}

	public void setFlatDemandMonth12(float flatDemandMonth12) {
		this.flatDemandMonth12 = flatDemandMonth12;
	}

	public String getDemandWeekdaySchedule() {
		return demandWeekdaySchedule;
	}

	public void setDemandWeekdaySchedule(String demandWeekdaySchedule) {
		this.demandWeekdaySchedule = demandWeekdaySchedule;
	}

	public String getDemandWeekendSchedule() {
		return demandWeekendSchedule;
	}

	public void setDemandWeekendSchedule(String demandWeekendSchedule) {
		this.demandWeekendSchedule = demandWeekendSchedule;
	}

	public float getDemandReactivePowercharge() {
		return demandReactivePowercharge;
	}

	public void setDemandReactivePowercharge(float demandReactivePowercharge) {
		this.demandReactivePowercharge = demandReactivePowercharge;
	}

	public float getDemandRatchetPercentage() {
		return demandRatchetPercentage;
	}

	public void setDemandRatchetPercentage(float demandRatchetPercentage) {
		this.demandRatchetPercentage = demandRatchetPercentage;
	}

	public float getDemandWindow() {
		return demandWindow;
	}

	public void setDemandWindow(float demandWindow) {
		this.demandWindow = demandWindow;
	}

	public String getDemandComments() {
		return demandComments;
	}

	public void setDemandComments(String demandComments) {
		this.demandComments = demandComments;
	}

	public String getEnergyRateUnit() {
		return energyRateUnit;
	}

	public void setEnergyRateUnit(String energyRateUnit) {
		this.energyRateUnit = energyRateUnit;
	}

	public String getEnergyWeekdaySchedule() {
		return energyWeekdaySchedule;
	}

	public void setEnergyWeekdaySchedule(String energyWeekdaySchedule) {
		this.energyWeekdaySchedule = energyWeekdaySchedule;
	}

	public String getEnergyWeekendSchedule() {
		return energyWeekendSchedule;
	}

	public void setEnergyWeekendSchedule(String energyWeekendSchedule) {
		this.energyWeekendSchedule = energyWeekendSchedule;
	}

	public String getEnergyComments() {
		return energyComments;
	}

	public void setEnergyComments(String energyComments) {
		this.energyComments = energyComments;
	}

	public String getSupersedes() {
		return supersedes;
	}

	public void setSupersedes(String supersedes) {
		this.supersedes = supersedes;
	}

	public float getDemandRateStructure_period1_period() {
		return demandRateStructure_period1_period;
	}

	public void setDemandRateStructure_period1_period(
			float demandRateStructure_period1_period) {
		this.demandRateStructure_period1_period = demandRateStructure_period1_period;
	}

	public float getDemandRateStructure_period2_period() {
		return demandRateStructure_period2_period;
	}

	public void setDemandRateStructure_period2_period(
			float demandRateStructure_period2_period) {
		this.demandRateStructure_period2_period = demandRateStructure_period2_period;
	}

	public float getDemandRateStructure_period2_tier1Rate() {
		return demandRateStructure_period2_tier1Rate;
	}

	public void setDemandRateStructure_period2_tier1Rate(
			float demandRateStructure_period2_tier1Rate) {
		this.demandRateStructure_period2_tier1Rate = demandRateStructure_period2_tier1Rate;
	}

	public float getDemandRateStructure_period1_tier1Rate() {
		return demandRateStructure_period1_tier1Rate;
	}

	public void setDemandRateStructure_period1_tier1Rate(
			float demandRateStructure_period1_tier1Rate) {
		this.demandRateStructure_period1_tier1Rate = demandRateStructure_period1_tier1Rate;
	}

	public float getDemandRateStructure_period3_period() {
		return demandRateStructure_period3_period;
	}

	public void setDemandRateStructure_period3_period(
			float demandRateStructure_period3_period) {
		this.demandRateStructure_period3_period = demandRateStructure_period3_period;
	}

	public float getDemandRateStructure_period3_tier1Rate() {
		return demandRateStructure_period3_tier1Rate;
	}

	public void setDemandRateStructure_period3_tier1Rate(
			float demandRateStructure_period3_tier1Rate) {
		this.demandRateStructure_period3_tier1Rate = demandRateStructure_period3_tier1Rate;
	}

	public float getDemandRateStructure_period1_tier1Adjustment() {
		return demandRateStructure_period1_tier1Adjustment;
	}

	public void setDemandRateStructure_period1_tier1Adjustment(
			float demandRateStructure_period1_tier1Adjustment) {
		this.demandRateStructure_period1_tier1Adjustment = demandRateStructure_period1_tier1Adjustment;
	}

	public float getDemandRateStructure_period2_tier1Adjustment() {
		return demandRateStructure_period2_tier1Adjustment;
	}

	public void setDemandRateStructure_period2_tier1Adjustment(
			float demandRateStructure_period2_tier1Adjustment) {
		this.demandRateStructure_period2_tier1Adjustment = demandRateStructure_period2_tier1Adjustment;
	}

	public float getFlatDemandStructure_period1_period() {
		return flatDemandStructure_period1_period;
	}

	public void setFlatDemandStructure_period1_period(
			float flatDemandStructure_period1_period) {
		this.flatDemandStructure_period1_period = flatDemandStructure_period1_period;
	}

	public float getFlatDemandStructure_period1_tier1Rate() {
		return flatDemandStructure_period1_tier1Rate;
	}

	public void setFlatDemandStructure_period1_tier1Rate(
			float flatDemandStructure_period1_tier1Rate) {
		this.flatDemandStructure_period1_tier1Rate = flatDemandStructure_period1_tier1Rate;
	}

	public float getFlatDemandStructure_period2_period() {
		return flatDemandStructure_period2_period;
	}

	public void setFlatDemandStructure_period2_period(
			float flatDemandStructure_period2_period) {
		this.flatDemandStructure_period2_period = flatDemandStructure_period2_period;
	}

	public float getFlatDemandStructure_period2_tier1Max() {
		return flatDemandStructure_period2_tier1Max;
	}

	public void setFlatDemandStructure_period2_tier1Max(
			float flatDemandStructure_period2_tier1Max) {
		this.flatDemandStructure_period2_tier1Max = flatDemandStructure_period2_tier1Max;
	}

	public float getFlatDemandStructure_period2_tier1Rate() {
		return flatDemandStructure_period2_tier1Rate;
	}

	public void setFlatDemandStructure_period2_tier1Rate(
			float flatDemandStructure_period2_tier1Rate) {
		this.flatDemandStructure_period2_tier1Rate = flatDemandStructure_period2_tier1Rate;
	}

	public float getFlatDemandStructure_period2_tier2Rate() {
		return flatDemandStructure_period2_tier2Rate;
	}

	public void setFlatDemandStructure_period2_tier2Rate(
			float flatDemandStructure_period2_tier2Rate) {
		this.flatDemandStructure_period2_tier2Rate = flatDemandStructure_period2_tier2Rate;
	}

	public float getFlatDemandStructure_period3_period() {
		return flatDemandStructure_period3_period;
	}

	public void setFlatDemandStructure_period3_period(
			float flatDemandStructure_period3_period) {
		this.flatDemandStructure_period3_period = flatDemandStructure_period3_period;
	}

	public float getFlatDemandStructure_period3_tier1Rate() {
		return flatDemandStructure_period3_tier1Rate;
	}

	public void setFlatDemandStructure_period3_tier1Rate(
			float flatDemandStructure_period3_tier1Rate) {
		this.flatDemandStructure_period3_tier1Rate = flatDemandStructure_period3_tier1Rate;
	}

	public float getFlatDemandStructure_period1_tier1Max() {
		return flatDemandStructure_period1_tier1Max;
	}

	public void setFlatDemandStructure_period1_tier1Max(
			float flatDemandStructure_period1_tier1Max) {
		this.flatDemandStructure_period1_tier1Max = flatDemandStructure_period1_tier1Max;
	}

	public float getFlatDemandStructure_period1_tier2Max() {
		return flatDemandStructure_period1_tier2Max;
	}

	public void setFlatDemandStructure_period1_tier2Max(
			float flatDemandStructure_period1_tier2Max) {
		this.flatDemandStructure_period1_tier2Max = flatDemandStructure_period1_tier2Max;
	}

	public float getFlatDemandStructure_period1_tier2Rate() {
		return flatDemandStructure_period1_tier2Rate;
	}

	public void setFlatDemandStructure_period1_tier2Rate(
			float flatDemandStructure_period1_tier2Rate) {
		this.flatDemandStructure_period1_tier2Rate = flatDemandStructure_period1_tier2Rate;
	}

	public float getFlatDemandStructure_period1_tier3Rate() {
		return flatDemandStructure_period1_tier3Rate;
	}

	public void setFlatDemandStructure_period1_tier3Rate(
			float flatDemandStructure_period1_tier3Rate) {
		this.flatDemandStructure_period1_tier3Rate = flatDemandStructure_period1_tier3Rate;
	}

	public float getFlatDemandStructure_period2_tier2Max() {
		return flatDemandStructure_period2_tier2Max;
	}

	public void setFlatDemandStructure_period2_tier2Max(
			float flatDemandStructure_period2_tier2Max) {
		this.flatDemandStructure_period2_tier2Max = flatDemandStructure_period2_tier2Max;
	}

	public float getFlatDemandStructure_period2_tier3Rate() {
		return flatDemandStructure_period2_tier3Rate;
	}

	public void setFlatDemandStructure_period2_tier3Rate(
			float flatDemandStructure_period2_tier3Rate) {
		this.flatDemandStructure_period2_tier3Rate = flatDemandStructure_period2_tier3Rate;
	}

	public float getFlatDemandStructure_period1_tier1Adjustment() {
		return flatDemandStructure_period1_tier1Adjustment;
	}

	public void setFlatDemandStructure_period1_tier1Adjustment(
			float flatDemandStructure_period1_tier1Adjustment) {
		this.flatDemandStructure_period1_tier1Adjustment = flatDemandStructure_period1_tier1Adjustment;
	}

	public float getFlatDemandStructure_period3_tier1Max() {
		return flatDemandStructure_period3_tier1Max;
	}

	public void setFlatDemandStructure_period3_tier1Max(
			float flatDemandStructure_period3_tier1Max) {
		this.flatDemandStructure_period3_tier1Max = flatDemandStructure_period3_tier1Max;
	}

	public float getFlatDemandStructure_period3_tier2Rate() {
		return flatDemandStructure_period3_tier2Rate;
	}

	public void setFlatDemandStructure_period3_tier2Rate(
			float flatDemandStructure_period3_tier2Rate) {
		this.flatDemandStructure_period3_tier2Rate = flatDemandStructure_period3_tier2Rate;
	}

	public float getEnergyRateStructure_period1_period() {
		return energyRateStructure_period1_period;
	}

	public void setEnergyRateStructure_period1_period(
			float energyRateStructure_period1_period) {
		this.energyRateStructure_period1_period = energyRateStructure_period1_period;
	}

	public float getEnergyRateStructure_period1_tier1Max() {
		return energyRateStructure_period1_tier1Max;
	}

	public void setEnergyRateStructure_period1_tier1Max(
			float energyRateStructure_period1_tier1Max) {
		this.energyRateStructure_period1_tier1Max = energyRateStructure_period1_tier1Max;
	}

	public float getEnergyRateStructure_period1_tier1Rate() {
		return energyRateStructure_period1_tier1Rate;
	}

	public void setEnergyRateStructure_period1_tier1Rate(
			float energyRateStructure_period1_tier1Rate) {
		this.energyRateStructure_period1_tier1Rate = energyRateStructure_period1_tier1Rate;
	}

	public float getEnergyRateStructure_period1_tier2Rate() {
		return energyRateStructure_period1_tier2Rate;
	}

	public void setEnergyRateStructure_period1_tier2Rate(
			float energyRateStructure_period1_tier2Rate) {
		this.energyRateStructure_period1_tier2Rate = energyRateStructure_period1_tier2Rate;
	}

	public float getEnergyRateStructure_period2_period() {
		return energyRateStructure_period2_period;
	}

	public void setEnergyRateStructure_period2_period(
			float energyRateStructure_period2_period) {
		this.energyRateStructure_period2_period = energyRateStructure_period2_period;
	}

	public float getEnergyRateStructure_period2_tier1Max() {
		return energyRateStructure_period2_tier1Max;
	}

	public void setEnergyRateStructure_period2_tier1Max(
			float energyRateStructure_period2_tier1Max) {
		this.energyRateStructure_period2_tier1Max = energyRateStructure_period2_tier1Max;
	}

	public float getEnergyRateStructure_period2_tier1Rate() {
		return energyRateStructure_period2_tier1Rate;
	}

	public void setEnergyRateStructure_period2_tier1Rate(
			float energyRateStructure_period2_tier1Rate) {
		this.energyRateStructure_period2_tier1Rate = energyRateStructure_period2_tier1Rate;
	}

	public float getEnergyRateStructure_period2_tier2Rate() {
		return energyRateStructure_period2_tier2Rate;
	}

	public void setEnergyRateStructure_period2_tier2Rate(
			float energyRateStructure_period2_tier2Rate) {
		this.energyRateStructure_period2_tier2Rate = energyRateStructure_period2_tier2Rate;
	}

	public float getEnergyRateStructure_period1_tier1Adjustment() {
		return energyRateStructure_period1_tier1Adjustment;
	}

	public void setEnergyRateStructure_period1_tier1Adjustment(
			float energyRateStructure_period1_tier1Adjustment) {
		this.energyRateStructure_period1_tier1Adjustment = energyRateStructure_period1_tier1Adjustment;
	}

	public float getEnergyRateStructure_period1_tier1sell() {
		return energyRateStructure_period1_tier1sell;
	}

	public void setEnergyRateStructure_period1_tier1sell(
			float energyRateStructure_period1_tier1sell) {
		this.energyRateStructure_period1_tier1sell = energyRateStructure_period1_tier1sell;
	}

	public float getEnergyRateStructure_period2_tier1Adjustment() {
		return energyRateStructure_period2_tier1Adjustment;
	}

	public void setEnergyRateStructure_period2_tier1Adjustment(
			float energyRateStructure_period2_tier1Adjustment) {
		this.energyRateStructure_period2_tier1Adjustment = energyRateStructure_period2_tier1Adjustment;
	}

	public float getEnergyRateStructure_period2_tier1sell() {
		return energyRateStructure_period2_tier1sell;
	}

	public void setEnergyRateStructure_period2_tier1sell(
			float energyRateStructure_period2_tier1sell) {
		this.energyRateStructure_period2_tier1sell = energyRateStructure_period2_tier1sell;
	}

	public float getEnergyRateStructure_period1_tier2Max() {
		return energyRateStructure_period1_tier2Max;
	}

	public void setEnergyRateStructure_period1_tier2Max(
			float energyRateStructure_period1_tier2Max) {
		this.energyRateStructure_period1_tier2Max = energyRateStructure_period1_tier2Max;
	}

	public float getEnergyRateStructure_period1_tier2Adjustment() {
		return energyRateStructure_period1_tier2Adjustment;
	}

	public void setEnergyRateStructure_period1_tier2Adjustment(
			float energyRateStructure_period1_tier2Adjustment) {
		this.energyRateStructure_period1_tier2Adjustment = energyRateStructure_period1_tier2Adjustment;
	}

	public float getEnergyRateStructure_period1_tier3Adjustment() {
		return energyRateStructure_period1_tier3Adjustment;
	}

	public void setEnergyRateStructure_period1_tier3Adjustment(
			float energyRateStructure_period1_tier3Adjustment) {
		this.energyRateStructure_period1_tier3Adjustment = energyRateStructure_period1_tier3Adjustment;
	}

	public float getEnergyRateStructure_period1_tier3Rate() {
		return energyRateStructure_period1_tier3Rate;
	}

	public void setEnergyRateStructure_period1_tier3Rate(
			float energyRateStructure_period1_tier3Rate) {
		this.energyRateStructure_period1_tier3Rate = energyRateStructure_period1_tier3Rate;
	}

	public float getEnergyRateStructure_period2_tier2Max() {
		return energyRateStructure_period2_tier2Max;
	}

	public void setEnergyRateStructure_period2_tier2Max(
			float energyRateStructure_period2_tier2Max) {
		this.energyRateStructure_period2_tier2Max = energyRateStructure_period2_tier2Max;
	}

	public float getEnergyRateStructure_period2_tier3Max() {
		return energyRateStructure_period2_tier3Max;
	}

	public void setEnergyRateStructure_period2_tier3Max(
			float energyRateStructure_period2_tier3Max) {
		this.energyRateStructure_period2_tier3Max = energyRateStructure_period2_tier3Max;
	}

	public float getEnergyRateStructure_period2_tier2Adjustment() {
		return energyRateStructure_period2_tier2Adjustment;
	}

	public void setEnergyRateStructure_period2_tier2Adjustment(
			float energyRateStructure_period2_tier2Adjustment) {
		this.energyRateStructure_period2_tier2Adjustment = energyRateStructure_period2_tier2Adjustment;
	}

	public float getEnergyRateStructure_period2_tier3Adjustment() {
		return energyRateStructure_period2_tier3Adjustment;
	}

	public void setEnergyRateStructure_period2_tier3Adjustment(
			float energyRateStructure_period2_tier3Adjustment) {
		this.energyRateStructure_period2_tier3Adjustment = energyRateStructure_period2_tier3Adjustment;
	}

	public float getEnergyRateStructure_period2_tier4Adjustment() {
		return energyRateStructure_period2_tier4Adjustment;
	}

	public void setEnergyRateStructure_period2_tier4Adjustment(
			float energyRateStructure_period2_tier4Adjustment) {
		this.energyRateStructure_period2_tier4Adjustment = energyRateStructure_period2_tier4Adjustment;
	}

	public float getEnergyRateStructure_period2_tier3Rate() {
		return energyRateStructure_period2_tier3Rate;
	}

	public void setEnergyRateStructure_period2_tier3Rate(
			float energyRateStructure_period2_tier3Rate) {
		this.energyRateStructure_period2_tier3Rate = energyRateStructure_period2_tier3Rate;
	}

	public float getEnergyRateStructure_period2_tier4Rate() {
		return energyRateStructure_period2_tier4Rate;
	}

	public void setEnergyRateStructure_period2_tier4Rate(
			float energyRateStructure_period2_tier4Rate) {
		this.energyRateStructure_period2_tier4Rate = energyRateStructure_period2_tier4Rate;
	}

	public float getEnergyRateStructure_period1_tier3Max() {
		return energyRateStructure_period1_tier3Max;
	}

	public void setEnergyRateStructure_period1_tier3Max(
			float energyRateStructure_period1_tier3Max) {
		this.energyRateStructure_period1_tier3Max = energyRateStructure_period1_tier3Max;
	}

	public float getEnergyRateStructure_period1_tier4Adjustment() {
		return energyRateStructure_period1_tier4Adjustment;
	}

	public void setEnergyRateStructure_period1_tier4Adjustment(
			float energyRateStructure_period1_tier4Adjustment) {
		this.energyRateStructure_period1_tier4Adjustment = energyRateStructure_period1_tier4Adjustment;
	}

	public float getEnergyRateStructure_period1_tier4Rate() {
		return energyRateStructure_period1_tier4Rate;
	}

	public void setEnergyRateStructure_period1_tier4Rate(
			float energyRateStructure_period1_tier4Rate) {
		this.energyRateStructure_period1_tier4Rate = energyRateStructure_period1_tier4Rate;
	}

	public float getEnergyRateStructure_period5_period() {
		return energyRateStructure_period5_period;
	}

	public void setEnergyRateStructure_period5_period(
			float energyRateStructure_period5_period) {
		this.energyRateStructure_period5_period = energyRateStructure_period5_period;
	}

	public float getEnergyRateStructure_period5_tier1Adjustment() {
		return energyRateStructure_period5_tier1Adjustment;
	}

	public void setEnergyRateStructure_period5_tier1Adjustment(
			float energyRateStructure_period5_tier1Adjustment) {
		this.energyRateStructure_period5_tier1Adjustment = energyRateStructure_period5_tier1Adjustment;
	}

	public float getEnergyRateStructure_period5_tier1Rate() {
		return energyRateStructure_period5_tier1Rate;
	}

	public void setEnergyRateStructure_period5_tier1Rate(
			float energyRateStructure_period5_tier1Rate) {
		this.energyRateStructure_period5_tier1Rate = energyRateStructure_period5_tier1Rate;
	}

	public float getEnergyRateStructure_period3_period() {
		return energyRateStructure_period3_period;
	}

	public void setEnergyRateStructure_period3_period(
			float energyRateStructure_period3_period) {
		this.energyRateStructure_period3_period = energyRateStructure_period3_period;
	}

	public float getEnergyRateStructure_period3_tier1Adjustment() {
		return energyRateStructure_period3_tier1Adjustment;
	}

	public void setEnergyRateStructure_period3_tier1Adjustment(
			float energyRateStructure_period3_tier1Adjustment) {
		this.energyRateStructure_period3_tier1Adjustment = energyRateStructure_period3_tier1Adjustment;
	}

	public float getEnergyRateStructure_period3_tier1Rate() {
		return energyRateStructure_period3_tier1Rate;
	}

	public void setEnergyRateStructure_period3_tier1Rate(
			float energyRateStructure_period3_tier1Rate) {
		this.energyRateStructure_period3_tier1Rate = energyRateStructure_period3_tier1Rate;
	}

	public float getEnergyRateStructure_period4_period() {
		return energyRateStructure_period4_period;
	}

	public void setEnergyRateStructure_period4_period(
			float energyRateStructure_period4_period) {
		this.energyRateStructure_period4_period = energyRateStructure_period4_period;
	}

	public float getEnergyRateStructure_period4_tier1Adjustment() {
		return energyRateStructure_period4_tier1Adjustment;
	}

	public void setEnergyRateStructure_period4_tier1Adjustment(
			float energyRateStructure_period4_tier1Adjustment) {
		this.energyRateStructure_period4_tier1Adjustment = energyRateStructure_period4_tier1Adjustment;
	}

	public float getEnergyRateStructure_period4_tier1Rate() {
		return energyRateStructure_period4_tier1Rate;
	}

	public void setEnergyRateStructure_period4_tier1Rate(
			float energyRateStructure_period4_tier1Rate) {
		this.energyRateStructure_period4_tier1Rate = energyRateStructure_period4_tier1Rate;
	}

	public float getEnergyRateStructure_period1_tier2sell() {
		return energyRateStructure_period1_tier2sell;
	}

	public void setEnergyRateStructure_period1_tier2sell(
			float energyRateStructure_period1_tier2sell) {
		this.energyRateStructure_period1_tier2sell = energyRateStructure_period1_tier2sell;
	}

	public float getEnergyRateStructure_period2_tier2sell() {
		return energyRateStructure_period2_tier2sell;
	}

	public void setEnergyRateStructure_period2_tier2sell(
			float energyRateStructure_period2_tier2sell) {
		this.energyRateStructure_period2_tier2sell = energyRateStructure_period2_tier2sell;
	}

	public float getEnergyRateStructure_period3_tier1Max() {
		return energyRateStructure_period3_tier1Max;
	}

	public void setEnergyRateStructure_period3_tier1Max(
			float energyRateStructure_period3_tier1Max) {
		this.energyRateStructure_period3_tier1Max = energyRateStructure_period3_tier1Max;
	}

	public float getEnergyRateStructure_period3_tier2Rate() {
		return energyRateStructure_period3_tier2Rate;
	}

	public void setEnergyRateStructure_period3_tier2Rate(
			float energyRateStructure_period3_tier2Rate) {
		this.energyRateStructure_period3_tier2Rate = energyRateStructure_period3_tier2Rate;
	}

	public float getEnergyRateStructure_period4_tier1Max() {
		return energyRateStructure_period4_tier1Max;
	}

	public void setEnergyRateStructure_period4_tier1Max(
			float energyRateStructure_period4_tier1Max) {
		this.energyRateStructure_period4_tier1Max = energyRateStructure_period4_tier1Max;
	}

	public float getEnergyRateStructure_period5_tier2Rate() {
		return energyRateStructure_period5_tier2Rate;
	}

	public void setEnergyRateStructure_period5_tier2Rate(
			float energyRateStructure_period5_tier2Rate) {
		this.energyRateStructure_period5_tier2Rate = energyRateStructure_period5_tier2Rate;
	}
}