/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 26, 2014                        TODO

 */
package com.solutiontag.entity.masterdata;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Table(name="superadmin")
public class SuperAdmin implements Serializable{
 
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  private Integer superadmin_id;
  
  @Column(name="commonId")                                                                            
  private Integer commonId;
  
  @Column(name="superadmin_Name")
  private String superAdminName;
  
  @Column(name="superadmin_EmailId")
  private String superAdminEmailId;
  
  @Column(name="superadmin_Password")
  private String superAdminPassword;
  
  @Column(name="superadmin_ProfilePicture")
  private String superAdminProfilePicture;
  
  @OneToOne(cascade=CascadeType.ALL, mappedBy="superAdmin")
  private ManagementInfo managementInfo;
  
 
  
  

  /**
   * @return the superadmin_id
   */
  public Integer getSuperadmin_id() {
    return superadmin_id;
  }

  /**
   * @return the superAdminName
   */
  public String getSuperAdminName() {
    return superAdminName;
  }

  /**
   * @return the superAdminEmailId
   */
  public String getSuperAdminEmailId() {
    return superAdminEmailId;
  }

  /**
   * @return the superAdminPassword
   */
  public String getSuperAdminPassword() {
    return superAdminPassword;
  }

  /**
   * @return the superAdminProfilePicture
   */
  public String getSuperAdminProfilePicture() {
    return superAdminProfilePicture;
  }

  /**
   * @return the managementInfo
   */
  public ManagementInfo getManagementInfo() {
    return managementInfo;
  }

  /**
   * @param superadmin_id the superadmin_id to set
   */
  public void setSuperadmin_id(Integer superadmin_id) {
    this.superadmin_id = superadmin_id;
  }

  /**
   * @param superAdminName the superAdminName to set
   */
  public void setSuperAdminName(String superAdminName) {
    this.superAdminName = superAdminName;
  }

  /**
   * @param superAdminEmailId the superAdminEmailId to set
   */
  public void setSuperAdminEmailId(String superAdminEmailId) {
    this.superAdminEmailId = superAdminEmailId;
  }

  /**
   * @param superAdminPassword the superAdminPassword to set
   */
  public void setSuperAdminPassword(String superAdminPassword) {
    this.superAdminPassword = superAdminPassword;
  }

  /**
   * @param superAdminProfilePicture the superAdminProfilePicture to set
   */
  public void setSuperAdminProfilePicture(String superAdminProfilePicture) {
    this.superAdminProfilePicture = superAdminProfilePicture;
  }

  /**
   * @param managementInfo the managementInfo to set
   */
  public void setManagementInfo(ManagementInfo managementInfo) {
    this.managementInfo = managementInfo;
  }
  
   
}
