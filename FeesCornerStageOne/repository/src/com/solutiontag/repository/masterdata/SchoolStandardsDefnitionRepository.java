/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 4, 2015                        TODO

 */
package com.solutiontag.repository.masterdata;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.solutiontag.entity.masterdata.SchoolStandardsDefnition;
@Repository
public interface SchoolStandardsDefnitionRepository extends JpaRepository<SchoolStandardsDefnition, Integer>{
  @Query("select standard.standardId from #{#entityName} standard where standard.statusForChecked =:statusForChecked ")
  public Set<Integer> returnEnabledStandards(@Param("statusForChecked")boolean statusForChecked);
}
