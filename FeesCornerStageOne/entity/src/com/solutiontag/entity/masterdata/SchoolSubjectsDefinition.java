/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 29, 2014                        TODO

 */
package com.solutiontag.entity.masterdata;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.cache.annotation.Cacheable;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;
import com.feescorner.serverstartup.serverstartupServlets.GsonExclude;

@Entity
@Cacheable
@Table(name="subjectdefinition")
public class SchoolSubjectsDefinition extends ApplicationPrimaryClass implements Serializable,Cloneable {

  /**
   * 
   */
  public SchoolSubjectsDefinition(){
   
  
  }
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator="subjectgenerator")
  @GenericGenerator(name="subjectgenerator",strategy="com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  @Column(name="subject_id")
  private int subjectId;
  
  @Column(name="subjectreferenceId")
  private String subjectRefId;
  
  @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
  @JoinColumn(name="masterdata_id")
  @JsonBackReference
  @GsonExclude
  private SchoolMasterDataDefinition defForSubject;
  
  @Column(name="subject_name")
  private String subjectName;
  
  @Column(name="subjectpreferredstd")
  private  String subjectPreferreStd;
  
  @Column(name="standard_id")
  private Integer standardId;
  
  @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
  @JoinColumn(name="section_id")
  private SchoolClassSectionDefinition schoolClassSection;
  
  @Transient
  private String action="";
  
  @Transient
  private SchoolSubjectsDefinitionAssignment schoolSubjectAssignment;

  /**
   * @return the subjectId
   */
  public int getSubjectId() {
    return subjectId;
  }


  /**
   * @param subjectId the subjectId to set
   */
  public void setSubjectId(int subjectId) {
    this.subjectId = subjectId;
  }

  /**
   * @return the subjectName
   */
  public String getSubjectName() {
    return subjectName;
  }


  /**
   * @param subjectName the subjectName to set
   */
  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }


  /**
   * @return the defForSubject
   */
  public SchoolMasterDataDefinition getDefForSubject() {
    return defForSubject;
  }


  /**
   * @param defForSubject the defForSubject to set
   */
  public void setDefForSubject(SchoolMasterDataDefinition defForSubject) {
    this.defForSubject = defForSubject;
  }
  


  /**
   * @return the subjectRefId
   */
  public String getSubjectRefId() {
    return subjectRefId;
  }


  /**
   * @param subjectRefId the subjectRefId to set
   */
  public void setSubjectRefId(String subjectRefId) {
    this.subjectRefId = subjectRefId;
  }
  

  /**
   * @return the subjectPreferreStd
   */
  public String getSubjectPreferreStd() {
    return subjectPreferreStd;
  }


  /**
   * @param subjectPreferreStd the subjectPreferreStd to set
   */
  public void setSubjectPreferreStd(String subjectPreferreStd) {
    this.subjectPreferreStd = subjectPreferreStd;
  }


  /**
   * @return the schoolClassSection
   */
  public SchoolClassSectionDefinition getSchoolClassSection() {
    return schoolClassSection;
  }


  /**
   * @param schoolClassSection the schoolClassSection to set
   */
  public void setSchoolClassSection(SchoolClassSectionDefinition schoolClassSection) {
    this.schoolClassSection = schoolClassSection;
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
  
  @Override
  protected Object clone() throws CloneNotSupportedException {
      return super.clone();
  }


  /**
   * @return the schoolSubjectAssignment
   */
  public SchoolSubjectsDefinitionAssignment getSchoolSubjectAssignment() {
    return schoolSubjectAssignment;
  }


  /**
   * @param schoolSubjectAssignment the schoolSubjectAssignment to set
   */
  public void setSchoolSubjectAssignment(SchoolSubjectsDefinitionAssignment schoolSubjectAssignment) {
    this.schoolSubjectAssignment = schoolSubjectAssignment;
  }


  /**
   * @return the action
   */
  public String getAction() {
    return action;
  }


  /**
   * @param action the action to set
   */
  public void setAction(String action) {
    this.action = action;
  }

  
}
