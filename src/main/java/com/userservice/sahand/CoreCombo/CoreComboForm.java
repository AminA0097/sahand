package com.userservice.sahand.CoreCombo;

import com.userservice.sahand.Bases.BasesForm;

public class CoreComboForm extends BasesForm {
    private Long coreComboId;
    private String coreComboName;
    private String coreComboTitle;
    public Long getCoreComboId() {
        return coreComboId;
    }
    public void setCoreComboId(Long coreComboId) {
        this.coreComboId = coreComboId;
    }

    public String getCoreComboName() {
        return coreComboName;
    }

    public void setCoreComboName(String coreComboName) {
        this.coreComboName = coreComboName;
    }

    public String getCoreComboTitle() {
        return coreComboTitle;
    }

    public void setCoreComboTitle(String coreComboTitle) {
        this.coreComboTitle = coreComboTitle;
    }

    @Override
    public Long getId() {
        return this.coreComboId;
    }
}
