import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentityGenerator;

import com.solutiontag.entity.test.Person;

/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 30, 2014                        TODO

 */

public class CustomIdGenerator extends IdentityGenerator{
  
  public Serializable generate(SessionImplementor session, Object obj) throws HibernateException {

      if ((((Person) obj).getId()) == null) {
          Serializable id = super.generate((org.hibernate.engine.spi.SessionImplementor) session, obj) ;
          return id;
      } else {
          return ((Person) obj).getId();

      }

}
  
}
