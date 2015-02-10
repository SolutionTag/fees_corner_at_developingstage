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
@Table(name="finedefinition")
public class SchoolFineDefinition implements Serializable {
  
  /**
   * 
   */
  public SchoolFineDefinition(){
    this.fineId=hashCode();
    this.hashSetIndexId=hashCode();
  }
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name="fineId")
  private Integer fineId;
  
  @Column(name="hashSetIndexId")
  private Integer hashSetIndexId; 
  
  @ManyToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="masterdata_id")
  private SchoolMasterDataDefinition defForFine;
  
  @Column(name="balance_amount") 
  private Integer balanceAmount;
  
  @Column(name="percentage_of_fine")
  private Integer percentageofFine;
  
  @Column(name="proportion")
  private Float proportion;

  /**
   * @return the fineId
   */
  public Integer getFineId() {
    return fineId;
  }

  /**
   * @param fineId the fineId to set
   */
  public void setFineId(Integer fineId) {
    this.fineId = fineId;
  }

  /**
   * @return the balanceAmount
   */
  public Integer getBalanceAmount() {
    return balanceAmount;
  }

  /**
   * @param balanceAmount the balanceAmount to set
   */
  public void setBalanceAmount(Integer balanceAmount) {
    this.balanceAmount = balanceAmount;
  }

  /**
   * @return the percentageofFine
   */
  public Integer getPercentageofFine() {
    return percentageofFine;
  }

  /**
   * @param percentageofFine the percentageofFine to set
   */
  public void setPercentageofFine(Integer percentageofFine) {
    this.percentageofFine = percentageofFine;
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
   * @return the defForFine
   */
  public SchoolMasterDataDefinition getDefForFine() {
    return defForFine;
  }

  /**
   * @param defForFine the defForFine to set
   */
  public void setDefForFine(SchoolMasterDataDefinition defForFine) {
    this.defForFine = defForFine;
  }

  @Override
  public boolean equals(Object obj){
    SchoolFineDefinition schoolFineDefinition=(SchoolFineDefinition) obj;
    return getHashSetIndexId()==schoolFineDefinition.getHashSetIndexId();
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

}
