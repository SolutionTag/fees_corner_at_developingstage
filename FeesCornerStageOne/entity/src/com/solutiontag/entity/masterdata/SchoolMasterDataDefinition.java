/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 29, 2014                        TODO

 */
package com.solutiontag.entity.masterdata;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.cache.annotation.Cacheable;

import com.feescorner.serverstartup.dbUtils.ApplicationUtills;


@Entity
@Cacheable
@Table(name="schoolmasterdata")
public class SchoolMasterDataDefinition implements Serializable {
  
  /**
   * 
   */
  public SchoolMasterDataDefinition(){
    
  /*  SchoolStandardsDefnition schoolStandardsDefnition =new SchoolStandardsDefnition();
    schoolStandardsDefnition.setDefForStandard(this);*/
    if(schoolStandardsDefnition.size()==0){
      loadDefaultStandards();
    }
   
    
    SchoolSubjectsDefinition schoolSubjectsDefinition =new SchoolSubjectsDefinition();
    schoolSubjectsDefinition.setDefForSubject(this);
   // this.schoolSubjectsDefinition.add(schoolSubjectsDefinition);
    
  
   // this.schoolStandardWiseFeesDefinition.add(schoolStandardWiseFeesDefinition);
    
    SchoolFineDefinition schoolFineDefinition=new SchoolFineDefinition();
    schoolFineDefinition.setDefForFine(this);
   // this.schoolFineDefinition.add(schoolFineDefinition);
    
    SchoolPrepaidFeesDeducationDefinition schoolPrepaidFeesDeducationDefinition=new SchoolPrepaidFeesDeducationDefinition();
    schoolPrepaidFeesDeducationDefinition.setDefForPrepaidFees(this);
   // this.schoolPrepaidFeesDeducationDefinition.add(schoolPrepaidFeesDeducationDefinition);
    
    SchoolSubsidiaryDefinition schoolSubsidiaryDefinition=new SchoolSubsidiaryDefinition();
    schoolSubsidiaryDefinition.setDefForSubsidiary(this);
   // this.schoolSubsidiaryDefinition.add(schoolSubsidiaryDefinition);
    
    SchoolLeavesDefinition schoolLeavesDefinition =new SchoolLeavesDefinition();
    schoolLeavesDefinition.setDefForLeave(this);
   // this.schoolLeavesDefinition.add(schoolLeavesDefinition);
    
    SchoolStafPayRollDefinition schoolStafPayRollDefinition=new SchoolStafPayRollDefinition();
    schoolStafPayRollDefinition.setDefForStaffPays(this);
  //  this.schoolStafPayRollDefinition.add(schoolStafPayRollDefinition);
   
    
    //SchoolStandardsDefnition
    
  }
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(generator="schoolmasterdatagen")
  @GenericGenerator(name="schoolmasterdatagen",strategy="com.feescorner.masterdata.genrators.SchoolMasterDataDefinitionGenerator")
  @Column(name="masterdata_id")
  private String masterDataId;
  
  @Column(name="master_dataschoolId")
  private Integer shoolId;
  
  @Column(name="masterdata_creation_startedtime")
  private Date masterDataCreationStartedTime;
  
  @Column(name="masterdata_creation_initiatorname")
  private String masterDataCreationInitiatorName;
  
  @Column(name="masterdata_creation_initiatorid")
  private Integer masterDataCreationInitiatorId;
  
  @MapsId
  @OneToOne(cascade=CascadeType.ALL, mappedBy="schoolMasterData")
  @JoinColumn(name = "masterdata_id") 
  private SchoolCollection schoolCollection;
  
  
  @ElementCollection
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL,mappedBy="defForStandard",orphanRemoval=true)
  @OrderBy("sort ASC")
  private Set<SchoolStandardsDefnition> schoolStandardsDefnition=new LinkedHashSet<SchoolStandardsDefnition>();
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL,mappedBy="defForSubject",orphanRemoval=true)
  @JsonManagedReference
  private Set<SchoolSubjectsDefinition> schoolSubjectsDefinition=new LinkedHashSet<SchoolSubjectsDefinition>();
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL,mappedBy="defForFine",orphanRemoval=true)
  private Set<SchoolFineDefinition> schoolFineDefinition=new LinkedHashSet<SchoolFineDefinition>();
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL,mappedBy="defForPrepaidFees",orphanRemoval=true)
  private Set<SchoolPrepaidFeesDeducationDefinition> schoolPrepaidFeesDeducationDefinition=new LinkedHashSet<SchoolPrepaidFeesDeducationDefinition>();
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL,mappedBy="defForSubsidiary",orphanRemoval=true)
  private Set<SchoolSubsidiaryDefinition> schoolSubsidiaryDefinition=new LinkedHashSet<SchoolSubsidiaryDefinition>();
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL,mappedBy="defForLeave",orphanRemoval=true)
  private Set<SchoolLeavesDefinition> schoolLeavesDefinition=new LinkedHashSet<SchoolLeavesDefinition>();
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL,mappedBy="defForStaffPays",orphanRemoval=true)
  private Set<SchoolStafPayRollDefinition> schoolStafPayRollDefinition=new LinkedHashSet<SchoolStafPayRollDefinition>();

  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL,mappedBy="defForFees",orphanRemoval=true)
  private Set<SchoolFeesDefinition> schoolFeesDefintion=new LinkedHashSet<SchoolFeesDefinition>();
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL,mappedBy="defForVocationalDefinition",orphanRemoval=true)
  @JsonManagedReference
  private Set<SchoolVocationalGroupDefinition> vocatinalGroupDefSet=new HashSet<SchoolVocationalGroupDefinition>();
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL,mappedBy="defForTerm",orphanRemoval=true)
  private Set<SchoolTermDefinition> termDefinitionSet=new HashSet<SchoolTermDefinition>();
  /**
   * @return the shoolId
   */
  public Integer getShoolId() {
    return shoolId;
  }

  /**
   * @param shoolId the shoolId to set
   */
  public void setShoolId(Integer shoolId) {
    this.shoolId = shoolId;
  }

  /**
   * @return the masterDataCreationStartedTime
   */
  public Date getMasterDataCreationStartedTime() {
    return masterDataCreationStartedTime;
  }

  /**
   * @param masterDataCreationStartedTime the masterDataCreationStartedTime to set
   */
  public void setMasterDataCreationStartedTime(Date masterDataCreationStartedTime) {
    this.masterDataCreationStartedTime = masterDataCreationStartedTime;
  }

  /**
   * @return the masterDataCreationInitiatorName
   */
  public String getMasterDataCreationInitiatorName() {
    return masterDataCreationInitiatorName;
  }

  /**
   * @param masterDataCreationInitiatorName the masterDataCreationInitiatorName to set
   */
  public void setMasterDataCreationInitiatorName(String masterDataCreationInitiatorName) {
    this.masterDataCreationInitiatorName = masterDataCreationInitiatorName;
  }

  /**
   * @return the masterDataCreationInitiatorId
   */
  public Integer getMasterDataCreationInitiatorId() {
    return masterDataCreationInitiatorId;
  }

  /**
   * @param masterDataCreationInitiatorId the masterDataCreationInitiatorId to set
   */
  public void setMasterDataCreationInitiatorId(Integer masterDataCreationInitiatorId) {
    this.masterDataCreationInitiatorId = masterDataCreationInitiatorId;
  }

  /**
   * @return the schoolCollection
   */
  public SchoolCollection getSchoolCollection() {
    return schoolCollection;
  }

  /**
   * @param schoolCollection the schoolCollection to set
   */
  public void setSchoolCollection(SchoolCollection schoolCollection) {
    this.schoolCollection = schoolCollection;
  }


  /**
   * @return the schoolSubjectsDefinition
   */
  public Set<SchoolSubjectsDefinition> getSchoolSubjectsDefinition() {
    return schoolSubjectsDefinition;
  }

  /**
   * @param schoolSubjectsDefinition the schoolSubjectsDefinition to set
   */
  public void setSchoolSubjectsDefinition(Set<SchoolSubjectsDefinition> schoolSubjectsDefinition) {
    this.schoolSubjectsDefinition = schoolSubjectsDefinition;
  }

  /**
   * @return the schoolFineDefinition
   */
  public Set<SchoolFineDefinition> getSchoolFineDefinition() {
    return schoolFineDefinition;
  }

  /**
   * @param schoolFineDefinition the schoolFineDefinition to set
   */
  public void setSchoolFineDefinition(Set<SchoolFineDefinition> schoolFineDefinition) {
    this.schoolFineDefinition = schoolFineDefinition;
  }

  /**
   * @return the schoolPrepaidFeesDeducationDefinition
   */
  public Set<SchoolPrepaidFeesDeducationDefinition> getSchoolPrepaidFeesDeducationDefinition() {
    return schoolPrepaidFeesDeducationDefinition;
  }

  /**
   * @param schoolPrepaidFeesDeducationDefinition the schoolPrepaidFeesDeducationDefinition to set
   */
  public void setSchoolPrepaidFeesDeducationDefinition(
      Set<SchoolPrepaidFeesDeducationDefinition> schoolPrepaidFeesDeducationDefinition) {
    this.schoolPrepaidFeesDeducationDefinition = schoolPrepaidFeesDeducationDefinition;
  }

  /**
   * @return the schoolSubsidiaryDefinition
   */
  public Set<SchoolSubsidiaryDefinition> getSchoolSubsidiaryDefinition() {
    return schoolSubsidiaryDefinition;
  }

  /**
   * @param schoolSubsidiaryDefinition the schoolSubsidiaryDefinition to set
   */
  public void setSchoolSubsidiaryDefinition(Set<SchoolSubsidiaryDefinition> schoolSubsidiaryDefinition) {
    this.schoolSubsidiaryDefinition = schoolSubsidiaryDefinition;
  }

  /**
   * @return the schoolLeavesDefinition
   */
  public Set<SchoolLeavesDefinition> getSchoolLeavesDefinition() {
    return schoolLeavesDefinition;
  }

  /**
   * @param schoolLeavesDefinition the schoolLeavesDefinition to set
   */
  public void setSchoolLeavesDefinition(Set<SchoolLeavesDefinition> schoolLeavesDefinition) {
    this.schoolLeavesDefinition = schoolLeavesDefinition;
  }

  /**
   * @return the schoolStafPayRollDefinition
   */
  public Set<SchoolStafPayRollDefinition> getSchoolStafPayRollDefinition() {
    return schoolStafPayRollDefinition;
  }

  /**
   * @param schoolStafPayRollDefinition the schoolStafPayRollDefinition to set
   */
  public void setSchoolStafPayRollDefinition(
      Set<SchoolStafPayRollDefinition> schoolStafPayRollDefinition) {
    this.schoolStafPayRollDefinition = schoolStafPayRollDefinition;
  }

  /**
   * @return the masterDataId
   */
  public String getMasterDataId() {
    return masterDataId;
  }

  /**
   * @param masterDataId the masterDataId to set
   */
  public void setMasterDataId(String masterDataId) {
    this.masterDataId = masterDataId;
  }


public void loadDefaultStandards(){
  SchoolStandardsDefnition schoolStandardDefintion=null;
  for(int i=0;i<14;i++){
    schoolStandardDefintion=new SchoolStandardsDefnition();
    if(i==0){
      schoolStandardDefintion.setStandardReferenceName("Lower Kindergarten");
      schoolStandardDefintion.setSort(i+1);
      schoolStandardDefintion.setStandardName("LKG");
     // schoolStandardDefintion.setNoOfGroupEnabled(0);
    }else if(i==1){
      schoolStandardDefintion.setStandardReferenceName("Upper Kindergarten");
      schoolStandardDefintion.setSort(i+1);
      schoolStandardDefintion.setStandardName("UKG");
     // schoolStandardDefintion.setNoOfGroupEnabled(0);
    }else{
      schoolStandardDefintion.setStandardReferenceName("STD"+(i-1));
      schoolStandardDefintion.setSort(i+1);
      schoolStandardDefintion.setStandardName(ApplicationUtills.RomanNumerals(i-1));
     // schoolStandardDefintion.setNoOfGroupEnabled(0);
    }
    schoolStandardDefintion.setDefForStandard(this);
    this.schoolStandardsDefnition.add(schoolStandardDefintion);
   
  }
}

/**
 * @return the schoolStandardsDefnition
 */
public Set<SchoolStandardsDefnition> getSchoolStandardsDefnition() {
  return schoolStandardsDefnition;
}

/**
 * @param schoolStandardsDefnition the schoolStandardsDefnition to set
 */
public void setSchoolStandardsDefnition(Set<SchoolStandardsDefnition> schoolStandardsDefnition) {
  this.schoolStandardsDefnition = schoolStandardsDefnition;
}

/**
 * @return the schoolFeesDefintion
 */
public Set<SchoolFeesDefinition> getSchoolFeesDefintion() {
  return schoolFeesDefintion;
}

/**
 * @param schoolFeesDefintion the schoolFeesDefintion to set
 */
public void setSchoolFeesDefintion(Set<SchoolFeesDefinition> schoolFeesDefintion) {
  this.schoolFeesDefintion = schoolFeesDefintion;
}

/**
 * @return the vocatinalGroupDefSet
 */
public Set<SchoolVocationalGroupDefinition> getVocatinalGroupDefSet() {
  return vocatinalGroupDefSet;
}

/**
 * @param vocatinalGroupDefSet the vocatinalGroupDefSet to set
 */
public void setVocatinalGroupDefSet(Set<SchoolVocationalGroupDefinition> vocatinalGroupDefSet) {
  this.vocatinalGroupDefSet = vocatinalGroupDefSet;
}

/**
 * @return the termDefinitionSet
 */
public Set<SchoolTermDefinition> getTermDefinitionSet() {
  return termDefinitionSet;
}

/**
 * @param termDefinitionSet the termDefinitionSet to set
 */
public void setTermDefinitionSet(Set<SchoolTermDefinition> termDefinitionSet) {
  this.termDefinitionSet = termDefinitionSet;
}









}
