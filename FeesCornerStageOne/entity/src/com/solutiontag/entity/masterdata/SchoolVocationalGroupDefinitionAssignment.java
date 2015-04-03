/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 23, 2015                        TODO

 */
package com.solutiontag.entity.masterdata;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;

@Entity
@Table(name="vocatinalgroupassignment")
@Cacheable
public class SchoolVocationalGroupDefinitionAssignment extends ApplicationPrimaryClass {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator="groupvocgen")
  @GenericGenerator(name="groupvocgen",strategy="com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  @Column(name="groupid")
  private Integer groupId;
  
  @Column(name="groupname")
  private String groupName;
  
  @Column(name="basegroupid")
  private Integer baseGroupId;
  
  @Column(name="groupdefnition")
  private String groupDefnition;
  
  @Column(name="groupenabled")
  private boolean groupEnabled;
  
  @OneToMany(cascade=CascadeType.ALL, mappedBy="schoolVocationalGroup",orphanRemoval=true)
  private Set<SchoolClassSectionDefinition> sectionSet =new HashSet<SchoolClassSectionDefinition>();
  
  @ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
  @JoinColumn(name="standard_id")
  private SchoolStandardsDefnition schoolStandardsDefnition;
  
  @Column(name="allsectionfeesessame")
  private boolean allSectionFeesSame;

  /**
   * @return the groupId
   */
  public Integer getGroupId() {
    return groupId;
  }

  /**
   * @param groupId the groupId to set
   */
  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  /**
   * @return the groupName
   */
  public String getGroupName() {
    return groupName;
  }

  /**
   * @param groupName the groupName to set
   */
  public void setGroupName(String groupName) {
    this.groupName = groupName;
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
   * @return the serialversionuid
   */
  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  /**
   * @return the schoolStandardsDefnition
   */
  public SchoolStandardsDefnition getSchoolStandardsDefnition() {
    return schoolStandardsDefnition;
  }

  /**
   * @param schoolStandardsDefnition the schoolStandardsDefnition to set
   */
  public void setSchoolStandardsDefnition(SchoolStandardsDefnition schoolStandardsDefnition) {
    this.schoolStandardsDefnition = schoolStandardsDefnition;
  }

  /**
   * @return the baseGroupId
   */
  public Integer getBaseGroupId() {
    return baseGroupId;
  }

  /**
   * @param baseGroupId the baseGroupId to set
   */
  public void setBaseGroupId(Integer baseGroupId) {
    this.baseGroupId = baseGroupId;
  }

  /**
   * @return the groupDefnition
   */
  public String getGroupDefnition() {
    return groupDefnition;
  }

  /**
   * @param groupDefnition the groupDefnition to set
   */
  public void setGroupDefnition(String groupDefnition) {
    this.groupDefnition = groupDefnition;
  }

  /**
   * @return the groupEnabled
   */
  public boolean isGroupEnabled() {
    return groupEnabled;
  }

  /**
   * @param groupEnabled the groupEnabled to set
   */
  public void setGroupEnabled(boolean groupEnabled) {
    this.groupEnabled = groupEnabled;
  }

  /**
   * @return the allSectionFeesSame
   */
  public boolean isAllSectionFeesSame() {
    return allSectionFeesSame;
  }

  /**
   * @param allSectionFeesSame the allSectionFeesSame to set
   */
  public void setAllSectionFeesSame(boolean allSectionFeesSame) {
    this.allSectionFeesSame = allSectionFeesSame;
  }
  
  

}
