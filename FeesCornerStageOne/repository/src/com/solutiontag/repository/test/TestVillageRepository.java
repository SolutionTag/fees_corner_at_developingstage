/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 22, 2014                        TODO

 */
package com.solutiontag.repository.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solutiontag.entity.test.TestVillageTwo;

@Repository
public interface TestVillageRepository  extends JpaRepository<TestVillageTwo, Integer>
{
  
 

}
