/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 23, 2014                        TODO

 */
package com.feescorner.masterdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.solutiontag.entity.test.TestVillageTwo;
import com.solutiontag.repository.test.TestVillageRepository;


@Component
public class TestVillageService {

  @Autowired
  private TestVillageRepository testvillageRepo;

  public TestVillageService() {
   
  }

  public Object save(TestVillageTwo object) {
    return testvillageRepo.save(object);
  }

}
