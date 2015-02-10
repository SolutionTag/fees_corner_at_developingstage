/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 2, 2015                        TODO

 */
package com.solutiontag.repository.academic;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.solutiontag.entity.academic.AcademicianStandardInfo;

public interface AcademicianStandardInfoRepository extends CrudRepository<AcademicianStandardInfo, Integer> {
  
  @Query("select u from #{#entityName} u where u.academicanStandardId = ?1")
  Set<AcademicianStandardInfo> returnStudentStandardsSet(int standardId);

}
