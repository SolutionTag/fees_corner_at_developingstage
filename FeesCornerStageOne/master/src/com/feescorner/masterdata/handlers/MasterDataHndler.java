/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
varadharajan.r       Apr 27, 2015                        TODO

 */
package com.feescorner.masterdata.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.solutiontag.entity.masterdata.SchoolMasterDataDefinition;
import com.solutiontag.repository.masterdata.SchoolMasterDataDefinitionRepository;

@Component
public class MasterDataHndler {
	@Autowired
	public SchoolMasterDataDefinitionRepository masterDataRepository; 
	
   public SchoolMasterDataDefinition returnMasterData(){
	  return  masterDataRepository.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
   }
}
