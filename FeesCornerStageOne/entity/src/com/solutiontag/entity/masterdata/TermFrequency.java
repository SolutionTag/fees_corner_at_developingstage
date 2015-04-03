/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Mar 3, 2015                        TODO

 */
package com.solutiontag.entity.masterdata;

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
@Table(name="termfrequency")
public class TermFrequency extends ApplicationPrimaryClass {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(generator="termfrequncygen")
  @GenericGenerator(name = "termfrequncygen", strategy = "com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  @Column(name="termfrequencyid")
  private int termfrequencyId;
  
  @Column(name="termfrequencyname")
  private String termFrequencyName;
  
  @Column(name="sort")
  private Integer sort;
  
  @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
  @JoinColumn(name="termid")
  private SchoolTermDefinition schoolTermDef;

  /**
   * @return the termfrequencyId
   */
  public int getTermfrequencyId() {
    return termfrequencyId;
  }

  /**
   * @param termfrequencyId the termfrequencyId to set
   */
  public void setTermfrequencyId(int termfrequencyId) {
    this.termfrequencyId = termfrequencyId;
  }

  /**
   * @return the termFrequencyName
   */
  public String getTermFrequencyName() {
    return termFrequencyName;
  }

  /**
   * @param termFrequencyName the termFrequencyName to set
   */
  public void setTermFrequencyName(String termFrequencyName) {
    this.termFrequencyName = termFrequencyName;
  }

  /**
   * @return the schoolTermDef
   */
  public SchoolTermDefinition getSchoolTermDef() {
    return schoolTermDef;
  }

  /**
   * @param schoolTermDef the schoolTermDef to set
   */
  public void setSchoolTermDef(SchoolTermDefinition schoolTermDef) {
    this.schoolTermDef = schoolTermDef;
  }

  /**
   * @return the sort
   */
  public Integer getSort() {
    return sort;
  }

  /**
   * @param sort the sort to set
   */
  public void setSort(Integer sort) {
    this.sort = sort;
  }


  
 

}
