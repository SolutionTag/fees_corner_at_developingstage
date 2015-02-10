/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 10, 2015                        TODO

 */
package com.solutiontag.entity.masterdata;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Table(name="admincredentials")
public class AdminCredentials implements Serializable {
  
  public AdminCredentials(){
    this.hashSetIndexId=hashCode();
  }
  @Id
  @Column(name="adminregid")
  private Integer adminRegId;
  
  @Column(name="hashsetindexid")
  private Integer hashSetIndexId;
  
  @Column(name="adminloginusername")
  private String  adminLoginUserName;
  
  @Column(name="adminloginmailid")
  private String  adminLoginMailId;
  
  @Column(name="adminloginpassword")
  private String  adminLoginPassword;
  
  @Column(name="adminfullname")
  private String  adminFullName;
  
  @Column(name="adminprofilepicture")
  private String  adminProfilePicture;
  
  @Column(name="lastlogintime")
  private Timestamp lastLoginTime;
  
  @Column(name="lastlogouttime")
  private Timestamp lastLogoutTime;

  /**
   * @return the adminRegId
   */
  public Integer getAdminRegId() {
    return adminRegId;
  }

  /**
   * @param adminRegId the adminRegId to set
   */
  public void setAdminRegId(Integer adminRegId) {
    this.adminRegId = adminRegId;
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

  /**
   * @return the adminLoginUserName
   */
  public String getAdminLoginUserName() {
    return adminLoginUserName;
  }

  /**
   * @param adminLoginUserName the adminLoginUserName to set
   */
  public void setAdminLoginUserName(String adminLoginUserName) {
    this.adminLoginUserName = adminLoginUserName;
  }

  /**
   * @return the adminLoginMailId
   */
  public String getAdminLoginMailId() {
    return adminLoginMailId;
  }

  /**
   * @param adminLoginMailId the adminLoginMailId to set
   */
  public void setAdminLoginMailId(String adminLoginMailId) {
    this.adminLoginMailId = adminLoginMailId;
  }

  /**
   * @return the adminLoginPassword
   */
  public String getAdminLoginPassword() {
    return adminLoginPassword;
  }

  /**
   * @param adminLoginPassword the adminLoginPassword to set
   */
  public void setAdminLoginPassword(String adminLoginPassword) {
    this.adminLoginPassword = adminLoginPassword;
  }

  /**
   * @return the adminFullName
   */
  public String getAdminFullName() {
    return adminFullName;
  }

  /**
   * @param adminFullName the adminFullName to set
   */
  public void setAdminFullName(String adminFullName) {
    this.adminFullName = adminFullName;
  }

  /**
   * @return the adminProfilePicture
   */
  public String getAdminProfilePicture() {
    return adminProfilePicture;
  }

  /**
   * @param adminProfilePicture the adminProfilePicture to set
   */
  public void setAdminProfilePicture(String adminProfilePicture) {
    this.adminProfilePicture = adminProfilePicture;
  }

  /**
   * @return the lastLoginTime
   */
  public Timestamp getLastLoginTime() {
    return lastLoginTime;
  }

  /**
   * @param lastLoginTime the lastLoginTime to set
   */
  public void setLastLoginTime(Timestamp lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  /**
   * @return the lastLogoutTime
   */
  public Timestamp getLastLogoutTime() {
    return lastLogoutTime;
  }

  /**
   * @param lastLogoutTime the lastLogoutTime to set
   */
  public void setLastLogoutTime(Timestamp lastLogoutTime) {
    this.lastLogoutTime = lastLogoutTime;
  }
   
  public boolean equals(Object obj){
    AdminCredentials adminCredentials=(AdminCredentials) obj;
    return getHashSetIndexId()==adminCredentials.getHashSetIndexId();
  }


}
