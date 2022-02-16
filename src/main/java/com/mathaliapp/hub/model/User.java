package com.mathaliapp.hub.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String imageUrl;
    @Column(nullable = false,updatable = false)
    private String userIdent;
    /**
     * Liste des rôles possédés par l'utilisateur
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "authority",
            joinColumns = @JoinColumn(name = "fk_userIdent"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_role")
    )
    private Set<Role> roles;

    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUserIdent() {
        return userIdent;
    }

    public void setUserIdent(String userIdent) {
        this.userIdent = userIdent;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' + ", imageUrl='" + imageUrl + '\'' + ", userIdent='" + userIdent + '\'' + ", roles=" + roles + '}';
    }
}
