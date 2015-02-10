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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Table(name = "subsidiarydefinition")
public class SchoolSubsidiaryDefinition implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  public SchoolSubsidiaryDefinition(){
    this.schoolSubsidiaryId=hashCode();
    this.hashSetIndexId=hashCode();
  }

  @Id
  @Column(name = "schoolsubsidiaryid")
  private Integer schoolSubsidiaryId;

  @ManyToOne(cascade=CascadeType.ALL)
  @JoinColumn(name = "masterdata_id")
  private SchoolMasterDataDefinition defForSubsidiary;

  @Column(name = "backwardclass_name")
  private String backwardClassName;

  @Column(name = "subsidary_percentage")
  private Integer subsidaryPercentage;

  @Column(name = "proportion")
  private Float proportion;

  @Column(name = "goorder_id")
  private String goOrderId;

  @Column(name="hashSetIndexId")
  private Integer hashSetIndexId;

  /**
   * @return the backwardClassName
   */
  public String getBackwardClassName() {
    return backwardClassName;
  }

  /**
   * @param backwardClassName the backwardClassName to set
   */
  public void setBackwardClassName(String backwardClassName) {
    this.backwardClassName = backwardClassName;
  }



  /**
   * @return the goOrderId
   */
  public String getGoOrderId() {
    return goOrderId;
  }

  /**
   * @param goOrderId the goOrderId to set
   */
  public void setGoOrderId(String goOrderId) {
    this.goOrderId = goOrderId;
  }

  /**
   * @return the schoolSubsidiaryId
   */
  public Integer getSchoolSubsidiaryId() {
    return schoolSubsidiaryId;
  }

  /**
   * @param schoolSubsidiaryId the schoolSubsidiaryId to set
   */
  public void setSchoolSubsidiaryId(Integer schoolSubsidiaryId) {
    this.schoolSubsidiaryId = schoolSubsidiaryId;
  }

  /**
   * @return the subsidaryPercentage
   */
  public Integer getSubsidaryPercentage() {
    return subsidaryPercentage;
  }

  /**
   * @param subsidaryPercentage the subsidaryPercentage to set
   */
  public void setSubsidaryPercentage(Integer subsidaryPercentage) {
    this.subsidaryPercentage = subsidaryPercentage;
  }

  /**
   * @return the proportion
   */
  public Float getProportion() {
    return proportion;
  }

  /**
   * @param proportion the proportion to set
   */
  public void setProportion(Float proportion) {
    this.proportion = proportion;
  }

  /**
   * @return the defForSubsidiary
   */
  public SchoolMasterDataDefinition getDefForSubsidiary() {
    return defForSubsidiary;
  }

  /**
   * @param defForSubsidiary the defForSubsidiary to set
   */
  public void setDefForSubsidiary(SchoolMasterDataDefinition defForSubsidiary) {
    this.defForSubsidiary = defForSubsidiary;
  }

  /**
   * @return the hashSetIndexId
   */
  public Integer getHashSetIndexId() {
    return hashSetIndexId;
  }

  /**
   * @param hashSetIndexId the hashSetIndexId to set
   */
  public void setHashSetIndexId(Integer hashSetIndexId) {
    this.hashSetIndexId = hashSetIndexId;
  }

  @Override
  public boolean equals(Object obj){
    SchoolSubsidiaryDefinition schoolSubsidiaryDefinition=(SchoolSubsidiaryDefinition) obj;
    return getHashSetIndexId()==schoolSubsidiaryDefinition.getHashSetIndexId();
  }
}
