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
@Table(name="feesdeducationdefintion")
public class SchoolPrepaidFeesDeducationDefinition implements Serializable {
  
  /**
   * 
   */
  public SchoolPrepaidFeesDeducationDefinition(){
    this.prepaidfeesdeductionid=hashCode();
    this.hashSetIndexId=hashCode();
  }
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="prepaidfeesdeductionid")
  private Integer prepaidfeesdeductionid;
  
  @ManyToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="masterdata_id")
  private SchoolMasterDataDefinition defForPrepaidFees;
  
  @Column(name="prepayment")
  private String prepayment;
  
  @Column(name="percentage_of_amount")
  private int percentageOfAmount;
  
  @Column(name="proportion")
  private float proportion;
  
  @Column(name="hashSetIndexId")
  private Integer hashSetIndexId;

  /**
   * @return the prepaidfeesdeductionid
   */
  public Integer getPrepaidfeesdeductionid() {
    return prepaidfeesdeductionid;
  }

  /**
   * @param prepaidfeesdeductionid the prepaidfeesdeductionid to set
   */
  public void setPrepaidfeesdeductionid(Integer prepaidfeesdeductionid) {
    this.prepaidfeesdeductionid = prepaidfeesdeductionid;
  }
  /**
   * @return the prepayment
   */
  public String getPrepayment() {
    return prepayment;
  }

  /**
   * @param prepayment the prepayment to set
   */
  public void setPrepayment(String prepayment) {
    this.prepayment = prepayment;
  }

  /**
   * @return the percentageOfAmount
   */
  public int getPercentageOfAmount() {
    return percentageOfAmount;
  }

  /**
   * @param percentageOfAmount the percentageOfAmount to set
   */
  public void setPercentageOfAmount(int percentageOfAmount) {
    this.percentageOfAmount = percentageOfAmount;
  }

  /**
   * @return the proportion
   */
  public float getProportion() {
    return proportion;
  }

  /**
   * @param proportion the proportion to set
   */
  public void setProportion(float proportion) {
    this.proportion = proportion;
  }

  /**
   * @return the serialversionuid
   */
  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  /**
   * @return the defForPrepaidFees
   */
  public SchoolMasterDataDefinition getDefForPrepaidFees() {
    return defForPrepaidFees;
  }

  /**
   * @param defForPrepaidFees the defForPrepaidFees to set
   */
  public void setDefForPrepaidFees(SchoolMasterDataDefinition defForPrepaidFees) {
    this.defForPrepaidFees = defForPrepaidFees;
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
    SchoolPrepaidFeesDeducationDefinition schoolPrepaidFeesDeducationDefinition=(SchoolPrepaidFeesDeducationDefinition) obj;
    return getHashSetIndexId()==schoolPrepaidFeesDeducationDefinition.getHashSetIndexId();
  }

}
