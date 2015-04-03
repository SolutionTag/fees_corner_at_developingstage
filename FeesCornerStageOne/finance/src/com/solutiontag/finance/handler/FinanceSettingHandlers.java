/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Feb 27, 2015                        TODO

 */
package com.solutiontag.finance.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.josql.Query;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.solutiontag.cqengine.indexdefinition.SchoolFeesDefinitionAssignmentIndexDefinition;
import com.solutiontag.entity.finance.FeesTermsElementsArrangements;
import com.solutiontag.entity.masterdata.SchoolClassSectionDefinition;
import com.solutiontag.entity.masterdata.SchoolFeesDefinition;
import com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment;
import com.solutiontag.entity.masterdata.SchoolStandardsDefnition;
import com.solutiontag.entity.masterdata.SchoolTermDefinition;
import com.solutiontag.entity.masterdata.SchoolVocationalGroupDefinitionAssignment;
import com.solutiontag.entity.masterdata.TermFrequency;
import com.solutiontag.repository.masterdata.SchoolFeesDefinitionAssignmentRepository;
import com.solutiontag.repository.masterdata.SchoolFeesDefinitionRepository;
import com.solutiontag.repository.masterdata.SchoolStandardsDefnitionRepository;
import com.solutiontag.repository.masterdata.SchoolTermDefinitionRepository;

@Component
public class FinanceSettingHandlers {
  
  @Autowired
  public SchoolStandardsDefnitionRepository standardDefRepository;
  @Autowired
  public SchoolFeesDefinitionAssignmentRepository feesDefinitionAssignmentRepository;
  @Autowired
  public SchoolFeesDefinitionAssignmentIndexDefinition feesDefinitionAssignmentIndexDefinition;
  @Autowired
  public SchoolTermDefinitionRepository schoolTermDefinitionRepository;
  @Autowired
  public SchoolFeesDefinitionRepository schoolFeesDefRepo;
  
  public boolean saveStandardFeesParticualrs(JSONObject eachSectionfeesparticulars,Integer standardId){
    SchoolStandardsDefnition stdDefObj= standardDefRepository.findOne(standardId);
    SchoolClassSectionDefinition classSection=null;
    List<SchoolClassSectionDefinition> classSectionList=new ArrayList<SchoolClassSectionDefinition>(stdDefObj.getSectionSet());
     @SuppressWarnings("unchecked")
   // Set<Integer> sectionIds= eachSectionfeesparticulars.keySet();
      Iterator<String> sectionIterator= eachSectionfeesparticulars.keys();
     while(sectionIterator.hasNext()){
       Integer sectionId= Integer.parseInt( sectionIterator.next());
       classSection=new SchoolClassSectionDefinition();
       SchoolFeesDefinitionAssignment schoolFeesDefAssignment=null;
       classSection.setCompareId(sectionId);
       int index=  classSectionList.indexOf(classSection);
       classSection= classSectionList.get(index);
      JSONArray sectionFeesArray=  eachSectionfeesparticulars.getJSONArray(String.valueOf(sectionId));
       List<SchoolFeesDefinitionAssignment> feesDefinitionAssignmentList=new ArrayList<SchoolFeesDefinitionAssignment>(classSection.getSchoolFeesDefinitionAssignmentSet());   
       int length= sectionFeesArray.length();
       for(int i=0;i<length;i++){
         schoolFeesDefAssignment=new SchoolFeesDefinitionAssignment();
         JSONObject  feesInfoObj= (JSONObject) sectionFeesArray.get(i);
         Integer feesCompareId=feesInfoObj.getInt("compareId");
         schoolFeesDefAssignment.setCompareId(feesCompareId);
         int indexid=   feesDefinitionAssignmentList.indexOf(schoolFeesDefAssignment);
         schoolFeesDefAssignment=feesDefinitionAssignmentList.get(indexid);
         schoolFeesDefAssignment.setFeesAmount(Float.parseFloat(feesInfoObj.getString("feesAmount")));
        /* schoolFeesDefAssignment.setTermAmount(Float.parseFloat(feesInfoObj.getString("termAmount")));
         schoolFeesDefAssignment.setMonthAmount(Float.parseFloat(feesInfoObj.getString("monthAmount")));
         schoolFeesDefAssignment.setTermAmountPercentage(Float.parseFloat(feesInfoObj.getString("termAmountPercentage")));
         schoolFeesDefAssignment.setMonthAmountPercentage(Float.parseFloat(feesInfoObj.getString("monthAmountPercentage")));
         schoolFeesDefAssignment.setDueAmountforFees(Float.parseFloat(feesInfoObj.getString("dueAmountforFees")));*/
       }
     }
     standardDefRepository.saveAndFlush(stdDefObj);
    return false;
  }
 public FeesTermsElementsArrangements getfeesTermElementArrangement(Set<SchoolStandardsDefnition> standardDefSet) 
 {
   Map<Integer,Map<Integer,Map<Integer,  Map<Integer,List<SchoolFeesDefinitionAssignment>> >>> feesByStandard=new HashMap<Integer, Map<Integer,Map<Integer,  Map<Integer,List<SchoolFeesDefinitionAssignment>> >>>();
   Map<Integer,Map<Integer,  Map<Integer,List<SchoolFeesDefinitionAssignment>> >> feesBySection=new HashMap<Integer, Map<Integer,  Map<Integer,List<SchoolFeesDefinitionAssignment>> >>();
   Map<Integer,  Map<Integer,List<SchoolFeesDefinitionAssignment>> > feesByTerm=new HashMap<Integer,  Map<Integer,List<SchoolFeesDefinitionAssignment>> >();
   Map<Integer,List<SchoolFeesDefinitionAssignment>> feesByFreqId=new HashMap<Integer, List<SchoolFeesDefinitionAssignment>>();
   //Set<SchoolFeesDefinitionAssignment> feesDefSet=new HashSet<SchoolFeesDefinitionAssignment>();
   Map<Integer,Map<Integer, Map<Integer,Set<SchoolFeesDefinition>>>> assignedFeesStd=new HashMap<Integer, Map<Integer,Map<Integer,Set<SchoolFeesDefinition>>>>();
   Map<Integer, Map<Integer,Set<SchoolFeesDefinition>>> assignedFeesSection=new HashMap<Integer, Map<Integer,Set<SchoolFeesDefinition>>>();
   Map<Integer,Set<SchoolFeesDefinition>> assignedFeesTerm=new HashMap<Integer, Set<SchoolFeesDefinition>>();
    
   FeesTermsElementsArrangements feesTermElement=new FeesTermsElementsArrangements();
    List<SchoolFeesDefinitionAssignment> beforeFilterFeesAssignment= feesDefinitionAssignmentRepository.findAll();
    List<SchoolTermDefinition> termDefList=schoolTermDefinitionRepository.findAll();
    List<SchoolFeesDefinition> feesDefinitionList=schoolFeesDefRepo.findAll();
    
   
    Iterator<SchoolStandardsDefnition> standardSetIterator= standardDefSet.iterator();
    Set<SchoolTermDefinition> availableTerms=null;
    while(standardSetIterator.hasNext()){
    SchoolStandardsDefnition standardDef=   standardSetIterator.next();
    feesBySection=new HashMap<Integer, Map<Integer,  Map<Integer,List<SchoolFeesDefinitionAssignment>> >>();
    feesByTerm=new HashMap<Integer,  Map<Integer,List<SchoolFeesDefinitionAssignment>> >();
    feesByFreqId=new HashMap<Integer, List<SchoolFeesDefinitionAssignment>>();
    availableTerms=new HashSet<SchoolTermDefinition>();
    assignedFeesSection=new HashMap<Integer, Map<Integer,Set<SchoolFeesDefinition>>>();
    assignedFeesTerm=new HashMap<Integer, Set<SchoolFeesDefinition>>();
    Integer standardId= standardDef.getStandardId();
    try{
      if(standardDef.isGroupassigned()==true && standardDef.getSectionSet().size() ==0 ){
        Set<SchoolVocationalGroupDefinitionAssignment> vocationalGroupSet= standardDef.getGroupSet();
        Iterator<SchoolVocationalGroupDefinitionAssignment> vocationalGroupIterator= vocationalGroupSet.iterator();
        while(vocationalGroupIterator.hasNext()){
        SchoolVocationalGroupDefinitionAssignment groupDefAssignment=vocationalGroupIterator.next();
       // sectionFees=new HashMap<Integer, Map<Integer,Map<Integer,Set<SchoolFeesDefinitionAssignment>>>>();
       // termFees=new HashMap<Integer, Map<Integer,Set<SchoolFeesDefinitionAssignment>>>();
       // feesByFreqId=new HashMap<Integer, Set<SchoolFeesDefinitionAssignment>>();
       // availableTerms=new HashSet<SchoolTermDefinition>();
        Integer vocationGroupId= groupDefAssignment.getGroupId();
        Query query1=new Query();
        String findbyStdIdandGroupId="select * from  com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment where standardId="+standardId+" and vocationalGroupId="+vocationGroupId+" ";
        query1.parse(findbyStdIdandGroupId);
        List<SchoolFeesDefinitionAssignment> filterdByStdIdandGroupId= query1.execute(beforeFilterFeesAssignment);
        Iterator<SchoolClassSectionDefinition> classSectionIterator=groupDefAssignment.getSectionSet().iterator();
        if(filterdByStdIdandGroupId.size()!=0){
          while (classSectionIterator.hasNext()) {
            SchoolClassSectionDefinition classSection = classSectionIterator.next();
            Set<SchoolTermDefinition> termDefSet=new HashSet<SchoolTermDefinition>(termDefList);
            Iterator<SchoolTermDefinition> termDefSetIterator=termDefSet.iterator();
            Integer sectionId= classSection.getCompareId();
            Query query2=new Query();
            String findbySectiondId="select * from  com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment where standardId="+standardId+" and vocationalGroupId="+vocationGroupId+" and  schoolClassSection.compareId="+sectionId+"  ";
            query2.parse(findbySectiondId);
            List<SchoolFeesDefinitionAssignment> filterdBySectionId=   query2.execute(filterdByStdIdandGroupId);
            feesByTerm=new HashMap<Integer,  Map<Integer,List<SchoolFeesDefinitionAssignment>> >();
            if(filterdBySectionId.size()!=0)
            {
              assignedFeesTerm=new HashMap<Integer, Set<SchoolFeesDefinition>>();
                while(termDefSetIterator.hasNext()){
                  SchoolTermDefinition termDef=  termDefSetIterator.next();
                  Query query3=new Query();
                  Integer termId= termDef.getCompareId();
                  String findByTermId=" select DISTINCT * from com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment" +
                      " where termId="+termId+" and standardId="+standardId+" and vocationalGroupId="+vocationGroupId+" and schoolClassSection.compareId="+sectionId+" ";
                  query3.parse(findByTermId);
                  List<SchoolFeesDefinitionAssignment> filterdByTermId=  query3.execute(filterdBySectionId);
                        if(filterdByTermId!=null && filterdByTermId.size()!=0){
                          feesByFreqId=new HashMap<Integer, List<SchoolFeesDefinitionAssignment>>();
                        availableTerms.add(termDef);
                        Set<SchoolFeesDefinition> assignedFeeses=  findDulicate(filterdByTermId, feesDefinitionList);
                        assignedFeesTerm.put(termId, assignedFeeses);
                        Iterator<TermFrequency> termFrequencyIterator= termDef.getTermFrequencySet().iterator();
                        while (termFrequencyIterator.hasNext()) {
                          TermFrequency termFrequency = termFrequencyIterator.next();
                          Query query4=new Query();
                          List<SchoolFeesDefinitionAssignment>   feesDefSet=new ArrayList<SchoolFeesDefinitionAssignment>();
                          Integer frequencyId = termFrequency.getCompareId();
                          String findByFrequencyId="select * from com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment " +
                              "where termId="+termId+" and  standardId="+standardId+" and vocationalGroupId="+vocationGroupId+" and termFrequencyId="+frequencyId+" and schoolClassSection.compareId="+sectionId+" ";
                          query4.parse(findByFrequencyId);
                          List<SchoolFeesDefinitionAssignment> feesAssignmentList= query4.execute(filterdByTermId);
                          for(SchoolFeesDefinitionAssignment feesObj:feesAssignmentList){
                            feesDefSet.add(feesObj);
                          }
                          feesByFreqId.put(frequencyId, feesDefSet);
                        }
                        feesByTerm.put(termId, feesByFreqId);
                      }
                }
            }
            feesBySection.put(sectionId, feesByTerm);
            assignedFeesSection.put(sectionId, assignedFeesTerm);
          }
          
        }
        feesByStandard.put(vocationGroupId, feesBySection);
        feesTermElement.getAvailableTermsForStdandards().put(standardId, availableTerms);
        assignedFeesStd.put(vocationGroupId, assignedFeesSection);
        }
      }else{
        Query query1=new Query();
        String findbyStdId="select * from  com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment where standardId="+standardId+"  ";
        query1.parse(findbyStdId);
        List<SchoolFeesDefinitionAssignment> filterdByStdId= query1.execute(beforeFilterFeesAssignment);
        System.out.println(filterdByStdId.size());
        Iterator<SchoolClassSectionDefinition> classSectionIterator=standardDef.getSectionSet().iterator();
        if(filterdByStdId.size()!=0)
        {
            while (classSectionIterator.hasNext()) {
              SchoolClassSectionDefinition classSection = classSectionIterator.next();
              Set<SchoolTermDefinition> termDefSet=new HashSet<SchoolTermDefinition>(termDefList);
              Iterator<SchoolTermDefinition> termDefSetIterator=termDefSet.iterator();
              Integer sectionId= classSection.getCompareId();
              Query query2=new Query();
              String findbySectiondId="select * from  com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment where standardId="+standardId+" and  schoolClassSection.compareId="+sectionId+"  ";
              query2.parse(findbySectiondId);
              List<SchoolFeesDefinitionAssignment> filterdBySectionId=   query2.execute(filterdByStdId);
              feesByTerm=new HashMap<Integer,  Map<Integer,List<SchoolFeesDefinitionAssignment>> >();
              if(filterdBySectionId.size()!=0)
              {
                assignedFeesTerm=new HashMap<Integer, Set<SchoolFeesDefinition>>();
                  while(termDefSetIterator.hasNext())
                  {
                    SchoolTermDefinition termDef=  termDefSetIterator.next();
                    Query query3=new Query();
                    Integer termId= termDef.getCompareId();
                    String findByTermId=" select DISTINCT * from com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment" +
                        " where termId="+termId+" and standardId="+standardId+"  and schoolClassSection.compareId="+sectionId+" ";
                    query3.parse(findByTermId);
                    if(775739646==sectionId){
                      System.out.println("place");
                    }
                    List<SchoolFeesDefinitionAssignment> filterdByTermId=  query3.execute(filterdBySectionId);
                          if(filterdByTermId!=null && filterdByTermId.size()!=0){
                            feesByFreqId=new HashMap<Integer, List<SchoolFeesDefinitionAssignment>>();
                          availableTerms.add(termDef);
                          
                          Set<SchoolFeesDefinition> assignedFeeses=  findDulicate(filterdByTermId, feesDefinitionList);
                          assignedFeesTerm.put(termId, assignedFeeses);
                          Iterator<TermFrequency> termFrequencyIterator= termDef.getTermFrequencySet().iterator();
                          while (termFrequencyIterator.hasNext()) {
                            TermFrequency termFrequency = termFrequencyIterator.next();
                            Query query4=new Query();
                            List<SchoolFeesDefinitionAssignment>   feesDefSet=new ArrayList<SchoolFeesDefinitionAssignment>();
                            Integer frequencyId = termFrequency.getCompareId();
                            String findByFrequencyId="select * from com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment " +
                                "where termId="+termId+" and  standardId="+standardId+" and termFrequencyId="+frequencyId+" and schoolClassSection.compareId="+sectionId+" ";
                            query4.parse(findByFrequencyId);
                            List<SchoolFeesDefinitionAssignment> feesAssignmentList= query4.execute(filterdByTermId);
                          /*  for(SchoolFeesDefinitionAssignment feesObj:feesAssignmentList){
                              feesDefSet.add(feesObj);
                            }*/
                            int i=0;
                            Query query5=new Query();
                            for(SchoolFeesDefinition schoolFeesDef:assignedFeeses){
                              Integer baseFeesId=schoolFeesDef.getCompareId();
                              String findBybaseFeesid="select * from com.solutiontag.entity.masterdata.SchoolFeesDefinitionAssignment where baseFeesId="+baseFeesId+" ";
                              query5.parse(findBybaseFeesid);
                              List<SchoolFeesDefinitionAssignment> feesAssignmentByOrder=   query5.execute(feesAssignmentList);
                              feesDefSet.add(feesAssignmentByOrder.get(0));
                              i++;
                            }
                            feesByFreqId.put(frequencyId, feesDefSet);
                          }
                          feesByTerm.put(termId, feesByFreqId);
                        }
                  }
                 
              }
              feesBySection.put(sectionId, feesByTerm);
              assignedFeesSection.put(sectionId, assignedFeesTerm);
            }
        }
        feesByStandard.put(standardId, feesBySection);
        feesTermElement.getAvailableTermsForStdandards().put(standardId, availableTerms);
        assignedFeesStd.put(standardId, assignedFeesSection);
      }
      

    }
    catch(QueryParseException queryParse ){
      queryParse.printStackTrace();
    }
    catch(QueryExecutionException querExecution){
      querExecution.printStackTrace();
    }
   
  
   }
   
    feesTermElement.setStandardFee(feesByStandard);
    feesTermElement.setAssignedFeesStd(assignedFeesStd);
   return feesTermElement;
 }
  
 public  Map<Integer, Map<Integer, Map<Integer,Set<SchoolFeesDefinitionAssignment>>>> getSectionFeesMap(Integer standardId,Integer vocationalGroupId,boolean isgroupAssigned){
   Map<Integer, Map<Integer, Map<Integer,Set<SchoolFeesDefinitionAssignment>>>> sectionFees=new HashMap<Integer, Map<Integer,Map<Integer,Set<SchoolFeesDefinitionAssignment>>>>();
   return sectionFees;
   
 }

 public Set<SchoolFeesDefinition> findDulicate(List<SchoolFeesDefinitionAssignment> originalSet,List<SchoolFeesDefinition> feesDefnitionList)
 {
  
   Set<SchoolFeesDefinition> result = new HashSet<SchoolFeesDefinition>();
   Set<Integer> titles = new HashSet<Integer>();

   for( SchoolFeesDefinitionAssignment item : originalSet ) {
     if(96300399==item.getBaseFeesId()){
       System.out.println();
     }
       if( titles.add(item.getBaseFeesId())) {
         SchoolFeesDefinition feesDefObj=new SchoolFeesDefinition();
         feesDefObj.setCompareId(item.getBaseFeesId());
         int pos= feesDefnitionList.indexOf(feesDefObj);
         if(pos!=-1){
           feesDefObj=  feesDefnitionList.get(pos);
           result.add(feesDefObj );
         }
       }
   }
  return result;
 }
}




/*Iterator<SchoolFeesDefinitionAssignment>  feesIterator=resultSet.iterator();
while(feesIterator.hasNext()){
 SchoolFeesDefinitionAssignment defobj= feesIterator.next();
 System.out.println("section Name: "+defobj.getSectionName()+" Period: "+defobj.getPeriod()+" Term Type :"+defobj.getTermtType()+"   fees Name "+defobj.getFeesName());
}*/
