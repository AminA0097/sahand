package com.userservice.sahand.Persons;

import com.userservice.sahand.Bases.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CORE_PERSONS")
public class PersonEntity extends BaseEntity {
    @Id
    @Column(name = "FLD_PERSON_ID")
    private long personId;

    @Column(name = "FLD_PERSON_NAME")
    private String firstName;

    @Column(name = "FLD_PERSON_FAMILY")
    private String lastName;

    @Column(name = "FLD_COMPANY_NAME")
    private String companyName;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
