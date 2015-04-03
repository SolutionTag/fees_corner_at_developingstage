/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Mar 12, 2015                        TODO

 */
package com.solutiontag.entity.finance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;
import com.solutiontag.entity.masterdata.SchoolFeesDefinition;
import com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment;
import com.solutiontag.entity.masterdata.SchoolTermDefinition;

public class FeesTermsElementsArrangements  extends ApplicationPrimaryClass{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  

  
  private Map<Integer, HashMap<Integer, HashMap<Integer, HashMap<Integer, SchoolFeesDefinitionAssignment>>>> xxx=
     new  HashMap<Integer, HashMap<Integer,HashMap<Integer,HashMap<Integer,SchoolFeesDefinitionAssignment>>>>();
  
  
  
 
  
  

  private Map<Integer, Map<Integer,Map<Integer,Set<Map<Integer,SchoolFeesDefinitionAssignment>>>>> standardWiseTerm=new HashMap<Integer,  Map<Integer,Map<Integer,Set<Map<Integer,SchoolFeesDefinitionAssignment>>>>>();
  
  
  private Map<Integer, Map<Integer,Set<SchoolFeesDefinitionAssignment>>> perodWiseSectionMap =new HashMap<Integer, Map<Integer,Set<SchoolFeesDefinitionAssignment>>>();

 
  
  private Map<Integer,Set<SchoolTermDefinition>> availableTermsForStdandards=new HashMap<Integer, Set<SchoolTermDefinition>>();
  
  
  
  private Map<Integer,Map<Integer,SchoolFeesDefinitionAssignment>> sectionWiseMap=new HashMap<Integer, Map<Integer,SchoolFeesDefinitionAssignment>>();
  
  
  private Map<Integer,SchoolFeesDefinitionAssignment> frequencyWiseMap=new HashMap<Integer,SchoolFeesDefinitionAssignment>();
  
  private Set<Map<Integer,SchoolFeesDefinitionAssignment>> sectionTermSet=new HashSet<Map<Integer,SchoolFeesDefinitionAssignment>>();
  
  private Map<Integer,Set<Map<Integer,SchoolFeesDefinitionAssignment>>> sectionWiseFeesAssignmentMap=new HashMap<Integer,  Set<Map<Integer,SchoolFeesDefinitionAssignment>>>();

  private Map<Integer,Map<Integer,Set<Map<Integer,SchoolFeesDefinitionAssignment>>>> termWiseFeesMap=new HashMap<Integer,Map<Integer,Set<Map<Integer,SchoolFeesDefinitionAssignment>>>>();
  
  Map<Integer,Map<Integer,Map<Integer,  Map<Integer,List<SchoolFeesDefinitionAssignment>> >>> standardFee=new HashMap<Integer, Map<Integer,Map<Integer,  Map<Integer,List<SchoolFeesDefinitionAssignment>> >>>(); 
  
  private Map<Integer,Map<Integer, Map<Integer,Set<SchoolFeesDefinition>>>> assignedFeesStd=new HashMap<Integer, Map<Integer,Map<Integer,Set<SchoolFeesDefinition>>>>();

  /**
   * @return the xxx
   */
  public Map<Integer, HashMap<Integer, HashMap<Integer, HashMap<Integer, SchoolFeesDefinitionAssignment>>>> getXxx() {
    return xxx;
  }

  /**
   * @param xxx the xxx to set
   */
  public void setXxx(
      Map<Integer, HashMap<Integer, HashMap<Integer, HashMap<Integer, SchoolFeesDefinitionAssignment>>>> xxx) {
    this.xxx = xxx;
  }

  /**
   * @return the perodWiseSectionMap
   */
  public Map<Integer, Map<Integer, Set<SchoolFeesDefinitionAssignment>>> getPerodWiseSectionMap() {
    return perodWiseSectionMap;
  }

  /**
   * @param perodWiseSectionMap the perodWiseSectionMap to set
   */
  public void setPerodWiseSectionMap(
      Map<Integer, Map<Integer, Set<SchoolFeesDefinitionAssignment>>> perodWiseSectionMap) {
    this.perodWiseSectionMap = perodWiseSectionMap;
  }


  /**
   * @return the frequencyWiseMap
   */
  public Map<Integer, SchoolFeesDefinitionAssignment> getFrequencyWiseMap() {
    return frequencyWiseMap;
  }

  /**
   * @param frequencyWiseMap the frequencyWiseMap to set
   */
  public void setFrequencyWiseMap(Map<Integer, SchoolFeesDefinitionAssignment> frequencyWiseMap) {
    this.frequencyWiseMap = frequencyWiseMap;
  }

  /**
   * @return the sectionWiseMap
   */
  public Map<Integer, Map<Integer, SchoolFeesDefinitionAssignment>> getSectionWiseMap() {
    return sectionWiseMap;
  }

  /**
   * @param sectionWiseMap the sectionWiseMap to set
   */
  public void setSectionWiseMap(
      Map<Integer, Map<Integer, SchoolFeesDefinitionAssignment>> sectionWiseMap) {
    this.sectionWiseMap = sectionWiseMap;
  }

  /**
   * @return the availableTermsForStdandards
   */
  public Map<Integer, Set<SchoolTermDefinition>> getAvailableTermsForStdandards() {
    return availableTermsForStdandards;
  }

  /**
   * @param availableTermsForStdandards the availableTermsForStdandards to set
   */
  public void setAvailableTermsForStdandards(
      Map<Integer, Set<SchoolTermDefinition>> availableTermsForStdandards) {
    this.availableTermsForStdandards = availableTermsForStdandards;
  }

  /**
   * @return the sectionTermSet
   */
  public Set<Map<Integer, SchoolFeesDefinitionAssignment>> getSectionTermSet() {
    return sectionTermSet;
  }

  /**
   * @param sectionTermSet the sectionTermSet to set
   */
  public void setSectionTermSet(Set<Map<Integer, SchoolFeesDefinitionAssignment>> sectionTermSet) {
    this.sectionTermSet = sectionTermSet;
  }

  /**
   * @return the sectionWiseFeesAssignmentMap
   */
  public Map<Integer, Set<Map<Integer, SchoolFeesDefinitionAssignment>>> getSectionWiseFeesAssignmentMap() {
    return sectionWiseFeesAssignmentMap;
  }

  /**
   * @param sectionWiseFeesAssignmentMap the sectionWiseFeesAssignmentMap to set
   */
  public void setSectionWiseFeesAssignmentMap(
      Map<Integer, Set<Map<Integer, SchoolFeesDefinitionAssignment>>> sectionWiseFeesAssignmentMap) {
    this.sectionWiseFeesAssignmentMap = sectionWiseFeesAssignmentMap;
  }

  /**
   * @return the termWiseFeesMap
   */
  public Map<Integer, Map<Integer, Set<Map<Integer, SchoolFeesDefinitionAssignment>>>> getTermWiseFeesMap() {
    return termWiseFeesMap;
  }

  /**
   * @param termWiseFeesMap the termWiseFeesMap to set
   */
  public void setTermWiseFeesMap(
      Map<Integer, Map<Integer, Set<Map<Integer, SchoolFeesDefinitionAssignment>>>> termWiseFeesMap) {
    this.termWiseFeesMap = termWiseFeesMap;
  }

  /**
   * @return the standardWiseTerm
   */
  public Map<Integer, Map<Integer, Map<Integer, Set<Map<Integer, SchoolFeesDefinitionAssignment>>>>> getStandardWiseTerm() {
    return standardWiseTerm;
  }

  /**
   * @param standardWiseTerm the standardWiseTerm to set
   */
  public void setStandardWiseTerm(
      Map<Integer, Map<Integer, Map<Integer, Set<Map<Integer, SchoolFeesDefinitionAssignment>>>>> standardWiseTerm) {
    this.standardWiseTerm = standardWiseTerm;
  }

  

  /**
   * @return the assignedFeesStd
   */
  public Map<Integer, Map<Integer, Map<Integer, Set<SchoolFeesDefinition>>>> getAssignedFeesStd() {
    return assignedFeesStd;
  }

  /**
   * @param assignedFeesStd the assignedFeesStd to set
   */
  public void setAssignedFeesStd(
      Map<Integer, Map<Integer, Map<Integer, Set<SchoolFeesDefinition>>>> assignedFeesStd) {
    this.assignedFeesStd = assignedFeesStd;
  }

  /**
   * @return the standardFee
   */
  public Map<Integer, Map<Integer, Map<Integer, Map<Integer, List<SchoolFeesDefinitionAssignment>>>>> getStandardFee() {
    return standardFee;
  }

  /**
   * @param standardFee the standardFee to set
   */
  public void setStandardFee(
      Map<Integer, Map<Integer, Map<Integer, Map<Integer, List<SchoolFeesDefinitionAssignment>>>>> standardFee) {
    this.standardFee = standardFee;
  }

 


 

 

  
  /*
 * SectionWiseMap=sectionId(key),FeesAssigmentMap(value)
 * 
 * periodWiseSectionMap=    periodId(key),SectionWiseMap(value);
 * 
 *   termId(key),periodWiseSectionMap(value)
 * 
 * 
 * */
}
