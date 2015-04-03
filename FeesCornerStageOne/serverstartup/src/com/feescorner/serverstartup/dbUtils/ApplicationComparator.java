/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 16, 2015                        TODO

 */
package com.feescorner.serverstartup.dbUtils;

import java.util.Comparator;

import com.solutiontag.entity.academic.AcademicianInfo;

public class ApplicationComparator {
  
  public static Comparator<AcademicianInfo> studentAdmissionDateComparator=new Comparator<AcademicianInfo>(){

    @Override
    public int compare(AcademicianInfo o1, AcademicianInfo o2) {
      return o1.getAcademicianAdmissionDate().compareTo(o2.getAcademicianAdmissionDate());
    }
    
 

   
  };

}
