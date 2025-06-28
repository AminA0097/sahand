package com.userservice.sahand.Persons;

import com.userservice.sahand.Bases.BasesEntity;
import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

@Entity
@Table(name = "CORE_PERSONS")
@TableGenerator(
        name = "CORE_PERSON_SEQ",
        table = "CORE_SEQ",
        pkColumnName = "TABLE_NAME",
        valueColumnName = "SEQ_COUNT",
        pkColumnValue = "PersonsEntitySeq",
        allocationSize = 1
)
public class PersonsEntity extends BasesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "CORE_PERSON_SEQ")
    @Column(name = "FLD_PERSON_ID")
    private Long personId;

    @Column(name = "FLD_PERSON_NAME")
    private String firstName;

    @Column(name = "FLD_PERSON_FAMILY")
    private String lastName;

    @Column(name = "FLD_COMPANY_NAME")
    private String companyName;

    @Column(name = "FLD_NATIONAL_NUMBER")
    private String nationalNumber;

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
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

    @Override
    public Long getId(){
        return this.personId;
    }
}
