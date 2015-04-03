/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 13, 2015                        TODO

 */
package com.solutiontag.entity.academic;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Table(name="academicianlastschooldetails")
public class AcademicianPreviousSchoolDetails implements Serializable {
 
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="studentid")
  private Integer studentId;
  
  @Column(name="laststudiedschoolname")
  private String lastStudiedSchoolName;
  
  @Column(name="standardpassed")
  private String standardPassed;
  
  @Column(name="studiedmedium")
  private String studiedMedium;
  
  @Column(name="lastschoolstudiedfrom")
  private Date lastSchoolStudiedFrom;
  
  @Column(name="lastSchoolstudiedto")
  private Date lastSchoolStudiedTo;
  
  @Column(name="reasonforleaving")
  private String reasonForLeaving;
  
  @MapsId
  @OneToOne(cascade=CascadeType.ALL, mappedBy="academicianPreviousSchoolDetails")
  @JoinColumn(name = "studentid") 
  @JsonBackReference
  private AcademicianInfo academicianInfo;
  
  
  @Column(name="percentageofmarksinlastschool")
  private Integer percentageOfMarksInLastSchool;

  /**
   * @return the studentId
   */
  public Integer getStudentId() {
    return studentId;
  }

  /**
   * @param studentId the studentId to set
   */
  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  /**
   * @return the lastStudiedSchoolName
   */
  public String getLastStudiedSchoolName() {
    return lastStudiedSchoolName;
  }

  /**
   * @param lastStudiedSchoolName the lastStudiedSchoolName to set
   */
  public void setLastStudiedSchoolName(String lastStudiedSchoolName) {
    this.lastStudiedSchoolName = lastStudiedSchoolName;
  }

  /**
   * @return the standardPassed
   */
  public String getStandardPassed() {
    return standardPassed;
  }

  /**
   * @param standardPassed the standardPassed to set
   */
  public void setStandardPassed(String standardPassed) {
    this.standardPassed = standardPassed;
  }

  /**
   * @return the studiedMedium
   */
  public String getStudiedMedium() {
    return studiedMedium;
  }

  /**
   * @param studiedMedium the studiedMedium to set
   */
  public void setStudiedMedium(String studiedMedium) {
    this.studiedMedium = studiedMedium;
  }

  /**
   * @return the lastSchoolStudiedFrom
   */
  public Date getLastSchoolStudiedFrom() {
    return lastSchoolStudiedFrom;
  }

  /**
   * @param lastSchoolStudiedFrom the lastSchoolStudiedFrom to set
   */
  public void setLastSchoolStudiedFrom(Date lastSchoolStudiedFrom) {
    this.lastSchoolStudiedFrom = lastSchoolStudiedFrom;
  }

  /**
   * @return the lastSchoolStudiedTo
   */
  public Date getLastSchoolStudiedTo() {
    return lastSchoolStudiedTo;
  }

  /**
   * @param lastSchoolStudiedTo the lastSchoolStudiedTo to set
   */
  public void setLastSchoolStudiedTo(Date lastSchoolStudiedTo) {
    this.lastSchoolStudiedTo = lastSchoolStudiedTo;
  }

  /**
   * @return the reasonForLeaving
   */
  public String getReasonForLeaving() {
    return reasonForLeaving;
  }

  /**
   * @param reasonForLeaving the reasonForLeaving to set
   */
  public void setReasonForLeaving(String reasonForLeaving) {
    this.reasonForLeaving = reasonForLeaving;
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
   * @return the percentageOfMarksInLastSchool
   */
  public Integer getPercentageOfMarksInLastSchool() {
    return percentageOfMarksInLastSchool;
  }

  /**
   * @param percentageOfMarksInLastSchool the percentageOfMarksInLastSchool to set
   */
  public void setPercentageOfMarksInLastSchool(Integer percentageOfMarksInLastSchool) {
    this.percentageOfMarksInLastSchool = percentageOfMarksInLastSchool;
  }
  
  
  
  
  

}
