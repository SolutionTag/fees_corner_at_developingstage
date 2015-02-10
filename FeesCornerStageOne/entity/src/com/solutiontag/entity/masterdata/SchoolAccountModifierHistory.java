/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 29, 2014                        TODO

 */
package com.solutiontag.entity.masterdata;

import java.io.Serializable;
import java.sql.Date;

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
@Entity
@Cacheable
@Table(name="schoolaccountmodifiersinfo")
public class SchoolAccountModifierHistory implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="modifier_id", unique = true, nullable = false)
  private Integer modifierId;
  
/*  @Column(name="school_id")
  private Integer schoolId;*/
  
  @Column(name="modifier_name")
  private String modifierName;
  
  @Column(name="modified_date_time")
  private Date modifiedDataandTime;
  
  @Column(name="modifierpicture")
  private String modifierPicture;
  
  @ManyToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="school_id")
  private SchoolCollection schoolCollection;

  /**
   * @return the modifierId
   */
  public Integer getModifierId() {
    return modifierId;
  }

  /**
   * @param modifierId the modifierId to set
   */
  public void setModifierId(Integer modifierId) {
    this.modifierId = modifierId;
  }

  /**
   * @return the modifierName
   */
  public String getModifierName() {
    return modifierName;
  }

  /**
   * @param modifierName the modifierName to set
   */
  public void setModifierName(String modifierName) {
    this.modifierName = modifierName;
  }

  /**
   * @return the modifiedDataandTime
   */
  public Date getModifiedDataandTime() {
    return modifiedDataandTime;
  }

  /**
   * @param modifiedDataandTime the modifiedDataandTime to set
   */
  public void setModifiedDataandTime(Date modifiedDataandTime) {
    this.modifiedDataandTime = modifiedDataandTime;
  }

  /**
   * @return the modifierPicture
   */
  public String getModifierPicture() {
    return modifierPicture;
  }

  /**
   * @param modifierPicture the modifierPicture to set
   */
  public void setModifierPicture(String modifierPicture) {
    this.modifierPicture = modifierPicture;
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

 
}
