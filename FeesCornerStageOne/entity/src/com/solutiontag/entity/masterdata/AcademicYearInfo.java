/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 30, 2015                        TODO

 */
package com.solutiontag.entity.masterdata;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.cache.annotation.Cacheable;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;

@Entity
@Cacheable
@Table(name="academicyearinfo")
public class AcademicYearInfo extends ApplicationPrimaryClass implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  
  @Id
  @Column(name="academicyearid")
  private Integer academicYearId;
  
  @Column(name="academicyear")
  private Integer academicYear;
  
  @Column(name="academicyearcreateddate")
  private Date academicYearCreatedDate;
  
  @Column(name="academicyearstartingdate")
  private Date academicYearStartingDate;
  
  @Column(name="academicyearendingdate")
  private Date academicYearEndingDate;
  
  @Column(name="academicyearworkingdays")
  private Integer academicYearWorkingDays;
  /**
   * @return the academicYearId
   */
  public Integer getAcademicYearId() {
    return academicYearId;
  }
  /**
   * @param academicYearId the academicYearId to set
   */
  public void setAcademicYearId(Integer academicYearId) {
    this.academicYearId = academicYearId;
  }
  /**
   * @return the academicYear
   */
  public Integer getAcademicYear() {
    return academicYear;
  }
  /**
   * @param academicYear the academicYear to set
   */
  public void setAcademicYear(Integer academicYear) {
    this.academicYear = academicYear;
  }
  /**
   * @return the academicYearCreatedDate
   */
  public Date getAcademicYearCreatedDate() {
    return academicYearCreatedDate;
  }
  /**
   * @param academicYearCreatedDate the academicYearCreatedDate to set
   */
  public void setAcademicYearCreatedDate(Date academicYearCreatedDate) {
    this.academicYearCreatedDate = academicYearCreatedDate;
  }
  /**
   * @return the academicYearStartingDate
   */
  public Date getAcademicYearStartingDate() {
    return academicYearStartingDate;
  }
  /**
   * @param academicYearStartingDate the academicYearStartingDate to set
   */
  public void setAcademicYearStartingDate(Date academicYearStartingDate) {
    this.academicYearStartingDate = academicYearStartingDate;
  }
  /**
   * @return the academicYearEndingDate
   */
  public Date getAcademicYearEndingDate() {
    return academicYearEndingDate;
  }
  /**
   * @param academicYearEndingDate the academicYearEndingDate to set
   */
  public void setAcademicYearEndingDate(Date academicYearEndingDate) {
    this.academicYearEndingDate = academicYearEndingDate;
  }
  /**
   * @return the academicYearWorkingDays
   */
  public Integer getAcademicYearWorkingDays() {
    return academicYearWorkingDays;
  }
  /**
   * @param academicYearWorkingDays the academicYearWorkingDays to set
   */
  public void setAcademicYearWorkingDays(Integer academicYearWorkingDays) {
    this.academicYearWorkingDays = academicYearWorkingDays;
  }


}
