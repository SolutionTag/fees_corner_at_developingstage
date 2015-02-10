/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 2, 2015                        TODO

 */
package com.feescorner.academic.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.solutiontag.entity.academic.AcademicianInfo;
import com.solutiontag.entity.masterdata.SchoolFeesDefinition;

public class SetDefnitions implements Serializable {
  
  /**
   * 
   */
  public SetDefnitions(){
    if(monthsList.size()==0){
      loadMonths();
    }
    
  }
  private static final long serialVersionUID = 1L;
  Set<AcademicianInfo> academicianInfoSet=new HashSet<AcademicianInfo>();
  
  private Set<SchoolFeesDefinition> schoolFeesDefSet=new HashSet<SchoolFeesDefinition>();
 
  
  private  static List<String> monthsList=new ArrayList<String>();
  
  /**
   * @return the academicianInfoSet
   */
  public Set<AcademicianInfo> getAcademicianInfoSet() {
    return academicianInfoSet;
  }
  /**
   * @param academicianInfoSet the academicianInfoSet to set
   */
  public void setAcademicianInfoSet(Set<AcademicianInfo> academicianInfoSet) {
    this.academicianInfoSet = academicianInfoSet;
  }
  /**
   * @return the schoolFeesDefSet
   */
  public Set<SchoolFeesDefinition> getSchoolFeesDefSet() {
    return schoolFeesDefSet;
  }
  /**
   * @param schoolFeesDefSet the schoolFeesDefSet to set
   */
  public void setSchoolFeesDefSet(Set<SchoolFeesDefinition> schoolFeesDefSet) {
    this.schoolFeesDefSet = schoolFeesDefSet;
  }
 public void loadMonths(){
   monthsList.add("JUN");
   monthsList.add("JULY");
   monthsList.add("AUG");
   monthsList.add("SEP");
   monthsList.add("OCT");
   monthsList.add("NOV");
   monthsList.add("DEC");
   monthsList.add("JAN");
   monthsList.add("FEB");
   monthsList.add("MAR");
   monthsList.add("APR");
   monthsList.add("MAY");
   
   
 }
/**
 * @return the monthsList
 */
public List<String> getMonthsList() {
  return monthsList;
}
/**
 * @param monthsList the monthsList to set
 */
public void setMonthsList(List<String> monthsList) {
  this.monthsList = monthsList;
}


}
