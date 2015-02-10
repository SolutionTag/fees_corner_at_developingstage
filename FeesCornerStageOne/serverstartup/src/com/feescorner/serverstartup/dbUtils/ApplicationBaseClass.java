/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 19, 2015                        TODO

 */
package com.feescorner.serverstartup.dbUtils;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ApplicationBaseClass implements Serializable{
  
 
  
  /**
   * 
   */
  public ApplicationBaseClass(){
   this.indexId=hashCode();
  
  }
  private static final long serialVersionUID = 1L;
  
  @Column(name="indexid")
  private int indexId;

  @Override
  public boolean equals(Object obj){
    ApplicationBaseClass baseEntity=(ApplicationBaseClass) obj;
    return getIndexId() == baseEntity.getIndexId();
  }

  /**
   * @return the indexId
   */
  public int getIndexId() {
    return indexId;
  }

  /**
   * @param indexId the indexId to set
   */
  public void setIndexId(int indexId) {
    this.indexId = indexId;
  }




  
}
