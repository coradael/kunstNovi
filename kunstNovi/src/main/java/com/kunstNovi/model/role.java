package com.kunstNovi.model;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;

@Entity
@Table(name = "roles")
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private roleName name;

    public role() {

    }

    public role(roleName name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public roleName getName() {
        return name;
    }

    public void setName(roleName name) {
        this.name = name;
    }
}