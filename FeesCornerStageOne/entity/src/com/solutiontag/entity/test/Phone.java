/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 2, 2015                        TODO

 */
package com.solutiontag.entity.test;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
public class Phone  implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", unique = true, nullable = false)
  private Long id;

  @Column(name = "CONTACTNUMBER", unique = true, nullable = false, length = 100)
  private String contactnumber;

  @Column(name = "PHONETYPE")
  private String phonetype;

  @ManyToOne
  @JoinColumn(name = "personId")
  private Persons persons;

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the contactnumber
   */
  public String getContactnumber() {
    return contactnumber;
  }

  /**
   * @param contactnumber the contactnumber to set
   */
  public void setContactnumber(String contactnumber) {
    this.contactnumber = contactnumber;
  }

  /**
   * @return the phonetype
   */
  public String getPhonetype() {
    return phonetype;
  }

  /**
   * @param phonetype the phonetype to set
   */
  public void setPhonetype(String phonetype) {
    this.phonetype = phonetype;
  }

  /**
   * @return the persons
   */
  public Persons getPersons() {
    return persons;
  }

  /**
   * @param persons the persons to set
   */
  public void setPersons(Persons persons) {
    this.persons = persons;
  }




  
  
}
