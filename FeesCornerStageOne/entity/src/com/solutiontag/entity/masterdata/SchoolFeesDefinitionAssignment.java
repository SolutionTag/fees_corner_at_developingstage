/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 19, 2015                        TODO

 */
package com.solutiontag.entity.masterdata;

import java.io.Serializable;

import javax.persistence.Cacheable;
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

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;

@Table(name="feesdefinitionassignment")
@Cacheable
@Entity
public class SchoolFeesDefinitionAssignment extends ApplicationPrimaryClass implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(generator="feesGeneration")
  @GenericGenerator(name="feesGeneration",strategy="com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  @Column(name="sectionfeesid")
  private Integer sectionfeesId;
  
  @Column(name="feesname")
  private String feesName;
  
  @Column(name="standardid")
  private Integer standardId;
  
  @Column(name="standrdname")
  private String standrdName;
  
  @Column(name="sectionname")
  private String sectionName;
  
  @Column(name="basefeesid")
  private Integer baseFeesId;
  
  @Column(name="feesamount")
  private Float feesAmount;
  
  @Column(name="termtype")
  private String termtType;
  
  @Column(name="termid")
  private Integer termId;
  
  @Column(name="period")
  private String period;
  
  @Column(name="termfrequecyid")
  private Integer termFrequencyId;
  
  @Column(name="vocationalgroupgroupid")
  private Integer vocationalGroupId;
  
  @Column(name="vocationalgroupname")
  private String vocationalGroupName;
  
/*  @Column(name="termAmountPercentage")
  private Float termAmountPercentage;
  
  @Column(name="monthAmountPercentage")
  private Float monthAmountPercentage;
  
  @Column(name="dueAmountforFees")
  private Float dueAmountforFees;
  
  @Column(name="termAmount")
  private Float termAmount;
  
  @Column(name="monthAmount")
  private Float monthAmount;*/
  
  @ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
  @JoinColumn(name="section_id",referencedColumnName="equalId")
  private SchoolClassSectionDefinition schoolClassSection;

  /**
   * @return the sectionfeesId
   */
  public Integer getSectionfeesId() {
    return sectionfeesId;
  }

  /**
   * @param sectionfeesId the sectionfeesId to set
   */
  public void setSectionfeesId(Integer sectionfeesId) {
    this.sectionfeesId = sectionfeesId;
  }

  /**
   * @return the feesName
   */
  public String getFeesName() {
    return feesName;
  }

  /**
   * @param feesName the feesName to set
   */
  public void setFeesName(String feesName) {
    this.feesName = feesName;
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
   * @return the standrdName
   */
  public String getStandrdName() {
    return standrdName;
  }

  /**
   * @param standrdName the standrdName to set
   */
  public void setStandrdName(String standrdName) {
    this.standrdName = standrdName;
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
   * @return the baseFeesId
   */
  public Integer getBaseFeesId() {
    return baseFeesId;
  }

  /**
   * @param baseFeesId the baseFeesId to set
   */
  public void setBaseFeesId(Integer baseFeesId) {
    this.baseFeesId = baseFeesId;
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
   * @return the feesAmount
   */
  public Float getFeesAmount() {
    return feesAmount;
  }

  /**
   * @param feesAmount the feesAmount to set
   */
  public void setFeesAmount(Float feesAmount) {
    this.feesAmount = feesAmount;
  }

  /**
   * @return the termtType
   */
  public String getTermtType() {
    return termtType;
  }

  /**
   * @param termtType the termtType to set
   */
  public void setTermtType(String termtType) {
    this.termtType = termtType;
  }

  /**
   * @return the termId
   */
  public Integer getTermId() {
    return termId;
  }

  /**
   * @param termId the termId to set
   */
  public void setTermId(Integer termId) {
    this.termId = termId;
  }

  /**
   * @return the period
   */
  public String getPeriod() {
    return period;
  }

  /**
   * @param period the period to set
   */
  public void setPeriod(String period) {
    this.period = period;
  }

  /**
   * @return the termFrequencyId
   */
  public Integer getTermFrequencyId() {
    return termFrequencyId;
  }

  /**
   * @param termFrequencyId the termFrequencyId to set
   */
  public void setTermFrequencyId(Integer termFrequencyId) {
    this.termFrequencyId = termFrequencyId;
  }

  /**
   * @return the vocationalGroupId
   */
  public Integer getVocationalGroupId() {
    return vocationalGroupId;
  }

  /**
   * @param vocationalGroupId the vocationalGroupId to set
   */
  public void setVocationalGroupId(Integer vocationalGroupId) {
    this.vocationalGroupId = vocationalGroupId;
  }

  /**
   * @return the vocationalGroupName
   */
  public String getVocationalGroupName() {
    return vocationalGroupName;
  }

  /**
   * @param vocationalGroupName the vocationalGroupName to set
   */
  public void setVocationalGroupName(String vocationalGroupName) {
    this.vocationalGroupName = vocationalGroupName;
  }


  


 
  
}
/*SELECT feesdefinitionassignment.sectionfeesid, feesdefinitionassignment.equal_id, 
feesdefinitionassignment.basefeesid, feesdefinitionassignment.due_amountfor_fees, 
feesdefinitionassignment.feesamount, feesdefinitionassignment.feesname, 
feesdefinitionassignment.month_amount, feesdefinitionassignment.month_amount_percentage, 
feesdefinitionassignment.sectionname, feesdefinitionassignment.standardid, 
feesdefinitionassignment.standrdname, feesdefinitionassignment.term_amount, 
feesdefinitionassignment.term_amount_percentage, feesdefinitionassignment.section_id  FROM `feesdefinitionassignment` GROUP BY  
feesdefinitionassignment.basefeesid HAVING COUNT(*) > 1 || ==1

*SELECT feesdefinitionassignment.sectionfeesid, feesdefinitionassignment.equal_id, 
*feesdefinitionassignment.basefeesid, 
*feesdefinitionassignment.due_amountfor_fees, 
*feesdefinitionassignment.feesamount, feesdefinitionassignment.feesname, 
*feesdefinitionassignment.month_amount,
* feesdefinitionassignment.month_amount_percentage, feesdefinitionassignment.sectionname,
*  feesdefinitionassignment.standardid, feesdefinitionassignment.standrdname, 
*  feesdefinitionassignment.term_amount, feesdefinitionassignment.term_amount_percentage, feesdefinitionassignment.section_id  FROM `feesdefinitionassignment`
* where feesdefinitionassignment.standardid = 84758 GROUP BY  feesdefinitionassignment.basefeesid HAVING COUNT(*) > 1 || ==1
*/