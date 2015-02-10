/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 2, 2015                        TODO

 */
package com.solutiontag.repository.test;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutiontag.entity.test.Phone;

public interface PhoneNumberRepo extends JpaRepository<Phone, Long>{

}
