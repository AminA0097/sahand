package com.userservice.sahand.CoreCombo;

import com.userservice.sahand.Bases.BasesEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CORE_ROLES")
public class CoreComboEntity extends BasesEntity {
    @Id
    @Column(name = "FLD_CORE_COMBO_ID")
    private long coreComboId;

    @Column(name = "FLD_CORE_COMBO_NAME")
    private String coreComboName;


}
