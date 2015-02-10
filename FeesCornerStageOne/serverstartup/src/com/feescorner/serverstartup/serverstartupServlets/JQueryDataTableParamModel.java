/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 26, 2015                        TODO

 */
package com.feescorner.serverstartup.serverstartupServlets;


public class JQueryDataTableParamModel {
  JQueryDataTableParamModel(){
    
    this.iTotalDisplayRecords=5;
    this.iTotalRecords=5;
  }
       
  public String aoData ;

      
  public String sEcho ;


  public String sSearch ;

  
  public int iDisplayLength ;

 
  public int iDisplayStart ;


  public int iColumns ;


  public int iSortingCols ;

 
  public String sColumns ;


  public String oSearch ;
  
  private int iTotalRecords;
  
  private int iTotalDisplayRecords;

  /**
   * @return the sEcho
   */
  public String getsEcho() {
    return sEcho;
  }

  /**
   * @param sEcho the sEcho to set
   */
  public void setsEcho(String sEcho) {
    this.sEcho = sEcho;
  }

  /**
   * @return the sSearch
   */
  public String getsSearch() {
    return sSearch;
  }

  /**
   * @param sSearch the sSearch to set
   */
  public void setsSearch(String sSearch) {
    this.sSearch = sSearch;
  }

  /**
   * @return the iDisplayLength
   */
  public int getiDisplayLength() {
    return iDisplayLength;
  }

  /**
   * @param iDisplayLength the iDisplayLength to set
   */
  public void setiDisplayLength(int iDisplayLength) {
    this.iDisplayLength = iDisplayLength;
  }

  /**
   * @return the iDisplayStart
   */
  public int getiDisplayStart() {
    return iDisplayStart;
  }

  /**
   * @param iDisplayStart the iDisplayStart to set
   */
  public void setiDisplayStart(int iDisplayStart) {
    this.iDisplayStart = iDisplayStart;
  }

  /**
   * @return the iColumns
   */
  public int getiColumns() {
    return iColumns;
  }

  /**
   * @param iColumns the iColumns to set
   */
  public void setiColumns(int iColumns) {
    this.iColumns = iColumns;
  }

  /**
   * @return the iSortingCols
   */
  public int getiSortingCols() {
    return iSortingCols;
  }

  /**
   * @param iSortingCols the iSortingCols to set
   */
  public void setiSortingCols(int iSortingCols) {
    this.iSortingCols = iSortingCols;
  }

  /**
   * @return the sColumns
   */
  public String getsColumns() {
    return sColumns;
  }

  /**
   * @param sColumns the sColumns to set
   */
  public void setsColumns(String sColumns) {
    this.sColumns = sColumns;
  }

  /**
   * @return the oSearch
   */
  public String getoSearch() {
    return oSearch;
  }

  /**
   * @param oSearch the oSearch to set
   */
  public void setoSearch(String oSearch) {
    this.oSearch = oSearch;
  }

  /**
   * @return the iTotalRecords
   */
  public int getiTotalRecords() {
    return iTotalRecords;
  }

  /**
   * @param iTotalRecords the iTotalRecords to set
   */
  public void setiTotalRecords(int iTotalRecords) {
    this.iTotalRecords = iTotalRecords;
  }

  /**
   * @return the iTotalDisplayRecords
   */
  public int getiTotalDisplayRecords() {
    return iTotalDisplayRecords;
  }

  /**
   * @param iTotalDisplayRecords the iTotalDisplayRecords to set
   */
  public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
    this.iTotalDisplayRecords = iTotalDisplayRecords;
  }

  /**
   * @return the aoData
   */
  public String getAoData() {
    return aoData;
  }

  /**
   * @param aoData the aoData to set
   */
  public void setAoData(String aoData) {
    this.aoData = aoData;
  }

}
