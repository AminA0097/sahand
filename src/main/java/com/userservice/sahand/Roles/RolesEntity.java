package com.userservice.sahand.Roles;

import com.userservice.sahand.Bases.BasesEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "CORE_ROLES")
@TableGenerator(
        name = "CORE_ROLE_SEQ",
        table = "CORE_SEQ",
        pkColumnName = "TABLE_NAME",
        valueColumnName = "SEQ_COUNT",
        pkColumnValue = "PersonsEntitySeq",
        allocationSize = 1
)
public class RolesEntity extends BasesEntity {
    @Id
    @Column(name = "FLD_ROLE_ID")
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "CORE_ROLE_SEQ")
    private long roleId;

    @Column(name = "ROLE_NAME")
    private String roleName;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public Long getId() {
        return this.roleId;
    }
}
