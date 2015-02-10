/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 29, 2014                        TODO

 */
package com.solutiontag.entity.masterdata;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.cache.annotation.Cacheable;
@Entity
@Cacheable
@Table(name="schoollcollections")
public class SchoollCollections implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  public SchoollCollections(){
    this.schoolCollectionId=hashCode();
  }
  @Id
  @Column(name="school_collection_id")
  private Integer schoolCollectionId;
  
  @Column(name="management_id")
  private Integer managementId;
  
  @Column(name="management_Name")
  private String managementName;
  
  @Column(name="management_Place")
  private String managementplace;
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL,mappedBy="schoolCollections")
  private Set<SchoolCollection> schoolCollectionSet=new LinkedHashSet<SchoolCollection>();
  /**
   * @return the managementId
   */
  public Integer getManagementId() {
    return managementId;
  }
  /** 
   * @return the managementName
   */
  public String getManagementName() {
    return managementName;
  }
  /**
   * @return the managementplace
   */
  public String getManagementplace() {
    return managementplace;
  }
  /**
   * @return the schoolCollectionSet
   */
  public Set<SchoolCollection> getSchoolCollectionSet() {
    return schoolCollectionSet;
  }
  /**
   * @param managementId the managementId to set
   */
  public void setManagementId(Integer managementId) {
    this.managementId = managementId;
  }
  /**
   * @param managementName the managementName to set
   */
  public void setManagementName(String managementName) {
    this.managementName = managementName;
  }
  /**
   * @param managementplace the managementplace to set
   */
  public void setManagementplace(String managementplace) {
    this.managementplace = managementplace;
  }
  /**
   * @param schoolCollectionSet the schoolCollectionSet to set
   */
  public void setSchoolCollectionSet(Set<SchoolCollection> schoolCollectionSet) {
    this.schoolCollectionSet = schoolCollectionSet;
  }
  /**
   * @return the schoolCollectionId
   */
  public Integer getSchoolCollectionId() {
    return schoolCollectionId;
  }
  /**
   * @param schoolCollectionId the schoolCollectionId to set
   */
  public void setSchoolCollectionId(Integer schoolCollectionId) {
    this.schoolCollectionId = schoolCollectionId;
  }

}
