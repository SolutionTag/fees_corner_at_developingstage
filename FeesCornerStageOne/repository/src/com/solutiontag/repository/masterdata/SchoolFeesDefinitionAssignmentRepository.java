/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 27, 2015                        TODO

 */
package com.solutiontag.repository.masterdata;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment;

@Repository
public interface SchoolFeesDefinitionAssignmentRepository extends JpaRepository<SchoolFeesDefinitionAssignment, Integer> {
  
@Query("select feesassignment from  #{#entityName} feesassignment where feesassignment.standardId= :standardId  GROUP BY  feesassignment.baseFeesId  HAVING COUNT(feesassignment.baseFeesId) > 1 ")
public Set<SchoolFeesDefinitionAssignment> returnFeesesForStandards(@Param("standardId")Integer standardId);

@Query(" select feesassignment from #{#entityName} feesassignment where  feesassignment.standardId=:standardId and " +
		" feesassignment.schoolClassSection.compareId=:sectionId and " +
		"feesassignment.termId=:termId and feesassignment.baseFeesId=:baseFeesId and feesassignment.termFrequencyId=:termFrequencyId")
public SchoolFeesDefinitionAssignment returnDuplicateTermFeesAssignmentForNonVocationalGroupStd(
    @Param("standardId")Integer standardId,
    @Param("sectionId") Integer sectionId,
    @Param("termId")Integer termId,
    @Param("baseFeesId") Integer baseFeesId,
    @Param("termFrequencyId") Integer termFrequencyId
    );

@Query(" select feesassignment from #{#entityName} feesassignment where  feesassignment.vocationalGroupId=:vocationalGroupId and " +
    " feesassignment.schoolClassSection.compareId=:sectionId and " +
    "feesassignment.termId=:termId and feesassignment.baseFeesId=:baseFeesId and feesassignment.termFrequencyId=:termFrequencyId")
public SchoolFeesDefinitionAssignment returnDuplicateTermFeesAssignmentForVocationalGroupStd(
@Param("vocationalGroupId")Integer standardId,
@Param("sectionId") Integer sectionId,
@Param("termId")Integer termId,
@Param("baseFeesId") Integer baseFeesId,
@Param("termFrequencyId") Integer termFrequencyId
);


public Set<SchoolFeesDefinitionAssignment> findBystandardId(Integer standardId);

public Set<SchoolFeesDefinitionAssignment> findByvocationalGroupId(Integer vocationalGroupId);

//SELECT `sectionfeesid`, `equal_id`, `basefeesid`, `feesamount`, `feesname`, `period`, `sectionname`, `standardid`, `standrdname`, `termfrequecyid`, `termid`, `termtype`, `vocationalgroupgroupid`, `vocationalgroupname`, `section_id` FROM `feesdefinitionassignment` 

//WHERE `basefeesid` =62338 and `standardid`=91325 and `section_id`=927766810 and  `termid`=1404303205
}
