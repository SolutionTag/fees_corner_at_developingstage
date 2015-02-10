/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 31, 2014                        TODO

 */
package com.solutiontag.entity.test;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Table(name="jobtwo")
public class JobTwo {
  @Id
  @GenericGenerator(name="person_generator", strategy = "com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  @GeneratedValue(generator="person_generator")
  @Column(name="id")
  Integer id;

  @OneToOne(mappedBy = "myJob2",cascade=CascadeType.ALL)
  Person currentWorker;

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @return the currentWorker
   */
  public Person getCurrentWorker() {
    return currentWorker;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @param currentWorker the currentWorker to set
   */
  public void setCurrentWorker(Person currentWorker) {
    this.currentWorker = currentWorker;
  }

}
