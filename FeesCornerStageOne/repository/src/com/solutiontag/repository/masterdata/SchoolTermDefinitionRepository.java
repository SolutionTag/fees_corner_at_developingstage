/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Mar 3, 2015                        TODO

 */
package com.solutiontag.repository.masterdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solutiontag.entity.masterdata.SchoolTermDefinition;
@Repository
public interface SchoolTermDefinitionRepository extends JpaRepository<SchoolTermDefinition, Integer> {

}
