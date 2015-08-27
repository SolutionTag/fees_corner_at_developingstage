/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
varadharajan.r       Apr 27, 2015                        TODO

 */
package com.meshyog.masterdata.buisnesslogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feescorner.masterdata.handlers.MasterDataHndler;
import com.solutiontag.entity.masterdata.SchoolMasterDataDefinition;

@Component
public class AcademicMasterDataLogics {
	@Autowired
	public MasterDataHndler masterDataHandler;
	
	public SchoolMasterDataDefinition getSchoolMasterData(){
		SchoolMasterDataDefinition schoolMasterDataObj=masterDataHandler.returnMasterData();
		return schoolMasterDataObj;
	}

}
