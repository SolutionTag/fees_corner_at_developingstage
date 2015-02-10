/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 2, 2015                        TODO

 */
package com.feescorner.masterdata.genrators;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.solutiontag.entity.masterdata.SchoolCollection;
import com.feescorner.serverstartup.dbUtils.ApplicationUtills;

public class SchoolGenerator implements IdentifierGenerator {

  @Override
  public Serializable generate(SessionImplementor sessionImpl, Object obj) throws HibernateException {
  SchoolCollection schoolCollectionObject=(SchoolCollection) obj;
  String schoolName= schoolCollectionObject.getSchoolName();
  String educationBoard= schoolCollectionObject.getEducationBoard();/*Matric,CBSE,StateBoard*/
  String stdOfEducation= schoolCollectionObject.getStandardOfEducation();
  String schoold=schoolName+educationBoard+stdOfEducation;
  schoold= schoold.concat(String.valueOf(ApplicationUtills.PIN()));
   return schoold;
  }
  
}
