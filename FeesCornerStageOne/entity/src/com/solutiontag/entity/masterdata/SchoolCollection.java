/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 29, 2014                        TODO

 */
package com.solutiontag.entity.masterdata;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.cache.annotation.Cacheable;

import com.feescorner.serverstartup.dbUtils.ApplicationUtills;
import com.solutiontag.entity.academic.AcademicianInfo;
@Entity
@Cacheable
@Table(name="schoolcollection")
public class SchoolCollection implements Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

 
  
  @Id
  @GeneratedValue(generator="schoolgenerator")
  @GenericGenerator(name="schoolgenerator",strategy="com.feescorner.masterdata.genrators.SchoolGenerator")
  @Column(name="school_id")
  private String schoolId;

  /*  
  @Column(name="school_collection_id")
  private Integer schoolCollectionId;*/
  
  @Column(name="school_name")
  private String schoolName;
 
  @Column(name="standard_of_education")
  private String standardOfEducation;
  
  @Column(name="education_board")
  private String educationBoard;
  
  @Column(name="school_recognized_by")
  private String schoolRecognizedBy;
  
  @Column(name="school_government_reg_id")
  private Integer schoolGovernmentRegId;
  
  @Column(name="school_establishedyear")
  private Date schoolEstablishedYear;
  
  @Column(name="school_location")
  private String schoolLocation;
  
  @Column(name="school_located_district")
  private String schoolLocatedDistrict;
  
  @Column(name="school_located_state")
  private String schoolLocatedState;
  
  @Column(name="school_latitude_landitude")
  private String schoolLatitudeandLanditude;
  
  @Column(name="school_vision")
  private String schoolVision;
  
  @Column(name="school_mission")
  private String schoolMission;
  
  @Column(name="school_longterm_goal")
  private String schoolLongTermGoal;
  
  @Column(name="school_phonenumber")
  private Integer schoolPhoneNumbers;
  
  @Column(name="school_emailid")
  private String schoolEmailId;
  
  @Column(name="school_account_createdby")
  private String schoolAccountCreatedBy;
  
  @Column(name="school_account_creatorid")
  private Integer schoolAccountCreatorId;
  
  @ManyToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="school_collection_id")
  private SchoollCollections schoolCollections;

  @OneToMany(cascade=CascadeType.ALL,mappedBy="schoolCollection")
  private Set<SchoolAccountModifierHistory> schoolAccountModifierHistory=new LinkedHashSet<SchoolAccountModifierHistory>();   
  
  @OneToOne
  @PrimaryKeyJoinColumn
  private SchoolMasterDataDefinition schoolMasterData;
  
  @Column(name="school_academicYear")
  private String academicYear;
  
  @Column(name="schooltype")
  private String boardingSchool;
  
  @Column(name="noofterms")
  private String noOfTerms;
  
  @Column(name="schoolmediumofinstruction")
  private String schoolMediumOfInstruction;
  
 /* @ElementCollection
  @CollectionTable(name="academicaininfo",joinColumns=@JoinColumn(name="school_id"))
  @MapKeyColumn(name = "nametest", length = 50, nullable = false)
  @Column(name="valutest")*/
  
/*  @ElementCollection
  @CollectionTable(name = "academicanmaptable", joinColumns = @JoinColumn(name = "school_id"))
  private Map<Integer, AcademicianInfo> academicianInfoMap = new HashMap<Integer, AcademicianInfo>();*/

  
  @OneToMany(cascade=CascadeType.ALL,mappedBy="schoolCollection")
  @MapKey(name="academicianId")
  private Map<Integer, AcademicianInfo> acadeinfo=new HashMap<Integer,  AcademicianInfo>();
  
  
  
 // private SchoolMasterData schoolMasterData;

  public SchoolCollection(){
    this.schoolMasterData=new SchoolMasterDataDefinition();
    this.schoolMasterData.setSchoolCollection(this);
     ArrayList<String> standardOfEducationList;
     ArrayList<String> schoolRecognizedByList;
     ArrayList<String> educationBoardLists;
  String one= ApplicationUtills.RomanNumerals(1);
  String five= ApplicationUtills.RomanNumerals(5);
  String six=ApplicationUtills.RomanNumerals(6);
  String eight=ApplicationUtills.RomanNumerals(8);
  String nine=ApplicationUtills.RomanNumerals(9);
 // String ten=ApplicationUtills.RomanNumerals(10);
  String eleven=ApplicationUtills.RomanNumerals(11);
  String twelve=ApplicationUtills.RomanNumerals(12);
    standardOfEducationList=new ArrayList<String>();
    schoolRecognizedByList=new ArrayList<String>();
    educationBoardLists=new ArrayList<String>();
    standardOfEducationList.add("PRE-PRIMARY-SCHOOL[Ex:Pre-basic Nursery,Kinder Garden,Montessori Schools]");
    standardOfEducationList.add("PRIMARY-SCHOOL[Ex:"+one+"to"+five+"]");
    standardOfEducationList.add("MIDDLE-SCHOOL[Ex:"+one+"to"+eight+"/"+six+"to"+eight+"]");
    standardOfEducationList.add("HIGH-SCHOOL[Ex:"+six+"to"+twelve+"/"+one+"to"+twelve+"/"+nine+"to"+twelve+"/"+eleven+"to"+twelve+"(Truncated School)]");
    schoolRecognizedByList.add("The Director of School Education");
    schoolRecognizedByList.add("The Director of Elementary Education");
    schoolRecognizedByList.add("The Director of Matriculation School");
    schoolRecognizedByList.add("The Director of Teacher Education ,Research and Training");
    educationBoardLists.add("CBSE-central Board for Secondary Education.");
    educationBoardLists.add("Matriculation-Matriculation Board is typically found in in Tamil Nadu and Pondicherry schools.");
    educationBoardLists.add("State boards-State Board - Virtually, every state in India has its own board.");
    educationBoardLists.add("ICSE-Indian Certificate of Secondary Education.");
    educationBoardLists.add("ISC - Indian School Certificate");
    educationBoardLists.add("IGCSE (International General Certificate of Secondary Education) is a curriculum spread over classes IX and X. ");
    educationBoardLists.add("Cambridge O-level,O -levels provide a curriculum spread over classes IX and X.");
    educationBoardLists.add("Cambridge A-level");
    educationBoardLists.add("IB-IB (International Baccalaureate) offers high quality programmes for children from ages 3 to 19.");
    educationBoardLists.add("ISC - Indian School Certificate");
    
  }

  /**
   * @return the schoolId
   */
  public String getSchoolId() {
    return schoolId;
  }

  /**
   * @param schoolId the schoolId to set
   */
  public void setSchoolId(String schoolId) {
    this.schoolId = schoolId;
  }

  /**
   * @return the schoolName
   */
  public String getSchoolName() {
    return schoolName;
  }

  /**
   * @param schoolName the schoolName to set
   */
  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }

  /**
   * @return the standardOfEducation
   */
  public String getStandardOfEducation() {
    return standardOfEducation;
  }

  /**
   * @param standardOfEducation the standardOfEducation to set
   */
  public void setStandardOfEducation(String standardOfEducation) {
    this.standardOfEducation = standardOfEducation;
  }

  /**
   * @return the educationBoard
   */
  public String getEducationBoard() {
    return educationBoard;
  }

  /**
   * @param educationBoard the educationBoard to set
   */
  public void setEducationBoard(String educationBoard) {
    this.educationBoard = educationBoard;
  }

  /**
   * @return the schoolRecognizedBy
   */
  public String getSchoolRecognizedBy() {
    return schoolRecognizedBy;
  }

  /**
   * @param schoolRecognizedBy the schoolRecognizedBy to set
   */
  public void setSchoolRecognizedBy(String schoolRecognizedBy) {
    this.schoolRecognizedBy = schoolRecognizedBy;
  }

  /**
   * @return the schoolGovernmentRegId
   */
  public Integer getSchoolGovernmentRegId() {
    return schoolGovernmentRegId;
  }

  /**
   * @param schoolGovernmentRegId the schoolGovernmentRegId to set
   */
  public void setSchoolGovernmentRegId(Integer schoolGovernmentRegId) {
    this.schoolGovernmentRegId = schoolGovernmentRegId;
  }

  /**
   * @return the schoolEstablishedYear
   */
  public Date getSchoolEstablishedYear() {
    return schoolEstablishedYear;
  }

  /**
   * @param schoolEstablishedYear the schoolEstablishedYear to set
   */
  public void setSchoolEstablishedYear(Date schoolEstablishedYear) {
    this.schoolEstablishedYear = schoolEstablishedYear;
  }

  /**
   * @return the schoolLocation
   */
  public String getSchoolLocation() {
    return schoolLocation;
  }

  /**
   * @param schoolLocation the schoolLocation to set
   */
  public void setSchoolLocation(String schoolLocation) {
    this.schoolLocation = schoolLocation;
  }

  /**
   * @return the schoolLocatedDistrict
   */
  public String getSchoolLocatedDistrict() {
    return schoolLocatedDistrict;
  }

  /**
   * @param schoolLocatedDistrict the schoolLocatedDistrict to set
   */
  public void setSchoolLocatedDistrict(String schoolLocatedDistrict) {
    this.schoolLocatedDistrict = schoolLocatedDistrict;
  }

  /**
   * @return the schoolLocatedState
   */
  public String getSchoolLocatedState() {
    return schoolLocatedState;
  }

  /**
   * @param schoolLocatedState the schoolLocatedState to set
   */
  public void setSchoolLocatedState(String schoolLocatedState) {
    this.schoolLocatedState = schoolLocatedState;
  }

  /**
   * @return the schoolLatitudeandLanditude
   */
  public String getSchoolLatitudeandLanditude() {
    return schoolLatitudeandLanditude;
  }

  /**
   * @param schoolLatitudeandLanditude the schoolLatitudeandLanditude to set
   */
  public void setSchoolLatitudeandLanditude(String schoolLatitudeandLanditude) {
    this.schoolLatitudeandLanditude = schoolLatitudeandLanditude;
  }

  /**
   * @return the schoolVision
   */
  public String getSchoolVision() {
    return schoolVision;
  }

  /**
   * @param schoolVision the schoolVision to set
   */
  public void setSchoolVision(String schoolVision) {
    this.schoolVision = schoolVision;
  }

  /**
   * @return the schoolMission
   */
  public String getSchoolMission() {
    return schoolMission;
  }

  /**
   * @param schoolMission the schoolMission to set
   */
  public void setSchoolMission(String schoolMission) {
    this.schoolMission = schoolMission;
  }

  /**
   * @return the schoolLongTermGoal
   */
  public String getSchoolLongTermGoal() {
    return schoolLongTermGoal;
  }

  /**
   * @param schoolLongTermGoal the schoolLongTermGoal to set
   */
  public void setSchoolLongTermGoal(String schoolLongTermGoal) {
    this.schoolLongTermGoal = schoolLongTermGoal;
  }

  /**
   * @return the schoolPhoneNumbers
   */
  public Integer getSchoolPhoneNumbers() {
    return schoolPhoneNumbers;
  }

  /**
   * @param schoolPhoneNumbers the schoolPhoneNumbers to set
   */
  public void setSchoolPhoneNumbers(Integer schoolPhoneNumbers) {
    this.schoolPhoneNumbers = schoolPhoneNumbers;
  }

  /**
   * @return the schoolEmailId
   */
  public String getSchoolEmailId() {
    return schoolEmailId;
  }

  /**
   * @param schoolEmailId the schoolEmailId to set
   */
  public void setSchoolEmailId(String schoolEmailId) {
    this.schoolEmailId = schoolEmailId;
  }

  /**
   * @return the schoolAccountCreatedBy
   */
  public String getSchoolAccountCreatedBy() {
    return schoolAccountCreatedBy;
  }

  /**
   * @param schoolAccountCreatedBy the schoolAccountCreatedBy to set
   */
  public void setSchoolAccountCreatedBy(String schoolAccountCreatedBy) {
    this.schoolAccountCreatedBy = schoolAccountCreatedBy;
  }

  /**
   * @return the schoolAccountCreatorId
   */
  public Integer getSchoolAccountCreatorId() {
    return schoolAccountCreatorId;
  }

  /**
   * @param schoolAccountCreatorId the schoolAccountCreatorId to set
   */
  public void setSchoolAccountCreatorId(Integer schoolAccountCreatorId) {
    this.schoolAccountCreatorId = schoolAccountCreatorId;
  }

  /**
   * @return the schoolCollections
   */
  public SchoollCollections getSchoolCollections() {
    return schoolCollections;
  }

  /**
   * @param schoolCollections the schoolCollections to set
   */
  public void setSchoolCollections(SchoollCollections schoolCollections) {
    this.schoolCollections = schoolCollections;
  }

  /**
   * @return the schoolAccountModifierHistory
   */
  public Set<SchoolAccountModifierHistory> getSchoolAccountModifierHistory() {
    return schoolAccountModifierHistory;
  }

  /**
   * @param schoolAccountModifierHistory the schoolAccountModifierHistory to set
   */
  public void setSchoolAccountModifierHistory(
      Set<SchoolAccountModifierHistory> schoolAccountModifierHistory) {
    this.schoolAccountModifierHistory = schoolAccountModifierHistory;
  }

  /**
   * @return the schoolMasterData
   */
  public SchoolMasterDataDefinition getSchoolMasterData() {
    return schoolMasterData;
  }

  /**
   * @param schoolMasterData the schoolMasterData to set
   */
  public void setSchoolMasterData(SchoolMasterDataDefinition schoolMasterData) {
    this.schoolMasterData = schoolMasterData;
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

  /**
   * @return the boardingSchool
   */
  public String getBoardingSchool() {
    return boardingSchool;
  }

  /**
   * @param boardingSchool the boardingSchool to set
   */
  public void setBoardingSchool(String boardingSchool) {
    this.boardingSchool = boardingSchool;
  }

  /**
   * @return the noOfTerms
   */
  public String getNoOfTerms() {
    return noOfTerms;
  }

  /**
   * @param noOfTerms the noOfTerms to set
   */
  public void setNoOfTerms(String noOfTerms) {
    this.noOfTerms = noOfTerms;
  }

  /**
   * @return the schoolMediumOfInstruction
   */
  public String getSchoolMediumOfInstruction() {
    return schoolMediumOfInstruction;
  }

  /**
   * @param schoolMediumOfInstruction the schoolMediumOfInstruction to set
   */
  public void setSchoolMediumOfInstruction(String schoolMediumOfInstruction) {
    this.schoolMediumOfInstruction = schoolMediumOfInstruction;
  }

  /**
   * @return the acadeinfo
   */
  public Map<Integer, AcademicianInfo> getAcadeinfo() {
    return acadeinfo;
  }

  /**
   * @param acadeinfo the acadeinfo to set
   */
  public void setAcadeinfo(Map<Integer, AcademicianInfo> acadeinfo) {
    this.acadeinfo = acadeinfo;
  }



  
  }
