/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 20, 2014                        TODO

 */
package com.feescorner.serverstartup.dbUtils;




public class CopyOfHibernatePropertyPlaceHolderConfigurer {
  private String connectionDriverClass;
  private String dialect;
  private String connectionUrl;
  private String connectionUserName;
  private String connectionPassword;
  private String connectionPoolSize;

  /**
   * @return the connectionDriverClass
   */
  public String getConnectionDriverClass() {
    return connectionDriverClass;
  }

  /**
   * @param connectionDriverClass the connectionDriverClass to set
   */
  public void setConnectionDriverClass(String connectionDriverClass) {
    this.connectionDriverClass = connectionDriverClass;
  }

  /**
   * @return the dialect
   */
  public String getDialect() {
    return dialect;
  }

  /**
   * @param dialect the dialect to set
   */
  public void setDialect(String dialect) {
    this.dialect = dialect;
  }

  /**
   * @return the connectionUrl
   */
  public String getConnectionUrl() {
    return connectionUrl;
  }

  /**
   * @param connectionUrl the connectionUrl to set
   */
  public void setConnectionUrl(String connectionUrl) {
    this.connectionUrl = connectionUrl;
  }

  /**
   * @return the connectionUserName
   */
  public String getConnectionUserName() {
    return connectionUserName;
  }

  /**
   * @param connectionUserName the connectionUserName to set
   */
  public void setConnectionUserName(String connectionUserName) {
    this.connectionUserName = connectionUserName;
  }

  /**
   * @return the connectionPassword
   */
  public String getConnectionPassword() {
    return connectionPassword;
  }

  /**
   * @param connectionPassword the connectionPassword to set
   */
  public void setConnectionPassword(String connectionPassword) {
    this.connectionPassword = connectionPassword;
  }

  /**
   * @return the connectionPoolSize
   */
  public String getConnectionPoolSize() {
    return connectionPoolSize;
  }

  /**
   * @param connectionPoolSize the connectionPoolSize to set
   */
  public void setConnectionPoolSize(String connectionPoolSize) {
    this.connectionPoolSize = connectionPoolSize;
  }
}
