import com.solutiontag.entity.masterdata.ManagementInfo;
import com.solutiontag.entity.masterdata.SuperAdmin;

/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 27, 2014                        TODO

 */

public class CoreMainClass {
 
  public static void main(String args[]){
    
   SuperAdmin superAdmin=new SuperAdmin();
   superAdmin.setSuperAdminEmailId("admin@feesCorner.com");
   superAdmin.setSuperAdminName("Jackson");
   superAdmin.setSuperAdminPassword("2568");
   superAdmin.setSuperAdminProfilePicture("Mypicture");
   ManagementInfo managementInfo =new ManagementInfo();
   managementInfo.setCorrespondentEmailId("correspondentEmailId@gmail.com");
   managementInfo.setCorrespondentName("Kevin Payne");
   managementInfo.setManagementName("Adaptavant");
   managementInfo.setManagementLocation("LossVagas");
   managementInfo.setCorrespondentId(6985);
  // superAdmin.setManagementInfo(managementInfo);
   managementInfo.setSuperAdmin(superAdmin);
   //managementRepository.save(managementInfo);
   
   
    
    
    
  }
}
