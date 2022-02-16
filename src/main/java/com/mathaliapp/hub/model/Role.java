package com.mathaliapp.hub.model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private Long id;

    @NotNull(message = "Role name cannot be null")
    @Column(name = "libelle", nullable = false, length = 30)
    private String libelle;

    public Role(String libelle) {
        this.libelle = libelle;
    }

    public Role() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
