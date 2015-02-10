/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Dec 30, 2014                        TODO

 */
package com.solutiontag.entity.masterdata;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Table(name="payrolldefinition")
public class SchoolStafPayRollDefinition implements Serializable {
  /**
   * 
   */
  
  private static final long serialVersionUID = 1L;
  public SchoolStafPayRollDefinition(){
    this.hashSetIndexId=hashCode();
    this.categoryId=hashCode();
  }

  @Id
  @Column(name="category_id")
  private Integer categoryId;
  
  @Column(name="hashSetIndexId")
  private Integer hashSetIndexId;
  
  @ManyToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="masterdata_id")
  private SchoolMasterDataDefinition defForStaffPays;
  
  @Column(name="category_name")
  private String categoryName;
  
 /* Grade pay is a new term in 6th pay commission
  * Grade pay is given in  a hierarchical order.
  * Grade pay remains fixed until the next promotion,
  * basic pay changes with time(annually).*/
  @Column(name="grade_pay")
  private Double  gradePay;
  
 /* Basic pay is the minimum remuneration given to the employee.
  * It changes from time to time,various perks such as 
  * DA ,TPT,HRA.are calculated from basic pay.*/
  @Column(name="basic_pay")
  private Double  basicPay;
  
  /* ********************DEDUCTION PART**************************/
  
  /*ESI will be calculate on Gross Salary upto 10000/- & PF will
  be calculate on Basic Salary upto 6500/- */
  
  @Column(name="provident_fund")
  private Double  providentFund;
  
  @Column(name="income_tax")
  private Double  incomeTax;
 /*DEDUCTION PART */
  @Column(name="permission_per_month")
  private int permissionPerMonth;
  
  @Column(name="casual_leave_per_year")
  private int casualLeavePerYear;
  
  @Column(name="medical_leave_per_year")
  private int medicalLeavePerYear;
  
  @Column(name="handicaped_allowance")
  private int handicapedAllowance;

  /**
   * @return the categoryId
   */
  public Integer getCategoryId() {
    return categoryId;
  }

  /**
   * @param categoryId the categoryId to set
   */
  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }
  /**
   * @return the categoryName
   */
  public String getCategoryName() {
    return categoryName;
  }

  /**
   * @param categoryName the categoryName to set
   */
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  /**
   * @return the gradePay
   */
  public Double getGradePay() {
    return gradePay;
  }

  /**
   * @param gradePay the gradePay to set
   */
  public void setGradePay(Double gradePay) {
    this.gradePay = gradePay;
  }

  /**
   * @return the basicPay
   */
  public Double getBasicPay() {
    return basicPay;
  }

  /**
   * @param basicPay the basicPay to set
   */
  public void setBasicPay(Double basicPay) {
    this.basicPay = basicPay;
  }

  /**
   * @return the providentFund
   */
  public Double getProvidentFund() {
    return providentFund;
  }

  /**
   * @param providentFund the providentFund to set
   */
  public void setProvidentFund(Double providentFund) {
    this.providentFund = providentFund;
  }

  /**
   * @return the incomeTax
   */
  public Double getIncomeTax() {
    return incomeTax;
  }

  /**
   * @param incomeTax the incomeTax to set
   */
  public void setIncomeTax(Double incomeTax) {
    this.incomeTax = incomeTax;
  }

  /**
   * @return the permissionPerMonth
   */
  public int getPermissionPerMonth() {
    return permissionPerMonth;
  }

  /**
   * @param permissionPerMonth the permissionPerMonth to set
   */
  public void setPermissionPerMonth(int permissionPerMonth) {
    this.permissionPerMonth = permissionPerMonth;
  }

  /**
   * @return the casualLeavePerYear
   */
  public int getCasualLeavePerYear() {
    return casualLeavePerYear;
  }

  /**
   * @param casualLeavePerYear the casualLeavePerYear to set
   */
  public void setCasualLeavePerYear(int casualLeavePerYear) {
    this.casualLeavePerYear = casualLeavePerYear;
  }

  /**
   * @return the medicalLeavePerYear
   */
  public int getMedicalLeavePerYear() {
    return medicalLeavePerYear;
  }

  /**
   * @param medicalLeavePerYear the medicalLeavePerYear to set
   */
  public void setMedicalLeavePerYear(int medicalLeavePerYear) {
    this.medicalLeavePerYear = medicalLeavePerYear;
  }

  /**
   * @return the handicapedAllowance
   */
  public int getHandicapedAllowance() {
    return handicapedAllowance;
  }

  /**
   * @param handicapedAllowance the handicapedAllowance to set
   */
  public void setHandicapedAllowance(int handicapedAllowance) {
    this.handicapedAllowance = handicapedAllowance;
  }

  /**
   * @return the defForStaffPays
   */
  public SchoolMasterDataDefinition getDefForStaffPays() {
    return defForStaffPays;
  }

  /**
   * @param defForStaffPays the defForStaffPays to set
   */
  public void setDefForStaffPays(SchoolMasterDataDefinition defForStaffPays) {
    this.defForStaffPays = defForStaffPays;
  }

  /**
   * @return the hashSetIndexId
   */
  public Integer getHashSetIndexId() {
    return hashSetIndexId;
  }

  /**
   * @param hashSetIndexId the hashSetIndexId to set
   */
  public void setHashSetIndexId(Integer hashSetIndexId) {
    this.hashSetIndexId = hashSetIndexId;
  }

  @Override
  public boolean equals(Object obj){
    SchoolStafPayRollDefinition schoolStafPayRollDefinition=(SchoolStafPayRollDefinition) obj;
    return getHashSetIndexId()==schoolStafPayRollDefinition.getHashSetIndexId();
  }
   
}
