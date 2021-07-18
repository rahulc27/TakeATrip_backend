package com.project.dto;


public class DetailsDTO {

	private String detailsId;
	private String about;
	private String packageInclusion;
	private String highlights;
	private String pace;
	
	
	private ItineraryDTO intineraryDTO;


	public String getDetailsId() {
		return detailsId;
	}


	public void setDetailsId(String detailsId) {
		this.detailsId = detailsId;
	}


	public String getAbout() {
		return about;
	}


	public void setAbout(String about) {
		this.about = about;
	}


	public String getPackageInclusion() {
		return packageInclusion;
	}


	public void setPackageInclusion(String packageInclusion) {
		this.packageInclusion = packageInclusion;
	}


	public String getHighlights() {
		return highlights;
	}


	public void setHighlights(String highlights) {
		this.highlights = highlights;
	}


	public String getPace() {
		return pace;
	}


	public void setPace(String pace) {
		this.pace = pace;
	}


	public ItineraryDTO getIntineraryDTO() {
		return intineraryDTO;
	}


	public void setIntineraryDTO(ItineraryDTO intineraryDTO) {
		this.intineraryDTO = intineraryDTO;
	}
	
	
}
