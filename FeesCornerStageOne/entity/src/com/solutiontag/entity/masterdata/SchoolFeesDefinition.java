/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 5, 2015                        TODO

 */
package com.solutiontag.entity.masterdata;

import java.io.Serializable;
import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;
@Entity
@Table(name="feesdefinition")
public class SchoolFeesDefinition extends ApplicationPrimaryClass implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

 
  @Id
  @GeneratedValue(generator="feesdefgenerator")
  @GenericGenerator(name = "feesdefgenerator", strategy = "com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  @Column(name="feesid")
  private Integer feesId;
  
  @Column(name="feesname")
  private String feesName;
  
  @Column(name="feestype")
  private String feesType;
  
  @Column(name="feescreateddate")
  private String feesCreatedDate;
  
  @Column(name="purposeoffees")
  private String purpose;

  
  @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
  @JoinColumn(name="masterdata_id")
  private SchoolMasterDataDefinition defForFees;
  

  

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
   * @return the defForFees
   */
  public SchoolMasterDataDefinition getDefForFees() {
    return defForFees;
  }

  /**
   * @param defForFees the defForFees to set
   */
  public void setDefForFees(SchoolMasterDataDefinition defForFees) {
    this.defForFees = defForFees;
  }

  /**
   * @return the feesType
   */
  public String getFeesType() {
    return feesType;
  }

  /**
   * @param feesType the feesType to set
   */
  public void setFeesType(String feesType) {
    this.feesType = feesType;
  }

  /**
   * @return the purpose
   */
  public String getPurpose() {
    return purpose;
  }

  /**
   * @param purpose the purpose to set
   */
  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  /**
   * @return the feesCreatedDate
   */
  public String getFeesCreatedDate() {
    return feesCreatedDate;
  }

  /**
   * @param feesCreatedDate the feesCreatedDate to set
   */
  public void setFeesCreatedDate(String feesCreatedDate) {
    this.feesCreatedDate = feesCreatedDate;
  }
  
 
  

}
