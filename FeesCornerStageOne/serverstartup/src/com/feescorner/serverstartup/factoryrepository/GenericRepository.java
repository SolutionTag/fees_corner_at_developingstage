/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 26, 2014                        TODO

 */
package com.feescorner.serverstartup.factoryrepository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository <T, ID extends Serializable> 
 extends JpaRepository<T, ID> {    
}
