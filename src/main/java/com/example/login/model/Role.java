package com.example.login.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_role")
@Data
public class Role {
    @Id
    private Long id;
    private String name;
}
