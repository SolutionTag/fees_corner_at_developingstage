/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 5, 2015                        TODO

 */
package com.solutiontag.entity.academic;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.springframework.cache.annotation.Cacheable;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;
@Entity
@Table(name="academicianguardianinfo")
@Cacheable
public class AcademicianGuardianInfo extends ApplicationPrimaryClass implements Serializable {

/**
   * 
   */
  private static final long serialVersionUID = 1L;

@Id
@Column(name="academicianid")
private Integer academicianId;
@Column(name="guardianFirstName")
private String guardianFirstName;
@Column(name="guardianLastName")
private String guardianLastName;
@Column(name="guardianOccupation")
private String guardianOccupation;
@Column(name="guardianDob")
private Date guardianDob;
@Column(name="guardianIncome")
private Float guardianIncome;
@MapsId
@OneToOne(cascade=CascadeType.ALL, mappedBy="academicianGurdianInfo")
@JoinColumn(name = "academicianid")
@JsonBackReference
private AcademicianInfo academicianInfo;

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
 * @return the guardianFirstName
 */
public String getGuardianFirstName() {
  return guardianFirstName;
}

/**
 * @param guardianFirstName the guardianFirstName to set
 */
public void setGuardianFirstName(String guardianFirstName) {
  this.guardianFirstName = guardianFirstName;
}

/**
 * @return the guardianLastName
 */
public String getGuardianLastName() {
  return guardianLastName;
}

/**
 * @param guardianLastName the guardianLastName to set
 */
public void setGuardianLastName(String guardianLastName) {
  this.guardianLastName = guardianLastName;
}

/**
 * @return the guardianOccupation
 */
public String getGuardianOccupation() {
  return guardianOccupation;
}

/**
 * @param guardianOccupation the guardianOccupation to set
 */
public void setGuardianOccupation(String guardianOccupation) {
  this.guardianOccupation = guardianOccupation;
}

/**
 * @return the guardianDob
 */
public Date getGuardianDob() {
  return guardianDob;
}

/**
 * @param guardianDob the guardianDob to set
 */
public void setGuardianDob(Date guardianDob) {
  this.guardianDob = guardianDob;
}

/**
 * @return the guardianIncome
 */
public Float getGuardianIncome() {
  return guardianIncome;
}

/**
 * @param guardianIncome the guardianIncome to set
 */
public void setGuardianIncome(Float guardianIncome) {
  this.guardianIncome = guardianIncome;
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




}
