/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
varadharajan.r       Apr 19, 2015                        TODO

 */
package com.meshyog.edument.prerequisites;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import atg.taglib.json.util.JSONArray;

import com.solutiontag.entity.masterdata.SchoolClassSectionDefinition;
import com.solutiontag.entity.masterdata.SchoolStandardsDefnition;
import com.solutiontag.entity.masterdata.SchoolVocationalGroupDefinitionAssignment;

@Component
public class AcademicMasterDataJsonPrerequisites {

	private Set < SchoolStandardsDefnition > standardDefSet = new HashSet < SchoolStandardsDefnition > ();

	/**
	 * @return the standardDefSet
	 */
	public Set < SchoolStandardsDefnition > getStandardDefSet() {
		return standardDefSet;
	}
	/**
	 * @param standardDefSet the standardDefSet to set
	 */
	public void setStandardDefSet(Set <SchoolStandardsDefnition > standardDefSet) {
		this.standardDefSet = standardDefSet;
	}
	public String getPrerequisitesForVocationalGroupAssignment() {
		JSONObject vocationalGroupsAssignedInfo = new JSONObject();
		JSONArray vocationalGrpAssignmentArray = null;
		for (SchoolStandardsDefnition standardDef: standardDefSet) {
			Integer standardId = standardDef.getStandardId();
			List < SchoolVocationalGroupDefinitionAssignment > vocationalGroupList = new ArrayList < SchoolVocationalGroupDefinitionAssignment > (standardDef.getGroupSet());
			vocationalGrpAssignmentArray = new JSONArray();
			for (SchoolVocationalGroupDefinitionAssignment vocationGroupDefAssignment: vocationalGroupList) {
				JSONObject vocationalGroupInfo = new JSONObject();
				vocationalGroupInfo.put("derivedcompareid", vocationGroupDefAssignment.getCompareId());
				vocationalGroupInfo.put("status", vocationGroupDefAssignment.isGroupEnabled());
				vocationalGroupInfo.put("basegroupcompareid", vocationGroupDefAssignment.getBaseGroupId());
				vocationalGrpAssignmentArray.put(vocationalGroupInfo);
			}
			vocationalGroupsAssignedInfo.put(String.valueOf(standardId), vocationalGrpAssignmentArray);
		}
		return vocationalGroupsAssignedInfo.toString();
	}
	public String getPrerequisitesForSubjectAssignment() {
		JSONObject subjectAssignment = new JSONObject();
		JSONArray subjectAssignmentArray = null;
		for (SchoolStandardsDefnition standardDef: standardDefSet) {
			Integer standardId = standardDef.getStandardId();
			if (standardDef.isStatusForChecked() == true) {
				List < SchoolClassSectionDefinition > classSectionList = new ArrayList < SchoolClassSectionDefinition > (standardDef.getSectionSet());
				subjectAssignmentArray = new JSONArray();
				for (SchoolClassSectionDefinition classSectionObj: classSectionList) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("sectionId", classSectionObj.getCompareId());
					jsonObject.put("sectionName", classSectionObj.getSectionName());
					subjectAssignmentArray.put(jsonObject);
				}
				subjectAssignment.put(String.valueOf(standardId), subjectAssignmentArray);
			}
		}
		return subjectAssignment.toString();
	}
	public String getPrerequisitesForVocationalGroupSubjectAssignment() {
		JSONObject vocationalGroupsSujectAssignedInfo = new JSONObject();
		JSONArray vocationalGrpAssignmentArray = null;
		JSONObject vocationalGroupByStd = null;
		for (SchoolStandardsDefnition standardDef: standardDefSet) {
			Integer standardId = standardDef.getStandardId();
			if (standardDef.isStatusForChecked() == true && standardDef != null) {
				List < SchoolVocationalGroupDefinitionAssignment > stnadardVocationalGroupsList = new ArrayList < SchoolVocationalGroupDefinitionAssignment > (standardDef.getGroupSet());
				vocationalGroupByStd = new JSONObject();;
				for (SchoolVocationalGroupDefinitionAssignment stdVocationalGroup: stnadardVocationalGroupsList) {
					Integer standardGroupCompareId = stdVocationalGroup.getCompareId();
					if (stdVocationalGroup.isGroupEnabled() == true && stdVocationalGroup.getSectionSet().size() != 0) {
						Set < SchoolClassSectionDefinition > classSectionSet = stdVocationalGroup.getSectionSet();
						for (SchoolClassSectionDefinition vocationalGroupSection: classSectionSet) {
							JSONObject vocationalGrpSection = new JSONObject();
							vocationalGrpSection.put("sectionId", vocationalGroupSection.getCompareId());
							vocationalGrpSection.put("sectionName", vocationalGroupSection.getSectionName());

						}
					}
					JSONObject vocationalGrpSection = new JSONObject();
					vocationalGrpSection.put("groupname", stdVocationalGroup.getGroupName());
					vocationalGroupByStd.put(String.valueOf(standardGroupCompareId), vocationalGrpSection);
				}
				vocationalGroupsSujectAssignedInfo.put(String.valueOf(standardId), vocationalGroupByStd);
			}
		}
		return vocationalGroupsSujectAssignedInfo.toString();
	}
	public String getPrerequisitesForGroupMetaInfo() {
		JSONObject vocationGroupMetaInfo = new JSONObject();
		JSONObject vocationalGroupByStd = new JSONObject();
		for (SchoolStandardsDefnition standardDef: standardDefSet) {
			if (standardDef.isStatusForChecked() == true) {
				List < SchoolVocationalGroupDefinitionAssignment > stnadardVocationalGroupsList = new ArrayList < SchoolVocationalGroupDefinitionAssignment > (standardDef.getGroupSet());
				// vocationalGroupByStd=new JSONObject();;
				for (SchoolVocationalGroupDefinitionAssignment stdVocationalGroup: stnadardVocationalGroupsList) {
					if(stdVocationalGroup.isGroupEnabled()==true){
						JSONObject jsonObject = new JSONObject();
						jsonObject.put("groupname", stdVocationalGroup.getGroupName());
						vocationalGroupByStd.put(String.valueOf(stdVocationalGroup.getCompareId()), jsonObject);
					}
					
				}
			}
		}
		return vocationalGroupByStd.toString();
	}
	
}