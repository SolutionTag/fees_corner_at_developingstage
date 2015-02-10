/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 28, 2015                        TODO

 */
package com.feescorner.serverstartup.dbUtils;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ApplicationPrimaryClass implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  public ApplicationPrimaryClass(){
    this.compareId=super.hashCode();
    
  }
  @Column(name="equalId")
  private int compareId;
  /**
   * @return the compareId
   */
  public int getCompareId() {
    return compareId;
  }
  /**
   * @param compareId the compareId to set
   */
  public void setCompareId(int compareId) {
    this.compareId = compareId;
  }
  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + compareId;
    return result;
  }
  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ApplicationPrimaryClass other = (ApplicationPrimaryClass) obj;
    if (compareId != other.compareId)
      return false;
    return true;
  }
}
