package com.userservice.sahand.Bases;

import java.util.Date;

public class BasesForm {
    private String createdBy;
    private String updatedBy;
    private Boolean deleted;
    private Date createdData;
    private Date updatedData;
    private Date deletedData;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreatedData() {
        return createdData;
    }

    public void setCreatedData(Date createdData) {
        this.createdData = createdData;
    }

    public Date getUpdatedData() {
        return updatedData;
    }

    public void setUpdatedData(Date updatedData) {
        this.updatedData = updatedData;
    }

    public Date getDeletedData() {
        return deletedData;
    }

    public void setDeletedData(Date deletedData) {
        this.deletedData = deletedData;
    }
}
