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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Table(name = "managementinfo")
public class ManagementInfo implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(generator="person_generator")
  @GenericGenerator(name="person_generator", strategy = "com.feescorner.serverstartup.dbUtils.ApplicationUtills",parameters=@Parameter(name="property", value="superAdmin"))
  @Column(name = "management_Id",unique=true,nullable=false)
  private Integer managementId;
  
  @Column(name = "management_Name")
  private String managementName;
  
  @Column(name = "management_Location")
  private String managementLocation;
  
  @Column(name = "correspondent_Name")
  private String correspondentName;
  
  @Column(name = "correspondent_Id")
  private Integer correspondentId;
  
  @Column(name = "correspondent_EmailId")
  private String correspondentEmailId;
  
  @OneToOne(cascade=CascadeType.ALL)
  @PrimaryKeyJoinColumn(name="management_Id",referencedColumnName="commonId")
  private SuperAdmin superAdmin;

  /**
   * @return the managementId
   */
  public Integer getManagementId() {
    return managementId;
  }

  /**
   * @return the managementName
   */
  public String getManagementName() {
    return managementName;
  }

  /**
   * @return the managementLocation
   */
  public String getManagementLocation() {
    return managementLocation;
  }

  /**
   * @return the correspondentName
   */
  public String getCorrespondentName() {
    return correspondentName;
  }

  /**
   * @return the correspondentId
   */
  public Integer getCorrespondentId() {
    return correspondentId;
  }

  /**
   * @return the correspondentEmailId
   */
  public String getCorrespondentEmailId() {
    return correspondentEmailId;
  }

  /**
   * @return the superAdmin
   */
  public SuperAdmin getSuperAdmin() {
    return superAdmin;
  }

  /**
   * @param managementId the managementId to set
   */
  public void setManagementId(Integer managementId) {
    this.managementId = managementId;
  }

  /**
   * @param managementName the managementName to set
   */
  public void setManagementName(String managementName) {
    this.managementName = managementName;
  }

  /**
   * @param managementLocation the managementLocation to set
   */
  public void setManagementLocation(String managementLocation) {
    this.managementLocation = managementLocation;
  }

  /**
   * @param correspondentName the correspondentName to set
   */
  public void setCorrespondentName(String correspondentName) {
    this.correspondentName = correspondentName;
  }

  /**
   * @param correspondentId the correspondentId to set
   */
  public void setCorrespondentId(Integer correspondentId) {
    this.correspondentId = correspondentId;
  }

  /**
   * @param correspondentEmailId the correspondentEmailId to set
   */
  public void setCorrespondentEmailId(String correspondentEmailId) {
    this.correspondentEmailId = correspondentEmailId;
  }

  /**
   * @param superAdmin the superAdmin to set
   */
  public void setSuperAdmin(SuperAdmin superAdmin) {
    this.superAdmin = superAdmin;
  }



}
