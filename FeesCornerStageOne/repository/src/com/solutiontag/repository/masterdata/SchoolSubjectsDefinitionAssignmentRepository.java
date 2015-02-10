/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 28, 2015                        TODO

 */
package com.solutiontag.repository.masterdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.solutiontag.entity.masterdata.SchoolSubjectsDefinitionAssignment;

public interface SchoolSubjectsDefinitionAssignmentRepository extends JpaRepository<SchoolSubjectsDefinitionAssignment, Integer> {

  
@Query(value="SELECT * FROM  `subjectassignment` WHERE  `standardid` =? AND  `basesubjectid` =? AND  `section_id` =?",nativeQuery=true)
SchoolSubjectsDefinitionAssignment findExist(Integer standardId,Integer baseSubjectId,Integer sectionId);

/*@NamedQuery(name = "SchoolSubjectsDefinitionAssignment.findExist", query = "SELECT s FROM  s subjectassignment WHERE  standardId =? AND  baseSubjectId =? AND  schoolClassSection.sectionId =?")*/



  
}
