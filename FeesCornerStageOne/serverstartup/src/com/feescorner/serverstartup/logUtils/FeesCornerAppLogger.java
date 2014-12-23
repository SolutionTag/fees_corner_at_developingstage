/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan     Dec 15, 2014    InitialVersion                   TODO

 */
package com.feescorner.serverstartup.logUtils;

import java.io.IOException;
import java.io.Serializable;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;

public class FeesCornerAppLogger implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  public static  Logger masterMddulelogger = null;

 public static  Logger logger = null;
 public static  Logger principalModulelogger = null;
 public static  Logger studentModulelogger = null;
 public static  Logger teacherModulelogger = null;
 public static  Logger feesModulelogger = null;
 //public static  Logger  = null;

  protected FeesCornerAppLogger(String name) {
    logger = Logger.getLogger(name);

  }

  protected FeesCornerAppLogger(Class<?> className) {
    logger = Logger.getLogger(className);
  }

 
  public static void masterDataModuleLogger(Class<?> className) throws IOException{
    Layout layout=new CustomHtmlLayout();
    String fileName="/principalModuleLogger.html";
    FileAppender fileAppender=new FileAppender(layout,fileName,true);
    masterMddulelogger.addAppender(fileAppender);
   
  }
  


}
