/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 23, 2014                        TODO

 */
package com.feescorner.masterdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.feescorner.masterdata.test.dao.TestVillageRepository;
import com.feescorner.masterdata.test.model.TestVillage;


@Service
@Transactional
public class TestVillageService {

  @Autowired
  private TestVillageRepository testVillageRepository;

  public TestVillageService() {
    System.out.println("Testvillage service..");
  }

  public TestVillage save(TestVillage testVillage) {

    return testVillageRepository.save(testVillage);
  }

}
