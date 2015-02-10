/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 30, 2014                        TODO

 */
package com.solutiontag.entity.test;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.cache.annotation.Cacheable;


@Entity
@Cacheable
@Table(name="persontable")
public class Person implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GenericGenerator(name="person_generator", strategy = "com.feescorner.serverstartup.dbUtils.ApplicationUtills",parameters=@Parameter(value="myJob2,myJob",name="property"))
  @GeneratedValue(generator="person_generator")
  //@GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id")
  Integer id;
  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name = "myJob1")
  Job myJob;
  
  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name = "myJob2")
  JobTwo myJob2;
  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }
  /**
   * @return the myJob
   */
  public Job getMyJob() {
    return myJob;
  }
  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }
  /**
   * @param myJob the myJob to set
   */
  public void setMyJob(Job myJob) {
    this.myJob = myJob;
  }
  /**
   * @return the myJob2
   */
  public JobTwo getMyJob2() {
    return myJob2;
  }
  /**
   * @param myJob2 the myJob2 to set
   */
  public void setMyJob2(JobTwo myJob2) {
    this.myJob2 = myJob2;
  }
}
