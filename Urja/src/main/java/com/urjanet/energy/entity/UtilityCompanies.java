package com.urjanet.energy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * utility companies and their web site
 * 
 * @author ac2211
 *
 */
@Entity
@Table(name = "urja_utility_companies")
@SequenceGenerator(name = "idSeqGen", sequenceName = "SEQ_URJA_UTIL_COMPANIES")
public class UtilityCompanies {

	@Id
	@GeneratedValue(generator = "idSeqGen", strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 512)
	private String label;
	@Column(length = 1024)
	private String uri;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
}