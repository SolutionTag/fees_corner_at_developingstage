/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 24, 2015                        TODO

 */
package com.solutiontag.entity.masterdata;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import com.feescorner.serverstartup.dbUtils.ApplicationPrimaryClass;
import com.feescorner.serverstartup.serverstartupServlets.GsonExclude;

@Entity
@Table(name="vocationalgroupinfo")
@Cacheable
public class SchoolVocationalGroupDefinition extends ApplicationPrimaryClass {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  @Id
  @Column
  @GeneratedValue(generator="groupgenerator")
  @GenericGenerator(name="groupgenerator",strategy="com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  private Integer groupId;
  
  @Column(name="groupname")
  private String groupName;
  
  @Column(name="groupdefinition")
  private String groupDefinition;
  
  @ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
  @JoinColumn(name="masterdata_id")
  @JsonBackReference
  @GsonExclude
  private SchoolMasterDataDefinition defForVocationalDefinition;

  /**
   * @return the groupId
   */
  public Integer getGroupId() {
    return groupId;
  }

  /**
   * @param groupId the groupId to set
   */
  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  /**
   * @return the groupName
   */
  public String getGroupName() {
    return groupName;
  }

  /**
   * @param groupName the groupName to set
   */
  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  /**
   * @return the defForVocationalDefinition
   */
  public SchoolMasterDataDefinition getDefForVocationalDefinition() {
    return defForVocationalDefinition;
  }

  /**
   * @param defForVocationalDefinition the defForVocationalDefinition to set
   */
  public void setDefForVocationalDefinition(SchoolMasterDataDefinition defForVocationalDefinition) {
    this.defForVocationalDefinition = defForVocationalDefinition;
  }

  /**
   * @return the groupDefinition
   */
  public String getGroupDefinition() {
    return groupDefinition;
  }

  /**
   * @param groupDefinition the groupDefinition to set
   */
  public void setGroupDefinition(String groupDefinition) {
    this.groupDefinition = groupDefinition;
  }
 
  

}
