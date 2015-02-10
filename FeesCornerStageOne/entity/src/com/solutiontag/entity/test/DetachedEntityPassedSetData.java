/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 5, 2015                        TODO

 */
package com.solutiontag.entity.test;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;

@Entity
@Table(name="detachedentitypassedset")
public class DetachedEntityPassedSetData extends ApplicationPrimaryClass implements Serializable  {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(generator="feesdefgenerator")
  @GenericGenerator(name = "feesdefgenerator", strategy = "com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  @Column(name="setid")
  private Integer setId;
  
  @Column(name="setName")
  private String setName;
  
  @ManyToOne(fetch=FetchType.LAZY,cascade={  CascadeType.MERGE})
  @JoinColumn(name="detachedid" )
  private DetachedEntityPassedChild detachedEntitychildset;

  /**
   * @return the setId
   */
  public Integer getSetId() {
    return setId;
  }

  /**
   * @param setId the setId to set
   */
  public void setSetId(Integer setId) {
    this.setId = setId;
  }

  /**
   * @return the setName
   */
  public String getSetName() {
    return setName;
  }

  /**
   * @param setName the setName to set
   */
  public void setSetName(String setName) {
    this.setName = setName;
  }

  /**
   * @return the detachedEntitychildset
   */
  public DetachedEntityPassedChild getDetachedEntitychildset() {
    return detachedEntitychildset;
  }

  /**
   * @param detachedEntitychildset the detachedEntitychildset to set
   */
  public void setDetachedEntitychildset(DetachedEntityPassedChild detachedEntitychildset) {
    this.detachedEntitychildset = detachedEntitychildset;
  }

}
