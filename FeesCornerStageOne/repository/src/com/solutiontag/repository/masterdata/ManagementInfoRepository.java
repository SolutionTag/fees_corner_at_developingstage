/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 27, 2014                        TODO

 */
package com.solutiontag.repository.masterdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solutiontag.entity.masterdata.ManagementInfo;

@Repository
public interface ManagementInfoRepository extends JpaRepository<ManagementInfo, Integer>{

  
}
