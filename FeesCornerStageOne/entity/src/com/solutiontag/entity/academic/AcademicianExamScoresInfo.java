/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 30, 2015                        TODO

 */
package com.solutiontag.entity.academic;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.cache.annotation.Cacheable;
import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;

@Entity
@Cacheable
@Table(name="academicianexamscoresinfo")
public class AcademicianExamScoresInfo extends ApplicationPrimaryClass implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="examscoreinfoid")
  private Integer examScoreInfoId;
  
  @Column(name="school_academicYear")
  private String academicYear;
  
  @Column(name="examid")
  private Integer examId;
  
  @Column(name="subjectid")
  private Integer subjectId;
  
  @Column(name="subjectname")
  private String subjectName;
  
  @Column(name="markscored")
  private float markScored;
  
  @Column(name="marksOutOf")
  private int marksOutOf;
  
  @ManyToOne(cascade=CascadeType.PERSIST)
  @JoinColumn(name="academicianid")
  private AcademicianInfo academicianInfo;

  /**
   * @return the examScoreInfoId
   */
  public Integer getExamScoreInfoId() {
    return examScoreInfoId;
  }

  /**
   * @param examScoreInfoId the examScoreInfoId to set
   */
  public void setExamScoreInfoId(Integer examScoreInfoId) {
    this.examScoreInfoId = examScoreInfoId;
  }

  /**
   * @return the examId
   */
  public Integer getExamId() {
    return examId;
  }

  /**
   * @param examId the examId to set
   */
  public void setExamId(Integer examId) {
    this.examId = examId;
  }

  /**
   * @return the subjectId
   */
  public Integer getSubjectId() {
    return subjectId;
  }

  /**
   * @param subjectId the subjectId to set
   */
  public void setSubjectId(Integer subjectId) {
    this.subjectId = subjectId;
  }

  /**
   * @return the subjectName
   */
  public String getSubjectName() {
    return subjectName;
  }

  /**
   * @param subjectName the subjectName to set
   */
  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  /**
   * @return the markScored
   */
  public float getMarkScored() {
    return markScored;
  }

  /**
   * @param markScored the markScored to set
   */
  public void setMarkScored(float markScored) {
    this.markScored = markScored;
  }

  /**
   * @return the marksOutOf
   */
  public int getMarksOutOf() {
    return marksOutOf;
  }

  /**
   * @param marksOutOf the marksOutOf to set
   */
  public void setMarksOutOf(int marksOutOf) {
    this.marksOutOf = marksOutOf;
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
   * @return the academicYear
   */
  public String getAcademicYear() {
    return academicYear;
  }

  /**
   * @param academicYear the academicYear to set
   */
  public void setAcademicYear(String academicYear) {
    this.academicYear = academicYear;
  }
  
  
  

}
