package com.feescorner.masterdata.controllers;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solutiontag.entity.masterdata.ManagementInfo;
import com.solutiontag.entity.masterdata.SuperAdmin;
import com.solutiontag.entity.test.Department;
import com.solutiontag.entity.test.Job;
import com.solutiontag.entity.test.JobTwo;
import com.solutiontag.entity.test.Person;
import com.solutiontag.entity.test.Persons;
import com.solutiontag.entity.test.Phone;
import com.solutiontag.entity.test.Student;
import com.solutiontag.entity.test.TestVillage;
import com.solutiontag.repository.masterdata.ManagementInfoRepository;
import com.solutiontag.repository.masterdata.SuperAdminRepository;
import com.solutiontag.repository.test.DepartmentRepo;
import com.solutiontag.repository.test.JobRep;
import com.solutiontag.repository.test.MyJob2;
import com.solutiontag.repository.test.PersonRep;
import com.solutiontag.repository.test.PersonsRepo;
import com.solutiontag.repository.test.PhoneNumberRepo;
import com.solutiontag.repository.test.StudentRepo;

@Controller
public class TestController {
  private static final Logger log=Logger.getLogger(TestController.class);
// @Autowired
 // private TestVillageService testVillageService;
 @Autowired
 public ManagementInfoRepository managementRepository;
 @Autowired
 public SuperAdminRepository superAdminRepository;
 @Autowired
 public PersonRep personRepository;
 @Autowired
 public JobRep jobRepository;
 
 @Autowired
 public MyJob2 job2Repository;
 @Autowired
 StudentRepo studentRepo;
 @Autowired 
 DepartmentRepo departmentRepo;
 
@Autowired
PersonsRepo personsRepo;

@Autowired
PhoneNumberRepo phoneNumberRepo;
 @RequestMapping("/ddd")
 public String init(){
   
   return "testVillage";
 }
 
 /*use this for after wards
  @RequestMapping("/")
  public ModelAndView init(){
    System.out.println("Index controller");
    return new ModelAndView("testVillage", "command", new TestVillage());
    
  }*/
  @RequestMapping(value="/saveVillageBean")
  public String saveTestVillageBean(@ModelAttribute("testVillage")TestVillage testVillage,ModelMap model) throws NoSuchElementException, IllegalStateException, Exception{
   /* log.info("master Data Module");
   // testVillageService.save(testVillage);
    TestVillageTwo testVillageTwo=new TestVillageTwo();
    testVillageTwo.setCityDistance("fiftyfive");
    testVillageTwo.setCityName("Trichy");
    testVillageTwo.setCityPlace("SouthSide");*/
 //   testVillageService.save(testVillageTwo);
    //BuildSpringEntityManager.getJpaTransactionManager().commit((TransactionStatus) testVillage);
    
   
   log.info("Test Messgae");
    SuperAdmin superAdmin=new SuperAdmin();
  //  superAdmin.setSuperAdminEmailId("admin@feesCorner.com");
  //  superAdmin.setSuperAdminName("Jackson");
  //  superAdmin.setSuperAdminPassword("25888868");
  //  superAdmin.setSuperAdminProfilePicture("Mypicture");
    ManagementInfo managementInfo =new ManagementInfo();
    managementInfo.setSuperAdmin(superAdmin);
    managementInfo.setCorrespondentEmailId("correspondentEmailId@gmail.com");
    managementInfo.setCorrespondentName("backspace");
    managementInfo.setManagementName("uninor");
    managementInfo.setManagementLocation("LossVagas");
    managementInfo.setCorrespondentId(6985);
    superAdmin.setManagementInfo(managementInfo);
    managementInfo.setSuperAdmin(superAdmin);
    //JpaTransactionManager jpaTrans= (JpaTransactionManager) BuildSpringEntityManager.getJpaTransactionManager2();
   // managementRepository.save(managementInfo);
   // SuperAdmin superAdmin2= superAdminRepository.findOne(2);
   // superAdmin2.getManagementInfo().setCorrespondentEmailId("Trigger@Gmail.com");
   // superAdmin2.setSuperAdminPassword("trigger");
   // superAdminRepository.save(superAdmin2);
    //superAdmin.getManagementInfo().setSuperAdmin(superAdmin);
//    superAdminRepository.save(superAdmin);
  //BuildSpringEntityManager.getcontainerEntityManagerFactoryBean2().getDataSource().getConnection().commit();
  return "success";
  }

  
  @RequestMapping(value="/savePerson")
  public String savePerson(@ModelAttribute("testVillage")TestVillage testVillage,ModelMap model) throws NoSuchElementException, IllegalStateException, Exception{
    Person person=new Person();
    Job job=new Job();
    JobTwo jobTwo=new JobTwo();
   // job.setId(58);
   // person.setId(22);
   // job.setCurrentWorker(person);
       /*  JpaTransactionManager jpaTransaaction= (JpaTransactionManager) BuildSpringEntityManager.getJpaTransactionManager();
    EntityManagerFactory emf=   jpaTransaaction.getEntityManagerFactory();
    EntityManager em=emf.createEntityManager();
    Session session=em.unwrap(Session.class);*/
    //job.setCurrentWorker(person);
  //   session.saveOrUpdate(job);
   //jobRepository.save(job);
   // em.persist(job);
  //  em.persist(person);
    //job.setCurrentWorker(person);
  //  person.setMyJob(job);
  //  person.setMyJob2(jobTwo);
    job.setCurrentWorker(person);
    
    jobTwo.setCurrentWorker(person);
     
   
    jobRepository.save(job);
    //person.setMyJob2(jobTwo);
   // job2Repository.save(jobTwo);
   // session.saveOrUpdate(jobTwo);
   // personRepository.save(person);
  //session.saveOrUpdate(person);
 // personRepository.save(person);
     //jobRepository.save(job);
    personRepository.save(person);
    
    return "success";
  }
  @RequestMapping(value="/checkForeign")
  public String checkForeign(){
    log.info("TEst messagae");
    com.solutiontag.entity.masterdata.ManagementInfo mangement=new com.solutiontag.entity.masterdata.ManagementInfo();
    com.solutiontag.entity.masterdata.SuperAdmin superAdmin=new com.solutiontag.entity.masterdata.SuperAdmin();
    mangement.setSuperAdmin(superAdmin);
    mangement.setCorrespondentEmailId("correspondentEmailId@gmail.com");
    mangement.setCorrespondentName("backspace");
    mangement.setManagementName("uninor");
    mangement.setManagementLocation("LossVagas");
    mangement.setCorrespondentId(6985);
    mangement.setSuperAdmin(superAdmin);
    superAdmin.setManagementInfo(mangement);
    superAdminRepository.save(superAdmin);
    managementRepository.save(mangement);
    return "success";
  }
  @RequestMapping(value="/checkOnetoOne")
  public String checkOnetoOne(){
    /* Department department=new Department();
     Student student=new Student();
     student.setDepartment(department);
     student.setName("Ramakrishnan");
     department.setName("physics");
     departmentRepo.save(department);*/
    // studentRepo.save(student);
    Student student=studentRepo.findOne(68406);
    Department department=new Department();
    //26545
    department.setName("chemistrty");
    student.setDepartment(department);
  //  departmentRepo.save(department);
    studentRepo.save(student);
     return "success";
  }
  @RequestMapping(value="/checkOnetoMany")
  public String checkOnetoMany(){
    Set<Phone> phoneSet=new HashSet<Phone>();
    Persons persons=new Persons();
    Phone phonenumber1=new Phone();
    Phone phonenumber2=new Phone();
    
    phonenumber1.setContactnumber("9288572550");
    phonenumber1.setPhonetype("2g");
    phonenumber1.setPersons(persons);
    
    phonenumber2.setContactnumber("9250589564");
    phonenumber2.setPhonetype("3g");
    phonenumber2.setPersons(persons);
    
    phoneSet.add(phonenumber1);
    phoneSet.add(phonenumber2);
    
    persons.setName("Kalyan");
    persons.setPersonPhoneNumbers(phoneSet);
    
    personsRepo.save(persons);
    
    return "success";
  }
  
}
