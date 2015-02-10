/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 2, 2015                        TODO

 */
package com.solutiontag.entity.test;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Table(name="student")
public class Student {
  @Id
  @GenericGenerator(name="student_generator", strategy = "com.feescorner.serverstartup.dbUtils.ApplicationUtills")
  @GeneratedValue(generator="student_generator")
  @Column(name="studentId")
  private int studentId;
  
  private String name;

  @OneToOne (cascade=CascadeType.ALL)
  @JoinColumn(unique= true, nullable=true, insertable=true, updatable=true)
  private Department department;

  public int getId() {
    return studentId;
  }

  public void setId(int studentId) {
    this.studentId = studentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public String toString() {
    return "\n\nID:" + studentId + "\nName:" + name + "\n\n" + department;
  }
}