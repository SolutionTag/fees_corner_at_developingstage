/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 4, 2015                        TODO

 */
package com.solutiontag.entity.academic;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.cache.annotation.Cacheable;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;
@Entity
@Table(name="academicianloginlogoutdetails")
@Cacheable
public class AcademicianLogInLogOutInfo extends ApplicationPrimaryClass implements Serializable {
  
 /**
   * 
   */
  private static final long serialVersionUID = 1L;

 @Id
 @Column(name="academicianLogin")
 private Integer academicianLoginId;
 
 @Column(name="platform")
 private String  platform;
 
 @Column(name="browser")
 private String browser;
 
 @Column(name="ipaddress")
 private String ipAddress;
 
 @Column(name="type")
 private String type; /*(login/logout)*/
 
 @Column(name="typetime")
 private Date typeTime;

/**
 * @return the academicianLoginId
 */
public Integer getAcademicianLoginId() {
  return academicianLoginId;
}

/**
 * @param academicianLoginId the academicianLoginId to set
 */
public void setAcademicianLoginId(Integer academicianLoginId) {
  this.academicianLoginId = academicianLoginId;
}

/**
 * @return the platform
 */
public String getPlatform() {
  return platform;
}

/**
 * @param platform the platform to set
 */
public void setPlatform(String platform) {
  this.platform = platform;
}

/**
 * @return the browser
 */
public String getBrowser() {
  return browser;
}

/**
 * @param browser the browser to set
 */
public void setBrowser(String browser) {
  this.browser = browser;
}

/**
 * @return the ipAddress
 */
public String getIpAddress() {
  return ipAddress;
}

/**
 * @param ipAddress the ipAddress to set
 */
public void setIpAddress(String ipAddress) {
  this.ipAddress = ipAddress;
}

/**
 * @return the type
 */
public String getType() {
  return type;
}

/**
 * @param type the type to set
 */
public void setType(String type) {
  this.type = type;
}

/**
 * @return the typeTime
 */
public Date getTypeTime() {
  return typeTime;
}

/**
 * @param typeTime the typeTime to set
 */
public void setTypeTime(Date typeTime) {
  this.typeTime = typeTime;
}
 
 
 

}
