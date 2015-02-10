/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 1, 2015                        TODO

 */
package com.solutiontag.entity.academic;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Qualifier;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;
import com.solutiontag.entity.masterdata.SchoolCollection;

@Entity
@Table(name="academicanstandardinfo")
@Cacheable
public class AcademicianStandardInfo extends ApplicationPrimaryClass implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GenericGenerator(name = "generator", strategy = "foreign", parameters =@Parameter(value="acdemicianInfo",name="property") )
 
  @GeneratedValue(generator = "generator")
  @Column(name="academicianid")
  private Integer academicianId;
  
  @Column(name="academicianstandardid")
  private Integer academicanStandardId;
  
  @Column(name="academicanstandardname")
  private String academicanStandrdName;
  
  @Column(name="academiciansection")
  private String academicianSection;
  
  @Column(name="academicianSectionId")
  private Integer academicianSectionId;
  
  @Column(name="academicancurrentyear")
  private Date academicyear;
  
/*  @MapsId
  @OneToOne(cascade=CascadeType.ALL, mappedBy="standardInfo")
  @JoinColumn(name="academicianid",referencedColumnName="academicianid")
  private AcademicianInfo acdemicianInfo;*/
  
  @Column(name="academiciangender")
  private String academicianGender;

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
   * @return the academicanStandardId
   */
  public Integer getAcademicanStandardId() {
    return academicanStandardId;
  }

  /**
   * @param academicanStandardId the academicanStandardId to set
   */
  public void setAcademicanStandardId(Integer academicanStandardId) {
    this.academicanStandardId = academicanStandardId;
  }

  /**
   * @return the academicanStandrdName
   */
  public String getAcademicanStandrdName() {
    return academicanStandrdName;
  }

  /**
   * @param academicanStandrdName the academicanStandrdName to set
   */
  public void setAcademicanStandrdName(String academicanStandrdName) {
    this.academicanStandrdName = academicanStandrdName;
  }

  /**
   * @return the academicyear
   */
  public Date getAcademicyear() {
    return academicyear;
  }

  /**
   * @param academicyear the academicyear to set
   */
  public void setAcademicyear(Date academicyear) {
    this.academicyear = academicyear;
  }


  /**
   * @return the serialversionuid
   */
  public static long getSerialversionuid() {
    return serialVersionUID;
  }



  /**
   * @return the academicianSection
   */
  public String getAcademicianSection() {
    return academicianSection;
  }

  /**
   * @param academicianSection the academicianSection to set
   */
  public void setAcademicianSection(String academicianSection) {
    this.academicianSection = academicianSection;
  }

  /**
   * @return the academicianSectionId
   */
  public Integer getAcademicianSectionId() {
    return academicianSectionId;
  }

  /**
   * @param academicianSectionId the academicianSectionId to set
   */
  public void setAcademicianSectionId(Integer academicianSectionId) {
    this.academicianSectionId = academicianSectionId;
  }
 public String getAcademicianGender() {
    return academicianGender;
  }


  public void setAcademicianGender(String academicianGender) {
    this.academicianGender = academicianGender;
  }
  
  

}
