/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 26, 2014                        TODO

 */
package com.solutiontag.repository.test;

import org.springframework.data.repository.NoRepositoryBean;
import com.solutiontag.entity.test.TestVillage;
import com.feescorner.serverstartup.factoryrepository.GenericRepository;

@NoRepositoryBean
public interface CustomVillageRepository  extends GenericRepository<TestVillage, Integer> { 
  
  String getCustomValue();
     

  
}
