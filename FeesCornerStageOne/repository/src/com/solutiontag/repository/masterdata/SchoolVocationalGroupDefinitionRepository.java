/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 24, 2015                        TODO

 */
package com.solutiontag.repository.masterdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solutiontag.entity.masterdata.SchoolVocationalGroupDefinition;

@Repository
public interface SchoolVocationalGroupDefinitionRepository extends JpaRepository<SchoolVocationalGroupDefinition, Integer> {

}
