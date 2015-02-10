/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 2, 2015                        TODO

 */
package com.solutiontag.entity.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Table(name="Dept")
public class Department {
    @Id 
    @GeneratedValue(generator="dept_Generator")
    @GenericGenerator(name="dept_Generator", strategy = "com.feescorner.serverstartup.dbUtils.ApplicationUtills")
    private int id;
 
    private String name;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String deptName) {
        this.name = deptName;
    }

    public String toString() {
        return "Department id: " + getId() + 
               ", name: " + getName();
    }

}
