/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 10, 2015                        TODO

 */
package com.feescorner.masterdata.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.solutiontag.entity.masterdata.AdminCredentials;
import com.solutiontag.repository.masterdata.AdminCredentialsRepository;

@Component
public class LoginHandler {
@Autowired
public AdminCredentialsRepository adminCredentialsRepository;
  public boolean saveLoginCredentials(AdminCredentials adminCredentials){
    adminCredentialsRepository.save(adminCredentials);
    return true;
  }
  
}
