/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 11, 2015                        TODO

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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Table(name="academcianphonenumbers")
public class AcademicianPhoneNumbers implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="phonenoid")
  private Integer phoneId;
  
  @Column(name="phonemode")
  private String phoneMode;
  
  
  @Column(name="phonenumber")
  private Long phoneNumber;
  
  @ManyToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="addressid")
  @JsonBackReference
  private AcademicianAddress academicAddress;

  /**
   * @return the phoneId
   */
  public Integer getPhoneId() {
    return phoneId;
  }

  /**
   * @param phoneId the phoneId to set
   */
  public void setPhoneId(Integer phoneId) {
    this.phoneId = phoneId;
  }

  /**
   * @return the phoneNumber
   */
  public Long getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * @param phoneNumber the phoneNumber to set
   */
  public void setPhoneNumber(Long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * @return the academicAddress
   */
  public AcademicianAddress getAcademicAddress() {
    return academicAddress;
  }

  /**
   * @param academicAddress the academicAddress to set
   */
  public void setAcademicAddress(AcademicianAddress academicAddress) {
    this.academicAddress = academicAddress;
  }

  /**
   * @return the phoneMode
   */
  public String getPhoneMode() {
    return phoneMode;
  }

  /**
   * @param phoneMode the phoneMode to set
   */
  public void setPhoneMode(String phoneMode) {
    this.phoneMode = phoneMode;
  }
  
}
