/**
 * 
CODED BY      CODED DATE      VERSION        MADE_CHANGES 
Aniruthan       Jan 2, 2015                        TODO

 */
package com.solutiontag.entity.test;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.cache.annotation.Cacheable;
@Entity
@Cacheable
@Table(name="persons")
public class Persons implements Serializable {
        /**
   * 
   */
  private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "personId", unique = true, nullable = false)
        private Long personId;
     
        @Column(name = "NAME")
        private String name;
     
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "persons")
        private Set<Phone> personPhoneNumbers = new HashSet<Phone>();


        /**
         * @return the name
         */
        public String getName() {
          return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
          this.name = name;
        }

        /**
         * @return the personPhoneNumbers
         */
        public Set<Phone> getPersonPhoneNumbers() {
          return personPhoneNumbers;
        }

        /**
         * @param personPhoneNumbers the personPhoneNumbers to set
         */
        public void setPersonPhoneNumbers(Set<Phone> personPhoneNumbers) {
          this.personPhoneNumbers = personPhoneNumbers;
        }

        /**
         * @return the personId
         */
        public Long getPersonId() {
          return personId;
        }

        /**
         * @param personId the personId to set
         */
        public void setPersonId(Long personId) {
          this.personId = personId;
        }


}
