package com.userservice.sahand.Persons;

import com.userservice.sahand.Bases.BasesForm;
import com.userservice.sahand.Utils.WhatFiled;

public class PersonsForm extends BasesForm {


    private String nationalNumber;

    @WhatFiled
    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    private Long personId;

    @WhatFiled(type = WhatFiled.whatTypes.Long)
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    private String firstName;

    @WhatFiled()
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;

    @WhatFiled()
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String companyName;

    @WhatFiled()
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public Long getId() {
        return this.personId;
    }
}
