/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 4, 2015                        TODO

 */
package com.solutiontag.repository.masterdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solutiontag.entity.masterdata.SchoolStafPayRollDefinition;
@Repository
public interface SchoolStafPayRollDefinitionRepository extends JpaRepository<SchoolStafPayRollDefinition, Integer> {

}
