package com.userservice.sahand.CoreCombo;

import com.userservice.sahand.Bases.BasesEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "CORE_ROLES")
@TableGenerator(
        name = "CORE_CORE_COMBO_SEQ",
        table = "CORE_SEQ",
        pkColumnName = "TABLE_NAME",
        valueColumnName = "SEQ_COUNT",
        pkColumnValue = "CoreComboEntitySeq",
        allocationSize = 1
)
public class CoreComboEntity extends BasesEntity {
    @Id
    @Column(name = "FLD_CORE_COMBO_ID")
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "CORE_CORE_COMBO_SEQ")
    private long coreComboId;

    @Column(name = "FLD_CORE_COMBO_NAME")
    private String coreComboName;

    public long getCoreComboId() {
        return coreComboId;
    }

    public void setCoreComboId(long coreComboId) {
        this.coreComboId = coreComboId;
    }

    public String getCoreComboName() {
        return coreComboName;
    }

    public void setCoreComboName(String coreComboName) {
        this.coreComboName = coreComboName;
    }

    @Override
    public Long getId() {
        return this.coreComboId;
    }
}
