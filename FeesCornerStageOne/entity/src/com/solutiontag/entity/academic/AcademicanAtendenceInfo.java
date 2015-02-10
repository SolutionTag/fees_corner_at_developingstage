/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 31, 2015                        TODO

 */
package com.solutiontag.entity.academic;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Table(name="academicanatendenceinfo")
public class AcademicanAtendenceInfo {
  
  @Id
  @Column(name="academicianId")
  private Integer academicianId;
  
  @Column(name="attnedenceDate")
  private Date attnedenceDate;
  
  @Column(name="isPresent")
  private boolean isPresent;

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
   * @return the attnedenceDate
   */
  public Date getAttnedenceDate() {
    return attnedenceDate;
  }

  /**
   * @param attnedenceDate the attnedenceDate to set
   */
  public void setAttnedenceDate(Date attnedenceDate) {
    this.attnedenceDate = attnedenceDate;
  }

  /**
   * @return the isPresent
   */
  public boolean isPresent() {
    return isPresent;
  }

  /**
   * @param isPresent the isPresent to set
   */
  public void setPresent(boolean isPresent) {
    this.isPresent = isPresent;
  }

}
