/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
varadharajan.r       Apr 27, 2015                        TODO

 */
package com.feescorner.masterdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.feescorner.academic.services.ApplicationStringJsons;
import com.meshyog.masterdata.buisnesslogic.AcademicMasterDataLogics;
import com.solutiontag.entity.masterdata.SchoolStandardsDefnition;

@Controller
@RequestMapping("/settings")
public class AcademicMasterDataControllers {
	@Autowired
	public AcademicMasterDataLogics academicMasterDataLogic;
	@Autowired
	public ApplicationStringJsons applicationStringJsons;

	@RequestMapping(value = "/academic-master-data")
	public String requestForAcademicMasterData(Model model) {
		applicationStringJsons = applicationStringJsons.getApplicationStringJsonForAcademicMasterData(academicMasterDataLogic.getSchoolMasterData());
		model.addAttribute("standardFormModelAttribute",new SchoolStandardsDefnition());
		model.addAttribute(applicationStringJsons);
		return "academicmasterdatascreen";

	}

}
