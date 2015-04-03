/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 31, 2015                        TODO

 */
package com.solutiontag.entity.academic;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.cache.annotation.Cacheable;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;

@Entity
@Cacheable
@Table(name="academicanfeesprofile")
public class FeesProfile extends ApplicationPrimaryClass implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  
  @Id
  @Column(name="fessprofileid")
  private Integer fessProfileId;
  
  @Column(name="assignedfeesid")
  private Integer assignedFeesId;
  
  @Column(name="assignedfeesname")
  private String assignedFeesName;
  
  @Column(name="assignedfeesamount")
  private float assignedFeesAmount;
  
  @Column(name="assignedfeesduedate")
  private Date assignedFeesDueDate;
  
  @Column(name="feesassigneddate")
  private Date feesAssignedDate;
  
  @Column(name="assignedfeesfineAmount")
  private Float assignedFeesFineAmount;
  
  @ManyToOne(cascade=CascadeType.PERSIST)
  @JoinColumn(name="academicianid")
  private AcademicianInfo academicianInfo;
  

  @OneToMany(cascade=CascadeType.ALL,mappedBy="feesprofile") 
  @Fetch(FetchMode.JOIN)
  private Set<FeesPaidProfile> academicanFeesPaidProfile=new HashSet<FeesPaidProfile>();


  /**
   * @return the fessProfileId
   */
  public Integer getFessProfileId() {
    return fessProfileId;
  }


  /**
   * @param fessProfileId the fessProfileId to set
   */
  public void setFessProfileId(Integer fessProfileId) {
    this.fessProfileId = fessProfileId;
  }


  /**
   * @return the assignedFeesId
   */
  public Integer getAssignedFeesId() {
    return assignedFeesId;
  }


  /**
   * @param assignedFeesId the assignedFeesId to set
   */
  public void setAssignedFeesId(Integer assignedFeesId) {
    this.assignedFeesId = assignedFeesId;
  }


  /**
   * @return the assignedFeesName
   */
  public String getAssignedFeesName() {
    return assignedFeesName;
  }


  /**
   * @param assignedFeesName the assignedFeesName to set
   */
  public void setAssignedFeesName(String assignedFeesName) {
    this.assignedFeesName = assignedFeesName;
  }


  /**
   * @return the assignedFeesAmount
   */
  public float getAssignedFeesAmount() {
    return assignedFeesAmount;
  }


  /**
   * @param assignedFeesAmount the assignedFeesAmount to set
   */
  public void setAssignedFeesAmount(float assignedFeesAmount) {
    this.assignedFeesAmount = assignedFeesAmount;
  }


  /**
   * @return the assignedFeesDueDate
   */
  public Date getAssignedFeesDueDate() {
    return assignedFeesDueDate;
  }


  /**
   * @param assignedFeesDueDate the assignedFeesDueDate to set
   */
  public void setAssignedFeesDueDate(Date assignedFeesDueDate) {
    this.assignedFeesDueDate = assignedFeesDueDate;
  }


  /**
   * @return the feesAssignedDate
   */
  public Date getFeesAssignedDate() {
    return feesAssignedDate;
  }


  /**
   * @param feesAssignedDate the feesAssignedDate to set
   */
  public void setFeesAssignedDate(Date feesAssignedDate) {
    this.feesAssignedDate = feesAssignedDate;
  }

  /**
   * @return the academicianInfo
   */
  public AcademicianInfo getAcademicianInfo() {
    return academicianInfo;
  }


  /**
   * @param academicianInfo the academicianInfo to set
   */
  public void setAcademicianInfo(AcademicianInfo academicianInfo) {
    this.academicianInfo = academicianInfo;
  }


  /**
   * @return the academicanFeesPaidProfile
   */
  public Set<FeesPaidProfile> getAcademicanFeesPaidProfile() {
    return academicanFeesPaidProfile;
  }


  /**
   * @param academicanFeesPaidProfile the academicanFeesPaidProfile to set
   */
  public void setAcademicanFeesPaidProfile(Set<FeesPaidProfile> academicanFeesPaidProfile) {
    this.academicanFeesPaidProfile = academicanFeesPaidProfile;
  }


  /**
   * @return the assignedFeesFineAmount
   */
  public Float getAssignedFeesFineAmount() {
    return assignedFeesFineAmount;
  }


  /**
   * @param assignedFeesFineAmount the assignedFeesFineAmount to set
   */
  public void setAssignedFeesFineAmount(Float assignedFeesFineAmount) {
    this.assignedFeesFineAmount = assignedFeesFineAmount;
  }
  
 
  
   
  
  
  
  

}
