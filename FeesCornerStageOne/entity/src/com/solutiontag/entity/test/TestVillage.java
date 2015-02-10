/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 22, 2014                        TODO

 */
package com.solutiontag.entity.test;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Table(name="testvillage")
public class TestVillage implements Serializable {

  /**
   * 
   */
  
  public TestVillage(){
    
  }
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.TABLE)
  @Column(name="villageId")
  private Integer villageId;
  
  @Column(name="villageName")
  private String villageName;
  
  @Column(name="villagePlace")
  private String villagePlace;
  
  @Column(name="villageDistrict")
  private String villageDistrict;
  
  private String getCustomValue;
  /**
   * @return the villageId
   */
  public Integer getVillageId() {
    return villageId;
  }
  /**
   * @param villageId the villageId to set
   */
  public void setVillageId(Integer villageId) {
    this.villageId = villageId;
  }
  /**
   * @return the villageName
   */
  public String getVillageName() {
    return villageName;
  }
  /**
   * @param villageName the villageName to set
   */
  public void setVillageName(String villageName) {
    this.villageName = villageName;
  }
  /**
   * @return the villagePlace
   */
  public String getVillagePlace() {
    return villagePlace;
  }
  /**
   * @param villagePlace the villagePlace to set
   */
  public void setVillagePlace(String villagePlace) {
    this.villagePlace = villagePlace;
  }
  /**
   * @return the villageDistrict
   */
  public String getVillageDistrict() {
    return villageDistrict;
  }
  /**
   * @param villageDistrict the villageDistrict to set
   */
  public void setVillageDistrict(String villageDistrict) {
    this.villageDistrict = villageDistrict;
  }
 
  
  /**
   * @return the getCustomValue
   */
  public String getGetCustomValue() {
    return getCustomValue;
  }
  /**
   * @param getCustomValue the getCustomValue to set
   */
  public void setGetCustomValue(String getCustomValue) {
    this.getCustomValue = getCustomValue;
  }
  

}
