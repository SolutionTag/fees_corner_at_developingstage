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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="detachedentitybase")
public class DetachedEntityPassedBase implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(generator="feesdefgenerator")
  @GenericGenerator(name = "feesdefgenerator", strategy = "com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  @Column(name="detachedbaseId")
  private Integer detachedbaseId;
  
  @Column(name="detachedName")
  private String detachedName;
  
  @OneToOne(cascade=CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private DetachedEntityPassedChild detachedChild;

  /**
   * @return the detachedbaseId
   */
  public Integer getDetachedbaseId() {
    return detachedbaseId;
  }

  /**
   * @param detachedbaseId the detachedbaseId to set
   */
  public void setDetachedbaseId(Integer detachedbaseId) {
    this.detachedbaseId = detachedbaseId;
  }

  /**
   * @return the detachedName
   */
  public String getDetachedName() {
    return detachedName;
  }

  /**
   * @param detachedName the detachedName to set
   */
  public void setDetachedName(String detachedName) {
    this.detachedName = detachedName;
  }

  /**
   * @return the detachedChild
   */
  public DetachedEntityPassedChild getDetachedChild() {
    return detachedChild;
  }

  /**
   * @param detachedChild the detachedChild to set
   */
  public void setDetachedChild(DetachedEntityPassedChild detachedChild) {
    this.detachedChild = detachedChild;
  }
  

}
