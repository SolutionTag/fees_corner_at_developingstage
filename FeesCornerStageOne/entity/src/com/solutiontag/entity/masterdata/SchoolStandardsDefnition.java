/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 29, 2014                        TODO

 */
package com.solutiontag.entity.masterdata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.cache.annotation.Cacheable;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;
import com.feescorner.serverstartup.dbUtils.ApplicationUtills;

@Entity
@Cacheable
@Table(name="standard")
public class SchoolStandardsDefnition extends ApplicationPrimaryClass implements Serializable {
  /**
   * 
   */
 public  SchoolStandardsDefnition(){
  
   this.statusForChecked=false; 
   
   
 }
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator="standardgenerator")
  @GenericGenerator(name="standardgenerator",strategy="com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  @Column(name="standard_id")
  private Integer standardId;
  
  @Column(name="standardreferencename")
  private String standardReferenceName;
  

  @Column(name="sort") 
  private int sort;
  
  @ManyToOne( fetch=FetchType.LAZY, cascade=CascadeType.ALL)
  @JoinColumn(name="masterdata_id")
  private SchoolMasterDataDefinition defForStandard;
  
  @Column(name="standard_name")
  private String standardName;
  
  @Column(name="statusforchecked")
  private boolean statusForChecked;
 
  @Transient
  private  List<SchoolClassSectionDefinition> section=new ArrayList<SchoolClassSectionDefinition>();
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL, mappedBy="schoolStandardsDefnition",orphanRemoval=true)
  private Set<SchoolClassSectionDefinition> sectionSet =new HashSet<SchoolClassSectionDefinition>();
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL, mappedBy="schoolStandardsDefnition",orphanRemoval=true)
  private Set<SchoolStandardWiseFeesDefinition> stdWiseFeesDefinitions =new HashSet<SchoolStandardWiseFeesDefinition>(); 

  /**
   * @return the defForStandard
   */
  public SchoolMasterDataDefinition getDefForStandard() {
    return defForStandard;
  }

  /**
   * @param defForStandard the defForStandard to set
   */
  public void setDefForStandard(SchoolMasterDataDefinition defForStandard) {
    this.defForStandard = defForStandard;
  }

  /**
   * @return the standardName
   */
  public String getStandardName() {
    return standardName;
  }

  /**
   * @param standardName the standardName to set
   */
  public void setStandardName(String standardName) {
    this.standardName = standardName;
  }

  /**
   * @return the sort
   */
  public int getSort() {
    return sort;
  }

  /**
   * @param sort the sort to set
   */
  public void setSort(int sort) {
    this.sort = sort;
  }

  /**
   * @return the statusForChecked
   */
  public boolean isStatusForChecked() {
    return statusForChecked;
  }

  /**
   * @param statusForChecked the statusForChecked to set
   */
  public void setStatusForChecked(boolean statusForChecked) {
    this.statusForChecked = statusForChecked;
  }

  /**
   * @return the standardReferenceName
   */
  public String getStandardReferenceName() {
    return standardReferenceName;
  }

  /**
   * @param standardReferenceName the standardReferenceName to set
   */
  public void setStandardReferenceName(String standardReferenceName) {
    this.standardReferenceName = standardReferenceName;
  }

  /**
   * @return the standardId
   */
  public Integer getStandardId() {
    return standardId;
  }

  /**
   * @param standardId the standardId to set
   */
  public void setStandardId(Integer standardId) {
    this.standardId = standardId;
  }

  /**
   * @return the section
   */
  public List<SchoolClassSectionDefinition> getSection() {
    return section;
  }

  /**
   * @param section the section to set
   */
  public void setSection(List<SchoolClassSectionDefinition> section) {
    this.section = section;
  }

  /**
   * @return the sectionSet
   */
  public Set<SchoolClassSectionDefinition> getSectionSet() {
    return sectionSet;
  }

  /**
   * @param sectionSet the sectionSet to set
   */
  public void setSectionSet(Set<SchoolClassSectionDefinition> sectionSet) {
    this.sectionSet = sectionSet;
  }

  /**
   * @return the stdWiseFeesDefinitions
   */
  public Set<SchoolStandardWiseFeesDefinition> getStdWiseFeesDefinitions() {
    return stdWiseFeesDefinitions;
  }

  /**
   * @param stdWiseFeesDefinitions the stdWiseFeesDefinitions to set
   */
  public void setStdWiseFeesDefinitions(Set<SchoolStandardWiseFeesDefinition> stdWiseFeesDefinitions) {
    this.stdWiseFeesDefinitions = stdWiseFeesDefinitions;
  }


 

 






 


}
