/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 10, 2015                        TODO

 */
package com.solutiontag.repository.masterdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutiontag.entity.masterdata.AdminCredentials;

public interface AdminCredentialsRepository extends JpaRepository<AdminCredentials, Integer> {

}
