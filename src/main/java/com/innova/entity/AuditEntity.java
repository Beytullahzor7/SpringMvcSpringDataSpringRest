package com.innova.entity;

import com.innova.audit.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//entity
@Entity
@Table(name="audit")
public class AuditEntity extends BaseEntity implements Serializable {

    @Column(name = "audit_name")
    private String auditName;
}