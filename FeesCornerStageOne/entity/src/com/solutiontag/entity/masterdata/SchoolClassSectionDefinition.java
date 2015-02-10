/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 2, 2015                        TODO

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

@Entity
@Cacheable
@Table(name="section")
public class SchoolClassSectionDefinition extends ApplicationPrimaryClass implements Serializable {
  
  /**
   * 
   */ 
  private static final long serialVersionUID = 1L;
  public  SchoolClassSectionDefinition(){
    
  }

  @Id
  @GeneratedValue(generator="sectiongenerator")
  @GenericGenerator(name="sectiongenerator",strategy="com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  @Column(name="section_id")
  private Integer sectionId;
  
  @Column(name="section_name")
  private String sectionName;
  
  @Column(name="maximumstudents")
  private Integer maximumStudents;
  
  
  @ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
  @JoinColumn(name="standard_id")
  private SchoolStandardsDefnition schoolStandardsDefnition;
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL,mappedBy="schoolClassSection",orphanRemoval=true)
  private Set<SchoolSubjectsDefinitionAssignment> schoolSubjectAssignmentSet=new HashSet<SchoolSubjectsDefinitionAssignment>();
  
  @Transient
  private List<SchoolSubjectsDefinitionAssignment> schoolSubjectAssignmentList=new ArrayList<SchoolSubjectsDefinitionAssignment>();

  /**
   * @return the sectionId
   */
  public Integer getSectionId() {
    return sectionId;
  }

  /**
   * @param sectionId the sectionId to set
   */
  public void setSectionId(Integer sectionId) {
    this.sectionId = sectionId;
  }

  /**
   * @return the sectionName
   */
  public String getSectionName() {
    return sectionName;
  }

  /**
   * @param sectionName the sectionName to set
   */
  public void setSectionName(String sectionName) {
    this.sectionName = sectionName;
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
   * @return the maximumStudents
   */
  public Integer getMaximumStudents() {
    return maximumStudents;
  }

  /**
   * @param maximumStudents the maximumStudents to set
   */
  public void setMaximumStudents(Integer maximumStudents) {
    this.maximumStudents = maximumStudents;
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
  public void setSchoolSubjectAssignmentSet(
      Set<SchoolSubjectsDefinitionAssignment> schoolSubjectAssignmentSet) {
    this.schoolSubjectAssignmentSet = schoolSubjectAssignmentSet;
  }

  /**
   * @return the schoolSubjectAssignmentList
   */
  public List<SchoolSubjectsDefinitionAssignment> getSchoolSubjectAssignmentList() {
    return schoolSubjectAssignmentList;
  }

  /**
   * @param schoolSubjectAssignmentList the schoolSubjectAssignmentList to set
   */
  public void setSchoolSubjectAssignmentList(
      List<SchoolSubjectsDefinitionAssignment> schoolSubjectAssignmentList) {
    this.schoolSubjectAssignmentList = schoolSubjectAssignmentList;
  }


}
