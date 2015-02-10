/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 13, 2015                        TODO

 */
package com.feescorner.academic.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.solutiontag.repository.academic.AcademicianAddressRepository;
import com.solutiontag.repository.academic.AcademicianInfoRepository;
import com.solutiontag.repository.academic.AcademicianPhoneNumbersRepository;
import com.solutiontag.repository.masterdata.SchoolCollectionRepository;

@Component
public class AcademicHandler {
  @Autowired
  public AcademicianInfoRepository academicianInfoRepository;
  
  @Autowired
  public AcademicianAddressRepository academicianAddressRepository;
  
  @Autowired
  public AcademicianPhoneNumbersRepository academicianPhoneNumbersRepository;
  
  @Autowired
  public SchoolCollectionRepository schoolCollectionRepository;
  
  
 
  
  

}
