/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 5, 2015                        TODO

 */
package com.solutiontag.repository.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solutiontag.entity.test.DetachedEntityPassedSetData;

@Repository
public interface DetachedEntityPassedSetDataRepo extends JpaRepository<DetachedEntityPassedSetData, Integer> {

}
