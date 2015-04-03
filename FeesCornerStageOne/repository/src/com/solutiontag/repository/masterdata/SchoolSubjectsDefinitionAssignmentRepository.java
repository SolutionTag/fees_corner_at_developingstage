/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 28, 2015                        TODO

 */
package com.solutiontag.repository.masterdata;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment;
import com.solutiontag.entity.masterdata.SchoolStandardsDefnition;
import com.solutiontag.entity.masterdata.SchoolSubjectsDefinitionAssignment;

@Repository
@Transactional(readOnly = true)
public interface SchoolSubjectsDefinitionAssignmentRepository extends JpaRepository<SchoolSubjectsDefinitionAssignment, Integer> {

  
@Query(value="SELECT * FROM  `subjectassignment` WHERE  `standardid` =? AND  `basesubjectid` =? AND  `section_id` =?",nativeQuery=true)
SchoolSubjectsDefinitionAssignment findExist(Integer standardId,Integer basecompareId,Integer sectionId);

@Query("select u from #{#entityName} u where u.standardId =:standardId and u.schoolClassSection.sectionId=:sectionId")
public Set<SchoolSubjectsDefinitionAssignment> returnSectionSubjectSet(@Param("standardId")Integer standardId,@Param("sectionId")Integer sectionId);
/*@NamedQuery(name = "SchoolSubjectsDefinitionAssignment.findExist", query = "SELECT s FROM  s subjectassignment WHERE  standardId =? AND  baseSubjectId =? AND  schoolClassSection.sectionId =?")*/

@Query("select u.derivedSubjectId from #{#entityName} u where u.standardId =:standardId and u.schoolClassSection.compareId=:sectionId and u.baseSubjectId =:baseSubjectId")
public Integer getSubjectAssignmentPrimaryKey(@Param("standardId")Integer standardId,@Param("sectionId")Integer sectionId,@Param("baseSubjectId")Integer baseSubjectId );

@Modifying
@Transactional
@Query("delete from #{#entityName} assignment where assignment.derivedSubjectId=:derivedSubjectId")
public void deleteSubjectFromAssignment(@Param("derivedSubjectId")Integer derivedSubjectId );


/*@Modifying 
@Query(value="delete  FROM `subjectassignment` WHERE `standardid` = ? and  `section_id` =? and `basesubjectid`=?",nativeQuery=true)
  public void deleteSubjectFromAssignment(Integer standardId,Integer sectionId,Integer baseSubjectId);
  "delete from #{#entityName} u where u.standardId =:standardId and u.schoolClassSection.sectionId=:sectionId and u.baseSubjectId =:baseSubjectId")
  */
}
