package com.userservice.sahand.Users;

import com.userservice.sahand.Bases.BasesForm;

public class UsersForm extends BasesForm {
    private Long userId;
    @Override
    public Long getId() {
        return this.userId;
    }
}
