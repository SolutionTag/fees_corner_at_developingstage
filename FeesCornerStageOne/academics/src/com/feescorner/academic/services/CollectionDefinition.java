/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 2, 2015                        TODO

 */
package com.feescorner.academic.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.solutiontag.entity.academic.AcademicianInfo;
import com.solutiontag.entity.finance.FeesTermsElementsArrangements;
import com.solutiontag.entity.masterdata.SchoolClassSectionDefinition;
import com.solutiontag.entity.masterdata.SchoolFeesDefinition;
import com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment;
import com.solutiontag.entity.masterdata.SchoolStandardsDefnition;
import com.solutiontag.entity.masterdata.SchoolSubjectsDefinitionAssignment;

public class CollectionDefinition implements Serializable {
  
  /**
   * 
   */
  public CollectionDefinition(){
    if(monthsList.size()==0){
      loadMonths();
    }
    
  }
  private static final long serialVersionUID = 1L;
  private Set<AcademicianInfo> academicianInfoSet=new HashSet<AcademicianInfo>();
  private List<AcademicianInfo> academicianInfoList=new ArrayList<AcademicianInfo>();
  private Set<SchoolSubjectsDefinitionAssignment> schoolSubjectAssignmentSet=new HashSet<SchoolSubjectsDefinitionAssignment>();
  private List<SchoolStandardsDefnition> standardDefList=new ArrayList<SchoolStandardsDefnition>();
  private Set<SchoolFeesDefinition> schoolFeesDefSet=new HashSet<SchoolFeesDefinition>();
  private Set<SchoolFeesDefinitionAssignment>  schoolFeesAssignmentSet=new HashSet<SchoolFeesDefinitionAssignment>();
  private Set<SchoolClassSectionDefinition> classSectionDefSet=new HashSet<SchoolClassSectionDefinition>();
  private HashMap<Integer,  Set<SchoolFeesDefinitionAssignment>> standardFeesMap=new HashMap<Integer, Set<SchoolFeesDefinitionAssignment>>();
  private FeesTermsElementsArrangements feesTermElementArrangement=new FeesTermsElementsArrangements();

  private  static List<String> monthsList=new ArrayList<String>();
  
  /**
   * @return the academicianInfoSet
   */
  public Set<AcademicianInfo> getAcademicianInfoSet() {
    return academicianInfoSet;
  }
  /**
   * @param academicianInfoSet the academicianInfoSet to set
   */
  public void setAcademicianInfoSet(Set<AcademicianInfo> academicianInfoSet) {
    this.academicianInfoSet = academicianInfoSet;
  }
  /**
   * @return the schoolFeesDefSet
   */
  public Set<SchoolFeesDefinition> getSchoolFeesDefSet() {
    return schoolFeesDefSet;
  }
  /**
   * @param schoolFeesDefSet the schoolFeesDefSet to set
   */
  public void setSchoolFeesDefSet(Set<SchoolFeesDefinition> schoolFeesDefSet) {
    this.schoolFeesDefSet = schoolFeesDefSet;
  }
 public void loadMonths(){
   monthsList.add("JUN");
   monthsList.add("JULY");
   monthsList.add("AUG");
   monthsList.add("SEP");
   monthsList.add("OCT");
   monthsList.add("NOV");
   monthsList.add("DEC");
   monthsList.add("JAN");
   monthsList.add("FEB");
   monthsList.add("MAR");
   monthsList.add("APR");
   monthsList.add("MAY");
   
   
 }
/**
 * @return the monthsList
 */
public List<String> getMonthsList() {
  return monthsList;
}
/**
 * @param monthsList the monthsList to set
 */
public void setMonthsList(List<String> monthsList) {
  this.monthsList = monthsList;
}
/**
 * @return the schoolSubjectAssignmentSet
 */
public Set<SchoolSubjectsDefinitionAssignment> getSchoolSubjectAssignmentSet() {
  return schoolSubjectAssignmentSet;
}
/**
 * @param schoolSubjectAssignmentSet the schoolSubjectAssignmentSet to set
 */
public void setSchoolSubjectAssignmentSet(Set<SchoolSubjectsDefinitionAssignment> schoolSubjectAssignmentSet) {
  this.schoolSubjectAssignmentSet = schoolSubjectAssignmentSet;
}
/**
 * @return the classSectionDefSet
 */
public Set<SchoolClassSectionDefinition> getClassSectionDefSet() {
  return classSectionDefSet;
}
/**
 * @param classSectionDefSet the classSectionDefSet to set
 */
public void setClassSectionDefSet(Set<SchoolClassSectionDefinition> classSectionDefSet) {
  this.classSectionDefSet = classSectionDefSet;
}
/**
 * @return the academicianInfoList
 */
public List<AcademicianInfo> getAcademicianInfoList() {
  return academicianInfoList;
}
/**
 * @param academicianInfoList the academicianInfoList to set
 */
public void setAcademicianInfoList(List<AcademicianInfo> academicianInfoList) {
  this.academicianInfoList = academicianInfoList;
}
/**
 * @return the schoolFeesAssignmentSet
 */
public Set<SchoolFeesDefinitionAssignment> getSchoolFeesAssignmentSet() {
  return schoolFeesAssignmentSet;
}
/**
 * @param schoolFeesAssignmentSet the schoolFeesAssignmentSet to set
 */
public void setSchoolFeesAssignmentSet(Set<SchoolFeesDefinitionAssignment> schoolFeesAssignmentSet) {
  this.schoolFeesAssignmentSet = schoolFeesAssignmentSet;
}
/**
 * @return the standardDefList
 */
public List<SchoolStandardsDefnition> getStandardDefList() {
  return standardDefList;
}
/**
 * @param standardDefList the standardDefList to set
 */
public void setStandardDefList(List<SchoolStandardsDefnition> standardDefList) {
  this.standardDefList = standardDefList;
}
/**
 * @return the standardFeesMap
 */
public HashMap<Integer, Set<SchoolFeesDefinitionAssignment>> getStandardFeesMap() {
  return standardFeesMap;
}
/**
 * @param standardFeesMap the standardFeesMap to set
 */
public void setStandardFeesMap(HashMap<Integer, Set<SchoolFeesDefinitionAssignment>> standardFeesMap) {
  this.standardFeesMap = standardFeesMap;
}
/**
 * @return the feesTermElementArrangement
 */
public FeesTermsElementsArrangements getFeesTermElementArrangement() {
  return feesTermElementArrangement;
}
/**
 * @param feesTermElementArrangement the feesTermElementArrangement to set
 */
public void setFeesTermElementArrangement(FeesTermsElementsArrangements feesTermElementArrangement) {
  this.feesTermElementArrangement = feesTermElementArrangement;
}



}
