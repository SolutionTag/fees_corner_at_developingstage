/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 4, 2015                        TODO

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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.cache.annotation.Cacheable;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;

@Entity
@Table(name="academicianprofile")
@Cacheable
public class AcademicianProfileInfo  extends ApplicationPrimaryClass implements Serializable{
  
 /**
   * 
   */
private static final long serialVersionUID = 1L;

@Id
@Column(name="academicianid")
private Integer  academicianId;

@Column(name="academicianusername")
private String academicianUserName;
  
@Column(name="academicianemailaddress")
 private String EmailAddress;
  
@Column(name="academicianpassword")
 private String Password;
  
@Column(name="academiciangender")
 private String Gender;
  
 @Column(name="academicianDob")
 private Date DOB;    
  
 @Column(name="academicianlocation")
 private String Location;
 
 @Fetch(FetchMode.JOIN)
 @OneToMany(cascade=CascadeType.ALL,mappedBy="academicianProfileInfo",orphanRemoval=true)
 private Set<AcademicianProfilePictureInfo> profilePictureInfo=new HashSet<AcademicianProfilePictureInfo>();
 
 @MapsId
 @OneToOne(cascade=CascadeType.ALL, mappedBy="academicianProfileInfo")
 @JoinColumn(name="academicianid",referencedColumnName="academicianid")
 private AcademicianInfo acdemicianInfo;

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
 * @return the academicianUserName
 */
public String getAcademicianUserName() {
  return academicianUserName;
}

/**
 * @param academicianUserName the academicianUserName to set
 */
public void setAcademicianUserName(String academicianUserName) {
  this.academicianUserName = academicianUserName;
}

/**
 * @return the emailAddress
 */
public String getEmailAddress() {
  return EmailAddress;
}

/**
 * @param emailAddress the emailAddress to set
 */
public void setEmailAddress(String emailAddress) {
  EmailAddress = emailAddress;
}

/**
 * @return the password
 */
public String getPassword() {
  return Password;
}

/**
 * @param password the password to set
 */
public void setPassword(String password) {
  Password = password;
}

/**
 * @return the gender
 */
public String getGender() {
  return Gender;
}

/**
 * @param gender the gender to set
 */
public void setGender(String gender) {
  Gender = gender;
}

/**
 * @return the dOB
 */
public Date getDOB() {
  return DOB;
}

/**
 * @param dOB the dOB to set
 */
public void setDOB(Date dOB) {
  DOB = dOB;
}

/**
 * @return the location
 */
public String getLocation() {
  return Location;
}

/**
 * @param location the location to set
 */
public void setLocation(String location) {
  Location = location;
}

/**
 * @return the profilePictureInfo
 */
public Set<AcademicianProfilePictureInfo> getProfilePictureInfo() {
  return profilePictureInfo;
}

/**
 * @param profilePictureInfo the profilePictureInfo to set
 */
public void setProfilePictureInfo(Set<AcademicianProfilePictureInfo> profilePictureInfo) {
  this.profilePictureInfo = profilePictureInfo;
}

/**
 * @return the acdemicianInfo
 */
public AcademicianInfo getAcdemicianInfo() {
  return acdemicianInfo;
}

/**
 * @param acdemicianInfo the acdemicianInfo to set
 */
public void setAcdemicianInfo(AcademicianInfo acdemicianInfo) {
  this.acdemicianInfo = acdemicianInfo;
}

}
