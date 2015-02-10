/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 29, 2014                        TODO

 */
package com.solutiontag.entity.masterdata;

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

@Entity
@Cacheable
@Table(name="leavedefintion")
public class SchoolLeavesDefinition implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  public SchoolLeavesDefinition(){
    this.leaveId=hashCode();
    this.hashSetIndexId=hashCode();
  }

  @Id
  @Column(name="leavdid")
  private Integer leaveId;
  
  @ManyToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="masterdata_id")
  private SchoolMasterDataDefinition defForLeave;
  
  @Column(name="leave_data")
  private Date leaveDate;
  
  @Column(name="accountOf")
  private String accountOf;
  
  @Column(name="hashSetIndexId")
  private Integer hashSetIndexId;

  /**
   * @return the leaveId
   */
  public Integer getLeaveId() {
    return leaveId;
  }

  /**
   * @param leaveId the leaveId to set
   */
  public void setLeaveId(Integer leaveId) {
    this.leaveId = leaveId;
  }

  /**
   * @return the leaveDate
   */
  public Date getLeaveDate() {
    return leaveDate;
  }

  /**
   * @param leaveDate the leaveDate to set
   */
  public void setLeaveDate(Date leaveDate) {
    this.leaveDate = leaveDate;
  }

  /**
   * @return the accountOf
   */
  public String getAccountOf() {
    return accountOf;
  }

  /**
   * @param accountOf the accountOf to set
   */
  public void setAccountOf(String accountOf) {
    this.accountOf = accountOf;
  }

  /**
   * @return the defForLeave
   */
  public SchoolMasterDataDefinition getDefForLeave() {
    return defForLeave;
  }

  /**
   * @param defForLeave the defForLeave to set
   */
  public void setDefForLeave(SchoolMasterDataDefinition defForLeave) {
    this.defForLeave = defForLeave;
  }
  @Override
  public boolean equals(Object obj){
    SchoolLeavesDefinition schoolLeavesDefinition=(SchoolLeavesDefinition) obj;
    return getHashSetIndexId()==schoolLeavesDefinition.getHashSetIndexId();
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
