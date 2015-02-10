/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 12, 2015                        TODO

 */
package com.solutiontag.repository.academic;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutiontag.entity.academic.AcademicianInfo;

public interface AcademicianInfoRepository extends JpaRepository<AcademicianInfo, Integer> {
  
   Set<AcademicianInfo> findByacademicanStandardId(int standardId);

}

