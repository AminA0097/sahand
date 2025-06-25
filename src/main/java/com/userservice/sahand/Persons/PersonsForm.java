package com.userservice.sahand.Persons;

import com.userservice.sahand.Bases.BasesForm;

public class PersonsForm extends BasesForm {
    private Long personId;
    private String firstName;
    private String lastName;
    private String companyName;

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
