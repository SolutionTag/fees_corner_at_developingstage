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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.tiles.request.servlet.extractor.ApplicationScopeExtractor;
import org.springframework.cache.annotation.Cacheable;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;

@Entity
@Cacheable
@Table(name="stdwisefeesdefinition")
public class SchoolStandardWiseFeesDefinition extends ApplicationPrimaryClass implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public SchoolStandardWiseFeesDefinition(){
    //this.standardId=hashCode();
  }
  
 
  
  @Id
  @Column(name="stdWiseFeesId")
  private Integer stdWiseFeesId;
  
  @Column(name="feesId")
  private Integer feesId;
 
  @Column(name="fees_name")
  private Integer feesName;
  
  @Column(name="yearwise")
  private float yearwiseAmount;
  
  @Column(name="termwise")
  private float termWiseAmount;
  
  @Column(name="monthlywise")
  private float monthlyWiseAmount;
  
  @Column(name="formonth")
  private String months;
  
  @Column(name="sectionid")
  private Integer sectionId;
  
  @Column(name="sectionname")
  private String sectionName;
  
  @Column(name="standardname")
  private String standardName;
  
  @Column(name="type")
  private String  type;
  
  @ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
  @JoinColumn(name="standard_id")
  private SchoolStandardsDefnition schoolStandardsDefnition;

  /**
   * @return the stdWiseFeesId
   */
  public Integer getStdWiseFeesId() {
    return stdWiseFeesId;
  }

  /**
   * @param stdWiseFeesId the stdWiseFeesId to set
   */
  public void setStdWiseFeesId(Integer stdWiseFeesId) {
    this.stdWiseFeesId = stdWiseFeesId;
  }

  /**
   * @return the feesId
   */
  public Integer getFeesId() {
    return feesId;
  }

  /**
   * @param feesId the feesId to set
   */
  public void setFeesId(Integer feesId) {
    this.feesId = feesId;
  }

  /**
   * @return the feesName
   */
  public Integer getFeesName() {
    return feesName;
  }

  /**
   * @param feesName the feesName to set
   */
  public void setFeesName(Integer feesName) {
    this.feesName = feesName;
  }

  /**
   * @return the yearwiseAmount
   */
  public float getYearwiseAmount() {
    return yearwiseAmount;
  }

  /**
   * @param yearwiseAmount the yearwiseAmount to set
   */
  public void setYearwiseAmount(float yearwiseAmount) {
    this.yearwiseAmount = yearwiseAmount;
  }

  /**
   * @return the termWiseAmount
   */
  public float getTermWiseAmount() {
    return termWiseAmount;
  }

  /**
   * @param termWiseAmount the termWiseAmount to set
   */
  public void setTermWiseAmount(float termWiseAmount) {
    this.termWiseAmount = termWiseAmount;
  }

  /**
   * @return the monthlyWiseAmount
   */
  public float getMonthlyWiseAmount() {
    return monthlyWiseAmount;
  }

  /**
   * @param monthlyWiseAmount the monthlyWiseAmount to set
   */
  public void setMonthlyWiseAmount(float monthlyWiseAmount) {
    this.monthlyWiseAmount = monthlyWiseAmount;
  }

  /**
   * @return the months
   */
  public String getMonths() {
    return months;
  }

  /**
   * @param months the months to set
   */
  public void setMonths(String months) {
    this.months = months;
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
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }
  
 
  

  
}
