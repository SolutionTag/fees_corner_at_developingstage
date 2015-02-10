/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 30, 2014                        TODO

 */
package com.solutiontag.repository.test;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutiontag.entity.test.Job;

public interface JobRep extends JpaRepository<Job, Integer> {

}
