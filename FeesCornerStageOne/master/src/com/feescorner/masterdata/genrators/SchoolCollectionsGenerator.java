/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 6, 2015                        TODO

 */
package com.feescorner.masterdata.genrators;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.solutiontag.entity.masterdata.SchoollCollections;

public class SchoolCollectionsGenerator implements IdentifierGenerator {

  /*
   * (non-Javadoc)
   * 
   * @see org.hibernate.id.IdentifierGenerator#generate(org.hibernate.engine.spi.SessionImplementor,
   * java.lang.Object)
   */
  @Override
  public Serializable generate(SessionImplementor sessionImpl, Object generatorClassObject)
      throws HibernateException {
    SchoollCollections schoollCollections = (SchoollCollections) generatorClassObject;
    schoollCollections.getSchoolCollectionId();
    return schoollCollections.getSchoolCollectionId();
  }

}
