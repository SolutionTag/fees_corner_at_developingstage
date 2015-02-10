/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 26, 2014                        TODO

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
@Table(name="testvillageTwo")
public class TestVillageTwo implements Serializable{
  @Id
  @GeneratedValue(strategy=GenerationType.TABLE)
  @Column(name="cityId")
  private Integer cityId;
  
  @Column(name="cityName")
  private String cityName;
  
  @Column(name="cityPlace")
  private String cityPlace;
  
  @Column(name="cityDistance")
  private String cityDistance;
  /**
   * @return the cityId
   */
  public Integer getCityId() {
    return cityId;
  }
  /**
   * @param cityId the cityId to set
   */
  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }
  /**
   * @return the cityName
   */
  public String getCityName() {
    return cityName;
  }
  /**
   * @param cityName the cityName to set
   */
  public void setCityName(String cityName) {
    this.cityName = cityName;
  }
  /**
   * @return the cityPlace
   */
  public String getCityPlace() {
    return cityPlace;
  }
  /**
   * @param cityPlace the cityPlace to set
   */
  public void setCityPlace(String cityPlace) {
    this.cityPlace = cityPlace;
  }
  /**
   * @return the cityDistance
   */
  public String getCityDistance() {
    return cityDistance;
  }
  /**
   * @param cityDistance the cityDistance to set
   */
  public void setCityDistance(String cityDistance) {
    this.cityDistance = cityDistance;
  }

}
