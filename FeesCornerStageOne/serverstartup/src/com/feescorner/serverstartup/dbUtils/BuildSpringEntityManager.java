/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 21, 2014                        TODO

 */
package com.feescorner.serverstartup.dbUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.DataSourceConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.log4j.Logger;
import org.hibernate.cache.ehcache.EhCacheRegionFactory;
import org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.jdbc.Connection;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( basePackageClasses=com.feescorner.serverstartup.factoryrepository.DefaultRepositoryFactoryBean.class, considerNestedRepositories=true, queryLookupStrategy=Key.CREATE_IF_NOT_FOUND, entityManagerFactoryRef = "appEntityManagerFactory", 
transactionManagerRef = "appTransactionManager",basePackages = {"com.solutiontag.repository"})
public class BuildSpringEntityManager {
  public static final Logger logger=Logger.getLogger(BuildSpringEntityManager.class);
 @Autowired
  Environment env;
  private static final DriverManagerDataSource driverManagerDataSource =
      new DriverManagerDataSource();;
  private static final HibernateJpaVendorAdapter hibernateJpaVendorAdaptor =
      new HibernateJpaVendorAdapter();
  private static final HibernateJpaDialect hibernateJpaDilect = new HibernateJpaDialect();
  private static final LocalContainerEntityManagerFactoryBean appContainerManagerFactory=new LocalContainerEntityManagerFactoryBean();
  private static final Properties jpaProperties=new Properties();
  private static Connection connection=null;
  
  @Bean(name="getDataSource")
  public  static DataSource getDataSource() throws SQLException {
    driverManagerDataSource.setDriverClassName(ApplicationUtills.getDataBaseProperties.getProperty("hibernate.driverName"));
    driverManagerDataSource.setUrl(ApplicationUtills.getDataBaseProperties.getProperty("hibernate.connection.url"));
    driverManagerDataSource.setUsername(ApplicationUtills.getDataBaseProperties.getProperty("hibernate.connection.username"));
    driverManagerDataSource.setPassword(ApplicationUtills.getDataBaseProperties.getProperty("hibernate.connection.password"));
    try{
    connection=(Connection) driverManagerDataSource.getConnection();
    }catch(Exception ex){
      System.out.println("Connection Not Established.Start your database.");
      logger.info(ex, ex.fillInStackTrace());
      System.exit(0);
    }
    return driverManagerDataSource;
  }

@Bean(name="getHibernateJpaVendorAdapter")
public static JpaVendorAdapter getHibernateJpaVendorAdapter() {
    hibernateJpaVendorAdaptor.setShowSql(true);
    hibernateJpaVendorAdaptor.setGenerateDdl(true);
    hibernateJpaVendorAdaptor.setDatabase(Database.MYSQL);
    hibernateJpaVendorAdaptor.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
    return hibernateJpaVendorAdaptor;
  }
@Bean(name="getHibernateJpaDialect")
public static HibernateJpaDialect  getHibernateJpaDialect(){
   return hibernateJpaDilect;
 }

public static HashMap<String,String> getJpaPropertyMap(){
  HashMap<String, String> jpaPropertyMap=new HashMap<String,String>();
  jpaPropertyMap.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
  jpaPropertyMap.put("hibernate.cache.use_second_level_cache", "true");
  jpaPropertyMap.put("hibernate.cache.use_query_cache", "true");
  jpaPropertyMap.put("javax.persistence.sharedCache.mode", "ENABLE_SELECTIVE");
  
  return  jpaPropertyMap;
}

public static Properties jpaProperties(){
  jpaProperties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
  jpaProperties.put("hibernate.hbm2ddl.auto", "update");
  jpaProperties.put("hibernate.enable_lazy_load_no_trans", "true");
  jpaProperties.put("hibernate.ejb.naming_strategy", org.hibernate.cfg.ImprovedNamingStrategy.class.getName());
 
  /*jpaProperties.put("hibernate.format_sql", "true");
  jpaProperties.put("hibernate.show_sql", "true");*/
  return jpaProperties;
} 
 @Bean(name="appEntityManagerFactory")
 public static LocalContainerEntityManagerFactoryBean appEntityManagerFactory() throws SQLException{
   appContainerManagerFactory.setDataSource(new BuildSpringEntityManager().getDataSource());
   appContainerManagerFactory.setPersistenceProviderClass(HibernatePersistence.class);
   appContainerManagerFactory.setJpaVendorAdapter(getHibernateJpaVendorAdapter());
   appContainerManagerFactory.setPackagesToScan("com.solutiontag.entity");
   appContainerManagerFactory.setJpaProperties(jpaProperties());
   appContainerManagerFactory.setJpaPropertyMap(getJpaPropertyMap());
   return appContainerManagerFactory;
 }
 
 @Bean(name="appTransactionManager")
 public static PlatformTransactionManager appTransactionManager() throws SQLException{
   EntityManagerFactory factory =appEntityManagerFactory().getObject();
   return new JpaTransactionManager(factory);
}
 
 @Bean(name="getGenericObjectPool")
  public static GenericObjectPool getGenericObjectPool() throws SQLException{
   // GenericObjectPool GENERIC_OBJECT_POOL = null;
    GenericObjectPool GENERIC_OBJECT_POOL =new GenericObjectPool();
    GENERIC_OBJECT_POOL.setMaxActive(10);
    GENERIC_OBJECT_POOL.setMinEvictableIdleTimeMillis(300000);
    GENERIC_OBJECT_POOL.setTimeBetweenEvictionRunsMillis(60000);
   // GENERIC_OBJECT_POOL.setFactory(getPoolableConnectionFactory());
    return GENERIC_OBJECT_POOL;
    
  }
  @Bean(name="getDataSourceConnectionFactory")
  public static DataSourceConnectionFactory getDataSourceConnectionFactory() throws SQLException{
    DataSourceConnectionFactory DATA_SOURCE_CONNECTION_FACTORY;
    DATA_SOURCE_CONNECTION_FACTORY=new DataSourceConnectionFactory(new BuildSpringEntityManager().getDataSource());
    return DATA_SOURCE_CONNECTION_FACTORY;
  }
  @Bean(name="getPoolableConnectionFactory")
  public static PoolableConnectionFactory getPoolableConnectionFactory() throws SQLException{
    PoolableConnectionFactory poolableConnectionFactory;
    poolableConnectionFactory=new PoolableConnectionFactory(getDataSourceConnectionFactory(), getGenericObjectPool(), null, null, false, true);
    return poolableConnectionFactory;
  }
  @DependsOn("getPoolableConnectionFactory")
  public static PoolingDataSource getPoolingDataSource() throws SQLException{
    PoolingDataSource poolingDataSource=new PoolingDataSource(getGenericObjectPool());
    return poolingDataSource;
  }
  
  /* 
  @Bean(name="getPropertyPlaceHolderConfigurer")
   public static PropertySourcesPlaceholderConfigurer getPropertyplaceholderConfigurer(){
     propertySourcePlaceHolder=new PropertySourcesPlaceholderConfigurer();
     Resource resource=new FileSystemResource(new File("E:/Fees_corner_confguration/dbpropertiesfiles/database.properties"));
     propertySourcePlaceHolder.setLocation(resource);
     propertySourcePlaceHolder.setIgnoreUnresolvablePlaceholders(true);
     propertySourcePlaceHolder.setEnvironment(env);
     return propertySourcePlaceHolder;
   }*/
}
