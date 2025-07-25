package com.userservice.sahand.Documents;


import com.userservice.sahand.Bases.BasesEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "CORE_DOC")
@TableGenerator(
        name = "CORE_DOC_SEQ",
        table = "CORE_SEQ",
        pkColumnName = "TABLE_NAME",
        valueColumnName = "SEQ_COUNT",
        pkColumnValue = "DocumentsEntitySeq",
        allocationSize = 1
)
public class DocumentsEntity extends BasesEntity {
    @Id
    @Column(name = "FLD_DOC_ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CORE_DOC_SEQ")
    private Long documentId;

    @Override
    public Long getId() {
        return this.documentId;
    }
}
