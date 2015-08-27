/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
varadharajan.r       Apr 11, 2015                        TODO

 */
package com.feescorner.academic.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feescorner.masterdata.handlers.MasterDataHandler;
import com.feescorner.serverstartup.dbUtils.ApplicationUtills;
import com.meshyog.edument.prerequisites.AcademicMasterDataJsonPrerequisites;
import com.solutiontag.entity.masterdata.SchoolClassSectionDefinition;
import com.solutiontag.entity.masterdata.SchoolMasterDataDefinition;
import com.solutiontag.entity.masterdata.SchoolStandardsDefnition;
import com.solutiontag.entity.masterdata.SchoolVocationalGroupDefinition;

@Component
public class ApplicationStringJsons implements Serializable {

	 @Autowired
	  public AcademicMasterDataJsonPrerequisites jsonPrerequisites;
	 @Autowired
	 public MasterDataHandler masterDataHandler;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*academic master data jsp,js prerequisites json strings*/
	private String standardJsonObjectAsString;
	private String sectionJsonObjectAsString;
	private String vocationalGroupJsonObjectAsString;
	private String prerequisitesForSubjectAssignment;
	private String prerequisitesForVocationalGroupAssignment;
	private String prerequisitesForVocationalGroupSubjectAssignment;
	private String prerequisitesForGroupMetaInfo;
	private String prerequisitesForAllClassSectionSet;
	
	/**
	 * @return the prerequisitesForAllClassSectionSet
	 */
	public String getPrerequisitesForAllClassSectionSet() {
		return prerequisitesForAllClassSectionSet;
	}
	/**
	 * @param prerequisitesForAllClassSectionSet the prerequisitesForAllClassSectionSet to set
	 */
	public void setPrerequisitesForAllClassSectionSet(
			String prerequisitesForAllClassSectionSet) {
		this.prerequisitesForAllClassSectionSet = prerequisitesForAllClassSectionSet;
	}
	/**
	 * @return the prerequisitesForSubjectAssignment
	 */
	public String getPrerequisitesForSubjectAssignment() {
		return prerequisitesForSubjectAssignment;
	}
	/**
	 * @param prerequisitesForSubjectAssignment the prerequisitesForSubjectAssignment to set
	 */
	public void setPrerequisitesForSubjectAssignment(
			String prerequisitesForSubjectAssignment) {
		this.prerequisitesForSubjectAssignment = prerequisitesForSubjectAssignment;
	}
	/**
	 * @return the prerequisitesForVocationalGroupAssignment
	 */
	public String getPrerequisitesForVocationalGroupAssignment() {
		return prerequisitesForVocationalGroupAssignment;
	}
	/**
	 * @param prerequisitesForVocationalGroupAssignment the prerequisitesForVocationalGroupAssignment to set
	 */
	public void setPrerequisitesForVocationalGroupAssignment(
			String prerequisitesForVocationalGroupAssignment) {
		this.prerequisitesForVocationalGroupAssignment = prerequisitesForVocationalGroupAssignment;
	}
	/**
	 * @return the prerequisitesForVocationalGroupSubjectAssignment
	 */
	public String getPrerequisitesForVocationalGroupSubjectAssignment() {
		return prerequisitesForVocationalGroupSubjectAssignment;
	}
	/**
	 * @param prerequisitesForVocationalGroupSubjectAssignment the prerequisitesForVocationalGroupSubjectAssignment to set
	 */
	public void setPrerequisitesForVocationalGroupSubjectAssignment(
			String prerequisitesForVocationalGroupSubjectAssignment) {
		this.prerequisitesForVocationalGroupSubjectAssignment = prerequisitesForVocationalGroupSubjectAssignment;
	}
	/**
	 * @return the prerequisitesForGroupMetaInfo
	 */
	public String getPrerequisitesForGroupMetaInfo() {
		return prerequisitesForGroupMetaInfo;
	}
	/**
	 * @param prerequisitesForGroupMetaInfo the prerequisitesForGroupMetaInfo to set
	 */
	public void setPrerequisitesForGroupMetaInfo(
			String prerequisitesForGroupMetaInfo) {
		this.prerequisitesForGroupMetaInfo = prerequisitesForGroupMetaInfo;
	}
	/**
	 * @return the vocationalGroupJsonObjectAsString
	 */
	public String getVocationalGroupJsonObjectAsString() {
		return vocationalGroupJsonObjectAsString;
	}
	/**
	 * @param vocationalGroupJsonObjectAsString the vocationalGroupJsonObjectAsString to set
	 */
	public void setVocationalGroupJsonObjectAsString(
			String vocationalGroupJsonObjectAsString) {
		this.vocationalGroupJsonObjectAsString = vocationalGroupJsonObjectAsString;
	}
	/**
	 * @return the standardJsonObjectAsString
	 */
	public String getStandardJsonObjectAsString() {
		return standardJsonObjectAsString;
	}
	/**
	 * @param standardJsonObjectAsString the standardJsonObjectAsString to set
	 */
	public void setStandardJsonObjectAsString(String standardJsonObjectAsString) {
		this.standardJsonObjectAsString = standardJsonObjectAsString;
	}
	/**
	 * @return the sectionJsonObjectAsString
	 */
	public String getSectionJsonObjectAsString() {
		return sectionJsonObjectAsString;
	}
	/**
	 * @param sectionJsonObjectAsString the sectionJsonObjectAsString to set
	 */
	public void setSectionJsonObjectAsString(String sectionJsonObjectAsString) {
		this.sectionJsonObjectAsString = sectionJsonObjectAsString;
	}
    
	public ApplicationStringJsons getApplicationStringJsonForAcademicMasterData(SchoolMasterDataDefinition schoolMasterDataDefinition){
		List<SchoolStandardsDefnition> standardDefList=new ArrayList<SchoolStandardsDefnition>(schoolMasterDataDefinition.getSchoolStandardsDefnition());
		   List<SchoolVocationalGroupDefinition> vocationalGroupList=new ArrayList<SchoolVocationalGroupDefinition>(schoolMasterDataDefinition.getVocatinalGroupDefSet());
		   jsonPrerequisites.setStandardDefSet(schoolMasterDataDefinition.getSchoolStandardsDefnition());
		   jsonPrerequisites.getPrerequisitesForVocationalGroupAssignment();
		   jsonPrerequisites.getPrerequisitesForVocationalGroupSubjectAssignment();
		   this.setPrerequisitesForAllClassSectionSet(ApplicationUtills.convertListToJsonString(new ArrayList<SchoolClassSectionDefinition>(masterDataHandler.getAllSections())));
		   this.setPrerequisitesForGroupMetaInfo( jsonPrerequisites.getPrerequisitesForGroupMetaInfo());
		   this.setPrerequisitesForVocationalGroupAssignment(jsonPrerequisites.getPrerequisitesForVocationalGroupAssignment ());
		   this.setPrerequisitesForSubjectAssignment(jsonPrerequisites.getPrerequisitesForSubjectAssignment());
		   this.setPrerequisitesForVocationalGroupSubjectAssignment(jsonPrerequisites.getPrerequisitesForVocationalGroupSubjectAssignment());
		   this.setStandardJsonObjectAsString(ApplicationUtills.convertListToJsonString(standardDefList));
		   this.setVocationalGroupJsonObjectAsString(ApplicationUtills.convertListToJsonString(vocationalGroupList));
		   return this;
	}
}
