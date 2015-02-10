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

import com.solutiontag.entity.masterdata.SchoolMasterDataDefinition;

public class SchoolMasterDataDefinitionGenerator implements IdentifierGenerator{
  public static int incr=200;

  @Override
  public Serializable generate(SessionImplementor sessionImpl, Object obj) throws HibernateException {
    SchoolMasterDataDefinition schoolMstrDataDef=(SchoolMasterDataDefinition)obj;
    if(schoolMstrDataDef!=null){
      
    }
  //  schoolMstrDataDef.get
    incr=incr+1;
    return incr;
  }
  
}
