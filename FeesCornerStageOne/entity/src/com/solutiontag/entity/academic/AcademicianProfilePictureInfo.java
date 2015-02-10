/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 4, 2015                        TODO

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
@Table(name="academicianprofilepicutureinfo")
@Cacheable
public class AcademicianProfilePictureInfo extends ApplicationPrimaryClass implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name="acdemicianid")
  private Integer academicianId;
  
  @Column(name="profilepicturename")
  private String profilePictureName;
  
  @Column(name="profilepicturesize")
  private String profilePictureSize;
  
  @Column(name="profilepicturechangeddate")
  private Date profilepictureChangedDate;
  
  @Column(name="profilepicturelocation")
  private String profilepicturelocation;
  
  @Column(name="iscurrentpicture")
  private String isCurrentPicture;
  
  @ManyToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="academicianId")
  private AcademicianProfileInfo academicianProfileInfo;

  /**
   * @return the academicianId
   */
  public Integer getAcademicianId() {
    return academicianId;
  }

  /**
   * @param academicianId the academicianId to set
   */
  public void setAcademicianId(Integer academicianId) {
    this.academicianId = academicianId;
  }

  /**
   * @return the profilePictureName
   */
  public String getProfilePictureName() {
    return profilePictureName;
  }

  /**
   * @param profilePictureName the profilePictureName to set
   */
  public void setProfilePictureName(String profilePictureName) {
    this.profilePictureName = profilePictureName;
  }

  /**
   * @return the profilePictureSize
   */
  public String getProfilePictureSize() {
    return profilePictureSize;
  }

  /**
   * @param profilePictureSize the profilePictureSize to set
   */
  public void setProfilePictureSize(String profilePictureSize) {
    this.profilePictureSize = profilePictureSize;
  }

  /**
   * @return the profilepictureChangedDate
   */
  public Date getProfilepictureChangedDate() {
    return profilepictureChangedDate;
  }

  /**
   * @param profilepictureChangedDate the profilepictureChangedDate to set
   */
  public void setProfilepictureChangedDate(Date profilepictureChangedDate) {
    this.profilepictureChangedDate = profilepictureChangedDate;
  }

  /**
   * @return the profilepicturelocation
   */
  public String getProfilepicturelocation() {
    return profilepicturelocation;
  }

  /**
   * @param profilepicturelocation the profilepicturelocation to set
   */
  public void setProfilepicturelocation(String profilepicturelocation) {
    this.profilepicturelocation = profilepicturelocation;
  }

  /**
   * @return the isCurrentPicture
   */
  public String getIsCurrentPicture() {
    return isCurrentPicture;
  }

  /**
   * @param isCurrentPicture the isCurrentPicture to set
   */
  public void setIsCurrentPicture(String isCurrentPicture) {
    this.isCurrentPicture = isCurrentPicture;
  }

  /**
   * @return the academicianProfileInfo
   */
  public AcademicianProfileInfo getAcademicianProfileInfo() {
    return academicianProfileInfo;
  }

  /**
   * @param academicianProfileInfo the academicianProfileInfo to set
   */
  public void setAcademicianProfileInfo(AcademicianProfileInfo academicianProfileInfo) {
    this.academicianProfileInfo = academicianProfileInfo;
  }
  
  
  

}
