/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 11, 2015                        TODO

 */
package com.solutiontag.entity.academic;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.cache.annotation.Cacheable;


@Entity
@Cacheable
@Table(name="academicianaddress")
public class AcademicianAddress implements Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  public AcademicianAddress() {
    AcademicianPhoneNumbers academicicanCellPhone=new AcademicianPhoneNumbers();
    academicicanCellPhone.setPhoneMode("Parent Phone Number");
    AcademicianPhoneNumbers academicicanHomePhone=new AcademicianPhoneNumbers();
    academicicanHomePhone.setPhoneMode("Alternative Number");
   
    academicicanCellPhone.setAcademicAddress(this);
    academicicanHomePhone.setAcademicAddress(this);
    
    HashSet<AcademicianPhoneNumbers> studentPhoneNoSet=new HashSet<AcademicianPhoneNumbers>();
    studentPhoneNoSet.add(academicicanCellPhone);
    studentPhoneNoSet.add(academicicanHomePhone);
   
    this.setAcademicianPhoneNumbersSet(studentPhoneNoSet);
  }

  @Id
  @Column(name="addressid")
  private Integer addressId;
  
  @Column(name="academiciandistrict")
  private String academicianDistrict;
  
  @Column(name="academicianstate")
  private String academicianState;
  
  @Column(name="academiciancountry")
  private String academicianCountry;
  
  @Column(name="academiciandoorno")
  private String academiciandDoorNo;
  
  @Column(name="academicianstreetname")
  private String academicianStreetName;
  
  @Column(name="academicianhometown")
  private String academicianHomeTown;

  
  @MapsId
  @OneToOne(cascade=CascadeType.ALL, mappedBy="academicianAddress")
  @JoinColumn(name = "addressid")
  @JsonBackReference
  private AcademicianInfo academicianInfo;
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL,mappedBy="academicAddress")
  @JsonManagedReference
  private Set<AcademicianPhoneNumbers> academicianPhoneNumbersSet=new LinkedHashSet<AcademicianPhoneNumbers>();

  /**
   * @return the addressId
   */
  public Integer getAddressId() {
    return addressId;
  }

  /**
   * @param addressId the addressId to set
   */
  public void setAddressId(Integer addressId) {
    this.addressId = addressId;
  }

  /**
   * @return the academicianDistrict
   */
  public String getAcademicianDistrict() {
    return academicianDistrict;
  }

  /**
   * @param academicianDistrict the academicianDistrict to set
   */
  public void setAcademicianDistrict(String academicianDistrict) {
    this.academicianDistrict = academicianDistrict;
  }

  /**
   * @return the academicianState
   */
  public String getAcademicianState() {
    return academicianState;
  }

  /**
   * @param academicianState the academicianState to set
   */
  public void setAcademicianState(String academicianState) {
    this.academicianState = academicianState;
  }

  /**
   * @return the academicianCountry
   */
  public String getAcademicianCountry() {
    return academicianCountry;
  }

  /**
   * @param academicianCountry the academicianCountry to set
   */
  public void setAcademicianCountry(String academicianCountry) {
    this.academicianCountry = academicianCountry;
  }

  /**
   * @return the academiciandDoorNo
   */
  public String getAcademiciandDoorNo() {
    return academiciandDoorNo;
  }

  /**
   * @param academiciandDoorNo the academiciandDoorNo to set
   */
  public void setAcademiciandDoorNo(String academiciandDoorNo) {
    this.academiciandDoorNo = academiciandDoorNo;
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
   * @return the academicianPhoneNumbersSet
   */
  public Set<AcademicianPhoneNumbers> getAcademicianPhoneNumbersSet() {
    return academicianPhoneNumbersSet;
  }

  /**
   * @param academicianPhoneNumbersSet the academicianPhoneNumbersSet to set
   */
  public void setAcademicianPhoneNumbersSet(Set<AcademicianPhoneNumbers> academicianPhoneNumbersSet) {
    this.academicianPhoneNumbersSet = academicianPhoneNumbersSet;
  }

  /**
   * @return the academicianStreetName
   */
  public String getAcademicianStreetName() {
    return academicianStreetName;
  }

  /**
   * @param academicianStreetName the academicianStreetName to set
   */
  public void setAcademicianStreetName(String academicianStreetName) {
    this.academicianStreetName = academicianStreetName;
  }

  /**
   * @return the academicianHomeTown
   */
  public String getAcademicianHomeTown() {
    return academicianHomeTown;
  }

  /**
   * @param academicianHomeTown the academicianHomeTown to set
   */
  public void setAcademicianHomeTown(String academicianHomeTown) {
    this.academicianHomeTown = academicianHomeTown;
  }
}
