/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 21, 2014                        TODO

 */
package com.feescorner.serverstartup.dbUtils;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "getcontainerEntityManagerFactoryBean", 
transactionManagerRef = "getJpaTransactionManager",basePackages = {"com.feescorner.masterdata.test.dao"})
public class BuildSpringEntityManager {

  BuildSpringEntityManager(){
    
    System.out.println("CONSTRUCTOR cALLING");
    
  }
  
  @Value("${init-db:false}")
  private String initDatabase;
  private static final DriverManagerDataSource DRIVER_MANAGER_DATA_SOURCE =
      new DriverManagerDataSource();;
  private static final HibernateJpaVendorAdapter HIBERNATE_JPA_VENDOR_ADAPTER =
      new HibernateJpaVendorAdapter();
  private static final HibernateJpaDialect HIBERNATE_JPA_DIALECT = new HibernateJpaDialect();
  private static final JpaTransactionManager JPA_TRANSACTION_MANAGER = new JpaTransactionManager();
  private static final LocalContainerEntityManagerFactoryBean LOCAL_CONTAINER_ENTITY_MANAGER_FACTORY_BEAN=new LocalContainerEntityManagerFactoryBean();
  private static final Properties jpaProperties=new Properties();
 // private static final Jpa
  //private static final PersistenceProvider 

  @Bean(name="getDataSource")
  public static DataSource getDataSource() {
    DRIVER_MANAGER_DATA_SOURCE.setDriverClassName("com.mysql.jdbc.Driver");
    DRIVER_MANAGER_DATA_SOURCE.setUrl("jdbc:mysql://localhost:3306/test");
    DRIVER_MANAGER_DATA_SOURCE.setUsername("feescorner");
    DRIVER_MANAGER_DATA_SOURCE.setPassword("feescorner");
    return DRIVER_MANAGER_DATA_SOURCE;
  }

@Bean(name="getHibernateJpaVendorAdapter")
public static JpaVendorAdapter getHibernateJpaVendorAdapter() {
   // HIBERNATE_JPA_VENDOR_ADAPTER.setDatabase(Database.MYSQL);
   // HIBERNATE_JPA_VENDOR_ADAPTER.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
    HIBERNATE_JPA_VENDOR_ADAPTER.setShowSql(false);
    HIBERNATE_JPA_VENDOR_ADAPTER.setGenerateDdl(false);
    return HIBERNATE_JPA_VENDOR_ADAPTER;
  }
@Bean(name="getHibernateJpaDialect")
public static HibernateJpaDialect  getHibernateJpaDialect(){
   return HIBERNATE_JPA_DIALECT;
 }

public static Properties jpaProperties(){
  jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
  jpaProperties.put("hibernate.hbm2ddl.auto", "update");
  return jpaProperties;
  
  
}
 @SuppressWarnings("deprecation")
@Bean(name="getcontainerEntityManagerFactoryBean")
 public static LocalContainerEntityManagerFactoryBean getcontainerEntityManagerFactoryBean(){
   try{
   LOCAL_CONTAINER_ENTITY_MANAGER_FACTORY_BEAN.setDataSource(getDataSource());
   LOCAL_CONTAINER_ENTITY_MANAGER_FACTORY_BEAN.setPersistenceProviderClass(HibernatePersistence.class);
   LOCAL_CONTAINER_ENTITY_MANAGER_FACTORY_BEAN.setJpaVendorAdapter(getHibernateJpaVendorAdapter());
   LOCAL_CONTAINER_ENTITY_MANAGER_FACTORY_BEAN.setPackagesToScan("com.feescorner.masterdata.test.model");
   LOCAL_CONTAINER_ENTITY_MANAGER_FACTORY_BEAN.setJpaProperties(jpaProperties());
 //  LOCAL_CONTAINER_ENTITY_MANAGER_FACTORY_BEAN.setPersistenceProviderClass(org.hibernate.ejb.HibernatePersistence.class);
  // LOCAL_CONTAINER_ENTITY_MANAGER_FACTORY_BEAN.setPackagesToScan("com.feescorner.masterdata.test.model");
  // LOCAL_CONTAINER_ENTITY_MANAGER_FACTORY_BEAN.setMappingResources("com.feescorner.masterdata.test.model");
  // LOCAL_CONTAINER_ENTITY_MANAGER_FACTORY_BEAN.setJpaProperties(jpaProperties)
  // LOCAL_CONTAINER_ENTITY_MANAGER_FACTORY_BEAN.setPersistenceUnitName(SysConstants.SysConfigPU);
   LOCAL_CONTAINER_ENTITY_MANAGER_FACTORY_BEAN.getObject();
   }
   catch(NoSuchMethodError error){
     
     error.printStackTrace();
   }
   return LOCAL_CONTAINER_ENTITY_MANAGER_FACTORY_BEAN;
 }
 
 
 @Bean(name="getJpaTransactionManager")
 public static PlatformTransactionManager getJpaTransactionManager(){
   EntityManagerFactory factory =getcontainerEntityManagerFactoryBean().getObject();
   return new JpaTransactionManager(factory);
  /* JPA_TRANSACTION_MANAGER.setDataSource(getDataSource());
   JPA_TRANSACTION_MANAGER.setEntityManagerFactory(getcontainerEntityManagerFactoryBean().getObject()); 
   return JPA_TRANSACTION_MANAGER;*/
 
}

  @Bean
  public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
    
    System.out.println("**************************"+initDatabase);
    DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
    dataSourceInitializer.setDataSource(dataSource);
    ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
   // databasePopulator.addScript(new ClassPathResource("db.sql"));
    dataSourceInitializer.setDatabasePopulator(databasePopulator);
    dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));
    return dataSourceInitializer;
  } 
  
  
}
