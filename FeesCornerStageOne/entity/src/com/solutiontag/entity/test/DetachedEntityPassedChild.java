/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 5, 2015                        TODO

 */
package com.solutiontag.entity.test;

import java.io.Serializable;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;

@Entity
@Table(name="detachedentitychild")
public class DetachedEntityPassedChild extends ApplicationPrimaryClass implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="detachedid")
  private Integer detachedId;
  
  @Column(name="detachedchildname")
  private String detachedchildname;
  
  @MapsId
  @OneToOne(cascade=CascadeType.ALL, mappedBy="detachedChild")
  @JoinColumn(name = "detachedbaseId") 
  private DetachedEntityPassedBase detachedBase;
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade = { CascadeType.ALL },mappedBy="detachedEntitychildset",orphanRemoval=true)
  private Set<DetachedEntityPassedSetData> detachedSet=new LinkedHashSet<DetachedEntityPassedSetData>();

  /**
   * @return the detachedId
   */
  public Integer getDetachedId() {
    return detachedId;
  }

  /**
   * @param detachedId the detachedId to set
   */
  public void setDetachedId(Integer detachedId) {
    this.detachedId = detachedId;
  }

  /**
   * @return the detachedchildname
   */
  public String getDetachedchildname() {
    return detachedchildname;
  }

  /**
   * @param detachedchildname the detachedchildname to set
   */
  public void setDetachedchildname(String detachedchildname) {
    this.detachedchildname = detachedchildname;
  }

  /**
   * @return the detachedBase
   */
  public DetachedEntityPassedBase getDetachedBase() {
    return detachedBase;
  }

  /**
   * @param detachedBase the detachedBase to set
   */
  public void setDetachedBase(DetachedEntityPassedBase detachedBase) {
    this.detachedBase = detachedBase;
  }

  /**
   * @return the detachedSet
   */
  public Set<DetachedEntityPassedSetData> getDetachedSet() {
    return detachedSet;
  }

  /**
   * @param detachedSet the detachedSet to set
   */
  public void setDetachedSet(Set<DetachedEntityPassedSetData> detachedSet) {
    this.detachedSet = detachedSet;
  }

}
