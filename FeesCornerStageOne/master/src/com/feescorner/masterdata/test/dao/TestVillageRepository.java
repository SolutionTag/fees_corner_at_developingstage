/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 22, 2014                        TODO

 */
package com.feescorner.masterdata.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feescorner.masterdata.test.model.TestVillage;

@Repository
public interface TestVillageRepository extends JpaRepository<TestVillage, Integer>
{
  
 

}
