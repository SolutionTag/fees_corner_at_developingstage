/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Mar 3, 2015                        TODO

 */
package com.solutiontag.entity.masterdata;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;

@Entity
@Table(name="termdefinition")
public class SchoolTermDefinition extends ApplicationPrimaryClass {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  
  @Id
  @GeneratedValue(generator="termidgenerator")
  @GenericGenerator(name = "termidgenerator", strategy = "com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  @Column(name="termid")
  private Integer termId;
  
  @Column(name="termname")
  private String termName;
  
  @Column(name="termperiod")
  private String termPeriod;
  
  @Fetch(FetchMode.JOIN)
  @OneToMany(cascade=CascadeType.ALL,mappedBy="schoolTermDef",orphanRemoval=true)
  @OrderBy("sort ASC")
  private Set<TermFrequency> termFrequencySet=new HashSet<TermFrequency>();
  
  @Column(name="termFrequenct")
  private String termFrequency;
  
  @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
  @JoinColumn(name="masterdata_id")
  private SchoolMasterDataDefinition defForTerm;
  /**
   * @return the termId
   */
  public Integer getTermId() {
    return termId;
  }
  /**
   * @param termId the termId to set
   */
  public void setTermId(Integer termId) {
    this.termId = termId;
  }
  /**
   * @return the termName
   */
  public String getTermName() {
    return termName;
  }
  /**
   * @param termName the termName to set
   */
  public void setTermName(String termName) {
    this.termName = termName;
  }
  /**
   * @return the termPeriod
   */
  public String getTermPeriod() {
    return termPeriod;
  }
  /**
   * @param termPeriod the termPeriod to set
   */
  public void setTermPeriod(String termPeriod) {
    this.termPeriod = termPeriod;
  }
  /**
   * @return the termFrequency
   */
  public String getTermFrequency() {
    return termFrequency;
  }
  /**
   * @param termFrequency the termFrequency to set
   */
  public void setTermFrequency(String termFrequency) {
    this.termFrequency = termFrequency;
  }
  /**
   * @return the defForTerm
   */
  public SchoolMasterDataDefinition getDefForTerm() {
    return defForTerm;
  }
  /**
   * @param defForTerm the defForTerm to set
   */
  public void setDefForTerm(SchoolMasterDataDefinition defForTerm) {
    this.defForTerm = defForTerm;
  }
  /**
   * @return the termFrequencySet
   */
  public Set<TermFrequency> getTermFrequencySet() {
    return termFrequencySet;
  }
  /**
   * @param termFrequencySet the termFrequencySet to set
   */
  public void setTermFrequencySet(Set<TermFrequency> termFrequencySet) {
    this.termFrequencySet = termFrequencySet;
  }


  

}
