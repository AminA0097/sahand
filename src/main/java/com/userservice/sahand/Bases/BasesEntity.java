package com.userservice.sahand.Bases;

import com.userservice.sahand.Utils.IsBoolean;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public abstract class BasesEntity {
    @Column(name = "FLD_CREATED_BY")
    private String createdBy;

    @Column(name = "FLD_UPDATED_BY")
    private String updatedBy;

    @Column(name = "FLD_DELETED")
    @IsBoolean()
    private boolean deleted;

    @Column(name = "FLD_CREATED_DATE")
    private Date createdData;

    @Column(name = "FLD_UPDATED_DATE")
    private Date updatedData;

    @Column(name = "FLD_DELETED_DATE")
    private Date deletedData;

    @Column(name = "FLD_ENABLED")
    @IsBoolean()
    private boolean enabled;

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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public abstract Long getId();
}