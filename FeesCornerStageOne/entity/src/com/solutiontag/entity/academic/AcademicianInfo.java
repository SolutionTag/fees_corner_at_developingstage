/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 11, 2015                        TODO

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.cache.annotation.Cacheable;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;
import com.solutiontag.entity.masterdata.SchoolCollection;
import com.solutiontag.entity.masterdata.SchoolMasterDataDefinition;



@Entity
@Cacheable
@Table(name="academicaininfo")
public class AcademicianInfo extends ApplicationPrimaryClass implements Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public AcademicianInfo() {
    this.academicianId=hashCode();
    this.academicianAddress=new AcademicianAddress();
    this.academicianAddress.setAcademicianInfo(this);
    this.setAcademicianAddress(academicianAddress);
    
    this.academicianPreviousSchoolDetails=new AcademicianPreviousSchoolDetails();
    this.academicianPreviousSchoolDetails.setAcademicianInfo(this);
    this.setAcademicianPreviousSchoolDetails(academicianPreviousSchoolDetails);
  }

  @Id
  /*@GenericGenerator(name="student_generator", strategy = "com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  @GeneratedValue(generator="student_generator")*/
  @Column(name="academicianid")
  private Integer academicianId;
  
/*  @Column(name="schoolid")
  private String schoolId;*/
  
 /*schoolid+joinedyear+standardid+rollnumber=Admission Number*/
  @Column(name="academicianAdmissionNumber")
  private Integer academicianAdmissionNumber;
  
  @Column(name="academicianAdmissionDate")
  private Date academicianAdmissionDate;
  
  @Column(name="academicianname")
  private String academicianName;
  
  @Column(name="academicianfirstname")
  private String academicianFirstName;
  
  @Column(name="academicianLastname")
  private String academicianLastName;
  
  @Column(name="academiciangender")
  private String academicianGender;
  
  @Column(name="academiciandob")
  private Date academicianDob;
  
  @Column(name="academicianphoto")
  private String academicianPhoto;
  
  @Column(name="academicianbloodgroup")
  private String academicianBloodGroup;
  
  @Column(name="academiciancategory")
  private String academicianCategory;
  
  @Column(name="academicianreligion")
  private String academicianReligion;
  
  @Column(name="academicianparentname")
  private String academicianParentName;
  
  @Column(name="academicianhassibling")
  private boolean academicianHasSibling;
  
  @Column(name="academicannationality")
  private String academicianNationality;
  
  @Column(name="academicianhometown")
  private String academicianFrom;
  
  @Column(name="academiciantravelmethod")
  private String academicianTravelmMthod;
  
  @Column(name="academicianstandardid")
  private Integer academicanStandardId;
  
  @Column(name="academicanstandardname")
  private String academicanStandrdName;
  
  @Column(name="academiciansection")
  private String academicianSection;
  
  @Column(name="academicianSectionId")
  private Integer academicianSectionId;
  
  @Column(name="isnewadmission")
  private boolean isNewAdmission;
  
  @OneToOne(cascade=CascadeType.ALL)
  @PrimaryKeyJoinColumn
  @JsonManagedReference
  private AcademicianPreviousSchoolDetails academicianPreviousSchoolDetails;
  
  @OneToOne(cascade=CascadeType.ALL)
  @PrimaryKeyJoinColumn
  @JsonManagedReference
  private AcademicianAddress academicianAddress;
  
  @OneToOne(cascade=CascadeType.ALL)
  @PrimaryKeyJoinColumn
  @JsonManagedReference
  private AcademicianGuardianInfo academicianGurdianInfo;
  
  @OneToMany(cascade=CascadeType.ALL,mappedBy="academicianInfo")
  @Fetch(FetchMode.JOIN)
  private Set<AcademicianExamScoresInfo> academicianExamScoresInfo=new HashSet<AcademicianExamScoresInfo>();


  @OneToMany(cascade=CascadeType.ALL,mappedBy="academicianInfo") 
  @Fetch(FetchMode.JOIN)
  private Set<FeesProfile> academicanFeesProfile=new HashSet<FeesProfile>();
  
  @ManyToOne(cascade=CascadeType.PERSIST)
  @JoinColumn(name = "schoolid")
  private SchoolCollection schoolCollection;
  
  @OneToOne(cascade=CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private AcademicianProfileInfo academicianProfileInfo;
  
/*  @OneToOne(cascade=CascadeType.ALL)
  @PrimaryKeyJoinColumn(name="academicianid",referencedColumnName="academicianid")
  private AcademicianStandardInfo standardInfo;*/

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
   * @return the academicianAdmissionNumber
   */
  public Integer getAcademicianAdmissionNumber() {
    return academicianAdmissionNumber;
  }

  /**
   * @param academicianAdmissionNumber the academicianAdmissionNumber to set
   */
  public void setAcademicianAdmissionNumber(Integer academicianAdmissionNumber) {
    this.academicianAdmissionNumber = academicianAdmissionNumber;
  }

  /**
   * @return the academicianName
   */
  public String getAcademicianName() {
    return academicianName;
  }

  /**
   * @param academicianName the academicianName to set
   */
  public void setAcademicianName(String academicianName) {
    this.academicianName = academicianName;
  }

  /**
   * @return the academicianFirstName
   */
  public String getAcademicianFirstName() {
    return academicianFirstName;
  }

  /**
   * @param academicianFirstName the academicianFirstName to set
   */
  public void setAcademicianFirstName(String academicianFirstName) {
    this.academicianFirstName = academicianFirstName;
  }

  /**
   * @return the academicianLastName
   */
  public String getAcademicianLastName() {
    return academicianLastName;
  }

  /**
   * @param academicianLastName the academicianLastName to set
   */
  public void setAcademicianLastName(String academicianLastName) {
    this.academicianLastName = academicianLastName;
  }

  /**
   * @return the academicianGender
   */
  public String getAcademicianGender() {
    return academicianGender;
  }

  /**
   * @param academicianGender the academicianGender to set
   */
  public void setAcademicianGender(String academicianGender) {
    this.academicianGender = academicianGender;
  }

  /**
   * @return the academicianDob
   */
  public Date getAcademicianDob() {
    return academicianDob;
  }

  /**
   * @param academicianDob the academicianDob to set
   */
  public void setAcademicianDob(Date academicianDob) {
    this.academicianDob = academicianDob;
  }

  /**
   * @return the academicianPhoto
   */
  public String getAcademicianPhoto() {
    return academicianPhoto;
  }

  /**
   * @param academicianPhoto the academicianPhoto to set
   */
  public void setAcademicianPhoto(String academicianPhoto) {
    this.academicianPhoto = academicianPhoto;
  }

  /**
   * @return the academicianBloodGroup
   */
  public String getAcademicianBloodGroup() {
    return academicianBloodGroup;
  }

  /**
   * @param academicianBloodGroup the academicianBloodGroup to set
   */
  public void setAcademicianBloodGroup(String academicianBloodGroup) {
    this.academicianBloodGroup = academicianBloodGroup;
  }

  /**
   * @return the academicianCategory
   */
  public String getAcademicianCategory() {
    return academicianCategory;
  }

  /**
   * @param academicianCategory the academicianCategory to set
   */
  public void setAcademicianCategory(String academicianCategory) {
    this.academicianCategory = academicianCategory;
  }

  /**
   * @return the academicianReligion
   */
  public String getAcademicianReligion() {
    return academicianReligion;
  }

  /**
   * @param academicianReligion the academicianReligion to set
   */
  public void setAcademicianReligion(String academicianReligion) {
    this.academicianReligion = academicianReligion;
  }

  /**
   * @return the academicianParentName
   */
  public String getAcademicianParentName() {
    return academicianParentName;
  }

  /**
   * @param academicianParentName the academicianParentName to set
   */
  public void setAcademicianParentName(String academicianParentName) {
    this.academicianParentName = academicianParentName;
  }

  /**
   * @return the academicianAddress
   */
  public AcademicianAddress getAcademicianAddress() {
    return academicianAddress;
  }

  /**
   * @param academicianAddress the academicianAddress to set
   */
  public void setAcademicianAddress(AcademicianAddress academicianAddress) {
    this.academicianAddress = academicianAddress;
  }

  /**
   * @return the academicianAdmissionDate
   */
  public Date getAcademicianAdmissionDate() {
    return academicianAdmissionDate;
  }

  /**
   * @param academicianAdmissionDate the academicianAdmissionDate to set
   */
  public void setAcademicianAdmissionDate(Date academicianAdmissionDate) {
    this.academicianAdmissionDate = academicianAdmissionDate;
  }

  /**
   * @return the academicianHasSibling
   */
  public boolean isAcademicianHasSibling() {
    return academicianHasSibling;
  }

  /**
   * @param academicianHasSibling the academicianHasSibling to set
   */
  public void setAcademicianHasSibling(boolean academicianHasSibling) {
    this.academicianHasSibling = academicianHasSibling;
  }

  /**
   * @return the academicianNationality
   */
  public String getAcademicianNationality() {
    return academicianNationality;
  }

  /**
   * @param academicianNationality the academicianNationality to set
   */
  public void setAcademicianNationality(String academicianNationality) {
    this.academicianNationality = academicianNationality;
  }

  /**
   * @return the academicianFrom
   */
  public String getAcademicianFrom() {
    return academicianFrom;
  }

  /**
   * @param academicianFrom the academicianFrom to set
   */
  public void setAcademicianFrom(String academicianFrom) {
    this.academicianFrom = academicianFrom;
  }

  /**
   * @return the academicianPreviousSchoolDetails
   */
  public AcademicianPreviousSchoolDetails getAcademicianPreviousSchoolDetails() {
    return academicianPreviousSchoolDetails;
  }

  /**
   * @param academicianPreviousSchoolDetails the academicianPreviousSchoolDetails to set
   */
  public void setAcademicianPreviousSchoolDetails(
      AcademicianPreviousSchoolDetails academicianPreviousSchoolDetails) {
    this.academicianPreviousSchoolDetails = academicianPreviousSchoolDetails;
  }

  /**
   * @return the academicianTravelmMthod
   */
  public String getAcademicianTravelmMthod() {
    return academicianTravelmMthod;
  }

  /**
   * @param academicianTravelmMthod the academicianTravelmMthod to set
   */
  public void setAcademicianTravelmMthod(String academicianTravelmMthod) {
    this.academicianTravelmMthod = academicianTravelmMthod;
  }

  /**
   * @return the academicianExamScoresInfo
   */
  public Set<AcademicianExamScoresInfo> getAcademicianExamScoresInfo() {
    return academicianExamScoresInfo;
  }

  /**
   * @param academicianExamScoresInfo the academicianExamScoresInfo to set
   */
  public void setAcademicianExamScoresInfo(Set<AcademicianExamScoresInfo> academicianExamScoresInfo) {
    this.academicianExamScoresInfo = academicianExamScoresInfo;
  }

  /**
   * @return the academicanFeesProfile
   */
  public Set<FeesProfile> getAcademicanFeesProfile() {
    return academicanFeesProfile;
  }

  /**
   * @param academicanFeesProfile the academicanFeesProfile to set
   */
  public void setAcademicanFeesProfile(Set<FeesProfile> academicanFeesProfile) {
    this.academicanFeesProfile = academicanFeesProfile;
  }

  /**
   * @return the schoolCollection
   */
  public SchoolCollection getSchoolCollection() {
    return schoolCollection;
  }

  /**
   * @param schoolCollection the schoolCollection to set
   */
  public void setSchoolCollection(SchoolCollection schoolCollection) {
    this.schoolCollection = schoolCollection;
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

  /**
   * @return the isNewAdmission
   */
  public boolean isNewAdmission() {
    return isNewAdmission;
  }

  /**
   * @param isNewAdmission the isNewAdmission to set
   */
  public void setNewAdmission(boolean isNewAdmission) {
    this.isNewAdmission = isNewAdmission;
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

  /**
   * @return the academicianGurdianInfo
   */
  public AcademicianGuardianInfo getAcademicianGurdianInfo() {
    return academicianGurdianInfo;
  }

  /**
   * @param academicianGurdianInfo the academicianGurdianInfo to set
   */
  public void setAcademicianGurdianInfo(AcademicianGuardianInfo academicianGurdianInfo) {
    this.academicianGurdianInfo = academicianGurdianInfo;
  }


}
