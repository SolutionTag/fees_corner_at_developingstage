/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 12, 2015                        TODO

 */
package com.feescorner.academic.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;

import com.feescorner.academic.handler.AcademicHandler;
import com.feescorner.academic.services.CollectionDefinition;
import com.feescorner.serverstartup.dbUtils.ApplicationComparator;
import com.feescorner.serverstartup.dbUtils.ApplicationUtills;
import com.solutiontag.entity.academic.AcademicianInfo;
import com.solutiontag.entity.masterdata.SchoolClassSectionDefinition;
import com.solutiontag.entity.masterdata.SchoolCollection;
import com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment;
import com.solutiontag.entity.masterdata.SchoolMasterDataDefinition;
import com.solutiontag.entity.masterdata.SchoolStandardsDefnition;
import com.solutiontag.entity.masterdata.SchoolSubjectsDefinition;
import com.solutiontag.repository.academic.AcademicianInfoRepository;
import com.solutiontag.repository.academic.AcademicianStandardInfoRepository;
import com.solutiontag.repository.masterdata.SchoolClassSectionDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolCollectionRepository;
import com.solutiontag.repository.masterdata.SchoolFeesDefinitionAssignmentRepository;
import com.solutiontag.repository.masterdata.SchoolMasterDataDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolStandardsDefnitionRepository;

@Controller
@RequestMapping("/academics")
public class AcademicController {
  @Autowired
  public AcademicHandler academicHandler;
  @Autowired
  public SchoolCollectionRepository schoolCollectionRepo;
  @Autowired
  public AcademicianInfoRepository academicainInfoRepos;
  @Autowired
  public SchoolStandardsDefnitionRepository standardDefintionRepo;
  @Autowired 
  public SchoolMasterDataDefinitionRepository masterDataRepository;
  @Autowired
  public SchoolClassSectionDefinitionRepository schoolSectionRepo;
  @Autowired 
  public AcademicianStandardInfoRepository standardInfoRepository;
  @Autowired
  public SchoolFeesDefinitionAssignmentRepository feesAssignmentRepo;
  public AcademicController(){
  }
  public static int s=234005;
  public static int castId=0;
  public static int genderId=0;
  public static int villageId=0;
  public static int standardId=0;
  public static Integer[] standardArray={14237, 59943, 65272, 66904, 67361, 84758, 86240, 86848, 89214, 93299, 59020, 52911, 18958, 20769, 26491, 35255, 38920, 45231, 45694, 46884, 51126, 96811};
  public static String[] cast={"BC","MBC","SC","ST","OB"};
  public static String[] gender={"MALE","FEMALE"};
  public static String[] village={"DURUGAM","KALLAKURICHI","ULUNDURPATTAI","KEERANUR","KACHIRAPAALAYAM","EMAPAIR","NEELAMANGALAM"};
  @RequestMapping(value="/save-student",method=RequestMethod.POST)
  public String saveAcademicianInfo(@ModelAttribute("academicianInfo")AcademicianInfo academicianInfo ,ModelMap model,RedirectAttributes redirectAttributes){
   
    System.out.println("sAVE SCHOOL");
    return "redirect:/display-student-info";
  }
  @RequestMapping(value="/student-admission")
  public String lauchStudentDataScreen(Model model,HttpServletResponse res) throws InterruptedException, UnsupportedEncodingException, IOException{
  CollectionDefinition collectionDef=new CollectionDefinition();
 HashMap<Integer,  Set<SchoolFeesDefinitionAssignment>> standardFeesMap=new HashMap<Integer, Set<SchoolFeesDefinitionAssignment>>();
  Set<Integer> enabledStandardSet=standardDefintionRepo.returnEnabledStandards(true);
   Iterator<Integer> iterator= enabledStandardSet.iterator();
   while(iterator.hasNext()){
     Integer standardId= iterator.next();
     Set<SchoolFeesDefinitionAssignment>  feesDefAssignment=feesAssignmentRepo.returnFeesesForStandards(standardId);
     standardFeesMap.put(standardId, feesDefAssignment);
   }
   collectionDef.setStandardFeesMap(standardFeesMap);

     
   
    long now = System.currentTimeMillis();
    new java.sql.Date(now);
    ApplicationUtills.getSchoolCollectionObject();
    AcademicianInfo  acdemicianInfoObj=new AcademicianInfo();
  //  AcademicianStandardInfo academicianStdInfo=new AcademicianStandardInfo();
    SchoolCollection schoolCollection=schoolCollectionRepo.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
    System.out.println(schoolCollection);
/*    
    
   for(Integer key:infomap.keySet())
    {
   AcademicianInfo academicianInfoVal = infomap.get(key);
   ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
   String json = ow.writeValueAsString(academicianInfoVal);
   System.out.println(json);
    }*/
 
/*String[] studentNames =
      {"My Baby Names", "Saguna", "Khagesh", "Dhirendra", "Sushim", "Priyanka", "Mugdha",
          "Visvajit", "Gopan", "Purnima, Poornima", "Kaushik", "Uttanka", "Ninad , Ninaad",
          "Vishodhan", "Tanish", "Virbhanu", "My Baby Names", "Aadarsh", "Aadesh", "Aadhira",
          "Aadhishankar", "Aadit", "Aagman", "Aagney", "Aahva", "Aakarshan", "Aaloka", "Aashi",
          "Aashirya", "Abha", "Abhay", "Abhi", "Abhijat", "Abhijit /Abhijeet", "Abhik",
          "Abhilash", "Abhilasha", "Abhinandan", "Abhinav", "Abhinivesh", "Abhiram", "Abhiroop",
          "Gangesh", "Gangi", "Gargi", "Garima", "Garv", "Gatik", "Gaura", "Gaurang", "Gaurav",
          "Gauri", "Gaurika", "Gaurikant", "Gaurinandan", "Gaurinath", "Gaurish", "Gaurishankar",
          "Gautam", "Gautami", "Gayatri", "Geena", "Geet", "Geeti", "Gehna", "Ghanashyam",
          "Ghandeep", "Ghanendra", "Gharshit", "Ghoshal", "Giridhar", "Girija", "Girijanandan",
          "Girilal", "Giriraj", "Girish", "Gita, Geeta", "Gitanjali", "Gitika", "Godavari",
          "Gogula", "Gomati", "Gopal", "Gopan", "Gopika", "Goshanraj", "Gourangi", "Gouresh",
          "Govind", "Gowshik", "Gul", "Gulab","Gulshan", "Gunaratna", "Gunjal", "Gunjan", "Gunjita", "Gurbachan", "Gurcharan",
          "Gurdayal", "Gurdeep", "Gurjas", "Gurman", "Gurmeet", "Gurnam", "Gursharan", "Guru",
          "Gurudas", "Gurudutt", "Gyanda", "Hanita", "Hansa", "Hansaraj", "Hanshal", "Hansika",
          "Hansini", "Hansraj", "Hanuman", "Hardik", "Haresh", "Hari", "Haridutt", "Harihar",
          "Harilal", "Harina", "Harini", "Haripriya", "Harish", "Harishankar", "Harita",
          "Harith", "Harman", "Harmendra", "Harsh", "Harsh joy", "Harsha", "Harshad", "Harshal",
          "Harshika", "Harshini", "Harshita", "Harshul", "Harshvardhan", "Harsith", "Harteij",
          "Hastin", "Havish", "Heer", "Heera", "Heet", "Hema", "Hemachandra", "Hemadri", "Hemal",
          "Hemali", "Hemang", "Hemanga", "Hemangi", "Hemant", "Hemaprakash", "Hemaraj",
          "Hemavatinandan", "Hemendra", "Hemendu", "Hemkanta", "Hena", "Henna", "Heramba",
          "Himal", "Himani", "Himank", "Himanshu", "Hiral", "Hiranmay", "Hiranya", "Hiresh",
          "Hiten", "Hitendra", "Hitesh", "Hiya", "Hridayesh", "Hridaynath", "Hridyanshu",
          "Hrishikesh", "Hrithik", "Hrithikesh", "Hrydesh", "Ila", "Ilesh", "Ina", "Indeever",
          "Indira", "Indra", "Indradutt", "Indrajit", "Indrakanta", "Indrakshi", "Indraneel",
          "Indrani", "Indrayani", "Indrina", "Indu", "Indubhushan", "Induj", "Induja",
          "Indukala", "Indukant", "Indukanta", "Indumati", "Indumukhi", "Induprabha",
          "Indushekhar", "Inesh", "Ipsa", "Ipsita", "Ira", "Iram", "Iravan", "Iravati", "Iresh",
          "Irit", "Isha", "Ishan", "Ishana", "Ishani", "Ishanvi", "Ishir", "Ishita", "Ishpreet",
          "Ishrit", "Ishta", "Ishver", "Ishwar", "My Baby Names", "Ishwari", "Ishwarya", "Iti",
          "Iyla", "Jagadeep", "Jagadeesh", "Jagajeet", "Jagajeevan", "Jagamohan", "Jagan",
          "Jaganarayan", "Jagannath", "Jagatbehari", "Jagatkishor", "Jagatpal", "Jagatprabhu",
          "Jagatprakash", "Jagatveer", "Jagriti", "Jahi", "Jahnavi", "Jaidev", "Jainil",
          "Jaithra", "Jakarious", "Jalaja", "Jalbhushan", "Jaldev", "Jaldhar", "Jalendu",
          "Jamini", "Jamuna", "Janak", "Janaki", "Janakibhushan", "Janakinath", "Janakiraman",
          "Janam", "Janani", "Janardan", "Janesh", "Janhavi", "Janmesh", "Japendu", "Japesh",
          "Jashith", "Jaskaran", "Jasraj", "Jasveer","Jaswant", "Jatin", "Javesh", "Jawahar", "Jay", "Jaya", "Jayachand", "Jayadeep",
          "Jayaditya", "Jayani", "Jayant", "Jayanti", "Jayapal", "Jayaprabha", "Jayaprada",
          "Jayaprakash", "Jayashekhar", "Jayashri", "Jayasudha", "Jayawant", "Jayita", "Jaypal",
          "Jaysukh", "Jeethesh", "Jeevan", "Jeevana", "Jeevika", "Jhalak", "Jharna", "Jheel", "Jhilmil", "Jigyasa", "Jilesh",
          "Jimuta", "Jinendra", "Jinesh", "Jishnu", "Jiten", "Jitendra", "Jivana", "Jivanta",
          "Jivin", "Jnyandeep", "Jnyaneshwar", "Jogindra", "Jograj", "Joshika", "Joshita",
          "Jovan", "Juhi", "JuilyAdd", "JwalaprasadAdd", "JyotiAdd", "JyotikaAdd",
          "JyotiprakashAdd", "JyotiranjanAdd", "JyotirdharAdd", "JyotsnaAdd", "KaavyaAdd",
          "KadambariAdd", "KadambiniAdd", "KailashAdd", "KailasnathAdd", "KaishoriAdd",
          "Kajal, KajolAdd", "KajjaliAdd", "KajriAdd", "KalaAdd", "KaladharAdd", "KalanAdd",
          "KalanathAdd", "KalanidhiAdd", "KalavatiAdd", "KaliAdd", "KalicharanAdd",
          "KalidasAdd", "KalikaAdd", "KalikeshAdd", "KalindiAdd", "KalkinAdd", "KalloleeAdd",
          "KalpakAdd", "KalpanaAdd", "KalpanathAdd", "KalpitaAdd", "KalyanAdd", "KalyaniAdd",
          "KamadevAdd", "KamakshiAdd", "KamalAdd", "KamalaAdd", "KamalakarAdd", "KamalakshAdd",
          "KamalakshiAdd", "KamalbandhuAdd", "KamaleshAdd", "KamalikaAdd", "KamaliniAdd",
          "KamalkantAdd", "KamalnathAdd", "KamalnayanAdd", "KamanaAdd", "KambojAdd", "KaminiAdd",
          "KamlapatiAdd", "KamleshAdd", "KamnaAdd", "KamnikaAdd", "KamranAdd", "KamyaAdd",
          "KanakAdd", "Kanak, KanakaAdd", "KanakpriyaAdd", "KananAdd", "KanchanAdd", "KanchiAdd",
          "KanhaAdd", "KanhaiAdd", "KanhaiyaAdd", "KanikaAdd", "KanishkAdd", "KanishkaAdd",
          "KantaAdd", "KanthamaniAdd", "KantiAdd", "KanupriyaAdd", "KapaaliAdd", "KapiAdd",
          "KapidhwajAdd", "KapilAdd", "KapilaAdd", "KapilashwaAdd", "KapindraAdd", "KapirathAdd",
          "KareenaAdd", "KarishmaAdd", "Karna, KaranAdd", "KarnabhushanAdd", "KarnajeetAdd",
          "KarnapriyaAdd", "KartheekAdd", "KartikAdd", "KartikeyAdd", "KartikeyaAdd",
          "Kartikeya SubramanyamAdd", "KarunaAdd", "KarunakarAdd", "Karunanidhi", "Kashi",
          "Kashika", "Kashinath", "Kashish", "Kashmira", "Kashvi", "Kashyapi", "Kasturi",
          "Kathit", "Katyayani", "Kaushal", "Kaushalya", "Kaushik", "Kavana", "Kavi", "Kavika",
          "Kavita", "Kayaan", "Kaylor", "Kedar", "Kedarnath", "Keerthinath", "Kerani", "Kesari",
          "Keshav", "Keshi", "Keshika", "Keshini", "Ketaki", "Ketan", "Ketana", "Keval", "Keya",
          "Khagendra", "Khagesh", "Kharanshu", "Khush", "Khushboo", "Khushi", "Khushwant",
          "Khyati", "Kiash", "Kimaayra", "Kimaya", "Kinnar", "Kinshuk", "Kintan", "Kiran",
          "Kirit", "Kiritmani", "Kirtan", "Kirti", "Kirtibhushan", "Kirtivallabh", "Kishan", "Kishlaya",
          "Kishore", "Kishori", "Kokila", "Komal", "Kopal", "Koundinya", "Koyal", "Kranti",
          "Kripa", "Kripanidhi", "Kripasagar", "Krishav", "Krishna", "Krishnamoorti", "Krithik",
          "Kritika", "Krittika", "Krunal", "Krupal", "Kruthika", "Kshanika", "Kshiraj",
          "Kshitidhar", "Kshitij", "Kuldeep", "Kuldev", "Kulvir", "Kumari", "Kumkum", "Kumud",
          "Kunal", "Kundan", "Kunjabehari", "Kuntal", "Kunti", "Kunwar", "Kusagra", "Kush",
          "Kushad", "Kushagra", "Kushal", "Maitreya", "Maitri", "Makarand", "Makshi", "Mala",
          "Malati", "Malavika", "Malhar", "Malini", "Mallika", "Manali", "Manana",
          "Manasa, Maanasa", "Manasi", "Manavendra", "Mandakini", "Mandeep", "Mandhatri",
          "Mandira", "Mandodari", "Maneet", "Manendra", "Mangal", "Mangala", "Mangesh", "Mani",
            "Manibhushan", "Manidhar", "Manik", "Manikandan",
          "Manindra", "Maniram", "Manish", "Manisha", "Manishankar", "Manivannan", "Manjari",
          "Manjeet", "Manjika", "Manju", "Manjughosh", "Manjula", "Manjunath", "Manjusha",
          "Manjusri", "Manmohan", "Manohar", "Manoj",
          "Manoop", "Manorama", "Manoranjan", "Manpal", "Manprasad", "Mansukh", "Manthan",
          "Manu", "Manuraj", "Manushri", "Manvi", "Manvir", "Manvit", "Manyu", "Mareechi",
          "Markandeya", "Martand", "Marudeva", "Maruti", "Matanga", "Matangi", "Matheysh",
          "Matsendra", "Maulik", "Mausumi, Maushmi",
          "Maya", "Mayank", "Mayon", "Mayur", "Mayuri", "Medha", "Medhansh", "Meena",
          "Meenakshi", "Meera", "Megha", "Meghdutt", "Meghna", "Meghnad", "Meghraj", "Megraj",
          "Mehaan", "Mehtab", "Mehul", "Menka"
          };
    
  for(int student=0;student<studentNames.length;student++){
   java.sql.Date date= new java.sql.Date(ApplicationUtills.getRandomTimeBetweenTwoDates().getTime());
   java.util.Date today = new java.util.Date();
   java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());
   acdemicianInfoObj=new AcademicianInfo();
   // academicianStdInfo=new AcademicianStandardInfo();
    String fullname=studentNames[student].substring(0,1)+" "+studentNames[student];
    acdemicianInfoObj.setAcademicianFirstName(studentNames[student]);
    acdemicianInfoObj.setAcademicianDob(date);
    acdemicianInfoObj.setAcademicianLastName(studentNames[student].substring(0,1));
    acdemicianInfoObj.setAcademicianNationality("INDIAN");
    acdemicianInfoObj.setAcademicianName(fullname);
    acdemicianInfoObj.setAcademicianCategory(cast[castId]);
    acdemicianInfoObj.setAcademicianAdmissionDate(timestamp);
    acdemicianInfoObj.setAcademicianGender(gender[genderId]);
    acdemicianInfoObj.setAcademicianFrom(village[villageId]);
    acdemicianInfoObj.setAcademicanStandardId(standardArray[standardId]);
     Integer mapkeyid=acdemicianInfoObj.getCompareId();
    acdemicianInfoObj.setSchoolCollection(schoolCollection);
    schoolCollection.getAcadeinfo().put(mapkeyid, acdemicianInfoObj);
    academicainInfoRepos.save(acdemicianInfoObj);
    academicianStdInfo.setAcademicanStandardId();
    academicianStdInfo.setAcademicyear(new Date(System.currentTimeMillis()));
    academicianStdInfo.setAcdemicianInfo(acdemicianInfoObj);
    
    //se(ApplicationUtills.RomanNumerals(ApplicationUtills.randInt()));
    //schoolCollectionRepo.saveAndFlush(schoolCollection);
    
   // schoolCollection.getAcademicianInfoMap().put(acdemicianInfotwo.getAcademicianId(), acdemicianInfotwo);
  //  schoolCollectionRepo.save(schoolCollection);
    s++;
    
    castId++;
   
    villageId++;
    standardId++;
    
    
  
    if(castId>4){
      castId=0;
    }
    if(villageId>6){
      villageId=0;
    }
    if(standardId>13){
      standardId=0;
      genderId++;
      if(genderId>1){
        genderId=0;
      }
    
    }
    }*/
   // SchoolMasterDataDefinition schoolMasterDataDefinition =masterDataRepository.findOne("RAVI SCHOOLCBSEPRE-PRIMARY46196");
  model.addAttribute("schoolMasterDataDefinition", schoolCollection.getSchoolMasterData());
  model.addAttribute("academicianInfo", new AcademicianInfo());
  model.addAttribute("collectionDef", collectionDef); 
    //model.addAttribute("academicianAddress", academicanInfo.getAcademicianAddress());
  ///  model.addAttribute("academicianPreviousSchoolDetails", academicanInfo.getAcademicianPreviousSchoolDetails());
  return "admissionscreen";
 }

  @RequestMapping(value="student-operations",method=RequestMethod.GET)
  public String academicanClassAssign(Model model,HttpServletRequest request, HttpServletResponse resp) {
    SchoolMasterDataDefinition schoolMasterDataDefinition=masterDataRepository.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
 Set< AcademicianInfo> academicianInfo  =academicainInfoRepos.findByacademicanStandardId(20999);
 System.out.println(academicianInfo);
  //  Set<AcademicianStandardInfo> academicianStandardList = standardInfoRepository.returnStudentStandardsSet(62208);
   // System.out.println(academicianStandardList.size() );
    model.addAttribute("schoolMasterDataDefinition",schoolMasterDataDefinition);
    model.addAttribute("subjectDefintion",new SchoolSubjectsDefinition());
    return "academicianoperation";
  }
  @SuppressWarnings("unchecked")
  @RequestMapping(value="/standard/{standardid}",method=RequestMethod.POST)
  public String returnAcademiciansAgainstStandards(@PathVariable("standardid") Integer standardid, Model model,HttpServletRequest request,HttpServletResponse resp){
    CollectionDefinition setDef=new CollectionDefinition();
    SchoolMasterDataDefinition schoolMasterDataDefinition=masterDataRepository.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
    Set<AcademicianInfo> academicianInfo = new HashSet<AcademicianInfo>(academicainInfoRepos.findByacademicanStandardId(standardid)); //standardInfoRepository.returnStudentStandardsSet(standardid);
    List<AcademicianInfo> academicianInfoList=new ArrayList<AcademicianInfo>(academicianInfo);
    Collections.sort(academicianInfoList,ApplicationComparator.studentAdmissionDateComparator);
    setDef.setAcademicianInfoSet(academicianInfo);
    setDef.setAcademicianInfoList(academicianInfoList);
    model.addAttribute("schoolMasterDataDefinition",schoolMasterDataDefinition);
    model.addAttribute("subjectDefintion",new SchoolSubjectsDefinition());
    model.addAttribute("setDef",setDef);
    
   
    return "academicianoperation";
  }
  @RequestMapping(value="/sectionAllocation",method=RequestMethod.POST)
  public String sectionAllocation(@RequestParam String wrappedData, Model model,HttpServletRequest request,HttpServletResponse response) throws JSONException{
    CollectionDefinition setDef=new CollectionDefinition();
    SchoolCollection schoolCollection= schoolCollectionRepo.findOne("akt matrichigher secondary schoolCBSEPRE-PRIMARY64067");
     Map<Integer,AcademicianInfo> academicianInfoMap=schoolCollection.getAcadeinfo();
     
    JSONObject sectionwiseStudents=new JSONObject(wrappedData);
    Iterator<String> iterator= sectionwiseStudents.keys();
    while(iterator.hasNext()){
       Integer sectionId=Integer.parseInt(iterator.next());
       SchoolClassSectionDefinition classSection= schoolSectionRepo.findOne(sectionId);
    JSONArray academicianCompareIds=   sectionwiseStudents.getJSONArray(sectionId.toString());
    for(int i=0;i<academicianCompareIds.length();i++){
     
       Integer compareId=(Integer) academicianCompareIds.get(i);
       AcademicianInfo academicianInfo= academicianInfoMap.get(compareId);
       academicianInfo.setAcademicianSectionId(classSection.getSectionId());
       academicianInfo.setAcademicianSectionName(classSection.getSectionName());
       academicainInfoRepos.saveAndFlush(academicianInfo);
    }
      // sectionwiseStudents.getInt(sectionId);
    }
    model.addAttribute("schoolMasterDataDefinition",schoolCollection.getSchoolMasterData());
    model.addAttribute("subjectDefintion",new SchoolSubjectsDefinition());
    model.addAttribute("setDef",setDef);
    return "academicianoperation";
  }
  @RequestMapping(value="new-academician-entry")
  public String newacademicianentry(@ModelAttribute("academicianInfo") AcademicianInfo academicianInfo,HttpServletRequest request,HttpServletResponse response,Model model) {
    java.util.Date today = new java.util.Date();
    java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());
    academicianInfo.setAcademicianAdmissionDate(timestamp);
    System.out.println("clean"+academicianInfo);
    
    return "";
  }
}
