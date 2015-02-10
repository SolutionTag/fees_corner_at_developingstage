/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 25, 2014                        TODO

 */
package com.feescorner.serverstartup.dbUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.solutiontag.entity.masterdata.SchoolCollection;

public class ApplicationUtills implements IdentifierGenerator{

  public static Properties properties;
  public static Properties getDataBaseProperties;

  private static com.solutiontag.entity.masterdata.SchoolCollection schoolCollectionObject=null;
  public static Properties getPropertiesFromFile(String fileName) {
    try {
      properties = new Properties();
      File file = new File(fileName);
      FileReader fileReader = new FileReader(file);
      BufferedReader bufferdReader = new BufferedReader(fileReader);
      properties.load(bufferdReader);
    } catch (FileNotFoundException FNFException) {
    } catch (IOException IOException) {
    }
    return properties;
  }

  public static String RomanNumerals(int Int) {
    LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
    roman_numerals.put("M", 1000);
    roman_numerals.put("CM", 900);
    roman_numerals.put("D", 500);
    roman_numerals.put("CD", 400);
    roman_numerals.put("C", 100);
    roman_numerals.put("XC", 90);
    roman_numerals.put("L", 50);
    roman_numerals.put("XL", 40);
    roman_numerals.put("X", 10);
    roman_numerals.put("IX", 9);
    roman_numerals.put("V", 5);
    roman_numerals.put("IV", 4);
    roman_numerals.put("I", 1);
    String res = "";
    for (Map.Entry<String, Integer> entry : roman_numerals.entrySet()) {
      int matches = Int / entry.getValue();
      res += repeat(entry.getKey(), matches);
      Int = Int % entry.getValue();
    }
    return res;
  }

  public static String repeat(String s, int n) {
    if (s == null) {
      return null;
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(s);
    }
    return sb.toString();
  }

  /* (non-Javadoc)
   * @see org.hibernate.id.IdentifierGenerator#generate(org.hibernate.engine.spi.SessionImplementor, java.lang.Object)
   */
  @Override
  public Serializable generate(SessionImplementor arg0, Object arg1) throws HibernateException {
    
    return PIN();
  }

  public static void getDataBaseProperties(){
    getDataBaseProperties=ApplicationUtills.getPropertiesFromFile("E:/Fees_corner_confguration/dbpropertiesfiles/database.properties");
    
  }

public static int PIN() {

    int max = 99999;
    int min = 10000;

    int PIN = (int) (Math.random() * (max - min) + min);

    return PIN;
}
public static HashSet<Object> getObjectSet(){
  
  return new HashSet<Object>();
} 
//For check null in Objects
public static <T> T checkNotNull(T e){
  if(e == null){
     throw new NullPointerException();
  }
  return e;
}

public static boolean isEmpty(@SuppressWarnings("rawtypes") Collection obj) {
  return obj == null || obj.isEmpty();
}

public static boolean isEmpty(String string) {
  return string == null || string.trim().isEmpty();
}

public static boolean isEmpty(Object obj) {
  return obj == null || obj.toString().trim().isEmpty();
}
@SuppressWarnings("unchecked")
public Object getBeanFromJsonObject(String jsonObj,Object beanObject) throws JsonParseException, JsonMappingException, IOException{
  return new ObjectMapper().readValue(jsonObj, (Class<Object>)beanObject);
}



public static Timestamp getRandomTimeBetweenTwoDates () {
  long offset = Timestamp.valueOf("1989-01-01 00:00:00").getTime();
  long end = Timestamp.valueOf("1991-01-01 00:00:00").getTime();
  long diff = end - offset + 1;
  Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
  return rand;
}
  public static int randInt() {
    Random rand = new Random();
    int randomNum = rand.nextInt((10 - 0) + 1) + 0;
    return randomNum;
}


  /**
   * @return the schoolCollectionObject
   */
  public static SchoolCollection getSchoolCollectionObject() {
    return schoolCollectionObject;
  }

  /**
   * @param schoolCollectionObject the schoolCollectionObject to set
   */
  public static void setSchoolCollectionObject(SchoolCollection schoolCollectionObject) {
    ApplicationUtills.schoolCollectionObject = schoolCollectionObject;
  }

  /**
   * @return the schoolCollectionObject
   */
 public static Gson createGsonFromBuilder( ExclusionStrategy exs ){
    GsonBuilder gsonbuilder = new GsonBuilder();
    gsonbuilder.setExclusionStrategies(exs);
    return gsonbuilder.serializeNulls().create();
}
}
