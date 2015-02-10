/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 31, 2015                        TODO

 */
package com.solutiontag.entity.academic;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.cache.annotation.Cacheable;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;

@Entity
@Cacheable
@Table(name="academicanfeespaidhistory")
public class FeesPaidProfile extends ApplicationPrimaryClass implements Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Column(name="feespaidprofileid")
  @Id
  private Integer feesPaidProfileId;
  
  @Column(name="feespaiddate")
  private Date feesPaidDate;
  
  @Column(name="feespaidamount")
  private float feesPaidAmount;
  
  @Column(name="feespaidby")
  private String feespaidBy;
  
  @Column(name="feespaymentmode")
  private String feesPaymentMode;/*Fess PaymentMode mean Cheque,DD,Cash,Online*/
  
  @ManyToOne(cascade=CascadeType.PERSIST)
  @JoinColumn(name="fessProfileId")
  private FeesProfile feesprofile;


  /**
   * @return the feesPaidProfileId
   */
  public Integer getFeesPaidProfileId() {
    return feesPaidProfileId;
  }


  /**
   * @param feesPaidProfileId the feesPaidProfileId to set
   */
  public void setFeesPaidProfileId(Integer feesPaidProfileId) {
    this.feesPaidProfileId = feesPaidProfileId;
  }


  /**
   * @return the feesPaidDate
   */
  public Date getFeesPaidDate() {
    return feesPaidDate;
  }


  /**
   * @param feesPaidDate the feesPaidDate to set
   */
  public void setFeesPaidDate(Date feesPaidDate) {
    this.feesPaidDate = feesPaidDate;
  }


  /**
   * @return the feesPaidAmount
   */
  public float getFeesPaidAmount() {
    return feesPaidAmount;
  }


  /**
   * @param feesPaidAmount the feesPaidAmount to set
   */
  public void setFeesPaidAmount(float feesPaidAmount) {
    this.feesPaidAmount = feesPaidAmount;
  }


  /**
   * @return the feespaidBy
   */
  public String getFeespaidBy() {
    return feespaidBy;
  }


  /**
   * @param feespaidBy the feespaidBy to set
   */
  public void setFeespaidBy(String feespaidBy) {
    this.feespaidBy = feespaidBy;
  }


  /**
   * @return the feesprofile
   */
  public FeesProfile getFeesprofile() {
    return feesprofile;
  }


  /**
   * @param feesprofile the feesprofile to set
   */
  public void setFeesprofile(FeesProfile feesprofile) {
    this.feesprofile = feesprofile;
  }

}
