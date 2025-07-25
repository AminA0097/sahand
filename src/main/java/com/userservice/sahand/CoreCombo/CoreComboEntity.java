package com.userservice.sahand.CoreCombo;

import com.userservice.sahand.Bases.BasesEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "CORE_COMBO")
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
    private Long coreComboId;

    @Column(name = "FLD_CORE_COMBO_NAME")
    private String coreComboName;

    @Column(name = "FLD_CORE_COMBO_TITLE")
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
