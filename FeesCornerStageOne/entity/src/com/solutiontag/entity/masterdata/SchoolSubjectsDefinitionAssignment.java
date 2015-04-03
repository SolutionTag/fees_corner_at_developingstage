/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 28, 2015                        TODO

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

import org.hibernate.annotations.GenericGenerator;
import org.springframework.cache.annotation.Cacheable;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;

@Entity
@Cacheable
@Table(name="subjectassignment")
public class SchoolSubjectsDefinitionAssignment extends ApplicationPrimaryClass implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  
  @Id
  @GeneratedValue(generator="subjectgenerator")
  @GenericGenerator(name="subjectgenerator",strategy="com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  @Column(name="derivedsubjectid")
  private int derivedSubjectId;
  
  @Column(name="subjectreferenceId")
  private String subjectRefId;
  
  @Column(name="subjectname")
  private String subjectName;
  
  @Column(name="subjectpreferredstd")
  private  String subjectPreferreStd;
  
  @Column(name="standardid")
  private Integer standardId;
  
  @Column(name="basesubjectid")
  private Integer baseSubjectId;
  
  @ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
  @JoinColumn(name="section_id",referencedColumnName="equalId")
  private SchoolClassSectionDefinition schoolClassSection;
  
  



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
   * @return the baseSubjectId
   */
  public Integer getBaseSubjectId() {
    return baseSubjectId;
  }

  /**
   * @param baseSubjectId the baseSubjectId to set
   */
  public void setBaseSubjectId(Integer baseSubjectId) {
    this.baseSubjectId = baseSubjectId;
  }

  /**
   * @return the derivedSubjectId
   */
  public int getDerivedSubjectId() {
    return derivedSubjectId;
  }

  /**
   * @param derivedSubjectId the derivedSubjectId to set
   */
  public void setDerivedSubjectId(int derivedSubjectId) {
    this.derivedSubjectId = derivedSubjectId;
  }

}
