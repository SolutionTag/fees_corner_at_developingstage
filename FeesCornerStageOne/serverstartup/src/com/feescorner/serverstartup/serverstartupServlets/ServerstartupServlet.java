/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 15, 2014                        TODO

 */
package com.feescorner.serverstartup.serverstartupServlets;

import java.io.File;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class ServerstartupServlet extends HttpServlet {
  public static final Logger logger = Logger.getLogger(ServerstartupServlet.class);


  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) {
    try {
      super.init(config);
      createLogFolders();
   //   initDbServices();
    } catch (ServletException servletException) {
      logger.info(servletException, servletException.fillInStackTrace());
    } catch (NullPointerException nullPointerexe) {
      logger.info(nullPointerexe, nullPointerexe.fillInStackTrace());
    }
  }

  public static void createLogFolders() throws NullPointerException {
    String folderNames[] = {"serverStartup", "masterDataModule"};
    for (int i = 0; i < folderNames.length; i++) {
      File file = new File(FeesCornerConstants.logPath + "\\" + folderNames[i]);
      if (!file.exists()) {
        file.mkdirs();
      }
    }
    DriverManagerDataSource driverManagerDataSource =new DriverManagerDataSource();
    driverManagerDataSource.setConnectionProperties(new Properties());
    
    
    
   
  }

}
