package com.urjanet.energy.json;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class BulkManifest {

	
	private Map<String, Series> dataset = new HashMap<>();



	public Map<String, Series> getDataset() {
		return dataset;
	}



	public void setDataset(Map<String, Series> dataset) {
		this.dataset = dataset;
	}



	public static class Series {
		@SerializedName("last_updated")
		private Date lastUpdated;
		@SerializedName("category_id")
		private String categoryId;
		private String name;
		@SerializedName("data_set")
		private String dataSet;
		private String identifier;
		private String title;
		private String description;
		private String keyword;
		private String publisher;
		private String person;
		private String mbox;
		private String accessLevel;
		private String accessLevelComment;
		private String accessURL;
		private String webService;
		private String format;
		private String license;
		private String spatial;
		private String temporal;
		private Date modified;

		public Date getLastUpdated() {
			return lastUpdated;
		}

		public void setLastUpdated(Date lastUpdated) {
			this.lastUpdated = lastUpdated;
		}

		public String getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(String categoryId) {
			this.categoryId = categoryId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDataSet() {
			return dataSet;
		}

		public void setDataSet(String dataSet) {
			this.dataSet = dataSet;
		}

		public String getIdentifier() {
			return identifier;
		}

		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public String getPerson() {
			return person;
		}

		public void setPerson(String person) {
			this.person = person;
		}

		public String getMbox() {
			return mbox;
		}

		public void setMbox(String mbox) {
			this.mbox = mbox;
		}

		public String getAccessLevel() {
			return accessLevel;
		}

		public void setAccessLevel(String accessLevel) {
			this.accessLevel = accessLevel;
		}

		public String getAccessLevelComment() {
			return accessLevelComment;
		}

		public void setAccessLevelComment(String accessLevelComment) {
			this.accessLevelComment = accessLevelComment;
		}

		public String getAccessURL() {
			return accessURL;
		}

		public void setAccessURL(String accessURL) {
			this.accessURL = accessURL;
		}

		public String getWebService() {
			return webService;
		}

		public void setWebService(String webService) {
			this.webService = webService;
		}

		public String getFormat() {
			return format;
		}

		public void setFormat(String format) {
			this.format = format;
		}

		public String getLicense() {
			return license;
		}

		public void setLicense(String license) {
			this.license = license;
		}

		public String getSpatial() {
			return spatial;
		}

		public void setSpatial(String spatial) {
			this.spatial = spatial;
		}

		public String getTemporal() {
			return temporal;
		}

		public void setTemporal(String temporal) {
			this.temporal = temporal;
		}

		public Date getModified() {
			return modified;
		}

		public void setModified(Date modified) {
			this.modified = modified;
		}
	}
}